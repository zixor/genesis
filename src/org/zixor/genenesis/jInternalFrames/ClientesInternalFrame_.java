package org.zixor.genenesis.jInternalFrames;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientesInternalFrame_ extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientesInternalFrame_() {
		super("Clientes", true, true, false, true);
		setBounds(250, 20, 300, 200);
		initComponents();
	}

	private void initComponents() {

		// txtFields
		JTextField txtPrimerNombre = new JTextField(10);
		JTextField txtSegundoNombre = new JTextField(10);
		JTextField txtPrimerApellido = new JTextField(10);
		JTextField txtSegundoApellido = new JTextField(10);
		JTextField txtTelefono = new JTextField(10);
		JTextField txtDireccion = new JTextField(10);
		JTextField txtCorreo = new JTextField(10);

		// labels
		JLabel lblPrimerNombre = new JLabel("Primer Nombre");
		lblPrimerNombre.setDisplayedMnemonic('P');
		lblPrimerNombre.setLabelFor(txtPrimerNombre);
		JLabel lblSegundoNombre = new JLabel("Segundo Nombre");
		lblSegundoNombre.setDisplayedMnemonic('S');
		lblSegundoNombre.setLabelFor(txtSegundoNombre);
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		lblPrimerApellido.setLabelFor(txtPrimerApellido);
		lblPrimerApellido.setDisplayedMnemonic('R');
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setLabelFor(txtSegundoApellido);
		lblSegundoApellido.setDisplayedMnemonic('E');
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setLabelFor(txtTelefono);
		lblTelefono.setDisplayedMnemonic('T');
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setLabelFor(txtDireccion);
		lblDireccion.setDisplayedMnemonic('D');
		JLabel lblCorreo = new JLabel("Correo Electronico");
		lblCorreo.setLabelFor(txtCorreo);
		lblCorreo.setDisplayedMnemonic('C');

		// Adds
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7, 2, 5, 5));
		panel.add(lblPrimerNombre);
		panel.add(txtPrimerNombre);
		panel.add(lblSegundoNombre);
		panel.add(txtSegundoNombre);
		panel.add(lblPrimerApellido);
		panel.add(txtPrimerApellido);
		panel.add(lblSegundoApellido);
		panel.add(txtSegundoApellido);
		panel.add(lblTelefono);
		panel.add(txtTelefono);
		panel.add(lblDireccion);
		panel.add(txtDireccion);
		panel.add(lblCorreo);
		panel.add(txtCorreo);
		getContentPane().add(panel, BorderLayout.CENTER);

	}

}
