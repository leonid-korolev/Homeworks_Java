package Homework_1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        final int min = -1000; //Минимальное число для диапазона.
        final int max = 1000;  //Максимальное число для диапазона.
        final int i = rnd(min, max);

        System.out.println("i = " + i);
        
        System.out.println(setBitNumber(i));
        
        int n = bit1(i);

        System.out.println("n = " + n);
        
        System.out.println("Short.MAX_VALUE = " + Short.MAX_VALUE);
        int max1 = Short.MAX_VALUE;
        
        System.out.println("Short.MIN_VALUE = " + Short.MIN_VALUE);
        int min1 = Short.MIN_VALUE;

        ArrayList<Integer> m1 = arrayMult(i, n, max1); // Сохранение в массив m1 кратных n чисел  i до Short.MAX_VALUE.
//        System.out.print("массив значений n > i: " + m1);

        ArrayList<Integer> m2 = arrayNotMult(i, n, min1); // Сохранение в массив m2 некратных n чисел от Short.MIN_VALUE до i.
//        System.out.println("массив значений n < i: " + m2);

        saveArray(m1, "Homework_1/m1.txt"); // Сохранение в файл массива m1.
        saveArray(m2, "Homework_1/m2.txt"); //Сохранение в файл массива m2.
    }
/* 
    1. Метод получения случайного целого числа
       от min до max (включая max);
 */
    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max)+ min; 
        
    }

/*
    Метод вычисления старшего значащего бита
    полученного случайного числа.
 */
    static int setBitNumber(int i) {

        if (i == 0)
            return 0;
 
        int msb = 0;
        i = i / 2;
 
        while (i != 0) {
            i = i / 2;
            msb++;
        }
 
        return (1 << msb);

    }

/*
    2. Метод вычисления позиции (номера) старшего значащего бита (msb).
 */
    public static int bit1( int i) {
            
        int msbNumber = Integer.toBinaryString(i).length();
        return msbNumber;
    }

//  3. Метод нахождения кратных n чисел в диапазоне от i до Short.MAX_VALUE
    public static ArrayList<Integer> arrayMult(int i, int n, int max1) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = i + 1; j <= max1; j++ ) {
            if (j % n == 0){
                list.add(j);
            }
        }
        return list;
    }

//  4. Метод нахождения некратных n чисел в диапазоне от Short.MIN_VALUE до i
    public static ArrayList<Integer> arrayNotMult(int i, int n, int min1) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = i - 1; j >= min1; j--){
            if (j % n !=0) {
                list.add(j);
            }
        }
        return list;
    }

// 5. 5. Сохранение массивов в файлы с именами m1 и m2 соответственно.
    public static void saveArray(ArrayList<Integer> arr, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
                for (Integer k : arr) {
                    writer.write(k + "\t");
                }
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
}


    

