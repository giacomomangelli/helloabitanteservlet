<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dettaglio Abitante</title>
	</head>
	<body>
		<% Abitante abitante = (Abitante) request.getAttribute("abitanteDaInviareAPaginaDettalio"); %><br>
		<label>Nome:</label> <%= abitante.getNome() %><br>
		<label>Cognome:</label> <%= abitante.getCognome() %><br>
		<label>Età</label> <%= abitante.getEta() %><br>
		<label>Codice Fiscale:</label> <%= abitante.getCodiceFiscale() %><br>
		<label>Motto Di Vita:</label> <%= abitante.getMottoDiVita() %><br><br>
		<a href = "searchForm.jsp">Home</a>
	</body>
</html>