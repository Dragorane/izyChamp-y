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

	public float calculScore(){
		return this.score = calculScore(p1, p2);
	}

	public float calculScore(Poule p1, Poule p2) {
		return Math.abs(p1.getScore() - p2.getScore());
	}

	public Championnat(){
		score=-1;
	}
	
	public Championnat (Vector<Ville> lesVilles) {
	
	}
	
	public Championnat (Poule P1, Poule P2) {
		this.p1=P1;
		this.p2=P2;
		this.score=calculScore();
	}

	@Override
	public String toString() {
		return "Championnat {\n" +
				"\tPoule 1 : [" + p1.lesVilles + "],\n" +
				"\tPoule 2 : [" + p2.lesVilles + "],\n" +
				"\tScore=" + score +
				"\n}\n";
	}

	public boolean mutation(){
		// we can add an try catch
		Random r = new Random();
		int p = r.nextInt(this.p1.lesVilles.size());
		int q = r.nextInt(this.p2.lesVilles.size());
		Ville v1 = this.p1.lesVilles.get(p);
		Ville v2 = this.p2.lesVilles.get(q);

		this.p1.lesVilles.remove(v1);
		this.p2.lesVilles.remove(v2);

		this.p1.lesVilles.add(v2);
		this.p2.lesVilles.add(v1);

		return true;
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

		if(this.score > o.score)
			return 1;
		else
			return -1;

	}
}
