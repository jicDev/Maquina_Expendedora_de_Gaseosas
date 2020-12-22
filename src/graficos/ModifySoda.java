package graficos;

import entidades.Soda;
import excepciones.ExceptionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifySoda extends JPanel {
    private JTextField completeBrand;
    private JTextField completeCompany;
    private JTextField completeStock;
    private final Handler handler;

    public ModifySoda(Handler handler) {
        this.handler = handler;
        Init();
    }

    private void Init() {
        setLayout(new GridLayout(5, 2));

        JLabel title = new JLabel("Modificar una gaseosa", SwingConstants.CENTER);
        add(title);

        JLabel emptyTitle = new JLabel();
        add(emptyTitle);

        JLabel brand = new JLabel("Marca de la gaseosa a modificar: ", SwingConstants.RIGHT);
        add(brand);

        completeBrand = new JTextField();
        add(completeBrand);

        JLabel company = new JLabel("Producto nuevo: ", SwingConstants.RIGHT);
        add(company);

        completeCompany = new JTextField();
        add(completeCompany);

        JLabel stock = new JLabel("Stock nuevo: ", SwingConstants.RIGHT);
        add(stock);

        completeStock = new JTextField();
        add(completeStock);

        JLabel emptyAccept = new JLabel();
        add(emptyAccept);

        JButton accept = new JButton("Aceptar");
        accept.addActionListener(new AcceptListener());
        add(accept);
    }

    private class AcceptListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                Soda soda = new Soda(completeBrand.getText(), completeCompany.getText(), Integer.parseInt(completeStock.getText()));
                handler.Modify(soda);
                handler.ListSoda();
            } catch (NumberFormatException e) {
                try {
                    throw new ExceptionManager("Error al pasar string a numero.");
                } catch (ExceptionManager e1) {}
            }
        }
    }
}
