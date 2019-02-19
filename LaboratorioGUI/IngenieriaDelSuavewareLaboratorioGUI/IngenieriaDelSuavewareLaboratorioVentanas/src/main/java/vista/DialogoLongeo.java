package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ehu.eus.IngenieriaDelSuavewareLaboratorioVentanas.App;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoLongeo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfUsuario;
	private JPasswordField tfContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoLongeo dialog = new DialogoLongeo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoLongeo() {
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{36, 0, 256, 23, 0};
		gbl_contentPanel.rowHeights = new int[]{44, 0, 28, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNombre = new JLabel("Nombre");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 1;
			gbc_lblNombre.gridy = 1;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			tfUsuario = new JTextField();
			GridBagConstraints gbc_tfUsuario = new GridBagConstraints();
			gbc_tfUsuario.insets = new Insets(0, 0, 5, 5);
			gbc_tfUsuario.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfUsuario.gridx = 2;
			gbc_tfUsuario.gridy = 1;
			contentPanel.add(tfUsuario, gbc_tfUsuario);
			tfUsuario.setColumns(10);
		}
		{
			JLabel lblUsuario = new JLabel("Contraseña");
			GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
			gbc_lblUsuario.anchor = GridBagConstraints.EAST;
			gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
			gbc_lblUsuario.gridx = 1;
			gbc_lblUsuario.gridy = 3;
			contentPanel.add(lblUsuario, gbc_lblUsuario);
		}
		{
			tfContrasena = new JPasswordField();
			GridBagConstraints gbc_tfContrasena = new GridBagConstraints();
			gbc_tfContrasena.insets = new Insets(0, 0, 5, 5);
			gbc_tfContrasena.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfContrasena.gridx = 2;
			gbc_tfContrasena.gridy = 3;
			contentPanel.add(tfContrasena, gbc_tfContrasena);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton jbbotonOk = new JButton("OK");
				jbbotonOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jbbotonOkActionPerformed(e);
					}
				});
				jbbotonOk.setActionCommand("OK");
				buttonPane.add(jbbotonOk);
				getRootPane().setDefaultButton(jbbotonOk);
			}
			{
				JButton jbBotonCancelar = new JButton("Cancel");
				jbBotonCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jbbotonCancelarActionPerformed(e);
					}
				});
				jbBotonCancelar.setActionCommand("Cancel");
				buttonPane.add(jbBotonCancelar);
			}
		}
		this.centrarVentana();
	}
	
	
	private void jbbotonOkActionPerformed(java.awt.event.ActionEvent evt) {
		App.Login(this.tfUsuario.getText(), String.valueOf(this.tfContrasena.getPassword()));
		
	}

	
	private void jbbotonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
		
	}
	
	private void centrarVentana() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);		
	}
	
	
}
