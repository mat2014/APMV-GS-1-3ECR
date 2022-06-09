package windows;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import main.DataBase;
import main.Endereco;
import main.GerenciarPostos;
import main.Posto;
import main.plugs;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Inicial {

	public JFrame frame;
	private GerenciarPostos gerenciarPostos;
	private static DataBase dataBase;
	private JTextField txtNome;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtAvaliacao;
	private JTextField txtPrecoKWH;
	private JLabel lblplugs;

	private JCheckBox cbxTipo1 = new JCheckBox("Tipo 1");;
	private boolean cbxTipo1IsChecked = false;

	private JCheckBox cbxTipo2 = new JCheckBox("Tipo 2");;
	private boolean cbxTipo2IsChecked = false;

	private JCheckBox cbxCSS2 = new JCheckBox("CSS2");;
	private boolean cbxCSS2IsChecked = false;

	private JCheckBox cbxCHA = new JCheckBox("CHAdeMO");;
	private boolean cbxCHAIsChecked = false;

		public Inicial(GerenciarPostos gerenciarPostos, DataBase dataBase) throws SQLException {
			 this.gerenciarPostos = gerenciarPostos;
			 cbxTipo1.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					cbxTipo1IsChecked = !cbxTipo1IsChecked;
				}    
	         
	         });    
			 
			 cbxTipo2.addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent e) {
						cbxTipo2IsChecked = !cbxTipo2IsChecked;
					}    
		         
		         });    
			 
			 cbxCSS2.addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent e) {
						cbxCSS2IsChecked = !cbxCSS2IsChecked;
					}    
		         
		         });    
			 
			 cbxCHA.addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent e) {
						cbxCHAIsChecked = !cbxCHAIsChecked;
					}    
		         
		         });    

			this.dataBase = dataBase;
			initialize();
		}

		private void initialize() {
			frame = new JFrame();
			frame.getContentPane().setForeground(Color.BLACK);
			frame.setBackground(Color.DARK_GRAY);
			frame.getContentPane().setBackground(Color.cyan);
			SpringLayout springLayout = new SpringLayout();
			frame.getContentPane().setLayout(springLayout);
			
			JLabel lbTitle = new JLabel("Cadastro:");
			springLayout.putConstraint(SpringLayout.NORTH, lbTitle, 20, SpringLayout.NORTH, frame.getContentPane());
			springLayout.putConstraint(SpringLayout.WEST, lbTitle, 190, SpringLayout.WEST, frame.getContentPane());
			lbTitle.setFont(new Font("Tahoma", Font.BOLD, 17));
			lbTitle.setForeground(Color.BLACK);
			frame.getContentPane().add(lbTitle);
			
			JLabel lblNome = new JLabel("Nome");
			springLayout.putConstraint(SpringLayout.NORTH, lblNome, 20, SpringLayout.SOUTH, lbTitle);
			lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
			springLayout.putConstraint(SpringLayout.WEST, lblNome, 20, SpringLayout.WEST, frame.getContentPane());
			lblNome.setForeground(Color.BLACK);
			frame.getContentPane().add(lblNome);
			
			txtRua = new JTextField();
			springLayout.putConstraint(SpringLayout.NORTH, txtNome, 0, SpringLayout.NORTH, lblRua);
			springLayout.putConstraint(SpringLayout.WEST, txtNome, 6, SpringLayout.EAST, lblRua);
			springLayout.putConstraint(SpringLayout.EAST, txtNome, 190, SpringLayout.EAST, frame.getContentPane());
			txtRua.setColumns(10);
			
			
			JLabel lblRua = new JLabel("Rua");
			springLayout.putConstraint(SpringLayout.NORTH, lblRua, 20, SpringLayout.SOUTH, lbTitle);
			springLayout.putConstraint(SpringLayout.WEST, lblRua, 70, SpringLayout.EAST, txtNome);
			lblRua.setForeground(Color.BLACK);
			lblRua.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblRua);
			
			txtRua = new JTextField();
			springLayout.putConstraint(SpringLayout.NORTH, lblNome, 20, SpringLayout.SOUTH, lblRua);
			springLayout.putConstraint(SpringLayout.WEST, txtRua, 6, SpringLayout.EAST, lblRua);
			springLayout.putConstraint(SpringLayout.EAST, txtRua, -12, SpringLayout.EAST, frame.getContentPane());
			txtRua.setColumns(10);
			frame.getContentPane().add(txtRua);
			
			JLabel lblBairro = new JLabel("Bairro");
			springLayout.putConstraint(SpringLayout.NORTH, lblBairro, 20, SpringLayout.SOUTH, lblRua);
			springLayout.putConstraint(SpringLayout.EAST, lblBairro, 0, SpringLayout.EAST, lblRua);
			lblBairro.setForeground(Color.BLACK);
			lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblBairro);
			
			txtBairro = new JTextField();
			springLayout.putConstraint(SpringLayout.WEST, txtBairro, 6, SpringLayout.EAST, lblBairro);
			springLayout.putConstraint(SpringLayout.SOUTH, txtBairro, 0, SpringLayout.SOUTH, lblBairro);
			springLayout.putConstraint(SpringLayout.EAST, txtBairro, 0, SpringLayout.EAST, txtRua);
			txtBairro.setColumns(10);
			frame.getContentPane().add(txtBairro);
			
			
			JLabel lblCidade = new JLabel("Cidade");
			springLayout.putConstraint(SpringLayout.NORTH, lblCidade, 20, SpringLayout.SOUTH, lblBairro);
			springLayout.putConstraint(SpringLayout.EAST, lblCidade, 0, SpringLayout.EAST, lblBairro);
			lblCidade.setForeground(Color.BLACK);
			lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblCidade);
			
			txtCidade = new JTextField();
			springLayout.putConstraint(SpringLayout.WEST, txtCidade, 6, SpringLayout.EAST, lblCidade);
			springLayout.putConstraint(SpringLayout.SOUTH, txtCidade, 0, SpringLayout.SOUTH, lblCidade);
			springLayout.putConstraint(SpringLayout.EAST, txtCidade, 0, SpringLayout.EAST, txtBairro);
			txtBairro.setColumns(10);
			frame.getContentPane().add(txtCidade);
			
			JLabel lblEstado = new JLabel("Estado");
			springLayout.putConstraint(SpringLayout.NORTH, lblEstado, 20, SpringLayout.SOUTH, lblCidade);
			springLayout.putConstraint(SpringLayout.EAST, lblEstado, 0, SpringLayout.EAST, lblCidade);
			lblEstado.setForeground(Color.BLACK);
			lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblEstado);
			
			txtEstado = new JTextField();
			springLayout.putConstraint(SpringLayout.WEST, txtEstado, 6, SpringLayout.EAST, lblEstado);
			springLayout.putConstraint(SpringLayout.SOUTH, txtEstado, 0, SpringLayout.SOUTH, lblEstado);
			springLayout.putConstraint(SpringLayout.EAST, txtEstado, 0, SpringLayout.EAST, txtCidade);
			txtCidade.setColumns(10);
			frame.getContentPane().add(txtEstado);
			
			JLabel lblAvaliacao = new JLabel("Avaliação");
			springLayout.putConstraint(SpringLayout.WEST, lblAvaliacao, 0, SpringLayout.WEST, lblNome);
			springLayout.putConstraint(SpringLayout.SOUTH, lblAvaliacao, 0, SpringLayout.SOUTH, lblBairro);
			lblAvaliacao.setForeground(Color.BLACK);
			lblAvaliacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblAvaliacao);
			
			txtAvaliacao = new JTextField();
			springLayout.putConstraint(SpringLayout.WEST, txtAvaliacao, 6, SpringLayout.EAST, lblAvaliacao);
			springLayout.putConstraint(SpringLayout.SOUTH, txtAvaliacao, 0, SpringLayout.SOUTH, lblBairro);
			springLayout.putConstraint(SpringLayout.EAST, txtAvaliacao, 0, SpringLayout.EAST, txtNome);
			txtAvaliacao.setColumns(10);
			frame.getContentPane().add(txtAvaliacao);
			
			JLabel lblPrecoKWH = new JLabel("Preço ");
			springLayout.putConstraint(SpringLayout.WEST, lblPrecoKWH, 0, SpringLayout.WEST, lblAvaliacao);
			springLayout.putConstraint(SpringLayout.SOUTH, lblPrecoKWH, 0, SpringLayout.SOUTH, lblCidade);
			lblPrecoKWH.setForeground(Color.BLACK);
			lblPrecoKWH.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblPrecoKWH);
			
			txtPrecoKWH = new JTextField();
			springLayout.putConstraint(SpringLayout.NORTH, txtPrecoKWH, 0, SpringLayout.NORTH, lblCidade);
			springLayout.putConstraint(SpringLayout.WEST, txtPrecoKWH, 6, SpringLayout.EAST, lblPrecoKWH);
			springLayout.putConstraint(SpringLayout.EAST, txtPrecoKWH, -46, SpringLayout.EAST, txtNome);
			frame.getContentPane().add(txtPrecoKWH);
			txtPrecoKWH.setColumns(10);
			
			lblplugs = new JLabel("Tipos de Plug");
			springLayout.putConstraint(SpringLayout.NORTH, lblplugs, 0, SpringLayout.NORTH, lblEstado);
			springLayout.putConstraint(SpringLayout.WEST, lblplugs, 0, SpringLayout.EAST, lblPrecoKWH);
			lblplugs.setForeground(Color.BLACK);
			lblplugs.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblplugs);
			
			springLayout.putConstraint(SpringLayout.NORTH, cbxTipo1, 49, SpringLayout.SOUTH, lblPrecoKWH);
			springLayout.putConstraint(SpringLayout.WEST, cbxTipo1, -20, SpringLayout.WEST, lblplugs);
			frame.getContentPane().add(cbxTipo1);
			
			springLayout.putConstraint(SpringLayout.WEST, cbxTipo2, 28, SpringLayout.EAST, cbxTipo1);
			springLayout.putConstraint(SpringLayout.SOUTH, cbxTipo2, 0, SpringLayout.SOUTH, cbxTipo1);
			frame.getContentPane().add(cbxTipo2);
			
			springLayout.putConstraint(SpringLayout.NORTH, cbxCSS2, 23, SpringLayout.SOUTH, cbxTipo1);
			springLayout.putConstraint(SpringLayout.WEST, cbxCSS2, 0, SpringLayout.WEST, cbxTipo1);
			frame.getContentPane().add(cbxCSS2);
			
			springLayout.putConstraint(SpringLayout.WEST, cbxCHA, 0, SpringLayout.WEST, cbxTipo2);
			springLayout.putConstraint(SpringLayout.SOUTH, cbxCHA, 0, SpringLayout.SOUTH, cbxCSS2);
			frame.getContentPane().add(cbxCHA);
			
			JButton btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.setForeground(Color.LIGHT_GRAY);
			springLayout.putConstraint(SpringLayout.WEST, btnCadastrar, 120, SpringLayout.WEST, frame.getContentPane());
			springLayout.putConstraint(SpringLayout.SOUTH, btnCadastrar, 0, SpringLayout.SOUTH, frame.getContentPane());
			springLayout.putConstraint(SpringLayout.EAST, btnCadastrar, -120, SpringLayout.EAST, frame.getContentPane());
			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					ArrayList<plugs> plugsL = new ArrayList<plugs>();
					
					if (cbxTipo1IsChecked) {
						plugsL.add(plugs.tipo1);
					}
					if (cbxTipo2IsChecked) {
						plugsL.add(plugs.tipo2);
					}
					if (cbxCSS2IsChecked) {
						plugsL.add(plugs.css2);
					}
					if (cbxCHAIsChecked) {
						plugsL.add(plugs.chademo);
					}
					
					Endereco enderecoCadastro = new Endereco(txtRua.getText(), 
													 txtBairro.getText(), 
													 txtCidade.getText(), 
													 txtEstado.getText());
					
					Posto novoPosto = new Posto(txtNome.getText(), enderecoCadastro, txtAvaliacao.getText(), plugsL, txtPrecoKWH.getText());
					
					try {
						dataBase.inserirPosto(novoPosto);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			});
			btnCadastrar.setBackground(Color.DARK_GRAY);
			frame.getContentPane().add(btnCadastrar);
			
			JButton btnTabela = new JButton("Tabela");
			btnTabela.setForeground(Color.LIGHT_GRAY);
			springLayout.putConstraint(SpringLayout.NORTH, btnTabela, 0, SpringLayout.NORTH, btnCadastrar);
			springLayout.putConstraint(SpringLayout.WEST, btnTabela, 0, SpringLayout.EAST, btnCadastrar);
			btnTabela.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Tabela window = new Tabela(dataBase);
								window.frmTabela.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
				}
			});
			btnTabela.setBackground(Color.DARK_GRAY);
			frame.getContentPane().add(btnTabela);
			
			JButton btnMapa = new JButton("Mapa");
			btnMapa.setForeground(Color.LIGHT_GRAY);
			springLayout.putConstraint(SpringLayout.NORTH, btnMapa, 0, SpringLayout.NORTH, btnCadastrar);
			springLayout.putConstraint(SpringLayout.EAST, btnMapa, 0, SpringLayout.WEST, btnCadastrar);
			btnMapa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Mapa window = new Mapa(dataBase);
									window.frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					
				}
			});
			btnMapa.setBackground(Color.DARK_GRAY);
			frame.getContentPane().add(btnMapa);
			
			
			frame.setForeground(Color.WHITE);
			frame.setTitle("Gerenciador postos de abastecimento");
			frame.setBounds(100, 100, 599, 500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}
