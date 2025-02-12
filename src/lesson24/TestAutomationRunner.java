package lesson24;

import lesson24.annotations.AfterSuite;
import lesson24.annotations.BeforeSuite;
import lesson24.annotations.Test;
import lesson24.exceptions.AssertException;
import lesson24.exceptions.InvalidSignatureException;
import lesson24.interfaces.Printer;
import lesson24.interfaces.Runner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * The class performs method testing.
 */
public class TestAutomationRunner implements Runner {

    private final List<Class<?>> testClasses;

    private final Printer printer;

    public TestAutomationRunner(List<Class<?>> testClasses, Printer printer) {
        this.testClasses = testClasses;
        this.printer = printer;
    }

    @Override
    public void run() {

        List<Execution> executions = new ArrayList<>();

        for (Class<?> testClass : testClasses) {
            List<Method> beforeSuiteMethods = new ArrayList<>();
            List<Method> testMethods = new ArrayList<>();
            List<Method> afterSuiteMethods = new ArrayList<>();

            Arrays.stream(testClass.getDeclaredMethods()).forEach(m -> {
                if (m.isAnnotationPresent(BeforeSuite.class)) beforeSuiteMethods.add(m);
                if (m.isAnnotationPresent(Test.class)) testMethods.add(m);
                if (m.isAnnotationPresent(AfterSuite.class)) afterSuiteMethods.add(m);
            });

            checkMethodSignature(beforeSuiteMethods, testClass, BeforeSuite.class);
            checkMethodSignature(afterSuiteMethods, testClass, AfterSuite.class);

            Object testingInstance = getInstance(testClass);

            Execution execution = new Execution(
                    testClass,
                    executeTestMethods(testMethods, testingInstance),
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );

            executions.add(execution);
        }

        printTestResults(executions);
    }

    /**
     * Method creates and returns testing class instance.
     *
     * @param testClass type of test class needed instance
     * @return tesing class instance.
     */
    private Object getInstance(Class<?> testClass) {
        Object testingInstance = null;
        try {
            testingInstance = testClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return testingInstance;
    }

    /**
     * Method sets defined printer and invokes method for printing test results.
     *
     * @param executions list of execution which contains test results data.
     */
    private void printTestResults(List<Execution> executions) {
        try {
            Method setExecutions = printer.getClass().getDeclaredMethod("setExecutions", List.class);
            setExecutions.invoke(printer, executions);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        printer.write();
    }

    /**
     * Method execute methods for test and returns a collection with ExecutionItems which reflects results of tests.
     *
     * @param testMethods     method with annotation @Test which is target for testing.
     * @param testingInstance an instance of the class for testing
     * @return list with ExecutionItems
     */
    private List<ExecutionItem<?>> executeTestMethods(List<Method> testMethods, Object testingInstance) {
        List<ExecutionItem<?>> executionItems = new ArrayList<>();

        testMethods.stream()
                .sorted(Comparator.comparingInt(o -> o.getAnnotation(lesson23.annotations.Test.class).order()))
                .forEach(method -> {
                    try {
                        method.invoke(testingInstance);
                    } catch (InvocationTargetException e) {
                        Throwable cause = e.getCause();
                        if (cause instanceof AssertException assertException) {
                            executionItems.add(new ExecutionItem<>(
                                    testingInstance.getClass(),
                                    method,
                                    assertException.getResult().success(),
                                    assertException.getResult().expectedResult(),
                                    assertException.getResult().actualResult()
                            ));
                        } else {
                            throw new RuntimeException("Unexpected exception", e);
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });
        return executionItems;
    }

    /**
     * Method checks if more than one method has defined annotation.
     *
     * @param methodList   list with methods to check
     * @param testingClass class which is testing
     * @param annotation   that should be used for one method only.
     */
    private void checkMethodSignature(List<Method> methodList, Class<?> testingClass, Class<?> annotation) {
        if (methodList.size() > 1) {
            throw new InvalidSignatureException(
                    STR."Class\{testingClass} must not have more than one annotation\{annotation}");
        }
    }

}
