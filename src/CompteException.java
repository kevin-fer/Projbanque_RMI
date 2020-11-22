import java.rmi.RemoteException;
/**
 * @author Kévin Ferreira - Licence Pro Métiers de l'informatique en initiale
 */

public class CompteException extends RemoteException {
  private static final long serialVersionUID = 42l;
  public CompteException() {
    super();
  }

  public CompteException(String message) {
    super(message);
  }
}
