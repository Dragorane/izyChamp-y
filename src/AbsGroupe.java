/**
 * Created by maxime on 06/05/2016.
 */
public abstract class AbsGroupe {

    public abstract void add(Ville v);

    public abstract int size();

    public abstract float getScore();

    public abstract Ville get(int p);

    public abstract boolean remove(Ville v2);

    public abstract boolean contains(Ville v);
}
