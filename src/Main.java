import java.util.*;

import static java.lang.System.*;

public class Main {

    public static void casSimple(int n,int m, float scoreMin, int nbGenMax){
        // n nombre d'individu dans une generation
        // m nombre d'individu qui vont avoir le droit a une mutation

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
        for (int i = 0; i < n; i++) {
            listChamp.add(Championnat.GenRandChampWithPoule(villes));
        }
        // list de championnat initial
        //System.out.println(listChamp);

        List<Championnat> listInit = new ArrayList<>(listChamp);
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
                    listEnfants.add(listChamp.get(p).croisementPoule(listChamp.get(s), villes));
                }


                // # X-men
                for (int i = 0; i < m; i++) {
                    Random r = new Random();
                    int p = r.nextInt(listEnfants.size());
                    listEnfants.get(p).mutation();
                }
                listChamp.addAll(listEnfants);


                Collections.sort(listChamp);


                for (int i = 0; i < n; i++) {
                    listChamp.remove(listChamp.size() - 1);
                }
                listEnfants.clear();
            } catch (Exception e) {
                err.println(e);
                listChamp = new ArrayList<>(listInit);

            }
        } while (listChamp.get(0).score > scoreMin && generation < nbGenMax);
        out.println("Nombre de Generation : " + generation);
        out.println("Derniere Generation : ");
        out.println(listChamp);
    }


    public static void casPasSimple(int n,int m, float scoreMin, int nbGenMax){


        Ville[] villes = {new Ville("Toulouse", 1, 1),
                new Ville("Cergy", 2, 3),
                new Ville("Meudon", 3, 4),
                new Ville("Amneville", 4, 7),
                new Ville("Francais_volants", 5, 8),
                new Ville("Asnieres", 6, 11),
                new Ville("Valance", 7, 12),
                new Ville("Chambery", 10, 2),
                new Ville("Annecy", 11, 5),
                new Ville("Limoges", 12, 6),
                new Ville("Clermon", 13, 9),
                new Ville("Villard", 14, 10),
        };

        List<Championnat> listChamp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listChamp.add(Championnat.GenRandChampWithGroupe(villes));
        }


        List<Championnat> listInit = new ArrayList<>(listChamp);
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
                    listEnfants.add(listChamp.get(p).croisementGroupe(listChamp.get(s), villes));
                }


                // # X-men
                for (int i = 0; i < m; i++) {
                    Random r = new Random();
                    int p = r.nextInt(listEnfants.size());
                    listEnfants.get(p).mutation();
                }
                listChamp.addAll(listEnfants);


                Collections.sort(listChamp);


                for (int i = 0; i < n; i++) {
                    listChamp.remove(listChamp.size() - 1);
                }
                listEnfants.clear();
            } catch (Exception e) {
                err.println(e);
                listChamp = new ArrayList<>(listInit);

            }
        } while (listChamp.get(0).score > scoreMin && generation < nbGenMax);
        out.println("Nombre de Generation : " + generation);
        out.println("Derniere Generation : ");
        out.println(listChamp);
    }

    public static void main(String[] args) {
        //casSimple(50,5,(float) 0.05, 25);
        casPasSimple(50,5,(float) 0.002, 25);
    }
}
