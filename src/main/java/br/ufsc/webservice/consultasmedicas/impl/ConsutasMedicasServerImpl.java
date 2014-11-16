package br.ufsc.webservice.consultasmedicas.impl;

import javax.inject.Inject;
import javax.jws.WebService;

import br.ufsc.webservice.consultasmedicas.ConsultasMedicasServer;
import br.ufsc.webservice.consultasmedicas.dominio.AccessToken;
import br.ufsc.webservice.consultasmedicas.dominio.Exame;
import br.ufsc.webservice.consultasmedicas.exceptions.ErroLoginException;
import br.ufsc.webservice.consultasmedicas.exceptions.ExameInexistenteException;
import br.ufsc.webservice.consultasmedicas.exceptions.ExameInexistenteParaOPacienteException;
import br.ufsc.webservice.consultasmedicas.exceptions.TokenNaoExisteException;
import br.ufsc.webservice.consultasmedicas.exceptions.tokenExpiradoException;
import br.ufsc.webservice.consultasmedicas.service.ExameService;
import br.ufsc.webservice.consultasmedicas.service.LoginService;

@WebService(endpointInterface = "br.ufsc.webservice.consultasmedicas.ConsultasMedicasServer", name="ExamesMedicos", serviceName="ExamesMedicos")
public class ConsutasMedicasServerImpl implements ConsultasMedicasServer {

	@Inject
	private LoginService loginService;
	
	@Inject
	private ExameService exameService;
	
	public AccessToken efetuarLogin(String login, String hashDaSenha) throws ErroLoginException {
		return loginService.efetuarLogin(login,hashDaSenha);
	}

	public void cadastrarResultadoExame(String token, Exame exame) throws TokenNaoExisteException, tokenExpiradoException {
		loginService.validaToken(token);
		exameService.cadastrarExame(exame);
	}

	public Exame consultarExame(String cpfPaciente, long codigoExame) throws ExameInexistenteParaOPacienteException {
		return exameService.consultarExameDoPaciente(cpfPaciente, codigoExame);
	}

	public void excluirExame(String token, long codigoExame) throws TokenNaoExisteException, tokenExpiradoException, ExameInexistenteException {
		loginService.validaToken(token);
		exameService.excluir(codigoExame);
	}
}
