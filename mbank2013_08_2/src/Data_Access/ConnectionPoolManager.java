package Data_Access;

import java.util.*;
import java.sql.*;
import java.util.*;
import java.sql.*;

public class ConnectionPoolManager{

	private  String databaseUrl = "jdbc:mysql://localhost:3306/mbank";
	private  String userName = "root";
	private  String password = "root";
	
	
	//String databaseName,
		 public  ConnectionPoolManager(String databaseUrl,String userName,String password) {
		  this.databaseUrl = databaseUrl;
		  this.userName = userName;
		  this.password = password;
		  initialize();
		 }

	
	List<Connection> connectionPool = new ArrayList<Connection>();

	 public ConnectionPoolManager(){
	  initialize();
	 }

	 private void initialize(){
	  //Here we can initialize all the information that we need
	  initializeConnectionPool();
	 }

	 private void initializeConnectionPool(){
		 
	  while(!checkIfConnectionPoolIsFull()){
//System.out.println("Connection Pool is NOT full. Proceeding with adding new connections");
	   //Adding new connection instance until the pool is full
	   connectionPool.add(createNewConnectionForPool());
	  }
//System.out.println("Connection Pool is full.");
	 }

	 private synchronized boolean checkIfConnectionPoolIsFull(){
	  final int MAX_POOL_SIZE = 10 ;

	  //Check if the pool size
	  if(connectionPool.size() < MAX_POOL_SIZE){
	   return false;
	  }

	  return true;
	 }

	 //Creating a connection
	 private Connection createNewConnectionForPool(){
	  Connection connection = null;

	  try {
	   Class.forName("com.mysql.jdbc.Driver");
	   connection = DriverManager.getConnection(databaseUrl, userName, password);
// System.out.println("Connection: "+connection);
	  }
	  catch(SQLException sqle) {
	   System.err.println("SQLException: "+sqle);
	   return null;
	  }
	  catch(ClassNotFoundException cnfe){
	   System.err.println("ClassNotFoundException: "+cnfe);
	   return null;
	  }

	  return connection;
	 }

	 public synchronized Connection getConnectionFromPool() {
	  Connection connection = null;

	  //Check if there is a connection available. There are times when all the connections in the pool may be used up
	  
	  
	  if(connectionPool.size() > 0) {
	   connection = (Connection) connectionPool.get(0);
	   connectionPool.remove(0);
	  }
	  //Giving away the connection from the connection pool
	  return connection;
	 }

	 public synchronized void returnConnectionToPool(Connection connection){
	  //Adding the connection from the client back to the connection pool
	  connectionPool.add(connection);
	 }

	public Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}
	
} 

