package com.emergentes.modelo3;
public class Inscripcion 
{
    private int id_ins;
    private int id_curso;
    private int id_estudiante;
    private String nota_final;

    public int getId_ins() {
        return id_ins;
    }
    public void setId_ins(int id_ins) {
        this.id_ins = id_ins;
    }
    public int getId_curso() {
        return id_curso;
    }
    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }
    public int getId_estudiante() {
        return id_estudiante;
    }
    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }
    public String getNota_final() {
        return nota_final;
    }
    public void setNota_final(String nota_final) {
        this.nota_final = nota_final;
    }
   
@Override
    public String toString()
    {
        return "Inscripciones{" + ", id_ins =" + id_ins + ",id_curso=" + id_curso + 
                ", id_estudiante=" + id_estudiante + ", nota_final=" + nota_final+ "}";
    }
}
 
        