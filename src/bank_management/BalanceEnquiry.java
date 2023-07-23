package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
JButton back;
String pinnumber;

BalanceEnquiry(String pinnumber) {
this.pinnumber = pinnumber;
setLayout(null);

back = new JButton("Back");
back.setBounds(355, 520, 150, 30);
back.addActionListener(this);
add(back);

Conn c = new Conn();
int balance=0;
try {
ResultSet rs = c.s.executeQuery("select * from bank where pinnumber ='"+pinnumber+"'");
while(rs.next()) {
if( rs.getString("type").equals("Deposit")) {
balance += Integer.parseInt(rs.getString("amount"));
} else {
balance -= Integer.parseInt(rs.getString("amount"));
}
}
} catch (Exception e) {
System.out.println(e);
}

JLabel text= new JLabel("Your Current Account balance is Rs " + balance);
text.setForeground(Color.BLACK);
text.setFont(new Font("System",Font.BOLD,30));
text.setBounds(100, 300, 700, 30);
add(text);

setSize(900, 900);
setLocation(300, 0);
setUndecorated(true);
setVisible(true);
}
public void actionPerformed(ActionEvent ae) {
setVisible(false);
new Transactions(pinnumber).setVisible(true);
}

public static void main(String args[]) {
new BalanceEnquiry(" ");
}
}
