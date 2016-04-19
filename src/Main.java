import java.util.*;

public class Main {
    public static void main(String[] args) {

        int n = 50; //nombre d'individu dans une generation
        int m = 5; //nombre d'individu qui vont avoir le droit a une mutation

        Ville[] villes = {new Ville("Toulouse", 1),
                new Ville("Cergy", 2),
                new Ville("Meudon", 3),
                new Ville("Amneville", 4),
                new Ville("Francais_volants", 5),
                new Ville("Asnieres", 6),
                new Ville("Valance", 7),
                new Ville("Avignon", 8),
                new Ville("Marseille", 9),
                new Ville("Chambery", 10),
                new Ville("Annecy", 11),
                new Ville("Limoges", 12),
                new Ville("Clermon", 13),
                new Ville("Villard", 14),
                new Ville("Roanne", 15),
                new Ville("Evry", 16),
                new Ville("Strasbourg", 17),
                new Ville("Wasquehal", 18)
        };

        List<Championnat> listChamp = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            listChamp.add(Championnat.GenRandChamp(villes));
        }
        // list de championnat initial

        List<Championnat> listEnfants = new ArrayList<>();

        int generation = 0;
        do { // boucle sur les generations
            generation++;

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
                listChamp.remove(listChamp.size());
            }
            listEnfants.clear();
        } while (false); //false pour le moment =)

        
        return;
    }
}
