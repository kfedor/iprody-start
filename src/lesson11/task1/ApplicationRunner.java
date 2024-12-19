package lesson11.task1;

import lesson11.task1.interfaces.Figure;
import lesson11.task1.interfaces.figures.Circle;
import lesson11.task1.interfaces.figures.Square;
import lesson11.task1.interfaces.figures.Triangle;

public class ApplicationRunner {
    public static void main(String[] args) {
        Figure[] figures = {
                new Circle(4.5),
                new Square(8.8),
                new Triangle(3.3, 4.4, 1.1)
        };
        FigurePrinter.printSquares(figures);
    }

}