package com.emergentes.modelo2;
public class Curso
{
    private int id_curso;
    private String descripcion;

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
  
@Override
    public String toString()
    {
        return "Cursos{" + ", id_curso =" + id_curso +
                ", descripcion=" + descripcion + "}";
    }
}
 