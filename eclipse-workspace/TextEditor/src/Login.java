import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;


import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

public class Login extends JPanel implements ActionListener {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JLabel UsernameL = new JLabel("UserName: ");
 JTextField userTF = new JTextField();
 JLabel PasswordL = new JLabel("Password: ");
 JPasswordField passwordTF = new JPasswordField();
 JPanel loginpanel = new JPanel(new GridLayout(3,2));
 JPanel mainpanel= new JPanel();
 JButton loginbtn = new JButton("Login");
 JButton registerbtn = new JButton("Register");
 CardLayout c1;
 public Login(){
	 setLayout(new CardLayout()); // used when two or more components uses the same display space
	 loginpanel.add(UsernameL);
	 loginpanel.add(userTF);
	 loginpanel.add(PasswordL);
	 loginpanel.add(passwordTF);
	 loginbtn.addActionListener(this);
	 registerbtn.addActionListener(this);
	 loginpanel.add(loginbtn); 
	 loginpanel.add(registerbtn);
	 mainpanel.add(loginpanel);
	 add(mainpanel,"login");
	 c1= (CardLayout) getLayout();
	 
	 
 }
 
 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginbtn)
		{
			try {
				BufferedReader br=new BufferedReader(new FileReader("password.txt"));
				String pass=null;
				String line= br.readLine();
		
				while(line!=null)
				{
					StringTokenizer str=new StringTokenizer(line);
					if(userTF.getText().equals(str.nextToken()))
						pass=str.nextToken();
						//System.out.println("Pass: "+pass);
						line=br.readLine();
                       //System.out.println("line :" +line);	
				}
					
			
				br.close();
				MessageDigest md;
				md=java.security.MessageDigest.getInstance("SHA-256");
				md.update(new String(passwordTF.getPassword()).getBytes());
				byte byteData[]=md.digest();
				
				StringBuffer sb=new StringBuffer();
			
				
				for(int i=0;i<byteData.length;i++)
				{
					sb.append(Integer.toString((byteData[i] & 0XFF)+0x100,16).substring(1));
				}	
		
				if(pass.equals(sb.toString()))
				{	
	                add(new FileBrowser(userTF.getText()),"filebrowser");  // calls the constructor of the filebrowser class
	                c1.show(this,"filebrowser");      // display the Filebrowser page
	                
				}
				else {
				 JOptionPane.showMessageDialog(loginpanel,"Wrong Password:Please enter again");	
			   // System.out.println("Wrong Password:Please enter again");
			    
				}	}
			 catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  catch (NoSuchElementException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==registerbtn)
		{
		add(new Register(),"register");
		c1.show(this,"register");
	}
	}

	public static void main(String args[]) 
	{
		JFrame frame=new JFrame("Text Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		Login login=new Login();
		frame.add(login);
		frame.setVisible(true);
		frame.setResizable(false);
        boolean resizable = frame.isResizable();
		
	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	}

}
