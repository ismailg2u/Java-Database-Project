import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class organiserMainPanel extends JFrame {
    private JPanel organiserMainPanel;
    private JButton showStaticsButton;
    private JButton backButton;

    public organiserMainPanel() {
        setContentPane(organiserMainPanel);
        setTitle("Organiser Panel");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        showStaticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //show statics button
                organiserStaticsPanel organiserStaticsPanel = new organiserStaticsPanel();
                organiserStaticsPanel.setVisible(true);
                setVisible(false);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //back button
                organiserPanel organiserPanel = new organiserPanel();
                organiserPanel.setVisible(true);
                setVisible(false);
            }
        });
    }
}
