package it.helloabitante.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import it.helloabitante.model.Abitante;

public class DB_Mock {
	public static final List<Abitante> LISTA_ABITANTI = new ArrayList<>();

	static {
		// preparo una lista mock perché ancora non ho il collegamento alla
		// base dati
		LISTA_ABITANTI.add(new Abitante(1l, "mario", "rossi", "mrs111", 60, "ciao a tutti"));
		LISTA_ABITANTI.add(new Abitante(2l, "mario2", "rossi2", "mrs222", 40, "mi piace"));
		LISTA_ABITANTI.add(new Abitante(3l, "mario3", "rossi3", "mrs333", 29, "lascia stare"));
		LISTA_ABITANTI.add(new Abitante(4l, "peppe", "bianchi", "pppbbb4", 23, "evviva il giorno"));
		LISTA_ABITANTI.add(new Abitante(5l, "pluto", "rossi", "plros", 17, "la luna bussò"));
		LISTA_ABITANTI.add(new Abitante(6l, "mario36", "rossi36", "mrs366", 39, "Highway to hell"));
		LISTA_ABITANTI.add(new Abitante(7l, "antonio", "sattoni", "mrs333", 77, "le ali della libertà"));
	}

	public static Long getNexIdAvailable() {
		Long resultId = null;
		if (LISTA_ABITANTI == null || LISTA_ABITANTI.isEmpty()) {
			resultId = 1L;
		}
		resultId = LISTA_ABITANTI.stream().max(Comparator.comparing(Abitante::getIdAbitante)).get().getIdAbitante();
		return ++resultId;
	}

}
