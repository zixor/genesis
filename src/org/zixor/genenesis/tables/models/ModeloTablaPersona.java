package org.zixor.genenesis.tables.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import org.zixor.genesis.beans.Persona;

public class ModeloTablaPersona extends AbstractTableModel {

	/**
	 * @author Noel Gonzalez (Zixor)
	 * @since 21 Enero 2010 
	 * 
	 **/

	private static final long serialVersionUID = 1L;

	public final static int COLUMN_ESTATURA = 2;

	public final static int COLUMN_NOMBRE = 1;

	public final static int COLUMN_CEDULA = 0;

	public final static int NUMBER_OF_COLUMNS = 3;


	private HashMap<Integer, Persona> data = new HashMap<Integer, Persona>();

	private Integer[] symbolRows;

	@SuppressWarnings("unchecked")
	public Class getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case COLUMN_CEDULA:
			return Integer.class;
		case COLUMN_NOMBRE:
			return String.class;
		case COLUMN_ESTATURA:
			return Float.class;
		default:
			System.err.print("No implementation for getColumnClass("
					+ columnIndex + ")");
			return Object.class;
		}
	}

	public int getColumnCount() {
		return NUMBER_OF_COLUMNS;
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case COLUMN_CEDULA:
			return "Cedula";
		case COLUMN_NOMBRE:
			return "Nombre";
		case COLUMN_ESTATURA:
			return "Estatura";
		default:
			System.err.print("No implementation for getColumnName("
					+ columnIndex + ")");
			return "Column " + columnIndex;
		}
	}

	public Map<Integer, Persona> getData() {
		return data;
	}

	public int getRowCount() {
		return symbolRows == null ? 0 : symbolRows.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Persona row = new Persona();
		if (data.size() > 0) {
			row = (Persona) data.get(symbolRows[rowIndex]);
		}
		switch (columnIndex) {
		case COLUMN_CEDULA:
			return row.getCedula();
		case COLUMN_NOMBRE:
			return row.getNombre();
		case COLUMN_ESTATURA:
			return new Float(row.getEstatura());
		default:
			System.err.print("No hay valor para getValueAt(" + rowIndex
					+ "," + columnIndex + ")");
			return null;
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case COLUMN_CEDULA:
			return false;
		case COLUMN_NOMBRE:
			return true; // esta columna no es editable
		case COLUMN_ESTATURA:
			return true;
		default:
			System.err.print("No hay valor para la celda isCellEditable(" + rowIndex
					+ "," + columnIndex + ")");
			return false;
		}
	}

	/**
	 * Añade un objeto tipo Persona al HashMap que es enlazado a la
	 * tabla 
	 * 
	 **/
	public boolean setData(Persona persona) {
		boolean noExiste = false;
		if (!data.containsKey(persona.getCedula())) {
			data.put(persona.getCedula(), persona);
			initSizeKeys();
		} else {
			noExiste = true;
		}
		fireTableDataChanged();
		return noExiste;
	}

	/**
	 * Edita el valor en la celda especifica y
	 * setea el valor de un Objeto tipo persona.  
	 */
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		String value = aValue.toString();
		Persona row = (Persona) data.get(symbolRows[rowIndex]);
		switch (columnIndex) {
		case COLUMN_CEDULA:
			// not editable;
			return;
		case COLUMN_NOMBRE:
			row.setNombre(value);
			break;
		case COLUMN_ESTATURA:
			try {
				row.setEstatura(Float.parseFloat(value.trim()));
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
			break;
		default:
			System.err.print("No implementation for setValueAt(" + aValue + ","
					+ rowIndex + "," + columnIndex + ")");
			return;
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public void removePersona(Integer cedula) {
		if (data.size() > 0) {
			data.remove(cedula);
			initSizeKeys();
			fireTableDataChanged();
		}
	}

	@SuppressWarnings("unchecked")
	private void initSizeKeys() {
		int j = 0;
		symbolRows = new Integer[data.size()];
		Set set = data.keySet();
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			Integer key = (Integer) iter.next();
			symbolRows[j] = key;
			j++;
		}
	}

	public void saveSeriazable(String path) throws IOException {
		FileOutputStream fs = new FileOutputStream(path);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		os.writeObject(data);
		os.close();
	}

	@SuppressWarnings("unchecked")
	public void getFile(String path) throws IOException {
		FileInputStream fs = new FileInputStream(path);
		ObjectInputStream os = new ObjectInputStream(fs);
		try {
			data = (HashMap<Integer, Persona>) os.readObject();			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		initSizeKeys();
		fireTableDataChanged();
	}

}
