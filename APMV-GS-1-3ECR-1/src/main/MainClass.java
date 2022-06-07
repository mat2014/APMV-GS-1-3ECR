package main;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import windows.Inicial;

import windows.Inicial;

public class MainClass {
	private static Connection connection;
	private static DataBase dataBase;
	
	public static void main(String[] args) {
		try {
			connection = DriverManager.getConnection("jdbc:h2:mem:ps13eca");
			dataBase = new DataBase(connection);
			dataBase.init();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial window = new Inicial(new GerenciarPostos(), dataBase);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

