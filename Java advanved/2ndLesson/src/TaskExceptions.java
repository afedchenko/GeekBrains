public class TaskExceptions {

    /**
     * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
     * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
     * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
     * должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
     * 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException,
     * и вывести результат расчета.
     */
    
    private static int sumM = 0;

    public static void main(String[] args) {

        String[][] a = {{"1", "8", "3", "4"}, {"1", "7", "23", "4"}, {"12", "24", "3", "4",}, {"a", "2", "3", "4"}};
        String[][] b = new String[5][5];

        checkEx(a);
        System.out.println("Сумма чисел в массиве: " + sumM);
        checkEx(b); //Проверка, показывающая, что массив больше, чем 4х4 не пройдет! You shall not pass!
    }


    private static void checkEx(String[][] a) {
        try {
            checkM(a);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void checkM(String[][] c) throws MyArraySizeException, MyArrayDataException {
        int[][] newIntMassive = new int[4][4];
        if (c.length == 4 && c[0].length == 4) {
            System.out.println("Массив верного размера, продолжаем работу");
        } else {
            throw new MyArraySizeException("Массив больше 4х4! YOU SHALL NOT PASS!!!");
        }

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                try {
                    newIntMassive[i][j] = Integer.parseInt(c[i][j].trim());
                    sumM += newIntMassive[i][j];
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Нельзя преобразовать в int содержимое " +
                            "ячейки " + i + "х" + j + " в которой находится: " + c[i][j]);
                }
            }
        }
    }
}




