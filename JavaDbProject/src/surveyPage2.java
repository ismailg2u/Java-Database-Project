import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class surveyPage2 extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton sendButton;
    private JButton backToButton;
    private JLabel q1;
    private JLabel q2;
    private JLabel q3;
    private JLabel q4;
    private JLabel q5;
    private JPanel surveyPage2;

    public surveyPage2(String ssn) {
        q1.setText(getQuestions().get(5));
        q2.setText(getQuestions().get(6));
        q3.setText(getQuestions().get(7));
        q4.setText(getQuestions().get(8));
        q5.setText(getQuestions().get(9));
        setContentPane(surveyPage2);
        setTitle("User Panel");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        backToButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPanel userPanel = new userPanel(ssn);
                userPanel.setVisible(true);
                setVisible(false);
            }
        });
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q1Answer = textField1.getText();
                String q2Answer = textField2.getText();
                String q3Answer = textField3.getText();
                String q4Answer = textField4.getText();
                String q5Answer = textField5.getText();
                int id1= Integer.parseInt(getResponseid().get(getResponseid().size()-1)) +2 ;
                response(id1,q1Answer,"6",ssn);
                int id2= Integer.parseInt(getResponseid().get(getResponseid().size()-1)) +2;
                response(id2,q2Answer,"7",ssn);
                int id3= Integer.parseInt(getResponseid().get(getResponseid().size()-1))+2;
                response(id3,q3Answer,"8",ssn);
                int id4= Integer.parseInt(getResponseid().get(getResponseid().size()-1))+2;
                response(id4,q4Answer,"9",ssn);
                int id5= Integer.parseInt(getResponseid().get(getResponseid().size()-1))+2;
                response(id5,q5Answer,"10",ssn);
                JOptionPane.showMessageDialog(null,"Send");
                userPanel userPanel = new userPanel(ssn);
                userPanel.setVisible(true);
                setVisible(false);
            }
        });
    }
    public List<String> getQuestions( ){
        List<String> list=new ArrayList<String>();

        try {
            Class.forName("org.sqlite.JDBC");
            java.sql.Connection connection = DriverManager.getConnection("jdbc:sqlite:data.sqlite");
            java.sql.Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM questions");

            while (resultSet.next()){
                list.add(resultSet.getString("Description"));

            }
        }
        catch (Exception ioException){
            ioException.printStackTrace();
        }
        return list;
    }
    public List<String> getResponseid( ){
        List<String> list=new ArrayList<String>();
        try {
            Class.forName("org.sqlite.JDBC");
            java.sql.Connection connection = DriverManager.getConnection("jdbc:sqlite:data.sqlite");
            java.sql.Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM responses");

            while (resultSet.next()){
                list.add((resultSet.getString("Responses_id")));

            }
        }
        catch (Exception ioException){
            ioException.printStackTrace();
        }
        return list;
    }
    public void response(int Responses_idInt, String Answer ,String Question_id,  String SSN ){

        try {
            String Responses_id = String.valueOf(Responses_idInt);
            Class.forName("org.sqlite.JDBC");
            java.sql.Connection connection = DriverManager.getConnection("jdbc:sqlite:data.sqlite");
            java.sql.Statement statement = connection.createStatement();
            String sql = " insert into responses (`Responses_id`, `Answer`, `Question_id`, `SSN`)"
                    + " values (?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString (1, Responses_id);
            preparedStmt.setString (2, Answer);
            preparedStmt.setString(3, Question_id);
            preparedStmt.setString    (4, SSN);
            preparedStmt.execute();


        }
        catch (Exception ioException){
            ioException.printStackTrace();
        }
    }
}
