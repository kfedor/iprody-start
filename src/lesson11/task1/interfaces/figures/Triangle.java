package lesson11.task1.interfaces.figures;

import lesson11.task1.interfaces.Figure;

public class Triangle implements Figure {

    private final double sideOne;
    private final double sideTwo;
    private final double sideThree;

    public Triangle(double sideOne, double sideTwo, double sideThree) {
        if (sideOne > 0 && sideTwo > 0 && sideThree > 0) {
            this.sideOne = sideOne;
            this.sideTwo = sideTwo;
            this.sideThree = sideThree;
        } else {
            throw new IllegalArgumentException("The side of triangle cannot be negative or equal to zero.");
        }
    }

    @Override
    public double findSquare() {
        double halfPerimeter = (sideOne + sideTwo + sideThree) / 2;
        return Math.sqrt(
                (halfPerimeter *
                        (halfPerimeter - sideOne) *
                        (halfPerimeter - sideTwo) *
                        (halfPerimeter - sideThree))
        );
    }
}
