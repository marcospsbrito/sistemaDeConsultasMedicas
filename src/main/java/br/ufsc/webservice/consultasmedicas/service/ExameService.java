package br.ufsc.webservice.consultasmedicas.service;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufsc.webservice.consultasmedicas.dominio.Exame;
import br.ufsc.webservice.consultasmedicas.dominio.ItemExame;
import br.ufsc.webservice.consultasmedicas.dominio.dao.ExameDao;
import br.ufsc.webservice.consultasmedicas.exceptions.ExameInexistenteException;
import br.ufsc.webservice.consultasmedicas.exceptions.ExameInexistenteParaOPacienteException;

@Named
public class ExameService{

	@Inject
    private ExameDao exameDao;

	public void cadastrarExame(Exame exame) {
		for (ItemExame item : exame.getItens()) {
			item.setExame(exame);
		}
		exameDao.salvar(exame);
	}

	public Exame consultarExameDoPaciente(String cpfPaciente, long codigoExame) throws ExameInexistenteParaOPacienteException {
		return exameDao.consultarExameDoPaciente(cpfPaciente, codigoExame);
	}

	public void excluir(long codigoExame) throws ExameInexistenteException {
		exameDao.deletarExame(codigoExame);
	}

    
}
