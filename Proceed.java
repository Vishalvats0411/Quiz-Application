package Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Proceed extends JFrame implements ActionListener{
    String name;
    JButton proceed,Back;
    Proceed(String name)
    {
        this.name=name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("WELCOME "+name+" to "+" Simple Minds :>");
        heading.setBounds(40,30,3000,45);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(40,70,3000,450);
        rules.setFont(new Font("Tahoma",Font.PLAIN,16));
        rules.setText(
            "<html>"+ 
            "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
            "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
            "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
            "4. Crying is allowed but please do so quietly." + "<br><br>" +
            "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
            "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
            "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
            "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
        "<html>"
        );
        add(rules);
        proceed = new JButton("Proceed");
        proceed.setBounds(200,500,120,35);
        proceed.setBackground(Color.BLUE);
        proceed.setForeground(Color.WHITE);
        proceed.addActionListener(this);
        add(proceed);

        Back = new JButton("Back");
        Back.setBounds(400,500,120,35);
        Back.setBackground(Color.BLUE);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);


        setSize(900,600);
        setLocation(350,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==proceed)
        {
            setVisible(false);
           new Quiz(name);
        }
        else if(ae.getSource()==Back)
        {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String [] args)
    {
        new Proceed("User");
    }
}
