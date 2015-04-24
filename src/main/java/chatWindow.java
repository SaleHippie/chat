import javax.swing.*;
import java.awt.*;

/**
 * Created by jolyma on 24.04.2015.
 */
public class chatWindow extends JFrame{
    private JPanel panelContainer;
    private JTextPane chatPane;
    private JScrollPane chatContent;
    private JPanel panelWriting;
    private JPanel panelUser;
    private JButton sendButton;
    private JLabel usersList;
    private JButton emoteButton;
    private JTextArea messageWriter;
    private JScrollPane messageScroll;

    public chatWindow(){
        super();

        setContentPane(panelContainer);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
