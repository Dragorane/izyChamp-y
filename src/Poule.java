import java.util.*;
 
public class Poule {
	Vector<Ville> lesVilles;


	@Override
	public String toString() {
		return "Poule{" +
				"lesVilles=" + lesVilles +
				", score=" + getScore() +
				'}';
	}

	public Poule(){
		lesVilles=new Vector<Ville>();
	}
	
	public float getScore(){
		float dist = 0;
		int clas = 0;
		for(int i = 0; i < lesVilles.size(); i++){
			clas += lesVilles.get(i).getClassement();
			for (int j = i+1; j <lesVilles.size(); j++){
				dist += lesVilles.get(i).getDist(lesVilles.get(j));
			}
		}

		return (float) (dist/1015.0) * (float) (clas/18.0);
	}
}
