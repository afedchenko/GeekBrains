import java.io.IOException;
import java.util.Scanner;

//Введите содержимое файла input.txt: 1 2 3
//Содержимое файла output.txt должно быть: 6


public class Test1 {
    public static void main(String[] args) {

        int sum = 0;
        try {
            Scanner scanner = TestUtils.initScanner();
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    sum += scanner.nextInt();
                } else {
                    scanner.next();
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TestUtils.writeFile(sum);
    }
}
