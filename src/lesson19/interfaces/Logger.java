package lesson19.interfaces;

/**
 * Logger is an entity that records in the form of logs what is happening in the program.
 */
public interface Logger {

    /**
     * Method records the logged action according to the logging configuration on level debug.
     *
     * @param str the incoming argument
     */
    void debug(String str);

    /**
     * Method records the logged action according to the logging configuration on level info.
     *
     * @param str the incoming argument
     */
    void info(String str);

}
