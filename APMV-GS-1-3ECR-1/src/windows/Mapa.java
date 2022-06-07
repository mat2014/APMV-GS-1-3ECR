package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import main.DataBase;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mapa {

	public JFrame frame;
	private JTextField txtNome;
	private DataBase dataBase;
	JLabel imageLbl = new JLabel();
	int nomeId = 0;

	public Mapa(DataBase dataBase) {
		this.dataBase = dataBase;
		initialize();
	}
	
	private void setImage(String nome) {
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(new File("src/FotosBuscadas/buscas"+ nome +".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ImageIcon imageIcon = new ImageIcon(image);
		
		imageLbl.setIcon(imageIcon);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.MAGENTA);
		frame.setBackground(Color.DARK_GRAY);
		frame.setTitle("Mapa");
		frame.setBounds(100, 100, 611, 796);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Inserir nome:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.getContentPane().add(lblNewLabel);
		
		txtNome = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 110, SpringLayout.WEST, txtNome);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -110 , SpringLayout.EAST, txtNome);
		springLayout.putConstraint(SpringLayout.NORTH, txtNome, 165, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -18, SpringLayout.NORTH, txtNome);
		springLayout.putConstraint(SpringLayout.WEST, txtNome, 150, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtNome, -150, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String url = dataBase.gerarStringAPI(txtNome.getText());
					url = url.replaceAll("\\s+","");
					
					dataBase.downloadImg(url, "busca"+nomeId);
					
					setImage("busca"+nomeId);
				} catch (SQLException | IOException e1) {
					e1.printStackTrace();
				}
				
				nomeId++;
			}
		});
		btnNewButton.setBackground(Color.DARK_GRAY);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 221, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 110, SpringLayout.WEST, txtNome);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -110, SpringLayout.EAST, txtNome);
		springLayout.putConstraint(SpringLayout.SOUTH, txtNome, -20, SpringLayout.NORTH, btnNewButton);
		frame.getContentPane().add(btnNewButton);
		
		imageLbl.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, imageLbl, 20, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, imageLbl, 20, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, imageLbl, -20, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, imageLbl, -20, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(imageLbl);
	}
}