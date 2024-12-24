package lesson11.task1.interfaces.figures;

import lesson11.task1.interfaces.Figure;

public class Square implements Figure {

    private final double side;

    public Square(double side) {
        if (side > 0) {
            this.side = side;
        } else {
            throw new IllegalArgumentException("The side of square cannot be negative or equal to zero.");
        }
    }

    @Override
    public double findSquare() {
        return side * side;
    }
}
