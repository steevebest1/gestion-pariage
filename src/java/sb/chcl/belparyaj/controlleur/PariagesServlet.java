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
import sb.chcl.belparyaj.dao.PariagesDao;
import sb.chcl.belparyaj.model.ComptesModel;
import sb.chcl.belparyaj.model.MatchesModel;
import sb.chcl.belparyaj.model.PariagesModel;
import sb.chcl.belparyaj.services.Code;

/**
 *
 * @author Steeve
 */
@WebServlet(name = "PariagesServlet", urlPatterns = {"/PariagesServlet"})
public class PariagesServlet extends HttpServlet {
    PariagesDao dao = new PariagesDao();
    PariagesModel model = new PariagesModel();
    final String liste = "pariages/index.jsp";
    final String ajouter = "pariages/add_pariage.jsp";
    final String modifier = "pariages/upt_pariage.jsp";
    MatchesModel modelP = null;
    MatchesDao daoP = new MatchesDao();
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
            out.println("<title>Servlet PariagesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PariagesServlet at " + request.getContextPath() + "</h1>");
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
             MatchesModel data=daoP.rechercher(id);
             out.print(id);
        if (op == null) {
                    lister(request, response);
        } else {
            switch (op) {
                case "add":
                      {                      
                           if(data!=null){
                                session.setAttribute("matchP", data);
                                response.sendRedirect(ajouter);                        
                           }else{
                               session.setAttribute("msg", "Ce match n'est plus disponible.");
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
                lister(request, response);
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
                        enregistrer(request, response);
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
    protected void enregistrer (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String code = Code.generate("user");
        String id_compte = ((ComptesModel) request.getSession(true).getAttribute("userInfo")).getCode();
        String id_match = ((MatchesModel) request.getSession(true).getAttribute("matchP")).getId(); 
        LocalDate date = LocalDate.now();
        String equ_rec_but = request.getParameter("equ_rec_but") != null? request.getParameter("equ_rec_but"):"";
        String equ_vis_but = request.getParameter("equ_vis_but") != null? request.getParameter("equ_vis_but"):"";
        String score =equ_rec_but+":"+equ_vis_but;
        Double montant = Double.valueOf(request.getParameter("montant"));
       
        model = new PariagesModel(code, id_compte, id_match, date, score, montant);
        ComptesModel user = (ComptesModel)request.getSession().getAttribute("userInfo");
        
        try {
            ArrayList<String> msgList = dao.Validate(user, model);
            if(msgList.isEmpty()){
                if (dao.enregistrer(model) > 0) {
                    user.setSolde(user.getSolde()-montant);
                    daoC.modifier(user);
                    lister(request, response);
                } else {
                    request.getSession().setAttribute("msg","Erreur lors de l'enregistrement, veuillez reessayer.");
                    response.sendRedirect(ajouter);
                }
            }else{
                request.getSession().setAttribute("msgV",msgList);
                response.sendRedirect(ajouter);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            response.sendRedirect(ajouter);
        }
    }

    protected void modifier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        String id_compte = request.getParameter("id_compte") != null? request.getParameter("id_compte"):"";
        String id_match = request.getParameter("id_match") != null? request.getParameter("id_match"):""; 
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String score = request.getParameter("score") != null? request.getParameter("score"):"";
        Double montant = Double.valueOf(request.getParameter("montant"));
        
        model = new PariagesModel(code, id_compte, id_match, date, score, montant);
        try {
            if (dao.modifier(model) > 0) {
                lister(request, response);
            } else {
                response.sendRedirect(ajouter);
            }
        } catch (SQLException ex) {
            response.sendRedirect(ajouter);
        } catch (ClassNotFoundException ex) {
            response.sendRedirect(ajouter);
        }
    }

    protected void lister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            refresh_liste_pariages(request, response);
            response.sendRedirect(liste);
    }
        
    public void refresh_liste_pariages(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<PariagesModel> data = dao.afficher();
            HttpSession session = request.getSession(true);
            session.setAttribute("liste", data);
        } catch (SQLException ex) {
            Logger.getLogger(ComptesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComptesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
        public void refresh_liste_pariagesC(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<PariagesModel> data = dao.afficherPuser(((ComptesModel)request.getSession(true).getAttribute("userInfo")).getCode());
            HttpSession session = request.getSession(true);
            session.setAttribute("listeParUser", data);
        } catch (SQLException ex) {
            Logger.getLogger(ComptesServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComptesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    protected void recharger(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id") != null? request.getParameter("id"):"";
        String e1 = request.getParameter("e1") ;
        String e2 = request.getParameter("e2");
        String score = e1.concat(":"+e2);
        
        try {
            model = dao.rechercher(id);
            if (model != null) {
                model.setScore_prevu(score);
                if (dao.modifier(model) > 0) {
                lister(request, response);
            } else {
                response.sendRedirect(ajouter);
            }
                //lister(request, response);
            } else {
                response.sendRedirect(ajouter);
            }
        } catch (SQLException ex) {
            response.sendRedirect(ajouter);
        } catch (ClassNotFoundException ex) {
            response.sendRedirect(ajouter);
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
