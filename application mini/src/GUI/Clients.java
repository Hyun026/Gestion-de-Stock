
package GUI;

/**
 *
 * @author AzComputer
 */
import static stock.LaConn.executeSqlQuery;
import static stock.LaConn.getConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Clients {
    
    public static int SearchClientByName(Connection conn, String name) {
    try {
        Scanner scanner = new Scanner(System.in);
        String query = "SELECT ID_CLIENT, NOM_CLIENT, ADRESSE FROM CLIENT WHERE NOM_CLIENT LIKE ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, "%" + name + "%");

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            if (!rs.isLast()) {
                System.out.println("Multiple clients found. Please enter the ID of the correct client:");
                do {
                    int clientId = rs.getInt("ID_CLIENT");
                    String clientName = rs.getString("NOM_CLIENT");
                    String clientAddress = rs.getString("ADRESSE");
                    System.out.println("ID: " + clientId + ", Name: " + clientName + ", Address: " + clientAddress);
                } while (rs.next());

                System.out.print("Enter the ID of the correct client (or 0 to create a new client): ");
                int selection = scanner.nextInt();
                if (selection != 0) {
                    return selection;
                }
            } else {
                int clientId = rs.getInt("ID_CLIENT");
                String clientName = rs.getString("NOM_CLIENT");
                String clientAddress = rs.getString("ADRESSE");
                System.out.println("Client found:");
                System.out.println("ID: " + clientId);
                System.out.println("Name: " + clientName);
                System.out.println("Address: " + clientAddress);
                System.out.print("Is this the correct user? (yes/no): ");
                String input = scanner.next();
                if (input.equalsIgnoreCase("yes")) {
                    return clientId;
                }
            }
        } else {
            System.out.println("Client not found.");
            System.out.println("Creating a new client...");
            System.out.print("Enter the client's address: ");
            String address = scanner.nextLine();
            System.out.print("Enter the client's contact: ");
            String contact = scanner.nextLine();
            return CreateClient(conn, name, address, contact);
        }

        return -1;
    } catch (SQLException e) {
        System.out.println("Failed to search for client. Error: " + e.getMessage());
        return -1;
    }
}
//getClient
  public static Object[][] GetClient() {
    Connection conn = getConnection(); 
    String query = "SELECT ID_CLIENT, NOM_CLIENT, ADRESSE, CONTACT FROM CLIENT";
    ResultSet rs = executeSqlQuery(conn, query); 
    
    ArrayList<Object[]> resultList = new ArrayList<>();
    
    try {
        while (rs.next()) {
            int id = rs.getInt("ID_CLIENT");
            String name = rs.getString("NOM_CLIENT");
            String address = rs.getString("ADRESSE");
            String contact = rs.getString("CONTACT");
            
            // Create an array to hold the data for each row
            Object[] rowData = new Object[] {id, name, address, contact};
            
            // Add the row data to the result list
            resultList.add(rowData);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    Object[][] resultArray = new Object[resultList.size()][];
    resultList.toArray(resultArray);
    
    return resultArray;
}
  
  //deleteClient
  public static boolean deleteClient(int clientId) {
    try {
        Connection conn = getConnection();
        String query = "DELETE FROM CLIENT WHERE ID_CLIENT = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, clientId);

        int rowsAffected = pstmt.executeUpdate();
        pstmt.close();

        // Check if any rows were affected by the deletion
        if (rowsAffected > 0) {
            System.out.println("Client with ID " + clientId + " deleted successfully.");
            return true;
        } else {
            System.out.println("No client found with ID " + clientId + ".");
            return false;
        }
    } catch (SQLException e) {
        System.out.println("Failed to delete client. Error: " + e.getMessage());
        return false;
    }
}
    
    
    
    
    
    
    
    
   public static int CreateClient(Connection conn, String name, String address, String contact) {
    try {
        String query = "INSERT INTO CLIENT (NOM_CLIENT, ADRESSE, CONTACT) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, name);
        pstmt.setString(2, address);
        pstmt.setString(3, contact);

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected == 0) {
            System.out.println("Creating client failed, no rows affected.");
            return -1;
        }

        ResultSet generatedKeys = pstmt.getGeneratedKeys();
        int newClientId = -1;
        if (generatedKeys.next()) {
            newClientId = generatedKeys.getInt(1);
        } else {
            System.out.println("Creating client failed, no ID obtained.");
            return -1;
        }

        generatedKeys.close();
        pstmt.close();

        return newClientId;
    } catch (SQLException e) {
        System.out.println("Failed to add new client. Error: " + e.getMessage());
        return -1;
    }
}
}