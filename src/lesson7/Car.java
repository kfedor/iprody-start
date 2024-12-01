package lesson7;

public class Car {

    public void start() {

        startElectricity();
        startCommand();
        startFuelSystem();

        System.out.println("Car has started.");
    }

    private void startFuelSystem() {
        System.out.println("Fuel system has started.");
    }

    private void startCommand() {
        System.out.println("Command has started.");
    }

    private void startElectricity() {
        System.out.println("Electricity has started.");
    }
}
