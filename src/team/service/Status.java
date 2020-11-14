package team.service;

/**
 * 表示员工状态，只有空闲和忙碌两种
 */

public class Status {
    private final String NAME;

    private Status(String name){
        this.NAME = name;
    }

    public static Status FREE = new Status("FREE");
    public static Status BUSY = new Status("BUSY");


    public String getNAME() {
        return NAME;
    }


}
