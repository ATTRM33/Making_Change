import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();

    public PursePanel() {
        this.purse = new Purse(); // Initialize with an empty purse
    }

    public void setPurse(Purse purse) {
        this.purse = purse;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (purse != null) {

            // Start drawing images from y=20, increase after each image
            int y = 20;
            for (Map.Entry<MoneyType, Integer> entry : purse.getCash().entrySet()) {
                MoneyType moneyType = entry.getKey();
                Integer count = entry.getValue();

                // Load image
                ImageIcon icon = new ImageIcon(getClass().getResource("/" + moneyType.img()));
                Image image = icon.getImage();


                if (image != null) {
                    g.drawImage(image, 10, y, this);

                    // Display the text next to the image
                    g.drawString(count + " x " + moneyType.name(), 10 + image.getWidth(null) + 5, y + image.getHeight(null) / 2);

                    y += image.getHeight(null) + 10;
                }
            }
            g.drawString("Total Value: $" + purse.getValue(), 10, y + 20);
        }
    }
}


