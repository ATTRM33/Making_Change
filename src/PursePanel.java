import money.MoneyType;
import purse.Purse;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Objects;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();

    public PursePanel() {
        
        this.purse = new Purse();
    }

    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (purse != null) {
            int y = 20;
            for (Map.Entry<MoneyType, Integer> entry : purse.getCash().entrySet()) {
                MoneyType moneyType = entry.getKey();
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/" + moneyType.img())));
                Image image = icon.getImage();

                g.drawImage(image, 10, y, this);
                g.drawString(entry.getValue() + " X " + moneyType.name(), 550, y + 30);
                y += 60;
            }
            g.drawString("Total Value: $" + purse.getValue(), 550, y= 400);
        }
    }
}


