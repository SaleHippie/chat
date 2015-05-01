import javax.swing.*;

/**
 * Created by jolyma on 23.04.2015.
 */
public class main extends JPanel {

    private static chatWindow clientForm = new chatWindow();
    public static String pseudo;
    private static Client client = new Client("localhost",8000);

    public static void main (String[] args) throws Exception{
        main.pseudo = "SaleHippie";


        clientForm.setVisible(true);
        client.run();
    }

    public void showMessageRecived(String msg){
        clientForm.writeMessageRecived(msg);
    }

    public static void send(String msg){
        client.channel.writeAndFlush("["+ pseudo + "] " + msg + "\r\n");
    }
}
