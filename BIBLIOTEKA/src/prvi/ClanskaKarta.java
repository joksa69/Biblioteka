package prvi;


public class ClanskaKarta extends Clan	{
	private int id;
	private int broj;
	private String datumOtvaranja;
	private String stanje;
	public int getId() {return id;}
	public void setID(int id) {this.id=id;}
	 
	public ClanskaKarta(int id,int broj,String datumOtvaranja) {
		this.broj=broj;
		this.datumOtvaranja=datumOtvaranja;
		this.id=id;
	}
	public ClanskaKarta() {}
	public ClanskaKarta(int id,int id1,String adresa,String ime,int broj,String datumOtvaranja,String stanje) {
		super(id1,adresa,ime);
		this.broj=broj;
		this.datumOtvaranja=datumOtvaranja;
		this.stanje=stanje;
		this.id=id;
	}
	
	public int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
		this.broj = broj;
	}
	public String getDatumOtvaranja() {
		return datumOtvaranja;
	}
	public void setDatumOtvaranja(String datumOtvaranja) {
		this.datumOtvaranja = datumOtvaranja;
	}
	public String getStanje() {
		return stanje;
	}
	public void setStanje(String stanje) {
		this.stanje = stanje;
	}
}

