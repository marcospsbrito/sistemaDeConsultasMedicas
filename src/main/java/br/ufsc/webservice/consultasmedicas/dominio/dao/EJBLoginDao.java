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
package br.ufsc.webservice.consultasmedicas.dominio.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.ufsc.webservice.consultasmedicas.dominio.AccessToken;
import br.ufsc.webservice.consultasmedicas.dominio.ProfissionalSaude;
import br.ufsc.webservice.consultasmedicas.exceptions.ErroLoginException;
import br.ufsc.webservice.consultasmedicas.exceptions.TokenNaoExisteException;

@Stateless
public class EJBLoginDao implements LoginDao {

    @Inject
    private EntityManager entityManager;

    public ProfissionalSaude fazerLogin(String login,String hashSenha) throws ErroLoginException {
        try {
            Query query = entityManager.createQuery("select u from ProfissionalSaude u where u.login=:login and u.hashSenha=:hashSenha");
            query.setParameter("login", login);
            query.setParameter("hashSenha", hashSenha);
            return (ProfissionalSaude) query.getSingleResult();
        } catch (NoResultException e) {
            throw new ErroLoginException();
        }
    }

	@Override
	public void salvar(Object entity) {
		entityManager.persist(entity);
		entityManager.merge(entity);
	}

	@Override
	public AccessToken buscarToken(String token) throws TokenNaoExisteException {
		try {
            Query query = entityManager.createQuery("select u from AccessToken u where u.token = :token");
            query.setParameter("token", token);
            return (AccessToken) query.getSingleResult();
        } catch (NoResultException e) {
            throw new TokenNaoExisteException();
        }
	}

}
