/**
 * Created by maxime on 04/04/2016.
 */
public class ville {
    private int index;
    private float[] matriceDist;
    private int classement;

    public float getDist(ville v){
        return matriceDist[v.index];
    }
}
