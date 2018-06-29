package de.thb.fim.pizzaPronto.controller;
import java.awt.Color;

import de.thb.fim.pizzaPronto.logik.Koch;

public class TestKochOV {

	public static void main(String[] args) {
		Koch myKoch = new Koch("Mueller", "Jens", Color.RED);
		System.out.println(myKoch.getNachname());
		System.out.println(myKoch.getVorname());
		System.out.println(myKoch.getFarbeSchuerze());
	}
}