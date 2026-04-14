<%
    if(session.getAttribute("userInfo") == null ){
    session.setAttribute("msg", "Veuillez d'abord vous connecter");
    response.sendRedirect("../login.jsp");
    }
    else{
%>
<%@page import="java.util.ArrayList"%>
<%@page import="sb.chcl.belparyaj.model.MatchesModel"%>
<%@include  file="../layout/header_2.jsp"%>
<div class="wrapper">
    <div class="container mt-1 mb-1">
        <form method="POST" action="${pageContext.request.contextPath}/PariagesServlet?operation=add">
            <h3>ENREGISTRER UN PARIAGE</h3>
            <div class="container-fluid mb-2">
                <p class='' style="color: red;">
                    <%= session.getAttribute("msg") != null? (String)session.getAttribute("msg"):"" %>
                    <%= session.getAttribute("msgV")!=null? (((ArrayList<String>) session.getAttribute("msgV")).get(0)):"" %>
                    <% 
                        session.removeAttribute("msgV");
                        session.removeAttribute("msg"); 
                    %>
                    <%= request.getParameter("msg") != null? request.getParameter("msg"):"" %>
                </p>
            </div>
            <div class="form-row">
                <div class="form-wrapper">
                    <label for="">Id Match *</label>
                    <input type="text" name="id_match" class="form-control" disabled value="<%= ((MatchesModel) session.getAttribute("matchP")).getId()  %>" required>
                </div>
                <div class="form-wrapper">
                    <label for="">Montant *</label>
                    <input type="number" name="montant" min="0.1" step="0.1" class="form-control" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-wrapper">
                    <label for="">Buts *</label>                    
                    <input type="number" min="0" step="1" name="equ_rec_but" class="form-control" placeholder="Equipe receveuse" required >
                </div>
                <div class="form-wrapper">
                    <label for="">Buts *</label>                    
                    <input type="number" min="0" step="1" name="equ_vis_but" placeholder="Equipe visiteuse" class="form-control" required >
                </div>
            </div>
            <button data-text="Enregistrer">
                <span>Valider</span>
            </button>
        </form>
    </div>
</div>
<%@include  file="../layout/script.jsp"%>
<%@include  file="../layout/footer.jsp"%>
<% } %>
