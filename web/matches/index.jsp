<%
    if(session.getAttribute("userInfo") == null ){
    session.setAttribute("msg", "Veuillez d'abord vous connecter");
    response.sendRedirect("../login.jsp");
    }
    else{
%>
<%@page import="sb.chcl.belparyaj.controlleur.MatchesServlet"%>
<%@page import="sb.chcl.belparyaj.model.MatchesModel"%>
<%@page import="sb.chcl.belparyaj.controlleur.ComptesServlet"%>
<%@page contentType="text/html" errorPage="exceptions.jsp" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@include  file="../layout/header_2.jsp"%>
<div class="container-fluid m-2 bg-light">
    <a class="btn btn-primary mt-4" href="${pageContext.request.contextPath}/matches/add_match.jsp"><i class="bi-plus"></i> Ajouter un match</a>
    <hr/>
    <% 
      if(session.getAttribute("msg")!=null){%>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>Message:</strong> <%=session.getAttribute("msg")%>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>

    <% session.removeAttribute("msg"); }%>
    <table id="tbcomptes" class="table table-responsive table-striped">
        <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Type de match</th>
                <th scope="col">Pays</th>
                <th scope="col">Date</th>
                <th scope="col">Heure</th>
                <th scope="col">Equipe receveuse</th>
                <th scope="col">Equipe visiteuse</th>
                <th scope="col">Cote</th>
                <th scope="col">Score final</th>
                <th scope="col">Etat</th>
                <th scope="col">Action</th>

            </tr>
        </thead>
        <tbody class="table-group-divider">
            <%
             MatchesServlet serv = new MatchesServlet();
             serv.refresh_liste_matches(request, response);
             ArrayList<MatchesModel> liste=(ArrayList<MatchesModel>)session.getAttribute("liste_matches");
             if(liste!=null){
                  if(liste.size()>0){
                     for(MatchesModel model:liste){
            %>
            <tr>
                <td><%=model.getId()%></td>
                <td><%=model.getType()%></td>
                <td><%=model.getPays()%></td>
                <td><%=model.getDate() %></td>
                <td><%=model.getHeure()%></td>
                <td><%=model.getEq_rec()%></td>
                <td><%=model.getEq_vis()%></td>
                <td><%=model.getCote() %></td>
                <td><%=model.getScore()%></td>
                <td><%=model.getEtat() %></td>
                
                <% if(model.getEtat().equalsIgnoreCase("T")){%>
                <td>
                    <i class="bi bi-check-circle-fill"></i>
                </td>
                <% }else{ %>
                <td>
                    <a title="Terminer" href="${pageContext.request.contextPath}/MatchesServlet?id=<%=model.getId()+"&operation=update"%>"><i class="bi bi-pencil-fill"></i></a>
                </td>
                <%}%>
            </tr>
            <%}}}else{%>
            <td>Aucun match pour l'instant</td>
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