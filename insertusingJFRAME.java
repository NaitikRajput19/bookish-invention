import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class insertusingJFRAME{
        JFrame frame;
        JLabel label1,label2,label3,label4,label5,label6;
        JTextField textField1,textField2,textField3,textField4,textField5,textField6;
        JButton button;

        insertusingJFRAME() {

                frame = new JFrame("Database Inserting");
                label1 = new JLabel("Name:");
                label1.setBounds(20,50,50,20);

                textField1 = new JTextField();
                textField1.setBounds(70,50,100,20);

                label2 = new JLabel("Owner:");
                label2.setBounds(20,100,60,20);

                textField2 = new JTextField();
                textField2.setBounds(80,100,100,20);

                label3 = new JLabel("Species:");
                label3.setBounds(20,150,60,20);

                textField3 = new JTextField();
                textField3.setBounds(80,150,100,20);

                label4 = new JLabel("Sex:");
                label4.setBounds(20,200,60,20);

                textField4 = new JTextField();
                textField4.setBounds(80,200,100,20);

                label5 = new JLabel("Birth:");
                label5.setBounds(20,250,60,20);

                textField5 = new JTextField();
                textField5.setBounds(80,250,100,20);

                label6 = new JLabel("Death:");
                label6.setBounds(20,300,60,20);

                textField6 = new JTextField();
                textField6.setBounds(80,300,100,20);

                button = new JButton("Submit");
                button.setBounds(50,350,100,20);
                button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String name = textField1.getText();
                                String owner = textField2.getText();
                                String species = textField3.getText();
                                String sex = textField4.getText();
                                String birth = textField5.getText();
                                String death;
                                if(textField6.getText().equalsIgnoreCase("null")){
                                        death = null;
                                } else {
                                        death = textField6.getText();
                                }

                                insertDataIntoDatabase(name,owner,species,sex,birth,death);
                        }
                });
                frame.add(label1);frame.add(textField1);
                frame.add(label2);frame.add(textField2);
                frame.add(label3);frame.add(textField3);
                frame.add(label4);frame.add(textField4);
                frame.add(label5);frame.add(textField5);
                frame.add(label6);frame.add(textField6); frame.add(button);
                frame.setSize(800,800);
                frame.setLayout(null);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        }
        private void insertDataIntoDatabase(String name,String owner,String species,String sex,String birth,String death) {
                {
                        String url = "jdbc:mysql://localhost:3306/fintech";
                        String user = "root";
                        String password = "aryanaitikrajput15";

                        try {

                                Connection connection = DriverManager.getConnection(url, user, password);
                                String sq = "CREATE TABLE IF NOT EXISTS pet (name VARCHAR(20), owner VARCHAR(20),species VARCHAR(20), sex CHAR(1), birth DATE, death DATE);";
                                Statement stmt1 = connection.createStatement();
                                stmt1.executeUpdate(sq);
                                System.out.println("Table Created");
                                String sql = "INSERT INTO pet(name,owner,species,sex,birth,death)values (?, ?, ?, ?, ?, ?)";
                                PreparedStatement statement = connection.prepareStatement(sql);
                                statement.setString(1, name);
                                statement.setString(2, owner);
                                statement.setString(3, species);
                                statement.setString(4, sex);
                                statement.setString(5, birth);
                                statement.setString(6, death);
                                statement.executeUpdate();
                                JOptionPane.showMessageDialog(frame, "Data inserted into the database.");
                                connection.close();
                        } catch (SQLException ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                        }
                }
        }

        public static void main(String[] args) {
                new insertusingJFRAME();
        }


}
