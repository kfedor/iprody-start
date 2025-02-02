package lesson19.enums;

/**
 * This enum defines logging levels.
 */
public enum LoggingLevel {

    INFO(0),
    DEBUG(1);

    /**
     * The weight of logging levels.
     */
    private final int weight;

    /**
     * Assigns weight value to enum fields.
     * @param weight of logging level
     */
    LoggingLevel(int weight) {
        this.weight = weight;
    }

    /**
     * Method returns the weight of logging level.
     */
    public int weight() {
        return weight;
    }
}
