package lesson19.config;

import lesson19.enums.LoggingLevel;
import lesson19.interfaces.LoggerConfiguration;

import java.io.File;
import java.nio.file.Path;
import java.time.LocalDateTime;

/**
 * Defines the format and configuration of the log file.
 */
public class FileLoggerConfiguration implements LoggerConfiguration {

    /**
     * Default pattern to write log to file.
     */
    private static final String DEFAULT_PATTERN = "[%s][%s] Message: [%s]";

    /**
     * Default size of file created based on this configuration.
     */
    private static final int DEFAULT_SIZE = 1024;

    /**
     * Representation of a file for logs.
     */
    private File file = Path.of("src/lesson19/logs", STR."Log_\{LocalDateTime.now()}.log").toFile();

    /**
     * Activated logging level.
     */
    private final LoggingLevel level;

    /**
     * Activated logging pattern.
     */
    private final String pattern;

    /**
     * Size of file created based on this configuration.
     */
    private final int size;

    /**
     * Creates a configuration for file logger.
     *
     * @param level   of logging
     * @param pattern of logging record
     * @param size    of the file for logging
     */
    public FileLoggerConfiguration(LoggingLevel level, String pattern, int size) {
        this.level = level;
        this.pattern = pattern;
        this.size = size;
    }

    /**
     * Creates a configuration for file logger based on default values.
     *
     * @param level of logging.
     */
    public FileLoggerConfiguration(LoggingLevel level) {
        this(level, DEFAULT_PATTERN, DEFAULT_SIZE);
    }

    @Override
    public LoggingLevel level() {
        return level;
    }

    @Override
    public String pattern() {
        return pattern;
    }

    /**
     * Method returns current file to write logs.
     *
     * @return file to write logs.
     */
    public File getFile() {
        return file;
    }

    /**
     * Method allows to set new file to write logs.
     *
     * @param file to write logs.
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Method returns size of the file based on this configuration.
     *
     * @return int value of size
     */
    public int getSize() {
        return size;
    }
}
