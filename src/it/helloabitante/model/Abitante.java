package it.helloabitante.model;

public class Abitante {

	private Long idAbitante;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private int eta;
	private String mottoDiVita;

	public Abitante() {
	}

	public Abitante(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}

	public Abitante(Long idAbitante, String nome, String cognome, String codiceFiscale, int eta, String mottoDiVita) {
		super();
		this.idAbitante = idAbitante;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.eta = eta;
		this.mottoDiVita = mottoDiVita;
	}

	public Long getIdAbitante() {
		return idAbitante;
	}

	public void setIdAbitante(Long idAbitante) {
		this.idAbitante = idAbitante;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getMottoDiVita() {
		return mottoDiVita;
	}

	public void setMottoDiVita(String mottoDiVita) {
		this.mottoDiVita = mottoDiVita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Abitante(String nome, String cognome, String codiceFiscale, int eta, String mottoDiVita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.eta = eta;
		this.mottoDiVita = mottoDiVita;
	}

	
	
}
