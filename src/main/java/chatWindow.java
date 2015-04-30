import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton emoteButton;
    private JTextArea messageWriter;
    private JScrollPane messageScroll;
    private JTextArea usersList;

    public chatWindow(){
        super();

        setContentPane(panelContainer);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Document doc = chatPane.getDocument();
                try {
                    doc.insertString(doc.getLength(), "Moi : " + messageWriter.getText() + "\n", chatPane.getStyle("default"));
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }

                messageWriter.setText(null);
            }
        });
    }

    public void writeMessageRecived(String msg){
        Document doc = chatPane.getDocument();
        try {
            doc.insertString(doc.getLength(), msg + "\n", chatPane.getStyle("default"));
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }

        messageWriter.setText(null);
    }

}
