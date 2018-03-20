package org.ticketAct.business.contract.manager;

import java.util.List;

import org.ticketAct.model.bean.projet.Projet;
import org.ticketAct.model.bean.projet.Version;
import org.ticketAct.model.exception.NotFoundException;

public interface ProjetManager {

	/**
	 * Renvoie le projet demandé
	 *
	 * @param pId l'identifiant du projet
	 * @return Le {@link Projet}
	 * @throws NotFoundException Si le projet n'est pas trouvé
	 */
	List<Projet> getListProjet();

	/**
	 * Renvoie la liste des {@link Projet}
	 *
	 * @return List
	 */
	Projet getProjet(Integer pId) throws NotFoundException;

	/**
	 * Ajoute une nouvelle version du projet
	 * 
	 * @param pVersion
	 */
	void insertVersion(Version pVersion);

}
