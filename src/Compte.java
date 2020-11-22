/**
 * @author Kévin Ferreira - Licence Pro Métiers de l'informatique en initiale
 */

public class Compte implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private int solde;
	private String mdp;

	public Compte (String id, int solde, String mdp) {
		this.setId(id);
		this.setSolde(solde);
		this.setMdp(mdp);
	}
    
    public Compte (Compte c) {
        this(c.getId(), c.getSolde(), c.getMdp());
    }
    
	public Compte () {
		this("ID_INCONNU",0, "MDP_INDEFINI");
	}

	public String getId() {
		return id;
	}
	
	public Compte getCompte() {
        return new Compte(this.getId(), this.getSolde(), this.getMdp());
	}
	
	public void setCompte(Compte c) {
        this.setId(c.getId());
        this.setSolde(c.getSolde());
        this.setMdp(c.getMdp());
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


}
