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

@WebServlet("/ExecuteDeleteAbitanteServlet")
public class ExecuteDeleteAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idAbitanteParameter = request.getParameter("idAbitante");

		String destinazione;

		try {

			if (cancellaAbitante(idAbitanteParameter) != 0) {
				destinazione = "searchForm.jsp";
			} else {
				destinazione = "delete.jsp";
			}
			RequestDispatcher rd = request.getRequestDispatcher(destinazione);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private int cancellaAbitante(String idAbitante) throws Exception {

		AbitanteService abitanteService = MyServiceFactory.getAbitanteServiceInstance();

		Abitante abitante = abitanteService.findById(Long.parseLong(idAbitante));
		return abitanteService.rimuovi(abitante);

	}

}
