package team.domain;

import team.service.Status;

public class Scenarist extends Employee{
    private double bonus;

    public Scenarist() {
    }


    public Scenarist(String name, double salary, int id, double bonus) {
        super(name, salary,id);
        this.bonus = bonus;
    }

    public String toString() {
        return  printInfo() + "\t脚本师\t" + bonus;
    }

    @Override
    public String printTeamInfo() {
        return getMemberId() + "/" + getId() + "\t\t" + getName() + "\t" + getSalary() + "\t脚本师";
    }
}
