package Controles;

import Telas.MenuIniciar;

public class Main {
	public static void main(String[] args) {
		MenuIniciar jp = new MenuIniciar();
		new Thread(jp).start();
 	}
}
