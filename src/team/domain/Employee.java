package team.domain;

import team.service.Status;

public abstract class Employee {
    private String name;
    private double salary;
    private int id;
    private int memberId;
    private Status status = Status.FREE;


    public Employee() {

    }

    public Employee(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String printInfo(){
        return id + "\t" + name + "\t" + status.getNAME() + "\t" + salary;
    }

    public abstract String toString();

    /**
     * 专门用于制作团队中信息的展示
     */
    public abstract String printTeamInfo();
}
