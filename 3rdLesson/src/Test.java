import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {

        /**
         1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
         Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         Посчитать, сколько раз встречается каждое слово.
         */

        String[] users = new String[]{"человек", "природа", "зверь", "зверь", "камень", "вода", "воздух", "воздух", "время", "время", "время"};

        Set<String> unique = new HashSet<>();
        Map <String,Integer> map = new HashMap<>();

        for(String i : users){
            unique.add(i);
            int count;

            if(map.get(i) == null) {
                map.put(i, 1);
            } else {
                count = map.get(i);
                count++;
                map.put(i, count);
            }
        }

        System.out.println("Сколько раз повторяются слова: " + map);
        System.out.println("Список уникальных слов: " + unique);
    }
}
