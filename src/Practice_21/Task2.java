package Practice_21;

class GenericArray<T> {
    private Object[] array;
    private int size;

    public GenericArray(int capacity) {
        array = new Object[capacity];
        size = 0;
    }

    public void add(T element) {
        if (size < array.length) {
            array[size] = element;
            size++;
        } else {
            int newCapacity = array.length * 2;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
            array[size] = element;
            size++;
        }
    }

    public void FiveFirst() {
        if (size >= 5) {
            for (int elem=0; elem<5; elem++) {
                System.out.printf("%d ", array[elem]);
            }
            System.out.println();
        } else {
            System.out.println("The array is too short.");
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return (T)array[index];
    }

    public int size() {
        return size;
    }
}


public class Task2 {
    public static void main(String[] args) {
        GenericArray<Integer> intArray = new GenericArray<>(7);
        for (int i=1; i<8; i++){
            intArray.add(i);
        }

        int elementAtIndex1 = intArray.get(1);
        System.out.println("Элемент под индексом 1: " + elementAtIndex1);

        System.out.print("Первые пять элементов: ");
        intArray.FiveFirst();

        GenericArray<String> strArray = new GenericArray<>(3);
        strArray.add("Hello");
        strArray.add("World");

        String elementAtIndex0 = strArray.get(0);
        System.out.println("Элемент под индексом 0: " + elementAtIndex0);
        System.out.print("Первые пять элементов: ");
        strArray.FiveFirst();
    }
}
