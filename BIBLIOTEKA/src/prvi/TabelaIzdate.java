package prvi;
import java.util.*;

import javax.swing.table.AbstractTableModel;

public class TabelaIzdate extends AbstractTableModel{

	
	

		ArrayList<Izdate> lista;
		
		public TabelaIzdate(ArrayList<Izdate> lista) {
			this.lista = lista;
		}
		
		@Override
		public int getColumnCount() {
			return 4;
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
				return iz.getNaziv();
			case 2:
				return iz.getAutor();
			case 3:
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
				return "Naziv";
			case 2:
				return "Autor";
			case 3:
				return "DatumIzdavanja";
			
			default:
				return "Greska!";
			}
		}
		
	
}
