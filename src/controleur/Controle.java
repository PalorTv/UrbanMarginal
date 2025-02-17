package controleur;

import outils.connexion.AsyncResponse;
import outils.connexion.ClientSocket;
import outils.connexion.Connection;
import outils.connexion.ServeurSocket;
import vue.Arene;
import vue.ChoixJoueur;
import vue.EntreeJeu;

/**
 * Contrôleur et point d'entrée de l'applicaton 
 *
 */
public class Controle implements AsyncResponse {
	
	/**
	 * N° du port d'écoute du serveur
	 */
	private static final int PORT = 6666;
	
	/**
	 * frame Arene
	 */
	private Arene frmArene ;
	
	/**
	 * frame EntreeJeu
	 */
	private EntreeJeu frmEntreeJeu ;

	/**
	 * frame ChoixJoueur
	 */
	private ChoixJoueur frmChoixJoueur ;
	
	/**
	 * type du jeu : client ou serveur
	 */
	private String typeJeu;
	
	/**
	 * Méthode de démarrage
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		new Controle();
	}
	
	/**
	 * Méthode de démarrage
@@ -23,8 +48,45 @@ public static void main(String[] args) {
	 * Constructeur
	 */
	private Controle() {
		this.frmEntreeJeu = new EntreeJeu(this);
		this.frmEntreeJeu.setVisible(true);
	}	
	
	/**
	 * Demande provenant de la vue EntreeJeu
	 * @param info information à traiter
	 */
	public void evenementEntreeJeu(String info) {
		if (info.equals("serveur")) {
			this.typeJeu = "serveur";
			new ServeurSocket(this, PORT);
			frmEntreeJeu.dispose();
			this.frmArene = new Arene();
			this.frmArene.setVisible(true);
		} else {
			this.typeJeu = "client";
			new ClientSocket(this, info, PORT);
		}
	}

	@Override
	public void reception(Connection connection, String ordre, Object info) {
		switch(ordre) {
		case "connexion" :
				if (this.typeJeu.equals("client")) {
						this.frmEntreeJeu.dispose();
						this.frmChoixJoueur = new ChoixJoueur();
						this.frmArene = new Arene();
						this.frmChoixJoueur.setVisible(true);
				}
				break;
		case "reception" :
				break;
		case "deconnexion" :
				break;
		
		}		
	}

}
