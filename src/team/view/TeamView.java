package team.view;

import team.domain.Employee;
import team.service.NameListService;
import team.service.TeamException;
import team.service.TeamService;

public class TeamView {
    TeamService teamSvc = new TeamService();
    NameListService listSvc = new NameListService();


    public void enterMenu(){
        System.out.println("--------------------------------------------------------------------");
        System.out.println("动画《我们仍未打听到那天所邂逅的移动开发部学姐的芳名》制作筹备中ᕦ(･ㅂ･)ᕤ");
        System.out.println("感谢使用本制作人员调度程序(*￣︶￣)");
        System.out.println("注意：");
        System.out.println("备选名单纯属瞎搞，与同名的真实人员无瓜");
        System.out.println("--------------------------------------------------------------------");


        TSUtility.readReturn();


        while (true){
            char key = '0';
            System.out.println("\n\n");
            listAllEmployees();
            System.out.println("1 - 显示制作组成员");
            System.out.println("2 - 添加制作组成员");
            System.out.println("3 - 删除制作组成员");
            System.out.println("4 - 退出");
            System.out.println("请输入选择（1 - 4）：");

            key = TSUtility.readMenuSelection();


            switch (key){
                case '1':
                    listTeam();
                    break;
                case '2':
                    addTeamMember();
                    break;
                case '3':
                    deleteTeamMember();
                    break;
                case '4':
                    System.out.println("确认退出吗？（Y/N）:");
                    char isExit = TSUtility.readConfirmSelection();
                    if(isExit == 'Y')
                    return;
            }
        }
    }






    public void listAllEmployees() {
        Employee[] employees = listSvc.getAllEmployees();

            System.out.println("--------------------------制作人员调度程序-----------------------------");
            System.out.println("ID\t姓名\t\t状态\t\t工资\t\t职位\t\t奖金\t\t领用设备");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i].toString());
            }
            System.out.println("--------------------------------------------------------------------");
        }




    public void deleteTeamMember(){
        listTeam();
        System.out.print("请输入要删除员工的TID：");
        int id = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N)：");
        char yn = TSUtility.readConfirmSelection();
        if (yn == 'N')
            return;

        try {
            teamSvc.removeMember(id);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        TSUtility.readReturn();
    }


    public void addTeamMember(){

        try {
            System.out.println("请输入需要添加的成员的id：");
            int id = TSUtility.readInt();

            Employee emp = listSvc.getEmployee(id);
            teamSvc.addMember(emp);

            System.out.println("添加成功");
            TSUtility.readReturn();
            System.out.println("--------------------------------------------------------------------\n");


        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }


    }


    public void listTeam(){
        Employee[] team = teamSvc.getCurrentTeam();
        if(team == null ||team.length == 0){
            System.out.println("制作组中没有任何成员信息");
            System.out.println("--------------------------------------------------------------------\n");
        }else{
            System.out.println("--------------------------制作团队人员展示-----------------------------");
            System.out.println("TID/ID\t姓名\t\t工资\t\t职位");

            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].printTeamInfo());
            }

            System.out.println("--------------------------------------------------------------------\n");
            TSUtility.readReturn();
        }

    }


}
