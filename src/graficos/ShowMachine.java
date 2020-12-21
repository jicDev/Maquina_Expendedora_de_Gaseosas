package graficos;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Vector;

public class ShowMachine extends JPanel {
    private Handler handler;
    private JLabel state;
    private JLabel sodaLabel;

    public ShowMachine() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        handler = new Handler();

        removeAll();
        add(StartLayout(), BorderLayout.PAGE_START);
        add(CenterLayout(), BorderLayout.CENTER);
        add(RightLayout(), BorderLayout.LINE_END);
        add(EndLayout(), BorderLayout.PAGE_END);
        validate();
        repaint();
        updateUI();
    }

    private JPanel StartLayout() {
        GridBagConstraints c = new GridBagConstraints();

        JPanel start = new JPanel();
        start.setLayout(new GridBagLayout());
        start.setBackground(Color.BLACK);

        BufferedImage upPicture;
        try {
            upPicture = ImageIO.read(getClass().getResource("/resources/images/up.jpg"));
            JLabel vendingMachineBrand = new JLabel(new ImageIcon(upPicture));
            c.insets = new Insets(10,10,10,10);
            c.gridx = 0;
            c.gridy = 0;
            c.anchor = GridBagConstraints.WEST;
            c.weightx = 1.0;
            start.add(vendingMachineBrand, c);
        } catch (IOException e) {
            e.printStackTrace();
        }

        state = new JLabel(" MAQUINA_LISTA ");
        c.insets = new Insets(10,10,10,10);
        c.gridx = 1;
        c.gridy = 0;
        state.setForeground(Color.WHITE);
        state.setFont(new Font(state.getName(), Font.PLAIN, 24));
        start.add(state, c);

        return start;
    }

    private JPanel CenterLayout() {
        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());
        center.setBackground(Color.RED);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 0;
        int count = 0;

        Vector<Vector> brands = handler.List();
        for(Vector brand : brands) {
            String brandString = (String)brand.firstElement();
            BufferedImage imageIcon;
            try {
                imageIcon = ImageIO.read(getClass().getResource(GetImage(brandString)));
                JButton brandButton = new JButton(new ImageIcon(imageIcon));
                brandButton.addActionListener(new SelectLisener(brandString));

                c.gridx = count % 2;
                c.gridy = count / 2;
                ++count;

                center.add(brandButton, c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return center;
    }

    private JPanel RightLayout() {
        GridBagConstraints c = new GridBagConstraints();

        JPanel right = new JPanel();
        right.setLayout(new GridBagLayout());
        right.setBackground(Color.BLACK);

        JButton addCoin = new JButton("Insertar Ficha");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 0;
        addCoin.addActionListener(new AddCoinLisener());
        right.add(addCoin, c);

        JButton returnCoin = new JButton("Devolver Ficha");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 1;
        returnCoin.addActionListener(new ReturnCoinLisener());
        right.add(returnCoin, c);

        JButton buy = new JButton("Comprar");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 2;
        buy.addActionListener(new BuySodaLisener());
        right.add(buy, c);

        return right;
    }

    private JPanel EndLayout() {
        GridBagConstraints c = new GridBagConstraints();

        JPanel end = new JPanel();
        end.setLayout(new GridBagLayout());
        end.setBackground(Color.BLACK);

        sodaLabel = new JLabel();
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 0;
        end.add(sodaLabel, c);

        JButton soda = new JButton("Agarrar gaseosa");
        c.insets = new Insets(10,10,10,10);
        c.gridx = 1;
        c.gridy = 0;
        soda.addActionListener(new RetrieveLisener());
        end.add(soda, c);

        return end;
    }

    public class AddCoinLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            handler.AddCoin();
            state.setText(handler.GetState());
        }
    }

    public class ReturnCoinLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            handler.ReturnCoin();
            state.setText(handler.GetState());
        }
    }

    public class SelectLisener implements ActionListener {
        private final String soda;

        public SelectLisener(String soda) {
            this.soda = soda;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            handler.SelectSoda(soda);
            state.setText(handler.GetState());
        }
    }

    public class BuySodaLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String brand = handler.BuySoda();
            state.setText(handler.GetState());

            BufferedImage cocacolaPicture;
            if (brand != null) {
                try {
                    cocacolaPicture = ImageIO.read(getClass().getResource(GetImage(brand)));
                    sodaLabel.setIcon(new ImageIcon(cocacolaPicture));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class RetrieveLisener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            handler.RetrieveSoda();
            state.setText(handler.GetState());
            sodaLabel.setIcon(null);
        }
    }

    private String GetImage(String brand) {
        if (brand.equalsIgnoreCase("Coca Cola")) {
            return "/resources/images/coca_cola.png";
        }
        if (brand.equalsIgnoreCase("Coca Cola Light")) {
            return "/resources/images/coca_cola_light.png";
        }
        if (brand.equalsIgnoreCase("Coca Cola Zero")) {
            return "/resources/images/coca_cola_zero.png";
        }
        if (brand.equalsIgnoreCase("Sprite")) {
            return "/resources/images/sprite.png";
        }

        return "/resources/images/not_found.png";
    }
}
