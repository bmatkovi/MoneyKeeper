package db;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

@Table(name = "Transakcija")
public class Transakcija extends Model {

	@Column(name = "idTranskacije")
	public int idTranskacije;

	@Column(name = "opis")
	public String opis;

	@Column(name = "datum")
	public String datum;

	@Column(name = "vrijeme")
	public String vrijeme;

	@Column(name = "iznos")
	public int iznos;

	@Column(name = "vrsta")
	public int vrsta;

	@Column(name = "Korisnik")
	public Korisnik Korisnik;

	@Column(name = "Kategorija")
	public Kategorija Kategorija;

	@Column(name = "Racun")
	public Racun Racun;

	public Transakcija() {
		super();
	}

	public Transakcija(int idTranskacije, String opis, String datum,
			String vrijeme, int iznos, int vrsta, Korisnik Korisnik,
			Kategorija Kategorija, Racun Racun) {
		super();
		this.idTranskacije = idTranskacije;
		this.opis = opis;
		this.datum = datum;
		this.vrijeme = vrijeme;
		this.iznos = iznos;
		this.vrsta = vrsta;
		this.Korisnik = Korisnik;
		this.Kategorija = Kategorija;
		this.Racun = Racun;
	}

	public int getIdTranskacije() {
		return idTranskacije;
	}

	public String getOpis() {
		return opis;
	}

	public String getDatum() {
		return datum;
	}

	public String getVrijeme() {
		return vrijeme;
	}

	public int getiZNOS() {
		return iznos;
	}

	public int getVrsta() {
		return vrsta;
	}

	public Korisnik getKorisnik() {
		return Korisnik;
	}

	public Kategorija getKategorija() {
		return Kategorija;
	}

	public Racun getRacun() {
		return Racun;
	}

	public void setIdTranskacije(int idTranskacije) {
		this.idTranskacije = idTranskacije;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public void setVrijeme(String vrijeme) {
		this.vrijeme = vrijeme;
	}

	public void setIznos(int iznos) {
		this.iznos = iznos;
	}

	public void setVrsta(int vrsta) {
		this.vrsta = vrsta;
	}

	public void setKorisnik(Korisnik korisnik) {
		Korisnik = korisnik;
	}

	public void setKategorija(Kategorija kategorija) {
		Kategorija = kategorija;
	}

	public void setRacun(Racun racun) {
		Racun = racun;
	}
	
	public static List<Transakcija> getTransakcions(){
		
		return new Select().all().from(Transakcija.class).execute();
	}
	
	public static List<Transakcija> DeleteTransakcije(){
		
		return new Delete().from(Transakcija.class).execute();
	}

}
