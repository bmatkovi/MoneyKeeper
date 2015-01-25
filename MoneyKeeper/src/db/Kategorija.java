package db;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

@Table(name = "Kategorija")
public class Kategorija extends Model {

	@Column(name = "idKategorije")
	public int idKategorije;

	@Column(name = "naziv")
	public String naziv;

	@Column(name = "opis")
	public String opis;

	@Column(name = "favorit")
	public String favorit;

	@Column(name = "VrstaKategorije")
	public VrstaKategorije VrstaKategorije;

	public Kategorija() {
		super();
	}

	public Kategorija(int idKategorije, String naziv, String opis,
			String favorit, VrstaKategorije VrstaKategorije) {
		super();
		this.idKategorije = idKategorije;
		this.naziv = naziv;
		this.opis = opis;
		this.favorit = favorit;
		this.VrstaKategorije = VrstaKategorije;
	}

	public int getIdKategorije() {
		return idKategorije;
	}

	public String getNaziv() {
		return naziv;
	}

	public String getOpis() {
		return opis;
	}

	public String getFavorit() {
		return favorit;
	}

	public VrstaKategorije getVrstaKategorije() {
		return VrstaKategorije;
	}

	public List<Transakcija> transakcije() {
		return getMany(Transakcija.class, "Kategorija");
	}

	public void setIdKategorije(int idKategorije) {
		this.idKategorije = idKategorije;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public void setFavorit(String favorit) {
		this.favorit = favorit;
	}

	public void setVrstaKategorije(VrstaKategorije vrstaKategorije) {
		VrstaKategorije = vrstaKategorije;
	}
	
	public static List<Kategorija> getKategorije(){
		
		return new Select().all().from(Kategorija.class).execute();
	}

public static List<Kategorija> DeleteKategorije(){
		
		return new Delete().from(Kategorija.class).execute();
	}

}