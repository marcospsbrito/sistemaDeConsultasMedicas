package br.ufsc.webservice.consultasmedicas.dominio;

import java.util.Date;
import java.util.List;

public class Exame {
	
	private long codigoExame;
	private Paciente paciente;
	private List<ItemExame> itens;
	private Date dataExame;
	private Medico medicoSolicitante;
	private ProfissionalSaude profissionalResponsavel;
	
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
	private Estabelecimento estabelecimento;
	

}
