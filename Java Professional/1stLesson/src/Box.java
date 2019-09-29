import java.util.ArrayList;

// Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
// поэтому в одну коробку нельзя сложить и яблоки, и апельсины

public class Box<T extends Fruit> {

    String name;

    public Box(String name) {
        this.name = name;
    }

    // Для хранения фруктов внутри коробки можно использовать ArrayList
    private ArrayList<T> unitsForFruits = new ArrayList<>();

    // Метод для добавления фруктов в коробку
    public void addFruitsIntoBox(ArrayList<T> arrayOfFruits) {
        unitsForFruits.addAll(arrayOfFruits);
    }

    //Метод, который высчитывает вес коробки = вес одного фрукта * на количество фруктов в коробке(листе)
    public float getWeight() {
        float weightOfBox = 0.0f;
        for (T x : unitsForFruits) {
            weightOfBox += x.weight;
        }
        return weightOfBox;
    }

    /* Сделать метод Compare, который позволяет сравнить текущую коробку с той, которую подадут в Compare в качестве
     * параметра. True – если их массы равны, False в противоположном случае. Можно сравнивать коробки с яблоками
     * и апельсинами */
    public <T> boolean compare(Box other) {
        boolean weightCompare = false;
        if (this.getWeight() == other.getWeight()) {
            weightCompare = true;
        }
        return weightCompare;
    }

    /** Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов:
     * нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается,
     * а в другую перекидываются объекты, которые были в первой
     * @return*/

    public void replaceFruitsToAnotherBox (Box<T> other) {
        System.out.println("Вес фруктов в коробке " + this.name + ": " + this.getWeight() + " кг, а вес фруктов в коробке "
                + other.name + " " + other.getWeight() + " кг");
        other.unitsForFruits.addAll(this.unitsForFruits);
        this.unitsForFruits.clear();
        System.out.println("Фрукты из коробки " + this.name + " пересыпаны в коробку " + other.name);
        System.out.println("Вес фруктов в текущей коробке " + this.getWeight() + " кг ,а вес фруктов в другой коробке "
                + other.getWeight() + " кг");
    }
}
