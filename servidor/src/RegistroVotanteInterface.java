import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RegistroVotanteInterface extends Remote {
    boolean verificarRFC(String rfc) throws RemoteException;
    void registrarVotante(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno) throws RemoteException;
}
