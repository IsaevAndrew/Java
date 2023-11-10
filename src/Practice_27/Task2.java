package Practice_27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        Map<String, List<String>> peopleMap = createMap();

        int sameFirstNameCount = getSameFirstNameCount(peopleMap, "Иван");
        int sameLastNameCount = getSameLastNameCount(peopleMap, "Петров");

        System.out.println("Людей с одинаковыми именами: " + sameFirstNameCount);
        System.out.println("Людей с одинаковой фамилией: " + sameLastNameCount);
    }

    public static Map<String, List<String>> createMap() {
        Map<String, List<String>> map = new HashMap<>();

        addPerson(map, "Петров", "Иван");
        addPerson(map, "Иванов", "Мария");
        addPerson(map, "Петров", "Андрей");
        addPerson(map, "Смирнова", "Анна");
        addPerson(map, "Козлов", "Дмитрий");
        addPerson(map, "Петров", "Ольга");
        addPerson(map, "Морозов", "Иван");
        addPerson(map, "Петров", "Дмитрий");
        addPerson(map, "Петров", "Ольга");
        addPerson(map, "Васильев", "Иван");

        return map;
    }

    public static void addPerson(Map<String, List<String>> map, String lastName, String firstName) {
        if (!map.containsKey(lastName)) {
            map.put(lastName, new ArrayList<>());
        }
        map.get(lastName).add(firstName);
    }

    public static int getSameFirstNameCount(Map<String, List<String>> map, String firstName) {
        int count = 0;
        for (List<String> names : map.values()) {
            count += names.stream().filter(name -> name.equals(firstName)).count();
        }
        return count;
    }

    public static int getSameLastNameCount(Map<String, List<String>> map, String lastName) {
        return map.containsKey(lastName) ? map.get(lastName).size() : 0;
    }
}
