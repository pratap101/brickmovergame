import javax.swing.JFrame;
import java.io.IOException;
import javax.imageio.ImageIO;

public final class PlayGame extends JFrame {
     public static boolean frametest=false;
     static boolean check =true;
	  boolean check1 =true;
    private final int OFFSET = 32;

    public PlayGame() {
           try {
                        setIconImage(ImageIO.read(this.getClass().getResource("sokoban.png")));
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        System.out.println("[DEBUG] : Problem while setting game icon");
                        e.printStackTrace();
						}
		  if(check){
		           check=false;
				   InitUI();
                    //this.dispose();
					}
		       
              
	 
	 }

    public void InitUI() {
        Board board = new Board();
        add(board);
       // Check lr = new Check();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(board.getBoardWidth() + OFFSET,
                board.getBoardHeight() + 2*OFFSET);
setVisible(true);        
setLocationRelativeTo(null);
     setResizable(false);   
     setTitle("Brick Mover Game");
    //dispose();
	}

/*public void InitUI1() {
        LevelTwo lt = new LevelTwo();
        add(lt);
       // Check lr = new Check();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(lt.getBoardWidth() + OFFSET,
                lt.getBoardHeight() + 2*OFFSET);
setVisible(true);        
setLocationRelativeTo(null);
        setTitle("Brick Mover Game");
    }*/

    public static void main(String[] args) {
        //Sokoban sokoban = new Sokoban();
        //sokoban.setVisible(true);
        PlayGame p = new PlayGame();
        p.setVisible(true);    

}
}