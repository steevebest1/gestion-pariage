
<%@page import="sb.chcl.belparyaj.model.ComptesModel"%>
<%! 
    ComptesModel model = new ComptesModel();
%>

<%
        if(session.getAttribute("userInfo")!=null && session.getAttribute("compte")!=null){
        if( !((ComptesModel)session.getAttribute("userInfo")).getType_compte().equalsIgnoreCase("admin")){
        response.sendRedirect("view_compte.jsp");
    }
            model = (ComptesModel)session.getAttribute("compte");
            ComptesModel user = (ComptesModel)session.getAttribute("userInfo");
%>
<%@include  file="../layout/header_2.jsp"%>
<div class="wrapper">
    <div class="container mt-1 mb-1">
        <form method="POST" action="${pageContext.request.contextPath}/ComptesServlet?operation=fund&id=<%= model.getCode() %>">
            <h3>RECHARGER <span class="text-dark h5">(<%= model.getCode() %>)</span></h3>
            <div class="container-fluid mb-2">
                <p class='' style="color: red;">
                    <%= session.getAttribute("msg") != null? (String)session.getAttribute("msg"):"" %>
                    <% session.removeAttribute("msg"); %>
                    <%= request.getParameter("msg") != null? request.getParameter("msg"):"" %>
                </p>
            </div>
            <div class="form-row">
                <div class="form-wrapper">
                    <label for="">Montant *</label>
                    <input type="number" min="0" step="0.1" name="montant" class="form-control" value="<%= model.getPrenom() %>" required>
                </div>
            </div>
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
