/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.ApiManager;
import managers.ServerManager;

/**
 *
 * @author User
 */
@WebServlet(name = "Withdraw", urlPatterns = {"/Withdraw"})
public class Withdraw extends HttpServlet {

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
        
         ApiManager apiManager = new ApiManager(request,response);
        
         
         
        boolean allParameterExist;
        
        
        allParameterExist=apiManager.checkParameters("accno","amount");
       
        if(allParameterExist){
                //        getting parameters
            long accNo = Long.parseLong(request.getParameter("accno"));
            float amount = Float.parseFloat(request.getParameter("amount"));
    //        checking login status
            boolean isSuccess = ServerManager.databaseManager.getTdao().withdrawATM(accNo, amount);

            if(isSuccess)
                apiManager.dummy(isSuccess,"");
            else
                apiManager.dummy(isSuccess, "Server Error Withdraw fail..Try again!!");

            apiManager.send();
        }else{
            apiManager.sendError(ApiManager.Error.ERROR_PARAMETR);
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
