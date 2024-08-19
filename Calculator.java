import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener{

	JFrame frame;
	JTextField textfield;
	JButton[] numberBtns = new JButton[10]; //buttons with numbers (0-10)
	JButton[] fuctionBtns = new JButton[10]; //buttons with operations and other
	JButton addButton,subButton,mulButton,divButton,negButton; //naming the buttons 
	JButton decButton,equButton,clrButton,delButton;
	JPanel panel;
	
	Font myFont = new Font("Comic Sans MS",Font.BOLD,30); //the font we use 
	                                                  //font(string name,int style,int size)
	
	double num1=0,num2=0,result=0;
	char operator;
	
	Calculator(){
		frame = new JFrame("My First Calculator"); //name of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //we can close the frame by pressing the X
		frame.setSize(420,550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(10, 15, 385, 40); //where is the textfield located,the width and the height
		                                      //setBounds(int x,int y,int width,int height)
		textfield.setFont(myFont);
		textfield.setEditable(false); //we can't write inside the textfield anymore
		
		//create buttons
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		clrButton = new JButton("C");
		delButton = new JButton("<-");
		negButton = new JButton("(-)");
		
		//add buttons in the array
		fuctionBtns[0] = addButton;
		fuctionBtns[1] = subButton;
		fuctionBtns[2] = mulButton;
		fuctionBtns[3] = divButton;
		fuctionBtns[4] = decButton;
		fuctionBtns[5] = equButton;
		fuctionBtns[6] = clrButton;
		fuctionBtns[7] = delButton;
		fuctionBtns[8] = negButton;
		
		for(int i=0;i<9;i++) {
			fuctionBtns[i].addActionListener(this);
			fuctionBtns[i].setFont(myFont);	
			fuctionBtns[i].setFocusable(false);		
		}
		
		for(int i=0;i<10;i++) {
			//create buttons
			numberBtns[i] = new JButton(Integer.toString(i));
			numberBtns[i].addActionListener(this);
			numberBtns[i].setFont(myFont);	
			numberBtns[i].setFocusable(false);	
		}
		
		negButton.setBounds(141,465,120,40);
		delButton.setBounds(17, 465, 120,40);
		clrButton.setBounds(265,465,120,40);
		equButton.setBackground(Color.getHSBColor(210, 40, 700)); 
		
		panel = new JPanel();
		panel.setBounds(15,80,375,375);
		panel.setLayout(new GridLayout(4,4,10,10)); //GridLayout(int rows,int cols,int h(orizontal)gap,
		                                                                               //int v(ertical)gap)
		//panel.setBackground(Color.gray); // setting background color
		
		panel.add(numberBtns[7]);
		panel.add(numberBtns[8]);
		panel.add(numberBtns[9]);
		panel.add(divButton);
		panel.add(numberBtns[4]);
		panel.add(numberBtns[5]);
		panel.add(numberBtns[6]);
		panel.add(mulButton);
		panel.add(numberBtns[1]);
		panel.add(numberBtns[2]);
		panel.add(numberBtns[3]);
		panel.add(subButton);
		panel.add(decButton);
		panel.add(numberBtns[0]);
		panel.add(addButton);
		panel.add(equButton);
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator calculator = new Calculator();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberBtns[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));  //the number buttons now 
				                                                          //work and appear on the textfield
			}
		}
		
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());
			switch(operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				if(num2!=0) {
					result = num1 / num2;
				}else if(num1==0) {
					result =0;
				}
				break;	
			}
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		
		if(e.getSource() == clrButton) {
			textfield.setText(""); 
		}
		
		if(e.getSource() == delButton) {
			String text = textfield.getText();
			textfield.setText(""); 
			for(int i=0;i<text.length()-1;i++) {
				textfield.setText(textfield.getText()+ text.charAt(i));
			}
		}
		
		if(e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	}

}
