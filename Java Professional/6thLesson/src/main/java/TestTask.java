package main.java;

public class TestTask {

    public int[] arrayAfterLastFour(int[] a) throws RuntimeException {
        int index = 0;

        //Находим индекс числа в массиве после последней четверки
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 4) {
                index = i + 1;
                break;
            } else if (i == 0) {
                throw new RuntimeException();
            }
        }

        //Вычисляем длину нового массива = длина старного массива - длинна массива до последней четверки включительно
        int lastFourIndex = a.length - index;
        int[] checkedArray = new int[lastFourIndex];

        //Если есть четверки в массиве, то заполняем новый массив числами из старого массива после последней четверки
        for (int i = 0; i < (lastFourIndex); i++) {
            checkedArray[i] = a[index + i];
        }
        return checkedArray;
    }
}