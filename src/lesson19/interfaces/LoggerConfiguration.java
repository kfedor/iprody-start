package lesson19.interfaces;

import lesson19.enums.LoggingLevel;

/**
 * Defines the format and configuration of the log entry.
 */
public interface LoggerConfiguration {

    /**
     * The method returns the activated logging level.
     *
     * @return logging level
     */
    LoggingLevel level();

    /**
     * The method returns the activated logging format (pattern).
     *
     * @return logging pattern
     */
    String pattern();
}
