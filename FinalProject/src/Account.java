import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.* ;
import javax.swing.* ;
import java.util.Random;
import java.lang.Boolean;

class Account extends JFrame implements ActionListener 
{
	Container contentPane = getContentPane();
	
	Container pane = getContentPane();
	
	Font headlineFont = new Font("Arial", Font.ITALIC, 20);
	JPanel pnl = new JPanel();
	
	JLabel greet = new JLabel("Welcome to Bank International!");
	JPasswordField pin = new JPasswordField(38);
	//greet.setFont(headlineFont);
	JButton btn = new JButton("Click Me");
	
	JLabel greet2 = new JLabel("Please choose which one you would like");
	JButton btn2 = new JButton("Checking");
	JButton btn3 = new JButton("Savings");
	JButton btn4 = new JButton("Loan Transaction");
	
	JButton btn5 = new JButton("Would you like to Withdrawl?");
	JTextField with = new JTextField(38);
	JButton btn6 = new JButton("Would you like to Deposit?");
	JTextField dep = new JTextField(38);
	
	JLabel S = new JLabel("Remaining balance of Savings account");
	JTextField Sav = new JTextField(38);
	JLabel C = new JLabel("Remaining balance of Checking account");
	JTextField Che = new JTextField(38);
	JLabel L = new JLabel("Remaining balance of Loan account");
	JTextField Lo = new JTextField(38);
	//int[] pins = new int[10];
	int Pin = 1234;
	
	JButton btn7 = new JButton("Enter payment amount:");
	JButton btn8 = new JButton("Press to go back");
	double[] saving = {3000,0,0};
	double[] checking = {3000,0,0};
	double[] loan = {10000,0,0};
	int input = 0;
	double w = 0;
	double d = 0;
	
	JLabel one = new JLabel("This is your checking account");
	JLabel two = new JLabel("This is your Savings account");
	JLabel three = new JLabel("This is your Loan account");
	Boolean s = false;
	Boolean c = false;
	Boolean l = false;
	
	
	public Account()
	{
		super("Swing Window");
		setSize( 550, 400);
		setDefaultCloseOperation( EXIT_ON_CLOSE);
		add(pnl);
		
		pnl.add(greet);
		pnl.add(btn);
		btn.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		//Random rand = new Random();
		if( event.getSource() == btn)
		{
			for (int i =0; i<10;i++)
			{
			//pins[i] = rand.nextInt((8888 - 0010) + 1) + 10;
			//System.out.print(pins[i] + ";");
			}
			System.out.println(" ");
			pin.setText(JOptionPane.showInputDialog(this, "Enter your Pin please", "Input Pin", JOptionPane.PLAIN_MESSAGE));
			double input = Integer.parseInt(pin.getText());
			if(Pin != input)
			{
				JOptionPane.showMessageDialog(null, "Incorrct Pin, Please Try again","Result", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				pnl.remove(btn);
				pnl.add(greet2);
				pnl.add(btn2);
				pnl.add(btn3);
				pnl.add(btn4);
				
				btn2.addActionListener(this);
				btn3.addActionListener(this);
				btn4.addActionListener(this);
				setVisible(true);
			}
		}
		
		
		if( event.getSource() == btn2)
		{
			//this is for checking checking
			c = true;
			
			pnl.remove(greet);
			pnl.remove(greet2);
			pnl.remove(btn2);
			pnl.remove(btn3);
			pnl.remove(btn4);
			
			pnl.add(one);
			pnl.add(btn5);
			pnl.add(with);
			pnl.add(btn6);
			pnl.add(dep);
			pnl.add(S);
			pnl.add(Sav);
			pnl.add(C);
			pnl.add(Che);
			pnl.add(L);
			pnl.add(Lo);
			Che.setText(String.valueOf(checking[0]));
			Sav.setText(String.valueOf(saving[0]));
			Lo.setText(String.valueOf(loan[0]));
			
			pnl.add(btn8);
			setVisible(true);
		}
		if( event.getSource() == btn5 && c==true)
		{
			Che.setText(String.valueOf(checking[0]));
			double w = Double.parseDouble(with.getText());
			System.out.print(checking[0]);
			
			if((checking[0] - w )<0)
			{
				JOptionPane.showMessageDialog(null, "Insufficient funds","Result", JOptionPane.PLAIN_MESSAGE);
			}
			else if(checking[0] <501)
			{
				checking[0] -=w;
				JOptionPane.showMessageDialog(null, "Alert, low funds","Result", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				checking[0] -=w;
				Che.setText(String.valueOf(checking[0]));
			}
				
			
		}
		if(event.getSource() == btn6 && c==true)
		{
			double d = Integer.parseInt(dep.getText());
			checking[0] = checking[0] + d;
			Che.setText(String.valueOf(checking[0]));
			System.out.print(checking[0]);
		}
		
		
	
	
		if( event.getSource() == btn3)
		{
		//savings
			s = true;
			pnl.remove(greet);
			pnl.remove(greet2);
			pnl.remove(btn2);
			pnl.remove(btn3);
			pnl.remove(btn4);
			
			pnl.add(two);
			pnl.add(btn5);
			pnl.add(with);
			pnl.add(btn6);
			pnl.add(dep);
			pnl.add(S);
			pnl.add(Sav);
			pnl.add(C);
			pnl.add(Che);
			pnl.add(L);
			pnl.add(Lo);
			pnl.add(btn8);
	
			Che.setText(String.valueOf(checking[0]));
			Sav.setText(String.valueOf(saving[0]));
			Lo.setText(String.valueOf(loan[0]));
			setVisible(true);
			
		}
		if( event.getSource() == btn5 && s==true)
		{
			Sav.setText(String.valueOf(saving[0]));
			double w = Double.parseDouble(with.getText());
			System.out.print(saving[0]);
			
			if((saving[0] - w )<0)
			{
				JOptionPane.showMessageDialog(null, "Insufficient funds","Result", JOptionPane.PLAIN_MESSAGE);
			}
			else if(saving[0] <501)
			{
				saving[0] -=w;
				JOptionPane.showMessageDialog(null, "Alert, low funds","Result", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				saving[0] -=w;
				Sav.setText(String.valueOf(saving[0]));
			}
				
			
		}
		if(event.getSource() == btn6 && s==true)
		{
			double d = Integer.parseInt(dep.getText());
			saving[0] = saving[0] + d;
			Sav.setText(String.valueOf(saving[0]));
			System.out.print(saving[0]);
		}
		
		
	
	
		if( event.getSource() == btn4)
		{
		//loan
		l = true;
		pnl.add(three);
		pnl.remove(greet);
		pnl.remove(greet2);
		pnl.remove(btn2);
		pnl.remove(btn3);
		pnl.remove(btn4);
		
		pnl.add(btn7);
		pnl.add(with);
		pnl.add(S);
		pnl.add(Sav);
		pnl.add(C);
		pnl.add(Che);
		pnl.add(L);
		pnl.add(Lo);
		pnl.add(btn8);
		
		Che.setText(String.valueOf(checking[0]));
		Sav.setText(String.valueOf(saving[0]));
		Lo.setText(String.valueOf(loan[0]));
		}
		if( event.getSource() == btn7 && l==true)
		{
			Lo.setText(String.valueOf(loan[0]));
			double w = Double.parseDouble(with.getText());
			System.out.print(loan[0]);
			
			if((loan[0] - w )<0)
			{
				loan[0] -=w;
				JOptionPane.showMessageDialog(null, "Completed payment","Result", JOptionPane.PLAIN_MESSAGE);
			}
			else if(loan[0] <501)
			{
				loan[0] -=w;
				JOptionPane.showMessageDialog(null, "Alert, Less than $500 left","Result", JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				loan[0] -=w;
				Lo.setText(String.valueOf(loan[0]));
			}
		}
		if(event.getSource() == btn8)
		{
			
			pnl.remove(S);
			pnl.remove(Sav);
			pnl.remove(C);
			pnl.remove(Che);
			pnl.remove(L);
			pnl.remove(Lo);
			pnl.remove(btn7);
			pnl.remove(btn5);
			pnl.remove(with);
			pnl.remove(btn6);
			pnl.remove(dep);
			pnl.remove(btn8);
			pnl.remove(one);
			pnl.remove(two);
			pnl.remove(three);
			
			pnl.add(greet2);
			pnl.add(btn2);
			pnl.add(btn3);
			pnl.add(btn4);
			c = false;
			s = false;
			l = false;
			revalidate();
			repaint();
		}
	
	}
public static void main(String[] args )
{
	Account gui = new Account();	
}
}
