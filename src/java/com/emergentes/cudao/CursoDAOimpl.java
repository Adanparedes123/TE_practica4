package com.emergentes.cudao;

import com.emergentes.modelo2.Curso;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOimpl extends ConexionDB implements CursoDAO {

    @Override
    public void insert(Curso curso) throws Exception {
         try
        {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("INSERT into cursos (descripcion) values (?)");
            ps.setString(1, curso.getDescripcion()); 
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
    public void update(Curso curso) throws Exception {
      try
        {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("UPDATE cursos set descripcion = ? where id_curso = ? ");
            ps.setString(1, curso.getDescripcion());
            ps.setInt(2, curso.getId_curso());
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
    public void delete(int id_curso) throws Exception {
       try
        {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("DELETE FROM cursos WHERE id_curso = ?");
            ps.setInt(1, id_curso);
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
    public Curso getById(int id_curso) throws Exception {
       Curso cur = new Curso();
        try
        {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("SELECT * FROM cursos WHERE id_curso = ? ");
            ps.setInt(1, id_curso);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            { 
                cur.setId_curso(rs.getInt("id_curso"));
                cur.setDescripcion(rs.getString("descripcion"));        
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
        return cur;
    }
    @Override
    public List<Curso> getAll() throws Exception {
   List<Curso> lista1 = null;
        try
        {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("SELECT * FROM cursos");
            ResultSet rs = ps.executeQuery();
            
            lista1 = new ArrayList<Curso>();
            
            while(rs.next())
            {
                Curso cur = new Curso();
                cur.setId_curso(rs.getInt("id_curso"));
                cur.setDescripcion(rs.getString("descripcion"));
                
                lista1.add(cur);
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
        return lista1;
    } 
}
