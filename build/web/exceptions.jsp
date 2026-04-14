<%@page contentType="text/html" isErrorPage="true" pageEncoding="UTF-8"%>
<%@include  file="layout/header.jsp"%>
<div class="mb-2"></div>
<div class="container">
    Exceptions :<%=request.getAttribute("exception")!=null?request.getAttribute("exception"):""%>
</div>
<%@include  file="layout/script.jsp"%>
<%@include  file="layout/footer.jsp"%>