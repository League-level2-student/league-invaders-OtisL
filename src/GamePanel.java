import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font menuOptions;
	Timer frameDraw;
	Rocketship rocket;
	ObjectManager manager;
	GamePanel(){
		titleFont = new Font("Arial", Font.PLAIN, 48);
		menuOptions = new Font("Arial", Font.PLAIN, 30);
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
		rocket = new Rocketship(250,700,50,50);
		manager = new ObjectManager(rocket);
	}
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	void updateMenuState() {  
		
	}
	void updateGameState() {  
		manager.update();
	}
	void updateEndState()  {  
		
	}
	void drawMenuState(Graphics g) { 
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 50);
		g.setFont(menuOptions);
		g.drawString("Press 'ENTER' to start", 95, 250);
		g.drawString("Press 'SPACE' for instructions", 50, 450);
	}
	void drawGameState(Graphics g) { 
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		manager.draw(g);
	}
	void drawEndState(Graphics g)  { 
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 100, 50);
		g.setFont(menuOptions);
		g.drawString("You killed null enemies", 95, 250);
		g.drawString("Press 'ENTER' to restart", 90, 450);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		System.out.println("action");
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		   	if(rocket.y>=10) {
		   		rocket.up();
		   	}
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			if(rocket.y<=740) {
				rocket.down();
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			if(rocket.x>=10) {
				rocket.left();
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(rocket.x<=440) {
				rocket.right();
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
