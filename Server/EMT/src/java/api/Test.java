/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import Data.DataCustomer;
import controls.CustomerDAO;
import managers.ServerManager;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.json.simple.JSONObject;

/**
 *
 * @author User
 */
@WebServlet(name = "Test", urlPatterns = {"/Test"})
public class Test extends HttpServlet {

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
        
        
        
        
        try {
            
//            JSONObject json = new JSONObject();
            Gson gson= new Gson(); 
            CustomerDAO c = ServerManager.databaseManager.getCdao();
            long AccNo = 123456789L;
            
            
//        fetching customer information using AccNo

            DataCustomer cust = new DataCustomer(c.getCustomer(AccNo));
            
            String json = gson.toJson(cust);
            
//            
//            json.put("name", cust.Name);
//            json.put("amount", new Double(cust.Amount));
            
            PrintWriter out = response.getWriter();
            
            response.setContentType("application/json;");
            
            
            
            out.print(json);
            
            

System.out.println(cust.toString());



//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Test</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Test at " + cust.toString() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        
        
        
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
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
     * 
     */
    
    
    
    @Override
    public void init()
            throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        
        new ServerManager();
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
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
