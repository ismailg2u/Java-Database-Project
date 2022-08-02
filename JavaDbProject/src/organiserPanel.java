import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class organiserPanel extends JFrame {
    private JPanel organiserPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton loginButton;
    private JButton backToMainPageButton;

    public organiserPanel(){
        // initialize panel settings
        setContentPane(organiserPanel);
        setTitle("Organiser Panel");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        backToMainPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // back to main page button
                mainPanel mainPanel = new mainPanel();
                mainPanel.setVisible(true);
                setVisible(false);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = textField1.getText();
                String password = textField2.getText();
                //this code is our login system it checks email and password correct or not
                if (getEmail().get(0).equals(userName) && getPassword().get(0).equals(password) || getEmail().get(1).equals(userName) && getPassword().get(1).equals(password)){
                   organiserMainPanel organiserMainPanel = new organiserMainPanel();
                   organiserMainPanel.setVisible(true);
                   setVisible(false);

                }
                else {
                    JOptionPane.showMessageDialog(null,"Wrong email or password");
                }


            }
        });
    }
    //this function provides that gets email information from our database
    public List<String> getEmail(){
        List<String> list=new ArrayList<String>();

        try {
            //connection with our local database
            Class.forName("org.sqlite.JDBC");
            java.sql.Connection connection = DriverManager.getConnection("jdbc:sqlite:data.sqlite");
            java.sql.Statement statement = connection.createStatement();
            //email query code
            ResultSet resultSet = statement.executeQuery("SELECT * FROM organiser");
            while (resultSet.next()){
                list.add(resultSet.getString("Email"));

            }
        }
        catch (Exception ioException){
            ioException.printStackTrace();
        }
        return list;
    }
    public List<String> getPassword(){
        List<String> list=new ArrayList<String>();

        try {
            //connection with our local database
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:data.sqlite");
            Statement statement = connection.createStatement();
            //password query code
            ResultSet resultSet = statement.executeQuery("SELECT * FROM organiser");
            while (resultSet.next()){
                list.add(resultSet.getString("Password"));

            }
        }
        catch (Exception ioException){
            ioException.printStackTrace();
        }
        return list;
    }
}
