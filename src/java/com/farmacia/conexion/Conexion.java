
package com.farmacia.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface Conexion {

    public void conectar();

    public Connection getConexion();

    public void desconectar();

 
}
