import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainPanel extends JFrame {


    private JPanel panel1;
    private JButton iAmOrganiserButton;
    private JButton iAmAUserButton;

public mainPanel(){
    // initialize panel settings
    setContentPane(panel1);
    setTitle("Main Panel");
    setSize(500,500);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    iAmOrganiserButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // if you click "i am organiser button"
            //main panel closes and organiser panel opens
            organiserPanel organiserPanel = new organiserPanel();
            organiserPanel.setVisible(true);
            setVisible(false);

        }
    });
    iAmAUserButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // if you click "i am user button"
            //main panel closes and organiser panel opens
            userInfoPanel userInfoPanel = new userInfoPanel();
            userInfoPanel.setVisible(true);
            setVisible(false);
        }
    });
}

    public static void main(String[] args) {
        mainPanel mainPanel = new mainPanel();
    }
}

