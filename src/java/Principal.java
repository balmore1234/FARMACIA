/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.farmacia.entidad.Menu;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Lenovo B4080
 */
@WebServlet(name="Principal", urlPatterns = {"/Principal"})
public class Principal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
       if (request.getSession().getAttribute("Usuario")== null){
           response.sendRedirect("Login");
       }else {
             HttpSession s = request.getSession();
             List<Menu> per = (List<Menu>)s.getAttribute("Permisos");
            //List<Menu> MenuPrincipal = per.stream().filter(field -> field.getIdpadre()==0).collect(Collectors.toList());
            //request.setAttribute("MenuPrincipal", MenuPrincipal);
             String op = request.getParameter("op");
             if(op!=null){
                 List<Menu> PermisosAsignados = per.stream().filter(field -> field.getIdpadre()==Integer.parseInt(op)).collect(Collectors.toList());
                 request.setAttribute("PermisosAsignados", PermisosAsignados);
             }
             if(null == accion){
                 request.getRequestDispatcher("principal.jsp").forward(request, response);
                
             }
             else switch(accion){
                 case "logout":
             logout(request, response);
             break;
                case "1":
                    request.getRequestDispatcher("principal.jsp").forward(request, response);
                    break;
                case "2":
                    response.sendRedirect("Categorias");
                    break;
                case "3":
                    response.sendRedirect("Productos");
                    break;
                case "4":
                    response.sendRedirect("Clientes");
                    break;
                case "5":
                    response.sendRedirect("Documentos");
                    break;
                case "6":
                    response.sendRedirect("Presentaciones");
                    break;
                case "7":
                    response.sendRedirect("Proveedores");
                    break;
               
               
                default:
                    response.sendRedirect("index.jsp");
                    break;
            }
        }
    }
private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
    HttpSession sesion = request.getSession();
    sesion.removeAttribute("Usuario");
    sesion.removeAttribute("Nombre");
    sesion.removeAttribute("Rol");
    sesion.invalidate();
    response.sendRedirect("Login");
}
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
