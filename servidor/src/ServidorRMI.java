import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            // Crear el registro RMI en el puerto 1099
            LocateRegistry.createRegistry(1099);

            // Instanciar la implementación del servicio y publicarla
            RegistroVotanteImpl registroVotante = new RegistroVotanteImpl();
            Naming.rebind("rmi://localhost/RegistroVotante", registroVotante);

            System.out.println("Servidor RMI listo y esperando solicitudes...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
