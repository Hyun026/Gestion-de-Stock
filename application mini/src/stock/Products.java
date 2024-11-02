package stock;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import static stock.LaConn.*;
import java.util.Scanner;  
import java.util.ArrayList;
            
                        
public class Products {

    
    public static void AddToPRODUIT(Connection conn,String Name, String prix ) {
        try{
        

                
        Map<String, Object> params = new HashMap<>();
        params.put("NOM_PRODUIT", Name);
        params.put("prix", prix);
        String query = GenInsertQuery("PRODUIT", params);
      
        ResultSet q =  executeSqlQuery(conn,query);
        
        }catch(Exception e){
        System.out.println("Invalid Input Or Internal Error | reason :"+e);
        }
        
    }
     
    
    
    
    
   public static Object[] GetProduit() {
    Connection conn = getConnection();
    String query = "SELECT * FROM PRODUIT";
    ResultSet rs = executeSqlQuery(conn, query);
    
    ArrayList<Object[]> resultList = new ArrayList<>();
    
    try {
        while (rs.next()) {
            int id = rs.getInt("id_PRODUIT");
            String name = rs.getString("NOM_PRODUIT");
            float price = rs.getFloat("prix");
            String date_dajoute = rs.getString("date_dajoute");
            
            // Create an array to hold the data for each row
            Object[] rowData = new Object[] {id, name, date_dajoute, price};
            
            // Add the row data to the result list
            resultList.add(rowData);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    // Convert the ArrayList to an array if needed
    Object[] resultArray = resultList.toArray();
    
    return resultArray;
}
     
  public static void DeleteProduit(int productId) {
    Connection conn = getConnection();
    String query = "DELETE FROM PRODUIT WHERE id_PRODUIT = ?";
    
    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, productId);
        
        // Execute the delete statement
        int rowsAffected = pstmt.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("No product found with ID: " + productId);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
