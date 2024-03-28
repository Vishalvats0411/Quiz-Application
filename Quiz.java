package Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener{
        String [][] questions= new String[10][5];
        String [][] answers = new String [10][2];
        String [][] useranswer = new String[10][1];
        JRadioButton opt1,opt2,opt3,opt4;
        ButtonGroup groupicons;
        JButton Submit,lifeline,proceed;
        public static int score =0;

        JLabel qno,question;
        public static int timer = 15;
        public static int ans_given=0;
        public static int count = 0;
        String name;
        Quiz(String name)
        {
            this.name=name;

            setBounds(200,50,1200,750);
            setLayout(null);
            getContentPane().setBackground(Color.WHITE);
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("quiz.jpg"));
            JLabel image = new JLabel(i1);
            image.setBounds(0,-10,1200,320);
            add(image);

            qno = new JLabel("");
            qno.setBounds(100 , 350 , 30, 30); 
            qno.setFont(new Font("Tahoma",Font.PLAIN,24));
            add(qno);

            question = new JLabel("");
            question.setBounds(130 , 350 , 850, 30);
            question.setFont(new Font("Tahoma",Font.PLAIN,24));
            add(question);

            questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
            questions[0][1] = "JVM";
            questions[0][2] = "JDB";
            questions[0][3] = "JDK";
            questions[0][4] = "JRE";
    
            questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
            questions[1][1] = "int";
            questions[1][2] = "Object";
            questions[1][3] = "long";
            questions[1][4] = "void";
    
            questions[2][0] = "Which package contains the Random class?";
            questions[2][1] = "java.util package";
            questions[2][2] = "java.lang package";
            questions[2][3] = "java.awt package";
            questions[2][4] = "java.io package";
    
            questions[3][0] = "An interface with no fields or methods is known as?";
            questions[3][1] = "Runnable Interface";
            questions[3][2] = "Abstract Interface";
            questions[3][3] = "Marker Interface";
            questions[3][4] = "CharSequence Interface";
    
            questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
            questions[4][1] = "Stack";
            questions[4][2] = "String memory";
            questions[4][3] = "Random storage space";
            questions[4][4] = "Heap memory";
    
            questions[5][0] = "Which of the following is a marker interface?";
            questions[5][1] = "Runnable interface";
            questions[5][2] = "Remote interface";
            questions[5][3] = "Readable interface";
            questions[5][4] = "Result interface";
    
            questions[6][0] = "Which keyword is used for accessing the features of a package?";
            questions[6][1] = "import";
            questions[6][2] = "package";
            questions[6][3] = "extends";
            questions[6][4] = "export";
    
            questions[7][0] = "In java, jar stands for?";
            questions[7][1] = "Java Archive Runner";
            questions[7][2] = "Java Archive";
            questions[7][3] = "Java Application Resource";
            questions[7][4] = "Java Application Runner";
    
            questions[8][0] = "Which of the following is a mutable class in java?";
            questions[8][1] = "java.lang.StringBuilder";
            questions[8][2] = "java.lang.Short";
            questions[8][3] = "java.lang.Byte";
            questions[8][4] = "java.lang.String";
    
            questions[9][0] = "Which of the following option leads to the portability and security of Java?";
            questions[9][1] = "Bytecode is executed by JVM";
            questions[9][2] = "The applet makes the Java code secure and portable";
            questions[9][3] = "Use of exception handling";
            questions[9][4] = "Dynamic binding between objects";

            answers[0][1] = "JDB";
            answers[1][1] = "int";
            answers[2][1] = "java.util package";
            answers[3][1] = "Marker Interface";
            answers[4][1] = "Heap memory";
            answers[5][1] = "Remote interface";
            answers[6][1] = "import";
            answers[7][1] = "Java Archive";
            answers[8][1] = "java.lang.StringBuilder";
            answers[9][1] = "Bytecode is executed by JVM";

            opt1 = new JRadioButton("");
            opt1.setBounds(130,420,400,30);
            opt1.setBackground(Color.white);
            opt1.setFont((new Font("Dialog",Font.PLAIN,20)));
            add(opt1);

            opt2 = new JRadioButton("");
            opt2.setBounds(130,460,400,30);
            opt2.setBackground(Color.white);
            opt2.setFont((new Font("Dialog",Font.PLAIN,20)));
            add(opt2);

            opt3 = new JRadioButton("");
            opt3.setBounds(130,500,400,30);
            opt3.setBackground(Color.white);
            opt3.setFont((new Font("Dialog",Font.PLAIN,20)));
            add(opt3);

            opt4 = new JRadioButton("");
            opt4.setBounds(130,540,400,30);
            opt4.setBackground(Color.white);
            opt4.setFont((new Font("Dialog",Font.PLAIN,20)));
            add(opt4);

            groupicons = new ButtonGroup();
            groupicons.add(opt1);
            groupicons.add(opt2);
            groupicons.add(opt3);
            groupicons.add(opt4);

            proceed = new JButton("Proceed");
            proceed.setBounds(900,400,120,35);
            proceed.setBackground(Color.BLUE);
            proceed.setForeground(Color.WHITE);
            proceed.addActionListener(this);
            add(proceed);
            
            lifeline = new JButton("50-50 LifeLine");
            lifeline.setBounds(900,480,120,35);
            lifeline.setBackground(Color.BLUE);
            lifeline.setForeground(Color.WHITE);
            lifeline.addActionListener(this);
            add(lifeline);

            Submit = new JButton("Submit");
            Submit.setBounds(900,560,120,35);
            Submit.setBackground(Color.BLUE);
            Submit.setForeground(Color.WHITE);
            Submit.setEnabled(false);
            Submit.addActionListener(this);
            add(Submit);

            start(count);

            
            setVisible(true);


        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==proceed)
            {
                repaint();
                opt1.setEnabled(true);
                opt2.setEnabled(true);
                opt3.setEnabled(true);
                opt4.setEnabled(true); 
                ans_given=1;
                if(groupicons.getSelection()==null)
                {
                    useranswer[count][0]="";
                }
                else{
                    useranswer[count][0]=groupicons.getSelection().getActionCommand();
                }
                if(count==8)
                {
                    proceed.setEnabled(false);
                    Submit.setEnabled(true);
                }
                count++;
                start(count);
            }
            else if(e.getSource()==lifeline)
            {
                if(count==2 || count==4  ||count==6 ||count==8 || count==10)
                {
                    opt2.setEnabled(false);
                    opt3.setEnabled(false);
                }
                else{
                    opt1.setEnabled(false);
                    opt4.setEnabled(false);
                }
                lifeline.setEnabled(false);
            }
            else
            {
                ans_given=1;
                if(groupicons.getSelection()==null)
                    {
                        useranswer[count][0]="";
                    }
                    else{
                        useranswer[count][0]=groupicons.getSelection().getActionCommand();
                    }
                    for(int i=0; i<useranswer.length;i++)
                    {
                        if(useranswer[i][0].equals(answers[i][1]))
                        {
                            score+=10;
                        }
                    }
                    setVisible(false);
                    new Score(name,score);
            }
        }

        public void paint(Graphics g)
        {
            super.paint(g);
            String time = "Time Left : "+timer+" Seconds";
            g.setColor(Color.RED);
            g.setFont(new Font("Tahoma",Font.BOLD,22));
            if(timer>0)
            {
                g.drawString(time, 900, 400);
            }
            else{
                g.drawString(time, 900, 400);
            }
            timer--;
            try
            {
                Thread.sleep(1000);
                repaint();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            if(ans_given==1)
            {
                ans_given=0;
                timer = 15;
            }
            else if(timer<0)
            {
                opt1.setEnabled(true);
                opt2.setEnabled(true);
                opt3.setEnabled(true);
                opt4.setEnabled(true); 

                if(count==8)
                {
                    proceed.setEnabled(false);
                    Submit.setEnabled(true);
                }
                if(count==9)
                {
                    if(groupicons.getSelection()==null)
                    {
                        useranswer[count][0]="";
                    }
                    else{
                        useranswer[count][0]=groupicons.getSelection().getActionCommand();
                    }
                    for(int i=0; i<useranswer.length;i++)
                    {
                        if(useranswer[i][0].equals(answers[i][1]))
                        {
                            score+=10;
                        }
                    }
                    setVisible(false);
                    new Score(name,score);
                }
                else{
                    timer =15;
                    if(groupicons.getSelection()==null)
                    {
                        useranswer[count][0]="";
                    }
                    else{
                        useranswer[count][0]=groupicons.getSelection().getActionCommand();
                    }
                    count++;
                    start(count);
                }
            }
        }
        

        public void start(int count )
        {
            qno.setText(""+(count +1)+"");
            question.setText(questions[count][0]);
            opt1.setText(questions[count][1]);
            opt1.setActionCommand(questions[count][1]);

            opt2.setText(questions[count][2]);
            opt2.setActionCommand(questions[count][2]);

            opt3.setText(questions[count][3]);
            opt3.setActionCommand(questions[count][3]);

            opt4.setText(questions[count][4]);
            opt4.setActionCommand(questions[count][4]);

            groupicons.clearSelection();
        
        }
        
    public static void main(String args[])
    {
        new Quiz("user");
    }
}
