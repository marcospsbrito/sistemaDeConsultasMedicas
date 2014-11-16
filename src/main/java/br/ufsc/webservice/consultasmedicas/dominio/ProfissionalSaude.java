package br.ufsc.webservice.consultasmedicas.dominio;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoProfissional")
public class ProfissionalSaude {
	
	@Id
	@GeneratedValue
	private long habilitacao;
	private String nome;
	@Column(unique=true)
	private String login;
	private String hashSenha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getHabilitacao() {
		return habilitacao;
	}
	public void setHabilitacao(long habilitacao) {
		this.habilitacao = habilitacao;
	}
	public String getHashSenha() {
		return hashSenha;
	}
	public void setHashSenha(String hashSenha) {
		this.hashSenha = hashSenha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

}
