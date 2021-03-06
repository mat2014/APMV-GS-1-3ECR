package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import main.DataBase;
import main.Posto;

import javax.swing.JTable;
import java.awt.ScrollPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tabela {

	public JFrame frmTabela;
	private JTable table;
	DefaultTableModel model;
	private static DataBase dataBase;
	Object[] coluna = {"nome","rua","bairro","cidade","estado","avaliação","plug tipo1","plug tipo2","plug CSS2","plug CHAdeMO", "preço KWH"};
	Object[] row = new Object[11];
	

	public Tabela(DataBase dataBase) {
		this.dataBase = dataBase;
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(coluna);
		
		atualizar(null);
		
		initialize();
	}
	
	private void ordenar() throws SQLException {
		ArrayList<Posto> postos = dataBase.getPostosOrdenado();
		atualizar(postos);
	}

	private void atualizar(ArrayList<Posto> postos) {
		try {
			if (postos == null) {
				postos = dataBase.getPostos();
			}
			
			model.setRowCount(0);

			
			for (Posto posto : postos) {
				row[0] = posto.getNome();
				row[1] = posto.getEndereco().getRua();
				row[2] = posto.getEndereco().getBairro();
				row[3] = posto.getEndereco().getCidade();
				row[4] = posto.getEndereco().getEstado();
				row[5] = posto.getAvaliacao();
				row[6] = posto.getPlug1();
				row[7] = posto.getPlug2();
				row[8] = posto.getPlug3();
				row[9] = posto.getPlug4();
				row[10]= posto.getPrecoKWH();
				
				model.addRow(row);
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	private void initialize() {
		frmTabela = new JFrame();
		frmTabela.setTitle("Tabela");
		frmTabela.getContentPane().setBackground(Color.DARK_GRAY);
		SpringLayout springLayout = new SpringLayout();
		frmTabela.getContentPane().setLayout(springLayout);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		springLayout.putConstraint(SpringLayout.NORTH, table, 5, SpringLayout.NORTH, frmTabela.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, table, 5, SpringLayout.WEST, frmTabela.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table, -5, SpringLayout.SOUTH, frmTabela.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table, -5, SpringLayout.EAST, frmTabela.getContentPane());
		table.setBackground(Color.LIGHT_GRAY);
		table.setModel(model);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 20, SpringLayout.NORTH, frmTabela.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, frmTabela.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, frmTabela.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, frmTabela.getContentPane());
		
		scrollPane.setViewportView(table);
		frmTabela.getContentPane().add(scrollPane);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar(null);
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnAtualizar, 0, SpringLayout.NORTH, scrollPane);
		btnAtualizar.setBackground(Color.WHITE);
		btnAtualizar.setForeground(Color.BLACK);
		springLayout.putConstraint(SpringLayout.WEST, btnAtualizar, 0, SpringLayout.WEST, frmTabela.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnAtualizar, -435, SpringLayout.EAST, frmTabela.getContentPane());
		frmTabela.getContentPane().add(btnAtualizar);
		
		JButton btnOrdenar = new JButton("Ordenar po Estado");
		btnOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ordenar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnOrdenar, 0, SpringLayout.EAST, btnAtualizar);
		springLayout.putConstraint(SpringLayout.SOUTH, btnOrdenar, 0, SpringLayout.SOUTH, btnAtualizar);
		btnOrdenar.setBackground(Color.WHITE);
		btnOrdenar.setForeground(Color.BLACK);
		springLayout.putConstraint(SpringLayout.NORTH, btnOrdenar, 0, SpringLayout.NORTH, btnAtualizar);
		springLayout.putConstraint(SpringLayout.EAST, btnOrdenar, 0, SpringLayout.EAST, frmTabela.getContentPane());
		frmTabela.getContentPane().add(btnOrdenar);
		
		frmTabela.setBounds(100, 100, 885, 499);
		frmTabela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}