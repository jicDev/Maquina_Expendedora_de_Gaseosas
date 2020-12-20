package graficos;

import entidades.Soda;
import excepciones.ExceptionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertSoda extends JPanel {
    private JTextField completeBrand;
    private JTextField completeCompany;
    private JTextField completeStock;
    private Handler handler;

    public InsertSoda() {
        Init();
    }

    private void Init() {
        setLayout(new GridLayout(5, 2));

        JLabel title = new JLabel("Ingresar nueva gaseosa", SwingConstants.CENTER);
        add(title);

        JLabel emptyTitle = new JLabel();
        add(emptyTitle);

        JLabel brand = new JLabel("Marca: ", SwingConstants.RIGHT);
        add(brand);

        completeBrand = new JTextField();
        add(completeBrand);

        JLabel company = new JLabel("Producto: ", SwingConstants.RIGHT);
        add(company);

        completeCompany = new JTextField();
        add(completeCompany);

        JLabel stock = new JLabel("Stock: ", SwingConstants.RIGHT);
        add(stock);

        completeStock = new JTextField();
        add(completeStock);

        JLabel emptyAccept = new JLabel();
        add(emptyAccept);

        JButton accept = new JButton("Aceptar");
        accept.addActionListener(new AcceptListener());
        add(accept);
    }

    public class AcceptListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                Soda soda = new Soda(completeBrand.getText(), completeCompany.getText(), Integer.parseInt(completeStock.getText()));
                handler = new Handler();
                handler.Insertar(soda);
            } catch (NumberFormatException e) {
                try {
                    throw new ExceptionManager("Error al pasar string a numero.");
                } catch (ExceptionManager s) {}
            } catch (ExceptionManager e) {}
        }
    }
}
