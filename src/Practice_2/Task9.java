package Practice_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество игроков: ");
        int n = scanner.nextInt();
        List<String> deck = initializeDeck();
        shuffleDeck(deck);
        for (int i = 0; i < n; i++) {
            System.out.println("Игрок " + (i + 1) + " получает карты:");
            for (int j = 0; j < 5; j++) {
                String card = deck.remove(0);
                System.out.println(card);
            }
            System.out.println();
        }
    }
    private static List<String> initializeDeck() {
        List<String> deck = new ArrayList<>();
        String[] suits = {"Черви", "Бубны", "Трефы", "Пики"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Валет", "Дама", "Король", "Туз"};
        for (String suit : suits) {
            for (String rank : ranks) {
                String card = rank + " " + suit;
                deck.add(card);
            }
        }
        return deck;
    }
    private static void shuffleDeck(List<String> deck) {
        Collections.shuffle(deck);
    }
}
