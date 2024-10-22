import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

public class RegistroVotanteImpl extends UnicastRemoteObject implements RegistroVotanteInterface {

    protected RegistroVotanteImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean verificarRFC(String rfc) throws RemoteException {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/votantes", "root", "qwer");
            String query = "SELECT * FROM votantes WHERE rfc = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, rfc);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                boolean yaVoto = rs.getBoolean("voto_emitido");
                con.close();
                return !yaVoto;  // Devuelve false si ya votó
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true; // Devuelve true si no está registrado y puede votar
    }

    @Override
    public void registrarVotante(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno) throws RemoteException {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/votantes", "root", "qwer");
            String query = "INSERT INTO votantes (rfc, nombre, apellido_paterno, apellido_materno, voto_emitido) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, rfc);
            stmt.setString(2, nombre);
            stmt.setString(3, apellidoPaterno);
            stmt.setString(4, apellidoMaterno);
            stmt.setBoolean(5, true);  // Marca como que ha votado
            stmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
