
	package entities;

	public class Document {
	    private int numEnreg;
	    private String titre;

	    private static int compteur = 1;

	    public Document(String titre) {
	        this.numEnreg = compteur++;
	        this.titre = titre;
	    }

	    public int getNumEnreg() {
	        return numEnreg;
	    }

	    public String getTitre() {
	        return titre;
	    }

	    public void setTitre(String titre) {
	        this.titre = titre;
	    }

	    @Override
	    public String toString() {
	        return "Numéro : " + numEnreg
	                + ", Titre : " + titre;
	    }
	
}
