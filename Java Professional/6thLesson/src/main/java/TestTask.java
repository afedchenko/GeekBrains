package main.java;

public class TestTask {
    public int[] arrayAfterLastFour(int[] a) throws RuntimeException {
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

        if (!thereIsFour) {
            throw new RuntimeException();
        } else {
            //Если есть четверки в массиве, то заполняем новый массив числами из старого массива после последней четверки
            for (int i = 0; i < (a.length - index); i++) {
                checkedArray[i] = a[index + i];
            }
        }
        return checkedArray;
    }
}