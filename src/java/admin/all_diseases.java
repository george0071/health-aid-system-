/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joseph
 */
public class all_diseases extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet all_diseases</title>");
            out.println("<link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css\" rel=\"stylesheet\" integrity=\"sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1\" crossorigin=\"anonymous\">");
            out.println("<link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class='container'>");
            out.println("<div class='row'>");

            out.println("<h1>Admin</h1>");

            out.println("<div class='panel panel-default'>");
            out.println("<div class='panel-heading'>");
            out.println("<h3 class='panel-title'>Diseases</h3>");
            out.println("</div>");
            out.println("<div class='panel-body'>");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/mambo";
                String user = "root";
                String password = "";

                Connection conn = DriverManager.getConnection(url, user, password);
                Statement st = conn.createStatement();

                String myuser = "SELECT * FROM diseases";

                ResultSet rs = st.executeQuery(myuser);

                out.println("Currently");
                out.println("<table class='table table-hover table-striped'>");
                out.println("<thead>");
                out.println("<th>Name</th>");
                out.println("<th>Edit</th>");
                out.println("<th>Delete</th>");
                out.println("</thead>");
                out.println("<tbody>");
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(rs.getString("d_name"));
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<a href=''><i class='fa fa-edit'></i></a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<a href=''><i class='fa fa-trash'></i></a>");
                    out.println("</td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
                out.println("</table>");

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(all_diseases.class.getName()).log(Level.SEVERE, null, ex);
            }

            out.println("</div>");
            out.println("</div>");

            out.println("</div>");
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
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
