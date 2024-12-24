package lesson11.task1;

import lesson11.task1.interfaces.Figure;

public class FigurePrinter {

    private FigurePrinter() {
    }

    public static void printSquares(Figure[] figures){
        double totalSquare = 0;
        for (Figure figure : figures) {
            totalSquare += figure.findSquare();
        }
        System.out.println("Total square of all figures is: " + totalSquare);
    }
}
