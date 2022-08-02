import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class userPanel extends JFrame {
    private JPanel userPanel;
    private JButton survey1Button;
    private JButton survey2Button;
    private JButton backToMainPageButton;

    public userPanel(String SSN){

        survey1Button.setText(getSurveyName().get(0)+"("+getSurveyDes().get(0)+")");
        survey2Button.setText(getSurveyName().get(1)+"("+getSurveyDes().get(1)+")");


        setContentPane(userPanel);
        setTitle("User Panel");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        backToMainPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel mainPanel = new mainPanel();
                mainPanel.setVisible(true);
                setVisible(false);
            }
        });
        survey1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                surveyPage1 surveyPage1 = new surveyPage1(SSN);
                surveyPage1.setVisible(true);
                setVisible(false);
            }
        });
        survey2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                surveyPage2 surveyPage2 = new surveyPage2(SSN);
                surveyPage2.setVisible(true);
                setVisible(false);
            }
        });
    }
    public List<String> getSurveyName(){
        List<String> list=new ArrayList<String>();

        try {
            //connection with database
            Class.forName("org.sqlite.JDBC");
            java.sql.Connection connection = DriverManager.getConnection("jdbc:sqlite:data.sqlite");
            java.sql.Statement statement = connection.createStatement();
            //survey name query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM surveyy");
            while (resultSet.next()){
                list.add(resultSet.getString("Survey_name"));

            }
        }
        catch (Exception ioException){
            ioException.printStackTrace();
        }
        return list;
    }
    public List<String> getSurveyDes(){
        List<String> list=new ArrayList<String>();

        try {
            Class.forName("org.sqlite.JDBC");
            java.sql.Connection connection = DriverManager.getConnection("jdbc:sqlite:data.sqlite");
            java.sql.Statement statement = connection.createStatement();
            //survey description query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM surveyy");
            while (resultSet.next()){
                list.add(resultSet.getString("Survey_des"));

            }
        }
        catch (Exception ioException){
            ioException.printStackTrace();
        }
        return list;
    }
}
