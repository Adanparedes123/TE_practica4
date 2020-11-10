package com.emergentes.cudao;
import com.emergentes.modelo2.Curso;
import java.util.List;
public interface CursoDAO
{
  public void insert(Curso curso) throws Exception;
    public void update(Curso curso ) throws Exception;
   public void delete(int id_curso) throws Exception;
    public Curso getById(int id_curso) throws Exception;
    public List<Curso> getAll() throws Exception;
}