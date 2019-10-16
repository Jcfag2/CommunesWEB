package fr.gtm.communes;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.gtm.communes.Constantes;
import fr.gtm.communes.dao.CommuneDAO;
import fr.gtm.communes.entities.Departement;

public class MainCommunes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constantes.UNIT_NAME);
		CommuneDAO dao = new CommuneDAO(emf);
		
//		List<Commune> communes = dao.getCommunesByCodePostal("972");
//		communes.forEach(System.out::println);
		List<Departement> departements = dao.getAllDepartement();
		departements.forEach(System.out::println);
		emf.close();
	}

}