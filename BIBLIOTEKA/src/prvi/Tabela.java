package prvi;

import java.util.*;
import javax.swing.table.AbstractTableModel;

public class Tabela extends AbstractTableModel{

	ArrayList<Knjiga> lista;
	
	public Tabela(ArrayList<Knjiga> lista) {
		this.lista = lista;
	}
	
	@Override
	public int getColumnCount() {
		return 11;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int r, int c) {
		Knjiga a = lista.get(r);
		switch (c) {
		case 0:
			return a.getId();
		case 1:
			return a.getBarcod();
		case 2:
			return a.getAutor();
		case 3:
			return a.getBroj_stranica_();
		case 4:
			return a.getDatum_publikovanja_();
		case 5:
			return a.getISBN();
		case 6:
			return a.getNaziv();
		case 7:
			return a.getIzdavac();
		case 8:
			return a.getJezik();
		case 9:
			return a.getOpis();
		case 10:
			return a.getTip_knjige();
			
			
		
		default:
			return "Greska!";
		}
	}

	@Override
	public String getColumnName(int c) {
		switch (c) {
		case 0:
			return "ID";
		case 1:
			return "BarCod";
		case 2:
			return "Autor";
		case 3:
			return "BrojStrana";
		case 4:
			return "DatumPublikovanja";
		case 5:
		   return "ISBN";
		case 6:
			return "Naziv";
		case 7:
			return "Izdavac";
		case 8:
			return "Jezik";
		case 9:
			return "Opis";
		case 10:
			return "TipKnjige";
		default:
			return "Greska!";
		}
	}
	
}