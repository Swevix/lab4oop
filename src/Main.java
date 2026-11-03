import java.awt.Font;
import javax.swing.*;

public final class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            configureLookAndFeel();
            DemoView view = new DemoView();
            new DemoController(view);
            JFrame frame = new JFrame("Лабораторная работа № 4 — события элементов управления");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(view);
            frame.pack();
            frame.setMinimumSize(frame.getSize());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    static void configureLookAndFeel() {
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); }
        catch (Exception error) { throw new IllegalStateException(error); }
        for (Object key : UIManager.getDefaults().keySet().toArray()) {
            if (UIManager.get(key) instanceof Font) {
                UIManager.put(key, new javax.swing.plaf.FontUIResource("SansSerif", Font.PLAIN, 15));
            }
        }
    }
}
