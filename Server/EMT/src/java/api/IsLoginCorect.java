/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;


import managers.ApiManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.ServerManager;

/**
 *
 * @author User
 */
@WebServlet(name = "IsLoginCorect", urlPatterns = {"/IsLoginCorect"})
public class IsLoginCorect extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        ApiManager apiManager = new ApiManager(request,response);
        
        boolean allParameterExist;
        
        
        allParameterExist=apiManager.checkParameters( "sname","accno","key");
       
        if(allParameterExist){
                //        getting parameters
            String sName = request.getParameter("sname");
            long accNo = Long.parseLong(request.getParameter("accno"));
            int key = Integer.parseInt(request.getParameter("key")); 
    //        checking login status
            boolean isExist = ServerManager.databaseManager.getCdao().isLoginCorrect(sName, accNo, key);

            if(isExist)
                apiManager.dummy(isExist,"");
            else
                apiManager.dummy(isExist, "AccountNo or Secreate Key is incorrect!!");

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
