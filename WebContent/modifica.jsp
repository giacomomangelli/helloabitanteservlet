<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Aggiorna Abitante</title>
	</head>
	<body>
		<%Abitante abitante = null;%>
		<% if(request.getAttribute("messaggio_errore") != null){ %>
		<p style="color: red;"><%=request.getAttribute("messaggio_errore") %></p>
			<% if(request.getAttribute("abitante_modifica") != null){ %>
				<% abitante = (Abitante) request.getAttribute("abitante_modifica"); %>
			<%}  %>
	<%  }else{ %>
		Inserire dati da aggiornare<br>
	<%}    %>
	
	<% Abitante abitanteDaModificare = (Abitante) request.getAttribute("abitanteDaInviareAPaginaDettalio"); %><br>
	<form action="ExecuteModificaAbitanteServlet" method="post">
		<input type = "hidden" name = "idAbitante" value = "<%= abitanteDaModificare.getIdAbitante() %>">
		<label for="nomeInputId">NOME:</label><br>
		<input type="text" name="nomeInputId" id="nomeInputId" value = "<%= abitante!=null&&abitante.getNome()!=null?abitante.getNome():"" %>"> 
		<br>
		<label for="cognomeInputId">COGNOME:</label><br>
		<input type="text" name="cognomeInputId" id="cognomeInputId" value = "<%= abitante!=null&&abitante.getCognome()!=null?abitante.getCognome():"" %>"> 
		<br>
		<label for="etaInputId">ETA':</label><br>
		<input type="text" name="etaInputId" id="etaInputId" value = "<%= abitante!=null&&abitante.getEta()!=0?abitante.getEta():"" %>">
		<br>
		<label for="codiceFiscaleInputId">CODICE FISCALE:</label><br>
		<input type="text" name="codiceFiscaleInputId" id="codiceFiscaleInputId" value = "<%= abitante!=null&&abitante.getCodiceFiscale()!=null?abitante.getCodiceFiscale():"" %>">
		<br>
		<label for="mottoDiVitaInputId">MOTTO DI VITA:</label><br>
		<input type="text" name="mottoDiVitaInputId" id="mottoDiVitaInputId" value = "<%= abitante!=null&&abitante.getMottoDiVita()!=null?abitante.getMottoDiVita():"" %>">
		<br><br>
		<input type="submit" value="AGGIORNA">	
	</form>
	</body>
</html>