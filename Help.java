import javax.swing.JOptionPane;
import javax.swing.JDialog;

public class Help {
	
	Help(){
		   JDialog.setDefaultLookAndFeelDecorated(true);
		JOptionPane.showMessageDialog(null, "Theme of the Game\n\nyou have to put all the Heavy boxes at its destination in the limitated time period."
		+ "\nTo score highest you have to put all the boxes at its destination with minimum time." + "\nLess the time higher you can score." 
		+ "\n\n How to Play\n\n In the game there is a super girl with super power. She can put all heavy boxes " 
        + "\nat its destination. You have to help her with your brain and logics to put these"
        + "\nboxes at its destination. With the help of up,down,left & right keys" , "Help Brick Mover Game", JOptionPane.INFORMATION_MESSAGE);
		
	}

}
