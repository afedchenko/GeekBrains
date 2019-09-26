import java.lang.reflect.Array;
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
        String[] a = {"Hello", "Goodbye"};
        swap(a);
        System.out.println("a:" + Arrays.toString(a));
        List<String> l = new ArrayList<String>(Arrays.asList(a));
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

        //Коробки с фруктами
    }
}