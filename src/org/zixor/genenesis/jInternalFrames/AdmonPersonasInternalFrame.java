package org.zixor.genenesis.jInternalFrames;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import org.zixor.genenesis.tables.models.ControlTablaPersona;
import org.zixor.genenesis.tables.models.ModeloTablaPersona;
import org.zixor.genesis.beans.Persona;
import org.zixor.utilities.Images;

public class AdmonPersonasInternalFrame extends JInternalFrame {

	/**
	 * @author Noel Gonzalez (Zixor)
	 * @since 21 Enero 2010
	 * 
	 **/
	private static final long serialVersionUID = 1L;
	private ModeloTablaPersona modelo = null;
	private ControlTablaPersona control = null;
	private static AdmonPersonasInternalFrame instance;

	private AdmonPersonasInternalFrame(ModeloTablaPersona modelo,
			ControlTablaPersona control) {
		super("Administrar Personas", false, true, true, true);
		this.modelo = modelo;
		this.control = control;
		setBounds(250, 20, 500, 600);
		initComponents();
	}

	public static AdmonPersonasInternalFrame getInstance(
			ModeloTablaPersona modeloPersona, ControlTablaPersona control) {
		if (instance == null) {
			instance = new AdmonPersonasInternalFrame(modeloPersona, control);
			instance.setName("clientes");
		}
		return instance;
	}

	private void initComponents() {

		// txtFields
		final JTextField txtCedula = new JTextField(20);
		final JTextField txtNombre = new JTextField(20);

		// labels
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setDisplayedMnemonic('C');
		lblCedula.setLabelFor(txtCedula);
		JLabel lbloNombre = new JLabel("Nombre");
		lbloNombre.setDisplayedMnemonic('N');
		lbloNombre.setLabelFor(txtNombre);
		JLabel lblEstatura = new JLabel("Estatura");
		Float min = 0.00f;
		Float value = 0.70f;
		Float max = 2.50f;
		Float stepSize = 0.01f;
		SpinnerNumberModel model = new SpinnerNumberModel(value, min, max,
				stepSize);

		final JSpinner spinner = new JSpinner(model);
		JSpinner.NumberEditor editor = (NumberEditor) spinner.getEditor();
		DecimalFormat format = editor.getFormat();
		format.setMinimumFractionDigits(2);
		lblEstatura.setLabelFor(spinner);
		lblEstatura.setDisplayedMnemonic('E');
		JButton btnAdd = new JButton("Adicionar", Images.New.getIcon(40, 40));
		btnAdd.setToolTipText("Adicionar");
		JButton btnRemove = new JButton("Eliminar", Images.Remove.getIcon(24,
				24));
		btnRemove.setToolTipText("Eliminar");

		editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		Dimension d = spinner.getPreferredSize();
		d.width = 85;
		spinner.setValue(0);

		JButton btnOpen = new JButton("Abrir", Images.Abrir.getIcon(24, 24));
		btnOpen.setToolTipText("Abrir");
		JButton btnSave = new JButton("Guardar", Images.Save.getIcon(24, 24));
		btnSave.setToolTipText("Guardar");
		btnOpen.setToolTipText("Abrir");
		final JLabel statusbar = new JLabel(
				"El nombre del archivo seleccionado sera mostrado aqui.");

		JScrollPane scroll = new JScrollPane();
		final JTable table = new JTable(modelo);
		scroll.setViewportView(table);
		scroll.setColumnHeaderView(table.getTableHeader());

		Container container = this.getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints restricciones = new GridBagConstraints();
		restricciones.gridx = 0;
		restricciones.gridy = 0;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		getContentPane().add(lblCedula, restricciones);

		restricciones.gridx = 1;
		restricciones.gridy = 0;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.BOTH;
		getContentPane().add(txtCedula, restricciones);

		restricciones.gridx = 2;
		restricciones.gridy = 0;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 3;
		restricciones.weightx = 3.0;
		restricciones.fill = GridBagConstraints.BOTH;
		getContentPane().add(btnAdd, restricciones);
		restricciones.weightx = 0.0;

		restricciones.gridx = 0;
		restricciones.gridy = 1;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		getContentPane().add(lbloNombre, restricciones);

		restricciones.gridx = 1;
		restricciones.gridy = 1;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		getContentPane().add(txtNombre, restricciones);

		restricciones.gridx = 0;
		restricciones.gridy = 2;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		getContentPane().add(lblEstatura, restricciones);

		restricciones.gridx = 1;
		restricciones.gridy = 2;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		getContentPane().add(spinner, restricciones);

		restricciones.gridx = 0;
		restricciones.gridy = 3;
		restricciones.gridwidth = 3;
		restricciones.gridheight = 1;
		getContentPane().add(scroll, restricciones);

		restricciones.gridx = 0;
		restricciones.gridy = 4;
		restricciones.gridwidth = 3;
		restricciones.gridheight = 1;
		restricciones.weightx = 3.0;
		restricciones.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(btnRemove, restricciones);
		restricciones.weightx = 0.0;

		restricciones.gridx = 1;
		restricciones.gridy = 5;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		restricciones.anchor = GridBagConstraints.EAST;
		getContentPane().add(btnOpen, restricciones);
		restricciones.anchor = GridBagConstraints.CENTER;

		restricciones.gridx = 2;
		restricciones.gridy = 5;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.NONE;
		restricciones.anchor = GridBagConstraints.EAST;
		getContentPane().add(btnSave, restricciones);

		restricciones.gridx = 0;
		restricciones.gridy = 6;
		restricciones.gridwidth = 3;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.BOTH;
		getContentPane().add(statusbar, restricciones);

		this.pack();

		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String msg = "";
				boolean todoOk = true;
				if (txtCedula.getText().trim().equals("")) {
					msg += "El campo Numero de cedula es requerido \n";
					todoOk &= false;
				}
				if (txtNombre.getText().trim().equals("")) {
					msg += "El campo nombre es requerido \n";
					todoOk &= false;
				}

				Float talla = 0.0f;
				if (spinner.getValue() instanceof Integer) {
					String estatura = String.valueOf(spinner.getValue());
					talla = Float.parseFloat(estatura);
				} else {
					talla = (Float) spinner.getValue();
				}

				Integer numCedula = 0;
				try {
					numCedula = Integer.parseInt(txtCedula.getText());
				} catch (NumberFormatException ex) {
					todoOk &= false;
					msg += "El campo Numero de cedula debe ser un numero \n";
				}

				if (todoOk) {
					Persona persona = new Persona(numCedula, txtNombre
							.getText(), talla);
					todoOk &= control.addRow(persona);
					if (todoOk) {
						JOptionPane.showMessageDialog(
								getContentPane(),
								"La persona con numero de cedula "
										+ txtCedula.getText() + " ya "
										+ "se encuentra matriculada",
								"Error...", JOptionPane.ERROR_MESSAGE);
					} else {
						txtCedula.setText("");
						txtNombre.setText("");
						spinner.setValue(0.0f);
					}

				} else {
					JOptionPane.showMessageDialog(getContentPane(), msg,
							"Error...", JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		btnRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer cedula = (Integer) table.getValueAt(
						table.getSelectedRow(), 0);
				control.removeRow(cedula);
			}
		});

		btnOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();

				chooser.setMultiSelectionEnabled(true);
				int option = chooser
						.showOpenDialog(AdmonPersonasInternalFrame.this);

				if (option == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					control.openFile(file.getPath());
					statusbar.setText("Selecciono " + file.getName());
				} else {
					statusbar.setText("Accion Cancelado.");
				}
			}

		});

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int option = chooser
						.showSaveDialog(AdmonPersonasInternalFrame.this);
				if (option == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					control.save(file.getPath());
					String msg = "Se guardo el archivo con nombre "
							+ file.getName();
					JOptionPane.showMessageDialog(getContentPane(), msg,
							"Informacion...", JOptionPane.INFORMATION_MESSAGE);
					statusbar.setText(msg
							+ ((chooser.getSelectedFile() != null) ? chooser
									.getSelectedFile().getName()
									: "No se puedo Guadar el archivo."));

				} else {
					statusbar.setText("Cancelado.");
				}
			}
		});
	}
}
