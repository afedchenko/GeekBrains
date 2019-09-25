public class Cat extends Being {
    @Override
    public void run(){
        System.out.println("Кот бежит со скоростью 35 км/ч");
    }

    @Override
    public void  jump() {
        System.out.println("Кот прыгнул на 3 метра вперед");
    }
}
