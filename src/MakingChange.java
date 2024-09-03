import javax.swing.*;

public class MakingChange {
    public static void main(String[] args) {

        JFrame jframe = new JFrame("Making Change");
        jframe.setSize(400, 400);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RegisterPanel registerPanel = new RegisterPanel();
        jframe.add(registerPanel);

        jframe.setVisible(true);
    }
}
