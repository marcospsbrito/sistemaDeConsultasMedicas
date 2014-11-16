package br.ufsc.webservice.consultasmedicas.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import br.ufsc.webservice.consultasmedicas.ConsultasMedicasServer;
import br.ufsc.webservice.consultasmedicas.dominio.AccessToken;
import br.ufsc.webservice.consultasmedicas.dominio.Estabelecimento;
import br.ufsc.webservice.consultasmedicas.dominio.Exame;
import br.ufsc.webservice.consultasmedicas.dominio.ItemExame;
import br.ufsc.webservice.consultasmedicas.dominio.Medico;
import br.ufsc.webservice.consultasmedicas.dominio.Paciente;
import br.ufsc.webservice.consultasmedicas.dominio.ProfissionalSaude;
import br.ufsc.webservice.consultasmedicas.dominio.TipoItemExame;
import br.ufsc.webservice.consultasmedicas.exceptions.ErroLoginException;
import br.ufsc.webservice.consultasmedicas.exceptions.ExameInexistenteException;
import br.ufsc.webservice.consultasmedicas.exceptions.ExameInexistenteParaOPacienteException;
import br.ufsc.webservice.consultasmedicas.exceptions.TokenNaoExisteException;
import br.ufsc.webservice.consultasmedicas.exceptions.tokenExpiradoException;

public class ExameMedicoClient {

	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("http://localhost:8080/exame-web-service/ExamesMedicos?wsdl");
			QName qname = new QName("http://impl.consultasmedicas.webservice.ufsc.br/", "ExamesMedicos");
			Service service = Service.create(url, qname);
			ConsultasMedicasServer server = service.getPort(ConsultasMedicasServer.class);
			AccessToken accessToken = server.efetuarLogin("marcos", "senha");
			Exame exame = criarExameTeste();
			server.cadastrarResultadoExame(accessToken.getToken(), exame);
			exame = server.consultarExame("123.123.123-12", 2l);
			server.excluirExame(accessToken.getToken(), exame.getCodigoExame());
		} catch (ErroLoginException e) {
			System.out.println("Falha ao efetuar Login.");
		} catch (MalformedURLException e1) {
			System.out.println("Erro inexperado.");
		} catch (TokenNaoExisteException e) {
			System.out.println("O token informado não existe.");
		} catch (tokenExpiradoException e) {
			System.out.println("O token informado expirou, Efetue login novamente.");
		} catch (ExameInexistenteParaOPacienteException e) {
			System.out.println("Não foi encontrado exame para o codigo e paciente informado.");
		} catch (ExameInexistenteException e) {
			System.out.println("O exame pesquisado não existe para o paciente informado.");
		}
	}

	private static Exame criarExameTeste() {
		Exame exame = new Exame();
		exame.setDataExame(Calendar.getInstance().getTime());
		exame.setEstabelecimento(criarEstabelecimento());
		exame.setItens(criarItens(exame,10));
		exame.setMedicoSolicitante(criarMedicoSolicitante());
		exame.setPaciente(criarPaciente());
		exame.setProfissionalResponsavel(criarProfissionalResponsavel());
		return exame;
	}

	private static ProfissionalSaude criarProfissionalResponsavel() {
		ProfissionalSaude profissionalSaude = new ProfissionalSaude();
		profissionalSaude.setHashSenha("123123");
		profissionalSaude.setLogin("profissional1");
		profissionalSaude.setNome("Profissional 1");
		return profissionalSaude;
	}

	private static Paciente criarPaciente() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.123.123-12");
		paciente.setIdade(20);
		paciente.setNome("Bianca");
		paciente.setSobrenome("Darck");
		return paciente;
	}

	private static Medico criarMedicoSolicitante() {
		Medico medico = new Medico();
		medico.setCRM(2);
		medico.setHashSenha("123123");
		medico.setLogin("medico1");
		medico.setNome("Medico 1");
		return medico;
	}

	private static List<ItemExame> criarItens(Exame exame, int quantidade) {
		ItemExame itemExame;
		List<ItemExame> itens = new ArrayList<ItemExame>();
		for (int indice = 1; indice<quantidade; indice++) {
			itemExame = new ItemExame();
			itemExame.setResultado("Tudo tranquilo");
			itemExame.setTipoItem(TipoItemExame.OUTROS);
			itemExame.setExame(exame);
			itemExame.setValorReferencia("Valor ref: Tudo tranquilo.");
			itens.add(itemExame);
		}
		return itens;
	}

	private static Estabelecimento criarEstabelecimento() {
		Estabelecimento estabelecimento = new Estabelecimento();
		estabelecimento.setNome("Clinica 1");
		estabelecimento.setTelefone("(48) 2222-2222");
		return estabelecimento;
	}
}
