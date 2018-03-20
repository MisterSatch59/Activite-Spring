package org.ticketAct.business.impl.manager;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.PlatformTransactionManager;
import org.ticketAct.consumer.contract.dao.DaoFactory;

/**
 * 
 * Superclasse des Manager
 * 
 * @author Oltenos
 *
 */
public abstract class AbstractManagerImpl {
	
	/**
	 * gestionnaire (Manager) de transaction (Spring)
	 */
	@Inject
	@Named("txManagerTicket")
	private PlatformTransactionManager platformTransactionManager;
	public PlatformTransactionManager getPlatformTransactionManager() {
		return platformTransactionManager;
	}
	
	@Inject
	private DaoFactory daoFactory;
	protected DaoFactory getDaoFactory() {
		return daoFactory;
	}
}
