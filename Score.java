package Application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Score extends JFrame implements ActionListener{
    String username;
    int score;
    Score(String username,int score)
    {
        this.username=username;
        this.score=score;

        setBounds(400,150,750,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE); 

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel image = new JLabel(i3);
        image.setBounds(0,200,300,250);
        add(image);

        JLabel heading = new JLabel("Thankyou "+username+" for Participating");
        heading.setBounds(200 , 50 , 500, 30); 
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(heading);

        JLabel scorel = new JLabel("Your Score is "+score);
        scorel.setBounds(300 , 150 , 500, 30); 
        scorel.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(scorel);

        JButton proceed = new JButton("Play again");
        proceed.setBounds(320,250,120,35);
        proceed.setBackground(Color.BLUE);
        proceed.setForeground(Color.WHITE);
        proceed.addActionListener(this);
        add(proceed);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
        new Login();
    }
    public static void main(String args[])
    {
        new Score("user", 100);
    }
}
