package Homework_6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;


public class Task6 {
    public static void main(String[] args) {
        // 1.Объявить и инициализировать множества HashSet hs, LinkedHashSet lhs и TreeSet ts
        HashSet<Integer> hs = new HashSet<>();
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        TreeSet<Integer> ts = new TreeSet<>();
        System.out.println(hs + " - HashSet (hs)\n" + lhs + " - LinkedHashSet (lhs)\n" + ts + " - TreeSet (ts)");
        System.out.println();

        // 2. Добавить в множества по 10 случайных целочисленных ключей.
        hs.addAll(rndmList(10));
        lhs.addAll(rndmList(10));
        ts.addAll(rndmList(10));
        System.out.println("hs: " + hs + "\nlhs: " + lhs + "\nts: " + ts);
        System.out.println();

        // 3. Пройти по множеству hs и, при условии наличия соответствующего ключа в множестве lhs, удалить ключ из hs
        System.out.println("hs: " + removeElementSet(hs, lhs));
        System.out.println();

        // 4. Пройти по множеству lhs и, при условии отсутствия соответствующего ключа в множестве ts, добавит ключ в ts
        System.out.println("lhs: " + addElementSet(lhs, ts));
        System.out.println();

        // 5. Объявить и инициализировать множество TreeSet ts1 с компаратором Integer (-1 при значении %2==0 ;0 при ==;1 при значении %2!=0).
        //  Заполнить ts1 15 случайными числами и вывести на печать.
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override 
            public int compare(Integer t0, Integer t1) {
                return ((t0 - t1)%2==0)?-1:((t0 - t1%2)!=0)?1:0;
            }
        };

        TreeSet<Integer> ts1 = new TreeSet<>(comparator);
        for (int i = 0; i < 15; i++) {
            int r = new Random().nextInt(50);
            ts1.add(r);
        }
        System.out.println("ts1: " + ts1 + "\n");

        // 6.*Объявить и инициализировать множество TreeMap tm с компаратором Integer (-1 при значении %2==0 ;0 при ==;1 при значении %2!=0).
        //  Заполнить tm 15 случайными числами и вывести на печать.
        TreeMap<Integer, Integer> tm = new TreeMap<>(comparator);
        for (int i = 0; i < 15; i++) {
            int k = new Random().nextInt(50);
            int v = new Random().nextInt(50);
            tm.put(k, v);
        }
        System.out.println("tm: " + tm + "\n"); 

    } 

    // 2.
    private static List<Integer> rndmList(int sizeList) {
       List<Integer> rndList = new ArrayList<>();
       while (rndList.size() < sizeList) {
           rndList.add((int) (Math.random() * 100));
       }
       return rndList;
    }

    // 3.
    private static Set<Integer> removeElementSet(Set<Integer> hs, Set<Integer> lhs) {
       hs.removeAll(lhs);
       return hs;
    }

    // 4.
    private static Set<Integer> addElementSet(Set<Integer> lhs, Set<Integer> ts) {
        lhs.addAll(ts);
        return lhs;
    }

    
}