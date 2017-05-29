package org.zixor.genenesis.tables.models;

import java.io.IOException;

import org.zixor.genesis.beans.Persona;

public class ControlTablaPersona {

	/**
	 * @author Noel Gonzalez (Zixor)
	 * @since 21 Enero 2010 Clase encargada de controlar las peticiones del
	 *        formulario swing al modelo encargado de actualizar los cambios en
	 *        la tabla que esta enlazada al Bean persona.
	 **/

	private ModeloTablaPersona modelo = null;
	private int numero = 0;

	public ControlTablaPersona(ModeloTablaPersona modelo) {
		this.modelo = modelo;
	}

	/**
	 * Recibe Un objeto persona para ser insertado en el HashMap que se
	 * encuentra en la clase ModeloTablaPersona
	 * 
	 * @param Persona
	 *            persona
	 * @return boolen este booleano determina si el dato fue insertado o el
	 *         registro a insertar ya existe
	 */
	public boolean addRow(Persona persona) {
		boolean noExiste = modelo.setData(persona);
		numero++;
		return noExiste;
	}

	/**
	 * @return void
	 * @param cedula
	 *            recibe un Integer el cual es la clave para ser eliminida del
	 *            HashMap que contiene un Objeto Persona
	 */
	public void removeRow(Integer cedula) {
		modelo.removePersona(cedula);
	}

	/**
	 * Este clase recibe la direccion donde se almacenara el HashMap serializado
	 * que contiene los objetos de tipo Persona
	 * 
	 * @param path
	 */

	public void save(String path) {
		try {
			modelo.saveSeriazable(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Recibe la direccion en la que se encuentra el archivo con el HashMap
	 * serializado y que es leido para cargar nuevamente la informacion 
	 * contenida en este.
	 *  @param path
	 */
	public void openFile(String path) {
		try {
			modelo.getFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
