package org.zixor.genenesis.jInternalFrames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.zixor.utilities.DateLabelFormatter;

public class InstructoresInternalFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InstructoresInternalFrame() {
		super("Instructores", true, true, false, true);
		setSize(new Dimension(400, 500));
		setBounds(250, 20, 300, 200);
		initComponents();
	}

	private void initComponents() {

		// txtFields
		JTextField txtCedula = new JTextField(10);
		JTextField txtNombres = new JTextField(10);
		JTextField txtApellidos = new JTextField(10);
		JTextField txtTelefono = new JTextField(10);
		JTextField txtCelular = new JTextField(10);
		JTextField txtDireccion = new JTextField(10);
		JTextField txtCorreo = new JTextField(10);
		
		JTextArea txtInfoGeneral = new JTextArea();
		txtInfoGeneral.setLineWrap(true);
		txtInfoGeneral.setWrapStyleWord(true);		
		JScrollPane scrollpane = new JScrollPane(txtInfoGeneral);
		scrollpane.setBounds(10,50,400,300);		
		
		UtilDateModel model = new UtilDateModel();
		Properties properties = new Properties();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		//Seleccionar la fecha del sistema por defecto
		Calendar cal = Calendar.getInstance();
		model.setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
		model.setSelected(true);
		
		//fecha año editable
//		datePicker.get
		

		// labels
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setDisplayedMnemonic('N');
		lblNombres.setLabelFor(txtNombres);
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setLabelFor(txtApellidos);
		lblApellidos.setDisplayedMnemonic('A');
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setLabelFor(txtTelefono);
		lblTelefono.setDisplayedMnemonic('T');
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setLabelFor(txtCelular);
		lblCelular.setDisplayedMnemonic('C');
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setLabelFor(txtDireccion);
		lblDireccion.setDisplayedMnemonic('D');
		JLabel lblCorreo = new JLabel("Correo Electronico");
		lblCorreo.setLabelFor(txtCorreo);
		lblCorreo.setDisplayedMnemonic('E');
		JLabel lblInformacion = new JLabel("Información General");
		lblInformacion.setLabelFor(scrollpane);
		lblInformacion.setDisplayedMnemonic('I');
		JLabel lblCedula = new JLabel("Número de identificación");
		lblCedula.setLabelFor(txtCedula);
		lblCedula.setDisplayedMnemonic('N');
		JLabel lblNacimiento = new JLabel("Fecha de Nacimiento");
		lblNacimiento.setLabelFor(datePicker);
		lblNacimiento.setDisplayedMnemonic('D');

		// Adds
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9, 2, 5, 5));
		panel.add(lblCedula);
		panel.add(txtCedula);
		panel.add(lblNombres);
		panel.add(txtNombres);
		panel.add(lblApellidos);
		panel.add(txtApellidos);
		panel.add(lblNacimiento);
		panel.add(datePicker);
		panel.add(lblTelefono);
		panel.add(txtTelefono);
		panel.add(lblCelular);
		panel.add(txtCelular);
		panel.add(lblDireccion);
		panel.add(txtDireccion);
		panel.add(lblCorreo);
		panel.add(txtCorreo);
		panel.add(lblInformacion);
		panel.add(scrollpane);
		getContentPane().add(panel, BorderLayout.CENTER);

	}


}
