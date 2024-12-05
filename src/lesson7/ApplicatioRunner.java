package lesson7;

public class ApplicatioRunner {
    public static void main(String[] args) {

        Employee employee1 = new Employee(
                "Ivanov Ivan Ivanovich",
                33,
                "Java Developer",
                "ivan@gmail.com",
                "8 800 200 20 20");

        Car car = new Car();
        car.start();
    }
}
