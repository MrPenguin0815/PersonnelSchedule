package team.service;

import team.domain.*;

public class NameListService {


    private Employee[] employees = new Employee[12];


    public NameListService() {//在构造器中对employees进行初始化
        for (int i = 0; i < employees.length; i++) {

            int job = Integer.parseInt(Data.EMPLOYEES[i][0]);//获取员工职业


            String name = Data.EMPLOYEES[i][2];
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][3]);//获取基本信息


            Equipment equipment;
            double bonus;


            switch (job) {//根据职业新建数组employees元素对象

                case Data.PAINTER:
                    equipment = createEquipment(i);
                    employees[i] = new Painter(name, salary, id, equipment);
                    break;

                case Data.DIRECTOR:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][4]);
                    employees[i] = new Director(name, salary, id, equipment, bonus);
                    break;

                case Data.MUSIC:
                    employees[i] = new Music(name, salary, id);
                    break;

                case Data.SCENARIST:
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][4]);
                    employees[i] = new Scenarist(name, salary, id, bonus);
                    break;

                case Data.WAITER:
                    employees[i] = new Waiter(name, salary, id);
            }


        }
    }


    /**
     * 获取员工对应位置上的设备
     */
    public Equipment createEquipment(int index) {
        String brand = Data.EQUIPMENTS[index][0];
        String model = Data.EQUIPMENTS[index][1];

        return new Tablet(model, brand);
    }


    /**
     * 获取员工数组
     */
    public Employee[] getAllEmployees() {
        return employees;
    }


    /**
     * 获取指定ID的员工
     */
    public Employee getEmployee(int id) throws TeamException {
        for (Employee e : employees) {
            if (e.getId() == id)
                return e;
        }
        throw new TeamException("该员工不存在");
    }


}
