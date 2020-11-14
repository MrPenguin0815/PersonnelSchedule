package team.domain;

import team.service.Status;

public class Music extends Employee {

    public Music() {
    }

    public Music(String name, double salary, int id) {
        super(name, salary, id);
    }

    @Override
    public String toString() {
        return printInfo()+ "\t音乐监督\t\t";
    }

    @Override
    public String printTeamInfo() {
        return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getSalary() + "\t音乐监督";
    }
}
