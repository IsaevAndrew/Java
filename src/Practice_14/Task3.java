package Practice_14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст с ценами:");
        String inputText = scanner.nextLine();
        String regexUSD = "\\b(\\d+\\.\\d{1,2}) USD\\b";
        String regexRUB = "\\b(\\d+\\.\\d{1,2}) RUB\\b";
        String regexEU = "\\b(\\d+\\.\\d{1,2}) EU\\b";
        Pattern patternUSD = Pattern.compile(regexUSD);
        Pattern patternRUB = Pattern.compile(regexRUB);
        Pattern patternEU = Pattern.compile(regexEU);
        Matcher matcherUSD = patternUSD.matcher(inputText);
        Matcher matcherRUB = patternRUB.matcher(inputText);
        Matcher matcherEU = patternEU.matcher(inputText);
        boolean found = false;
        if (matcherUSD.find()) {
            System.out.println("Цена в USD: " + matcherUSD.group(1));
            found = true;
        }
        if (matcherRUB.find()) {
            System.out.println("Цена в RUB: " + matcherRUB.group(1));
            found = true;
        }
        if (matcherEU.find()) {
            System.out.println("Цена в EU: " + matcherEU.group(1));
            found = true;
        }
        if (!found) {
            System.out.println("Ошибка: Неправильный формат цены.");
        }
    }
}
