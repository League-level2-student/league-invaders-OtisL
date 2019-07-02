import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel panel;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	public static void main(String[] args) {
		LeagueInvaders make = new LeagueInvaders();
		make.setup();
	}
	LeagueInvaders(){
		panel=new GamePanel();
		frame=new JFrame();
	}
	void setup() {
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT+20);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(panel);
	}
}
