package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public interface AbitanteService {
	public void setAbitanteDAO(AbitanteDAO abitanteDAO);

	public List<Abitante> cercaPerNomeECognome(String nome, String cognome);
	
	public Abitante findById(Long id) throws Exception;
	
	public int aggiorna(Abitante abitante) throws Exception;
	
	public int inserisci(Abitante abitante) throws Exception;
	
	public int rimuovi(Abitante abitante) throws Exception;
	
}
