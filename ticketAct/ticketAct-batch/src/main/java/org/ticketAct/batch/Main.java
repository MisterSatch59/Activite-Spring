package org.ticketAct.batch;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.ticketAct.business.contract.manager.ManagerFactory;
import org.ticketAct.model.bean.projet.Projet;
import org.ticketAct.model.bean.projet.Version;
import org.ticketAct.model.exception.NotFoundException;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");

		System.out.println("-- Premier point : Générer le fichier contenant les TicketStatut --");
		FileSave fs = vApplicationContext.getBean("fileSave", FileSave.class);
		fs.saveTicketStatut();

		System.out.println(
				"\n-- Deuxième point : Utilisation des méthodes ProjetManager.getListProjet() et ProjetManager.getProjet(Integer) --");
		System.out.println("\nListe des projets : ");

		ManagerFactory managerFactory = vApplicationContext.getBean("managerFactory", ManagerFactory.class);
		List<Projet> list = managerFactory.getProjetManager().getListProjet();
		for (Projet projet : list) {
			System.out.println(projet.toString());
		}

		System.out.println("\nProjets n°3 : ");
		Projet p = null;
		try {
			p = managerFactory.getProjetManager().getProjet(3);
			System.out.println(p.toString());
		} catch (NotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("\n-- Troisième point : utilisation de ProjetManager.insertVersion(Version) --");

		Version pVersion = new Version();
		pVersion.setProjet(p);
		pVersion.setNumero("1987.0503");
		managerFactory.getProjetManager().insertVersion(pVersion);
		
		
		System.out.println("\n-- FIN DU PROGRAMME --");
	}

}
