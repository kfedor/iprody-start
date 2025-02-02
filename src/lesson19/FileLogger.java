package lesson19;

import lesson19.config.FileLoggerConfiguration;
import lesson19.enums.LoggingLevel;
import lesson19.interfaces.Logger;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;

/**
 * An entity that records to file in the form of logs what is happening in the program.
 */
public class FileLogger implements Logger {

    /**
     * Configuration which is necessary to build file logger.
     */
    private final FileLoggerConfiguration configuration;

    /**
     * Creates a file logger based on specified configuration.
     *
     * @param configuration to build file logger
     */
    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void debug(String str) {
        if (configuration.level().weight() >= LoggingLevel.DEBUG.weight()) {
            write(str, LoggingLevel.DEBUG);
        }
    }

    @Override
    public void info(String str) {
        if (configuration.level().weight() >= LoggingLevel.INFO.weight()) {
            write(str, LoggingLevel.INFO);
        }
    }

    /**
     * Method writes the string to log file with defined logging level.
     *
     * @param str   original which should be formatted and written to log file.
     * @param level of logging
     */
    private void write(String str, LoggingLevel level) {
        String formatted = prepareMessage(str, level);
        if (!fileSizeChecking(formatted)) {
            configuration.setFile(Path.of("logs", STR."Log_\{LocalDateTime.now()}.log").toFile());
        }
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream(configuration.getFile(), true))) {

            bufferedOutputStream.write(formatted.getBytes());
            bufferedOutputStream.write("\n".getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method prepares message which will be written to log file based on pattern.
     *
     * @param str   original which should be formatted and then logged.
     * @param level of logging
     * @return formatted message that will be then written to file as a log.
     */
    private String prepareMessage(String str, LoggingLevel level) {
        return configuration.pattern().formatted(LocalDateTime.now(), level, str);
    }

    /**
     * Method checks if the file have enough capacity to write formatted string as log.
     *
     * @param str formatted to write to log file.
     * @return true or false whether param string can be written to file.
     */
    private boolean fileSizeChecking(String str) {
        return (configuration.getSize() - configuration.getFile().length()) >= str.length();
    }
}

