import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Color;
import javax.swing.table.*;

//login Page
class Login extends JFrame{
	JTextField t1,t2;
	JButton b1,b2;
	JLabel l1,l2,l3,l4,system,Userlabel;
	Login(){
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Department Store Information System
		l1 = new JLabel("Department Store Information");
		l1.setFont(new Font("Time New Roman",Font.BOLD,25));
		l1.setForeground(Color.BLUE);
		l1.setBounds(50,10,1000,30);
		add(l1);
		system = new JLabel("System");
		system.setFont(new Font("Time New Roman",Font.BOLD,25));
		system.setForeground(Color.BLUE);
		system.setBounds(180,45,1000,30);
		add(system);
		//USERNAME
		l2 = new JLabel("Username: ");
		l2.setFont(new Font("Time New Roman",Font.BOLD,12));
		l2.setBounds(75,90,120,30);
		add(l2);
		//PASSWORD
		l3 = new JLabel("Password: ");
		l3.setFont(new Font("Time New Roman",Font.BOLD,12));
		l3.setBounds(75,130,120,30);
		add(l3);
		//SIZE OF LETTERS FOR USERNAME AND PASSWORD
		t1 =  new JTextField(60);
		t2 =  new JPasswordField(60);
		b1 =  new JButton("Sign In");
		b2 =  new JButton("Sign Up");
		t1.setBounds(150,90,150,30);
		t2.setBounds(150,130,150,30);
		b1.setBounds(180,170,80,30);
		b2.setBounds(180,210,80,30);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		
		//SIGN IN BUTTON
		b1.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent ae){
				boolean matched = false;
				String uname = t1.getText().toString();
				String pwd = t2.getText().toString();
				try{
				
					FileReader fr = new FileReader("record.txt");
					BufferedReader br = new BufferedReader(fr);
					String line;
					while((line=br.readLine())!=null){
						if(line.equals(uname+"\t"+pwd)){
						matched = true;
						break;
						}
					}
					fr.close();
				}
				catch(Exception e){
				}
				if(matched){ 
					dispose();
					HomePage hp = new HomePage(); //FROM LOGIN TO HOMEPAGE!
					hp.setVisible(true);
					hp.setBounds(350,280,600,500);
				}
				else{
					JFrame f = new JFrame(); //NOT REGISTERED
					JOptionPane.showMessageDialog(f,"Invalid username or password");
				}
			}
		});
		//SIGN UP BOTTON
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				SignUp s = new SignUp();
				s.setVisible(true);
				s.setBounds(400,280,500,300);
			}
		});
	}
}
//SignUp Page
class SignUp extends JFrame{
	JTextField t1,t2;
	JButton b1,b2;	
	JLabel l1,l2,l3;
	SignUp(){
		setLayout(null);
		//SIGNUP PAGELABEL
		l1 = new JLabel("SignUp Page");
		l1.setFont(new Font("Time New Roman",Font.BOLD,25));
		l1.setForeground(Color.BLUE);
		l1.setBounds(160,10,1000,30);
		add(l1);
		//usernameLABEL
		l2 = new JLabel("Enter your Username:");
		l2.setFont(new Font("Time New Roman",Font.BOLD,12));
		l2.setBounds(175,50,1000,30);
		add(l2);
		//passwordLABEL
		l3 = new JLabel("Enter your Password:");
		l3.setFont(new Font("Time New Roman",Font.BOLD,12));
		l3.setBounds(175,120,1000,30);
		add(l3);
		t1 =  new JTextField(60);
		t2 =  new JPasswordField(60);
		b1 =  new JButton("Submit");
		b2 =  new JButton("Back");
		
		t1.setBounds(175,75,120,30);
		t2.setBounds(175,145,120,30);
		
		b1.setBounds(195,185,80,30);
		b2.setBounds(195,220,80,30);
		
		//SubmitBUTTON
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
					String uname = t1.getText().toString();
					String pass = t2.getText().toString();
				if(uname.equals("")||pass.equals("")){
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f,"Please Input your Username or Password");
				}
				else{
						try{
							FileWriter fw = new FileWriter("record.txt",true);
							fw.write(t1.getText()+"\t"+t2.getText());
							fw.close();
							JFrame f = new JFrame();
							JOptionPane.showMessageDialog(f,"Registration Completed");
							dispose();
							}catch(Exception e){
							}
				}
				
			}	
		});
		//backButton
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
					}	
		});
		add(t1);
		add(t2);
		add(b1);
		add(b2);
	}
} 
//HOMEPAGE PAGE
class HomePage extends JFrame{
	
 	JLabel name,quantity,price,psign,category,n1,q1,c1,p1,fb,ig;
	JTextField n,q,p;
	JButton add,update,delete,logout;
	JComboBox comboCat;
	HomePage(){
		setLayout(null);
		name = new JLabel("ItemName:");
		name.setFont(new Font("Time New Roman",Font.PLAIN,18));
		name.setForeground(Color.BLUE);
		name.setBounds(60,20,1000,30);
		add(name);
		
		quantity = new JLabel("Quantity:");
		quantity.setFont(new Font("Time New Roman",Font.PLAIN,18));
		quantity.setForeground(Color.BLUE);
		quantity.setBounds(60,70,1000,30);
		add(quantity);
		
		price = new JLabel("Price:");
		price.setFont(new Font("Time New Roman",Font.PLAIN,18));
		price.setForeground(Color.BLUE);
		price.setBounds(60,120,1000,30);
		add(price);
		
		n1 = new JLabel("ItemName:");//ItemNAME for jtable
		n1.setFont(new Font("Time New Roman",Font.BOLD,14));
		n1.setForeground(Color.BLACK);
		n1.setBounds(20,220,1000,30);
		add(n1);
		
		q1 = new JLabel("Quantity:");//quantity for jtable
		q1.setFont(new Font("Time New Roman",Font.BOLD,14));
		q1.setForeground(Color.BLACK);
		q1.setBounds(157,220,1000,30);
		add(q1);
		
		c1 = new JLabel("Categories:");//Categories for jtable
		c1.setFont(new Font("Time New Roman",Font.BOLD,14));
		c1.setForeground(Color.BLACK);
		c1.setBounds(295,220,1000,30);
		add(c1);
		
		p1 = new JLabel("Price:");//Price for jtable
		p1.setFont(new Font("Time New Roman",Font.BOLD,14));
		p1.setForeground(Color.BLACK);
		p1.setBounds(435,220,1000,30);
		add(p1);
		
		n =  new JTextField(60);//name
		n.setBounds(150,20,100,30);
		add(n);
		
		q =  new JTextField(60);//quantity
		q.setBounds(150,70,50,30);
		add(q);
		
		p =  new JTextField(60);//price
		p.setBounds(150,120,50,30);
		add(p);
		
		category = new JLabel("Categories:");//Categories Label
		category.setFont(new Font("Time New Roman",Font.PLAIN,18));
		category.setForeground(Color.BLUE);
		category.setBounds(295, 21, 165, 25);
		add(category);
		
		fb = new JLabel("FB:Ayan Dela Cruz");//FbPage
		fb.setFont(new Font("Time New Roman",Font.PLAIN,12));
		fb.setForeground(Color.BLACK);
		fb.setBounds(170,390,1000,30);
		add(fb);
		
		ig = new JLabel("IG:@josh_ayaaaaan");//IGPage
		ig.setFont(new Font("Time New Roman",Font.PLAIN,12));
		ig.setForeground(Color.BLACK);
		ig.setBounds(290,390,1000,30);
		add(ig);
		
		String categories[] = {"Snacks","Drinks","Fruits","Chocolates"};//Categories ComboBox
        comboCat= new JComboBox(categories);
        comboCat.setBounds(400, 21, 165, 25);
        add(comboCat);
  
		JTable table = new JTable();//JTABLE
		table.setBounds(20,250,550,120);
		table.setVisible(true);
		add(table);
		
		Object[] columns = {"ItemName","Quantity","Categories ","Price"};//columnNAME
		DefaultTableModel model= new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setBackground(Color.white);
		Font font = new Font("",1,12);
		table.setFont(font);
		table.setRowHeight(30);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0,0,800,200);
		add(table);
			
			
			//add button
			add =  new JButton("Add");
			add.setBounds(230,180,100,30);
			add.setForeground(Color.RED);
			add.setFont(new Font("Time New Roman",Font.BOLD,14));
			add(add);
			
			Object[] row = new Object[4];//rows
			add.addActionListener(new ActionListener(){ 
				public void actionPerformed(ActionEvent ae){
					String iname = n.getText().toString();
					String quanti = q.getText().toString();
					String price = p.getText().toString();
				if(iname.equals("")||q.equals("")||p.equals("")){
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f,"Please Enter All Data");
				}
				else{
				
					row[0] = n.getText();
					row[1] = q.getText();
					row[2] = comboCat.getSelectedItem();
					row[3] = p.getText();
					model.addRow(row);
					

					n.setText("");//to reset the text 
					q.setText("");
					p.setText("");
					}
					
				
				}
			});
			
			table.addMouseListener(new MouseAdapter(){
			@Override 
			public void mouseClicked(MouseEvent e){
				int i = table.getSelectedRow();
				n.setText(model.getValueAt(i,0).toString());
				q.setText(model.getValueAt(i,1).toString());
				String selectedCat = model.getValueAt(i,2).toString();
				p.setText(model.getValueAt(i,3).toString());
				
					switch(selectedCat){
						case "Snacks":
							comboCat.setSelectedIndex(0);
							break;
						case "Drinks":
							comboCat.setSelectedIndex(1);
							break;
						case "Fruits":
							comboCat.setSelectedIndex(2);
							break;
						case "Chocolates":
							comboCat.setSelectedIndex(3);
							break;
					}
					
			}
			});
			
			
			//update button
			update =  new JButton("Update");
			update.setBounds(350,180,100,30);
			update.setForeground(Color.RED);
			update.setFont(new Font("Time New Roman",Font.BOLD,14));
			add(update);
			update.addActionListener(new ActionListener(){ 
				@Override
				public void actionPerformed(ActionEvent ae){
					int i = table.getSelectedRow();
					if(i >=0){
					model.setValueAt(n.getText(),i,0);
					model.setValueAt(q.getText(),i,1);
					model.setValueAt(p.getText(),i,3);
					}
					else{
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f,"Update Error");
					}
					
				}
			});
			
			//delete button
			delete =  new JButton("Delete");
			delete.setBounds(470,180,100,30);
			delete.setFont(new Font("Time New Roman",Font.BOLD,14));
			delete.setForeground(Color.RED);
			add(delete);
			delete.addActionListener(new ActionListener(){ 
				public void actionPerformed(ActionEvent ae){
					int i =table.getSelectedRow();
					if(i>=0){
						model.removeRow(i);
						n.setText("");//to reset the text 
						q.setText("");
						p.setText("");
					}
					else{
						JFrame f = new JFrame();
						JOptionPane.showMessageDialog(f,"Delete Error");
					}
					
				}
			});
			
			
			//logout button
			logout=  new JButton("SignOut");
			logout.setBounds(240,420,100,20);
			logout.setFont(new Font("Time New Roman",Font.BOLD,12));
			logout.setForeground(Color.BLUE);
			add(logout);
			logout.addActionListener(new ActionListener(){ 
				public void actionPerformed(ActionEvent ae){
					dispose();
					Login login = new Login();
					login.setVisible(true);
					login.setBounds(400,280,480,300);
			
				}			
			});
	}
}
//LOGIN FORM
public class LoginForm{
	public static void main(String[]args){
		Login l =  new Login();
		l.setBounds(400,280,480,300);
		l.setVisible(true);
		
	}
}