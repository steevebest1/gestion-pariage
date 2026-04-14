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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sb.chcl.belparyaj.dao.ComptesDao;
import sb.chcl.belparyaj.model.ComptesModel;
import sb.chcl.belparyaj.services.Code;

/**
 *
 * @author Steeve
 */
public class ComptesServlet extends HttpServlet {
    ComptesModel model = null;
    ComptesDao dao = new ComptesDao();
    final String liste = "comptes/index.jsp";
    final String ajouter = "comptes/add_compte.jsp";
    final String modifier = "comptes/upt_compte.jsp";
    final String recharger = "comptes/fund_compte.jsp";
    final String visualiser = "comptes/view_compte.jsp";
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
            out.println("<title>Servlet CompteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CompteServlet at " + request.getContextPath() + "</h1>");
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
             ComptesModel data=dao.rechercher(id);
             out.print(id);
        if (op == null) {
            if(((ComptesModel)request.getSession(true).getAttribute("userInfo")).getType_compte().equalsIgnoreCase("admin")){
                    session.setAttribute("msg", "Erreur interne!");
                    lister(request, response);  
                }else{
                session.setAttribute("msg", "Erreur interne!");
                response.sendRedirect(visualiser);
                }
        } else {
            switch (op) {
                case "update":
                      {                      
                           if(data!=null){
                                session.setAttribute("compte", data);
                                response.sendRedirect(modifier);
                        
                           }else{
                                //test si c\est un admin
                if(((ComptesModel)request.getSession(true).getAttribute("userInfo")).getType_compte().equalsIgnoreCase("admin")){
                    session.setAttribute("msg", "Compte introuvable!");
                    lister(request, response);  
                }else{
                session.setAttribute("msg", "Compte introuvable!");
                response.sendRedirect(visualiser);
                }
                           }
                            
                    }
                    break;

                case "recharger":
                    {                      
                           if(data!=null){
                                session.setAttribute("compte", data);
                                response.sendRedirect(recharger);
                        
                           }else{
                                //test si c\est un admin
                if(((ComptesModel)request.getSession(true).getAttribute("userInfo")).getType_compte().equalsIgnoreCase("admin")){
                    session.setAttribute("msg", "Compte introuvable!");
                    lister(request, response);  
                }
                           }
                            
                    }
                    break;
                default:
                    lister(request, response);
            }
        }
        } catch (SQLException | ClassNotFoundException ex) {
                request.setAttribute("exception",ex.getMessage());
                request.getRequestDispatcher("../exceptions.jsp").forward(request, response);
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
                case "fund":
                    recharger(request, response);
                    break;
                default:
                    lister(request, response);
            }
        }
    }
    
    //Les méthodes
    protected void creer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String code = Code.generate("user");
        String nom = request.getParameter("nom") != null? request.getParameter("nom"):"";
        String prenom = request.getParameter("prenom") != null? request.getParameter("prenom"):"";
        String sexe = request.getParameter("sexe") != null? request.getParameter("sexe"):"";
        String adresse = request.getParameter("adresse") != null? request.getParameter("adresse"):"";
        String lieu_naissance = request.getParameter("pob") != null? request.getParameter("pob"):"";
        LocalDate date_naissance = LocalDate.parse(request.getParameter("dob"));
        String phone = request.getParameter("phone") != null? request.getParameter("phone"):"";
        String nif_cin = request.getParameter("nif_cin") != null? request.getParameter("nif_cin"):"";
        String username = request.getParameter("username") != null? request.getParameter("username"):"";
        String password = request.getParameter("pass") != null? request.getParameter("pass"):"";
       
        model = new ComptesModel(code, nom, prenom, sexe, adresse, lieu_naissance, date_naissance, phone, nif_cin, username, password,0, "A", "simple");
        try {
            ArrayList msgErreur = dao.Validate(model);
            if(msgErreur != null && msgErreur.isEmpty()){
                if (dao.enregistrer(model) > 0) {
                request.getSession(true).setAttribute("userInfo", model);
                response.sendRedirect("index.jsp");
                }
                else {
                response.sendRedirect(ajouter);
                }
            }
            else{
                request.getSession(true).setAttribute("msg", msgErreur);
                response.sendRedirect(ajouter);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            response.sendRedirect(ajouter+"?="+ex.getMessage());
        }
    }

    protected void modifier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = ((ComptesModel)request.getSession(true).getAttribute("compte")).getCode();
        String nom = request.getParameter("nom") != null? request.getParameter("nom"):"";
        String prenom = request.getParameter("prenom") != null? request.getParameter("prenom"):"";
        String sexe = request.getParameter("sexe") != null? request.getParameter("sexe"):"";
        String adresse = request.getParameter("adresse") != null? request.getParameter("adresse"):"";
        String lieu_naissance = request.getParameter("pob") != null? request.getParameter("pob"):"";
        LocalDate date_naissance = LocalDate.parse(request.getParameter("dob"));
        String phone = request.getParameter("phone") != null? request.getParameter("phone"):"";
        String nif_cin = request.getParameter("nif_cin") != null? request.getParameter("nif_cin"):"";
        String username = request.getParameter("username") != null? request.getParameter("username"):"";
        String password = request.getParameter("pass") != null? request.getParameter("pass"):"";
        Double solde = 0.0; //request.getParameter("solde")!=null? Double.parseDouble(request.getParameter("solde")):((ComptesModel)request.getSession(true).getAttribute("compte")).getSolde();
        String etat = request.getParameter("etat")!=null?request.getParameter("etat"):((ComptesModel)request.getSession(true).getAttribute("compte")).getEtat();
        String type =  request.getParameter("type")!=null?request.getParameter("type"):((ComptesModel)request.getSession(true).getAttribute("compte")).getType_compte();
        
        model = new ComptesModel(code, nom, prenom, sexe, adresse, lieu_naissance, date_naissance, phone, nif_cin, username, password,solde, etat, type);
        ComptesModel user = (ComptesModel)request.getSession(true).getAttribute("userInfo");
        try {
            if (dao.modifier(model) > 0) {
                //test si c\est un admin
                if(user.getType_compte().equalsIgnoreCase("admin")){
                  lister(request, response);  
                }else{
                model = dao.rechercher(user.getCode());
                request.getSession(true).setAttribute("userInfo", model);
                response.sendRedirect(visualiser+"?"+user.getType_compte());
                }
            } else {
                response.sendRedirect(modifier+"?msg=Erreur de modification");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            response.sendRedirect(modifier+"?msg="+ex);
        }
    }

    protected void lister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            refresh_liste_compte(request, response);
            request.getSession(true).setAttribute("msg", "Modification réussie!");
            response.sendRedirect(liste);
    }
        
    public void refresh_liste_compte(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<ComptesModel> data = dao.afficher();
            HttpSession session = request.getSession(true);
            session.setAttribute("liste", data);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ComptesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    protected void recharger(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Double solde = Double.valueOf(request.getParameter("montant"));        
        
        try {
            model = dao.rechercher(id);
            if (model != null) {
                model.setSolde(model.getSolde()+solde);
                if (dao.modifier(model) > 0) {
                lister(request, response);
            } else {
                response.sendRedirect(recharger);
            }
                //lister(request, response);
            } else {
                response.sendRedirect(recharger);
            }
        } catch (SQLException ex) {
            response.sendRedirect(recharger);
        } catch (ClassNotFoundException ex) {
            response.sendRedirect(recharger);
        }
    }
    
    /**
     * Returns a short description of the servlet.
     * 
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Ce servlet gère le traitement des comptes";
    }// </editor-fold>

}
