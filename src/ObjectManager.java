import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocket;
	ArrayList <Projectile> projectiles= new ArrayList <Projectile>();
	ArrayList <Alien> aliens = new ArrayList <Alien>();
	Random randy = new Random();
	ObjectManager(Rocketship r){
		rocket=r;
	}
	void addProjectile(Projectile p) {
		projectiles.add(p);
	}
	void addAlien() {
		aliens.add(new Alien(randy.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	void update() {
		for(int i=0; i<aliens.size(); i++) {
			Alien a = aliens.get(i);
			a.update();
			if(a.y>LeagueInvaders.HEIGHT) {
				a.isActive=false;
			}
		}
		for(int j=0; j<projectiles.size(); j++) {
			Projectile p = projectiles.get(j);
			p.update();
			if(p.y<LeagueInvaders.HEIGHT) {
				p.isActive=false;
			}
		}
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
		//STUCK on 7 on Model Managment
		
	}
}
