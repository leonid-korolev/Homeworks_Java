package Homework_2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        String str1 = "Мыла мама раму";
        String str2 = "Мама";

        String tmp = str1.toLowerCase();
        String tmp1 = str2.toLowerCase();
        System.out.println(str1);
        System.out.println(str2);

        //1.
        System.out.println("1.\nНаименьшее окно в строке, содержащей все символы другой строки: ");
        minWindow(tmp, tmp1);
        System.out.println();

        // 2
        System.out.println("2.\nПроверить, являются ли две данные строки вращением друг друга.");
        Scanner iScanner = new Scanner(System.in, "UTF-8");
        System.out.printf("Введите первую строку: ");
        String str01 = iScanner.nextLine();
        System.out.printf("Введите вторую строку: ");
        String str02 = iScanner.nextLine();
//        iScanner.close();
        
        System.out.println();
        if (searchPalindrom(str01, str02)) {
            System.out.println("2.\nВведенные вами строки являются вращением друг друга");
        } else
            System.out.println("2.\nВведенные вами строки НЕ являются вращением друг друга");

        // 3 
        System.out.println("3.\nПереворачиваем строку с помощью рекурсии.");
        
        System.out.println("Введите строку: ");
        String str = iScanner.nextLine();
        iScanner.close();
        System.out.println("Результат: " + reverseString(str) );

        // 4
        System.out.println();
        System.out.println("4.\nМатематические выражения в виде строк:");
        int a = 3, b = 56;
        System.out.println(mathToStr(a, b, '+'));
        System.out.println(mathToStr(a, b, '-'));
        System.out.println(mathToStr(a, b, '*'));

        // 5
        System.out.println();
        System.out.println("5.\nЗамена знака '=' на слово 'равно'");
        System.out.println(replacEqual(mathToStr(a, b, '+')));
        System.out.println(replacEqual(mathToStr(a, b, '-')));
        System.out.println(replacEqual(mathToStr(a, b, '*')));
        
    }

//  1. Совпадения текста второй строки с первой
//     находим через регулярные выражения https://habr.com/ru/post/260773/.

    public static void minWindow(String firstText, String secondText) {
        Pattern pattern = Pattern.compile(secondText);
        Matcher matcher = pattern.matcher(firstText);
        while (matcher.find()) {
            System.out.println(firstText.substring(matcher.start(), matcher.end()));
        }
    }

// 2. Напишите программу на Java, чтобы проверить,
//    являются ли две данные строки вращением друг друга.

    public static boolean searchPalindrom(String firstStr, String secondStr) {
        return firstStr.equals(new StringBuilder(secondStr).reverse().toString());
    }

// 3. Напишите программу на Java, чтобы перевернуть строку с помощью рекурсии.

    public static String reverseString(String str) {
        if (str.length() <= 1) {
           return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
      }

// 4. Дано два числа, например 3 и 56, необходимо составить следующие строки:
//    3 + 56 = 59;  3 – 56 = -53;  3 * 56 = 168
//    Используем метод StringBuilder.append().

    public static String mathToStr(int num1, int num2, char sign) {
        StringBuilder sb = new StringBuilder();
        sb.append(num1).append(" ").append(sign).append(" ").append(num2).append(" = ");
        switch (sign) {
            case '+':
                sb.append(num1 + num2);
                break;
            case '-':
                sb.append(num1 - num2);
                break;
            case '*':
                sb.append(num1 * num2);
                break;
        }
        return sb.toString();
    }

// 5. Замените символ “=” на слово “равно”. 
//    Используйте методы StringBuilder.insert(),
//    StringBuilder.deleteCharAt(). 
    
    public static String replacEqual(String mathTask) {
        StringBuilder task = new StringBuilder(mathTask);
        int index = task.indexOf("=");
        return task.deleteCharAt(index).insert(index, "равно").toString();
    }   

    
}
