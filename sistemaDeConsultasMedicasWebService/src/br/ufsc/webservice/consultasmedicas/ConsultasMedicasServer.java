package br.ufsc.webservice.consultasmedicas;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.ufsc.webservice.consultasmedicas.dominio.Exame;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ConsultasMedicasServer {
	
	@WebMethod
	String efetuarLogin(String login, String hashDaSenha);

	@WebMethod
	boolean cadastrarResultadoExame(String token, long cpf, Exame exame);

	@WebMethod
	Exame consultarExame(long cpf, long codigoExame);

	@WebMethod
	float excluirExame(String token, long codigoExame);
}
