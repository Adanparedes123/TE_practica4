package com.emergentes.insdao;

import com.emergentes.modelo.Estudiante;
import com.emergentes.modelo2.Curso;
import com.emergentes.modelo3.Inscripcion;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InscripDAOimpl extends ConexionDB implements InscripDAO
{

    @Override
    public void insert(Inscripcion inscripcion) throws Exception 
    {
        try
        {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("INSERT into inscripciones (id_curso, id_estudiante, nota_final) values (?, ?, ?)");
            ps.setInt(1, inscripcion.getId_curso());
            ps.setInt(2, inscripcion.getId_estudiante());
            ps.setString(3, inscripcion.getNota_final());
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
    public void update(Inscripcion inscripcion) throws Exception
    {
 try
        {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("UPDATE inscripciones set id_curso = ?, id_estudiante = ?, nota_final = ? where id_ins = ? ");
            ps.setInt(1, inscripcion.getId_curso());
            ps.setInt(2, inscripcion.getId_estudiante());
            ps.setString(3, inscripcion.getNota_final());
            ps.setInt(4, inscripcion.getId_ins());
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
    public void delete(int id_ins) throws Exception
    {
         try
        {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("DELETE FROM inscripciones WHERE id_ins = ?");
            ps.setInt(1, id_ins);
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
    public Inscripcion getById(int id_ins) throws Exception
    {
        Inscripcion ins = new Inscripcion();
        try
        {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement ("SELECT * FROM inscripciones WHERE id_ins = ? ");
            ps.setInt(1, id_ins);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            { 
                
                ins.setId_ins(rs.getInt("id_ins"));
                ins.setId_curso(rs.getInt("id_curso"));
                ins.setId_estudiante(rs.getInt("id_estudiante"));
                ins.setNota_final(rs.getString("nota_final"));
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
        return ins;
    }  
    @Override
    public List<Inscripcion> getAll() throws Exception 
    {      
               List<Curso> lista1 = null;
               List<Estudiante> lista = null;
               List<Inscripcion> lista3 = null;
        try
        {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement (" SELECT * from inscripciones");
            
            ResultSet rs = ps.executeQuery();
            
            lista1 = new ArrayList<Curso>();
            lista = new ArrayList<Estudiante>();
            lista3 = new ArrayList<Inscripcion>();
            
            while(rs.next())
            {
                Inscripcion ins = new Inscripcion();
                ins.setId_ins(rs.getInt("id_ins"));
               
                 ins.setId_curso(rs.getInt("id_curso"));
                ins.setId_estudiante(rs.getInt("id_estudiante"));
                ins.setNota_final(rs.getString("nota_final"));
                
                lista3.add(ins);
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
        return lista3;
    } 
}

