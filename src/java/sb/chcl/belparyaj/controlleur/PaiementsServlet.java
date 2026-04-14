/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sb.chcl.belparyaj.controlleur;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sb.chcl.belparyaj.dao.ComptesDao;
import sb.chcl.belparyaj.dao.MatchesDao;
import sb.chcl.belparyaj.dao.PaiementsDao;
import sb.chcl.belparyaj.dao.PariagesDao;
import sb.chcl.belparyaj.model.ComptesModel;
import sb.chcl.belparyaj.model.MatchesModel;
import sb.chcl.belparyaj.model.PaiementsModel;
import sb.chcl.belparyaj.model.PariagesModel;

/**
 *
 * @author Steeve
 */
@WebServlet(name = "PaiementsServlet", urlPatterns = {"/PaiementsServlet"})
public class PaiementsServlet extends HttpServlet {
    PaiementsDao dao = new PaiementsDao();
    PaiementsModel model = new PaiementsModel();
    final String liste = "paiements/index.jsp";
    MatchesModel match = null;
    MatchesDao daoM = new MatchesDao();
    PariagesModel pariage = null;
    PariagesDao daoP = new PariagesDao();
    ComptesDao daoC = new ComptesDao();
    
    String msg;
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
            out.println("<title>Servlet PaiementsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PaiementsServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession(true);
         String op = request.getParameter("operation");
          String id = request.getParameter("id"); 
          MatchesModel data = (MatchesModel)session.getAttribute("match");
          out.print(id);
          if (op == null) {
              response.sendRedirect(liste);
          } else {
              switch (op) {
                  case "add":
                  {
                      if(data!=null){
                          try {
                              effectuerPaiements(request, response);
                          } catch (SQLException ex) {
                              Logger.getLogger(PaiementsServlet.class.getName()).log(Level.SEVERE, null, ex);
                          } catch (ClassNotFoundException ex) {
                              Logger.getLogger(PaiementsServlet.class.getName()).log(Level.SEVERE, null, ex);
                          }
                      }else{
                          session.setAttribute("msg", "Ce match n'est plus disponible.");
                          response.sendRedirect(liste);
                      }
                  }
                  break;
                  default:
                      response.sendRedirect(liste);
              }
          }
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

    private void effectuerPaiements(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException {
        //Recuperation du match
          MatchesModel data = (MatchesModel)request.getSession().getAttribute("match");
        //Recuperation des pariages de ce match
        ArrayList<PariagesModel> pariage_act = new ArrayList<>();
        pariage_act = daoP.afficherP(data.getId());
        //Test sur la liste
        if(pariage_act==null || pariage_act.isEmpty()){
            response.sendRedirect(liste);
        }
        else{
            //Si la liste contient au moins un element
            for(PariagesModel p: pariage_act){
                //comparaison des scores
                if(p.getScore_prevu().equalsIgnoreCase(data.getScore())){
                    //Si le pariage est ok
                    //Recuperation du compte
                    ComptesModel co = daoC.rechercher(p.getId_compte());
                    //Modification du solde
                    co.setSolde(co.getSolde()+ (p.getMontant()*data.getCote()));
                    //Sauuvegardedes modification
                    daoC.modifier(co);
                    //Sauvegarde du paiement
                    PaiementsModel pm = new PaiementsModel("", p.getId(), LocalDate.now());
                    dao.enregistrer(pm);
                    
                }
            }response.sendRedirect(liste);
        }
    }

    protected void lister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            refresh_liste_paiements(request, response);
            response.sendRedirect(liste);
    }
        
    public void refresh_liste_paiements(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<PaiementsModel> data = dao.afficher();
            HttpSession session = request.getSession(true);
            session.setAttribute("liste_paiements", data);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ComptesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
