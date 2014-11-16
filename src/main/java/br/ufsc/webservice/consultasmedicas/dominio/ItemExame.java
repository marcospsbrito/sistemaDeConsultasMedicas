package br.ufsc.webservice.consultasmedicas.dominio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class ItemExame {
	
	private long codigoItem;
	private TipoItemExame  tipoItem;
	private Exame exame;
	private String resultado;
	private String ValorReferencia;
	
	@Enumerated(EnumType.STRING)
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
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(long codigoItem) {
		this.codigoItem = codigoItem;
	}
	@XmlTransient
	@ManyToOne(cascade=CascadeType.ALL)
	public Exame getExame() {
		return exame;
	}
	public void setExame(Exame exame) {
		this.exame = exame;
	}
}
