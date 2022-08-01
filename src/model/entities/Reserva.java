package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}

	public Reserva(Integer numQuarto, Date checkIn, Date checkOut) throws DomainException{
		if (!checkOut.after(checkIn)) { 
			throw new DomainException("Data de check-out anterior a data de check-in");
		}
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
		long diferenca = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
		
	}
	
	public void updateData(Date checkIn, Date chackOut) throws DomainException{
		
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			throw new DomainException("Data do check-out antes da data futura do check-in");			
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Data de check-out anterior a data de check-in");
		}
		
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
