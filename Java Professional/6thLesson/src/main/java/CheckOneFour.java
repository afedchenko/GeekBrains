package main.java;

public class CheckOneFour {

    //Проверяем состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод вернет false
    public boolean checkOneFourMethod(int[] a) {
        boolean isOneHere = false;
        boolean isFourHere = false;

        for (int value : a) {
            if (value == 1) {
                isOneHere = true;
            } else if (value == 4) {
                isFourHere = true;
            } else {
                return false;
            }
        }
        return isOneHere && isFourHere;
    }
}