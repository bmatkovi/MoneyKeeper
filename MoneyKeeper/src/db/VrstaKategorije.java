package db;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

@Table(name = "VrstaKategorije")
public class VrstaKategorije extends Model {

	@Column(name = "naziv")
	public String naziv;

	public VrstaKategorije() {
		super();
	}

	public VrstaKategorije(String naziv) {
		super();
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public List<Kategorija> kategorije() {
		return getMany(Kategorija.class, "VrstaKategorije");
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public static List<VrstaKategorije> getVrstaKategorije(){
		
		return new Select().all().from(VrstaKategorije.class).execute();
	}

	public static List<VrstaKategorije> DeleteVrstuKategorije(){
		
		return new Delete().from(VrstaKategorije.class).execute();
	}


}
