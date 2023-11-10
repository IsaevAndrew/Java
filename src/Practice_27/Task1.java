package Practice_27;

import java.util.HashSet;
import java.util.TreeSet;

public class Task1 {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("Хонор");
        hashSet.add("Самсунг");
        hashSet.add("Ксиоми");
        hashSet.add("ZTE");
        hashSet.add("Айфон");
        TreeSet<String> treeSet = new TreeSet<>(hashSet);
        for (String item : treeSet) {
            System.out.println(item);
        }
    }
}
