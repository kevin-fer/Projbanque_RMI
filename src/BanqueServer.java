import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
/**
 * @author Kévin Ferreira - Licence Pro Métiers de l'informatique en initiale
 */
public class BanqueServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println( "Serveur : Construction de l’implémentation ");
            BanqueImplement banqueDescartes = new BanqueImplement();
            System.out.println("Objet Banque lié dans le RMIregistry");
            Naming.rebind("rmi://" + InetAddress.getLocalHost().getHostAddress()+":1099/MyBanque", banqueDescartes);
            System.out.println("Attente des invocations des clients …");
            } catch (Exception e) {
            System.out.println("Erreur de liaison de l'objet banqueDescartes");
            System.out.println(e.toString());
        }
        
    }
}
