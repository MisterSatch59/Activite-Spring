package org.ticketAct.consumer.contract.dao;

import java.util.List;

import org.ticketAct.model.bean.ticket.Ticket;
import org.ticketAct.model.bean.ticket.TicketStatut;

import recherche.ticket.RechercheTicket;

/**
 * Interface DAO du package org.example.demo.ticket.model.bean.ticket
 * 
 * @author Oltenos
 *
 */
public interface TicketDao {

	/**
	 * Retourne le nombre de ticket correspondant au critére de recherche
	 * @param pRechercheTicket critére de recherche
	 * @return nombre de ticket correspondant
	 */
	int getCountTicket(RechercheTicket pRechercheTicket);

	/**
	 * Retourne la liste de tous les TicketStatut
	 * @return liste des TicketStatut
	 */
	List<TicketStatut> getListTicketStatut();

	/**
	 * Modification d'un statut
	 * @param pTicketStatut statut modifié
	 */
	void updateTicketStatut(TicketStatut pTicketStatut);

	/**
	 * Insérer un nouveau statut
	 * @param pTicketStatut statut à insérer
	 */
	void insertTicketStatut(TicketStatut pTicketStatut);

	/**
	 * Modification d'un Ticket (Rq : méthode non implémentée)
	 * @param pTicket Ticket modifié
	 */
	void updateTicket(Ticket pTicket);

}
