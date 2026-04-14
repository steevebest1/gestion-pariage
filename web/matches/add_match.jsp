<%
    if(session.getAttribute("userInfo") == null ){
    session.setAttribute("msg", "Veuillez d'abord vous connecter");
    response.sendRedirect("../login.jsp");
    }
    else{
%>
<%@include  file="../layout/header_2.jsp"%>
<div class="wrapper">
    <div class="container mt-1 mb-1">
        <form method="POST" action="${pageContext.request.contextPath}/MatchesServlet?operation=add">
            <h3>ENREGISTRER UN MATCH</h3>
            <div class="container-fluid mb-2">
                <p class='' style="color: red;">
                    <%= session.getAttribute("msg") != null? (String)session.getAttribute("msg"):"" %>
                    <% session.removeAttribute("msg"); %>
                    <%= request.getParameter("msg") != null? request.getParameter("msg"):"" %>
                </p>
            </div>
            <div class="form-row">
                <div class="form-wrapper">
                    <label for="">Type de match*</label>
                    <select id="" name="type_match" class="form-control" required>
                        <option selected disabled>Votre choix</option>
                        <option value="Championnat">Championnat</option>
			<option value="Coupe du monde">Coupe du monde</option>
                        <option value="Eliminatoire">Eliminatoire</option>
                        <option value="Amical">Amical</option>
                    </select>
                    <i class="zmdi zmdi-chevron-down"></i>
                </div>
                <div class="form-wrapper">
                    <label for="">Pays *</label>
                    <input type="text" name="pays" class="form-control" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-wrapper">
                    <label for="">Equipe receveuse</label>                    
                    <input type="text" name="equ_rec" class="form-control" required >
                </div>
                <div class="form-wrapper">
                    <label for="">Equipe visiteuse</label>                    
                    <input type="text" name="equ_vis" class="form-control" required >
                </div>
            </div>
            <div class="form-row last">
                <div class="form-wrapper">
                    <label for="">Cote*</label>
                    <input type="number" name="cote" min="1" step="0.1" class="form-control" required="">
                </div>
                <div class="form-wrapper">
                    <label for="">Score *</label>
                    
                    <input type="number" name="equ_rec_but" min="0" value="0" step="1" class="form-control" placeholder="Nombre de but de l'equipe receveuse" disabled>
                    <input type="number" name="equ_vis_but" min="0" step="1" value="0" class="form-control" placeholder="Buts equipe visiteuse" disabled>
                </div>
            </div>
            <button data-text="Enregistrer match">
                <span>Valider</span>
            </button>
        </form>
    </div>
</div>
<%@include  file="../layout/script.jsp"%>
<%@include  file="../layout/footer.jsp"%>

<%

}
%>

