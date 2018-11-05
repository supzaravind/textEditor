import javax.swing.*;
import java.awt.*;
import java.security.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
public class Register extends JPanel implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel userL = new JLabel("Username");
	JTextField userTF = new JTextField();
	JLabel passwordL = new JLabel("Password");
	JPasswordField passwordTF = new JPasswordField();
	JLabel confirmpwdL= new JLabel("RE-TYPE password");
	JPasswordField confirmpwdTF=new JPasswordField();
	JButton registerbtn=new JButton("Register");
	JButton back= new JButton("Go Back");
	 public Register()
	 {
		 JPanel loginp = new JPanel();
		 loginp.setLayout(new GridLayout(4,2));
		 loginp.add(userL);
		 loginp.add(userTF);
		 loginp.add(passwordL);
		 loginp.add(passwordTF);
		 loginp.add(confirmpwdL);
		 loginp.add(confirmpwdTF);
		 loginp.add(registerbtn);
		 loginp.add(back);
		 registerbtn.addActionListener(this);
		 back.addActionListener(this);
		 add(loginp);
		
		 
	 }
	 public void actionPerformed(ActionEvent e)
	 
	 { 
		 if(e.getSource()==registerbtn && passwordTF.getPassword().length>0 && userTF.getText().length()>0)
	 {
		String password=new String(passwordTF.getPassword());
		String confirmpwd= new String(confirmpwdTF.getPassword());
		if(password.equals(confirmpwd))
		{
			try {
	
				
			BufferedReader br=new BufferedReader(new FileReader("password.txt"));
			String line= br.readLine();
			while(line!=null)
			{
				StringTokenizer st= new StringTokenizer(line);
				if(userTF.getText().equals(st.nextToken()))
				{  
					System.out.println("The user already exist");
					return;
				}
				line=br.readLine();
			}
			br.close();
			/* MESSAGE DIGEST : To convert the password into hashed value.
			 *  Java.security provides a class called MessageDigest to hash any value
			 *   The hashed value is called "message digest" or "hash value"
			 *   It is done using three main methods of the MessageDigest Class*/
			MessageDigest md;
			
			md=java.security.MessageDigest.getInstance("SHA-256");    /* Step 1: Create a MessageDigest object and call getInstance() method.It takes String parameter of the algorithm to be used and returns md object */
			md.update(password.getBytes());                           /* Step 2 : Add the message to be hashed using update method. It takes byte array parameter.So convert the message to bytes*/
			byte byteData[]=md.digest();                              /* Step 3 : The hashing algorithm is computed on the message by calling digest() method.It returns the hashed values in byte array format  */
			StringBuffer sb= new StringBuffer();                      /* Step 4 : To convert the byte array into string or hexastring, create a string buffer and append using toString method*/  
			
			for(int i= 0;i<byteData.length;i++)                       /* Step 5:  byteData.length ensures  */
			{   //System.out.println(" printing toString " +Integer.toString(byteData[i] & 0xFF));
				sb.append(Integer.toString((byteData[i] & 0xFF) +0x100, 16).substring(1)); }
				BufferedWriter output= new BufferedWriter(new FileWriter("password.txt",true));
				//System.out.println(sb.toString());
			
				output.write(userTF.getText()+" "+sb.toString()+ "\n");
				output.close();
				 Login login=(Login)getParent();
					login.c1.show(login, "login");	
			
			
			}
		
			catch(FileNotFoundException e1)
			{
			 System.out.println(e);
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
			
		
	 }
	 }
		  
		 if(e.getSource()==back)
		 {
			 Login login=(Login)getParent();
			login.c1.show(login, "login");
		 }
	 }
	
}
