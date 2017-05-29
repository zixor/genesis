package org.zixor.genenesis.tables.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.zixor.genesis.beans.Persona;

public class ModeloTablaPersonaArray implements TableModel {

	public ModeloTablaPersonaArray() {

	}

	private LinkedList<Persona> datos = new LinkedList<Persona>();
	private LinkedList<TableModelListener> listenera = new LinkedList<TableModelListener>();

	@Override
	public void addTableModelListener(TableModelListener l) {
		// añade el suscriptor a la lista de suscriptores
		listenera.add(l);

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return Float.class;
		default:
			return Object.class;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Cedula";
		case 1:
			return "Nombre";
		case 2:
			return "Estatura";

		default:
			return null;
		}

	}

	@Override
	public int getRowCount() {
		return datos.size();
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		Persona aux = datos.get(fila);
		switch (columna) {
		case 0:
			return aux.getCedula();

		case 1:
			return aux.getNombre();

		case 2:
			return aux.getEstatura();

		default:
			return null;
		}

	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		listenera.remove(l);

	}

	@Override
	public void setValueAt(Object dato, int fila, int columna) {
		Persona aux = datos.get(fila);
		switch (columna) {
		case 0:
			aux.setCedula((Integer) dato);
			break;
		case 1:
			aux.setNombre((String) dato);
			break;
		case 2:
			aux.setEstatura((Float) dato);
			break;

		default:
			break;
		}
		TableModelEvent evento = new TableModelEvent(this, fila, fila, columna);
		avisaSuscriptores(evento);

	}

	private void avisaSuscriptores(TableModelEvent evento) {
		for (TableModelListener listenerItem : listenera) {
			listenerItem.tableChanged(evento);
		}

	}

	public void addPersona(Persona newPersona) {
		boolean existe;
		existe = datos.contains(newPersona);
		if (!existe) {
			datos.add(newPersona);
			// se avisa a los subscritores, para actualizar el TableModelEvent
			TableModelEvent evento = new TableModelEvent(this, this
					.getRowCount() - 1, this.getRowCount() - 1,
					TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
			avisaSuscriptores(evento);
		}else{
			System.out.println("Existe ....");
		}

	}

	public void removePersona(int fila) {
		// borra el objeto persona en la fila especificada
		datos.remove(fila);
		// se avisa a los subscritores, para actualizar el TableModelEvent
		TableModelEvent evento = new TableModelEvent(this, fila, fila,
				TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
		avisaSuscriptores(evento);
	}

	public void saveSeriazable(String path) throws IOException {
		FileOutputStream fs = new FileOutputStream(path);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		os.writeObject(datos);
		os.close();
	}

	@SuppressWarnings("unchecked")
	public void getFile(String path) throws IOException {
		FileInputStream fs = new FileInputStream(path);
		ObjectInputStream os = new ObjectInputStream(fs);
		try {
			datos = (LinkedList<Persona>) os.readObject();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		TableModelEvent evento = new TableModelEvent(this,
				this.getRowCount() - 1, this.getRowCount() - 1,
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		avisaSuscriptores(evento);
	}
}
