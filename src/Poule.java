import java.util.*;
 
public class Poule {
	Vector<Ville> lesVilles;
	float score;

	@Override
	public String toString() {
		return "Poule{" +
				"lesVilles=" + lesVilles +
				", score=" + score +
				'}';
	}

	public Poule(){
		lesVilles=new Vector<Ville>();
	}
	
	public float getScore(){
		return 0;
	}
}
