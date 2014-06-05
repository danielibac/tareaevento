package main;

import gui.Ventana;
import eventos.EventBuilder;
import javax.swing.JToggleButton;

public class Main {

public static void main(String[] args) {
Ventana ventana = new Ventana();

JToggleButton circulo = new JToggleButton("CIRCULO");
JToggleButton linea = new JToggleButton("LINEA");

ventana.getToolbar().addBtn("CIRCULO", circulo);
ventana.getToolbar().addBtn("LINEA", linea);
circulo.addActionListener(EventBuilder.presionarCirculo(ventana));
linea.addActionListener(EventBuilder.presionarLinea(ventana));
ventana.getToolbar().addButtonsToToolbar();
ventana.getCanvas().addMouseListener(EventBuilder.eventoDelCirculo(ventana));
ventana.getCanvas().addMouseListener(EventBuilder.eventoDeLinea(ventana));
ventana.getToolbar().getBtnLimpiar().addActionListener(EventBuilder.Limpiador(ventana));
ventana.setVisible(true);
  }
}