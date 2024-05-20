package ru.gb.jcore.homework_3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Задание 3**. Создать массива всех сотрудников, который должен быть сразу инициализирован и не должно быть создано дополнительных переменных.
        Employee[] staff = {new Employee("Иванов", "Иван", "Иванович", "бухгалтер", "79255813223", 120000, LocalDate.of(1973,10,2)),
                new Employee("Петров", "Пётр", "Петрович", "эксперт", "79051234567", 90000, LocalDate.of(2001,6,30)),
                new Employee("Екатеринова", "Екатерина", "Екатериновна", "дистрибьютор", "79255813223", 120000, LocalDate.of(1963,5,7)),
                new Employee("Тарасов", "Тарас", "Тарасович", "маркетолог", "79033244556", 100000, LocalDate.of(1999,3,21)),
                new Employee("Ольгова", "Ольга", "Ольговна", "курьер", "79012237879", 60000, LocalDate.of(2001,6,30)),
                new Head("Владимиров", "Владимир", "Владимирович", "Начальник", "79150803023", 150000, LocalDate.of(1975,9,15))
        };
        getStaffInfo(staff);
        System.out.println("+++++++++++++++++++++++++++++++++");

        //Задание 2*. Написать функцию выводящую всю доступную информацию об объекте таким образом, чтобы функция
        //возвращала значение.
        System.out.println(staff[2].getInfo());
        System.out.println("+++++++++++++++++++++++++++++++++");

        //Задание 4. Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
        // Метод должен принимать в качестве параметра массив сотрудников, возраст и размер повышения.
        // Перенесите статический метод повышения зарплаты в класс руководителя,
        // модифицируйте метод таким образом, чтобы он мог поднять заработную плату всем, кроме руководителей.
        // Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.
        Head.increaseSalary(staff, 45, 5000);
        getStaffInfo(staff);
        System.out.println("+++++++++++++++++++++++++++++++++");

        //Задание 5. Написать методы (принимающие на вход массив сотрудников), вычисляющие
        //средний возраст и среднюю зарплату сотрудников, вывести результаты работы в консоль.
        System.out.println("Средний возраст сотрудников = " + getAverageAge(staff));
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("Средняя зарплата сотрудников = " + getAverageSalary(staff));
        System.out.println("+++++++++++++++++++++++++++++++++");

        // Использование компаратора для сравнения дат. Определим кто из двух сотрудников старше.
        whoIsOlder(staff[0], staff[2]);
        System.out.println("+++++++++++++++++++++++++++++++++");
        whoIsOlder(staff[1], staff[4]);
    }

    public static int getAverageAge(Employee[] staff){
        int totalAge = 0;
        for (Employee employee : staff) {
            totalAge = totalAge + employee.getAge();
        }
        return totalAge / staff.length;
    }

    public static int getAverageSalary(Employee[] staff){
        int totalSalary = 0;
        for (Employee employee : staff) {
            totalSalary = totalSalary + employee.getSalary();
        }
        return totalSalary / staff.length;
    }

    public static void whoIsOlder(Employee o1, Employee o2) {
        int index = Employee.compareDates(o1, o2);
        if (index < 0) {
            System.out.println(o1.getLastName() + " " + o1.getFirstName() + " " + o1.getMiddleName() + " старше, чем " + o2.getLastName() + " " + o2.getFirstName() + " " + o2.getMiddleName());
        } else if (index == 0) {
            System.out.println(o1.getLastName() + " " + o1.getFirstName() + " " + o1.getMiddleName() + " и " + o2.getLastName() + " " + o2.getFirstName() + " " + o2.getMiddleName() + " родились в один день");
        } else {
            System.out.println(o2.getLastName() + " " + o2.getFirstName() + " " + o2.getMiddleName() + " старше, чем " + o1.getLastName() + " " + o1.getFirstName() + " " + o1.getMiddleName());
        }
    }

    public static void getStaffInfo(Employee[] staff){
        for (Employee employee : staff) {
            System.out.println(employee.getInfo());
        }
    }
}
