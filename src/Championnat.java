import com.sun.scenario.effect.Merge;

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
			if(p1.lesVilles.size() < villes.length/2 && r.nextBoolean() || p2.lesVilles.size() >= villes.length/2)
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
		return "Championnat {\n" +
				"\tPoule 1 : [" + p1.lesVilles + "],\n" +
				"\tPoule 2 : [" + p2.lesVilles + "],\n" +
				"\tScore=" + score +
				"\n}\n";
	}

	public Championnat mutation(){
        return null;
    }
     public Championnat croisement(Championnat c){


		 Vector<Ville> toutesLesVilles = new Vector<Ville>();
		 toutesLesVilles.addAll(p1.lesVilles);
		 toutesLesVilles.addAll(p2.lesVilles);

		 // now we have toutesLesVilles initiate !!! Fuck it !! Need refactoring or not

		 Poule newP1 = new Poule(), newP2 = new Poule();
		 Vector<Ville> reste = new Vector<Ville>();


		 for (Ville v : toutesLesVilles) {
			 if(this.p1.lesVilles.contains(v) && c.p1.lesVilles.contains(v))
				 newP1.lesVilles.add(v);
			 else if(this.p2.lesVilles.contains(v) && c.p2.lesVilles.contains(v))
				 newP2.lesVilles.add(v);
			 else
				 reste.add(v);
		 }

		 for (Ville v: reste ) {
			 Random r = new Random();
			 if(newP1.lesVilles.size() < toutesLesVilles.size()/2 && r.nextBoolean() || newP2.lesVilles.size() >= toutesLesVilles.size()/2)
				 newP1.lesVilles.add(v);
			 else
				 newP2.lesVilles.add(v);
		 }
		 return new Championnat(newP1,newP2);
     }

	@Override
	public int compareTo(Championnat o) {
		return 0;
	}
}
