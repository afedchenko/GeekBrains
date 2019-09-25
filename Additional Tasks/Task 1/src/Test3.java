import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

//Введите содержимое файла input.txt: 12 5 12 5 12 5
//Содержимое файла output.txt должно быть: 17

public class Test3 {
    //Записываем в файл output.txt значения из HashSet, предварительно их суммировав
    public static void writeFileSum(HashSet<Integer> numbers) {

        try {
            PrintWriter out = new PrintWriter("output.txt");
            int sum = 0;
            for (Integer number : numbers) {
                sum += number;
            }
            out.print(sum);
            out.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("Не найден файл output.txt");
        }
    }

    public static void main(String[] args) {
        HashSet<Integer> setList = new HashSet<>();
        try {
            Scanner scanner = TestUtils.initScanner();
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    setList.add(scanner.nextInt());
                } else {
                    scanner.next();
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Не найден файл input.txt]");
        }
        writeFileSum(setList);
    }
}
