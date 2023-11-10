package Practice_3;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class OnlineStore {
    private Map<String, Double> products;

    public OnlineStore() {
        products = new HashMap<>();
        products.put("молоко", 100.0);
        products.put("чипсы", 200.0);
        products.put("кекс", 300.0);
    }

    private Locale getLocaleByCurrency(String currency) {
        switch (currency.toLowerCase()) {
            case "юань":
                return Locale.CHINA;
            case "доллар":
                return Locale.US;
            case "евро":
                return Locale.FRANCE;
            default:
                return Locale.getDefault();
        }
    }

    public void purchaseProduct(String productName, double amount, String chosenCurrency) {
        if (products.containsKey(productName)) {
            double priceInRubles = products.get(productName);
            double convertedAmount = new Converter().convert(priceInRubles, chosenCurrency);
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(getLocaleByCurrency(chosenCurrency));
            if (convertedAmount <= amount) {
                System.out.println("Покупка товара " + productName + " успешно завершена!");
                System.out.println("Сдача: " + numberFormat.format(amount - convertedAmount));
            } else {
                System.out.println("Недостаточно средств для покупки " + productName);
            }
        } else {
            System.out.println("Такого товара не существует");
        }
    }

    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Доступные товары и их цены:");
        for (String productName : store.products.keySet()) {
            System.out.println(productName + ": " + store.products.get(productName) + " руб.");
        }

        System.out.print("Выберите товар для покупки: ");
        String selectedProduct = scanner.nextLine().toLowerCase();

        System.out.print("Выберите валюту для оплаты (Юань, Доллар, Евро): ");
        String chosenCurrency = scanner.next().toLowerCase();

        System.out.print("Введите сумму в выбранной валюте: ");
        double amount = scanner.nextDouble();

        store.purchaseProduct(selectedProduct, amount, chosenCurrency);

        scanner.close();
    }
}

