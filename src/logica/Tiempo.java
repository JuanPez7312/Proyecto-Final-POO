package logica;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tiempo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int annio;
	private int mes;
	private int dia;
	private int hora;
	private int minuto;

	public Tiempo() {
		LocalDateTime ahora = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy-hh-mm");
		String fyh[] = ahora.format(formato).split("-");
		this.dia = Integer.parseInt(fyh[0]);
		this.mes = Integer.parseInt(fyh[1]);
		this.annio = Integer.parseInt(fyh[2]);
		this.hora = Integer.parseInt(fyh[3]);
		this.minuto = Integer.parseInt(fyh[4]);
	}
	
	public static String actual() {
		LocalDateTime ahora = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyyhhmmss");
		return ahora.format(formato);
	}

	public int getAnnio() {
		return annio;
	}

	public int getMes() {
		return mes;
	}

	public int getDia() {
		return dia;
	}

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

}
