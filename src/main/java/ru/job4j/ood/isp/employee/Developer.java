package ru.job4j.ood.isp.employee;

public class Developer implements Employee {
    @Override
    public void writeCode() {
        System.out.println("writeCode");
    }

    @Override
    public void fixBugs() {
        System.out.println("fixBugs");
    }

    @Override
    public void testCode() {

    }
}
