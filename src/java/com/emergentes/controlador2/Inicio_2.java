package com.emergentes.controlador2;

import com.emergentes.cudao.CursoDAO;
import com.emergentes.cudao.CursoDAOimpl;
import com.emergentes.modelo2.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio_2", urlPatterns = {"/inicio_2"})
public class Inicio_2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        { try {
            CursoDAO dao = new CursoDAOimpl();
            int id;
            Curso cur = new Curso();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"): "view";
            
            switch(action)
            {
                case "add":
                    request.setAttribute("curso", cur);
                    request.getRequestDispatcher("frmcalifi_2.jsp").forward(request, response);
                    
                break;
                    
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_curso"));
                    cur = dao.getById(id);
                    System.out.println(cur);
                    request.setAttribute("curso", cur);
                    request.getRequestDispatcher("frmcalifi_2.jsp").forward(request, response);
      
                break;
                
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_curso"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/inicio_2");
                    //response.sendRedirect("inicio");
                    
                break;
                    
                case "view":
                    List<Curso> lista = dao.getAll();
                    request.setAttribute("cursos", lista);
                    request.getRequestDispatcher("index_2.jsp").forward(request, response);
                    
                default:
                    
                break;
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error "+ ex.getMessage());
        } 
    }
 }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
     
      int id = Integer.parseInt(request.getParameter("id_curso"));
        String descripcion = request.getParameter("descripcion");
        
         
        Curso cur = new Curso();
        
        cur.setId_curso(id);
        cur.setDescripcion(descripcion);
 
        if(id == 0)
        {
            try
            {
                CursoDAO dao  = new CursoDAOimpl();
                dao.insert(cur);
                response.sendRedirect(request.getContextPath()+"/inicio_2");
            }   
            catch (Exception ex)
            {
                System.out.println("Error " + ex.getMessage());
            }
        }
        else
        {
            try
            {
                CursoDAO dao  = new CursoDAOimpl();
                dao.update(cur);
                response.sendRedirect(request.getContextPath()+"/inicio_2");
            }
            catch (Exception ex)
            {
                System.out.println("Error " + ex.getMessage());
            }
        }
    }
}
