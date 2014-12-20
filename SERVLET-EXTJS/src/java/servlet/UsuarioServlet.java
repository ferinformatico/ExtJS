package servlet;

import com.fer.model.Usuario;
import com.fer.service.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class UsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String accion = request.getParameter("accion");
            JSONObject jsonRetorno = new JSONObject();

            if (accion!=null && accion.trim().equals("listar")) {
                jsonRetorno.put("ListadeUsuarios", listaUsuarios());
                jsonRetorno.put("success", Boolean.TRUE);

            }
            if (accion==null) {
                String nombre = request.getParameter("nombre");
                String usuario = request.getParameter("usuario");
                String password = request.getParameter("password");
                System.out.println("Nombre:" + nombre + " usuario:" + usuario + "Login:" + password);

                Usuario user = new Usuario();
                user.setNombre(nombre);
                user.setPassword(password);
                user.setUsuario(usuario);

                JSONObject jsonUsuarioSalvo = new JSONObject();

                jsonUsuarioSalvo = salvarUsuario(user);
                jsonRetorno.put("usuario", jsonUsuarioSalvo);
                jsonRetorno.put("success", Boolean.TRUE);

            }

            out.println(jsonRetorno.toString());
            out.close();

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

    private JSONObject salvarUsuario(Usuario user) {
        UsuarioService service = new UsuarioService();
        service.guardarUsuario(user);
        JSONObject jsonUsuario = new JSONObject(user);

        return jsonUsuario;
    }

    private JSONArray listaUsuarios() {

        JSONArray array = new JSONArray();
        UsuarioService service = new UsuarioService();
        List<Usuario> usuarios = service.listarUsuario();
        for (Usuario usuario : usuarios) {
            JSONObject jSONObject = new JSONObject(usuario);
            array.put(jSONObject);
        }

        return array;
    }

}
