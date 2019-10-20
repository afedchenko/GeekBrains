import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 4, 4, 4, 6, 8, 9};
        int[] array1 = new int[]{1, 2, 3, 5, 6, 7, 6, 0, 9, 5};

        try {
            System.out.println(Arrays.toString(arrayAfterLastFour(array)));
            System.out.println(Arrays.toString(arrayAfterLastFour(array1)));
        } catch (RuntimeException e) {
            System.out.println("В следующем массиве нет четверок");
        }
    }

    public static int[] arrayAfterLastFour(int[] a) throws RuntimeException {
        int index = 0;
        boolean thereIsFour = false;

        //Находим индекс числа в массиве после последней четверки
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 4) {
                index = i + 1;
                thereIsFour = true;
            }
        }

        //Вычисляем длину нового массива = длина старного массива - длинна массива до последней четверки включительно
        int[] checkedArray = new int[a.length - index];

        if (thereIsFour == false) {
            throw new RuntimeException();
        } else {
            //Если есть четверки в массиве, то заполняем новый массив числами из старого массива после последней четверки
            for (int i = 0; i < (a.length - index); i++) {
                checkedArray[i] = a[index + i];
            }
            System.out.println("Цифры после четверки");
        }
        return checkedArray;
    }
}