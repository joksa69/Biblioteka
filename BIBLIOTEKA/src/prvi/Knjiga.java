package prvi;
import java.io.*;
import java.sql.*;
import java.util.Date;
import java.sql.*;
import java.util.*;
import java.sql.*;
import java.util.Date;

import javax.swing.JOptionPane;

import java.util.ArrayList;
public final class Knjiga 
{
	
   private  static int uid=0;
   private int id;
   private String barcod;
   private String autor;
   private int broj_stranica_;
   private String datum_publikovanja_;
   private String ISBN;
   private String naziv;
   private String izdavac;
   private String jezik;
   private String opis;
   private String tip_knjige;
   


public Knjiga(int id, String barcod, String autor, int broj_stranica_, String datum_publikovanja_, String iSBN,
		String naziv, String izdavac, String jezik, String opis, String tip_knjige) {
	super();
	this.id = id;
	this.barcod = barcod;
	this.autor = autor;
	this.broj_stranica_ = broj_stranica_;
	this.datum_publikovanja_ = datum_publikovanja_;
	ISBN = iSBN;
	this.naziv = naziv;
	this.izdavac = izdavac;
	this.jezik = jezik;
	this.opis = opis;
	this.tip_knjige = tip_knjige;
}




public Knjiga() {}

	



public String getNaziv() {return naziv;}




public int getId() {
	return id;
}




public void setId(int id) {
	this.id = id;
}




public String getBarcod() {
	return barcod;
}




public void setBarcod(String barcod) {
	this.barcod = barcod;
}




public String getAutor() {
	return autor;
}




public void setAutor(String autor) {
	this.autor = autor;
}




public int getBroj_stranica_() {
	return broj_stranica_;
}




public void setBroj_stranica_(int broj_stranica_) {
	this.broj_stranica_ = broj_stranica_;
}




public String getDatum_publikovanja_() {
	return datum_publikovanja_;
}




public void setDatum_publikovanja_(String datum_publikovanja_) {
	this.datum_publikovanja_ = datum_publikovanja_;
}




public String getISBN() {
	return ISBN;
}




public void setISBN(String iSBN) {
	ISBN = iSBN;
}




public String getIzdavac() {
	return izdavac;
}




public void setIzdavac(String izdavac) {
	this.izdavac = izdavac;
}




public String getJezik() {
	return jezik;
}




public void setJezik(String jezik) {
	this.jezik = jezik;
}




public String getOpis() {
	return opis;
}




public void setOpis(String opis) {
	this.opis = opis;
}




public String getTip_knjige() {
	return tip_knjige;
}




public void setTip_knjige(String tip_knjige) {
	this.tip_knjige = tip_knjige;
}




public void setNaziv(String naziv) {
	this.naziv = naziv;
}




@Override
public String toString() {
	return "Knjiga [id=" + id + ", barcod=" + barcod + ", autor=" + autor + ", broj_stranica_=" + broj_stranica_
			+ ", datum_publikovanja_=" + datum_publikovanja_ + ", ISBN=" + ISBN + ", naziv=" + naziv + ", izdavac="
			+ izdavac + ", jezik=" + jezik + ", opis=" + opis + ", tip_knjige=" + tip_knjige + "]";
}

   
}
