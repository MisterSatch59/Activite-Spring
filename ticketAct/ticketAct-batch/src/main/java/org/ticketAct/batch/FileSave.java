package org.ticketAct.batch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.ticketAct.business.contract.manager.ManagerFactory;
import org.ticketAct.model.bean.ticket.TicketStatut;

@Named
public class FileSave {
	@Inject
	private ManagerFactory managerFactory;
	
	private String adresse ="test.txt";
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void saveTicketStatut() {
		List<TicketStatut> list = managerFactory.getTicketManager().getListTicketStatut();

		String enter = System.getProperty("line.separator");
		String enr = "";
		for (TicketStatut ticketStatut : list) {
			enr +=ticketStatut.toString();
			enr += enter;
		}
		
		FileWriter fw;
		BufferedWriter output = null;
		try {
			fw = new FileWriter(adresse, false);
			output = new BufferedWriter(fw);
			output.write(enr);
		} catch (IOException ioe) {
			System.out.println("Erreur lors de l'enregistrement du fichier.");
		} finally {
			try {
				output.flush();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
