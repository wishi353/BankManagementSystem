/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank_management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

    public class SignupTwo extends JFrame implements ActionListener {
   
    long random;
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,occupation,education,income;
    String formno;
    SignupTwo(String formno) {
        this.formno=formno;
        System.out.println("formno: "+formno);
        setLayout(null);
         
        setTitle("NEW ACCOUNT APPLICATION FORM -PAGE 2");
                
                JLabel additionalalDetails=new JLabel("page 2: Additional Details");
                additionalalDetails.setFont(new Font("Raleway",Font.BOLD,22));
                additionalalDetails.setBounds(290,80,400,30);
                add(additionalalDetails);
                
                JLabel rname=new JLabel("Religion:");
                rname.setFont(new Font("Raleway",Font.BOLD,20));
                rname.setBounds(100,130,400,30);
                add(rname);
                
                String valReligion[]={"HINDU","MUSLIM","SIKH","CHRISTIAN","other"};
                religion=new JComboBox(valReligion);
                religion.setBounds(300,140,400,30);
                religion.setBackground(Color.WHITE);
                add(religion);
                
                JLabel fname=new JLabel("Category:");
                fname.setFont(new Font("Raleway",Font.BOLD,20));
                fname.setBounds(100,190,200,30);
                add(fname);
                
                String valcategory[] = {"general","obc","sc","st","other"};
                category = new  JComboBox(valcategory);
                category.setBounds(300,190,400,30);
                category.setBackground(Color.WHITE);
                add(category);
                
                JLabel dob=new JLabel("Income:");
                dob.setFont(new Font("Raleway",Font.BOLD,20));
                dob.setBounds(100,240,200,30);
                add(dob);
                
                String incomecategory[] = {"NULL","< 1,50,000","2,50,000","5,00,000","upto 10,00,000 "};
                income = new JComboBox(incomecategory);
                income.setBounds(300,240 ,400,30);
                income.setBackground(Color.WHITE);
                add(income);
                
                JLabel gender=new JLabel("Educational");
                gender.setFont(new Font("Raleway",Font.BOLD,20));
                gender.setBounds(100,290,200,30);
                add(gender);
                
                String educationvalues[] = {"non-graduation","graduate","post-graduate","doctarate","other "};
                education = new JComboBox(educationvalues);
                education.setBounds(300,315  ,400,30);
                education.setBackground(Color.WHITE);
                add(education);
                
                 JLabel email=new JLabel("Qualification:");
                email.setFont(new Font("raleway",Font.BOLD,20));
                email.setBounds(100,315 ,200,30);
                add(email);
                
                
                
                JLabel marital=new JLabel("Occupation:");
                marital.setFont(new Font("raleway",Font.BOLD,20));
                marital.setBounds(100,390,200,30);
                add(marital);
                
                String occupationvalues[] = {"salaried","self-employement","business","student","other "};
                occupation = new JComboBox(occupationvalues);
                occupation.setBounds(300,390 ,400,30);
                occupation.setBackground(Color.WHITE);
                add(occupation);
               
                JLabel address =new JLabel("Pan-number:");
                address.setFont(new Font("Raleway",Font.BOLD,20));
                address.setBounds(100,440,200,30);
                add(address);
                
                pan=new JTextField();
                pan.setFont(new Font("raleway",Font.BOLD,20));
                pan.setBounds(300,440,400,30);
                add(pan);
                
                JLabel city=new JLabel("Aadhar Number:");
                city.setFont(new Font("Raleway",Font.BOLD,20));
                city.setBounds(100,490,200,30);
                add(city);
                
                aadhar = new JTextField();
                aadhar.setFont(new Font("raleway",Font.BOLD,14));
                aadhar.setBounds(300,490,400,30);
                add(aadhar);
                
                JLabel state=new JLabel("Senior Citizen:");
                state.setFont(new Font("Raleway",Font.BOLD,20));
                state.setBounds(100,540,200,30);
                add(state);
                
                syes=new JRadioButton("Yes");
                syes.setFont(new Font("raleway",Font.BOLD,20));
                syes.setBounds(300,540,120,30);
                syes.setBackground(Color.WHITE);
                add(syes);
                
                sno=new JRadioButton("No");
                sno.setFont(new Font("raleway",Font.BOLD,20));
                sno.setBounds(450,540,120,30);
                sno.setBackground(Color.WHITE);
                add(sno);
                
              
                JLabel existingacc=new JLabel("Existing Account:");
                existingacc.setFont(new Font("Raleway",Font.BOLD,20));
                existingacc.setBounds(100,590,200,30);
                add(existingacc);
                
                eyes= new JRadioButton("Yes");
                eyes.setFont(new Font("raleway",Font.BOLD,20));
                eyes.setBounds(300,590,120,30);
                eyes.setBackground(Color.WHITE);
                add(eyes);
                
                eno= new JRadioButton("No");
                eno.setFont(new Font("raleway",Font.BOLD,20));
                eno.setBounds(450,590,200,30);
                eno.setBackground(Color.WHITE);
                add(eno);
               
                next=new JButton("Next");
                next.setBackground(Color.BLACK);
                next.setForeground(Color.WHITE);
                next.setFont(new Font("Raleway",Font.BOLD,14));
                next.setBounds(620,620,80,30);
                next.addActionListener(this);
                add(next);
                
getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
   @Override 
    public void actionPerformed(ActionEvent ae){
        
        String formno1 = this.formno;
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){ 
            seniorcitizen = "yes";
        }else if(sno.isSelected()){ 
            seniorcitizen = "no";
        }
            
        
        
        String existingaccount = null;
        if(eyes.isSelected()){ 
           existingaccount  = "yes";
        }else if(eno.isSelected()){ 
            existingaccount = "no";
        }
           
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        

        try {
            Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno1+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                System.out.println("q2: "+query);
                c.s.executeUpdate(query);
               
                new SignupThree(formno).setVisible(true);
                setVisible(false);
            
            
        }catch(Exception e){
             System.out.println(e);
        }
    }
    
public static void main(String args[]){
    new SignupTwo("");
}
    
}
