package lesson24;

import lesson24.interfaces.Printer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
/**
 * Class prints results of testing methods to file under defined path with defined template.
 */
public class FilePrinter implements Printer {

    private List<Execution> executions;

    private String template =
            """
                    Testing class [%s]
                    Testing method [%s]
                    Passed [%s]""";

    private Path target = Path.of("/test", "/testResultFile");

    @Override
    public void write() {
        for (Execution execution : executions) {
            List<ExecutionItem<?>> executionItems = execution.executions();
            for (ExecutionItem<?> executionItem : executionItems) {
                try {
                    Files.writeString(target,
                            (String.format(
                                    template,
                                    executionItem.testingClass(),
                                    executionItem.testingMethod(),
                                    executionItem.result())));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public void setExecutions(List<Execution> executions) {
        this.executions = executions;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public void setTarget(Path target) {
        this.target = target;
    }
}
