import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProgressBar extends JFrame {
	
	JProgressBar jb;
	int i=0,num=0;


	ProgressBar() throws IOException{
	 // new  BrickMoverGame();
		//new MyCanvas();
	//Container c=this.getContentPane();	
	//c.setBackground(Color.black);
	 try {
                        setIconImage(ImageIO.read(this.getClass().getResource("sokoban.png")));
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        System.out.println("[DEBUG] : Problem while setting game icon");
                        e.printStackTrace();
						}
	BufferedImage bf = ImageIO.read(new File("LoadingImage.jpg"));
  	  this.setContentPane(new BackImage1(bf));
  	  jb=new JProgressBar(0,2000);
	jb.setBounds(0,290,550,200);
	jb.setForeground(Color.white);
	jb.setBackground(Color.BLACK);
	jb.setBorderPainted(false);
	jb.setValue(0);
	jb.setStringPainted(true);	
	add(jb);
	//this.setBackground(Color.black);
	this.setSize(550,300);

        //this.setResizable(false);
	this.setLocation(415,205);
	this.setUndecorated(true);
        this.setLayout(null);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	iterate();
	}

	public void iterate(){
		
	while(i<=2000){
	  jb.setValue(i);
	  i=i+40;
	  try{
		  Thread.sleep(150);
		  }
	  catch(Exception e){}
	
	
	//this.dispose();
	if(i==2000){
		jb.setVisible(false);
		this.dispose();
		
		} 
	}  
	}
	}

class BackImage1 extends JPanel 
{
//private static final long serialVersionUID = 2268304137890377137L;
Image i;
public BackImage1(Image i) 
       {
       this.i = i;

       }

//Overriding the paintComponent method
//@Override
public void paintComponent(Graphics g) {
//this.add(new ImagePanel());
g.drawImage(i, 0, 0, null);  // Drawing image using drawImage method
g.setColor(Color.gray);
g.setFont(new Font("Chiller",Font.BOLD,30));
g.drawString("Please Wait...", 0, 280);
g.setFont(new Font("Chiller",Font.BOLD,65));
g.drawString("BRICK MOVER GAME", 15, 165);
}

}

