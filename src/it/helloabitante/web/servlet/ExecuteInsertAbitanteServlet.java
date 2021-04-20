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
import it.helloabitante.service.abitante.AbitanteService;

@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nameParameter = request.getParameter("nomeInputId");
		String surnameParameter = request.getParameter("cognomeInputId");
		String etaParameter = request.getParameter("etaInputId");
		String codiceFiscaleParameter = request.getParameter("codiceFiscaleInputId");
		String mottoDiVitaParameter = request.getParameter("mottoDiVitaInputId");

		String destinazione = null;

		if (validationInput(nameParameter, surnameParameter, etaParameter, codiceFiscaleParameter,
				mottoDiVitaParameter)) {

			destinazione = "searchForm.jsp";
			inserisciAbitante(nameParameter, surnameParameter, etaParameter, codiceFiscaleParameter,
					mottoDiVitaParameter);

		} else {

			String messaggioErrore = "Valorizzare correttamente tutti i campi";
			request.setAttribute("messaggio_errore", messaggioErrore);
			destinazione = "insert.jsp";
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

	private void inserisciAbitante(String nome, String cognome, String eta, String codiceFiscale, String mottoDiVita) {

		int etaParsed = Integer.parseInt(eta);

		Abitante abitante = new Abitante(nome, cognome, codiceFiscale, etaParsed, mottoDiVita);
		AbitanteService abitanteService = MyServiceFactory.getAbitanteServiceInstance();

		try {
			abitanteService.inserisci(abitante);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
