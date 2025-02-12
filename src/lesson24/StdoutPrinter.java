package lesson24;

import lesson24.interfaces.Printer;

import java.util.List;

/**
 * Class prints results of testing methods to console with defined template.
 */
public class StdoutPrinter implements Printer {

    private List<Execution> executions;

    private String template =
            """
                    Testing class [%s]
                    Testing method [%s]
                    Passed [%s]""";

    @Override
    public void write() {
        for (Execution execution : executions) {
            List<ExecutionItem<?>> executionItems = execution.executions();
            for (ExecutionItem<?> executionItem : executionItems) {
                System.out.println(String.format(
                        template,
                        executionItem.testingClass(),
                        executionItem.testingMethod(),
                        executionItem.result()));
            }
        }
    }

    public void setExecutions(List<Execution> executions) {
        this.executions = executions;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
