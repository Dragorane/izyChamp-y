import java.util.Random;
import java.util.Vector;

public class Championnat implements Comparable<Championnat> {
	Poule p1;
	Poule p2;
	float score;

	public static Championnat GenRandChamp(Ville[] villes){

		Poule p1 = new Poule(), p2 = new Poule();
		for (Ville v: villes ) {
			Random r = new Random();
			if(p1.lesVilles.size() < villes.length/2 && r.nextBoolean())
				p1.lesVilles.add(v);
			else
				p2.lesVilles.add(v);
		}
		return new Championnat(p1,p2);
	}
	
	public Championnat(){
		score=-1;
	}
	
	public Championnat (Vector<Ville> lesVilles) {
	
	}
	
	public Championnat (Poule P1, Poule P2) {
		this.p1=P1;
		this.p2=P2;
		this.score=-1;
	}

	@Override
	public String toString() {
		return "Championnat{" +
				"p2=" + p2 +
				", p1=" + p1 +
				", score=" + score +
				'}';
	}

	public Championnat mutation(){
        return null;
    }
     public Championnat croisement(Championnat c){
         

		 return null;
     }

	@Override
	public int compareTo(Championnat o) {
		return 0;
	}
}
