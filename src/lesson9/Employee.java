package lesson9;

public class Employee {
    private String fullName;
    private int age;
    private String position;
    private int salary;
    private String email;
    private String phoneNumber;

    public Employee(String fullName, int age, String position, int salary, String email, String phoneNumber) {
        this.fullName = fullName;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void printInfo() {
        System.out.println(
                "full name: " + fullName +
                        "\nage: " + age +
                        "\nposition: " + position +
                        "\nsalary: " + salary +
                        "\nemail: " + email +
                        "\nphone number: " + phoneNumber
        );
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
