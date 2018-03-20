package org.ticketAct.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.ticketAct.model.bean.ticket.TicketStatut;

/**
 * RowMapper du Bean TicketStatut
 * 
 * @author Oltenos
 *
 */
public class TicketStatutRM implements RowMapper<TicketStatut>{
	
	public TicketStatut mapRow(ResultSet pRS, int pRowNum) throws SQLException {
        TicketStatut vTicketStatut = new TicketStatut(pRS.getInt("id"));
        vTicketStatut.setLibelle(pRS.getString("libelle"));
        
        return vTicketStatut;
    }
}
