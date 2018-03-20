package org.ticketAct.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.RowMapper;
import org.ticketAct.consumer.contract.dao.DaoFactory;
import org.ticketAct.model.bean.projet.Projet;
import org.ticketAct.model.bean.utilisateur.Utilisateur;

/**
 * RowMapper du Bean Projet
 * 
 * @author Oltenos
 *
 */
@Named
public class ProjetRM implements RowMapper<Projet>{
	
	@Inject
	DaoFactory daoFactory;

	@Override
	public Projet mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Projet vProjet = new Projet();
		vProjet.setId(pRS.getInt("id"));
		vProjet.setNom(pRS.getString("nom"));
		vProjet.setDateCreation(pRS.getDate("date_creation"));
		vProjet.setCloture(pRS.getBoolean("cloture"));
		Utilisateur responsable = daoFactory.getUtilisateurDao().getUtilisateur(pRS.getInt("responsable_id"));
		vProjet.setResponsable(responsable);
		
		return vProjet;
	}

}
