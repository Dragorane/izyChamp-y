

import java.util.Random;
import java.util.Vector;

public class Championnat implements Comparable<Championnat> {

    private AbsGroupe g1;
    private AbsGroupe g2;

    float score;

    public Championnat(AbsGroupe p1, AbsGroupe p2) {
        this.g1 = p1;
        this.g2 = p2;
        this.score = calculScore(p1, p2);
    }

    public static Championnat GenRandChampWithPoule(Ville[] villes) {

        AbsGroupe p1 = new Poule(), p2 = new Poule();
        for (Ville v : villes) {
            Random r = new Random();
            if (p1.size() < villes.length / 2 && r.nextBoolean() || p2.size() >= villes.length / 2)
                p1.add(v);
            else
                p2.add(v);
        }
        return new Championnat(p1, p2);
    }

    public static Championnat GenRandChampWithGroupe(Ville[] villes) {

        AbsGroupe p1 = new Groupe(), p2 = new Groupe();
        for (Ville v : villes) {
            Random r = new Random();
            if (p1.size() < 6 && r.nextBoolean() || p2.size() >= 6)
                p1.add(v);
            else
                p2.add(v);
        }
        return new Championnat(p1, p2);
    }

    private float calculScore(AbsGroupe g1, AbsGroupe g2) {
        return this.score = Math.abs(g1.getScore() - g2.getScore());
    }

    @Override
    public String toString() {
        return "Championnat {\n" +
                "\tGroupe 1 : [" + g1 + "],\n" +
                "\tGroupe 2 : [" + g2 + "],\n" +
                "\tScore=" + score +
                "\n}\n";
    }

    public boolean mutation() {
        // we can add an try catch
        Random r = new Random();
        int p = r.nextInt(this.g1.size());
        int q = r.nextInt(this.g2.size());
        Ville v1 = this.g1.get(p);
        Ville v2 = this.g2.get(q);

        this.g1.remove(v1);
        this.g2.remove(v2);

        this.g1.add(v2);
        this.g2.add(v1);

        return true;
    }

    public Championnat croisementPoule(Championnat c, Ville[] toutesLesVilles) {

        AbsGroupe newP1 = new Poule(), newP2 = new Poule();
        Vector<Ville> reste = new Vector<Ville>();


        for (Ville v : toutesLesVilles) {
            if (this.g1.contains(v) && c.g1.contains(v))
                newP1.add(v);
            else if (this.g2.contains(v) && c.g2.contains(v))
                newP2.add(v);
            else
                reste.add(v);
        }

        for (Ville v : reste) {
            Random r = new Random();
            if (newP1.size() < toutesLesVilles.length / 2 && r.nextBoolean() || newP2.size() >= toutesLesVilles.length / 2)
                newP1.add(v);
            else
                newP2.add(v);
        }
        return new Championnat(newP1, newP2);
    }

    public Championnat croisementGroupe(Championnat c, Ville[] toutesLesVilles) {

        AbsGroupe newP1 = new Groupe(), newP2 = new Groupe();
        Vector<Ville> reste = new Vector<Ville>();


        for (Ville v : toutesLesVilles) {
            if (this.g1.contains(v) && c.g1.contains(v))
                newP1.add(v);
            else if (this.g2.contains(v) && c.g2.contains(v))
                newP2.add(v);
            else
                reste.add(v);
        }

        for (Ville v : reste) {
            Random r = new Random();
            if (newP1.size() < toutesLesVilles.length / 2 && r.nextBoolean() || newP2.size() >= toutesLesVilles.length / 2)
                newP1.add(v);
            else
                newP2.add(v);
        }
        return new Championnat(newP1, newP2);
    }

    @Override
    public int compareTo(Championnat o) {

        if (this.score > o.score) {

            return 1;
        } else if (this.score < o.score) {

            return -1;
        } else {
            return 0;
        }
    }
}
