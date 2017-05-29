package org.zixor.genesis.jFrames;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel;

public class LunchApp {
	public static void main(String args[]) {
		try {
			try {
				UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
				//UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel");
				//UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} 
		
//		 try {
//			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//			        if ("Nimbus".equals(info.getName())) {
//			            UIManager.setLookAndFeel(info.getClassName());
//			            break;
//			        }
//			    }
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	  //   try {
			//UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
//			 try {
//				UIManager.setLookAndFeel(new SubstanceGraphiteLookAndFeel());
//			} catch (UnsupportedLookAndFeelException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		MainWindow mgr = MainWindow.getInstance();
		mgr.setVisible(true);
	}
}
