import java.util.*;

public class Main {
    public static void main(String[] args) {

        int n = 50; //nombre d'individu dans une generation
        int m = 5; //nombre d'individu qui vont avoir le droit a une mutation

        Ville[] villes = {new Ville("Toulouse", 1, 1),
                new Ville("Cergy", 2, 3),
                new Ville("Meudon", 3, 4),
                new Ville("Amneville", 4, 7),
                new Ville("Francais_volants", 5, 8),
                new Ville("Asnieres", 6, 11),
                new Ville("Valance", 7, 12),
                new Ville("Avignon", 8, 16),
                new Ville("Marseille", 9, 18),
                new Ville("Chambery", 10, 2),
                new Ville("Annecy", 11, 5),
                new Ville("Limoges", 12, 6),
                new Ville("Clermon", 13, 9),
                new Ville("Villard", 14, 10),
                new Ville("Roanne", 15, 13),
                new Ville("Evry", 16, 14),
                new Ville("Strasbourg", 17, 15),
                new Ville("Wasquehal", 18, 17)
        };

        List<Championnat> listChamp = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            listChamp.add(Championnat.GenRandChamp(villes));
        }
        // list de championnat initial
        //System.out.println(listChamp);

        List<Championnat> listInit = new ArrayList<Championnat>(listChamp);

        List<Championnat> listEnfants = new ArrayList<>();

        int generation = 0;
        do { // boucle sur les generations
            generation++;

            try {
                // gen n enfants
                for (int i = 0; i < n; i++) {
                    Random r = new Random();
                    int p = r.nextInt(listChamp.size());
                    int s = r.nextInt(listChamp.size());
                    listEnfants.add(listChamp.get(p).croisement(listChamp.get(s)));
                }


                // # X-men
                for (int i = 0; i < m ; i++) {
                    Random r = new Random();
                    int p = r.nextInt(listEnfants.size());
                    listEnfants.get(p).mutation();
                }
                listChamp.addAll(listEnfants);


                Collections.sort(listChamp);


                for (int i = 0; i < n; i++) {
                    listChamp.remove(listChamp.size() -1);
                }
                listEnfants.clear();
            }
            catch (Exception e){
                System.err.println(e);
                listChamp = new ArrayList<Championnat>(listInit);

            }
        } while (listChamp.get(0).score > 0.05 || generation > 10);
        System.out.println("Nombre de Generation : " + generation);
        System.out.println(listChamp);
    }
}
