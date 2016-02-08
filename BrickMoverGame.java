            //BrickMoverGame.java                      
    //This is the main fuction class that is the main menu of game
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public  class BrickMoverGame extends JFrame implements ActionListener
			{
		 public static void main(String ags[]) throws IOException
		 {

		 BrickMoverGame bmg=new BrickMoverGame();
		 bmg.setTitle("BRICK MOVER GAME");
		 bmg.setLocation(230,60);
		 bmg.setSize(906,615 );
		 bmg.setResizable(false);
		 bmg.setExtendedState(JFrame.MAXIMIZED_BOTH);
		 bmg.setVisible(true);
		 bmg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		JButton b1,b2,b3,b4,b5;
		Container c;
		BrickMoverGame() throws IOException
		{
		   
			new ProgressBar();
			try 
			{
			setIconImage(ImageIO.read(this.getClass().getResource("sokoban.png")));
			} 
			catch (IOException e) 
			{
			// TODO Auto-generated catch block
			System.out.println("[DEBUG] : Problem while setting game icon");
			e.printStackTrace();
			}

		   BufferedImage bf = ImageIO.read(new File("Game.png"));
		   this.setContentPane(new BackImage(bf));
		   
		   b1= new JButton("");
		   ImageIcon b1img=new ImageIcon("Button1.png");
		   b1=new JButton(" " ,b1img);
		   b1.setHorizontalTextPosition(SwingConstants.CENTER);
		 
		   ImageIcon b3img=new ImageIcon("Button2.png");
		   b3=new JButton(" ",b3img);
		   b3.setHorizontalTextPosition(SwingConstants.CENTER);

		   ImageIcon b4img=new ImageIcon("Button3.png");
		   b4=new JButton(" ",b4img);
		   b4.setHorizontalTextPosition(SwingConstants.CENTER);

		   ImageIcon b5img=new ImageIcon("Button4.png");
		   b5=new JButton(" ",b5img);
		   b5.setHorizontalTextPosition(SwingConstants.CENTER);
		 
		   b1.setBounds(325, 270, 251, 46);
		// b2.setBounds(488, 111, 251, 46);
		   b3.setBounds(325, 316, 251, 46);
		   b4.setBounds(325, 362, 251, 47);
		   b5.setBounds(325, 409, 251, 46);
		 
		  this.add(b1);
		 //this.add(b2);    /*Add buttons to the container that means frame*/
		  this.add(b3);
		  this.add(b4);
		  this.add(b5);

		  b1.addActionListener(this);
		//b2.addActionListener(this);    /* Add action listener to the button */
		  b3.addActionListener(this);
		  b4.addActionListener(this);     
		  b5.addActionListener(this);
		  }

		  public void actionPerformed(ActionEvent event)
				{
				if(event.getSource()==b1)
						 {
						 new InputPlayerName();
						 new PlayGame();
						 this.setVisible(false);
						 }

				/*if(event.getSource()==b2)
						 {         	                
						 System.exit(0);
						 } */ 

				if(event.getSource()==b3)
						 {
						new About(); 
						 }  

				if(event.getSource()==b4)
						 {
						new Help();   
						 }  

				if(event.getSource()==b5)
						 {
						 new Exit();
						 }
				}

          protected void processWindowEvent(WindowEvent e) 
				 {
				 if (e.getID() == WindowEvent.WINDOW_CLOSING) 
						{
					    JDialog.setDefaultLookAndFeelDecorated(true);
						int exit = JOptionPane.showConfirmDialog(this, "ARE YOU SURE?\nDO YOU WANT TO QUIT THE GAME");
						if (exit == JOptionPane.YES_OPTION) 
							{
							System.exit(0);
							}

						} 
				 else 
				  {
				  super.processWindowEvent(e);
				  }
				  }
				 }

           class BackImage extends JComponent 
					 {
					 Image i;
					 public BackImage(Image i) 
							{
							this.i = i;

							}

          public void paintComponent(Graphics g) 
		   {
		   g.drawImage(i, 0, 0, null);  // Drawing image using drawImage method
		   }
		   }