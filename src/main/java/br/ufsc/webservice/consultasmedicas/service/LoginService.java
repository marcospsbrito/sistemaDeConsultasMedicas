/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.ufsc.webservice.consultasmedicas.service;

import java.util.Calendar;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufsc.webservice.consultasmedicas.dominio.AccessToken;
import br.ufsc.webservice.consultasmedicas.dominio.Medico;
import br.ufsc.webservice.consultasmedicas.dominio.ProfissionalSaude;
import br.ufsc.webservice.consultasmedicas.dominio.dao.LoginDao;
import br.ufsc.webservice.consultasmedicas.exceptions.ErroLoginException;
import br.ufsc.webservice.consultasmedicas.exceptions.TokenNaoExisteException;
import br.ufsc.webservice.consultasmedicas.exceptions.tokenExpiradoException;

@Named
public class LoginService{

	@Inject
    private LoginDao loginDao;

	public AccessToken efetuarLogin(String login, String hashDaSenha) throws ErroLoginException {
		ProfissionalSaude profissionalLogado;
		try{
			profissionalLogado = loginDao.fazerLogin(login, hashDaSenha);
		}catch(ErroLoginException e){
			criarMedicoDefault(login, hashDaSenha);
			profissionalLogado = loginDao.fazerLogin(login, hashDaSenha);
		}
		Calendar dataAtual = Calendar.getInstance();
		dataAtual.add(Calendar.MINUTE, 30);
		AccessToken token = new AccessToken(Math.random()*10000000000l+"ex", dataAtual.getTime(),profissionalLogado.getHabilitacao());
		loginDao.salvar(token);
		return token;
		
	}

	private void criarMedicoDefault(String login, String hashDaSenha) {
		Medico medico = new Medico();
		medico.setCRM(123);
		medico.setLogin(login);
		medico.setHashSenha(hashDaSenha);
		medico.setNome("Marcos Brito");
		loginDao.salvar(medico);
		
	}

	public void validaToken(String token) throws TokenNaoExisteException, tokenExpiradoException {
		AccessToken toAccessToken = loginDao.buscarToken(token);
		if(toAccessToken.getDataExpiracao().before(Calendar.getInstance().getTime())){
			throw new tokenExpiradoException();
		}
	}
    
}
