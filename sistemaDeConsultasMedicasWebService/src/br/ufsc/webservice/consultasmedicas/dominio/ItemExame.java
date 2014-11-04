package br.ufsc.webservice.consultasmedicas.dominio;

public class ItemExame {
	private TipoItemExame  tipoItem;
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
}
