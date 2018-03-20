package org.ticketAct.consumer.contract.dao;

import java.util.List;

import org.ticketAct.model.bean.projet.Projet;
import org.ticketAct.model.bean.projet.Version;
import org.ticketAct.model.exception.FunctionalException;


/**
 * Interface DAO du package org.example.demo.ticket.model.bean.projet
 * 
 * @author Oltenos
 *
 */
public interface ProjetDao {

	/**
	 * Retourne le projet correspondant à l'identifiant
	 * @param id identifiant
	 * @return projet correspondant
	 */
	Projet getProjet(int id);

	/**
	 * Retorune la liste de tous les projets
	 * @return liste des projets
	 */
	List<Projet> getListProjet();

	/**
	 * Insérer une nouvelle version de projet
	 * @param pVersion version à ajouter
	 * @throws FunctionalException Exception en cas de paramètres invalide (null, vide ou projet inexistant)
	 */
	void insertVersion(Version pVersion);

}
