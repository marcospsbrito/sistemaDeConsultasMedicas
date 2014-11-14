package br.ufsc.webservice.consultasmedicas.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import br.ufsc.webservice.consultasmedicas.ConsultasMedicasServer;
import br.ufsc.webservice.consultasmedicas.exceptions.ErroLoginException;
import br.ufsc.webservice.consultasmedicas.service.AccessToken;

public class ExameMedicoClient {

	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("http://localhost:8080/exame-web-service/ExamesMedicos?wsdl");

			// 1st argument service URI, refer to wsdl document above
			// 2nd argument is service name, refer to wsdl document above
			QName qname = new QName("http://impl.consultasmedicas.webservice.ufsc.br/", "ExamesMedicos");

			Service service = Service.create(url, qname);

			ConsultasMedicasServer server = service.getPort(ConsultasMedicasServer.class);

			AccessToken accessToken = server.efetuarLogin("marcos", "senha");
		} catch (ErroLoginException e) {
			System.out.println("Falha ao efetuar Login.");
		} catch (MalformedURLException e1) {
			System.out.println("Erro inexperado.");
		}
	}
}
