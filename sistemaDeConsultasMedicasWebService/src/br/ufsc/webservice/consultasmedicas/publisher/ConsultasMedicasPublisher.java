package br.ufsc.webservice.consultasmedicas.publisher;

import javax.xml.ws.Endpoint;

import br.ufsc.webservice.consultasmedicas.impl.ConsutasMedicasServerImpl;

public class ConsultasMedicasPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://127.0.0.1:9876/consulta",new ConsutasMedicasServerImpl());
	}

}
