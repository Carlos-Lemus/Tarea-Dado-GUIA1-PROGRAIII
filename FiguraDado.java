//aplicacion hecha por Carlos Alfonso Lemus Rodezno LR18001

import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;
import javax.swing.JPanel;

//clase que hereda de JPanel sera la encarga de mostrar sera la encargada de mostrar
//el dado en la ventana
public class FiguraDado extends JPanel {
	
	//atributo que sera utilizado para determinar cuando generar los puntos del dado
	private boolean presionado = false;
	
	
	//la siguiente linea especifica que el metodo paintComponent es una redefinicion
	//Del metodo paintComponent de la clase JPanel este metodo nos permite
	//generar figuras en la ventana
	@Override
	public void paintComponent(Graphics g)
	{
		
		//super llama al metodo paintComponent original
		super.paintComponent(g);
		
		g.setColor(Color.RED); //metodo que estable el color
		
		g.draw3DRect(125, 60, 100, 100, true); //metodo que genera la figura del dado
	
		//si presionar es true entonces se generan los puntos en el dado
		if(presionado)
		{	
			//se establece las coordenas de los puntos
			int x = 120;
			int y = 90;
			int n = 0;
					
			//instancia aun objeto de la clase SecureRandom 
			SecureRandom nAleatorio = new SecureRandom();
					
			//el metodo nextInt retorna un numero aleatorio de 0 hasta un numero 
			//de 0 hasta n-1 se le suma 1 para que tome n en cuenta
			int na = nAleatorio.nextInt(6+1);
					
			//si el numero aleatorio de na es 0 se incrimentara para que se 1
			//ya que al tirar de un dado no puede ser cero
			if(na == 0)
			{
				na++;
			}
					
			//ciclo que permite mostrar mas de un punto dependiendo de el numero 
			//de na
			for(int i = 0; i < na; i++)
			{	//se le suma debido a que n se le sumara "X" y "Y" para mover 
				//la posicion de los puntos
				n+=25;
				
				//en caso de que i sea 3 signifca que se han generado 3 puntos en 
				//el dado por que se incremeta "Y" para hacer dos filas de puntos
				//y se restablece n
				if(i == 3)
				{
					y+=30;
					n = 25;
				}
						
				g.setColor(Color.BLACK); //metodo que establece el color
						
				g.fillOval(x+n, y, 10, 10); //metodo que sera utilizado para generar
											//los puntos del dado
			
				//se restablece presionar como false 
				presionado = false;
			}
			
		}
		
	}
	
	//metodo que nos permite saber cuando se ha presionado el JButton "btirar"
	//de ese modo establecemos a presionado como true (el metodo posee como
	//parametro un booleano pero este solo podra tener el valor de true caso 
	//contrario no tendria sentido)
	public void ponerPuntos(boolean p) {
			
		//presionado toma el valor de p que es true por lo tanto se generaran los 
		//puntos del dado
		presionado = p; 
			
		repaint(); //metodo para redibujar las figuras, sin este metodo cualquier
					//cambio que se les haga a las figuras queda truncado
			
	}
	
}
