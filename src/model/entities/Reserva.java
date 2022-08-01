package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}

	public Reserva(Integer numQuarto, Date checkIn, Date checkOut) {
		this.numQuarto = numQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkOut;
	}

	public long duracao() {
		long diferenca = checkOut.getTime() - checkIn.getTime(); // RETORNA A DIFERENÇA EM MILESEGUNDOS
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS); // MACETE PARA CONVERTER OS MILESEGUNDOS DA VARIAVEL "diferenca" EM DIAS
		
	}
	
	public void updateData(Date checkIn, Date chackOut) {
		this.checkIn = checkIn;
		this.checkOut = chackOut;	
	}

	@Override
	public String toString() {
		return "Quarto: " 
				+ numQuarto 
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+ " noites";
	}
	
	

	
}
