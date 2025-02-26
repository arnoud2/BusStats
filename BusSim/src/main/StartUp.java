package main;

import cui.BusSimApplication;
import domein.DomeinController;

public class StartUp {
	public static void main(String[] args) {
		DomeinController dm = new DomeinController();
		BusSimApplication busApp = new BusSimApplication(dm);

		busApp.Start();
	}
}
