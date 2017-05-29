package org.zixor.utilities;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.jdesktop.swingx.graphics.GraphicsUtilities;

public enum Images {

//Nombre de imagenes
	Cut("cut.jpg"),
	Copy("copy.jpg"),
	Save("save.png"),
	Abrir("open.png"),
	Game("Game.ico"),
	New("new.png"),
	Remove("remove.png"),
    NetworkConnected("NetworkConnected.png"),
    NetworkDisconnected("NetworkDisconnected.png"),
    Quit("quit.png"),
    Reports("reports.png"),
    Security("security.png"),
    Tools("tools.png"),
    Clear("Clear.png"),
    Print("print.png"),
    Help("help.png"),
    PayCash("pay_cash.png");
//Datos
    String imagefilename;

//Constructor
    Images(String name) {
        imagefilename = name;
    }

    /**
     * getImage, este metodo toma las imagenes de un archivo zip
     * añadido como libreria utilizando la siguiente linea
     * EsteClassLoader.getSystemResourceAsStream(imagefilename)
     * @author Noel Gonzalez (Zixor)
     **/


    BufferedImage getImage() {
        try {           
            return ImageIO.read(ClassLoader.getSystemResourceAsStream(imagefilename));
        } catch (IOException e) {
            return null;
        }
    }

    Icon getIcon() {
        return new ImageIcon(getImage());
    }

    public BufferedImage getImage(int width, int height) {
        return GraphicsUtilities.createThumbnail(getImage(), width, height);
    }


    /**
     * getIcon, retorna un objeto Icono con las dimenciones establecidas
     * como parametros
     * @param width int
     * @param height int
     * @return Icon
     */
    public Icon getIcon(int width, int height) {
        return new ImageIcon(getImage(width, height));
    }
}
