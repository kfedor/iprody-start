package lesson23;

import lesson23.annotations.AfterSuite;
import lesson23.annotations.BeforeSuite;
import lesson23.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        TestClass aClass = new TestClass();
        Class<? extends TestClass> tClass = aClass.getClass();
        TestRunner.start(tClass);
    }

    static class TestRunner {

        static <T> void start(Class<T> tClass) {

            Method[] methods = tClass.getDeclaredMethods();
            startMethodWithAnnotation(methods, BeforeSuite.class);
            startTestMethods(methods, tClass);
            startMethodWithAnnotation(methods, AfterSuite.class);

        }

        static void startMethodWithAnnotation(Method[] methods, Class<? extends Annotation> annotation) {
            annotationValidator(methods, annotation);
            for (Method method : methods) {
                if (method.isAnnotationPresent(annotation)) {
                    try {
                        Object instance = method.getDeclaringClass().getDeclaredConstructor().newInstance();
                        method.invoke(instance);
                    } catch (IllegalAccessException | InvocationTargetException | InstantiationException |
                             NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        static void annotationValidator(Method[] methods, Class<? extends Annotation> annotation) {
            int count = 0;
            for (Method method : methods) {
                if (method.isAnnotationPresent(annotation)) {
                    count++;
                    if (count > 1) {
                        throw new RuntimeException(STR."Annotation \{annotation.getName()}could be used only for one time.");
                    }
                }
            }
        }

        static <T> void startTestMethods(Method[] methods, Class<T> tClass) {
            List<Method> testMethodsList = new ArrayList<>();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    testMethodsList.add(method);
                }
            }
            testMethodsList.stream()
                    .sorted(Comparator.comparingInt(o -> o.getAnnotation(Test.class).order()))
                    .forEach(method -> {
                        try {
                            Object instance = method.getDeclaringClass().getDeclaredConstructor().newInstance();
                            method.invoke(instance);
                        } catch (IllegalAccessException | InvocationTargetException | InstantiationException |
                                 NoSuchMethodException e) {
                            throw new RuntimeException(e);
                        }
                    });

            testMethodsList.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).order()));
        }
    }
}

