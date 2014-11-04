package br.ufsc.webservice.consultasmedicas.dominio;

public class Medico extends ProfissionalSaude{
	private long CRM;

	public long getCRM() {
		return CRM;
	}
	public void setCRM(long cRM) {
		CRM = cRM;
	}
}
