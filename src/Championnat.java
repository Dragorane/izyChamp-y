import java.util.Vector;

public class Championnat {
	Poule p1;
	Poule p2;
	float score;
	
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

    public boolean mutation(){
        return true;
    }
     public boolean croisement(){
         return true;
     }
}
