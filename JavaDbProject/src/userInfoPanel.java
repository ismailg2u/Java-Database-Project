import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userInfoPanel extends JFrame{
    private JPanel userInfoPanel;
    private JTextField SSN;
    private JTextField email;
    private JTextField address;
    private JTextField gender;
    private JTextField birth;
    private JTextField mint;
    private JTextField lname;
    private JTextField phonenumv;
    private JTextField fname;
    private JButton countiuneButton;
    private JButton backToMainPageButton;

    public userInfoPanel() {
        JOptionPane.showMessageDialog(null,"If you have an account youcan just write your ssn number" +
                " otherwise fill the blanks");
        setContentPane(userInfoPanel);
        setTitle("User Panel");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        backToMainPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //back button
                mainPanel mainPanel = new mainPanel();
                mainPanel.setVisible(true);
                setVisible(false);
            }
        });
        countiuneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ssnText = SSN.getText();
                //checking the user's if it is already registered don't add new user
                for (int i = 0; i < getSSNS().size(); i++){
                    if (getSSNS().get(i).equals(ssnText)){
                        JOptionPane.showMessageDialog(null,"This user already registered");
                        userPanel userPanel = new userPanel(ssnText);
                        userPanel.setVisible(true);
                        setVisible(false);
                        break;

                    }
                }
                String fnameText = fname.getText();
                String lnameText = lname.getText();
                String phonenum = phonenumv.getText();

                if(phonenum.equals("")){
                    JOptionPane.showMessageDialog(null,"Phone number must be filled"
                            +"phone number must be integer");
                }
                int phoneNUmint = Integer.parseInt(phonenum);
                String mintText = mint.getText();
                String emailText = email.getText();
                String addressText = address.getText();
                String genderText = gender.getText();

               if(!ssnText.equals("") &&!fnameText.equals("")&&phonenumv!=null){
                for (int i = 0; i < getSSNS().size(); i++) {
                    if (!getSSNS().get(i).equals(ssnText)){
                        addNewUser(ssnText,  fnameText , lnameText,   phoneNUmint ,  mintText ,  emailText ,  addressText,  genderText);
                        userPanel userPanel = new userPanel(ssnText);
                        userPanel.setVisible(true);
                        JOptionPane.showMessageDialog(null,"Welcome to survey System "+fnameText);
                        setVisible(false);
                        break;

                    }



                }

            }
            else{
                   JOptionPane.showMessageDialog(null,"Ssn,Phone number and first name must be filled and"
                   +"Phone number must be integer");

               }}
        });
    }
    public List<String> getSSNS(){
        List<String> list=new ArrayList<String>();

        try {
            Class.forName("org.sqlite.JDBC");
            java.sql.Connection connection = DriverManager.getConnection("jdbc:sqlite:data.sqlite");
            java.sql.Statement statement = connection.createStatement();
            // Ssn number query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()){
                list.add(resultSet.getString("SSN"));

            }
        }
        catch (Exception ioException){
            ioException.printStackTrace();
        }
        return list;
    }
    public void addNewUser(String ssnText, String fnameText ,String lnameText,  int phoneNUmint , String mintText , String emailText , String addressText, String genderText  ){

        try {
            //connection with database
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:data.sqlite");
            String sql = " insert into user (`SSN`, `Phone_num`, `Fname`, `Minit`, `Lname`, `Email`, `Adress`, `Gender`)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);

            // add new user info to database
            preparedStmt.setString (1, ssnText);
            preparedStmt.setInt (2, phoneNUmint);
            preparedStmt.setString(3, fnameText);
            preparedStmt.setString    (4, mintText);
            preparedStmt.setString  (5, lnameText);
            preparedStmt.setString    (6, emailText);
            preparedStmt.setString    (7, addressText);
            preparedStmt.setString    (8, genderText);
            preparedStmt.execute();


        }
        catch (Exception ioException){
            ioException.printStackTrace();
        }

    }

}
