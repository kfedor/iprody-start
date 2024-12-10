package lesson9;

public class Application {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee(
                        "Ivanov Ivan Ivanovich",
                        41,
                        "sales manager",
                        100000,
                        "ivan@ivan.com",
                        "777-777"),
                new Employee("Petrov Petr Petrovich",
                        20,
                        "developer",
                        1000000,
                        "petr@petr.com",
                        "666-666"),
                new Employee("Denisova Sveta Denisovna",
                        16,
                        "senior developer",
                        2000000,
                        "sveta@senior.com",
                        "111-111"),
                new Employee("Vasiliev Vasiliy Vasilievoch",
                        23,
                        "administrator",
                        100000,
                        "vasiliy@vasiliy.com",
                        "222-222"),
                new Employee("Nikolaeva Ksenia Petrovna",
                        55,
                        "CEO",
                        2000000,
                        "ceo@ceo.com",
                        "000-000"),
        };
        printInfo(employees);
    }

    public static void printInfo(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() >= 40) {
                employees[i].printInfo();
                System.out.println("====================");
            }
        }
    }
}
