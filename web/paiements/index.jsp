<%
    if(session.getAttribute("userInfo") == null ){
    session.setAttribute("msg", "Veuillez d'abord vous connecter");
    response.sendRedirect("../login.jsp");
    }
    else{
%>
<%@page import="sb.chcl.belparyaj.model.PaiementsModel"%>
<%@page import="sb.chcl.belparyaj.controlleur.PaiementsServlet"%>
<%@page import="sb.chcl.belparyaj.controlleur.MatchesServlet"%>
<%@page import="sb.chcl.belparyaj.model.MatchesModel"%>
<%@page import="sb.chcl.belparyaj.controlleur.ComptesServlet"%>
<%@page contentType="text/html" errorPage="exceptions.jsp" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@include  file="../layout/header_2.jsp"%>
<div class="container-fluid m-2 bg-light">
    <a class="btn btn-primary mt-4" href="#"><i class="bi-plus"></i>Liste de paiements</a>
    <hr/>
    
    <table id="tbcomptes" class="table table-responsive table-striped">
        <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Id pariage</th>
                <th scope="col">Date</th>

            </tr>
        </thead>
        <tbody class="table-group-divider">
            <%
             PaiementsServlet serv = new PaiementsServlet();
             serv.refresh_liste_paiements(request, response);
             ArrayList<PaiementsModel> liste=(ArrayList<PaiementsModel>)session.getAttribute("liste_paiements");
             if(liste!=null){
                  if(liste.size()>0){
                     for(PaiementsModel model:liste){
            %>
            <tr>
                <td><%=model.getId()%></td>
                <td><%=model.getId_pariage()%></td>
                <td><%=model.getDate() %></td>
            </tr>
            <%}}}else{%>
            <p class="btn">Aucun paiement pour l'instant</p>
            <%}%>
        </tbody>
    </table>
</div>

<script>
    
    $(document).ready(function(){
        $("#tbcomptes").DataTable({
        buttons: [
        'copy', 'excel', 'pdf'
         ]
});
    });
</script>
<%@include  file="../layout/script.jsp"%>
<% } %>