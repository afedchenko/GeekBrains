import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

//Введите содержимое файла input.txt: 3 3 3 3 3 3 3 3 3 3 3 3
//Содержимое файла output.txt должно быть: 3

public class Test2 {
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
            e.printStackTrace();
        }

        TestUtils.writeFile(setList);
    }
}
