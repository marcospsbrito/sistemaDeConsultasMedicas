package br.ufsc.webservice.consultasmedicas;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.ufsc.webservice.consultasmedicas.dominio.AccessToken;
import br.ufsc.webservice.consultasmedicas.dominio.Exame;
import br.ufsc.webservice.consultasmedicas.exceptions.ErroLoginException;
import br.ufsc.webservice.consultasmedicas.exceptions.ExameInexistenteException;
import br.ufsc.webservice.consultasmedicas.exceptions.ExameInexistenteParaOPacienteException;
import br.ufsc.webservice.consultasmedicas.exceptions.TokenNaoExisteException;
import br.ufsc.webservice.consultasmedicas.exceptions.tokenExpiradoException;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ConsultasMedicasServer {
	
	@WebMethod
	AccessToken efetuarLogin(String login, String hashDaSenha) throws ErroLoginException;

	@WebMethod
	void cadastrarResultadoExame(String token, Exame exame) throws TokenNaoExisteException, tokenExpiradoException;

	@WebMethod
	Exame consultarExame(String cpfPaciente, long codigoExame) throws ExameInexistenteParaOPacienteException ;

	@WebMethod
	void excluirExame(String token, long codigoExame) throws TokenNaoExisteException, tokenExpiradoException, ExameInexistenteException;
}
