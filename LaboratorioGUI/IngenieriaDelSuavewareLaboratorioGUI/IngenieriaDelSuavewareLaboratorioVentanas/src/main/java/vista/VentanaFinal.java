package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class VentanaFinal extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblX;
	private JLabel lbX;
	private JLabel lblY;
	private JLabel lbY;
	private JPanel panel_1;
	private JLabel lblLaTeclap;
	private JLabel lbConteo;
	private JLabel lblVeces;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFinal frame = new VentanaFinal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaFinal() {
		initialize();
		this.centrarVentana();
		anadirKeyListener();
		anadirMouseListener();
		
	}
	
	public VentanaFinal(int resolucion) {
		initialize(resolucion);
		this.centrarVentana();
		anadirKeyListener();
		anadirMouseListener();
		
	}
	
	private void anadirKeyListener() {
		addKeyListener(new KeyAdapter() {			
			@Override
			public void keyPressed(KeyEvent e) {
				ventanaKeyPressed(e);
			}
		});
	}
	
	private void anadirMouseListener() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				ventanaMouseMovido(arg0);
			}
		});
		
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.SOUTH);
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		this.setLocation(null);
	}

	
	private void initialize(int resolucion) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, resolucion, resolucion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.SOUTH);
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			panel.add(getLblX());
			panel.add(getLbX());
			panel.add(getLblY());
			panel.add(getLbY());
		}
		return panel;
	}
	private JLabel getLblX() {
		if (lblX == null) {
			lblX = new JLabel("X: ");
		}
		return lblX;
	}
	private JLabel getLbX() {
		if (lbX == null) {
			lbX = new JLabel("0,00");
		}
		return lbX;
	}
	private JLabel getLblY() {
		if (lblY == null) {
			lblY = new JLabel(" Y: ");
		}
		return lblY;
	}
	private JLabel getLbY() {
		if (lbY == null) {
			lbY = new JLabel("0,00");
		}
		return lbY;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
			panel_1.add(getLblLaTeclap());
			panel_1.add(getLbConteo());
			panel_1.add(getLblVeces());
		}
		return panel_1;
	}
	private JLabel getLblLaTeclap() {
		if (lblLaTeclap == null) {
			lblLaTeclap = new JLabel("La tecla \"P\" se ha pulsado un total de ");
		}
		return lblLaTeclap;
	}
	private JLabel getLbConteo() {
		if (lbConteo == null) {
			lbConteo = new JLabel("0");
		}
		return lbConteo;
	}
	private JLabel getLblVeces() {
		if (lblVeces == null) {
			lblVeces = new JLabel(" veces.");
		}
		return lblVeces;
	}
	
	private void centrarVentana() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);		
	}
	
	
	private void ventanaKeyPressed(KeyEvent arg0) {
		if(arg0.getKeyChar() == 'p') {
			this.lbConteo.setText(""+(Integer.parseInt(this.lbConteo.getText())+1));
		}
	}	
		
	
	private void ventanaMouseMovido(MouseEvent arg0) {
		this.lbX.setText(""+arg0.getX());
		this.lbY.setText(""+arg0.getY());
		
		
		
	}
		
	
	
}
