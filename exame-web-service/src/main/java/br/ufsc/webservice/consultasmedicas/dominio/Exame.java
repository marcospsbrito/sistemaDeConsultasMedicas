package br.ufsc.webservice.consultasmedicas.dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Exame {
	
	@Id
	@GeneratedValue
	private long codigoExame;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Paciente paciente;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER,mappedBy="exame")
	private List<ItemExame> itens;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataExame;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Medico medicoSolicitante;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private ProfissionalSaude profissionalResponsavel;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Estabelecimento estabelecimento;

	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public List<ItemExame> getItens() {
		return itens;
	}
	public void setItens(List<ItemExame> itens) {
		this.itens = itens;
	}
	public Date getDataExame() {
		return dataExame;
	}
	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}
	public Medico getMedicoSolicitante() {
		return medicoSolicitante;
	}
	public void setMedicoSolicitante(Medico medicoSolicitante) {
		this.medicoSolicitante = medicoSolicitante;
	}
	public ProfissionalSaude getProfissionalResponsavel() {
		return profissionalResponsavel;
	}
	public void setProfissionalResponsavel(ProfissionalSaude profissionalResponsavel) {
		this.profissionalResponsavel = profissionalResponsavel;
	}
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	public long getCodigoExame() {
		return codigoExame;
	}
	public void setCodigoExame(long codigoExame) {
		this.codigoExame = codigoExame;
	}
	

}
