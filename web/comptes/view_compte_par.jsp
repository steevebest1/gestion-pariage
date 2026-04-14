<%@page import="sb.chcl.belparyaj.model.PariagesModel"%>
<%@page import="sb.chcl.belparyaj.controlleur.PariagesServlet"%>
<%@page import="sb.chcl.belparyaj.model.PaiementsModel"%>
<%@page import="sb.chcl.belparyaj.controlleur.PaiementsServlet"%>
<%@page import="sb.chcl.belparyaj.model.MatchesModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sb.chcl.belparyaj.controlleur.MatchesServlet"%>
<%
    if(session.getAttribute("userInfo") == null ){
    session.setAttribute("msg", "Veuillez d'abord vous connecter");
    response.sendRedirect("../login.jsp");
    }
    else{
%>
<%@include  file="../layout/header_2.jsp"%> 
<div class="wrapper container-fluid">
    <div class="container mt-1 mb-1">
        <form method="POST" action="${pageContext.request.contextPath}/ComptesServlet?operation=add">
            <h3>Mon COMPTE</h3>
            <div><a href="view_compte_p.jsp"><span class="btn btn-primary">Mes paiements</span></a><a href="view_compte.jsp"><span class="ms-3 btn btn-primary">Mes matches</span></a></div>>
            <div class="container-fluid mb-2">
                <p class='' style="color: red;">
                    <%= session.getAttribute("msg") != null? (String)session.getAttribute("msg"):"" %>
                    <% session.removeAttribute("msg"); %>
                    <%= request.getParameter("msg") != null? request.getParameter("msg"):"" %>
                </p>
            </div>
            <div class="form-row">
                <div class="form-wrapper">
                    <div class="container">
                        <img class="img-fluid bg-dark  border-danger" src="../ressources/images/user.png" alt="alt"/>
                    </div>
                </div>
                <div class="form-wrapper">
                    <div class="container-fluid pe-3 ps-0 ms-0 text-center">
                        <table id="tbcomptes" class="table table-responsive table-striped">
                        <thead>
                            <tr>
                                <div><h5 class="container btn btn-dark"><%= ((ComptesModel)session.getAttribute("userInfo")).getCode() %> </h5></div> 
                            </tr>
                        </thead>
                        <tbody class="table-group-divider">
                        <th class="text-start text-dark" scope="col">Nom:</th>
                                <th scope="col"><%= ((ComptesModel)session.getAttribute("userInfo")).getNom() %></th>
                            <tr>
                                <td class="text-start text-dark" >Prenom:</td>
                                <td><%= ((ComptesModel)session.getAttribute("userInfo")).getPrenom()%></td>                                
                            </tr>
                            <tr>
                                <td class="text-start text-dark" >Sexe:</td>
                                <td><%= ((ComptesModel)session.getAttribute("userInfo")).getPrenom()%></td>                                
                            </tr>
                            <tr>
                                <td class="text-start text-dark" >Adresse:</td>
                                <td><%= ((ComptesModel)session.getAttribute("userInfo")).getAdresse()%></td>                                
                            </tr>
                            <tr>
                                <td class="text-start text-dark" >Lieu de naissance:</td>
                                <td><%= ((ComptesModel)session.getAttribute("userInfo")).getLieu_naissance()%></td>                                
                            </tr>
                            <tr>
                                <td class="text-start text-dark" >Date de naissance:</td>
                                <td><%= ((ComptesModel)session.getAttribute("userInfo")).getDate_naissance() %></td>                                
                            </tr>
                            <tr>
                                <td class="text-start text-dark" >Telephone:</td>
                                <td><%= ((ComptesModel)session.getAttribute("userInfo")).getPhone() %></td>                                
                            </tr>
                            <tr>
                                <td class="text-start text-dark" >Nif_cin:</td>
                                <td><%= ((ComptesModel)session.getAttribute("userInfo")).getNif_cin() %></td>                                
                            </tr>
                            <tr>
                                <td class="text-start text-dark" >Nom d'utilisateur:</td>
                                <td><%= ((ComptesModel)session.getAttribute("userInfo")).getUsername() %></td>                                
                            </tr>
                            <tr>
                                <td class="text-start text-dark" >Solde:</td>
                                <td><%= ((ComptesModel)session.getAttribute("userInfo")).getSolde() %> Gdes</td>                                
                            </tr>
                            <tr>
                                <td class="text-start text-dark" >Etat:</td>
                                <td><%= ((ComptesModel)session.getAttribute("userInfo")).getEtat() %></td>                                
                            </tr>
                            
                        </tbody>
                    </table>
                            <a href="${pageContext.request.contextPath}/ComptesServlet?id=<%= ((ComptesModel)session.getAttribute("userInfo")).getCode() %>&operation=update" class="btn text-dark btn-outline-warning ">Modifier compte</a>                   <!--<div><h5 class="container btn btn-dark"><%= ((ComptesModel)session.getAttribute("userInfo")).getCode() %> </h5></div> 
                        <h5 class="text-dark bg-info-">Nom: <span class="d-inline container text-end"><%= ((ComptesModel)session.getAttribute("userInfo")).getNom() %></span></h5>
                        <div><h5 class="text-dark ">Prénom: <span class=" btn"><%= ((ComptesModel)session.getAttribute("userInfo")).getPrenom() %></span></h5></div>
                        <h5 class="text-dark ">Sexe: <span class=" btn"><%= ((ComptesModel)session.getAttribute("userInfo")).getSexe() %></span></h5>
                        <h5 class="text-dark ">Adresse: <span class=" btn"><%= ((ComptesModel)session.getAttribute("userInfo")).getAdresse() %></span></h5>
                        <h5 class="text-dark ">Lieu de naissance: <span class=" btn"><%= ((ComptesModel)session.getAttribute("userInfo")).getLieu_naissance()%></span></h5>
                        <h5 class="text-dark ">Date de naissance: <span class=" btn"><%= ((ComptesModel)session.getAttribute("userInfo")).getDate_naissance()%></span></h5>
                        <h5 class="text-dark ">Téléphone: <span class=" btn"><%= ((ComptesModel)session.getAttribute("userInfo")).getPhone() %></span></h5>
                        <h5 class="text-dark ">Nif/Cin: <span class=" btn"><%= ((ComptesModel)session.getAttribute("userInfo")).getNif_cin() %></span></h5>
                        <h5 class="text-dark ">Username: <span class=" btn"><%= ((ComptesModel)session.getAttribute("userInfo")).getUsername() %></span></h5>
                        <h5 class="text-dark ">Solde <span class=" btn"><%= ((ComptesModel)session.getAttribute("userInfo")).getSolde() %> Gdes</span> </h5>
                        <h5 class="text-dark ">Etat <span class=" btn"><%= ((ComptesModel)session.getAttribute("userInfo")).getEtat() %></span></h5>-->
                        
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                    <span class="btn btn-primary container mt-2">Pariages</span>
                        <table id="tbcomptes" class="table table-responsive table-striped mb-5">
                            <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Id Match</th>
                                    <th scope="col">Date</th>
                                    <th scope="col">Score prevu</th>
                                    <th scope="col">Montant</th>
                                </tr>
                            </thead>
                            <tbody class="table-group-divider">
                                <%
                                 PariagesServlet serv = new PariagesServlet();
                                 serv.refresh_liste_pariagesC(request, response);
                                 ArrayList<PariagesModel> liste=(ArrayList<PariagesModel>)session.getAttribute("listeParUser");
                                 if(liste!=null){
                                      if(liste.size()>0){
                                         for(PariagesModel model:liste){
                                %>
                                <tr>
                                    <td><%=model.getId()%></td>
                                    <td><%=model.getId_match() %></td>
                                    <td><%=model.getDate()%></td>
                                    <td><%=model.getScore_prevu() %></td>
                                    <td><%=model.getMontant()+" Gdes" %></td>
                                </tr>
                                <%}}}else{%>
                                <td>Aucun pariage pour l'instant</td>
                                <%}%>
                            </tbody>
    </table>               
            </div>
        </form>
    </div>
</div>
<%@include  file="../layout/script.jsp"%>
<%@include  file="../layout/footer.jsp"%>
<%}%>
