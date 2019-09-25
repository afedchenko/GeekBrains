import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;

public class TestUtils {

    //Инициализируем сканер для считывания данных из файла
    public static Scanner initScanner() throws IOException {
        Path filePath = Paths.get("input.txt");
        Scanner scanner = null;
        scanner = new Scanner(filePath);
        return scanner;
    }

    // Записываем в файд output.txt значение типа  int
    public static void writeFile(int numToWrite) {
        PrintWriter out = null;
        try {
            out = new PrintWriter("output.txt");
            out.println(numToWrite);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }

    }

    //Записываем в файл output.txt значения из HashSet
    public static void writeFile(HashSet<Integer> numbers) {

        try {
            PrintWriter out = new PrintWriter("output.txt");

            for (Integer number : numbers) {
                out.print(number + " ");
            }
            out.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
