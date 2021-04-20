<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Inserimento Abitante</title>
	</head>
<body>
	<% if(request.getAttribute("messaggio_errore") != null){ %>
		<p style="color: red;"><%=request.getAttribute("messaggio_errore") %></p>
	<%  }else{ %>
		Inserire dati da inserire<br>
	<%}    %>
	<form action="ExecuteInsertAbitanteServlet" method="post">
		<label for="nomeInputId">NOME:</label><br>
		<input type="text" name="nomeInputId" id="nomeInputId">
		<br>
		<label for="cognomeInputId">COGNOME:</label><br>
		<input type="text" name="cognomeInputId" id="cognomeInputId">
		<br>
		<label for="etaInputId">ETA':</label><br>
		<input type="text" name="etaInputId" id="etaInputId">
		<br>
		<label for="codiceFiscaleInputId">CODICE FISCALE:</label><br>
		<input type="text" name="codiceFiscaleInputId" id="codiceFiscaleInputId">
		<br>
		<label for="mottoDiVitaInputId">MOTTO DI VITA:</label><br>
		<input type="text" name="mottoDiVitaInputId" id="mottoDiVitaInputId">
		<br><br>
		<input type="submit" value="AGGIUNGI">		
	
	</form>
</body>
</html>