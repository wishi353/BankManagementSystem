package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno, cardnumber, pinumber;

    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);

        JLabel ab = new JLabel("page 3: Account Details");
        ab.setFont(new Font("Raleway", Font.BOLD, 22));
        ab.setBounds(280, 40, 400, 40);
        add(ab);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 100, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 150, 250, 30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 150, 250, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(650, 150, 250, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(900, 150, 250, 20);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        Random random = new Random();
        cardnumber = "" + (Math.abs(random.nextLong() % 900000000L) + 504093600000000L) % 10000000000000000L;
        pinumber = "" + (Math.abs(random.nextLong() % 9000L) + 1000L) % 10000;

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 200, 200, 30);
        add(card);

        JLabel number = new JLabel(cardnumber);
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 200, 300, 30);
        add(number);

        JLabel carddetails = new JLabel("your 16 digit card number");
        carddetails.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetails.setBounds(100, 230, 200, 20);
        add(carddetails);

        JLabel pin = new JLabel("Pin");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 270, 200, 30);
        add(pin);

        JLabel pnumber = new JLabel("xxxx");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 270, 100, 30);
        add(pnumber);

        JLabel pindetail = new JLabel("your 4 digit password");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetail.setBounds(100, 300, 300, 20);
        add(pindetail);

        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 350, 400, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 400, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(550, 400, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(800, 400, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email And Sms Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(300, 400, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 450, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(300, 450, 200, 30);
        add(c6);

        c7 = new JCheckBox("I declare tht the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 500, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 12));
        submit.setBounds(100, 600, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 12));
        cancel.setBounds(400, 600, 100, 30);
        submit.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(1000, 1000);
        setLocation(350, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "saving account";
            } else if (r2.isSelected()) {
                accountType = "fixed deposit account";
            } else if (r3.isSelected()) {
                accountType = "current account";
            } else if (r4.isSelected()) {
                accountType = "recurring deposit account";
            }

            /*Random random=new Random();
           String cardnumber= ""+ (Math.abs(random.nextLong()%900000000L) +504093600000000L)%10000000000000000L;
           Random random=new Random();
           String pinumber=""+ (Math.abs(random.nextLong()%9000L) + 1000L)%10000;*/
            String facility = "";
            if (c1.isSelected()) {
                facility = facility + "ATM card";
            } else if (c2.isSelected()) {
                facility = facility + "internet banking";
            } else if (c3.isSelected()) {
                facility = facility + "mobile banking";
            } else if (c4.isSelected()) {
                facility = facility + "email & sms alerts";
            } else if (c5.isSelected()) {
                facility = facility + "cheque book";
            } else if (c6.isSelected()) {
                facility = facility + "E-statement";
            }

            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "account type is required");
                } else {
                    Connection c;
                    Statement s;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "root");
                        s = c.createStatement();
                        String query1 = "insert into signupthree values('" + formno + "','" + accountType + "','" + cardnumber + "','" + pinumber + "','" + facility + "')";
                        String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinumber + "')";
                        s.executeUpdate(query1);
                        s.executeUpdate(query2);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    //Conn conn = new Conn();
                    //String query1 = "insert into signupthree values('" + formno + "','" + accountType + "','" + cardnumber + "','" + pinumber + "','" + facility + "')";
                    //String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinumber + "')";
                    //s.executeUpdate(query1);
                    //s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "pin: " + pinumber);
                }
                setVisible(false);
                //new Deposit(pinumber).setVisible(false);
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

   public static void main(String arg[]) {
        new SignupThree("");
    }
}
