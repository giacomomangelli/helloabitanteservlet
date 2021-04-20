package it.helloabitante.dao;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.dao.abitante.AbitanteDAOImpl;

public class MyDaoFactory {

	private static AbitanteDAO ABITANTE_DAO_INSTANCE = null;

	public static AbitanteDAO getAbitanteDAOInstance() {
		if (ABITANTE_DAO_INSTANCE == null)
			ABITANTE_DAO_INSTANCE = new AbitanteDAOImpl();

		return ABITANTE_DAO_INSTANCE;
	}

}
