public class Course {
     /**
     * 3. Добавить класс Course (полоса препятствий), в котором будут находиться массив препятствий и метод,
     * который будет просить команду пройти всю полосу;
     */

    private int[] board;

    public Course(int[] board) {
        this.board = board;
    }


    public void doIt(Team team) {
        for (TeamMate i : team.getTeamMate()) {

            for (int j = 0; j <= board.length; j++) {
                if(i.getJump()<j){
                    i.result = 0;
                }
            }

        }
    }
}
