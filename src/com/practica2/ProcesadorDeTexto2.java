package com.practica2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.InputEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.ItalicAction;

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
		//
		//construir barra(negrita)
		JToolBar barra = new JToolBar();
		JButton negritaBarra = new JButton(new ImageIcon("src/graficos/bold.gif"));
		//construir barra(cursiva)
		JButton cursivaBarra = new JButton(new ImageIcon("src/graficos/italic.gif"));
		//()underline
		JButton underlineBarra = new JButton(new ImageIcon("src/graficos/unln.gif"));
		//colores
		JButton azulBarra = new JButton(new ImageIcon("src/graficos/azul.gif"));
		JButton amarilloBarra = new JButton(new ImageIcon("src/graficos/amarillo.gif"));
		JButton rojoBarra = new JButton(new ImageIcon("src/graficos/rojo.gif"));
		//
		//Alineados
		JButton aIzquierda = new JButton(new ImageIcon("src/graficos/ds.gif"));
		JButton aCentrado = new JButton(new ImageIcon("src/graficos/d.gif"));
		JButton aDerecha = new JButton(new ImageIcon("src/graficos/e.gif"));
		JButton ajusto = new JButton(new ImageIcon("src/graficos/t.gif"));
		//
		
		negritaBarra.addActionListener(new StyledEditorKit.BoldAction());
		cursivaBarra.addActionListener(new StyledEditorKit.ItalicAction());
		underlineBarra.addActionListener(new StyledEditorKit.UnderlineAction());
		//
		azulBarra.addActionListener(new StyledEditorKit.ForegroundAction("Azul", Color.BLUE));
		amarilloBarra.addActionListener(new StyledEditorKit.ForegroundAction("Amarillo", Color.YELLOW));
		rojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("Rojo", Color.RED));
		//
		aIzquierda.addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
		aCentrado.addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
		aDerecha.addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
		ajusto.addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));
		//Agregar botones
		barra.add(negritaBarra);
		barra.add(cursivaBarra);
		barra.add(underlineBarra);
		barra.add(azulBarra);
		barra.add(amarilloBarra);
		barra.add(rojoBarra);
		//
		barra.add(aIzquierda);
		barra.add(aCentrado);
		barra.add(aDerecha);
		barra.add(ajusto);
		barra.setOrientation(1);
		add(barra, BorderLayout.WEST);
		//------------------------------------------

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