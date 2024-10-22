import java.rmi.Naming;
import javax.swing.*;

public class ClienteRMI {
    public static void main(String[] args) {
        try {
            // Conectarse al servidor RMI
            RegistroVotanteInterface registro = (RegistroVotanteInterface) Naming.lookup("rmi://192.168.221.73:1099/RegistroVotante");

            // Ingresar el RFC
            String rfc = JOptionPane.showInputDialog("Ingrese el RFC:");
            boolean puedeVotar = registro.verificarRFC(rfc);
            if (puedeVotar) {
                // Solicitar datos del votante si no ha votado
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
                String apellidoPaterno = JOptionPane.showInputDialog("Ingrese el apellido paterno:");
                String apellidoMaterno = JOptionPane.showInputDialog("Ingrese el apellido materno:");
                registro.registrarVotante(rfc, nombre, apellidoPaterno, apellidoMaterno);
                JOptionPane.showMessageDialog(null, "Votante registrado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Este RFC ya ha votado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
