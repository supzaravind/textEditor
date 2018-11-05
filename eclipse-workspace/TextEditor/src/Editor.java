import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Editor extends JPanel implements ActionListener{
	File file;
	JButton save=new JButton("Save");
	JButton saveclose=new JButton("Save & Close");
	JTextArea textarea = new JTextArea(20,40);
	public Editor(String key) throws IOException
	{
		
		file=new File(key); 
		save.addActionListener(this);
		 saveclose.addActionListener(this);
		 if(file.exists())
		 {    
			 
			 BufferedReader br=new BufferedReader(new FileReader(file));
	         String line=br.readLine();
	         
			 while(line!=null)
			 {
				 textarea.append(line + "\n");
				 line=br.readLine();
			 }
			 br.close();
			
		 }
		 add(save);
		 add(saveclose);
		 add(textarea);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			 try {
				FileWriter out=new FileWriter(file);
				out.write(textarea.getText());
				out.close();
				System.out.println("FileWriter completed");
				if(e.getSource()==saveclose)
				{
					Login login=(Login)getParent();
					login.c1.show(login,"filebrowser");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  
		
	}

}
