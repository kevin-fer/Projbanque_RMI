import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * @author Kévin Ferreira - Licence Pro Métiers de l'informatique en initiale
 */

public interface BanqueInterface extends Remote {
    public void ouvrirCompte(String identifiant, String mdp) throws RemoteException;
    public Compte verifie(String identifiant, String mdp) throws RemoteException;
    public int fermerCompte (String identifiant, String mdp) throws RemoteException;
    public void deposer (int somme, Compte compte) throws RemoteException;
    public void retirer (int somme, Compte compte) throws RemoteException;
    public Compte getCompte (String idCompte, String mdp) throws RemoteException;
    public int solde(Compte compte) throws RemoteException;

}
