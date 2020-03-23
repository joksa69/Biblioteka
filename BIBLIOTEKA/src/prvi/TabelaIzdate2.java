package prvi;
import java.util.*;

import javax.swing.table.AbstractTableModel;

public class TabelaIzdate2 extends AbstractTableModel{

	
	

		ArrayList<Izdate> lista;
		
		public TabelaIzdate2(ArrayList<Izdate> lista) {
			this.lista = lista;
		}
		
		@Override
		public int getColumnCount() {
			return 6;
		}

		@Override
		public int getRowCount() {
			return lista.size();
		}

		@Override
		public Object getValueAt(int r, int c) {
			
		Izdate iz=lista.get(r);
			
			switch (c) {
			case 0:
				return iz.getId();
			case 1:
				return iz.getBroj();
			case 2:
				return iz.getIme();
			case 3:
				return iz.getAutor();
			case 4:
				return iz.getNaziv();
			case 5:
				return iz.getDatum();
			
				
				
			
			default:
				return "Greska!";
			}
		}

		@Override
		public String getColumnName(int c) {
			switch (c) {
			case 0:
				return "Rbr";
			case 1:
				return "Broj karte";
			case 2:
				return "Ime";
			case 3:
				return "Autor";
			case 4:
				return "Naziv";
			case 5:
				return "Datum Izdavanja";
			
			default:
				return "Greska!";
			}
		}
		
	
}
