package br.ufsc.webservice.consultasmedicas.impl;

import javax.jws.WebService;

import br.ufsc.webservice.consultasmedicas.ConsultasMedicasServer;
import br.ufsc.webservice.consultasmedicas.dominio.Exame;

@WebService(endpointInterface = "br.ufsc.webservice.consultasmedicas.ConsultasMedicasServer")
public class ConsutasMedicasServerImpl implements ConsultasMedicasServer {

	@Override
	public String efetuarLogin(String login, String hashDaSenha) {
		// TODO Auto-generated method stub
		return "funcionando";
	}

	@Override
	public boolean cadastrarResultadoExame(String token, long cpf, Exame exame) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Exame consultarExame(long cpf, long codigoExame) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float excluirExame(String token, long codigoExame) {
		// TODO Auto-generated method stub
		return 0;
	}

}
