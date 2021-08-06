package com.practica1_5;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class PruebaAcciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoAccion marco = new MarcoAccion();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}
//Frame
class MarcoAccion extends JFrame{
	public MarcoAccion() {
		setTitle("Prueba Acciones");
		setBounds(300, 300, 700, 300);
		//
		PanelAcion lamina = new PanelAcion();
		add(lamina);
	}//
}//
//
//Components
class PanelAcion extends JPanel{
	//
	//Constructor
	public PanelAcion() {
		ActionColor accionAmarillo = new ActionColor("Amarillo", new ImageIcon("src/com.eventos/amarillo.gif"), Color.YELLOW);
		ActionColor accionAzul = new ActionColor("Azul", new ImageIcon("src/com.eventos/azul.gif"), Color.BLUE);
		ActionColor accionRojo = new ActionColor("Rojo", new ImageIcon("src/com.eventos/rojo.gif"), Color.RED);
		
		add(new JButton(accionAmarillo));
		add(new JButton(accionAzul));
		add(new JButton(accionRojo));
		/*
		 * JButton botonAmarillo = new JButton(accionAmarillo); add(botonAmarillo);
		 * 
		 * JButton botonAzul = new JButton(accionAzul); add(botonAzul);
		 * 
		 * JButton botonRojo = new JButton(accionRojo); add(botonRojo);
		 */
		/*
		 * JButton botonAmarillo = new JButton("Amarillo"); JButton botonRojo = new
		 * JButton("Rojo"); JButton botonAzul = new JButton("Azul"); //Add buttons to
		 * the panel / buttons are event source / put the panel as listener
		 * add(botonAmarillo); add(botonAzul); add(botonRojo);
		 */
		InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		//KeyStroke teclaAmarillo = KeyStroke.getKeyStroke("ctrl A");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_Azul");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_Rojo");
		ActionMap mapaAccion = getActionMap();
		mapaAccion.put("fondo_amarillo", accionAmarillo);
		mapaAccion.put("fondo_Azul", accionAzul);
		mapaAccion.put("fondo_Rojo", accionRojo);
	}//
	//
	//create a class that implements interface Action
	private class ActionColor extends AbstractAction{
		//Constructor...
		public  ActionColor(String nombre, Icon icono, Color color_boton) {
			// TODO Auto-generated constructor stub
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Pone la lamina de color: "+nombre);
			putValue("Color_de_fondo", color_boton);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub	
			Color c = (Color) getValue("Color_de_fondo");
			setBackground(c);
			System.out.println("nombre: "+getValue(Action.NAME));
			System.out.println("icono: "+getValue(Action.SMALL_ICON));
		}
	}//actionColor
}//

