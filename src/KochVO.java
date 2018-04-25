import java.awt.Color;

public class KochVO {
	private String nachname;
	private String vorname;
	private Color farbeSchuerze;
	
	public KochVO() {
		this(null, null, null);
	}

	public KochVO(String nachname, String vorname, Color farbeSchuerze) {
		this.nachname = nachname;
		this.vorname = vorname;
		this.farbeSchuerze = farbeSchuerze;
	}
	
	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Color getFarbeSchuerze() {
		return farbeSchuerze;
	}

	public void setFarbeSchuerze(Color farbeSchuerze) {
		this.farbeSchuerze = farbeSchuerze;
	}
}
