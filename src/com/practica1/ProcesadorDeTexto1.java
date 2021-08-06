package com.practica1;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;



public class ProcesadorDeTexto1 {

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
		}else if(menu == "estilo") {
			estilo.add(elemMenu);
		}else if(menu == "tamanio") {
			tamanio.add(elemMenu);
		}//
		//
		elemMenu.addActionListener(new GestionaEventos(rotulo, tipoLetra, estilos, tam));
	}//
	//
	//Clase interna pata el manejo de eventos.
	private class GestionaEventos implements ActionListener{
		String tipo_texto, menu;
		int estilo_letra, tamanio_letra;
		public GestionaEventos(String elemento, String texto2, int estilo2, int tam_letra) {
			// TODO Auto-generated constructor stub
			tipo_texto= texto2;
			estilo_letra = estilo2;
			tamanio_letra = tam_letra;
			menu = elemento;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			letras = miArea.getFont();
			if(menu=="Arial" || menu=="Courier" || menu=="Verdana") {
				estilo_letra = letras.getStyle();
				tamanio_letra = letras.getSize();
			}else if(menu=="Negrita" || menu=="Cursiva") {
				if(letras.getStyle()==1 || letras.getStyle()==2) {
					estilo_letra=3;
				}//
				tipo_texto = letras.getFontName();
				tamanio_letra = letras.getSize();
			}else if(menu=="12" || menu=="16" || menu=="20" || menu=="24") {
				estilo_letra = letras.getStyle();
				tipo_texto = letras.getFontName();
			}//
			miArea.setFont(new Font(tipo_texto, estilo_letra, tamanio_letra));
			System.out.println("Tipo de fuente: "+tipo_texto+", Estilo: "+estilo_letra+", Tamanio: "+tamanio_letra);
		}
		//
	}//
	
}//