package fr.gtm.communes.services;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import fr.gtm.communes.dao.CommuneDAO;
import fr.gtm.communes.entities.Commune;

public class CommuneServices {
	private CommuneDAO dao;

	public CommuneServices(EntityManagerFactory emf) {
		dao = new CommuneDAO(emf);
	}
	
	public List<Commune> getCommunesByCodePostal(String codePostal){
		return dao.getCommunesByCodePostal(codePostal);
	}
	
	public List<Commune> getCommunesByNom(String nom){
		return dao.getCommunesByNom(nom);
	}
	
	
	
	
	
}
