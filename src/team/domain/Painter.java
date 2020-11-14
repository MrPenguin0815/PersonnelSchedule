package team.domain;

public class Painter extends Employee{
    private Equipment equipment;



    public Painter() {
    }

    public Painter(String name, double salary, int id, Equipment equipment) {
        super(name, salary, id);
        this.equipment = equipment;

    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String toString(){
        return printInfo() + "\t原画" +"\t\t\t\t" + equipment.getDescription();
    }

    @Override
    public String printTeamInfo() {
        return getMemberId() + "/" + getId() + "\t\t" + getName() + "\t" + getSalary() + "\t原画" ;

    }
}
