package Data_Access;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Core_System.Account;
import Core_System.Client;
import Data_Access.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientsDBManager implements ClientSManager {
	private static ClientsDBManager instance;

	private ClientsDBManager() {
	}

	public static ClientsDBManager getInstance() {
		if (instance == null) {
			instance = new ClientsDBManager();
		}
		return instance;
	}

	/** insert/create clients in to DB */
	@Override
	public boolean createNewClient(Connection con, Client c) {

		try {

			String sql = "insert into clients value (?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setLong(1, c.getClient_id());
			pstmt.setString(2, c.getClient_name());
			pstmt.setString(3, c.getPassword());
			pstmt.setString(4, c.getType().name());
			pstmt.setString(5, c.getAddress());
			pstmt.setString(6, c.getEmail());
			pstmt.setString(7, c.getPhone());
			pstmt.setString(8, c.getComment());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/** update clients data - It works good */
	@Override
	public void updateclients(Connection con, Client c) {

		try {
			PreparedStatement pstmt = con
					.prepareStatement("update clients set client_name =?, password = ?, type = ? , address = ?, email = ?, phone = ?, comment = ? where client_id = ? ");
			pstmt.setString(1, c.getClient_name());
			pstmt.setString(2, c.getPassword());
			pstmt.setString(3, c.getType().name());
			pstmt.setString(4, c.getAddress());
			pstmt.setString(5, c.getEmail());
			pstmt.setString(6, c.getPhone());
			pstmt.setString(7, c.getComment());
			pstmt.setInt(8, c.getClient_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/** prepare statements to select clients */
	@Override
	public Client selectClient(Connection con, Client c) {
		Client clientToReturn = null;
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from clients where client_id = ?");
			pstmt.setInt(1, c.getClient_id());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				clientToReturn = new Client(rs.getInt(1));
				clientToReturn.setClient_id(rs.getInt(1));
				clientToReturn.setClient_name(rs.getString(2));
				clientToReturn.setPassword(rs.getString(3));
				/** converting ENUM to string use -> valueOf() **/
				clientToReturn.setType(Type.valueOf(rs.getString(4)));
				clientToReturn.setAddress(rs.getString(5));
				clientToReturn.setEmail(rs.getString(6));
				clientToReturn.setPhone(rs.getString(7));
				clientToReturn.setComment(rs.getString(8));

			} else {
				System.err.println("No client founed");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(clientToReturn);
		return clientToReturn;

	}

	@Override
	public boolean deleteClient(Connection con, Client c) {

		try {
			PreparedStatement pstmt = con
					.prepareStatement("delete from clients where client_id =?");
			pstmt.setInt(1, c.getClient_id());
			int success = pstmt.executeUpdate();
			if (success == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public List<Client> getAllClients(Connection con) {
		// TODO Auto-generated method stub
		Statement stmt = null;
	    String query =
	        "select client_id, client_name, password, type, address,email,phone,comment "  + "from "  + " clients";
	    List<Client> clients = new ArrayList<Client>();
	    try {
	        stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        while (rs.next()) {
	            int client_id = rs.getInt("client_id");
	            String client_name = rs.getString("client_name");
	            String password = rs.getString("password");
	            Type type = Type.valueOf(rs.getString("type"));
	            String address = rs.getString("address");
	            String email = rs.getString("email");
	            String phone = rs.getString("phone");
	            String comment = rs.getString("comment");
//	            
//	            System.out.println(client_id + "\t" + client_name +
//	                               "\t" + password + "\t" + type +
//	                               "\t" + address + "\t" + phone + "\t" +comment );
	            //TODO Convert ENUM to String
	            clients.add(new Client(client_id, client_name, password,type, address,email,phone,comment));
	        }  
	    } catch (SQLException e ) {
	    	
	    }
		return clients;
	}

}// END OF CLASS
