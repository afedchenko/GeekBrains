public class Robot extends Being {
    @Override
    public void run(){
        System.out.println("Робот пока не умеет бегать");
    }

    @Override
    public void jump() {
        System.out.println("Робот пока не научился прыгать");
    }
}
