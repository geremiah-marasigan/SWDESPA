import java.util.*;

public abstract class Observer{
	public abstract void update();
	public void main(String[] args){
		Subject s;
		ArrayList<MobileApp> = ma;
		ArrayList<WebApp> = wa;
		Scanner sc = new Scanner(System.in);
		while (True){
			System.out.println("Welcome to DOTC Metro Cebu Navigator! \n [1] Add Mobile App \n [2] Add Web App \n [3] Update Northbound of a Road \n [4] Update Southbound of a Road \n");
			int input = sc.nextInt();
			switch(input){
				case 1: System.out.println("New Mobile app " + (ma.size() + 1));
						ma.add(new MobileApp());
						break;
				case 2: System.out.println("New Web app " + (wa.size() + 1));
						wa.add(new WebApp());
						break;
				case 3: System.out.println("What NB road? \n [1] Osmena Boulevard \n [2] Colon \n [3] V. Rama \n [4] Marcelo Fernan Bridge \n [5] Mactan-Mandaue Bridge \n");
						input = sc.nextInt();
						switch(input){
							case 1: Road r = s.getRoad("Osmena Boulevard");
									System.out.println("What information? \n [1] Traffic Condition \n [2] Traffic Advisory \n");
									input = sc.nextInt();
									switch(input){
										case 1: System.out.println("How is the traffic? \n [1] Heavy \n [2] Medium \n [3] Light \n");
									}
						}
			}
		}
	}
}