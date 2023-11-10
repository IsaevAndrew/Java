package Practice_3;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Converter {
    public double convert(double amount, String toCurrency) {
        double convertedAmount = -1;
        if ("юань".equalsIgnoreCase(toCurrency)) {
            convertedAmount = amount / 13.34;
        } else if ("доллар".equalsIgnoreCase(toCurrency)) {
            convertedAmount = amount / 97.54;
        } else if ("евро".equalsIgnoreCase(toCurrency)) {
            convertedAmount = amount / 104.9;
        }
        return convertedAmount;
    }

    public void convert_print(double amount, String toCurrency) {
        double convertedAmount;
        if ("юань".equalsIgnoreCase(toCurrency)) {
            NumberFormat numberFormat1 = NumberFormat.getCurrencyInstance(Locale.CHINA);
            System.out.println("Сумма в выбранной валюте: " + numberFormat1.format(amount / 13.34));
        } else if ("доллар".equalsIgnoreCase(toCurrency)) {
            NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance(Locale.US);
            System.out.println("Сумма в выбранной валюте: " + numberFormat2.format(amount / 97.54));
        } else if ("евро".equalsIgnoreCase(toCurrency)) {
            NumberFormat numberFormat3 = NumberFormat.getCurrencyInstance(Locale.FRANCE);
            System.out.println("Сумма в выбранной валюте: " + numberFormat3.format(amount / 104.9));
        } else {
            System.out.println("Вы ввели неправильную валюту");
        }
    }

    public static void main(String[] args) {
        Converter converter = new Converter();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сумму в рублях: ");
        double amountInRubles = scanner.nextDouble();
        System.out.println("Выберите валюту для конвертации (Юань, Доллар, Евро): ");
        String toCurrency = scanner.next().toLowerCase();
        converter.convert_print(amountInRubles, toCurrency);
    }
}
