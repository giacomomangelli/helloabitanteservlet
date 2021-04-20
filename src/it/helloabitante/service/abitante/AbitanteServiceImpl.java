package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public class AbitanteServiceImpl implements AbitanteService {

	private AbitanteDAO abitanteDAO;

	public void setAbitanteDAO(AbitanteDAO abitanteDAO) {
		this.abitanteDAO = abitanteDAO;
	}

	@Override
	public List<Abitante> cercaPerNomeECognome(String nome, String cognome) {
		return abitanteDAO.findByNomeAndCognome(nome, cognome);
	}

	@Override
	public Abitante findById(Long id) throws Exception {
		if(id < 1) {
			throw new Exception("Inserimento invalido");
		}
		return abitanteDAO.get(id);
	}

	@Override
	public int aggiorna(Abitante abitante) throws Exception {
		if(abitante == null) {
			throw new Exception("Inserimento invalido");
		}
		return abitanteDAO.update(abitante);
	}

	@Override
	public int inserisci(Abitante abitante) throws Exception {
		if(abitante == null) {
			throw new Exception("Inserimento invalido");
		}
		return abitanteDAO.insert(abitante);
	}

	@Override
	public int rimuovi(Abitante abitante) throws Exception {
		if(abitante == null) {
			throw new Exception("Inserimento invalido");
		}
		return abitanteDAO.delete(abitante);
	}

}
