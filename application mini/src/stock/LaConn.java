
package stock;

import java.sql.*;
import java.util.Map;
public class LaConn<ALTER, IDENTIFIED> {

    //change the password in the url and in  the backup file and laconn.CreateDataBase 
    // the name of data base should stay the same
    public static final String USER = "root";
        public static final String HOST = "jdbc:mysql://localhost:3306/stock";
        public static final String PASSWORD = "123456";
        

    
  public static void createDatabase() {
      
    final String url = "jdbc:mysql://localhost:3306/?user=root&password=123456";
    final String databaseName = "stock";
    
    try (Connection conn = DriverManager.getConnection(url)) {
        if (conn == null) {
            System.err.println("Failed to make connection!");
            return;
        }

        try (Statement stmt = conn.createStatement()) {
            
            try{
            stmt.executeUpdate("Drop database " + databaseName);
            }catch(Exception e){
                System.out.print("");
            }
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + databaseName);
            
            // Use the created database
            stmt.executeUpdate("USE " + databaseName);
            
            // Create tables
            createTable(stmt, "USER","id INT AUTO_INCREMENT PRIMARY KEY,"+
                        "username VARCHAR(50) UNIQUE,"+
                            " password VARCHAR(50)");
            createTable(stmt, "CLIENT", 
                        "ID_CLIENT int auto_increment PRIMARY KEY, " +
                        "NOM_CLIENT varchar(55) null, " +
                        "ADRESSE varchar(100) null, " +
                        "date_dajoute datetime DEFAULT current_timestamp(), " +
                        "CONTACT varchar(100) null");

            createTable(stmt, "PRODUIT", 
                        "ID_PRODUIT int auto_increment PRIMARY KEY, " +
                        "NOM_PRODUIT varchar(55) null, " +
                        "date_dajoute datetime DEFAULT current_timestamp(), " +
                        "PRIX float null");

            createTable(stmt, "STOCK", 
                        "ID_STOCK int auto_increment PRIMARY KEY, " +
                        "ID_PRODUIT int not null, " +
                        "date_dajoute datetime DEFAULT current_timestamp(), " +
                        "QUANTITE_DE_PRODUIT int not null, " +
                        "FOREIGN KEY (ID_PRODUIT) REFERENCES PRODUIT(ID_PRODUIT) on update cascade on delete cascade");

            createTable(stmt, "COMMANDE", 
                        "ID_COMMANDE int auto_increment PRIMARY KEY, " +
                        "ID_CLIENT int not null, " +
                        "date_dajoute datetime DEFAULT current_timestamp(), " +
                        "ID_PRODUIT int not null, " +
                        "QUANTITE_DE_PRODUIT int null, " +
                        "FOREIGN KEY (ID_CLIENT) REFERENCES CLIENT(ID_CLIENT) on update cascade on delete cascade, " +
                        "FOREIGN KEY (ID_PRODUIT) REFERENCES PRODUIT(ID_PRODUIT) on update cascade on delete cascade");
        }

        System.out.println("[*] Database and tables are loaded successfully.");

    } catch (SQLException e) {
        System.err.println("SQLException: " + e.getMessage());
    }
}

private static void createTable(Statement stmt, String tableName, String tableColumns) throws SQLException {
    stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + tableName + " (" + tableColumns + ")");
}

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(HOST, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
        } catch (SQLException e) {
            System.err.println("Connection to MySQL failed!");
        }
        return connection;
    }
public static ResultSet executeSqlQuery(Connection connection, String query) {
    ResultSet resultSet = null;
    try {
        PreparedStatement statement = connection.prepareStatement(query);
        
        if (query.trim().toLowerCase().startsWith("select")) {
            resultSet = statement.executeQuery();
        } else {
            statement.executeUpdate(); 
        }
    } catch (SQLException e) {
        System.err.println("Failed to execute query: " + query);
        e.printStackTrace();
    }
    return resultSet;
}

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Failed to close the connection to MySQL!");
            }
        }
    }

    
    
public static String GenInsertQuery(String tableName, Map<String, Object> fieldValues) {
    StringBuilder queryBuilder = new StringBuilder();
    queryBuilder.append("INSERT INTO ").append(tableName).append(" (");

    for (String fieldName : fieldValues.keySet()) {
        queryBuilder.append(fieldName).append(", ");
    }
    queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length());
    queryBuilder.append(") VALUES (");

    for (Object value : fieldValues.values()) {
        if (value instanceof String) {
            queryBuilder.append("'").append(value).append("', ");
        } else {
            queryBuilder.append(value).append(", ");
        }
    }
    queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length());
    queryBuilder.append(")");

    return queryBuilder.toString();
}
    public static String GenUpdateQuery(String tableName, Map<String, Object> fieldValues, String condition) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("UPDATE ").append(tableName).append(" SET ");

        for (Map.Entry<String, Object> entry : fieldValues.entrySet()) {
            String fieldName = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof String) {
                queryBuilder.append(fieldName).append("='").append(value).append("', ");
            } else {
                queryBuilder.append(fieldName).append("=").append(value).append(", ");
            }
        }
        queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length());
        
        if (condition != null && !condition.isEmpty()) {
            queryBuilder.append(" WHERE ").append(condition);
        }

        return queryBuilder.toString();
    }

    public static void executeInTransaction(Connection connection, String[] queries) {
        if (connection == null || queries == null || queries.length == 0) {
            return;
        }

        try {
            connection.setAutoCommit(false); // Start transaction
            Statement statement = connection.createStatement();

            for (String query : queries) {
                statement.addBatch(query);
            }

            statement.executeBatch();
            connection.commit(); // Commit transaction
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback(); // Rollback transaction if any query fails
                }
            } catch (SQLException rollbackException) {
                System.err.println("Failed to rollback transaction: " + rollbackException.getMessage());
            }
            System.err.println("Failed to execute batch queries: " + e.getMessage());
        }
    }


}

