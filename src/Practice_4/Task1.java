package Practice_4;

enum Season {
    Spring(7),
    Summer(20) {
        @Override
        public String getDescription() {
            return "Теплое время года";
        }
    },
    Autumn(6),
    Winter(-7);

    private int averageTemperature;

    Season(int averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public String getDescription() {
        return "Холодное время года";
    }

    public String getFullDescription() {
        return getDescription() + " (" + averageTemperature + "°C)";
    }

    public static void describeMyFavoriteSeason(Season favoriteSeason) {
        switch (favoriteSeason) {
            case Spring:
                System.out.println("Я люблю весну!");
                break;
            case Summer:
                System.out.println("Я люблю лето!");
                break;
            case Autumn:
                System.out.println("Я люблю осень!");
                break;
            case Winter:
                System.out.println("Я люблю зиму!");
                break;
            default:
                System.out.println("У меня нет любимого времени года.");
                break;
        }
    }

    public static void printAllSeasons() {
        for (Season season : Season.values()) {
            System.out.println(season + ": " + season.getFullDescription());
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
        Season favoriteSeason = Season.Summer;
        System.out.println("Мое любимое время года: " + favoriteSeason);
        System.out.println("Информация о моем любимом времени года: " + favoriteSeason.getFullDescription());

        Season.describeMyFavoriteSeason(favoriteSeason);
        Season.printAllSeasons();
    }
}

