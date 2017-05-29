package org.zixor.genenesis.components;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;

import org.zixor.genesis.actions.AdmonPersonasAction;
import org.zixor.genesis.actions.Maestros.ClasesAction;
import org.zixor.genesis.actions.Maestros.ClientesAction;
import org.zixor.genesis.actions.Maestros.InstructoresAction;
import org.zixor.genesis.actions.Maestros.RegistrarPagoClienteAction;
import org.zixor.genesis.jFrames.MainWindow;

public class MenuPPal extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainWindow parent;

	public MenuPPal(JFrame parentWindow) {
		parent = (MainWindow) parentWindow;
		initMenu();
	}

	private void initMenu() {
		
		JMenu nmSeguridad = new JMenu("  Seguridad   ");
		nmSeguridad.setHorizontalTextPosition(SwingConstants.CENTER);
		nmSeguridad.setVerticalTextPosition(SwingConstants.BOTTOM);
//		nmSeguridad.setIcon(new ImageIcon(Images.Security.getImage(32,32)));
//		nmSeguridad.addSeparator();
		this.add(nmSeguridad);
		
		
		JMenu mnMaestros = new JMenu("  Maestros   ");
		mnMaestros.setHorizontalTextPosition(SwingConstants.CENTER);
		mnMaestros.setVerticalTextPosition(SwingConstants.BOTTOM);
//		mnMaestros.setIcon(new ImageIcon(Images.Tools.getImage(32,32)));
//		mnMaestros.addSeparator();
		
		
		mnMaestros.add(new AdmonPersonasAction(parent));
		mnMaestros.add(new ClientesAction(parent));
		mnMaestros.add(new InstructoresAction(parent));
		mnMaestros.add(new ClasesAction(parent));
		this.add(mnMaestros);
		
		
		JMenu mnClientes = new JMenu("  Clientes   ");
		mnClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		mnClientes.setVerticalTextPosition(SwingConstants.BOTTOM);
//		mnClientes.setIcon(new ImageIcon(Images.New.getImage(32,32)));
//		mnClientes.addSeparator();
		this.add(mnClientes);
		
		
		JMenu mnPagos = new JMenu("  Pagos   ");
		mnPagos.setHorizontalTextPosition(SwingConstants.CENTER);
		mnPagos.setVerticalTextPosition(SwingConstants.BOTTOM);
//		mnPagos.setIcon(new ImageIcon(Images.PayCash.getImage(32,32)));
		mnPagos.addSeparator();
		mnPagos.add(new RegistrarPagoClienteAction(parent));
		this.add(mnPagos);

		
		JMenu mnReportes = new JMenu("  Reportes   ");
		mnReportes.setHorizontalTextPosition(SwingConstants.CENTER);
		mnReportes.setVerticalTextPosition(SwingConstants.BOTTOM);
//		mnReportes.setIcon(new ImageIcon(Images.Reports.getImage(32,32)));
//		mnReportes.addSeparator();
		this.add(mnReportes);
		
		JMenu mnHelp = new JMenu("  Ayuda   ");
		mnHelp.setHorizontalTextPosition(SwingConstants.CENTER);
		mnHelp.setVerticalTextPosition(SwingConstants.BOTTOM);
//		mnHelp.setIcon(new ImageIcon(Images.Help.getImage(32,32)));
//		mnHelp.addSeparator();
		this.add(mnHelp);
		
		
	}

}
