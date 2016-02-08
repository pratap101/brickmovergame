import javax.swing.JOptionPane;
import javax.swing.JDialog;

public class About {
	
	About(){
		
		JDialog.setDefaultLookAndFeelDecorated(true);
		JOptionPane.showMessageDialog(null, "BRICK MOVER IS GAME APPLICATION\n\nVersion 1.0\nDeveloped by FRIEND GROUP Team And All "
				+ "Rights Reserved\nThanks for using this program", "About Brick Mover Game",
            JOptionPane.INFORMATION_MESSAGE);
		    
          }
}