package org.ticketAct.consumer.impl.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.ticketAct.consumer.contract.dao.ProjetDao;
import org.ticketAct.model.bean.projet.Projet;
import org.ticketAct.model.bean.projet.Version;

@Named("projetDao")
public class ProjetDaoImpl extends AbstractDaoImpl implements ProjetDao {

	@Inject
	RowMapper<Projet> projetRM;

	@Override
	public Projet getProjet(int id) {

		String vSQL = "SELECT * FROM public.projet WHERE id = " + id;

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		List<Projet> vListProjet = vJdbcTemplate.query(vSQL, projetRM);

		if (vListProjet.isEmpty()) {
			return null;
		} else {
			return vListProjet.get(0);
		}
	}

	@Override
	public List<Projet> getListProjet() {
		String vSQL = "SELECT * FROM public.projet";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		List<Projet> vListProjet = vJdbcTemplate.query(vSQL, projetRM);

		return vListProjet;

	}

	@Override
	public void insertVersion(Version pVersion) {
		if (pVersion != null && pVersion.getNumero() != null && pVersion.getProjet() != null) {
			if (getProjet(pVersion.getProjet().getId()) != null && !pVersion.getNumero().isEmpty()) {
				int id = pVersion.getProjet().getId();
				String numero = pVersion.getNumero();
				String vSQL = "INSERT INTO version (projet_id, numero) VALUES (" + id + "," + numero + ")";

				JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

				vJdbcTemplate.execute(vSQL);
			}
		}
	}
}
