public final class DemoModel {
    public enum Country {
        RUSSIA("Россия", "Москва", "Российский рубль"),
        KAZAKHSTAN("Казахстан", "Астана", "Тенге"),
        JAPAN("Япония", "Токио", "Иена");

        public final String name;
        public final String capital;
        public final String currency;

        Country(String name, String capital, String currency) {
            this.name = name;
            this.capital = capital;
            this.currency = currency;
        }

        @Override public String toString() { return name; }
    }

    public static int price(boolean cheese, boolean mushrooms, boolean delivery) {
        return 400 + (cheese ? 80 : 0) + (mushrooms ? 60 : 0) + (delivery ? 150 : 0);
    }

    public static int length(String text) {
        return text.codePointCount(0, text.length());
    }

    public static String classify(String text) {
        int length = length(text);
        return length <= 5 ? "Короткая" : length <= 10 ? "Нормальная" : "Длинная";
    }
}
