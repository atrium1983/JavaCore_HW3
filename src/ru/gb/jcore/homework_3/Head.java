package ru.gb.jcore.homework_3;

import java.time.LocalDate;

public class Head extends Employee{

    public Head(String lastName, String firstName, String middleName, String position, String phoneNumber, int salary, LocalDate dateOfBirth) {
        super(lastName, firstName, middleName, position, phoneNumber, salary, dateOfBirth);
    }
    public static void increaseSalary(Employee[] staff, int age, int amount){
        for (Employee employee : staff) {
            if (!(employee instanceof Head) && employee.getAge() > age) {
                employee.increaseSalary(amount);
            }
        }
    }
}
