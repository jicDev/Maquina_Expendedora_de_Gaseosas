package graficos;

import entidades.Gaseosa;
import excepciones.MiException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertarGaseosa extends JPanel {

    private JTextField completarMarca;
    private JTextField completarProductor;
    private JTextField completarStock;
    private Handler handler;

    public InsertarGaseosa() {

        iniciar();

    }

    private void iniciar() {

        setLayout(new GridLayout(5, 2));

        JLabel titulo = new JLabel("Ingresar nueva gaseosa", SwingConstants.CENTER);
        add(titulo);

        JLabel vacio = new JLabel();
        add(vacio);

        JLabel nombre = new JLabel("Marca: ", SwingConstants.RIGHT);
        add(nombre);

        completarMarca = new JTextField();
        add(completarMarca);

        JLabel mail = new JLabel("Productor: ", SwingConstants.RIGHT);
        add(mail);

        completarProductor = new JTextField();
        add(completarProductor);

        JLabel contrasena = new JLabel("Stock: ", SwingConstants.RIGHT);
        add(contrasena);

        completarStock = new JTextField();
        add(completarStock);

        JLabel vacio2 = new JLabel();
        add(vacio2);

        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(new AceptarListener());
        add(aceptar);


    }

    public class AceptarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            try {
                Gaseosa gaseosa = new Gaseosa(completarMarca.getText(), completarProductor.getText(), Integer.parseInt(completarStock.getText()));
                handler = new Handler(gaseosa);
                handler.insertar();
            } catch (NumberFormatException e) {
                try {
                    throw new MiException("Error al pasar string a numero.");
                } catch (MiException s) {

                }
            } catch (MiException e) {

            }
        }
    }
}
