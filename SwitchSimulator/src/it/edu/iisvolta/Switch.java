package it.edu.iisvolta;

public class Switch {
	private String[] porte=new String[5];		//memorizza i mac address per ogni porta
	private String[] messaggi=new String[5];
	private int stato;
	
	public Switch() {		//costruttore
		for(int i=0;i<5;i++) {
			porte[i]="";
			messaggi[i]="";
		}
		stato=0;		//spento			
	}
	
	public void accendi() {
		if (stato==0)
			stato=1;
		else
			System.out.println("Switch già acceso!");
	}
	
	public void spegni() {
		if (stato==1)
			stato=0;
		else
			System.out.println("Switch già spento!");
	}
	
	public void invia(
		int porta, String macAddressSrc, String macAddressDst, 
		String messaggio) {
		if (stato==0) 
			System.out.println("Lo switch deve essere acceso!"); 
		else if (porta<0 || porta>4)
			System.out.println("Porta non valida!");
		else {
			if (!porte[porta].isEmpty() &&				//la porta di ingresso non è vuota
				!porte[porta].equals(macAddressSrc))		//sulla porta di ingresso c'è un mac address diverso da macAddressSrc
				System.out.println("MAC address sorgente non valido!");
			else if (porte[porta].isEmpty())	//se la porta di ingresso non è valorizzata 
				porte[porta]=macAddressSrc;	//memorizzo il mac sorgente nella porta di ingresso
			
			//cerco nel vettore delle porte il mac destinazione
			int pos=-1;
			for(int i=0;i<5;i++)
				if(porte[i].equals(macAddressDst))
					pos=i;		//memorizzo la posizione in cui l'ho trovato
			
			if (pos<0) {			//il mac destinazione non è presente nella tabella
				//mando il messaggio su tutte le porte tranne quella di ingresso
				for(int i=0;i<5;i++)
					if (i!=porta)
						messaggi[i]=messaggio;
			} else {		//il mac destinazione è presente nella tabella
				//mando il messaggio solo sulla porta corrispondente al mac destinazione
				messaggi[pos]=messaggio;			
			}
		}
			
	}
	
	public String getStato() {
		if (stato==0)
			return "SPENTO";
		else
			return "ACCESO";
	}
	
	public String getMacAddress(int porta) {
		return porte[porta];
	}
	
	public String getMessage(int porta) {
		return messaggi[porta];
	}

}
