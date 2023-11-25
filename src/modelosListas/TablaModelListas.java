package modelosListas;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import logica.ListaTareas;
import logica.Usuario;

@SuppressWarnings("serial")
public class TablaModelListas extends AbstractTableModel {
	private String[] columnNames = { "Listas de Tareas" };

	private static ArrayList<String> dat = new ArrayList<String>();
	
	public TablaModelListas(Usuario us) {
		for(ListaTareas lista : us.getListas()) {
			dat.add(lista.getTitulo());
		}

	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public int getRowCount() {
		return dat.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return dat.get(row);
	}

	@Override
	public Class<?> getColumnClass(int column) {
			return String.class;
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		
	}
}
