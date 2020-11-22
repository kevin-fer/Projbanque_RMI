import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class BanqueImplement extends UnicastRemoteObject implements BanqueInterface {

    //private static final long serialVersionUID = 1L;
    private Map<String, Compte> comptes;
	private Compte compte;
	BanqueImplement () throws RemoteException {
		comptes = new HashMap<>();
	}

	public void ouvrirCompte (String nom, String mdp) throws CompteException {
		if (this.comptes.containsKey(nom)){
            if(this.comptes.get(nom).getMdp().equals(mdp)) {
                throw new CompteException ("Vous êtes déjà connecté sur une session. En cas d'erreur veuillez contacter votre Banque");
            }
		} else {
			this.compte = new Compte(nom,0,mdp);
			comptes.put(nom, compte);
			comptes.get(nom).setSolde(0);
			System.out.println("Un compte a été crée");
		}
    }
    
	public Compte verifie (String nom, String mdp) throws CompteException {
		Compte compteTemp = new Compte();
		if(comptes.containsKey(nom)) {
            if(comptes.get(nom).getMdp().equals(mdp)) {
               compteTemp.setCompte(this.compte.getCompte());
            }
		}
		else {
            throw new CompteException ("Compte inexistant dans la base de données");
        }
        System.out.println("Un compte a été vérifié");
		return compteTemp.getCompte();
    }
    
	public Compte getCompte (String idCompte, String mdp) throws CompteException {
        Compte compteTemp = new Compte();
        if(this.comptes.containsKey(idCompte)) {
            if(this.comptes.get(idCompte).getMdp().equals(mdp)){
                compteTemp.setCompte(this.comptes.get(idCompte).getCompte());
            }
        } 
        else {
            throw new CompteException ("Erreur nom d'utilisateur ou mot de passe ");
            //return 0;
        }
        System.out.println("Un compte a été récupéré");
        return compteTemp;
	}

	public int fermerCompte (String nom, String mdp) throws CompteException {
		int soldeTempo = 0; 
        if(comptes.containsKey(nom)) {
            if(comptes.get(nom).getMdp().equals(mdp)) {
                soldeTempo = this.solde(comptes.get(nom));
                comptes.remove(nom);
            }
        }
        System.out.println("Un utilisateur à fermé son compte");
		return soldeTempo;
	}

	public int solde(Compte compte) throws CompteException {
        System.out.println("Une demande de solde à été effectuée");
		return compte.getSolde();
	}

	public void deposer (int somme, Compte compte) throws CompteException {
        this.compte.setSolde(somme + compte.getSolde());
        System.out.println("Un utilisateur à déposé de l'argent");
	}

	public void retirer (int somme, Compte compte) throws CompteException {
		int operationSoldeTempo = compte.getSolde()-somme;
        this.compte.setSolde(operationSoldeTempo);
        System.out.println("Un utilisateur à retiré de l'argent");
	}
}
