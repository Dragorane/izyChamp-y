/**
 * Created by maxime on 04/04/2016.
 */
public class Ville {
    private int index;
    private float[] matriceDist;
    private int classement;

    public float getDist(Ville v){
        return matriceDist[v.index];
    }
}
