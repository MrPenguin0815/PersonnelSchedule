package team.domain;

public class Waiter extends Employee{
    public Waiter() {
    }

    public Waiter(String name, double salary, int id) {
        super(name, salary, id);
    }

    @Override
    public String toString() {
        return printInfo() + "\t倒茶\t\t";
    }

    @Override
    public String printTeamInfo() {
        return null;
    }
}
