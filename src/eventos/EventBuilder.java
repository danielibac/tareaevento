package eventos;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import gui.Ventana;
import modelo.Circulo;
import modelo.Linea;

final public class EventBuilder {
	static Point punto = new Point();
	static Point inicio = new Point();
	static Point fin = new Point();
private EventBuilder(){}

public static ActionListener presionarCirculo(final Ventana ventana){
	ActionListener circulo = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent evento){
			if(ventana.getToolbar().getBtn("CIRCULO").isSelected() == true ){
				ventana.setSeleccionado(Ventana.CIRCULO);	
			}					
		}
	};
	return circulo;		
}
public static MouseAdapter eventoDelCirculo( final Ventana ventana){
	
	MouseAdapter Adapter= new MouseAdapter(){
		
		@Override
		public void mouseClicked(MouseEvent evento){
			if(ventana.getSeleccionado() == Ventana.CIRCULO){
				Circulo miCirculo = new Circulo(evento.getPoint(),50);
				ventana.getCanvas().addDibujable(miCirculo);
				ventana.getCanvas().repaint();
			}
		}
		
	};
	
	return Adapter;
}

public static ActionListener presionarLinea(final Ventana ventana){
	ActionListener al = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent evento){
			if(ventana.getToolbar().getBtn("LINEA").isSelected() == true ){
				ventana.setSeleccionado(Ventana.LINEA);	
			}					
		}
	};
	return al;		
}

public static ActionListener Limpiador(final Ventana ventana){
	ActionListener limpiador = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent evento){
			ventana.getCanvas().limpiar();				
		}
	};
	return limpiador;		
}





public static MouseAdapter eventoDeLinea( final Ventana ventana){
	
	MouseAdapter Adapter = new MouseAdapter(){
				
		@Override 
		public void mousePressed(MouseEvent evento){
			if(ventana.getSeleccionado() == Ventana.LINEA ){
			    inicio=evento.getPoint();
			    
				Linea linea= new Linea(inicio,inicio);
			    ventana.getCanvas().setDibujableTmp(linea);
			    ventana.getCanvas().setDibujandoTmp(true);
			    ventana.getCanvas().repaint();
			    
			}
		}
		
		
		public void mouseDragged(MouseEvent evento){// no me funciono 
			if(ventana.getSeleccionado()== Ventana.LINEA && ventana.getCanvas().isDibujandoTmp()){
			
				Linea linea2=null;
			linea2.setFin(evento.getPoint());
			
			ventana.getCanvas().repaint();
			}
		}
		
		
		@Override
		public void mouseReleased(MouseEvent evento){
			
			if(ventana.getSeleccionado() == Ventana.LINEA && ventana.getCanvas().isDibujandoTmp()){
				Linea linea = new Linea(inicio, evento.getPoint());
				
				ventana.getCanvas().addDibujable(linea);
				linea=null;
				ventana.getCanvas().setDibujableTmp(linea);
				ventana.getCanvas().repaint();
		 }
	   }
		
	 };
	
	return Adapter;
  }

}



