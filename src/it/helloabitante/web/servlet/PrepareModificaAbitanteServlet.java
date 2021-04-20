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

@WebServlet("/PrepareModificaAbitanteServlet")
public class PrepareModificaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String parametroIdDellAbitanteDiCuiVoglioLaModifica = request.getParameter("idDaInviareComeParametro");

		AbitanteService abitanteServiceInstance = MyServiceFactory.getAbitanteServiceInstance();
		try {
			Abitante result = abitanteServiceInstance
					.findById(Long.parseLong(parametroIdDellAbitanteDiCuiVoglioLaModifica));
			request.setAttribute("abitanteDaInviareAPaginaDettalio", result);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("modifica.jsp");
		rd.forward(request, response);
	}
}
