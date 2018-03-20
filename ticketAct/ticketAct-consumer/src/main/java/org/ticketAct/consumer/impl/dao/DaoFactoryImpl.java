package org.ticketAct.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;

import org.ticketAct.consumer.contract.dao.DaoFactory;
import org.ticketAct.consumer.contract.dao.ProjetDao;
import org.ticketAct.consumer.contract.dao.TicketDao;
import org.ticketAct.consumer.contract.dao.UtilisateurDao;

@Named ("daoFactory")
public class DaoFactoryImpl implements DaoFactory{
	
	@Inject
	private TicketDao ticketDao;
	@Inject
	private UtilisateurDao utilisateurDao;
	@Inject
	private ProjetDao projetDao;

	@Override
	public TicketDao getTicketDao() {
		return ticketDao;
	}

	@Override
	public UtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}
	
	@Override
	public ProjetDao getProjetDao() {
		return projetDao;
	}

}
