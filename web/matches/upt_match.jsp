<%@page import="sb.chcl.belparyaj.model.MatchesModel"%>
<%! 
    MatchesModel model = new MatchesModel();
%>

<%
        if(session.getAttribute("userInfo")!=null && session.getAttribute("match")!=null){
            model = (MatchesModel)session.getAttribute("match");
            ComptesModel user = (ComptesModel)session.getAttribute("userInfo");
%>
<%@include  file="../layout/header_2.jsp"%>
<div class="wrapper">
    <div class="container mt-1 mb-1">
        <form method="POST" action="${pageContext.request.contextPath}/MatchesServlet?operation=update">
            <h3>TERMINER UN MATCH</h3>
            <div class="container-fluid mb-2">
                <p class='' style="color: red;">
                    <%= session.getAttribute("msg") != null? (String)session.getAttribute("msg"):"" %>
                    <% session.removeAttribute("msg"); %>
                    <%= request.getParameter("msg") != null? request.getParameter("msg"):"" %>
                </p>
            </div>
            
            <div class="form-row last">
                <div class="form-wrapper">
                    <label for="">Date</label>
                    <input type="date" name="date" class="form-control" value="<%= model.getDate() %>" disabled>
                </div>
                
                <div class="form-wrapper">
                    <label for="">Heure</label>
                    <input type="time" name="heure" class="form-control" value="<%= model.getHeure() %>" disabled>
                </div>
            </div>
            <div class="form-row">
                <div class="form-wrapper">
                    <label for="">Equipe receveuse</label>                    
                    <input type="text" name="equ_rec" class="form-control" value="<%= model.getEq_rec()%>" disabled >
                </div>
                <div class="form-wrapper">
                    <label for="">Equipe visiteuse</label>                    
                    <input type="text" name="equ_vis" class="form-control" value="<%= model.getEq_vis()%>" disabled required >
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
            <button data-text="Terminer">
                <span>Valider</span>
            </button>
        </form>
    </div>
</div>
<%@include  file="../layout/script.jsp"%>
<%@include  file="../layout/footer.jsp"%>
<%}else{
    response.sendRedirect("index.jsp");
}%>
