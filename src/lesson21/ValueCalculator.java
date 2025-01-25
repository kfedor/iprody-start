package lesson21;

public class ValueCalculator {

    private final double[] values = new double[1000000];

    public void doCalc() {
        long startTime = System.currentTimeMillis();
        for (double value : values) {
            value = 1.0;
        }
        double[] halfValues1 = new double[500000];
        double[] halfValues2 = new double[500000];
        System.arraycopy(values, 0, halfValues1, 0, 500000);
        System.arraycopy(values, 500000, halfValues2, 0, 500000);

        Thread thread1 = new Thread(() -> {
            for (double i : halfValues1) {
                i = i * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (double j : halfValues2) {
                j = j * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2);
            }
        });

        System.arraycopy(halfValues1, 0, values, 0, 500000);
        System.arraycopy(halfValues2, 0, values, 500000, 500000);
        long endTime = System.currentTimeMillis();

        System.out.println("The time taken to execute the program is equal to " + (endTime - startTime) + " millis.");

    }
}
