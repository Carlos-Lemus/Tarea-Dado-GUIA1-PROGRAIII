//aplicacion hecha por Carlos Alfonso Lemus Rodezno LR18001

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//clase que hereda de JFrame, sera la unica ventana de la aplicacion
public class Ventana extends JFrame {
	
	//Atributos
	private JLabel text;
	private FiguraDado figuraDado;
	private JButton btirar;
	
	public Ventana() 	//constructor
	{
		//super llama al constructor del JFrame
		super("Dado");
		
		//los Layout determinan la forma que van a ser distribuidos los componentes
		//en la ventana
		
        setLayout(new BorderLayout()); //se setea el Layout
        
        //panelNorte contiene un metodo que retorna una instancia de un panel
		JPanel panelNorte = getPanelNorte();
		panelNorte.setBackground(Color.DARK_GRAY); //se estable el color del panel
		add(panelNorte, BorderLayout.NORTH); //se agrega a la parte norte de la ventana
		
		//instancia de figuraDado que contiene todas las figuras de la aplicacion
		//y que tambien es un panel ya que hereda de JPanel
		figuraDado = new FiguraDado();
		add(figuraDado, BorderLayout.CENTER); //se agrega a la parte del centro de la ventana
		
		//panelSur contiene un metodo que retorna una instancia de un panel
		JPanel panelSur = getPanelSur();
		panelSur.setBackground(Color.BLUE); //se estable el color del panel
		add(panelSur, BorderLayout.SOUTH); //se agrega a la parte sur de la ventana
														
		setSize(360, 300); //Establece el tamaño de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true); //hace visible la ventana
		
	}
	
	//metodo que retorna la instancia de un panel este panel sera la seccion norte
	//de la ventana
	public JPanel getPanelNorte()
	{
		//instancia a un panel y se le pasa una instancia de FlowLayout al constructor
		JPanel p = new JPanel(new FlowLayout()); 
		//se instancia text y se le personaliza el JLabel
		text = new JLabel("Tira el dado!");
		text.setFont(new Font("serif",Font.BOLD,25));
		text.setForeground(Color.WHITE);
		p.add(text); //se agrega al panel
		
		return p;
	}
	
	//metodo que retorna la instancia de un panel este panel sera la seccion sur
	//de la ventana
	public JPanel getPanelSur()
	{
		JPanel p = new JPanel(); //instancia a un panel
		
		btirar = new JButton("Tirar");
		p.add(btirar); //se agrega al panel
		
		//metodo que realiza una accion en este caso la accion la determina 
		//la clase TirarDado por eso se le pasa una instancia de un objeto de este
		//tipo al metodo
		btirar.addActionListener(new TirarDado());
		
		return p;
	}
	
	//Clase que implementa la clase ActionListener este metodo realizara una accion
	//al momento de presionar el boton btirar
	private class TirarDado implements ActionListener
	{
		//redefinicion del metodo actionPerformed de la clase ActionListener
		@Override
		public void actionPerformed(ActionEvent e) {
			//metodo al que se le pasa como argumento true ya que eso indicara
			//que se generen los puntos en el dado
			figuraDado.ponerPuntos(true);
		}
		
	}
	
}
