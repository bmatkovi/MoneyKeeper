package db;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

@Table(name = "Korisnik")
public class Korisnik extends Model {

	@Column(name = "idKorisnik")
	public int idKorisnik;

	@Column(name = "ime")
	public String ime;

	@Column(name = "prezime")
	public String prezime;

	@Column(name = "lozinka")
	public String lozinka;

	public Korisnik() {
		super();
	}

	public Korisnik(int idKorisnik, String ime, String prezime, String lozinka) {
		super();
		this.idKorisnik = idKorisnik;
		this.ime = ime;
		this.prezime = prezime;
		this.lozinka = lozinka;
	}

	public int getIdKorisnik() {
		return idKorisnik;
	}

	public String getiIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getLozinka() {
		return lozinka;
	}

	public List<Transakcija> transakcije() {
		return getMany(Transakcija.class, "Korisnik");
	}

	public List<KorisnikLog> korisnikLog() {
		return getMany(KorisnikLog.class, "Korisnik");
	}

	public List<Obavijesti> obavijesti() {
		return getMany(Obavijesti.class, "Korisnik");
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	public static List<Korisnik> getKorisnici(){
		
		return new Select().all().from(Korisnik.class).execute();
	}


public static List<Korisnik> DeleteKorisnike(){
		
		return new Delete().from(Korisnik.class).execute();
	}
}