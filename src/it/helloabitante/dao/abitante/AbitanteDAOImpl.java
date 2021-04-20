package it.helloabitante.dao.abitante;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.model.Abitante;

public class AbitanteDAOImpl implements AbitanteDAO {

	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Abitante> findByNomeAndCognome(String nome, String cognome) {
		List<Abitante> result = new ArrayList<>();

		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (abitanteItem.getNome().startsWith(nome) && abitanteItem.getCognome().startsWith(cognome))
				result.add(abitanteItem);
		}
		return result;
	}

	@Override
	public List<Abitante> list() throws Exception {
		List<Abitante> abitanti = new ArrayList<>();
		for (Abitante abitante : DB_Mock.LISTA_ABITANTI) {
			abitanti.add(abitante);
		}
		return abitanti;
	}

	@Override
	public Abitante get(Long id) throws Exception {
		
		for(Abitante abitante : DB_Mock.LISTA_ABITANTI) {
			if(abitante.getIdAbitante().equals(id)) {
				return abitante;
			}
		}
		return null;
	}

	@Override
	public int update(Abitante input) throws Exception {

		for (Abitante abitante : DB_Mock.LISTA_ABITANTI) {
			if (abitante.getIdAbitante().equals(input.getIdAbitante())) {
				abitante.setCodiceFiscale(input.getCodiceFiscale());
				abitante.setCognome(input.getCognome());
				abitante.setEta(input.getEta());
				abitante.setMottoDiVita(input.getMottoDiVita());
				abitante.setNome(input.getNome());
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int insert(Abitante input) throws Exception {
		input.setIdAbitante(DB_Mock.getNexIdAvailable());
		if (DB_Mock.LISTA_ABITANTI.add(input)) {
			return 1;
		}
		return 0;
	}

	@Override
	public int delete(Abitante input) throws Exception {
		if (DB_Mock.LISTA_ABITANTI.remove(input)) {
			return 1;
		}
		return 0;
	}

}
