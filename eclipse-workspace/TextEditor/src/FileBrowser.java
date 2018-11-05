import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.io.*;
public class FileBrowser extends JPanel implements ActionListener  {


		// TODO Auto-generated method stub
 JLabel filelistL= new JLabel("File List: ");
 JButton open = new JButton("Open");
 JTextField newfileTF= new JTextField(20);
 JButton newfilebtn= new JButton("New File");
 JButton logout = new JButton("Logout");
 ButtonGroup bg;

 File directory;
 public FileBrowser(String dir)     // username is passed from the Login class
 {
	 directory=new File(dir);           
	 directory.mkdir();  // it calls the existing directory or creates a new directory in the name of the username(dir)
	  JPanel fileList=new JPanel(new GridLayout(directory.listFiles().length+3,1));  //gridlayout (no of rows,no of columns)
	  fileList.add(filelistL);          // the label " File List: " is added to the File List
	  bg=new ButtonGroup();
	  for(File file : directory.listFiles())         // each file in the directory is traversed. Similar to int i but since its a file, we refer File file 
	  {
		  JRadioButton radio= new JRadioButton(file.getName()); //All the files in the directory are listed as radio button
		  radio.setActionCommand(file.getName());           // it takes a string parameter that referes to the name of the radio or the  name by which it can be accessed
		  bg.add(radio);     // adding the button to the group ensures that only one button is selected in the group
		  fileList.add(radio);  // adding the button to the JPanel
		  
	  }
    logout.addActionListener(this);  
	  JPanel newpanel= new JPanel();     
	  newpanel.add(newfileTF); 
	  newpanel.add(newfilebtn);
	  newpanel.add(logout);
	  fileList.add(open);
	  fileList.add(newpanel);
	  newfilebtn.addActionListener(this);
	  open.addActionListener(this);
	  add(fileList); // adding the fileList panel to the browser panel
 }
 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Login login=(Login)getParent();
		if(e.getSource()==open)
		{
			try {
				login.add(new Editor(directory.getName()+"\\"+bg.getSelection().getActionCommand()),"editor");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   
			login.c1.show(login,"editor");
		}
		if(e.getSource()==newfilebtn)
		{
			String newfile=directory.getName()+"//"+newfileTF.getText()+".txt";
			String directoryname= directory.getName();
	
			if((newfileTF.getText().length()>0) && !(new File(newfile).exists()))
               {
	          try {
	        	
				login.add(new Editor(newfile),"editor");
				   login.c1.show(login,"editor");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	       
               }
               else
               {
            	   JOptionPane.showMessageDialog(null,"Enter a valid file name");
               }
		}
	if(e.getSource()==logout)
	{   
		
		login.c1.show(login, "login");
	}
		
	}

}
