package com.emergentes.esdao;
import com.emergentes.modelo.Estudiante;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOimpl extends ConexionDB implements EstudianteDAO {

    @Override
    public void insert(Estudiante estudiante) throws Exception 
    {
        try
        {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("INSERT into estudiantes (nombre, apellidos, correo) values (?, ?, ?)");
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getCorreo());
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }     
    } 
    @Override
    public void update(Estudiante estudiante) throws Exception {
    try
        {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("UPDATE estudiantes set nombre = ?, apellidos = ?, correo = ? where id_estudiante = ? ");
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getCorreo());
            ps.setInt(4, estudiante.getId_estudiante());
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    @Override
    public void delete(int id_estudiante) throws Exception {
    try
        {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("DELETE FROM estudiantes WHERE id_estudiante = ?");
            ps.setInt(1, id_estudiante);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }

    @Override
    public Estudiante getById(int id_estudiante) throws Exception {
            Estudiante cal = new Estudiante();
        try
        {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("SELECT * FROM estudiantes WHERE id_estudiante = ? ");
            ps.setInt(1, id_estudiante);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            { 
                cal.setId_estudiante(rs.getInt("id_estudiante"));
                cal.setNombre(rs.getString("nombre"));
                cal.setApellidos(rs.getString("apellidos"));
                cal.setCorreo(rs.getString("correo"));
            }
        }
        catch(Exception e)
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return cal;
    }
    
    @Override
    public List<Estudiante> getAll() throws Exception {
        List<Estudiante> lista = null;
        try
        {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("SELECT * FROM estudiantes");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Estudiante>();
            
            while(rs.next())
            {
                Estudiante cal = new Estudiante();
                cal.setId_estudiante(rs.getInt("id_estudiante"));
                cal.setNombre(rs.getString("nombre"));
                cal.setApellidos(rs.getString("apellidos"));
                cal.setCorreo(rs.getString("correo"));
                
                lista.add(cal);
            }
            rs.close();
            ps.close();
        }
        catch(Exception e)
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        return lista;
    } 
}
