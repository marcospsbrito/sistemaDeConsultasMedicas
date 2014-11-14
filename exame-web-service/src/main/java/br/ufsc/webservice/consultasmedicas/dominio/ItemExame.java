package br.ufsc.webservice.consultasmedicas.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemExame {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigoItem;
	@Enumerated(EnumType.STRING)
	private TipoItemExame  tipoItem;
	@ManyToOne(cascade=CascadeType.ALL)
	private Exame exame;
	private String resultado;
	private String ValorReferencia;
	
	public TipoItemExame getTipoItem() {
		return tipoItem;
	}
	public void setTipoItem(TipoItemExame tipoItem) {
		this.tipoItem = tipoItem;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getValorReferencia() {
		return ValorReferencia;
	}
	public void setValorReferencia(String valorReferencia) {
		ValorReferencia = valorReferencia;
	}
	public long getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(long codigoItem) {
		this.codigoItem = codigoItem;
	}
}
