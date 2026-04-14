<%
    if(session.getAttribute("userInfo") != null ){
%>

<%
    }else{
}
%>




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

            </tr>
        </thead>
        <tbody class="table-group-divider">
            <%
             MatchesServlet serv = new MatchesServlet();
             serv.refresh_liste_matchesC(request, response);
             ArrayList<MatchesModel> liste=(ArrayList<MatchesModel>)session.getAttribute("liste_matchesC");
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
            </tr>
            <%}}}else{%>
            <td>Aucun match pour l'instant</td>
            <%}%>
        </tbody>
    </table>
                    </div>
                </div>
                </hr>
                <div class="container">
                    <span class="btn btn-primary container mt-2">Paiements</span>
                    <div class="container-fluid">
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
             MatchesServlet serv1 = new MatchesServlet();
             serv1.refresh_liste_paiementsC(request, response);
             ArrayList<PaiementsModel> liste1=(ArrayList<PaiementsModel>)session.getAttribute("liste_paiementsC");
             if(liste1!=null){
                  if(liste1.size()>0){
                     for(PaiementsModel model:liste1){
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

        
        
        
        
        <span class="btn btn-primary container mt-2">Paiements</span>
                    <div class="container-fluid">
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
             MatchesServlet serv1 = new MatchesServlet();
             serv1.refresh_liste_paiementsC(request, response);
             ArrayList<PaiementsModel> liste1=(ArrayList<PaiementsModel>)session.getAttribute("liste_paiementsC");
             if(liste1!=null){
                  if(liste1.size()>0){
                     for(PaiementsModel model:liste1){
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

        
        
        <span class="btn btn-primary container mt-2">Matches</span>
                    <div class="container-fluid">
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

            </tr>
        </thead>
        <tbody class="table-group-divider">
            <%
             MatchesServlet serv = new MatchesServlet();
             serv.refresh_liste_matchesC(request, response);
             ArrayList<MatchesModel> liste=(ArrayList<MatchesModel>)session.getAttribute("liste_matchesC");
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
            </tr>
            <%}}}else{%>
            <td>Aucun match pour l'instant</td>
            <%}%>
        </tbody>
    </table>




<div class="wrapper">
    <div class="inner">
        <form action="">
            <h3>INSCRIPTION</h3>
            <div class="form-row">
                <div class="form-wrapper">
                    <label for="">Name *</label>
                    <input type="text" class="form-control" placeholder="Your Name">
                </div>
                <div class="form-wrapper">
                    <label for="">Phone *</label>
                    <input type="text" class="form-control" placeholder="Phone">
		</div>
            </div>
            <div class="form-row">
                <div class="form-wrapper">
                    <label for="">Check-in *</label>
                    <span class="lnr lnr-calendar-full"></span>
                    <input type="text" class="form-control datepicker-here" data-language='en' data-date-format="dd M yyyy" id="dp1">
		</div>
                <div class="form-wrapper">
                    <label for="">Check-out *</label>
                    <span class="lnr lnr-calendar-full"></span>
                    <input type="text" class="form-control datepicker-here" data-language='en'  data-date-format="dd M yyyy" id="dp2">
                    </div>
            </div>
            <div class="form-row last">
                <div class="form-wrapper">
                    <label for="">Adults *</label>
                    <select name="" id="" class="form-control">
                        <option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
                    </select>
                    <i class="zmdi zmdi-chevron-down"></i>
                </div>
                <div class="form-wrapper">
                    <label for="">Chidren *</label>
                    <select name="" id="" class="form-control">
                        <option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
                    </select>
                    <i class="zmdi zmdi-chevron-down"></i>
                </div>
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox"> No one rejects, dislikes, or avoids pleasure itself.
                    <span class="checkmark"></span>
                </label>
            </div>
            <button data-text="Book Room">
                <span>Valider</span>
            </button>
        </form>
    </div>
</div>

        
        
        
        
        
        
        <div class="form-wrapper">
                    <span class="btn btn-primary container mt-2">Paiements</span>
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
                             serv.refresh_liste_paiementsC(request, response);
                             ArrayList<PaiementsModel> liste1=(ArrayList<PaiementsModel>)session.getAttribute("liste_paiementsW");
                             if(liste1!=null){
                                  if(liste1.size()>0){
                                     for(PaiementsModel mod:liste1){
                            %>
                            <tr>
                                <td><%=mod.getId()%></td>
                                <td><%=mod.getId_pariage()%></td>
                                <td><%=mod.getDate() %></td>
                            </tr>
                            <%}}}else{%>
                            <p class="btn">Aucun paiement pour l'instant</p>
                            <%}%>
                        </tbody>
                    </table>
                </div>