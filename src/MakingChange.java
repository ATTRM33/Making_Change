import javax.swing.*;

public class MakingChange {
    public static void main(String[] args) {

        JFrame jframe = new JFrame("Making Change");
        jframe.setSize(700, 700);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RegisterPanel registerPanel = new RegisterPanel();
        jframe.add(registerPanel);

        jframe.setVisible(true);
    }
}
