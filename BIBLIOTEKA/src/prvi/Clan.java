package prvi;





public class Clan {
	private int id;
	private String adresa;
	private String ime;
    public  int getId() {return id;}
	public void setID(int id) {this.id=id;}
	
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public Clan() {}
	public Clan(int id,String ime,String adresa) {
		this.id=id;
		this.adresa=adresa;
		this.ime=ime;
	}
	@Override
	public String toString() {
		return "Clan [adresa=" + adresa + ", ime=" + ime + "]";
	}
	
}
