package team.domain;

public class Tablet implements Equipment{
    private String model;//型号
    private String brand;//品牌

    public Tablet(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    @Override
    public String getDescription() {
        return brand + "(" + model + ")";
    }
}
