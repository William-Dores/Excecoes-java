package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		/* SEGUNDA SOLUÇÃO DE TRATAMENTO DE ERRO DE FORMA RUIM, COM O TRATAMENTO SENDO DELEGADO PARA A CLASSE RESERVA RETORNANDO UM METODO STRING*/
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		try {
			System.out.print("Numero do quarto: ");
			int numQuarto = sc.nextInt();
			System.out.print("Data de check-in (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de check-out (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
		
		
			Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva");
			System.out.print("Data de check-in (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de check-out (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			
			reserva.updateData(checkIn, checkOut);
			System.out.println(reserva);
		}
		catch (ParseException e) {
			System.out.println("Data informada invalida: ");
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva: "+ e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inexperado! ");
		}
	
		sc.close();
	}

}
