package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ehu.eus.IngenieriaDelSuavewareLaboratorioVentanas.App;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaConfig extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnBotonAceptar;
	private JPanel panel_1;
	private JRadioButton rdbtnx;
	private JRadioButton rdbtnx_1;
	private JRadioButton rdbtnx_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConfig frame = new VentanaConfig();
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
	public VentanaConfig() {
		initialize();
		this.centrarVentana();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.SOUTH);
		contentPane.add(getPanel_1(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel.add(getBtnBotonAceptar());
		}
		return panel;
	}
	private JButton getBtnBotonAceptar() {
		if (btnBotonAceptar == null) {
			btnBotonAceptar = new JButton("Aceptar");
			btnBotonAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnBotonAceptarActionPerformed(e);
				}
			});
		}
		return btnBotonAceptar;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(180)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(getRdbtnx())
							.addComponent(getRdbtnx_1())
							.addComponent(getRdbtnx_2())))
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(30)
						.addComponent(getRdbtnx())
						.addGap(5)
						.addComponent(getRdbtnx_1())
						.addGap(5)
						.addComponent(getRdbtnx_2()))
			);
			panel_1.setLayout(gl_panel_1);
		}
		return panel_1;
	}
	
	private JRadioButton getRdbtnx() {
		if (rdbtnx == null) {
			rdbtnx = new JRadioButton("200x200");
			rdbtnx.setMnemonic('0');
			buttonGroup.add(rdbtnx);
		}
		return rdbtnx;
	}
	
	private JRadioButton getRdbtnx_1() {
		if (rdbtnx_1 == null) {
			rdbtnx_1 = new JRadioButton("400x400");
			rdbtnx_1.setMnemonic('1');
			buttonGroup.add(rdbtnx_1);
		}
		return rdbtnx_1;
	}
	
	private JRadioButton getRdbtnx_2() {
		if (rdbtnx_2 == null) {
			rdbtnx_2 = new JRadioButton("600x600");
			rdbtnx_2.setMnemonic('2');
			buttonGroup.add(rdbtnx_2);
		}
		return rdbtnx_2;
	}
	
	
	private void btnBotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
		ButtonModel btnModel = buttonGroup.getSelection();
		if(btnModel != null) {
			App.PasarAVentanaFinal(btnModel.getMnemonic());
		}				
	}
	
	private void centrarVentana() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
