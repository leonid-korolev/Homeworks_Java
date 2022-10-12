package Homework_5;

import java.util.HashMap;

public class Task5 {
    public static void main(String[] args) {
        // 1. Объявить и инициализировать словарь hashMap<String, String>
        HashMap<String,String> hashMap = new HashMap<>();
        // 2. Добавить в словарь 10 пар "Ключ - Значение". Автор и название книги например.
        hashMap.put("Стивен Кинг", "Зеленая миля");
        hashMap.put("Федор Михайлович Достоевский", "Преступление и наказание");
        hashMap.put("Антуан де Сент-Экзюпери", "Маленький принц");
        hashMap.put("Михаил Булгаков", "Собачье сердце");
        hashMap.put("Эрих Мария Ремарк", "Три товарища");
        hashMap.put("Джером Сэлинджер", "Над пропастью во ржи");
        hashMap.put("Михаил Лермонтов", "Герой нашего времени");
        hashMap.put("Артур Конан Дойл", "Приключения Шерлока Холмса");
        hashMap.put("Оскар Уайльд", "Портрет Дориана Грея");
        hashMap.put("Льюис Кэрролл", "Приключения Алисы в стране чудес");

        hashMap.forEach((k,v) -> System.out.println(k + " - " + v));
        System.out.println();

        // 3. Пройти по словарю и добавить к значениям символ "!"
        hashMap.replaceAll((k,v) ->  v + "!");
        hashMap.forEach((k,v) -> System.out.println(k + " - " + v));
        System.out.println();

        // 4. Добавить нового автора и название книги если соответствующего ключа не было.
        hashMap.computeIfAbsent("Даниель Дефо", v -> "Робинзон Крузо");
        hashMap.computeIfAbsent("Михаил Лермонтов", v -> "Этот текст не должен добавиться");
        hashMap.forEach((k,v) -> System.out.println(k + " - " + v));
        System.out.println();

        // 5. Если ключ, указанный в запросе, имеется, 
        //    вырезать из соответствующего ключу значения первое слово.
        hashMap.computeIfPresent("Михаил Булгаков", (k,v) -> v.replaceFirst("Собачье", ""));
        hashMap.forEach((k,v) -> System.out.println(k + " - " + v));
        System.out.println();
        
    }
}
