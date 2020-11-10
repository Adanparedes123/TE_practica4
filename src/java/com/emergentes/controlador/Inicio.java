package com.emergentes.controlador;
import com.emergentes.esdao.EstudianteDAOimpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.esdao.EstudianteDAO;
import com.emergentes.modelo.Estudiante;

@WebServlet(name = "Inicio", urlPatterns = {"/inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    { try {
            EstudianteDAO dao = new EstudianteDAOimpl();
            int id;
            Estudiante cal = new Estudiante();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"): "view";
            
            switch(action)
            {
                case "add":
                    request.setAttribute("estudiante", cal);
                    request.getRequestDispatcher("frmcalifi.jsp").forward(request, response);
                    
                break;
                    
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_estudiante"));
                    cal = dao.getById(id);
                    System.out.println(cal);
                    request.setAttribute("estudiante", cal);
                    request.getRequestDispatcher("frmcalifi.jsp").forward(request, response);
      
                break;
                
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_estudiante"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/inicio");
                    //response.sendRedirect("inicio");
                    
                break;
                    
                case "view":
                    List<Estudiante> lista = dao.getAll();
                    request.setAttribute("estudiantes", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    
                default:
                    
                break;
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error "+ ex.getMessage());
        } 
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
      int id = Integer.parseInt(request.getParameter("id_estudiante"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String correo = request.getParameter("correo");
         
        Estudiante cal = new Estudiante();
        
        cal.setId_estudiante(id);
        cal.setNombre(nombre);
        cal.setApellidos(apellidos);
        cal.setCorreo(correo);
          
        if(id == 0)
        {
            try
            {
                EstudianteDAO dao  = new EstudianteDAOimpl();
                dao.insert(cal);
                response.sendRedirect(request.getContextPath()+"/inicio");
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
                EstudianteDAO dao  = new EstudianteDAOimpl();
                dao.update(cal);
                response.sendRedirect(request.getContextPath()+"/inicio");
            }
            catch (Exception ex)
            {
                System.out.println("Error " + ex.getMessage());
            }
        }
    }
}
