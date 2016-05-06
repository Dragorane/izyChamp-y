import java.util.Random;

public class Groupe extends AbsGroupe {
    SousGroupe sgrp1, sgrp2;

    int tailleSGrp = 3;

    public Groupe() {
        sgrp1 = new SousGroupe();
        sgrp2 = new SousGroupe();
    }

    public void add(Ville v) {
        Random r = new Random();
        if (sgrp1.size() < tailleSGrp && r.nextBoolean() || sgrp2.size() >= tailleSGrp)
            sgrp1.add(v);
        else
            sgrp2.add(v);
    }

    public int size() {
        return sgrp1.size() + sgrp2.size();
    }

    @Override
    public float getScore() {
        return (float) (getSommeDist() / 1015) + (float) getSommeClassement() / 12;
    }

    public float getSommeDist() {
        float dist = 2 * (sgrp1.getSommeDist() + sgrp2.getSommeDist());

        for (int i = 0; i < sgrp1.size(); i++) {
            for (int j = 0; j < sgrp2.size(); j++) {
                dist += sgrp1.get(i).getDist(sgrp2.get(j));
            }
        }
        return dist;
    }

    public int getSommeClassement() {
        return sgrp1.getSommeClassement() + sgrp2.getSommeClassement();
    }

    @Override
    public String toString() {
        return "SousGroupe 1 := " + sgrp1 +
                "\n\t\t\t\tSousGroupe 2 := " + sgrp2 +
                "\n\t\t\t\t";
    }

    @Override
    public Ville get(int p) {
        if (p < 3)
            return sgrp1.get(p);
        else
            return sgrp2.get(p - 3);
    }

    @Override
    public boolean remove(Ville v) {
        if (sgrp1.contains(v))
            return sgrp1.remove(v);
        else if (sgrp2.contains(v))
            return sgrp2.remove(v);
        else
            return false;
    }

    @Override
    public boolean contains(Ville v) {
        return sgrp2.contains(v) || sgrp1.contains(v);
    }
}
