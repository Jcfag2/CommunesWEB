package fr.gtm.communes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="departments")
@NamedQueries({
	@NamedQuery(name="Departement.all", query = "SELECT d FROM Departement d")
})
public class Departement {
	@Id
	private long id;
	@Column(name="name")
	private String nom;
	@ManyToOne
	@JoinColumn(name="region_code")
	private Region region;
	@Column(name="code")
	private String numDep;
	
	public String getNom() {
		return nom;
	}
	public Region getRegion() {
		return region;
	}
	@Override
	public String toString() {
		return numDep + " " + nom;
	}

	
	
}
