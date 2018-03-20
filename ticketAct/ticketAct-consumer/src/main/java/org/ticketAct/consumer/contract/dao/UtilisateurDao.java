package org.ticketAct.consumer.contract.dao;

import java.util.List;

import org.ticketAct.model.bean.utilisateur.Utilisateur;

/**
 * Interface DAO du package org.example.demo.ticket.model.bean.utilisateur
 * 
 * @author Oltenos
 *
 */
public interface UtilisateurDao {

	/**
	 * Retourne l'utilisateur ayant l'identifiant en paramètre
	 * @param id identifiant
	 * @return utilisateur
	 */
	Utilisateur getUtilisateur(int id);

	/**
	 * Retourne la liste de tous les utilisateurs
	 * @return liste des utilisateurs
	 */
	List<Utilisateur> getListUtilisateur();

}
