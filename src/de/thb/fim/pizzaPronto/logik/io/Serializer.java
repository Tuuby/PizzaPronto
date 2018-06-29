package de.thb.fim.pizzaPronto.logik.io;

import java.io.*;

import de.thb.fim.pizzaPronto.logik.Bestellung;

public class Serializer {
    private ObjectOutputStream os;
    private ObjectInputStream is;

    public Serializer(String datei) {
    	try {
    		os = new ObjectOutputStream(new FileOutputStream(datei));
    		is = new ObjectInputStream(new FileInputStream(datei));
    	} catch (IOException e) {
    		System.err.println(e.getMessage());
    	}
    }

    public void serializeBestellung(Bestellung bestellung) {
    	try {
            os.writeObject(bestellung);
    	} catch (IOException e) {
    		System.err.println(e.getMessage());
    	}
    }

    public void closeOutput() {
        try {
        	os.close();
    	} catch (IOException e) {
    		System.err.println(e.getMessage());
    	}
    }

    public Bestellung deserializeBestellung() {
        try {
        	return (Bestellung)is.readObject();
    	} catch (IOException e) {
    		System.err.println(e.getMessage());
    	} catch (ClassNotFoundException e) {
    		System.err.println(e.getMessage());
    	}
        return null;
    }

    public void closeInput() {
    	try {
        	is.close();
    	} catch (IOException e) {
    		System.err.println(e.getMessage());
    	}
    }
}
