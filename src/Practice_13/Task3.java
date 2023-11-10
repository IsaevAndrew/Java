package Practice_13;

import java.util.StringTokenizer;

class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;

    public Address(String addressString) {
        StringTokenizer tokenizer = new StringTokenizer(addressString, ",.;-");

        if (tokenizer.hasMoreTokens()) {
            country = tokenizer.nextToken().trim();
        }
        if (tokenizer.hasMoreTokens()) {
            region = tokenizer.nextToken().trim();
        }
        if (tokenizer.hasMoreTokens()) {
            city = tokenizer.nextToken().trim();
        }
        if (tokenizer.hasMoreTokens()) {
            street = tokenizer.nextToken().trim();
        }
        if (tokenizer.hasMoreTokens()) {
            house = tokenizer.nextToken().trim();
        }
        if (tokenizer.hasMoreTokens()) {
            building = tokenizer.nextToken().trim();
        }
        if (tokenizer.hasMoreTokens()) {
            apartment = tokenizer.nextToken().trim();
        }
    }

    @Override
    public String toString() {
        return "Адрес:" +
                "страна='" + country + '\'' +
                ", регион='" + region + '\'' +
                ", город='" + city + '\'' +
                ", улица='" + street + '\'' +
                ", дом='" + house + '\'' +
                ", корпус='" + building + '\'' +
                ", квартира='" + apartment + '\'';
    }
}


public class Task3 {
    public static void main(String[] args) {
        String address1 = "Россия, Москва, Красная Площадь, 1, 2, 3, 4";
        String address2 = "США; Нью-Йорк; Уолл-стрит; 10; ; ; ";
        String address3 = "Германия. Берлин. Улица Фридриха, 5. ; ; 301";
        String address4 = "Франция-Париж-Эйфелева Башня-123-456-789-1011";

        Address addr1 = new Address(address1);
        Address addr2 = new Address(address2);
        Address addr3 = new Address(address3);
        Address addr4 = new Address(address4);

        System.out.println(addr1);
        System.out.println(addr2);
        System.out.println(addr3);
        System.out.println(addr4);
    }
}
