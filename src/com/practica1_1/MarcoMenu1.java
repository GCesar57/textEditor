package com.practica1_1;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class MarcoMenu1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoMenu miMarcoMenu = new MarcoMenu();
		miMarcoMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarcoMenu.setVisible(true);
	}

}
//
class MarcoMenu extends JFrame{
	public MarcoMenu() {
		setTitle("Prueba con Menus");
		setBounds(550,300, 550, 350);
		LaminaMenu miLaminaMenu = new LaminaMenu();
		add(miLaminaMenu);
	}//
}//
//
class LaminaMenu extends JPanel{
	public LaminaMenu() {
		JTextPane miArea;
		setLayout(new BorderLayout());
		JMenuBar miBarra = new JMenuBar();
		JMenu miArchivo = new JMenu("Archivo");
		JMenu miEdicion = new JMenu("Edicion");
		JMenu miHerramientas = new JMenu("Herramientas");
		JMenu opciones = new JMenu("Opciones");
		//Agregar Submenu
		JMenuItem guardar = new JMenuItem("Guardar..");
		JMenuItem guardarComo = new JMenuItem("Guardar Como...");
		
		JMenuItem cortar = new JMenuItem("Cortar", new ImageIcon("bin/graficos/cortar.gif"));
		JMenuItem copiar = new JMenuItem("Copiar", new ImageIcon("bin/graficos/copiar.gif"));
		JMenuItem pegar = new JMenuItem("Pegar", new ImageIcon("bin/graficos/pegar.gif"));
		JMenuItem generales = new JMenuItem("Generales");
		
		//Submenus...
		JMenuItem opcion1 = new JMenuItem("Opcion 1");
		JMenuItem opcion2 = new JMenuItem("Opcion 2");
		opciones.add(opcion1);
		opciones.add(opcion2);
		//miEdicion.add(opciones); se agrego mas abajo...
		//
		miArchivo.add(guardar);
		miArchivo.add(guardarComo);
		
		miEdicion.add(cortar);
		miEdicion.add(copiar);
		miEdicion.add(pegar);
		miEdicion.addSeparator();
		miEdicion.add(opciones);
		
		miHerramientas.add(generales);
		//Agregar los menus a la barra
		miBarra.add(miArchivo);
		miBarra.add(miEdicion);
		miBarra.add(miHerramientas);
		
		//Agregar la barra a la lamina
		add(miBarra, BorderLayout.NORTH);
		//
		miArea = new JTextPane();
		add(miArea, BorderLayout.CENTER);
	}//
}
