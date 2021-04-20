package it.helloabitante.dao.abitante;

import java.sql.Connection;
import java.util.List;

import it.helloabitante.dao.IBaseDAO;
import it.helloabitante.model.Abitante;

public interface AbitanteDAO extends IBaseDAO<Abitante> {
	public void setConnection(Connection connection);
	public List<Abitante> findByNomeAndCognome(String nome, String cognome);
}
