
	package test;

	import java.util.Scanner;
	import entities.*;

	public class Test {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Capacité de la bibliothèque : ");
	        int n = Integer.parseInt(sc.nextLine());

	        if (n < 2) {
	            System.out.println(
	                "La capacité doit être au moins égale à 2."
	            );
	            sc.close();
	            return;
	        }

	        Bibliotheque b = new Bibliotheque(n);

	        // Initialiser avec deux documents
	        b.ajouter(new Roman(
	            "Le Petit Prince", "Antoine de Saint-Exupéry",
	            96, 45.0
	        ));

	        b.ajouter(new Revue(
	            "Science et Vie", "Octobre", 2026
	        ));

	        int choix;

	        do {
	            System.out.println("\n===== MENU =====");
	            System.out.println("1. Ajouter un document");
	            System.out.println("2. Afficher les documents");
	            System.out.println("3. Supprimer un document");
	            System.out.println("4. Rechercher un document");
	            System.out.println("5. Afficher les auteurs");
	            System.out.println("0. Quitter");
	            System.out.print("Votre choix : ");

	            choix = Integer.parseInt(sc.nextLine());

	            switch (choix) {
	                case 1:
	                    System.out.println(
	                        "Type : 1-Roman, 2-Manuel, "
	                        + "3-Revue, 4-Dictionnaire"
	                    );

	                    int type = Integer.parseInt(sc.nextLine());

	                    System.out.print("Titre : ");
	                    String titre = sc.nextLine();

	                    Document doc = null;

	                    if (type == 1 || type == 2) {
	                        System.out.print("Auteur : ");
	                        String auteur = sc.nextLine();

	                        System.out.print("Nombre de pages : ");
	                        int pages = Integer.parseInt(sc.nextLine());

	                        if (type == 1) {
	                            System.out.print("Prix : ");
	                            double prix = Double.parseDouble(
	                                sc.nextLine()
	                            );

	                            doc = new Roman(
	                                titre, auteur, pages, prix
	                            );
	                        } else {
	                            System.out.print("Niveau : ");
	                            String niveau = sc.nextLine();

	                            doc = new Manuel(
	                                titre, auteur, pages, niveau
	                            );
	                        }

	                    } else if (type == 3) {
	                        System.out.print("Mois : ");
	                        String mois = sc.nextLine();

	                        System.out.print("Année : ");
	                        int annee = Integer.parseInt(sc.nextLine());

	                        doc = new Revue(titre, mois, annee);

	                    } else if (type == 4) {
	                        System.out.print("Langue : ");
	                        String langue = sc.nextLine();

	                        doc = new Dictionnaire(titre, langue);

	                    } else {
	                        System.out.println("Type invalide.");
	                        break;
	                    }

	                    if (b.ajouter(doc)) {
	                        System.out.println("Document ajouté.");
	                    } else {
	                        System.out.println(
	                            "Échec : bibliothèque pleine."
	                        );
	                    }
	                    break;

	                case 2:
	                    b.afficherDocuments();
	                    break;

	                case 3:
	                    System.out.print("Numéro à supprimer : ");
	                    int numSup = Integer.parseInt(sc.nextLine());

	                    Document docSup = b.document(numSup);

	                    if (docSup != null && b.supprimer(docSup)) {
	                        System.out.println("Document supprimé.");
	                    } else {
	                        System.out.println("Document introuvable.");
	                    }
	                    break;

	                case 4:
	                    System.out.print("Numéro à rechercher : ");
	                    int num = Integer.parseInt(sc.nextLine());

	                    Document resultat = b.document(num);

	                    if (resultat != null) {
	                        System.out.println(resultat);
	                    } else {
	                        System.out.println("Document introuvable.");
	                    }
	                    break;

	                case 5:
	                    b.afficherAuteurs();
	                    break;

	                case 0:
	                    System.out.println("Au revoir !");
	                    break;

	                default:
	                    System.out.println("Choix invalide.");
	            }

	        } while (choix != 0);

	        sc.close();
	    }
	
}
