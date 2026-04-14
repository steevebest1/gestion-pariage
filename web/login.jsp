<%
    if(session.getAttribute("userInfo") == null ){
%>
<%@include  file="layout/headerLogin.jsp"%>
<div class="wrapper mt-4">
    <div class="container">
        <form method="POST" action="${pageContext.request.contextPath}/LoginServlet">
            <h3>CONNECTION</h3>
            <div class="container-fluid ms-0 mb-2">
                <p class='' style="color: red;">
                    <%= session.getAttribute("msg") != null? (String)session.getAttribute("msg"):"" %>
                    <% session.removeAttribute("msg"); %>
                </p>
            </div>
            <div class="form-row">
                <div class="form-wrapper">
                    <label for="">Nom d'utilisateur *</label>
                    <input type="text" class="form-control" name="username" required>
                </div>
            </div>
            <div class="form-row">
                <div class="form-wrapper">
                    <label for="">Mot de passe *</label>
                    <input type="password" class="form-control" name="pass" required>
                </div>
            </div>
            <button data-text="Se connecter">
                <span>Valider</span>
            </button>
            </div>
            
        </form>
    </div>
</div>
<%@include  file="layout/script.jsp"%>
<%@include  file="layout/footer.jsp"%>
<% }else{
    response.sendRedirect("index.jsp");
}%>
