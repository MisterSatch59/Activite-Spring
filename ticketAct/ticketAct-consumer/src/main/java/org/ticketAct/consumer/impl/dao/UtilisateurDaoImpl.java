package org.ticketAct.consumer.impl.dao;

import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.ticketAct.consumer.contract.dao.UtilisateurDao;
import org.ticketAct.consumer.impl.rowmapper.UtilisateurRM;
import org.ticketAct.model.bean.utilisateur.Utilisateur;

@Named("utilisateurDao")
public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {

	@Override
	public Utilisateur getUtilisateur(int id) {

		String vSQL = "SELECT * FROM public.utilisateur WHERE id = " + id;

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		RowMapper<Utilisateur> vRowMapper = new UtilisateurRM();

		List<Utilisateur> vListUtilisateur = vJdbcTemplate.query(vSQL, vRowMapper);

		return vListUtilisateur.get(0);
	}

	@Override
	public List<Utilisateur> getListUtilisateur() {
		String vSQL = "SELECT * FROM public.utilisateur";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		RowMapper<Utilisateur> vRowMapper = new UtilisateurRM();

		List<Utilisateur> vListUtilisateur = vJdbcTemplate.query(vSQL, vRowMapper);

		return vListUtilisateur;

	}

}
