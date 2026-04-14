
<%@page import="sb.chcl.belparyaj.model.ComptesModel"%>
<%! 
    ComptesModel model = new ComptesModel();
%>

<%
        if(session.getAttribute("userInfo")!=null && session.getAttribute("compte")!=null){
            model = (ComptesModel)session.getAttribute("compte");
            ComptesModel user = (ComptesModel)session.getAttribute("userInfo");
%>
<%@include  file="../layout/header_2.jsp"%>
<div class="wrapper">
    <div class="container mt-1 mb-1">
        <form method="POST" action="${pageContext.request.contextPath}/ComptesServlet?operation=update">
            <h3>Modification <span class="text-dark h5">(<%= model.getCode() %>)</span></h3>
            <div class="container-fluid mb-2">
                <p class='' style="color: red;">
                    <%= session.getAttribute("msg") != null? (String)session.getAttribute("msg"):"" %>
                    <% session.removeAttribute("msg"); %>
                    <%= request.getParameter("msg") != null? request.getParameter("msg"):"" %>
                </p>
            </div>
            <div class="form-row">
                <div class="form-wrapper">
                    <label for="">Nom *</label>
                    <input type="text" name="nom" class="form-control" value="<%= model.getNom() %>" required>
                </div>
                <div class="form-wrapper">
                    <label for="">Prénom *</label>
                    <input type="text" name="prenom" class="form-control" value="<%= model.getPrenom() %>" required>
                </div>
            </div>
            <div class="form-row last">
                <div class="form-wrapper">
                    <label for="">Sexe *</label>
                    
                    <select id="" name="sexe" class="form-control" required>
                        <option value="M" <%= model.getSexe().equalsIgnoreCase("M")? "selected" : ""%> >Masculin</option>
			<option value="F" <%= model.getSexe().equalsIgnoreCase("F")? "selected" : ""%> >Féminin</option>
                    </select>
                    <i class="zmdi zmdi-chevron-down"></i>
                </div>
                <div class="form-wrapper">
                    <label for="">Adresse</label>
                    <input type="text" name="adresse" class="form-control" value="<%= model.getAdresse()%>"  >
                </div>
            </div>
            <div class="form-row">
                <div class="form-wrapper">
                    <label for="">Lieu de naissance</label>
                    <input type="text" name="pob" class="form-control" value="<%= model.getLieu_naissance()%>" >
                </div>
                <div class="form-wrapper">
                    <label for="">Date de naissance</label>                    
                    <input type="date" name="dob" class="form-control" value="<%= model.getDate_naissance() %>"required >
                    </div>
            </div>
            <div class="form-row last">
                <div class="form-wrapper">
                    <label for="">Téléphone (+509) *</label>
                    <input type="number" name="phone" class="form-control" value="<%= model.getPhone()%>" required="">
                </div>
                <div class="form-wrapper">
                    <label for="">Nif/Cin *</label>
                    <input type="number" name="nif_cin" class="form-control" value="<%= model.getNif_cin()%>" required>
                </div>
            </div>
            <div class="form-row last">
                <div class="form-wrapper">
                    <label for="">Nom d'utilisateur *</label>
                    <input type="text" name="username" class="form-control" value="<%= model.getUsername() %>" required>
                </div>
                <div class="form-wrapper">
                    <label for="">Mot de passe *</label>
                    <input type="text" name="pass" class="form-control" value="<%= model.getPassword()%>" required>
                </div>
            </div>
                <%
                    if(user.getType_compte().equalsIgnoreCase("admin")){%>
            <div class="form-row last">
                <div class="form-wrapper">
                    <label for="">Solde *</label>
                    <input type="number" name="solde" class="form-control" value="<%= model.getSolde()%>" required>
                </div>
                <div class="form-wrapper">
                    <label for="">Type compte *</label>                    
                    <select id="" name="type" class="form-control" required>
                        <option value="simple" <%= model.getSexe().equalsIgnoreCase("simple")? "selected" : ""%> >Simple</option>
			<option value="admin" <%= model.getSexe().equalsIgnoreCase("admin")? "selected" : ""%> >Admin</option>
                    </select>
                    <i class="zmdi zmdi-chevron-down"></i>
                </div>
            </div>
            <div class="form-row last">
                <div class="form-wrapper">
                    <label for="">Etat *</label>                    
                    <select id="" name="etat" class="form-control" required>
                        <option value="a" <%= model.getSexe().equalsIgnoreCase("a")? "selected" : ""%> >Actif</option>
			<option value="s" <%= model.getSexe().equalsIgnoreCase("s")? "selected" : ""%> >Supprimé</option>
                        <option value="f" <%= model.getSexe().equalsIgnoreCase("f")? "selected" : ""%> >Fermé</option>
                    </select>
                    <i class="zmdi zmdi-chevron-down"></i>
                </div>
            </div>
                   <% }
                %>
            <button data-text="Modifier">
                <span>Valider</span>
            </button>
        </form>
    </div>
</div>
<%@include  file="../layout/script.jsp"%>
<%@include  file="../layout/footer.jsp"%>
<%}else{
    session.setAttribute("msg", "Veuillez d'abord vous connecter");
    response.sendRedirect("view_compte.jsp");
}%>
