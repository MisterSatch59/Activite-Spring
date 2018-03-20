package org.ticketAct.business.impl.manager;

import javax.inject.Inject;
import javax.inject.Named;

import org.ticketAct.business.contract.manager.ManagerFactory;
import org.ticketAct.business.contract.manager.ProjetManager;
import org.ticketAct.business.contract.manager.TicketManager;

/**
 * Factory des Manager
 * 
 * @author Oltenos
 *
 */
@Named ("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

	@Inject
	private ProjetManager projetManager;
	@Inject
	private TicketManager ticketManager;

	@Override
	public ProjetManager getProjetManager() {
		return this.projetManager;
	}
	
	@Override
	public TicketManager getTicketManager() {
		return this.ticketManager;
	}

}
