public class TeamMate {
    private  String name;
    private int jump;

    public TeamMate(String name, int jump) {
        this.name = name;
        this.jump = jump;
    }

    public String getName() {
        return name;
    }

    public int getJump() {
        return jump;
    }

    public int result = 1; // У каждого тиммэйта есть результат. По умолчанию "1" - значит прошел
}
