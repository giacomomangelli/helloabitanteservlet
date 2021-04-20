package it.helloabitante.service;

import it.helloabitante.dao.MyDaoFactory;
import it.helloabitante.service.abitante.AbitanteService;
import it.helloabitante.service.abitante.AbitanteServiceImpl;

public class MyServiceFactory {
	// rendiamo questo factory SINGLETON
	private static AbitanteService ABITANTE_SERVICE_INSTANCE;

	public static AbitanteService getAbitanteServiceInstance() {
		if (ABITANTE_SERVICE_INSTANCE == null)
			ABITANTE_SERVICE_INSTANCE = new AbitanteServiceImpl();

		ABITANTE_SERVICE_INSTANCE.setAbitanteDAO(MyDaoFactory.getAbitanteDAOInstance());

		return ABITANTE_SERVICE_INSTANCE;
	}
}
