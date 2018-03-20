package org.ticketAct.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

/**
 * 
 * Superclasse des DAO
 * 
 * @author Oltenos
 *
 */
public abstract class AbstractDaoImpl {

	/**
	 * DataSource d'accés à la base de données
	 */
	@Inject
	@Named("dataSourceTicket")
	private DataSource dataSource;

	/**
	 * getters de la DataSource
	 * 
	 * @return DataSource
	 */
	protected DataSource getDataSource() {
		return dataSource;
	}
}
