package graficos;

import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        setBounds(100, 100, 550, 600);

        Menu menu = new Menu(new Handler(this));

        setJMenuBar(menu);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void ChangeMode(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        getContentPane().validate();
        getContentPane().repaint();
    }

}
