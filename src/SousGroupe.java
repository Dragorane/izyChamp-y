import java.util.Vector;

public class SousGroupe {
    Vector<Ville> lesVilles;

    public SousGroupe() {
        this.lesVilles = new Vector<Ville>();
    }

    public int size() {
        return lesVilles.size();
    }

    @Override
    public String toString() {
        return lesVilles.toString();
    }

    public void add(Ville v) {
        lesVilles.add(v);
    }

    public float getSommeDist() {
        float dist = 0;
        for (int i = 0; i < lesVilles.size(); i++) {
            for (int j = i + 1; j < lesVilles.size(); j++) {
                dist += lesVilles.get(i).getDist(lesVilles.get(j));
            }
        }

        return dist;
    }

    public int getSommeClassement() {
        int clas = 0;
        for (int i = 0; i < lesVilles.size(); i++) {
            clas += lesVilles.get(i).getClassement();
        }
        return clas;
    }

    public Ville get(int p) {
        return lesVilles.get(p);
    }

    public boolean remove(Ville v) {
        return lesVilles.remove(v);
    }

    public boolean contains(Ville v) {
        return lesVilles.contains(v);
    }
}
