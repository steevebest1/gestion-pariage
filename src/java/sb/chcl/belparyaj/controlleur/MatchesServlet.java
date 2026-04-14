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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sb.chcl.belparyaj.dao.MatchesDao;
import sb.chcl.belparyaj.dao.PaiementsDao;
import sb.chcl.belparyaj.dao.PariagesDao;
import sb.chcl.belparyaj.model.ComptesModel;
import sb.chcl.belparyaj.model.MatchesModel;
import sb.chcl.belparyaj.model.PaiementsModel;
import sb.chcl.belparyaj.model.PariagesModel;
import sb.chcl.belparyaj.services.Code;

/**
 *
 * @author Steeve
 */
public class MatchesServlet extends HttpServlet {
    MatchesModel model = null;
    MatchesDao dao = new MatchesDao();
    PariagesDao daoP = new PariagesDao();
    PaiementsDao daoPm = new PaiementsDao();
    final String lister_matches = "matches/index.jsp";
    final String ajouter = "matches/add_match.jsp";
    final String modifier = "matches/upt_match.jsp";
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
            out.println("<title>Servlet MatchesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MatchesServlet at " + request.getContextPath() + "</h1>");
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
         try{
             MatchesModel data=dao.rechercher(id);
             out.print(id);
        if (op == null) {
                    lister(request, response);
        } else {
            switch (op) {
                case "update":
                      {                      
                           if(data!=null){
                                session.setAttribute("match", data);
                                response.sendRedirect(modifier);                        
                           }else{
                                lister(request, response);
                           }                            
                    }
                    break;
                default:
                    lister(request, response);
            }
        }
        } catch (SQLException | ClassNotFoundException ex) {
                request.setAttribute("msg",ex.getMessage());
                response.sendRedirect(modifier);
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
        String operation = request.getParameter("operation");
        if (operation == null) {
            lister(request, response);
        } else {
            switch (operation) {
                case "add":
                {
                    try {
                        creer(request, response);
                    } catch (SQLException ex) {
                request.setAttribute("exception",ex.getMessage());
                request.getRequestDispatcher("../exceptions.jsp").forward(request, response);
                    }
                }
                    break;

                case "update":
                    modifier(request, response);
                    break;
                default:
                    lister(request, response);
            }
        }
    }

    //Les méthodes
    protected void creer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String code = Code.generate("match");
        String type = request.getParameter("type_match") != null? request.getParameter("type_match"):"";
        String pays= request.getParameter("pays") != null? request.getParameter("pays"):"";
        LocalDate date = LocalDate.now();
        LocalTime heure = LocalTime.now();
        String equ_rec = request.getParameter("equ_rec") != null? request.getParameter("equ_rec"):"";
        String equ_vis = request.getParameter("equ_vis") != null? request.getParameter("equ_vis"):"";
        Double cote = Double.parseDouble(request.getParameter("cote") != null? request.getParameter("cote"):"");
        String equ_rec_but = request.getParameter("equ_rec_but") != null? request.getParameter("equ_rec_but"):"";
        String equ_vis_but = request.getParameter("equ_vis_but") != null? request.getParameter("equ_vis_but"):"";
        String score ="0:0";
       
        model = new MatchesModel(code, type, pays, date, heure, equ_rec, equ_vis, cote, score, "N" );
        try {
            if (dao.enregistrer(model) > 0) {
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect(ajouter);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            response.sendRedirect(ajouter+"?="+ex.getMessage());
        }
    }

    protected void modifier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        model =(MatchesModel) request.getSession(true).getAttribute("match");
        ComptesModel user = (ComptesModel)request.getSession(true).getAttribute("userInfo");
        String equ_rec_but = request.getParameter("equ_rec_but") != null? request.getParameter("equ_rec_but"):"";
        String equ_vis_but = request.getParameter("equ_vis_but") != null? request.getParameter("equ_vis_but"):"";
        String score =equ_rec_but+":"+equ_vis_but;
        model.setScore(score);
        model.setEtat("T");
       
        try {
            if (dao.modifierScore(model) > 0) {
                request.getSession(true).setAttribute("match",model);
                response.sendRedirect("PaiementsServlet?operation=add");
            } else {
                response.sendRedirect(modifier+"?msg=Le match n'a pas ete modifie.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            response.sendRedirect(modifier+"?msg="+ex);
        }
    }

    protected void lister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            refresh_liste_matches(request, response);
            response.sendRedirect(lister_matches);
    }
        
    public void refresh_liste_matches(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<MatchesModel> data = dao.afficher();
            HttpSession session = request.getSession(true);
            session.setAttribute("liste_matches", data);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ComptesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void refresh_liste_matchesC(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<MatchesModel> data = new ArrayList<>();
            ComptesModel user = (ComptesModel)request.getSession(true).getAttribute("userInfo");
            ArrayList<PariagesModel> pariages = daoP.afficherPuser(user.getCode());
            if(pariages!=null && (!pariages.isEmpty())){
                for(PariagesModel p:pariages){
                    data.add(dao.rechercher(p.getId_match()));
                }
                
                HttpSession session = request.getSession(true);
                session.setAttribute("liste_matchesC", data);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ComptesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void refresh_liste_paiementsC(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {HttpSession session = request.getSession(true);
            ArrayList<PaiementsModel> data = new ArrayList<>();
            ComptesModel user = (ComptesModel)request.getSession(true).getAttribute("userInfo");
            ArrayList<PariagesModel> pariages = daoP.afficherPuser(user.getCode());
            if(pariages!=null && (!pariages.isEmpty())){
                for(PariagesModel p:pariages){
                    data.add(daoPm.rechercher(p.getId()));
                }               
                session.setAttribute("liste_paiementsW", data);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ComptesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

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
