package Homework_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Task3
 */
public class Task3 {

    // 1.
    // Создайте новый список массивов, добавить несколько цветов
    // (строку) и вывести коллекцию на экран.
    public static List<String> newColorList() {
        List<String> colorList = new ArrayList<>();
        colorList.add("red");
        colorList.add("yellow");
        colorList.add("green");

        return colorList;
    }

    // 2.
    // Проитерируйте все элементы списка цветов и добавте к каждому символ '!'.
    public static List<String> iterList(List<String> list) {
        ListIterator<String> it = list.listIterator();
        while(it.hasNext()) {
            it.set(it.next().concat("!"));
        }
        return list;
    }

    // 3.
    // Напишите программу для вставки элемента в список массивов в первой позиции.
    public static List<String> addList(List<String> list) {
        list.add(0, "white");
        return list;
    }

    // 4.
    // Извлеките элемент (по указанному индексу) из заданного списка.
    public static String getList(List<String> list) {
        return list.get(1);
    }

    // 5.
    // Обновите элемент массива по заданному индексу.
    public static List<String> updateElementList(List<String> list, int i, String Element ) {
        list.set(i, Element);
        return list;
    }

    // 6.
    // Напишите программу для удаления третьего элемента из списка массивов.
    public static List<String> removeList(List<String> list) {
        list.remove(2);
        return list;
    }

    // 7.
    // Напишите программу для поиска элемента в списке массивов.
    public static boolean searchElementList(List<String> list, String element) {
        if (list.contains(element))
            return true;
        else
            return false;
    }

    // 8.
    // Напишите программу для сортировки заданного списка массивов.
    public static List<String> sortList(List<String> list) {
        Collections.sort(list);
        return list;
    }

    // 9.
    // Напишите программу для копирования одного списка массивов в другой.
    public static List<String> copyList(List<String> list) {
        List<String> newCopyList = List.copyOf(list);
        return newCopyList;
    }


    public static void main(String[] args) {
        // 1.
        System.out.println(newColorList());

        // 2.
        System.out.println(iterList(newColorList()));

        // 3.
        System.out.println(addList(iterList(newColorList())));

        // 4.
        System.out.println(getList(addList(iterList(newColorList()))));

        // 5.
        System.out.println(updateElementList(addList(iterList(newColorList())), 1, "blue"));

        // 6.
        System.out.println(removeList(updateElementList(addList(iterList(newColorList())), 1, "blue")));

        // 7.
        String searchElement = "yellow";
        System.out.println(searchElementList(removeList(updateElementList(addList(iterList(newColorList())), 1, "blue")), searchElement));
        
        // 8.
        System.out.println(sortList(updateElementList(addList(iterList(newColorList())), 1, "blue")));

        // 9.
        System.out.println(copyList(sortList(updateElementList(addList(iterList(newColorList())), 1, "blue"))));

    }

    
}