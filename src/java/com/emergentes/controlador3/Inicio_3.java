package com.emergentes.controlador3;
import com.emergentes.insdao.InscripDAO;
import com.emergentes.insdao.InscripDAOimpl;
import com.emergentes.modelo3.Inscripcion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio_3", urlPatterns = {"/inicio_3"})
public class Inicio_3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       { try {
            InscripDAO dao = new InscripDAOimpl();
            int id;
            Inscripcion ins = new Inscripcion();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"): "view";
            
            switch(action)
            {
                case "add":
                    request.setAttribute("inscripcion", ins);
                    request.getRequestDispatcher("frmcalifi_3.jsp").forward(request, response);
                    
                break;
                    
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_ins"));
                    ins = dao.getById(id);
                    System.out.println(ins);
                    request.setAttribute("inscripcion", ins);
                    request.getRequestDispatcher("frmcalifi_3.jsp").forward(request, response);
      
                break;
                
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_ins"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath()+"/inicio_3");
                    //response.sendRedirect("inicio");
                    
                break;
                    
                case "view":
                    List<Inscripcion> lista3 = dao.getAll();
                    request.setAttribute("inscripciones", lista3);
                    request.getRequestDispatcher("index_3.jsp").forward(request, response);
                    
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
            throws ServletException, IOException {
          
       int id = Integer.parseInt(request.getParameter("id_ins"));
       int id_curso = Integer.parseInt(request.getParameter("id_curso"));
       int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
        String nota_final = request.getParameter("nota_final");
     
         
        Inscripcion ins = new Inscripcion();
        
        ins.setId_ins(id);
        ins.setId_curso(id_curso);
        ins.setId_estudiante(id_estudiante);
        ins.setNota_final(nota_final);
          
        if(id == 0)
        {
            try
            {
                InscripDAO dao  = new InscripDAOimpl();
                dao.insert(ins);
                response.sendRedirect(request.getContextPath()+"/inicio_3");
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
                InscripDAO dao  = new InscripDAOimpl();
                dao.update(ins);
                response.sendRedirect(request.getContextPath()+"/inicio_3");
            }
            catch (Exception ex)
            {
                System.out.println("Error " + ex.getMessage());
            }
        }
    }
}
