import javax.swing.JOptionPane;
import javax.swing.JDialog;

public class Exit{

	Object option[]={"END GAME","PLAY GAME"};
	Exit(){
		JDialog.setDefaultLookAndFeelDecorated(true);
		int response = JOptionPane.showOptionDialog(null, "ARE YOU SURE DO YOU WANT TO QUIT THE GAME?", "ALERT",
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,null,option,option[1]);
            if (response == JOptionPane.YES_OPTION)
                              {
                              System.exit(0);
	                          }
                 
          }
                }