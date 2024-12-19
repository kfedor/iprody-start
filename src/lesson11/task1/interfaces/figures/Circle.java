package lesson11.task1.interfaces.figures;

import lesson11.task1.interfaces.Figure;

public class Circle implements Figure {

    private final double radius;

    public Circle(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("The radius of circle cannot be negative or equal to zero.");
        }
    }

    @Override
    public double findSquare() {
        return Math.PI * radius * radius;
    }
}
