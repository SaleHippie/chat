import javax.swing.*;

/**
 * Created by jolyma on 23.04.2015.
 */
public class window extends JPanel {

    private static chatWindow client = new chatWindow();

    public static void main (String[] args) throws Exception{


        client.setVisible(true);


        new Client("localhost",8000).run();
    }

    public void showMessageRecived(String msg){
        client.writeMessageRecived(msg);
    }
}
