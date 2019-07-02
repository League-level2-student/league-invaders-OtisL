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
}
//Currently on Step 5 of Model Management (not started on that)