package Application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener  {
    JButton proceed,Back;
    JTextField tfname;
        Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,-10,600,500);
        add(image);
        
        JLabel heading = new JLabel("Simple Minds");
        heading.setBounds(750,60,300,45);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel name = new JLabel("Enter your name");
        name.setBounds(670,150,300,45);
        name.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        name.setForeground(Color.BLACK);
        add(name);

        tfname = new JTextField();
        tfname.setBounds(820,158,250,25);
        tfname.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(tfname);

        proceed = new JButton("Proceed");
        proceed.setBounds(700,300,120,35);
        proceed.setBackground(Color.BLUE);
        proceed.setForeground(Color.WHITE);
        proceed.addActionListener(this);
        add(proceed);

        Back = new JButton("Back");
        Back.setBounds(900,300,120,35);
        Back.setBackground(Color.BLUE);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);

        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==proceed)
        {
            if(tfname.getText().equals(""))
            {
                JLabel error = new JLabel("Enter your name !!!");
                error.setBounds(870,170,300,45);
                error.setFont(new Font("Mongolian Baiti",Font.BOLD,14));
                error.setForeground(Color.RED);
                add(error);   
             
                revalidate();
                repaint();
            }
            else{
                String name = tfname.getText();            
                setVisible(false);
                new Proceed(name);
            }
        }
        else if(ae.getSource()==Back)
        {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}