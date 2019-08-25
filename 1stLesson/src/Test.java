public class Test {
    public static void main(String[] args) {

        /**
         * Задание 1 из методички
        Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь
        бегать и прыгать (методы просто выводят информацию о действии в консоль).
         */

        Being some = new Being ();
        some.run();
        some.jump();

        Human Alex = new Human();
        Alex.run();
        Alex.jump();

        Cat Vaska = new Cat();
        Vaska.run();
        Vaska.jump();

        Robot Cyborg = new Robot();
        Cyborg.run();
        Cyborg.jump();


        /**
         * Course c = new Course(...); // Создаем полосу препятствий
         * Team team = new Team(...); // Создаем команду
         * c.doIt(team); // Просим команду пройти полосу
         * team.showResults(); // Показываем результаты
         */

        Team team = new Team("CrazyRunners", new String[]{"John", "Dazy", "Colin", "Ted"});

        team.teamInfo();
    }
}
