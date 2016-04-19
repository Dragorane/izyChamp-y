import java.util.Vector;

public class Championnat implements Comparable<Championnat> {
	Poule p1;
	Poule p2;
	float score;

	public static Championnat GenRandChamp(Ville[] villes){
		return null;
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
