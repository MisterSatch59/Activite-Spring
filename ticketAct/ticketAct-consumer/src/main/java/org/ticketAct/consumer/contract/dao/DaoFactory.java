package org.ticketAct.consumer.contract.dao;

/**
 * DaoFactory
 * 
 * @author Oltenos
 *
 */
public interface DaoFactory {

	/**
	 * Retourne le TicketDao
	 * @return TicketDao
	 */
	TicketDao getTicketDao();

	/**
	 * Retourne le UtilisateurDao
	 * @return UtilisateurDao
	 */
	UtilisateurDao getUtilisateurDao();

	/**
	 * Retourne le ProjetDao
	 * @return ProjetDao
	 */
	ProjetDao getProjetDao();

}
