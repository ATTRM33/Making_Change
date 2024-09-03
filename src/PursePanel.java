import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse;

    public PursePanel() {
        this.purse = new Purse(); // Initialize with an empty purse
    }

    public void setPurse(Purse purse) {
        this.purse = purse;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Purse Contents:", 10, 20);
        int y = 40;

        for (Map.Entry<MoneyType, Integer> entry : purse.getCash().entrySet()) {
            String displayText = entry.getValue() + " x " + entry.getKey().name() + " (" + entry.getKey().form() + ") - $" + entry.getKey().amt() + " each";
            g.drawString(displayText, 10, y);
            y += 20;
        }

        g.drawString("Total Value: $" + purse.getValue(), 10, y + 20);
    }
}
