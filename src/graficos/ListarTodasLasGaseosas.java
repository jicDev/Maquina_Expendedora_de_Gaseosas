package graficos;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ListarTodasLasGaseosas extends JPanel {

    private Handler handler;

    public ListarTodasLasGaseosas() {

        iniciar();

    }

    private void iniciar() {

        setLayout(new GridLayout(1, 1));
        handler = new Handler();
        Vector<Vector> filas = handler.listar();

        Vector<String> nombreColumnas = new Vector<>();
        nombreColumnas.addElement("Marca");
        nombreColumnas.addElement("Producto");
        nombreColumnas.addElement("Stock");

        JTable table = new JTable(filas, nombreColumnas);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setViewPosition(new Point(0, 0));

        removeAll();
        add(scrollPane);
        validate();
        repaint();
        updateUI();
    }
}
