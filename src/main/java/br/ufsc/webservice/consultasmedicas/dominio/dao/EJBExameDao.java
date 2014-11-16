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

import br.ufsc.webservice.consultasmedicas.dominio.Exame;
import br.ufsc.webservice.consultasmedicas.exceptions.ExameInexistenteException;
import br.ufsc.webservice.consultasmedicas.exceptions.ExameInexistenteParaOPacienteException;

@Stateless
public class EJBExameDao implements ExameDao {

    @Inject
    private EntityManager entityManager;

	@Override
	public void salvar(Object entity) {
		entityManager.persist(entity);
		entityManager.merge(entity);
	}

	@Override
	public Exame consultarExameDoPaciente(String cpfPaciente, long codigoExame) throws ExameInexistenteParaOPacienteException {
		try {
            Query query = entityManager.createQuery("select u from Exame u where u.codigoExame=:codigoExame and u.paciente.cpf=:cpf");
            query.setParameter("cpf", cpfPaciente);
            query.setParameter("codigoExame", codigoExame);
            return (Exame) query.getSingleResult();
        } catch (NoResultException e) {
            throw new ExameInexistenteParaOPacienteException();
        }
	}

	@Override
	public void deletarExame(long codigoExame) throws ExameInexistenteException {
		try {
			Query query = entityManager.createQuery("delete from ItemExame u where u.exame.codigoExame=:codigoExame");
            query.setParameter("codigoExame", codigoExame);
            query.executeUpdate();
            query = entityManager.createQuery("delete from Exame u where u.codigoExame=:codigoExame");
            query.setParameter("codigoExame", codigoExame);
            query.executeUpdate();
        } catch (NoResultException e) {
            throw new ExameInexistenteException();
        }
	}

}
