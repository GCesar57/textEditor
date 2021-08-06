package com.practica1_3;


import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;



public class MenusEmergentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoEmergente mimarcoemergente = new MarcoEmergente();
		mimarcoemergente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
//
class MarcoEmergente extends JFrame{
	public MarcoEmergente() {
		setTitle("Menus Emergentes");
		setBounds(550,300, 550, 350);
		LaminaEmergente milaminaemergente = new LaminaEmergente();
		add(milaminaemergente);
		setVisible(true);
	}//
}//
//
class LaminaEmergente extends JComponent{
	JMenu fuente, estilo, tamanio;
	public LaminaEmergente() {
		setLayout(new BorderLayout());
		JPanel laminaMenu = new JPanel();
		JMenuBar miBarra = new JMenuBar();
		JMenu fuente = new JMenu("Fuente");
		JMenu estilo = new JMenu("Estilo");
		JMenu tamanio = new JMenu("Tamanio");
		miBarra.add(fuente);
		miBarra.add(estilo);
		miBarra.add(tamanio);
		laminaMenu.add(miBarra);
		add(laminaMenu, BorderLayout.NORTH);
		JTextPane miArea = new JTextPane();
		add(miArea, BorderLayout.CENTER);
		//=------------------------------------
		JPopupMenu emergente = new JPopupMenu();
		JMenuItem negrita = new JMenuItem("Negrita");
		JMenuItem cursiva = new JMenuItem("Cursiva");
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		emergente.add(negrita);
		emergente.add(cursiva);
		
		miArea.setComponentPopupMenu(emergente);
		
		
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
		
		}else if(menu == "tamanio") {
			tamanio.add(elemMenu);
			elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamanio", 12));
		}//
		//
	}//
}//
