package stock;
import static stock.LaConn.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Backup {
    public static void ooo() {
        try {
            Connection conn = DriverManager.getConnection(HOST, USER, PASSWORD);
            if (conn != null) {
                System.out.println("Connected to the database");

                
                // begin transaction
                conn.setAutoCommit(false);
                try {
                    // Execute insert queries
                    insertClientData(conn);
                    insertProduitData(conn);
                    insertStockData(conn);
                    insertCommandeData(conn);
                    conn.commit();
                } catch (SQLException e) {
                    // Rollback transaction if any operation fails
                    conn.rollback();
                    e.printStackTrace();
                } finally {
                    // Close connection
                    conn.close();
                }
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeInsertQuery(Connection conn, String query) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        }
    }

    public static void insertClientData(Connection conn) throws SQLException {
        String[] clientInsertQueries = {
            "INSERT INTO `client` (`ID_CLIENT`, `NOM_CLIENT`, `ADRESSE`, `date_dajoute`, `CONTACT`) VALUES (1, 'yasser', 'tanger', '2024-03-18 00:53:06', NULL)",
            "INSERT INTO `client` (`ID_CLIENT`, `NOM_CLIENT`, `ADRESSE`, `date_dajoute`, `CONTACT`) VALUES (2, 'youssera ', 'tetouan', '2024-03-18 00:54:16', NULL)",
            "INSERT INTO `client` (`ID_CLIENT`, `NOM_CLIENT`, `ADRESSE`, `date_dajoute`, `CONTACT`) VALUES (3, 'boutaina', 'martil', '2024-03-18 00:55:46', NULL)"
        };

        for (String query : clientInsertQueries) {
            executeInsertQuery(conn, query);
        }
    }

    public static void insertCommandeData(Connection conn) throws SQLException {
        String[] commandeInsertQueries = {
            "INSERT INTO `commande` (`ID_COMMANDE`, `ID_CLIENT`, `date_dajoute`, `ID_PRODUIT`, `QUANTITE_DE_PRODUIT`) VALUES (1, 1, '2024-03-18 00:53:13', 1, 5)",
            "INSERT INTO `commande` (`ID_COMMANDE`, `ID_CLIENT`, `date_dajoute`, `ID_PRODUIT`, `QUANTITE_DE_PRODUIT`) VALUES (2, 3, '2024-03-18 00:55:50', 2, 30)"
        };

        for (String query : commandeInsertQueries) {
            executeInsertQuery(conn, query);
        }
    }

    public static void insertProduitData(Connection conn) throws SQLException {
        String[] produitInsertQueries = {
            "INSERT INTO `produit` (`ID_PRODUIT`, `NOM_PRODUIT`, `date_dajoute`, `PRIX`) VALUES (1, 'btata', '2024-03-18 00:44:41', 3)",
            "INSERT INTO `produit` (`ID_PRODUIT`, `NOM_PRODUIT`, `date_dajoute`, `PRIX`) VALUES (2, 'tefaha', '2024-03-18 00:44:52', 5)",
            "INSERT INTO `produit` (`ID_PRODUIT`, `NOM_PRODUIT`, `date_dajoute`, `PRIX`) VALUES (3, 'maticha', '2024-03-18 00:45:03', 10)",
            "INSERT INTO `produit` (`ID_PRODUIT`, `NOM_PRODUIT`, `date_dajoute`, `PRIX`) VALUES (4, 'banane', '2024-03-18 00:45:34', 6)"
        };

        for (String query : produitInsertQueries) {
            executeInsertQuery(conn, query);
        }
    }

    public static void insertStockData(Connection conn) throws SQLException {
        String[] stockInsertQueries = {
            "INSERT INTO `stock` (`ID_STOCK`, `ID_PRODUIT`, `date_dajoute`, `QUANTITE_DE_PRODUIT`) VALUES (1, 1, '2024-03-18 00:51:29', 50)",
            "INSERT INTO `stock` (`ID_STOCK`, `ID_PRODUIT`, `date_dajoute`, `QUANTITE_DE_PRODUIT`) VALUES (2, 1, '2024-03-18 00:51:34', 60)",

        };

        for (String query : stockInsertQueries) {
            executeInsertQuery(conn, query);
        }
    }
}
