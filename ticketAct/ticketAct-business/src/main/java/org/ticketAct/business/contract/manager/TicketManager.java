package org.ticketAct.business.contract.manager;

import java.util.List;

import org.ticketAct.model.bean.ticket.Commentaire;
import org.ticketAct.model.bean.ticket.Ticket;
import org.ticketAct.model.bean.ticket.TicketStatut;
import org.ticketAct.model.bean.utilisateur.Utilisateur;
import org.ticketAct.model.exception.NotFoundException;

import recherche.ticket.RechercheTicket;

public interface TicketManager {

	
	void changerStatut(Ticket pTicket, TicketStatut pNewStatut, Utilisateur pUtilisateur, Commentaire pCommentaire);
	/**
	 * méthode non implémentée
	 * @param pNumero
	 * @return
	 * @throws NotFoundException
	 */
	Ticket getTicket(Long pNumero) throws NotFoundException;

	/**
	 * méthode non implémentée
	 * @param pRechercheTicket
	 * @return
	 */
	List<Ticket> getListTicket(RechercheTicket pRechercheTicket);

	/**
	 * méthode non implémentée
	 * @param pRechercheTicket
	 * @return
	 */
	int getCountTicket(RechercheTicket pRechercheTicket);

	/**
	 * Retourne la liste de tous les TicketStatut
	 * @return
	 */
	List<TicketStatut> getListTicketStatut();

}
