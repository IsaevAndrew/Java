package Practice_26;

import java.util.LinkedList;

class KeyValuePair<K, V> {
    K key;
    V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class HashTable<K, V> {
    private static final int TABLE_SIZE = 100;
    private LinkedList<KeyValuePair<K, V>>[] table;

    public HashTable() {
        table = new LinkedList[TABLE_SIZE];
    }

    public int hashFunction(K key) {
        return Math.abs(key.hashCode()) % TABLE_SIZE;
    }

    public void add(K key, V value) {
        int index = hashFunction(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (KeyValuePair<K, V> pair : table[index]) {
            if (pair.key.equals(key)) {
                // Ключ уже существует, обновляем значение
                pair.value = value;
                return;
            }
        }

        // Ключ не найден, добавляем новую пару ключ-значение
        table[index].add(new KeyValuePair<>(key, value));
    }

    public V lookup(K key) {
        int index = hashFunction(key);
        if (table[index] != null) {
            for (KeyValuePair<K, V> pair : table[index]) {
                if (pair.key.equals(key)) {
                    return pair.value;
                }
            }
        }
        return null; // Ключ не найден
    }

    public void delete(K key) {
        int index = hashFunction(key);
        if (table[index] != null) {
            for (KeyValuePair<K, V> pair : table[index]) {
                if (pair.key.equals(key)) {
                    table[index].remove(pair);
                    return;
                }
            }
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        HashTable<String, Integer> hashtable = new HashTable<>();
        hashtable.add("один", 1);
        hashtable.add("два", 2);
        hashtable.add("три", 3);

        System.out.println("Поиск: ключ 'два', значение: " + hashtable.lookup("два"));

        hashtable.delete("два");
        System.out.println("Поиск после удаления: ключа 'два', значение: " + hashtable.lookup("два"));
    }
}
