public class Ville {
    private int index;
    private int classement;
    static float[] matriceDist;

    public float getDist(Ville v){
        return matriceDist[v.index];
    }
}
