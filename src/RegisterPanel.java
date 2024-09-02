import javax.swing.*;
import java.awt.*;

public class RegisterPanel {
    private Register register;
    private JPanel inputPanel;
    private JTextField input;
    private PursePanel changePanel;

    public RegisterPanel() {
        this.register = new Register();
        this.inputPanel = new JPanel();
        this.input = new JTextField();
        this.changePanel = new PursePanel;
    }
}
