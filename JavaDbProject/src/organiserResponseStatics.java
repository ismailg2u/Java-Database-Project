import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class organiserResponseStatics extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private JButton backUserStaticsButton;
    String[] columns = {"Responses_id", "Answer", "Question_id", "SSN"};
    public organiserResponseStatics(){
        setContentPane(panel1);
        setTitle("Organiser Panel");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        backUserStaticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                organiserStaticsPanel organiserStaticsPanel = new organiserStaticsPanel();
                organiserStaticsPanel.setVisible(true);
                setVisible(false);
            }
        });
    }

    private void createUIComponents() {
        //initialize the table
        DefaultTableModel tableModel = new DefaultTableModel(0,8);
        tableModel.setColumnIdentifiers(columns);
        table1 = new JTable(tableModel);
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:data.sqlite");
            Statement statement = connection.createStatement();
            //responses query from database
            ResultSet resultSet = statement.executeQuery("SELECT * FROM responses");
            while (resultSet.next()){
                Object[] row = {String.valueOf(resultSet.getString("Responses_id")),String.valueOf(resultSet.getString("Answer")),
                        String.valueOf(resultSet.getString("Question_id")), String.valueOf(resultSet.getString("SSN"))} ;
                //add the table user information
                tableModel.addRow(row);


            }
        }
        catch (Exception ioException){
            ioException.printStackTrace();



        }
    }
}
