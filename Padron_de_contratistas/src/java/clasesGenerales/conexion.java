package clasesGenerales;

import mx.gob.sefiplan.daoMDB.Conexion;


public class conexion extends Conexion {
  
    public conexion() {                 

        super.setDriver("com.mysql.jdbc.Driver");
        super.setServidor("jdbc:mysql://10.1.40.15:3306/Contratistas");
        //super.setServidor("jdbc:jtds:sqlserver://10.1.40.180:1433//PADRONCON;tds=4.2;charset=cp1252");
        super.setUsuario("usr_padron");
        super.setPassword("Padron135");

  }
    
    
    
    


}