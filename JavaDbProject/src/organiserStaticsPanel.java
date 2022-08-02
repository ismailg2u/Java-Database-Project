import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class organiserStaticsPanel extends JFrame{
    private JPanel organiserStaticsPanel;
    private JButton backToButton;
    private JTable table1;
    private JButton showResponseStaticsButton;
    String[] columns = {"SSN", "Phone_num"," Fname", "Minit", "Lname", "Email", "Adress", "Gender"};

    public organiserStaticsPanel() {


        setContentPane(organiserStaticsPanel);
        setTitle("Organiser Panel");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        backToButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //back button
                organiserMainPanel organiserMainPanel = new organiserMainPanel();
                organiserMainPanel.setVisible(true);
                setVisible(false);

            }
        });
        showResponseStaticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                organiserResponseStatics organiserResponseStatics = new organiserResponseStatics();
                organiserResponseStatics.setVisible(true);
                setVisible(false);
            }
        });
    }

    private void createUIComponents() {

            //this code provides that see users
            // initialize table
            DefaultTableModel tableModel = new DefaultTableModel(0,8);
            tableModel.setColumnIdentifiers(columns);
            table1 = new JTable(tableModel);
            try {
                //connection with our database
                Class.forName("org.sqlite.JDBC");
                Connection connection = DriverManager.getConnection("jdbc:sqlite:data.sqlite");
                Statement statement = connection.createStatement();
                //user query from database
                ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
                while (resultSet.next()){
                    Object[] row = {String.valueOf(resultSet.getString("SSN")),String.valueOf(resultSet.getString("Phone_num")),
                            String.valueOf(resultSet.getString("Fname")),
                            String.valueOf(resultSet.getString("Minit")),String.valueOf(resultSet.getString("Lname")),
                            String.valueOf(resultSet.getString("Email"))
                            ,String.valueOf(resultSet.getString("Adress")),} ;

                    //add the table user information
                    tableModel.addRow(row);


                }
            }
            catch (Exception ioException){
                ioException.printStackTrace();



        }
    }
}
