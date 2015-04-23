import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.*;

/**
 * Created by jolyma on 23.04.2015.
 */
public class window extends JPanel {

    public static void main (String[] args) {
        JFrame chatWindow = new JFrame();
        chatWindow.setContentPane(new window());
        chatWindow.pack();
        chatWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Constructor
    public window() {
        JPanel panelContainer = new JPanel();
        JPanel panelUser = new JPanel();
        JTextPane chatPane = new JTextPane();
        JPanel panelWriting = new JPanel();


        setPreferredSize(new java.awt.Dimension(512, 400));

        panelContainer.setBackground(new Color(0, 0, 0, 1));
        panelContainer.setLayout(new java.awt.BorderLayout());

        panelContainer.add(chatPane, CENTER);
        panelContainer.add(panelUser, EAST);
        panelContainer.add(panelWriting, SOUTH);

    }
}
