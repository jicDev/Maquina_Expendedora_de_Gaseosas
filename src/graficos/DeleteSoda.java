package graficos;

import entidades.Soda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteSoda extends JPanel {
    private JTextField completeBrand;
    private Handler handler;

    public DeleteSoda() {
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 1));

        JLabel title = new JLabel("Borrar una gaseosa.", SwingConstants.CENTER);
        add(title);

        JLabel brand = new JLabel("Marca: ", SwingConstants.RIGHT);
        add(brand);

        completeBrand = new JTextField();
        add(completeBrand);

        JButton accept = new JButton("Aceptar");
        accept.addActionListener(new AcceptListener());
        add(accept);
    }

    private class AcceptListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            Soda soda = new Soda(completeBrand.getText());
            handler = new Handler(soda);
            handler.delete();
        }
    }
}
