/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GeorgeF
 */
public class demo extends HttpServlet {

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

        String myfirm = request.getParameter("one");

        PrintWriter d = response.getWriter();
        // d.println("text here = " + myfirm);

        // START HEADER
        d.println("<!DOCTYPE html>\n"
                + "<!--\n"
                + "To change this license header, choose License Headers in Project Properties.\n"
                + "To change this template file, choose Tools | Templates\n"
                + "and open the template in the editor.\n"
                + "-->\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Health Aid </title>\n"
                + "        <link rel=\"stylesheet\" type=\"text/css\" href=\"Style.css\" />\n"
                + "        <link rel=\"stylesheet\" type=\"text/css\" href=\"1000px.css\" media=\"screen and (max-width:800px)\"/>\n"
                + "        <link rel=\"stylesheet\" type=\"text/css\" href=\"menu.css\" />\n"
                + "              \n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <div id=\"container\">\n"
                + "            <div id=\"header\" >\n"
                + "              <marquee> <p><h1> Health Aid System</h1></p></marquee>\n"
                + "                </div>\n"
                + "               <div id =\"menu\" >\n"
                + "                   <ul>\n"
                + "                       <li><a href=\"http://localhost:8080/health_aid_system/index.html\">Home</a></li>\n"
                + "                        <li><a href=\"http://localhost:8080/health_aid_system/index2.html\">Service</a></li>\n"
                + "                         <li><a href=\"http://localhost:8080/health_aid_system/index3.html\">About</a></li>\n"
                + "                          <li><a href=\"#\">Contact</a></li>\n"
                + "                   </ul>\n"
                + "                          \n"
                + "                </div>\n"
                + "            <div id=\"content\">\n"
                + "                <div id=\"picture\">\n"
                + "                    <img src=\"jojo.JPG\" height=\"400\" width=\"700\" alt=\"doctar_jojo\">\n"
                + "                </div>");
        d.println("<div id=\"mainbody\">");

        // END HEADER
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mambo";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();

            String myuser = "select * from diseases, prescriptions, symptoms where diseases.d_id = prescriptions.d_id and symptoms.s_id = prescriptions.s_id and symptoms.s_name like '%" + myfirm + "%';";

            ResultSet rs = st.executeQuery(myuser);

            int counter = 1;
            // Find a way to calculate the total number of rows returned
            //counter = rs.total_rows;
     
            if (counter > 0) {

                d.println("<h2>According to your symptom, we recommend the following prescription(s)</h2>");
                d.println("<table border='1'>");
                d.println("<thead>");
                d.println("<th>Disease</th>");
                d.println("<th>Prescription</th>");
                d.println("</thead>");
                d.println("<tbody>");
                while (rs.next()) {
                    d.println("<tr>");
                    String d_name = rs.getString("d_name");
                    String p_name = rs.getString("p_name");

                    d.println("<td>");
                    d.println(d_name);
                    d.println("</td>");

                    d.println("<td>");
                    d.println(p_name);
                    d.println("</td>");

                    d.println("</tr>");
                }
                d.println("</tbody>");
                d.println("</table>");
            } else {
                d.println("<h2>Empty</h2>");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(reg.class.getName()).log(Level.SEVERE, null, ex);
        }

        d.println("</div>\n"
                + "                </div>\n"
                + "            <div id=\"footer\"> \n"
                + "            Copyright &copy;2016 fonso_BM. \n"
                + "            </div>\n"
                + "        \n"
                + "        \n"
                + "        \n"
                + "        </div>\n"
                + "            \n"
                + "    </body>\n"
                + "</html>");

        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mambo";
            String user = "root";
            String password = "";
             
            //int myid = Integer.parseInt(request.getParameter("id"));
          String myfirm = request.getParameter("symptoms");
            
            Connection conn =DriverManager.getConnection(url, user, password);
            Statement st =conn.createStatement();
            //String myuser = "SELECT d_name FROM diseases(SELECT p_name FROM prescriptions) VALUE ('"+myfirm+"')";
           
         String myuser="select * from prescriptions where s_name='"+myfirm+"'";
       
           ResultSet rs = st.executeQuery(myuser);
           PrintWriter pt = response.getWriter();
           
           pt.println("<!DOCTYPE html>\n" +
"<!--\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>Health Aid </title>\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"Style.css\" />\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"1000px.css\" media=\"screen and (max-width:800px)\"/>\n" +
"        <link rel=\"stylesheet\" type=\"text/css\" href=\"menu.css\" />\n" +
"              \n" +
"    </head>\n" +
"    <body>\n" +
"        <div id=\"container\">\n" +
"            <div id=\"header\" >\n" +
"               <h1> Health Aid System</h1>\n" +
"                </div>\n" +
"               <div id =\"menu\" >\n" +
"                   <ul>\n" +
"                       <li><a href=\"http://localhost:8080/health_aid_system/index.html\">Home</a></li>\n" +
"                        <li><a href=\"http://localhost:8080/health_aid_system/index2.html\">Service</a></li>\n" +
"                         <li><a href=\"http://localhost:8080/health_aid_system/index3.html\">About</a></li>\n" +
"                          <li><a href=\"#\">Contact</a></li>\n" +
"                   </ul>\n" +
"                          \n" +
"                </div>\n" +
"            <div id=\"content\">\n" +
"                <div id=\"picture\">\n" +
"                    <img src=\"jojo.JPG\" height=\"400\" width=\"700\" alt=\"doctar_jojo\">\n" +
"                </div>");
           pt.println("<div id=\"mainbody\">");
           pt.println("<table border='2'");
           
           
           while(rs.next()){
               pt.println("<tr>");
            
              String firstname = rs.getString("s_id");
               String lastname = rs.getString("s_name");
               
               //PrintWriter d = response.getWriter();
               //d.println(firstname);
               pt.println("<td>"+firstname+"</td></tr>");
               
           }
           pt.println("</table>");
              pt.println("</div>\n" +
"                </div>\n" +
"            <div id=\"footer\"> \n" +
"            Copyright &copy;2016 fonso_BM. \n" +
"            </div>\n" +
"        \n" +
"        \n" +
"        \n" +
"        </div>\n" +
"            \n" +
"    </body>\n" +
"</html>");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(reg.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

}
