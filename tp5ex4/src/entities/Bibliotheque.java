
	package entities;

	public class Bibliotheque {
	    private int capacite;
	    private Document[] documents;
	    private int nombreDocuments;

	    public Bibliotheque(int capacite) {
	        if (capacite < 0) {
	            throw new IllegalArgumentException(
	                "La capacité doit être positive."
	            );
	        }

	        this.capacite = capacite;
	        this.documents = new Document[capacite];
	        this.nombreDocuments = 0;
	    }

	    public void afficherDocuments() {
	        if (nombreDocuments == 0) {
	            System.out.println("La bibliothèque est vide.");
	            return;
	        }

	        for (int i = 0; i < nombreDocuments; i++) {
	            System.out.println(documents[i]);
	        }
	    }

	    public boolean ajouter(Document doc) {
	        if (doc == null || nombreDocuments >= capacite) {
	            return false;
	        }

	        documents[nombreDocuments] = doc;
	        nombreDocuments++;
	        return true;
	    }

	    public boolean supprimer(Document doc) {
	        if (doc == null) {
	            return false;
	        }

	        for (int i = 0; i < nombreDocuments; i++) {
	            if (documents[i].getNumEnreg()
	                    == doc.getNumEnreg()) {

	                for (int j = i; j < nombreDocuments - 1; j++) {
	                    documents[j] = documents[j + 1];
	                }

	                documents[nombreDocuments - 1] = null;
	                nombreDocuments--;
	                return true;
	            }
	        }

	        return false;
	    }

	    public Document document(int numEnrg) {
	        for (int i = 0; i < nombreDocuments; i++) {
	            if (documents[i].getNumEnreg() == numEnrg) {
	                return documents[i];
	            }
	        }

	        return null;
	    }

	    public void afficherAuteurs() {
	        boolean trouve = false;

	        for (int i = 0; i < nombreDocuments; i++) {
	            if (documents[i] instanceof Livre) {
	                Livre livre = (Livre) documents[i];

	                System.out.println(
	                    livre.getAuteur() + " - "
	                    + livre.getTitre()
	                );

	                trouve = true;
	            }
	        }

	        if (!trouve) {
	            System.out.println("Aucun livre trouvé.");
	        }
	    }
	
}
