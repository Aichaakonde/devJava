import java.util.Scanner;

public class GestionCommerciale {
    enum Statut {
        PAYE, IMPAYE
    }

    class Commande {
        private int id;
        private String reference;
        private String date;
        private double montant;
        private Statut statut;

        public Commande() {}

        public Commande(int id, String reference, String date, double montant, Statut statut) {
            this.id = id;
            this.reference = reference;
            this.date = date;
            this.montant = montant;
            this.statut = statut;
        }

        public int getId() {
            return id;
        }

        public String getReference() {
            return reference;
        }

        public String getDate() {
            return date;
        }

        public double getMontant() {
            return montant;
        }

        public Statut getStatut() {
            return statut;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setMontant(double montant) {
            this.montant = montant;
        }

        public void setStatut(Statut statut) {
            this.statut = statut;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Référence: " + reference + ", Date: " + date + ", Montant: " + montant + ", Statut: " + statut;
        }

        public void payer() {
            if (statut == Statut.PAYE)
                statut = Statut.PAYE;
            else if (statut == Statut.IMPAYE)
                statut = Statut.IMPAYE;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionCommerciale gestionCommerciale = new GestionCommerciale();
        int choix;
        Commande nouvelleCommande;

        do {
            System.out.println("1. Enregistrer une commande");
            System.out.println("2. Lister toutes les commandes");
            System.out.println("3. Lister les commandes par statut");
            System.out.println("4. Quitter");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    nouvelleCommande = gestionCommerciale.enregistrerCommande();
                    break;

                case 2:
                    gestionCommerciale.listerToutesCommandes();
                    break;

                case 3:
                    System.out.println("Entrez le statut de la commande (PAYE ou IMPAYE) : ");
                    String statutStr = scanner.next().toUpperCase();
                    Statut statut = Statut.valueOf(statutStr);
                    gestionCommerciale.listerCommandesParStatut(statut);
                    break;

                default:
                    break;
            }

        } while (choix != 4);

        scanner.close();
    }

    public Commande enregistrerCommande() {
        Scanner scanner = new Scanner(System.in);
        Commande nouvelleCommande;

        System.out.println("Entrez l’id de la commande : ");
        int id = scanner.nextInt();
        System.out.println("Entrez la référence de la commande : ");
        String reference = scanner.next();
        System.out.println("Entrez la date de la commande : ");
        String date = scanner.next();
        System.out.println("Entrez le montant de la commande : ");
        double montant = scanner.nextDouble();
        System.out.println("Entrez le statut de la commande (PAYE ou IMPAYE) : ");
        String statutStr = scanner.next().toUpperCase();
        Statut statut = Statut.valueOf(statutStr);

        nouvelleCommande = new Commande(id, reference, date, montant, statut);
        System.out.println("Enregistrement réussi.");

        scanner.close();

        return nouvelleCommande;
    }

    public void listerToutesCommandes() {
        // Code pour lister toutes les commandes
    }

    public void listerCommandesParStatut(Statut statutRecherche) {
        // Code pour lister les commandes par statut
    }
}
