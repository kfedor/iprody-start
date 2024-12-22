package lesson12.exceptions;

public class ArrayDataException extends NumberFormatException {

    public ArrayDataException() {
        super();
    }

    public ArrayDataException(String s) {
        super(s);
    }
}
