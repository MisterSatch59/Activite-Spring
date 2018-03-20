package org.ticketAct.business.impl.manager;

import java.util.List;

import javax.inject.Named;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.ticketAct.business.contract.manager.ProjetManager;
import org.ticketAct.model.bean.projet.Projet;
import org.ticketAct.model.bean.projet.Version;
import org.ticketAct.model.exception.NotFoundException;

@Named("projetManager")
public class ProjetManagerImpl extends AbstractManagerImpl implements ProjetManager {

	@Override
	public Projet getProjet(Integer pId) throws NotFoundException {

		Projet vProjet = this.getDaoFactory().getProjetDao().getProjet(pId);

		if (vProjet == null) {
			throw new NotFoundException();
		}

		return vProjet;
	}

	@Override
	public List<Projet> getListProjet() {
		return this.getDaoFactory().getProjetDao().getListProjet();
	}

	@Override
	public void insertVersion(Version pVersion) {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		TransactionStatus vTransactionStatus = this.getPlatformTransactionManager().getTransaction(definition);
		try {
			this.getDaoFactory().getProjetDao().insertVersion(pVersion);
			TransactionStatus vTScommit = vTransactionStatus;
			vTransactionStatus = null;
			this.getPlatformTransactionManager().commit(vTScommit);
		} finally {
			if (vTransactionStatus != null) {
				this.getPlatformTransactionManager().rollback(vTransactionStatus);
			}
		}
	}

}
