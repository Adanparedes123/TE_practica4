package com.emergentes.insdao;
import com.emergentes.modelo3.Inscripcion;
import java.util.List;
public interface InscripDAO 
{
    
  public void insert(Inscripcion inscripcion) throws Exception;
    public void update(Inscripcion inscripcion ) throws Exception;
   public void delete(int id_ins) throws Exception;
    public Inscripcion getById(int id_ins) throws Exception;
    public List<Inscripcion> getAll() throws Exception;
}