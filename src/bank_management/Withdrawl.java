package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
JTextField amount;
JButton withdraw,back;
String pinnumber;

Withdrawl(String pinnumber) {
this.pinnumber=pinnumber;
setLayout(null);


JLabel text=new JLabel("Enter the amount you want to withdrawl");
text.setForeground(Color.BLACK);
text.setFont(new Font("System",Font.BOLD,16));
text.setBounds(170,300,400,20);
add(text);

amount=new JTextField();
amount.setFont(new Font("Railway",Font.BOLD,22));
amount.setBounds(170,350,320,25);
add(amount);

withdraw=new JButton("withdraw");
withdraw.setBounds(355,485,150,30);
withdraw.addActionListener(this);
add(withdraw);

back=new JButton("back");
back.setBounds(355,520,150,30);
back.addActionListener(this);
add(back);



setSize(900,900);
setLocation(300,0);
setVisible(true);
}

public void actionPerformed(ActionEvent ae) {
if(ae.getSource()==withdraw){

String number=amount.getText();
Date date=new Date();
if(number.equals(" ")){
JOptionPane.showMessageDialog(null,"please enter the amount you want to withdrawl");
}
else {
try {
Conn conn=new Conn();
String query4="insert into bank values('"+pinnumber+"','Withdraw','"+number+"')";
conn.s.executeUpdate(query4);
JOptionPane.showMessageDialog(null,"Rs "+number+" withdrawl successfully");
new Transactions(pinnumber).setVisible(true);
}catch (Exception e) {
System.out.println(e);
}
}
}else if(ae.getSource()==back){
setVisible(false);
new Transactions(pinnumber).setVisible(true);
}
}
public static void main(String args[]){
new Deposit(" ");
}

}
