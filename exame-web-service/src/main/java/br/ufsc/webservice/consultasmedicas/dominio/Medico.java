package br.ufsc.webservice.consultasmedicas.dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Medico")
public class Medico extends ProfissionalSaude{
	private long CRM;

	public long getCRM() {
		return CRM;
	}
	public void setCRM(long cRM) {
		CRM = cRM;
	}
}
