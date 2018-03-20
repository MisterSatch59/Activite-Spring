package org.ticketAct.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.ticketAct.business.contract.manager.TicketManager;
import org.ticketAct.model.bean.projet.Projet;
import org.ticketAct.model.bean.ticket.Bug;
import org.ticketAct.model.bean.ticket.Commentaire;
import org.ticketAct.model.bean.ticket.Evolution;
import org.ticketAct.model.bean.ticket.Ticket;
import org.ticketAct.model.bean.ticket.TicketStatut;
import org.ticketAct.model.bean.utilisateur.Utilisateur;
import org.ticketAct.model.exception.NotFoundException;

import recherche.ticket.RechercheTicket;

@Named("ticketManager")
public class TicketManagerImpl extends AbstractManagerImpl implements TicketManager {

	@Override
	public void changerStatut(Ticket pTicket, TicketStatut pNewStatut, Utilisateur pUtilisateur,
			Commentaire pCommentaire) {

		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		TransactionStatus vTransactionStatus = this.getPlatformTransactionManager().getTransaction(definition);
		try {
			pTicket.setStatut(pNewStatut);
			getDaoFactory().getTicketDao().updateTicket(pTicket);
			// Ajout de la ligne d'historique + commentaire ...
			TransactionStatus vTScommit = vTransactionStatus;
			vTransactionStatus = null;
			this.getPlatformTransactionManager().commit(vTScommit);
		} finally {
			if (vTransactionStatus != null) {
				this.getPlatformTransactionManager().rollback(vTransactionStatus);
			}
		}
	}

	@Override
	public Ticket getTicket(Long pNumero) throws NotFoundException {
		// Je n'ai pas encore codé la DAO
		// Je mets juste un code temporaire pour commencer le cours...
		if (pNumero < 1L) {
			throw new NotFoundException("Ticket non trouvé : numero=" + pNumero);
		}
		Evolution vEvolution = new Evolution(pNumero);
		vEvolution.setPriorite(10);
		return vEvolution;
	}

	@Override
	public List<Ticket> getListTicket(RechercheTicket pRechercheTicket) {
		// Je n'ai pas encore codé la DAO
		// Je mets juste un code temporaire pour commencer le cours...
		List<Ticket> vList = new ArrayList<>();
		if (pRechercheTicket.getProjetId() != null) {
			Projet vProjet = new Projet(pRechercheTicket.getProjetId());
			for (int vI = 0; vI < 4; vI++) {
				Ticket vTicket = new Bug((long) pRechercheTicket.getProjetId() * 10 + vI);
				vTicket.setProjet(vProjet);
				vList.add(vTicket);
			}
		} else {
			for (int vI = 0; vI < 9; vI++) {
				Ticket vTicket = new Evolution((long) vI);
				vList.add(vTicket);
			}
		}
		return vList;
	}

	@Override
	public int getCountTicket(RechercheTicket pRechercheTicket) {
		// Je n'ai pas encore codé la DAO
		// Je mets juste un code temporaire pour commencer le cours...
		return 42;
	}

	@Override
	public List<TicketStatut> getListTicketStatut() {
		return this.getDaoFactory().getTicketDao().getListTicketStatut();
	}

}
