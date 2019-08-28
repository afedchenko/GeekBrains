public class Team {

    /**
     * 2. Добавить класс Team, который будет содержать название команды, массив из четырех участников
     * (в конструкторе можно сразу указыватьвсех участников ), метод для вывода информации о членах команды,
     * прошедших дистанцию, метод вывода информации обо всех членах команды.
     */

    private String teamName;
    private TeamMate[] teamMate ;


    public TeamMate[] getTeamMate() {
        return teamMate;
    }

    public String getTeamName() {
        return teamName;
    }


    public Team (String teamName, TeamMate[] teamMate){
        this.teamName = teamName;
        this.teamMate = teamMate;
    }

    public void showResults(){
        System.out.println("Итак, СТАРТ!!!");
        for (TeamMate i: teamMate) {
            if (i.result == 1) {System.out.println(i.getName() + " прошел дистанцию!");}
            else System.out.println(i.getName() + " выдохся и не прошел =(");

        }

    }

    public void teamInfo(){
        System.out.println("Название команды: " + getTeamName());
        System.out.println("Количество участников: " + teamMate.length);
        System.out.println("Имена участников:");
        for(TeamMate i: teamMate) {
            System.out.println(i.getName());
        }
    }


}
