package ru.gb.jcore.homework_3;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public class Employee {
    private String lastName;
    private String firstName;
    private String middleName;
    private String position;
    private String phoneNumber;
    private int salary;
    private LocalDate dateOfBirth;

    public Employee(String lastName, String firstName, String middleName, String position, String phoneNumber, int salary, LocalDate dateOfBirth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return getPeriod(getDateOfBirth(), LocalDate.now());
    }

    private int getPeriod(LocalDate start, LocalDate end){
        Period difference = Period.between(start, end);
        return difference.getYears();
    }

    public String getInfo(){
        return "Фамилия: " +
                getLastName() +
                ", имя: " +
                getFirstName() +
                ", отчество: " +
                getMiddleName() +
                "| Должность: " +
                getPosition() +
                "| Телефон: " +
                getPhoneNumber() +
                "| Зарплата: " +
                getSalary() +
                "| Возраст: " +
                getAge();
    }

    public void increaseSalary(int amount){
        setSalary(getSalary() + amount);
    }

    // Написать прототип компаратора - метод внутри класса сотрудника, сравнивающий две даты,
    // представленные в виде трёх чисел гггг-мм-дд, без использования условного оператора.
    public static Comparator<Employee> getBirthOfDateComparator(){
        return Comparator.comparing(employee -> employee.dateOfBirth);
    }

    public static int compareDates(Employee o1, Employee o2) {
        return Employee.getBirthOfDateComparator().compare(o1, o2);
    }
}
