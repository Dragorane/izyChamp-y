import java.util.*;

public class Poule extends AbsGroupe {
    Vector<Ville> lesVilles;


    @Override
    public String toString() {
        return lesVilles.toString();
    }

    public Poule() {
        lesVilles = new Vector<Ville>();
    }

    @Override
    public void add(Ville v) {
        lesVilles.add(v);
    }

    @Override
    public int size() {
        return lesVilles.size();
    }

    public float getScore() {
        float dist = 0;
        int clas = 0;
        for (int i = 0; i < lesVilles.size(); i++) {
            clas += lesVilles.get(i).getClassement();
            for (int j = i + 1; j < lesVilles.size(); j++) {
                dist += lesVilles.get(i).getDist(lesVilles.get(j));
            }
        }

        return (float) (dist / 1015.0) * (float) (clas / 18.0);
    }

    @Override
    public Ville get(int index) {
        return lesVilles.get(index);
    }

    @Override
    public boolean remove(Ville v) {
        return lesVilles.remove(v);
    }

    @Override
    public boolean contains(Ville v) {
        return lesVilles.contains(v);
    }
}
