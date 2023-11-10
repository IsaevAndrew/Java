package Practice_13;

class PhoneNumberFormatter {
    private String formattedNumber;

    public PhoneNumberFormatter(String phoneNumber) {
        formattedNumber = formatPhoneNumber(phoneNumber);
    }

    public String getFormattedNumber() {
        return formattedNumber;
    }

    private String formatPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("[^0-9]", ""); // Удаление всех символов, кроме цифр

        if (phoneNumber.length() == 11 && phoneNumber.startsWith("8")) {
            phoneNumber = "+7" + phoneNumber.substring(1);
        } else if (!phoneNumber.startsWith("+")) {
            phoneNumber = "+" + phoneNumber;
        }

        return phoneNumber.substring(0, phoneNumber.length()-7) + "-" + phoneNumber.substring(phoneNumber.length()-7, phoneNumber.length()-4) + "-" + phoneNumber.substring(phoneNumber.length()-4);

    }
}

public class Task5 {
    public static void main(String[] args) {
        String phoneNumber1 = "+79175655655";
        String phoneNumber2 = "+104289652211";
        String phoneNumber3 = "89175655655";

        PhoneNumberFormatter formatter1 = new PhoneNumberFormatter(phoneNumber1);
        PhoneNumberFormatter formatter2 = new PhoneNumberFormatter(phoneNumber2);
        PhoneNumberFormatter formatter3 = new PhoneNumberFormatter(phoneNumber3);

        System.out.println(formatter1.getFormattedNumber());
        System.out.println(formatter2.getFormattedNumber());
        System.out.println(formatter3.getFormattedNumber());
    }
}
