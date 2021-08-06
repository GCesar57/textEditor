package com.practica1_5;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

import com.sun.glass.events.KeyEvent;

public class ProcesadorDeTexto2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuProcesador menuprocesador = new MenuProcesador();
		menuprocesador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuprocesador.setVisible(true);
	}

}
//
class MenuProcesador extends JFrame{
	public MenuProcesador() {
		setTitle("Procesador de Texto");
		setBounds(550,300, 550, 350);
		LaminaProcesador milaminaprocesador = new LaminaProcesador();
		add(milaminaprocesador);
		setVisible(true);
	}//
}
//
class LaminaProcesador extends JPanel{
	private JTextPane miArea;
	JMenu fuente, estilo, tamanio;
	Font letras;
	public LaminaProcesador() {
		//Establecer la distribucion.
		setLayout(new BorderLayout());
		JPanel laminaMenu = new JPanel(); //Lamina que tendra el menu
		//Crear la barra de menus
		JMenuBar miBarra = new JMenuBar();
		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamanio = new JMenu("Tamanio");

		//Elementos de fuente----------------------------------------------------------
		configuraMenu("Arial", "fuente", "Arial", 9, 10);
		configuraMenu("Courier", "fuente", "Courier", 9, 10);
		configuraMenu("Verdana", "fuente", "Verdana", 9, 10);

		//Elementos de estilo----------------------------------------------------------
		configuraMenu("Negrita", "estilo", "", Font.BOLD, 1);
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 1);
		
		//Elementos de tamanio----------------------------------------------------------
		configuraMenu("12", "tamanio", "", 9, 12);
		configuraMenu("16", "tamanio", "", 9, 16);
		configuraMenu("20", "tamanio", "", 9, 20);
		configuraMenu("24", "tamanio", "", 9, 24);
		
		//-----------------------------------------------------------------------------
		//
		//Agregar los elementos al menu.
		miBarra.add(fuente);
		miBarra.add(estilo);
		miBarra.add(tamanio);
		//Agregar la barra a la lamina.
		laminaMenu.add(miBarra);
		//Ubicacion
		add(laminaMenu, BorderLayout.NORTH);
		//
	    miArea = new JTextPane();
		add(miArea, BorderLayout.CENTER);
	}//
	//
	public void configuraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam) {
		//
		JMenuItem elemMenu = new JMenuItem(rotulo);
		if(menu == "fuente") {
			fuente.add(elemMenu);
			if(tipoLetra=="Arial") {
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra", "Arial"));
			}else if(tipoLetra=="Courier") {
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra", "Courier"));
			}else if(tipoLetra=="Verdana") {
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra", "Verdana"));
			}
		}else if(menu == "estilo") {
			estilo.add(elemMenu);
			if(estilos==Font.BOLD) {
				elemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
				elemMenu.addActionListener(new StyledEditorKit.BoldAction());
			}else if(estilos==Font.ITALIC) {
				elemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
				elemMenu.addActionListener(new StyledEditorKit.ItalicAction());
			}//
			elemMenu.addActionListener(new StyledEditorKit.ItalicAction());
		}else if(menu == "tamanio") {
			tamanio.add(elemMenu);
			elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamanio", tam));
		}//
		//
	}//
	//
	//Clase interna pata el manejo de eventos.
	
	
}//