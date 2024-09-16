package edu.mum.cs.cs525.labs.skeleton.composite;

public class Test {
    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("David Beckham");
        employee1.setSalary(100000.00);

        Employee employee2 = new Employee();
        employee2.setName("Jason Bourne");
        employee2.setSalary(50000.00);

        Manager manager = new Manager();
        manager.setName("Cris Ronaldo");
        manager.setSalary(500000.00);
        manager.addHire(employee2);


        Manager cto = new Manager();
        cto.setName("CTO");
        cto.setSalary(2000000.00);
        cto.addHire(employee1);
        cto.addHire(manager);

        SalaryConsumer salaryConsumer = new SalaryConsumer();
        HireCounterConsumer hireCounterConsumer = new HireCounterConsumer();
        cto.process(hireCounterConsumer);
        cto.process(salaryConsumer);
        System.out.println(STR."Count: \{hireCounterConsumer.getCount()}");
        System.out.println(STR."Total salary: \{salaryConsumer.getTotalSalary()}");
    }
}
