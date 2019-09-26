import java.util.ArrayList;


// Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
// поэтому в одну коробку нельзя сложить и яблоки, и апельсины

public class Box<T extends Fruit> {

    // Для хранения фруктов внутри коробки можно использовать ArrayList
    ArrayList<T> box = new ArrayList<>();


    // Метод для добавления фрукта в коробку

    public <T> void addFruitsIntoBox(ArrayList<T> arrayOfFruits) {
        ArrayList<T> arrayIntoBox = new ArrayList<>();

    }


    //Метод, который высчитывает вес коробки = вес одного фрукта * на количество фруктов в коробке(листе)

    public void getWeight(ArrayList<Box> list) {
        float weightOfBox = 0.0f;
        //тут будет формула
        System.out.println(weightOfBox);
    }

    /* Сделать метод Compare, который позволяет сравнить текущую коробку с той, которую подадут в Compare в качестве
     * параметра. True – если их массы равны, False в противоположном случае. Можно сравнивать коробки с яблоками
     * и апельсинами */



    /** Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов:
     * нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается,
     * а в другую перекидываются объекты, которые были в первой */

}