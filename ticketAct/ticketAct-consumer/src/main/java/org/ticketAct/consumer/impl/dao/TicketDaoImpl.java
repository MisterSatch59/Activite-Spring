package org.ticketAct.consumer.impl.dao;

import java.sql.Types;
import java.util.List;
import javax.inject.Named;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.ticketAct.consumer.contract.dao.TicketDao;
import org.ticketAct.consumer.impl.rowmapper.TicketStatutRM;
import org.ticketAct.model.bean.ticket.Ticket;
import org.ticketAct.model.bean.ticket.TicketStatut;

import recherche.ticket.RechercheTicket;

@Named("ticketDao")
public class TicketDaoImpl extends AbstractDaoImpl implements TicketDao {

	@Override
	public int getCountTicket(RechercheTicket pRechercheTicket) {

		MapSqlParameterSource vParams = new MapSqlParameterSource();

		StringBuilder vSQL = new StringBuilder("SELECT COUNT(*) FROM ticket WHERE 1=1");

		if (pRechercheTicket != null) {
			if (pRechercheTicket.getAuteurId() != null) {
				vSQL.append(" AND auteur_id = :auteur_id");
				vParams.addValue("auteur_id", pRechercheTicket.getAuteurId());
			}
			if (pRechercheTicket.getProjetId() != null) {
				vSQL.append(" AND projet_id = :projet_id");
				vParams.addValue("projet_id", pRechercheTicket.getProjetId());
			}
		}

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		int vNbrTicket = vJdbcTemplate.queryForObject(vSQL.toString(), vParams, Integer.class);

		return vNbrTicket;
	}

	@Override
	public List<TicketStatut> getListTicketStatut() {
		String vSQL = "SELECT * FROM public.statut";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		RowMapper<TicketStatut> vRowMapper = new TicketStatutRM();

		List<TicketStatut> vListStatut = vJdbcTemplate.query(vSQL, vRowMapper);

		return vListStatut;
	}

	@Override
	public void updateTicketStatut(TicketStatut pTicketStatut) {
		String vSQL = "UPDATE statut SET libelle = ? WHERE id = ?";

		Object[] vParams = { new SqlParameterValue(Types.INTEGER, pTicketStatut.getId()),
				new SqlParameterValue(Types.VARCHAR, pTicketStatut.getLibelle()), };

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, vParams);
	}

	@Override
	public void insertTicketStatut(TicketStatut pTicketStatut) {
		String vSQL = "INSERT INTO statut (id, libelle) VALUES (:id, :libelle)";
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

		BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pTicketStatut);
		vParams.registerSqlType("id", Types.INTEGER);
		vParams.registerSqlType("libelle", Types.VARCHAR);

		try {
			vJdbcTemplate.update(vSQL, vParams);
		} catch (DuplicateKeyException vEx) {
			System.out.println("Le TicketStatut existe déjà ! id=" + pTicketStatut.getId());
			vEx.printStackTrace();
		}
	}

	@Override
	public void updateTicket(Ticket pTicket) {

	}
}
