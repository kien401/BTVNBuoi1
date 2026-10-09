
//sửa javax thành jakarta
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "CalculatorController", urlPatterns = {"/CalculatorController"})
public class CalculatorController extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalculatorController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculatorController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // nhiệm vụ ở controller la lấy 2 giá trị từ bên fe gửi qua
       String n1 =request.getParameter("num1"); // lấy gia strij của biến num1
         String n2 =request.getParameter("num2");
         String n3 =request.getParameter("phepTinh");
        PrintWriter out = response.getWriter();
         try {
            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);
            double res=0;
            if(n3.equals("+")){
             res = num1 + num2;
            }else{
                res = num1 - num2;
            }
            
            out.println(res);
        } catch (Exception e) {
            out.println("NO");
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
