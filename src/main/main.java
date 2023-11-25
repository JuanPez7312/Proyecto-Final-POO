package main;

import java.awt.EventQueue;

import gui.ideas;

public class main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ideas frame = new ideas(3,80);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
