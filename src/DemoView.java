import java.awt.*;
import javax.swing.*;

public final class DemoView extends JPanel {
    final JComboBox<DemoModel.Country> countries = new JComboBox<>(DemoModel.Country.values());
    final JLabel countryResult = new JLabel();
    final JCheckBox cheese = new JCheckBox("Сыр +80 ₽");
    final JCheckBox mushrooms = new JCheckBox("Грибы +60 ₽");
    final JCheckBox delivery = new JCheckBox("Доставка +150 ₽");
    final JLabel priceResult = new JLabel();
    final JTextField text = new JTextField();
    final JLabel textResult = new JLabel();
    final JLabel status = new JLabel("Измените любой элемент — результат обновится автоматически.");

    public DemoView() {
        setLayout(new BorderLayout(0, 18));
        setBorder(BorderFactory.createEmptyBorder(24, 28, 22, 28));
        setBackground(new Color(240, 244, 250));
        setPreferredSize(new Dimension(800, 610));
        JLabel title = new JLabel("Лабораторная № 4 · Обработка событий");
        title.setFont(new Font("SansSerif", Font.BOLD, 25));
        add(title, BorderLayout.NORTH);
        JPanel cards = new JPanel(new GridLayout(3, 1, 0, 14));
        cards.setOpaque(false);
        JPanel country = card("01   ComboBox — сведения о стране");
        country.add(countries);
        country.add(countryResult);
        cards.add(country);
        JPanel order = card("02   CheckBox — стоимость заказа (основа 400 ₽)");
        JPanel options = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        options.setOpaque(false);
        for (JCheckBox check : new JCheckBox[] {cheese, mushrooms, delivery}) {
            check.setOpaque(false);
            options.add(check);
        }
        order.add(options);
        order.add(priceResult);
        cards.add(order);
        JPanel input = card("03   Текстовое поле — длина строки");
        input.add(text);
        input.add(textResult);
        cards.add(input);
        add(cards, BorderLayout.CENTER);
        status.setFont(new Font("SansSerif", Font.PLAIN, 13));
        add(status, BorderLayout.SOUTH);
    }

    private JPanel card(String heading) {
        JPanel panel = new JPanel(new GridLayout(3, 1, 0, 8));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(215, 224, 237)),
                BorderFactory.createEmptyBorder(12, 16, 12, 16)));
        JLabel title = new JLabel(heading);
        title.setFont(new Font("SansSerif", Font.BOLD, 16));
        panel.add(title);
        return panel;
    }
}
