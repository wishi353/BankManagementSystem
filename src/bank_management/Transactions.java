package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcash,balanceenquiry,exit;
    String pinnumber;
Transactions(String pinnumber){
    System.out.println("Begin Transactions");
this.pinnumber = pinnumber;
setLayout(null);

JLabel text=new JLabel("Please select your Transaction");
text.setBounds(210,300,700,35);
text.setForeground(Color.BLACK);
text.setFont(new Font("System",Font.BOLD,16));
add(text);

deposit=new JButton("Deposit");
deposit.setBounds(170,415,150,30);
deposit.addActionListener(this);
add(deposit);

withdrawl=new JButton("Cash Withdrawl");
withdrawl.setBounds(355,415,150,30);
withdrawl.addActionListener(this);
add(withdrawl);

fastcash=new JButton("Fast cash");
fastcash.setBounds(170,450,150,30);
fastcash.addActionListener(this);
add(fastcash);

balanceenquiry=new JButton("Balance-Enquiry");
balanceenquiry.setBounds(355,450,150,30);
balanceenquiry.addActionListener(this);
add(balanceenquiry);

exit=new JButton("exit");
exit.setBounds(355,555,150,30);
exit.addActionListener(this);
add(exit);

setSize(900,900);
setLocation(300,0);
setUndecorated(true);
setVisible(true);

System.out.println("End Transactions");
}
@Override
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==exit) {
    System.exit(0);
}else if(ae.getSource()== deposit) {
    setVisible(false);
    new Deposit(pinnumber).setVisible(true);
} else if(ae.getSource()==withdrawl){
    setVisible(false);
   new Withdrawl(pinnumber).setVisible(true);
}else if(ae.getSource()==fastcash){
    setVisible(false);
   new FastCash(pinnumber).setVisible(true);
}else if(ae.getSource()==balanceenquiry){
    setVisible(false);
   new BalanceEnquiry(pinnumber).setVisible(true);
}
}
public static void main(String[] args){
    new Transactions("");
}


    
}
