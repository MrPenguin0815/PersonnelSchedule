package team.service;


public class Data {

    public static final int PAINTER = 11;
    public static final int DIRECTOR = 12;
    public static final int SCENARIST = 13;
    public static final int MUSIC = 14;
    public static final int WAITER = 15;



    //PAINTER   :  11, id, name, salary
    //DIRECTOR  :  12, id, name, salary, bonus
    //SCENARIST :  13, id, name, salary, bonus
    //MUSIC     :  14, id, name, salary
    //WAITER    :  15, id, name

    public static final String[][] EMPLOYEES = {
            {"11", "1", "汤浅政明", "8000"},
            {"11", "2", "吉成钢", "7500"},
            {"11", "3", "吉成曜", "7000"},
            {"11", "4", "真岛浩", "2400"},
            {"11", "5", "天野明", "6000"},
            {"11", "6", "古馆春一", "6800"},
            {"12", "7", "青木英", "10800","1200"},
            {"12", "8", "押井守", "19800","2500"},
            {"13", "9", "虚渊玄", "1800", "4800"},
            {"14", "10", "梶浦由记", "7600"},
            {"14", "11", "泽野弘之", "7100"},
            {"15", "12", "小太刀", "10"}
    };

    //如下的EQUIPMENTS数组元素与上面的EMPLOYEES元素一一对应
    public static final String[][] EQUIPMENTS = {
            {"WACOM", "DTC-133"},
            {"WACOM", "INTUOS-PRO"},
            {"XP-PEN", "G640"},
            {"UGEE", "EX08"},
            {"XP-PEN", "G430S"},
            {"WACOM", "PTH-660"},
            {"WACOM", "CTI-672"},
            {"UGEE", "EXRAI12"},
            {},
            {},
            {},
            {},

    };
}
