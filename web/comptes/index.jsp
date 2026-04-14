
<%
    if(session.getAttribute("userInfo") == null ){
    session.setAttribute("msg", "Veuillez d'abord vous connecter");
    response.sendRedirect("../login.jsp");
    }
    else{
%>
<%@page import="sb.chcl.belparyaj.controlleur.ComptesServlet"%>
<%@page import="sb.chcl.belparyaj.dao.ComptesDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sb.chcl.belparyaj.model.ComptesModel"%>
<%@include  file="../layout/header_2.jsp"%>
<div class="container-fluid m-2 bg-light">
    <a class="btn btn-primary mt-4" href="${pageContext.request.contextPath}/comptes/add_compte.jsp"><i class="bi-plus"></i> Créer un compte</a>
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
                <th scope="col">Code</th>
                <th scope="col">Nom</th>
                <th scope="col">Prénom</th>
                <th scope="col">Sexe</th>
                <th scope="col">Adresse</th>
                <th scope="col">Lieu de naissance</th>
                <th scope="col">Date de naissance</th>
                <th scope="col">Téléphone</th>
                <th scope="col">Nif/Cin</th>
                <th scope="col">Nom d'utilisateur</th>
                <th scope="col">Mot de passe</th>
                <th scope="col">Solde</th>
                <th scope="col">Etat</th>
                <th scope="col">type</th>
                <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody class="table-group-divider">
            <%
             ComptesServlet serv = new ComptesServlet();
             serv.refresh_liste_compte(request, response);
             ArrayList<ComptesModel> liste=(ArrayList<ComptesModel>)session.getAttribute("liste");
             if(liste!=null){
                  if(liste.size()>0){
                     for(ComptesModel model:liste){
            %>
            <tr>
                <td><%=model.getCode()%></td>
                <td><%=model.getNom()%></td>
                <td><%=model.getPrenom()%></td>
                <td><%=model.getSexe()%></td>
                <td><%=model.getAdresse()%></td>
                <td><%=model.getLieu_naissance()%></td>
                <td><%=model.getDate_naissance()%></td>
                <td><%=model.getPhone()%></td>
                <td><%=model.getNif_cin()%></td>
                <td><%=model.getUsername() %></td>
                <td><%=model.getPassword()%></td>
                <td><%=model.getSolde()%></td>
                <td><%=model.getEtat()%></td>
                <td><%=model.getType_compte()%></td>
                <td>
                    <a href="${pageContext.request.contextPath}/ComptesServlet?id=<%=model.getCode()+"&operation=update"%>"><i class="bi bi-pencil-fill"></i></a> |
                    <a title="Recharger" href="${pageContext.request.contextPath}/ComptesServlet?id=<%=model.getCode()+"&operation=recharger"%>"><i class="bi bi-cash-coin text-success"></i></a>

                </td>
            </tr>
            <%}}}else{%>
            <td>Aucun compte pour l'instant</td>
            <%}%>
        </tbody>
    </table>
</div>
<%@include  file="../layout/script.jsp"%>
<script>
    
    $(document).ready(function(){
        $("#tbcomptes").DataTable({
        buttons: [
        'copy', 'excel', 'pdf'
         ]
});
    });
</script>
<%
}
%>