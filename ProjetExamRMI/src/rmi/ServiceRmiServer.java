package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.ConnexionBD;

public class ServiceRmiServer extends UnicastRemoteObject implements IServiceRemote {
    
    private static final long serialVersionUID = 1L;
    Connection conn = null;
    ResultSet rs ;
    PreparedStatement ps = null;

    public ServiceRmiServer() throws RemoteException {
        super();
        try {
            // Connexion à la base de données MySQL
        	ConnexionBD  connect = new ConnexionBD();
            conn = connect.connecter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ServiceInsert(String code, String libelle) throws RemoteException {
        try {
            // Insertion des données dans la table SERVICE
            PreparedStatement ps = conn.prepareStatement("INSERT INTO elements (CODE, LIBELLE) VALUES (?, ?)");
            ps.setString(1, code);
            ps.setString(2, libelle);
            ps.executeUpdate();
            ps.close();
            System.out.println("Service ajoute avec success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
        	LocateRegistry.createRegistry(1099);
            // Recherche du serveur RMI
            ServiceRmiServer od = new ServiceRmiServer();
            // Appel de la méthode ServiceInsert pour insérer un service dans la base de données
            System.out.println("Les services ont demarer oui !");
			Naming.rebind("rmi://localhost:1099/Service", od);
//           od.ServiceInsert("mycode", "Service Comptable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

