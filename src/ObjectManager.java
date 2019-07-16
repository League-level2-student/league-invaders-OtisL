import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Rocketship rocket;
	ArrayList <Projectile> projectiles= new ArrayList <Projectile>();
	ArrayList <Alien> aliens = new ArrayList <Alien>();
	Random randy = new Random();
	private int score = 0;
	ObjectManager(Rocketship r){
		rocket=r;
	}
	void addProjectile(Projectile p) {
		projectiles.add(p);
	}
	void addAlien() {
		aliens.add(new Alien(randy.nextInt(LeagueInvaders.WIDTH)-30,0,50,50));
	}
	void update() {
		for(int i=0; i<aliens.size(); i++) {
			if(!rocket.isActive) {
				break;
			}
			Alien a = aliens.get(i);
			a.update();
			if(a.y>LeagueInvaders.HEIGHT) {
				a.isActive=false;
			}
		}
		for(int j=0; j<projectiles.size(); j++) {
			if(!rocket.isActive) {
				break;
			}
			Projectile p = projectiles.get(j);
			p.update();
			if(p.y<0) {
				p.isActive=false;
			}
		}
		checkCollision();
		purgeObjects();
	}
	void draw(Graphics g) {
		rocket.draw(g);
		for(int i=0; i<aliens.size(); i++) {
			Alien a = aliens.get(i);
			a.draw(g);
		}
		for(int j=0; j<projectiles.size(); j++) {
			Projectile p = projectiles.get(j);
			p.draw(g);
		}
	}
	void purgeObjects() {
		for(int i=aliens.size()-1; i>=0; i--) {
			Alien a = aliens.get(i);
			if(!a.isActive) {
				aliens.remove(i);
			}
		}
		for(int j=projectiles.size()-1; j>=0; j--) {
			Projectile p = projectiles.get(j);
			if(!p.isActive) {
				projectiles.remove(j);
			}
		}
	}
	void checkCollision() {
		for(int i=0; i<aliens.size(); i++) {
			Alien a = aliens.get(i);
			if(rocket.collisionBox.intersects(a.collisionBox)) {
				a.isActive=false;
				rocket.isActive=false;
			}
			for(int j=0; j<projectiles.size(); j++) {
				Projectile p = projectiles.get(j);
				if(p.collisionBox.intersects(a.collisionBox)) {
					p.isActive=false;
					a.isActive=false;
					score++;
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
	public int getScore() {
		return score;
	}
}
