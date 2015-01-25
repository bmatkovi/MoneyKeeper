package db;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

@Table(name = "Racun")
public class Racun extends Model {

	@Column(name = "idRacun")
	public int idRacun;

	@Column(name = "opis")
	public String opis;

	@Column(name = "naziv")
	public String naziv;

	@Column(name = "iznos")
	public int iznos;

	public Racun() {
		super();
	}

	public Racun(int idRacun, String opis, String naziv, int iznos) {
		super();
		this.idRacun = idRacun;
		this.opis = opis;
		this.naziv = naziv;
		this.iznos = iznos;
	}

	public int getRacun() {
		return idRacun;
	}

	public String getOpis() {
		return opis;
	}

	public String getNaziv() {
		return naziv;
	}

	public int getIznos() {
		return iznos;
	}

	public List<Transakcija> transakcije() {
		return getMany(Transakcija.class, "Racun");
	}

	public void setIdRacun(int idRacun) {
		this.idRacun = idRacun;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void setIznos(int iznos) {
		this.iznos = iznos;
	}
	

	public static List<Racun> getRacuni(){
		
		return new Select().all().from(Racun.class).execute();
	}

public static List<Racun> DeleteRacune(){
		
		return new Delete().from(Racun.class).execute();
	}
}
