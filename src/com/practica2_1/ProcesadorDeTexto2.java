package com.practica2_1;

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
import javax.swing.text.StyledEditorKit.BoldAction;
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
		setBounds(550,200, 550, 440);
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
	JButton negritaBarra, cursivaBarra, subrabarra, azulBarra, rojoBarra, amarilloBarra, a_izquierda, a_derecha, a_centrado, a_justificado;
	JToolBar barra;
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
		barra = new JToolBar();
		configuraBarra("src/graficos/bold.gif").addActionListener(new StyledEditorKit.BoldAction());
		configuraBarra("src/graficos/unln.gif").addActionListener(new StyledEditorKit.UnderlineAction());
		configuraBarra("src/graficos/italic.gif").addActionListener(new StyledEditorKit.ItalicAction());
		//colores
		barra.addSeparator();
		configuraBarra("src/graficos/azul.gif").addActionListener(new StyledEditorKit.ForegroundAction("Azul", Color.BLUE));
		configuraBarra("src/graficos/rojo.gif").addActionListener(new StyledEditorKit.ForegroundAction("Rojo", Color.RED));
		configuraBarra("src/graficos/amarillo.gif").addActionListener(new StyledEditorKit.ForegroundAction("Amarillo", Color.YELLOW));
		//justificados
		barra.addSeparator();
		configuraBarra("src/graficos/izquierda.gif").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
		configuraBarra("src/graficos/centrado.gif").addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
		configuraBarra("src/graficos/derecha.gif").addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
		configuraBarra("src/graficos/justificado.gif").addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));
		barra.setOrientation(1);
		add(barra, BorderLayout.WEST);
		//------------------------------------------

	}//
	//
	//construir barra... devolvera un objeto de tipo JButton
	public JButton configuraBarra(String ruta) {
		JButton boton = new JButton(new ImageIcon(ruta));
		barra.add(boton);
		return boton;
	}//
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