package Practice_7;

interface StringManipulator {
    int countCharacters(String s);
    String oddPositionCharacters(String s);
    String reverseString(String s);
}

class StringManipulatorTest implements StringManipulator {
    public int countCharacters(String s) {
        return s.length();
    }

    public String oddPositionCharacters(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 != 0) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

}


public class Task6 {
    public static void main(String[] args) {
        StringManipulator manipulator = new StringManipulatorTest();
        String inputString = "Пример строки для тестирования";
        int count_symbols = manipulator.countCharacters(inputString);
        String oddPositionSymbols = manipulator.oddPositionCharacters(inputString);
        String reverse = manipulator.reverseString(inputString);
        System.out.println("Исходная строка: " + inputString);
        System.out.println("Количество символов: " + count_symbols);
        System.out.println("Символы на нечетных позициях: " + oddPositionSymbols);
        System.out.println("Инвертированная строка: " + reverse);
    }
}
