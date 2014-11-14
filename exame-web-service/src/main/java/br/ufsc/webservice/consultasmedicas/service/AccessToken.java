package br.ufsc.webservice.consultasmedicas.service;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AccessToken {

	@Id
	private String token;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataExpiracao;

	private long habilitacao;
	

	public AccessToken() {
	}
	
	public AccessToken(String token, Date dataExpiracao, long habilitacao) {
		this.dataExpiracao = dataExpiracao;
		this.token = token;
		this.setHabilitacao(habilitacao);
		
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public long getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(long habilitacao) {
		this.habilitacao = habilitacao;
	}

}
