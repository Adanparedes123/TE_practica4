package com.emergentes.utiles;
import java.sql.DriverManager;
import java.sql.*;
public class ConexionDB 
{
    static String driver="com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_calificaciones";
    static String usuario = "root";
    static String password = "";
    
    protected Connection conn = null;
    
    public ConexionDB()
    {
        try {
            Class.forName(driver);
            
            conn =(Connection) DriverManager.getConnection(url, usuario, password);
            if(conn != null)
            {
                System.out.println("Conexion Ok: " + conn);
            }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println("Error de SQL: " + e);
        }
    }
    
    public Connection conectar()
    {
        return conn;
    }
    
    public void desconectar()
    {
        System.out.println("Cerrando la BD:" + conn);
        try
        {
            conn.close();
        }
        catch(SQLException ex)
        {
            System.out.println("Error de SQL: " + ex.getMessage());
        }
    }
}
