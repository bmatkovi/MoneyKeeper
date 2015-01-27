/*
 * 
 */
package db;

import java.util.List;

import android.content.ClipData.Item;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

// TODO: Auto-generated Javadoc
/**
 * The Class Kategorija.
 */
@Table(name = "Kategorija")
public class Kategorija extends Model {

	/** The id kategorije. */
	@Column(name = "idKategorije")
	public int idKategorije;

	/** The naziv. */
	@Column(name = "naziv")
	public String naziv;

	/** The opis. */
	@Column(name = "opis")
	public String opis;

	/** The favorit. */
	@Column(name = "favorit")
	public String favorit;

	/** The Vrsta kategorije. */
	@Column(name = "VrstaKategorije")
	public VrstaKategorije VrstaKategorije;

	/**
	 * Instantiates a new kategorija.
	 */
	public Kategorija() {
		super();
	}

	/**
	 * Instantiates a new kategorija.
	 *
	 * @param idKategorije the id kategorije
	 * @param naziv the naziv
	 * @param opis the opis
	 * @param favorit the favorit
	 * @param VrstaKategorije the vrsta kategorije
	 */
	public Kategorija(int idKategorije, String naziv, String opis,
			String favorit, VrstaKategorije VrstaKategorije) {
		super();
		this.idKategorije = idKategorije;
		this.naziv = naziv;
		this.opis = opis;
		this.favorit = favorit;
		this.VrstaKategorije = VrstaKategorije;
	}

	/**
	 * Gets the id kategorije.
	 *
	 * @return the id kategorije
	 */
	public int getIdKategorije() {
		return idKategorije;
	}

	/**
	 * Gets the naziv.
	 *
	 * @return the naziv
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Gets the opis.
	 *
	 * @return the opis
	 */
	public String getOpis() {
		return opis;
	}

	/**
	 * Gets the favorit.
	 *
	 * @return the favorit
	 */
	public String getFavorit() {
		return favorit;
	}

	/**
	 * Gets the vrsta kategorije.
	 *
	 * @return the vrsta kategorije
	 */
	public VrstaKategorije getVrstaKategorije() {
		return VrstaKategorije;
	}

	/**
	 * Transakcije.
	 *
	 * @return the list
	 */
	public List<Transakcija> transakcije() {
		return getMany(Transakcija.class, "Kategorija");
	}

	/**
	 * Sets the id kategorije.
	 *
	 * @param idKategorije the new id kategorije
	 */
	public void setIdKategorije(int idKategorije) {
		this.idKategorije = idKategorije;
	}

	/**
	 * Sets the naziv.
	 *
	 * @param naziv the new naziv
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	/**
	 * Sets the opis.
	 *
	 * @param opis the new opis
	 */
	public void setOpis(String opis) {
		this.opis = opis;
	}

	/**
	 * Sets the favorit.
	 *
	 * @param favorit the new favorit
	 */
	public void setFavorit(String favorit) {
		this.favorit = favorit;
	}

	/**
	 * Sets the vrsta kategorije.
	 *
	 * @param vrstaKategorije the new vrsta kategorije
	 */
	public void setVrstaKategorije(VrstaKategorije vrstaKategorije) {
		VrstaKategorije = vrstaKategorije;
	}

	
	/**
	 * Gets the kategorije.
	 *
	 * @return the kategorije
	 */
	public static List<Kategorija> getKategorije(){
		
		return new Select().all().from(Kategorija.class).execute();
	}

/**
 * Delete kategorije.
 *
 * @return the list
 */

	public static List<Kategorija> DeleteKategorije() {

		return new Delete().from(Kategorija.class).execute();
	}
	
	public static Kategorija getRandom() {
	    return new Select().from(Kategorija.class).orderBy("RANDOM()").executeSingle();
	}
	
	public static List<Kategorija> getAll(VrstaKategorije vrsta) {
	    return new Select()
	        .from(Kategorija.class)
	        .where("VrstaKategorije = ?", vrsta.getId())
	        .orderBy("Name ASC")
	        .execute();
	}

}