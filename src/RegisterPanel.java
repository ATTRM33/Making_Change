import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private Register register;
    private JPanel inputPanel;
    private JTextField input;
    private PursePanel changePanel;

    public RegisterPanel() {
        this.register = new Register();
        this.inputPanel = new JPanel();
        this.input = new JTextField();
        this.changePanel = new PursePanel();

        inputPanel.add(new JLabel("Enter an Amount:"));
        inputPanel.add(input);

        input.addActionListener(new InputListener());

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
