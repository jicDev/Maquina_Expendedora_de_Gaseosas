package graficos;

import entidades.Gaseosa;
import servicios.GaseosaServicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrarGaseosa extends JPanel {

    private JTextField completarMarca;
    private Handler handler;

    public BorrarGaseosa() {

        iniciar();

    }

    private void iniciar() {

        setLayout(new GridLayout(1, 1));

        JLabel titulo = new JLabel("Borrar una gaseosa.", SwingConstants.CENTER);
        add(titulo);

        JLabel nombre = new JLabel("Marca: ", SwingConstants.RIGHT);
        add(nombre);

        completarMarca = new JTextField();
        add(completarMarca);

        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(new AceptarListener());
        add(aceptar);

    }

    private class AceptarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            Gaseosa gaseosa = new Gaseosa(completarMarca.getText());
            handler = new Handler(gaseosa);
            handler.borrar();

        }
    }
}
