import Clases.Producto;
import Clases.ProductoController;
import Clases.ConexionBaseDeDatos;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    Producto producto;
    ProductoController registroproducto;
    Producto[] productoRegistrado;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter respuesta = response.getWriter()) {
        respuesta.write("");
        registroproducto = new ProductoController();
        String control = request.getParameter("control");
        StringBuffer objetoRespuesta = new StringBuffer();
        if (control != null) {
            if (control.toUpperCase().equals("GUARDAR")) {
                // Se crea el objeto producto con los datos recibidos del navegador a través de la petición HTTP
                
                producto = new Producto(
                        Integer.parseInt(request.getParameter("codigo_producto")),
                        request.getParameter("nombre_producto"),
                        request.getParameter("Precio"),
                        request.getParameter("Existencia"),
                        request.getParameter("Fechavencimiento"),
                        request.getParameter("id_marca"),
                        request.getParameter("id_categoria"),
                registroproducto.guardarProducto(producto)); // Almacenarlo en BD
            } else if (control.toUpperCase().equals("ELIMINAR")) {
                int codigoEliminar = Integer.parseInt(request.getParameter("codigo"));
                registroproducto.eliminarproducto(codigoEliminar);
            }
        }

        registroproducto.getProducto(objetoRespuesta); // Consultar productos en la BD
        respuesta.write(objetoRespuesta.toString());
    }
}


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
