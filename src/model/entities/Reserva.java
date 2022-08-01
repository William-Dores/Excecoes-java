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
	
	public String updateData(Date checkIn, Date chackOut) {
		
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			return "Data do check-out antes da data futura do check-in";			
		}
		if (!checkOut.after(checkIn)) {
			return "Data de check-out anterior a data de check-in";
		}
		
		this.checkIn = checkIn;
		this.checkOut = chackOut;	
		return null;
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
