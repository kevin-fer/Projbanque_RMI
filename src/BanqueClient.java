import java.net.InetAddress;
import java.rmi.Naming;
import java.util.Scanner;

/**
 * @author Kévin Ferreira - Licence Pro Métiers de l'informatique en initiale
 */
public class BanqueClient {

    public static void main (String [] args){
        try {
            int choix;
            Boolean quit = false;
            Scanner sc = new Scanner(System.in);
            System.setProperty("java.security.policy","file:./client1.policy");
            BanqueInterface banqueDescartes = (BanqueInterface)Naming.lookup("rmi://" + InetAddress.getLocalHost().getHostAddress()+":1099/MyBanque");
            //final String NO_CONNECTED_ID = "NON_IDENTIFIE", NO_CONNECTED_PASSWORD =;
            String id="0", mdp="0";
            while (quit==false) {
                System.out.println("-- Bienvenue à la Banque Descartes --");
                System.out.println("-- Que souhaitez-vous faire ? -------");
                System.out.println("-- 1 - Ouvrir un compte bancaire ----");
                System.out.println("-- 2 - Afficher votre solde ---------");
                System.out.println("-- 3 - Déposer de l'argent ----------");
                System.out.println("-- 4 - Retirer de l'argent ----------");
                System.out.println("-- 5 - Fermer votre compte ----------");
                System.out.println("-- Pour quitter l'application, veuillez appuyer sur n'importe quelle touche --");
                choix = sc.nextInt();
                switch(choix) {
                    case 1:
                        if(id!="0") {
                            System.out.println("Vous êtes déjà connecté!");
                            break;
                        }
                        System.out.println("Entrez un identifiant :");
                        id = sc.next();
                        System.out.println("Entrez un mot de passe :");
                        mdp = sc.next();
                        banqueDescartes.ouvrirCompte(id,mdp);
                        break;
                    case 2:
                        if(id=="0") {System.out.println("Veuillez vous connecter !");break;}
                        System.out.println("Bonjour " + id + ", vous avez demandé votre solde :");
                        System.out.println("Votre solde : " + banqueDescartes.solde(banqueDescartes.verifie(id, mdp)));
                        break;
                    case 3:
                        if(id=="0") {System.out.println("Veuillez vous connecter !");break;}
                        System.out.println("Bonjour " + id + ", vous avez demandé à déposer de l'argent :");
                        System.out.println("Quelle est la somme :");
                        int sommeTmp = sc.nextInt();
                        while(sommeTmp < 0) {
                                System.out.println("Veuillez entrer une somme supérieure à 0");
                            sommeTmp = sc.nextInt();

                        }
                        banqueDescartes.deposer(sommeTmp, banqueDescartes.getCompte(id, mdp));
                        break;
                    case 4:
                        if(id=="0") {System.out.println("Veuillez vous connecter !");break;}
                        System.out.println("Bonjour " + id + ", vous avez demandé à retirer de l'argent :");
                        System.out.println("Quelle est la somme :");
                        int sommeDeduireTmp = sc.nextInt();
                        banqueDescartes.retirer(sommeDeduireTmp, banqueDescartes.getCompte(id, mdp));
                        break;
                    case 5:
                        if(id=="0") {System.out.println("Veuillez vous connecter !");break;}
                        System.out.println("Bonjour " + id + ", vous avez demandé à fermer votre compte :");
                        banqueDescartes.fermerCompte(id, mdp);
                        break;
                    default:
                        System.out.println( "Vous quittez le programme" );
                        quit=true;
                }
            }
        //banqueDescartes.ouvrirCompte("kevin","bg");
        //banqueDescartes.deposer(200, banqueDescartes.getCompte("kevin", "bg"));
        //System.out.println("Fermeture du compte, solde actualisé : " + banqueDescartes.fermerCompte("kevin", "bg"));
        } catch (Exception e) {
            System.out.println ("Erreur d'accès à l'objet distant.");
            System.out.println (e.toString());
            }
        }
        
}
