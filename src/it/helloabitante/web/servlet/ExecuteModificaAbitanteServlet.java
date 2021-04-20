package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;

@WebServlet("/ExecuteModificaAbitanteServlet")
public class ExecuteModificaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idAbitanteParameter = request.getParameter("idAbitante");
		String nameParameter = request.getParameter("nomeInputId");
		String surnameParameter = request.getParameter("cognomeInputId");
		String etaParameter = request.getParameter("etaInputId");
		String codiceFiscaleParameter = request.getParameter("codiceFiscaleInputId");
		String mottoDiVitaParameter = request.getParameter("mottoDiVitaInputId");

		String destinazione = null;

		Abitante abitante = valuesSaver(nameParameter, surnameParameter, etaParameter, codiceFiscaleParameter,
				mottoDiVitaParameter);

		if (validationInput(nameParameter, surnameParameter, etaParameter, codiceFiscaleParameter,
				mottoDiVitaParameter)) {
			try {
				abitante.setIdAbitante(Long.parseLong(idAbitanteParameter));
				MyServiceFactory.getAbitanteServiceInstance().aggiorna(abitante);
			} catch (Exception e) {
				e.printStackTrace();
			}
			destinazione = "searchForm.jsp";

		} else {

			if (abitante != null) {
				request.setAttribute("abitante_modifica", abitante);
			}
			String messaggioErrore = "Valorizzare correttamente tutti i campi";
			request.setAttribute("messaggio_errore", messaggioErrore);
			destinazione = "modifica.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(destinazione);
		rd.forward(request, response);

	}

	private boolean validationInput(String nome, String cognome, String eta, String codiceFiscale, String mottoDiVita) {

		if (nome == null || cognome == null || eta == null || codiceFiscale == null || mottoDiVita == null
				|| nome.isEmpty() || cognome.isEmpty() || eta.isEmpty() || codiceFiscale.isEmpty()
				|| mottoDiVita.isEmpty() || Integer.parseInt(eta) < 0) {
			return false;
		}
		return true;
	}

	private Abitante valuesSaver(String nome, String cognome, String eta, String codiceFiscale, String mottoDiVita) {

		Abitante abitante = new Abitante();

		if (nome == null || cognome == null || eta == null || codiceFiscale == null || mottoDiVita == null) {
			return null;
		}
		if (!nome.isEmpty()) {
			abitante.setNome(nome);
		}
		if (!cognome.isEmpty()) {
			abitante.setCognome(cognome);
		}
		if (!eta.isEmpty() && Integer.parseInt(eta) > 0) {
			int etaParsed = Integer.parseInt(eta);
			abitante.setEta(etaParsed);
		}
		if (!codiceFiscale.isEmpty()) {
			abitante.setCodiceFiscale(codiceFiscale);
		}
		if (!mottoDiVita.isEmpty()) {
			abitante.setMottoDiVita(mottoDiVita);
		}
		return abitante;

	}
}
