import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    //1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    private static <T> void swap(T[] a) {
        T t = a[0];
        a[0] = a[1];
        a[1] = t;
    }

    private static <T> void swap(List<T> l) {
        Collections.<T>swap(l, 0, 1);
    }

    private static void test() {
        String[] a = {"Лево", "Правоä"};
        swap(a);
        System.out.println("a:" + Arrays.toString(a));
        List<String> l = new ArrayList<>(Arrays.asList(a));
        swap(l);
        System.out.println("l:" + l);
    }

    //2. Написать метод, который преобразует массив в ArrayList;

    public static <T> ArrayList<T> changeArrayToArrayList(T[] simpleArray) {
        return new ArrayList<>(Arrays.asList(simpleArray));
    }

    //Тест
    public static void main(String[] args) {

        //Проверка 1-й задачи
        test();

        //Создаем листы фруктов для добавления в коробки
        ArrayList<Orange> oranges = new ArrayList<>();
        ArrayList<Apple> apples = new ArrayList<>();

        //Заполняем листы фруктами
        for (int i = 0; i < 20; i++) {
            oranges.add(new Orange());
            apples.add(new Apple());
        }

        //Создаем коробки, кладем в них фрукты, взвешиваем
        Box<Orange> boxOfOranges = new Box<>("boxOfOranges");
        boxOfOranges.addFruitsIntoBox(oranges);
        System.out.println("Апельсины в коробке весят " + boxOfOranges.getWeight() + " кг");

        Box<Apple> boxOfApples = new Box<>("boxOfApples");
        boxOfApples.addFruitsIntoBox(apples);
        System.out.println("Яблоки в коробке весят " + boxOfApples.getWeight() + " кг");

        //Сравниваем по весу коробки Апельсинов с Яблоками
        System.out.println("Равны ли по весу коробки? " + boxOfApples.compare(boxOfOranges));


        //Добавляем пару коробок, чтобы пересыпать фрукты
        Box<Orange> boxOfOranges1 = new Box<>("boxOfOranges1");
        Box<Apple> boxOfApples1 = new Box<>("boxOfApples1");
        boxOfOranges.replaceFruitsToAnotherBox(boxOfOranges1);
        // boxOfApples.replaceFruitsToAnotherBox(boxOfOranges); // Это не будет работать из-за сортировки типов

    }
}