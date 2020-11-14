package team.service;

import team.domain.*;

public class TeamService {
    private final int MAX_NUMBER = 6;//加入开发团队的最大人数
    private static int count = 0;//用于之后给memberId赋值
    private int total;//已加入开发团队的人数
    private Employee[] team = new Employee[MAX_NUMBER];





    /**
     * 用于已加入的成员的展示,返回已加入成员构成的数组
     */
    public Employee[] getCurrentTeam() {
        Employee[] team = new Employee[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }

        return team;
    }




    /**
     * 添加成员，并处理添加时出现的异常
     */
    public void addMember(Employee e) throws TeamException {

        if(total > MAX_NUMBER){
            throw new TeamException("制作组成员已满，添加失败");
        }


        if(e instanceof Waiter){
            throw new TeamException("此人会毁掉本作品，添加失败");
        }


        if(isExit(e)){
            throw new TeamException("该员工已在制作组中，添加失败");
        }


        if(e.getStatus().equals("BUSY")){
            throw new TeamException("该员工已加入某制作组，添加失败");
        }




        //限制制作组各个职位的人数
        int numOfDir = 0,numOfPai = 0,numOfSce = 0,numOfMus = 0;
        for (int i = 0; i < total; i++) {
            if(team[i] instanceof Director){
                numOfDir++;
            }else if(team[i] instanceof Painter){
                numOfPai++;
            }else if(team[i]instanceof Music){
                numOfMus++;
            }else if(team[i] instanceof Scenarist){
                numOfSce++;
            }
        }

        if(e instanceof Director){
            if(numOfDir == 1){
                throw new TeamException("制作组至多只能有一名导演,添加失败");
            }
        }else if(e instanceof Painter){
            if(numOfPai == 3){
                throw new TeamException("制作组至多只能有三名原画师,添加失败");
            }
        }else if(e instanceof Music){
            if(numOfMus == 1){
                throw new TeamException("制作组至多只能有一名音乐监督,添加失败");
            }
        }else if(e instanceof Scenarist){
            if(numOfSce == 1){
                throw new TeamException("制作组至多只能有一名脚本师,添加失败");
            }
        }



        team[total] = e;//若以上异常均未发生，则执行此部分
        total++;
        e.setStatus(Status.BUSY);
        e.setMemberId(++count);

    }





    /**
     * 判断某员工是否已在团队中
     */
    private boolean isExit(Employee e) {
        for (int i = 0; i < total; i++) {
            if (e.getId() == team[i].getId()) {
                return true;
            }
        }
        return false;
    }






    /**
     * 删除成员，并处理删除时出现的异常
     */
    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if (memberId == team[i].getMemberId()) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }


        if (i == total) {
            throw new TeamException("未找到指定成员，删除失败");
        }

        for (int j = i; j < total - 1; j++) {
            team[j] = team[j + 1];
        }
        team[total - 1] = null;
        total--;
    }


}
