package bank_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener{
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font ("Osward",Font.BOLD,38));
        text.setBounds(200,30,400,30);
        add(text);

        JLabel cardno = new JLabel("Card Number : ");
        cardno.setFont(new Font ("Raleway",Font.BOLD,38));
        cardno.setBounds(120,150,400,40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(375,160,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin = new JLabel("Password");
        pin.setFont(new Font ("Raleway",Font.BOLD,38));
        pin.setBounds(120,220,250,30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(375,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
}
    
@Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText(" ");
            pinTextField.setText(" ");
        } else if(ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"'and pinumber = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    System.out.println("Login successful");
                    new Transactions(pinnumber).setVisible(true);                   
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect cardnumber or pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        } else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);            
}

}
    public static void main(String[] args)
    {
        new Login().setVisible(true);
    }
}
