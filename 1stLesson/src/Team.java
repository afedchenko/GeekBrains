public class Team {

    /**
     * 2. Добавить класс Team, который будет содержать название команды, массив из четырех участников
     * (в конструкторе можно сразу указыватьвсех участников ), метод для вывода информации о членах команды,
     * прошедших дистанцию, метод вывода информации обо всех членах команды.
     */

    private String teamName;
    private String[] teamMate;


    public String getTeamName() {
        return teamName;
    }


    public Team (String teamName, String[] teamMate){
        this.teamName = teamName;
        this.teamMate = teamMate;
    }

    public void showResults(){

    }

    public void teamInfo(){
        System.out.println("Название команды: " + this.getTeamName());
    }
}
