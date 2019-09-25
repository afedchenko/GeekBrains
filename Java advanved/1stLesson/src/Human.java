public class Human extends Being {
    @Override
    public void run(){
        System.out.println("Человек бежит со скоростью 15 км/ч");
    }

    @Override
    public void  jump() {
        System.out.println("Человек прыгнул на 2 метра вперед");
    }
}
