package db;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

@Table(name = "KorisnikLog")
public class KorisnikLog extends Model {

	@Column(name = "datum")
	public String datum;

	@Column(name = "vrijeme")
	public String vrijeme;

	@Column(name = "akcija")
	public String akcija;

	@Column(name = "Korisnik")
	public Korisnik Korisnik;

	public KorisnikLog() {
		super();
	}

	public KorisnikLog(String datum, String vrijeme, String akcija,
			Korisnik Korisnik) {
		super();
		this.datum = datum;
		this.vrijeme = vrijeme;
		this.akcija = akcija;
		this.Korisnik = Korisnik;
	}

	public String getDatum() {
		return datum;
	}

	public String getVrijeme() {
		return vrijeme;
	}

	public String getAkcija() {
		return akcija;
	}

	public Korisnik getKorisnik() {
		return Korisnik;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public void setVrijeme(String vrijeme) {
		this.vrijeme = vrijeme;
	}

	public void setAkcija(String akcija) {
		this.akcija = akcija;
	}

	public void setKorisnik(Korisnik korisnik) {
		Korisnik = korisnik;
	}
	
public static List<KorisnikLog> getKorisnikLog(){
		
		return new Select().all().from(KorisnikLog.class).execute();
	}

public static List<KorisnikLog> DeleteKorisnikLog(){
	
	return new Delete().from(KorisnikLog.class).execute();
}

}
