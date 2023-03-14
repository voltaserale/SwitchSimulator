package it.edu.iisvolta;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String scelta;
		Scanner s=new Scanner(System.in);
		Switch sw=new Switch();
		
		do {
			Console.clear();
			stampaSwitch(sw, 70, 3);
			Console.setCursorPosition(1, 1);
			System.out.println("*** SWITCH SIMULATOR ***");
			System.out.println();
			System.out.println("1) accendi");
			System.out.println("2) spegni");
			System.out.println("3) invia");
			System.out.println("4) ricevi");
			System.out.println("9) esci");
			System.out.println();
			System.out.print("Inserisci la tua scelta: ");
			scelta=s.nextLine();
			switch(scelta) {
			case "1":
				sw.accendi();
				break;
			case "2":
				sw.spegni();
				break;
			case "3":
				int porta;
				String macSrc, macDst, msg;
				System.out.print("Inserisci la porta: ");
				porta=Integer.parseInt(s.nextLine());
				System.out.print("Inserisci il MAC sorgente: ");
				macSrc=s.nextLine();
				System.out.print("Inserisci il MAC destinazione: ");
				macDst=s.nextLine();
				System.out.print("Inserisci il messaggio: ");
				msg=s.nextLine();
				sw.invia(porta, macSrc, macDst, msg);
				break;
			case "4":
				break;
			case "9":
				System.out.println("Arrivederci!");
				break;
			default:
				System.out.println("Scelta non valida!");
				break;
			}
			System.out.println();
			System.out.println("Premi Enter per continuare");
			s.nextLine();
		} while (!scelta.equals("9"));
		
		s.close();
	}
	
	public static void stampaSwitch(Switch sw, int posX, int posY) {
		Console.setCursorPosition(posY, posX);
		System.out.println("Stato: "+sw.getStato());
		Console.setCursorPosition(posY+1, posX);
		System.out.println("MAC ADDRESS:");
		for(int i=0;i<5;i++) {
			Console.setCursorPosition(posY+2+i, posX);
			System.out.println(i+": "+sw.getMacAddress(i));
		}
		
		Console.setCursorPosition(posY+7, posX);
		System.out.println("MESSAGGI:");
		for(int i=0;i<5;i++) {
			Console.setCursorPosition(posY+8+i, posX);
			System.out.println(i+": "+sw.getMessage(i));
		}
			
	}

}
