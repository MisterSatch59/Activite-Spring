package org.ticketAct.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.ticketAct.model.bean.utilisateur.Utilisateur;

/**
 * RowMapper du Bean Utilisateur
 * 
 * @author Oltenos
 *
 */
public class UtilisateurRM implements RowMapper<Utilisateur> {

	@Override
	public Utilisateur mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Utilisateur vUtilisateur = new Utilisateur();
		vUtilisateur.setId(pRS.getInt("id"));
		vUtilisateur.setNom(pRS.getString("nom"));
		vUtilisateur.setPrenom(pRS.getString("prenom"));

		return vUtilisateur;
	}

}
