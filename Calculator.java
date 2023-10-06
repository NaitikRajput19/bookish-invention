import javax.swing.*;
import java.awt.event.*;
public class Calculator extends JFrame implements ActionListener{

    JLabel first,second,answer;
    JTextField t1,t2,t3;
    JButton b1,b2,b3,b4,b5;

    Calculator(){
        first = new JLabel("First Number: ");
        first.setBounds(10,20,120,30);
        t1 = new JTextField();
        t1.setBounds(120,20,100,30);
        second = new JLabel("Second Number: ");
        second.setBounds(10,70,120,30);
        t2 = new JTextField();
        t2.setBounds(120,70,100,30);
        answer = new JLabel("Answer: ");
        answer.setBounds(10,120,120,30);

        t3 = new JTextField();
        t3.setBounds(70,120,100,30);
        t3.setEditable(false);

        b1 = new JButton("ADDITION");
        b1.setBounds(10,180,100,30);
        b2 = new JButton("SUBTRACTION");
        b2.setBounds(120,180,140,30);
        b3 = new JButton("MULTIPLY");
        b3.setBounds(270,180,100,30);
        b4 = new JButton("DIVIDE");
        b4.setBounds(380,180,120,30);
        b5 = new JButton("MODULO");
        b5.setBounds(510,180,120,30);


        add(first);add(t1);add(second);add(t2);add(answer);add(t3);add(b1);add(b2);add(b3);add(b4);add(b5);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        setSize(700,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            int num1 = Integer.parseInt(t1.getText());
            int num2 = Integer.parseInt(t2.getText());
            int add = num1+num2;
            t3.setText(Integer.toString(add));
        }
        if(e.getSource()==b2){
            int num1 = Integer.parseInt(t1.getText());
            int num2 = Integer.parseInt(t2.getText());
            int sub = num1-num2;
            t3.setText(Integer.toString(sub));
        }
        if(e.getSource()==b3){
            int num1 = Integer.parseInt(t1.getText());
            int num2 = Integer.parseInt(t2.getText());
            int multi = num1*num2;
            t3.setText(Integer.toString(multi));
        }
        if(e.getSource()==b4){
            float num1 = Float.parseFloat(t1.getText());
            float num2 = Float.parseFloat(t2.getText());
            float div = num1/num2;
            t3.setText(Float.toString(div));
        }
        if(e.getSource()==b5){
            float num1 = Float.parseFloat(t1.getText());
            float num2 = Float.parseFloat(t2.getText());
            float mod = num1 % num2;
            t3.setText(Float.toString(mod));
        }
    }
    public static void main(String[] args) {
        new Calculator();
    }


}
