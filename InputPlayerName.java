import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.util.*;

public class InputPlayerName{
               Formatter x;
               String name;
            public InputPlayerName(){
			 PlayerName();
			 } 
			 
			 public void PlayerName(){
			    try{
				JDialog.setDefaultLookAndFeelDecorated(true);
				name = JOptionPane.showInputDialog("Enter Player Name");
				createFile();
				}
			 catch(NumberFormatException e){
			 JOptionPane.showMessageDialog(null,"Are You Sure! Your Name Contains Numeric Number\n\nPlease Input Correct Name","ALERT",JOptionPane.PLAIN_MESSAGE);
			 PlayerName();
			 
			 }
			   }
			   public void createFile(){
            try{
			x=new Formatter("PlayerName.txt");
			addRecords();
			}
            catch(Exception e){}

}
public void addRecords(){
            x.format("\n"+name+"\n");
		   closeFile();
		 }
public void closeFile(){
x.close();
}
		 public static void main(String args[]){
InputPlayerName p = new InputPlayerName();
//p.PlayerName();
}
}