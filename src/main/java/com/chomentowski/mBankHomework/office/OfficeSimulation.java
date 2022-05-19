package com.chomentowski.mBankHomework.office;

public class OfficeSimulation {
    public static void main(String[] args) {
        Boss boss = new Boss("Kamil", "Kudynowski");
        Employee employee = new Employee("Sebastian", "Chomentowski");

        System.out.println(boss.getPosition() + " firstname: " + boss.getFirstName());
        System.out.println(employee.getPosition() + " surname: " + employee.getSurName());
    }
}
