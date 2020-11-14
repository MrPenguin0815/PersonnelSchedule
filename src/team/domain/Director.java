package team.domain;

import team.service.Status;

public class Director extends Painter {
    private double bonus;

    public Director() {
    }

    public Director(String name, double salary, int id,Equipment equipment,double bonus) {
        super(name, salary, id,equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


    @Override
    public String toString() {
        return  printInfo() + "\t导演\t\t" + bonus + "\t" + getEquipment().getDescription();
    }


    @Override
    public String printTeamInfo() {
        return getMemberId() + "/" + getId() + "\t\t" + getName() + "\t" + getSalary() + "\t导演";
    }
}
