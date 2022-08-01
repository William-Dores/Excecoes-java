package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		/* SEGUNDA SOLUÇÃO DE TRATAMENTO DE ERRO DE FORMA RUIM, COM O TRATAMENTO SENDO DELEGADO PARA A CLASSE RESERVA RETORNANDO UM METODO STRING*/
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int numQuarto = sc.nextInt();
		System.out.print("Data de check-in (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de check-out (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (! checkOut.after(checkIn)) { 
			System.out.print("Erro na reservar: Data do check-out antes da data de Check-in");		
		}
		else {
			Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva");
			System.out.print("Data de check-in (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de check-out (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			
			String erro = reserva.updateData(checkIn, checkOut);
			if (erro != null) {
				System.out.println("Erro na reserva: "+erro);
			}
			else {
			System.out.println(reserva);
			}
		}
		sc.close();
	}

}
