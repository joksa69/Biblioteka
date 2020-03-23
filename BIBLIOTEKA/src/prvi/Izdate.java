package prvi;

public class Izdate 
{
	private int id;
  private int broj;
  private String ime;
  private String autor;
  private String naziv;
  private String datum;
public Izdate(int id,int broj, String ime, String autor, String naziv, String datum) {
	super();
	this.id=id;
	this.broj = broj;
	this.ime = ime;
	this.autor = autor;
	this.naziv = naziv;
	this.datum = datum;
}
public int getId() {return id;}

public int getBroj() {
	return broj;
}
public void setBroj(int broj) {
	this.broj = broj;
}
public String getIme() {
	return ime;
}
public void setIme(String ime) {
	this.ime = ime;
}
public String getAutor() {
	return autor;
}
public void setAutor(String autor) {
	this.autor = autor;
}
public String getNaziv() {
	return naziv;
}
public void setNaziv(String naziv) {
	this.naziv = naziv;
}
public String getDatum() {
	return datum;
}
public void setDatum(String datum) {
	this.datum = datum;
}
@Override
public String toString() {
	return "Izdate [broj=" + broj + ", ime=" + ime + ", autor=" + autor + ", naziv=" + naziv + ", datum=" + datum + "]";
}
  
}
