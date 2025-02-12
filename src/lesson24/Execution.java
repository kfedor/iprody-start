package lesson24;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Class representing execution scenario of a particular testing class.
 */
public record Execution(
        Class<?> testingClass,
        List<ExecutionItem<?>> executions,
        LocalDateTime startedAt,
        LocalDateTime executedAt
) {
}
