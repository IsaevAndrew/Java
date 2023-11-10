package Practice_6;

interface Printable {
    void print();
}

class Book implements Printable {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void print() {
        System.out.println("Название книги: " + title);
        System.out.println("Автор: " + author);
    }
}

class shop1 implements Printable {
    private String name;
    private String location;

    public shop1(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public void print() {
        System.out.println("Название магазина: " + name);
        System.out.println("Расположение: " + location);
    }
}


public class Task6_9 {
    public static void main(String[] args) {
        Printable[] printableItems = new Printable[4];
        printableItems[0] = new Book("Война и мир", "Лев Толстой");
        printableItems[1] = new shop1("Магнит", "Москва");
        printableItems[2] = new Book("Гарри Поттер и философский камень", "Джоан Роулинг");
        printableItems[3] = new shop1("Ашан", "Санкт-Петербург");

        for (Printable item : printableItems) {
            item.print();
            System.out.println();
        }
    }
}
