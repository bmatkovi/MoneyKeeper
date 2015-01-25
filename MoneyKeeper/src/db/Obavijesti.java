package db;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

@Table(name = "Obavijesti")
public class Obavijesti extends Model {

	@Column(name = "idObavijesti")
	public int idObavijesti;

	@Column(name = "datum")
	public String datum;

	@Column(name = "vrijeme")
	public String vrijeme;

	@Column(name = "poruka")
	public String poruka;

	@Column(name = "Korisnik")
	public Korisnik Korisnik;

	public Obavijesti() {
		super();
	}

	public Obavijesti(int idObavijesti, String datum, String vrijeme,
			String poruka, Korisnik Korisnik) {
		super();
		this.idObavijesti = idObavijesti;
		this.datum = datum;
		this.vrijeme = vrijeme;
		this.poruka = poruka;
		this.Korisnik = Korisnik;
	}

	public int getIdObavijesti() {
		return idObavijesti;
	}

	public String getDatum() {
		return datum;
	}

	public String getVrijeme() {
		return vrijeme;
	}

	public String getPoruka() {
		return poruka;
	}

	public Korisnik getKorisnik() {
		return Korisnik;
	}

	public void setIdObavijesti(int idObavijesti) {
		this.idObavijesti = idObavijesti;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public void setVrijeme(String vrijeme) {
		this.vrijeme = vrijeme;
	}

	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}

	public void setKorisnik(Korisnik korisnik) {
		Korisnik = korisnik;
	}
	
	public static List<Obavijesti> getObavijesti(){
		
		return new Select().all().from(Obavijesti.class).execute();
	}

	public static List<Obavijesti> DeleteObavijesti(){
		
		return new Delete().from(Obavijesti.class).execute();
	}


}