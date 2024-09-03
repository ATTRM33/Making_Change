import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private Register register = new Register();
    private JPanel inputPanel = new JPanel();
    private JTextField input = new JTextField(10);
    private PursePanel changePanel = new PursePanel();

    public RegisterPanel() {
        setLayout(new BorderLayout()); // Use BorderLayout for better control over layout
        inputPanel.add(new JLabel("Enter Amount:"));
        inputPanel.add(input);
        add(inputPanel, BorderLayout.NORTH);

        input.addActionListener(new InputListener());

        add(changePanel, BorderLayout.CENTER);

    }

    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double amt = Double.parseDouble(input.getText());
            Purse change = register.makeChange(amt);
            changePanel.setPurse(change);
            changePanel.repaint();

        }
    }
}
