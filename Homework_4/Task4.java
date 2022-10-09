package Homework_4;
import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        LinkedList<Integer> id = new LinkedList<>();
        
        Scanner sc = new Scanner(System.in);
               
        boolean exit = true;
        while (exit) {
            
            
            System.out.println("Введите имя: ");
            name.add(sc.nextLine());
            
            System.out.println("Введите пол: ");         
            gender.add(sc.nextLine());

            System.out.println("Введите возраст: ");
            age.add(sc.nextInt());

            id.add(name.size() - 1);
            

            System.out.println("Выйти? (y/n)");
     
            sc.nextLine();
            String ex = sc.nextLine();

            if (ex.equals("y")) {
                exit = false;
            }
            
        }
 
//       int i = 0;
//       while (i < name.size()) {
//       System.out.println("Имя: " + name.get(i) + "  Пол: " + gender.get(i) + "  Возраст: " + age.get(i) + "  id: " + id.get(i));
//   
//       i++;
//       }
        id.forEach(n -> System.out.println("Имя: " + 
                name.get(n) + 
                "  Пол: " + gender.get(n) + 
                "  Возраст: " + age.get(n) + 
                "  id: " + name.get(n).hashCode()));

       System.out.println();
       System.out.println("----------");
 

        int cnt = id.size()-1 ;
        while (cnt > -1) {
            int maxAge = age.get(id.get(cnt));
            int index = cnt;         

            for ( int k = 0; k < cnt; k++) {
                if (maxAge < age.get(id.get(k))) {                
                    index = k;                  
                    maxAge = age.get(id.get(k));
                }

            }
            int tmp = id.get(index);
            id.set(index, id.get(cnt));
            id.remove(cnt);
            id.add(tmp);
            cnt --;
            
        }
        sc.close();

        id.forEach(n -> System.out.println("Имя: " + 
                name.get(n) + 
                "  Пол: " + gender.get(n) + 
                "  Возраст: " + age.get(n) + 
                "  id: " + name.get(n).hashCode()));
                   
    }
    
}
