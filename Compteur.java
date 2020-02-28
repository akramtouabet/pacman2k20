package pacman;

public class Compteur {
	private int score;
	private int deaths;
	private int lives;
	private boolean alive;
	
	public Compteur() {
		score = 0;
		lives = 3;
		deaths = 0;
		alive=true;
	}
	
	public void resetScore() {
		score=0;
	}
	public int getScore() {
		return score;
	}
	
	public int getLives() {
		return lives;
	}
	
	public void incDeaths() {
		deaths++;
	}
	public void updateLives() {
		lives = 3 + (score/5000) - deaths;
	}
	public void incScore (int x) {
		score = score + x;
	}
	public void setAlive(boolean b) {
		alive=b;
	}
	public void incLives() {
		lives++;
	}
	public void isAlive() {
		if (lives <= 0) {
			setAlive(false);
		}
		setAlive(true);
	}
	
	public boolean getAlive() {
		return alive;
	}
	
	public int getDeaths() {
		return deaths;
	}
}
