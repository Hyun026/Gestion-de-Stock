
import GUI.RegisterFrame;
import static stock.LaConn.*;
import static stock.Backup.*;

import java.io.IOException;
import java.sql.SQLException;



public class AppLuncher {

    public static void main(String[] args)throws IOException, SQLException {
        
        createDatabase();
        ooo();

        //change password host in stock/LaConn.java and stock/backup.java and Conn/Constants.java
        
               RegisterFrame form=new RegisterFrame();
               form.setVisible(true);
    }
}
