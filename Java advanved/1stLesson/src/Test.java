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

        Course course = new Course(new int[]{1, 2, 3, 4}); //Создаем массив препятствий, с высотой в метрах


       //Создаем массив участников, который подставим в конструктор класса Team
       //У каждого участника есть параметр jump - максимальная высота прыжка
        TeamMate[] member = new TeamMate[]{
                new TeamMate("Ivan", 5),
                new TeamMate("Vasya", 4),
                new TeamMate("Ilya", 3),
                new TeamMate("Natalia", 4)
        };

        Team team = new Team("Crazy" , member); //Создаем команду с названием и массивом мемберов

    team.teamInfo(); //Информация о команде
    course.doIt(team); //Просим команду пройти полосу препятствий
    team.showResults(); //Показываем, кто прошел, а кто нет
        
    }
}
