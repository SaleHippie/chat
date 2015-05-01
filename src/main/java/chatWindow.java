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
                String message = messageWriter.getText();
                try {
                    doc.insertString(doc.getLength(), message + "\n", chatPane.getStyle("default"));
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }

              /*  PrintWriter prt = null;

                try {
                    prt = new PrintWriter(String.valueOf(ChannelOutboundBuffer.class));
                    prt.println("[" + main.pseudo + "] " + message + "\r\n");
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }

                //  BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

                //try {
                   /* out.write("[" + main.pseudo + "] " + message + "\r\n");
                    out.newLine();
                    out.flush();*/


             /*   } catch (IOException e1) {
                    try {
                        doc.insertString(doc.getLength(), "message perdu", chatPane.getStyle("default"));
                    } catch (BadLocationException e2) {
                        e2.printStackTrace();
                    }
                }**/
                main.send(message);
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
