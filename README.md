# Activite-Spring
Activité de fin du cours Spring d'OpenClassrooms

Bonjour,

Premièrement merci d'avance pour la correction!

Ensuite voici quelques éléments particuliers : 

- J'ai recréé entièrement le projet Maven, l'architecture et les dépendances peuvent donc être légérement
différente du cours.
- J'ai créer ma propre class Main dans le batch permettant le test des fonctionnalités demandées

Pour effectuer les tests il faut : 
1 Décompresser l'archive
2 Créer et initialiser la base de données (si pas déjà fait ;-)) j'ai remis pour cela les
	fichier .sql fournis à mon dossier
3 Dans le fichier Activité-Spring/ticketAct/ticketAct-batch/src/data/conf/db-ticket.properties
	modifier le username et password si nécéssaire (selon votre configuration utilisateur)
	ou créer l'utilisateur "adm_ticket" avec le password "ticket" pour la base de données dans Postgres
4 Dans le fichier Activité-Spring/ticketAct/ticketAct-batch/src/data/conf/config.properties
	entrer l'adresse d'enregistrement souhaitée du fichier contenant les TicketStatut
	et si vous le souhaitez le nom du fichier (actuellement D:/ListeDesTicketStatut.txt)
5 Lancer le Main de batch (aucun travail demandé sur webapp) :

Avec Eclipse (je ne connais que Eclipse):
	- Importer dans Eclipse le projet ticketAct
	- Lancer la classe Main en pensant à bien configurer la JVM :
		Run Configurations... > Arguments dans la case "VM arguments:" écrire :
			-DTICKET_HOME="XXX" ou XXX est le chemin du dossier data de ticketAct-batch
			XXX doit donc se terminer par : "\ticketAct\ticketAct-batch\src\data"

Vous pouvez alors vérifier le travail effectuer :
- Premier point : vérifier à l'emplacement spécifié la bonne génération du fichier
- Deuxième point : Les résultats des méthodes ProjetManager.getProjet(Integer) et ProjetManager.getListProjet() sont afficher
	dans la console
- Troisième point : Vérifier dans votre base de donnés PostgreSQL de l'ajout d'une version (1987.0503) au projet 3

Merci!