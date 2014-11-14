package br.ufsc.webservice.consultasmedicas.impl;

import javax.inject.Inject;
import javax.jws.WebService;

import br.ufsc.webservice.consultasmedicas.ConsultasMedicasServer;
import br.ufsc.webservice.consultasmedicas.dominio.Exame;
import br.ufsc.webservice.consultasmedicas.exceptions.ErroLoginException;
import br.ufsc.webservice.consultasmedicas.service.AccessToken;
import br.ufsc.webservice.consultasmedicas.service.LoginService;

@WebService(endpointInterface = "br.ufsc.webservice.consultasmedicas.ConsultasMedicasServer", name="ExamesMedicos", serviceName="ExamesMedicos")
public class ConsutasMedicasServerImpl implements ConsultasMedicasServer {

	@Inject
	private LoginService loginService;
	
	public AccessToken efetuarLogin(String login, String hashDaSenha) throws ErroLoginException {
		return loginService.efetuarLogin(login,hashDaSenha);
	}

	public boolean cadastrarResultadoExame(String token, long cpf, Exame exame) {
		// TODO Auto-generated method stub
		return true;
	}

	public Exame consultarExame(long cpf, long codigoExame) {
		// TODO Auto-generated method stub
		return null;
	}

	public float excluirExame(String token, long codigoExame) {
		// TODO Auto-generated method stub
		return 0;
	}

}
