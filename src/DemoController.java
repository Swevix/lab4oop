import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public final class DemoController {
    private final DemoView view;

    public DemoController(DemoView view) {
        this.view = view;
        view.countries.addActionListener(event -> {
            updateCountry();
            view.status.setText("ActionListener: выбрана страна «" + view.countries.getSelectedItem() + "».");
        });
        for (javax.swing.JCheckBox check : new javax.swing.JCheckBox[] {
                view.cheese, view.mushrooms, view.delivery}) {
            check.addItemListener(event -> {
                updatePrice();
                view.status.setText("ItemListener: «" + check.getText() + "» — "
                        + (check.isSelected() ? "выбрано." : "снято."));
            });
        }
        view.text.addKeyListener(new KeyAdapter() {
            @Override public void keyReleased(KeyEvent event) {
                updateText();
                view.status.setText("KeyListener: клавиша отпущена; строка проверена.");
            }
        });
        view.text.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent event) { changed(); }
            public void removeUpdate(DocumentEvent event) { changed(); }
            public void changedUpdate(DocumentEvent event) { changed(); }
            private void changed() {
                updateText();
                view.status.setText("DocumentListener: содержимое текстового поля изменено.");
            }
        });
        updateCountry();
        updatePrice();
        updateText();
    }

    private void updateCountry() {
        DemoModel.Country country = (DemoModel.Country) view.countries.getSelectedItem();
        view.countryResult.setText("Столица: " + country.capital + "    ·    Валюта: " + country.currency);
    }

    private void updatePrice() {
        view.priceResult.setText("Итого: " + DemoModel.price(view.cheese.isSelected(),
                view.mushrooms.isSelected(), view.delivery.isSelected()) + " ₽");
    }

    private void updateText() {
        String value = view.text.getText();
        view.textResult.setText("Символов: " + DemoModel.length(value) + "    ·    "
                + DemoModel.classify(value) + "    (≤ 5 / ≤ 10 / > 10)");
    }
}
