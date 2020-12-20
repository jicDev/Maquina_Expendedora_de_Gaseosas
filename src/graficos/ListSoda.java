package graficos;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ListSoda extends JPanel {
    private Handler handler;

    public ListSoda() {
        Init();
    }

    private void Init() {
        setLayout(new GridLayout(1, 1));
        handler = new Handler();

        Vector<Vector> rows = handler.List();

        Vector<String> columns = new Vector<>();
        columns.addElement("Marca");
        columns.addElement("Producto");
        columns.addElement("Stock");

        JTable table = new JTable(rows, columns);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setViewPosition(new Point(0, 0));

        removeAll();
        add(scrollPane);
        validate();
        repaint();
        updateUI();
    }
}
