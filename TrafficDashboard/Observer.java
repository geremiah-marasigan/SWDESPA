                                                                                                                                                                                  
import java.util.*;                                                                                                                                                                   
                                                                                                                                                                                      
public abstract class Observer{                                                                                                                                                       
	protected Subject subject;                                                                                                                                                        
	protected int id;                                                                                                                                                                 
	public abstract void update();                                                                                                                                                    
	public static void main(String[] args){                                                                                                                                           
		Subject subject = new Subject();                                                                                                                                              
		int mobileAppNo = 0;                                                                                                                                                          
		int webAppNo = 0;                                                                                                                                                             
		String tempRoad;                                                                                                                                                              
		Scanner sc = new Scanner(System.in);                                                                                                                                          
		subject.init();                                                                                                                                                               
		while (true){                                                                                                                                                                 
			System.out.println("Welcome to DOTC Metro Cebu Navigator! \n[1] Add Mobile App \n[2] Add Web App \n[3] Update Northbound of a Road \n[4] Update Southbound of a Road \n");
			int input = sc.nextInt();                                                                                                                                                 
			switch(input){                                                                                                                                                            
				case 1: System.out.println("New Mobile app " + (mobileAppNo+1));                                                                                                      
						mobileAppNo++;                                                                                                                                                
						new MobileApp(subject, mobileAppNo);                                                                                                                          
						break;                                                                                                                                                        
				case 2: System.out.println("New Web app " + (webAppNo + 1));                                                                                                          
						webAppNo++;                                                                                                                                                   
						new WebApp(subject, webAppNo);                                                                                                                                
						break;                                                                                                                                                        
				case 3: System.out.println("What NB road? \n[1] Osmena Boulevard \n[2] Colon \n[3] V. Rama \n[4] Marcelo Fernan Bridge \n[5] Mactan-Mandaue Bridge \n");              
						input = sc.nextInt();                                                                                                                                         
						tempRoad = "";                                                                                                                                                
						switch(input){                                                                                                                                                
							case 1: tempRoad = RoadName.Osmena.toString(); break;                                                                                                     
							case 2: tempRoad = RoadName.Colon.toString(); break;                                                                                                      
							case 3: tempRoad = RoadName.V.toString(); break;                                                                                                          
							case 4: tempRoad = RoadName.Marcelo.toString(); break;                                                                                                    
							case 5: tempRoad = RoadName.Mactan.toString(); break;                                                                                                     
						}                                                                                                                                                             
						System.out.println("What information? \n [1] Traffic Condition \n [2] Traffic Advisory \n");                                                                  
						input = sc.nextInt();                                                                                                                                         
						switch(input){                                                                                                                                                
							case 1: System.out.println("How is the traffic? \n[1] Heavy \n[2] Medium \n[3] Light \n");                                                                
									input = sc.nextInt();                                                                                                                             
									switch(input){                                                                                                                                    
											case 1: subject.getRoad(tempRoad).setNorthB("Heavy"); break;                                                                              
											case 2: subject.getRoad(tempRoad).setNorthB("Medium"); break;                                                                             
											case 3: subject.getRoad(tempRoad).setNorthB("Light"); break;                                                                              
											}                                                                                                                                         
											break;                                                                                                                                    
													                                                                                                                                  
							case 2: System.out.println("What advisory would you give? \n[1] Accident \n[2] Flood \n[3] Road Repair \n[4] Road Blocking");                             
									input = sc.nextInt();                                                                                                                             
									switch(input){                                                                                                                                    
											case 1: subject.getRoad(tempRoad).setNorthA("Accident"); break;                                                                           
											case 2: subject.getRoad(tempRoad).setNorthA("Flood"); break;                                                                              
											case 3: subject.getRoad(tempRoad).setNorthA("Road Repair"); break;                                                                        
											case 4: subject.getRoad(tempRoad).setNorthA("Road Blocking"); break;                                                                      
											case 5: subject.getRoad(tempRoad).setSouthA("");                                                                                          
											}                                                                                                                                         
											break;                                                                                                                                    
						}                                                                                                                                                             
						break;                                                                                                                                                        
				case 4: System.out.println("What SB road? \n[1] Osmena Boulevard \n[2] Colon \n[3] V. Rama \n[4] Marcelo Fernan Bridge \n[5] Mactan-Mandaue Bridge \n");              
						input = sc.nextInt();                                                                                                                                         
						tempRoad = "";                                                                                                                                                
						switch(input){                                                                                                                                                
							case 1: tempRoad = RoadName.Osmena.toString(); break;                                                                                                     
							case 2: tempRoad = RoadName.Colon.toString(); break;                                                                                                      
							case 3: tempRoad = RoadName.V.toString(); break;                                                                                                          
							case 4: tempRoad = RoadName.Marcelo.toString(); break;                                                                                                    
							case 5: tempRoad = RoadName.Mactan.toString(); break;                                                                                                     
						}                                                                                                                                                             
						System.out.println("What information? \n [1] Traffic Condition \n [2] Traffic Advisory \n");                                                                  
						input = sc.nextInt();                                                                                                                                         
						switch(input){                                                                                                                                                
							case 1: System.out.println("How is the traffic? \n[1] Heavy \n[2] Medium \n[3] Light \n");                                                                
									input = sc.nextInt();                                                                                                                             
									switch(input){                                                                                                                                    
											case 1: subject.getRoad(tempRoad).setSouthB(Traffic.Heavy.toString()); break;                                                             
											case 2: subject.getRoad(tempRoad).setSouthB(Traffic.Medium.toString()); break;                                                            
											case 3: subject.getRoad(tempRoad).setSouthB(Traffic.Light.toString()); break;                                                             
											}                                                                                                                                         
											break;                                                                                                                                    
													                                                                                                                                  
							case 2: System.out.println("What advisory would you give? \n[1] Accident \n[2] Flood \n[3] Road Repair \n[4] Road Blocking \n[5] Remove Advisory");       
									input = sc.nextInt();                                                                                                                             
									switch(input){                                                                                                                                    
											case 1: subject.getRoad(tempRoad).setSouthA(Advisory.Accident.toString()); break;                                                         
											case 2: subject.getRoad(tempRoad).setSouthA(Advisory.Flood.toString()); break;                                                            
											case 3: subject.getRoad(tempRoad).setSouthA(Advisory.RoadRepair.toString()); break;                                                       
											case 4: subject.getRoad(tempRoad).setSouthA(Advisory.RoadBlocking.toString()); break;                                                     
											case 5: subject.getRoad(tempRoad).setSouthA(Advisory.None.toString());                                                                    
											}                                                                                                                                         
											break;                                                                                                                                    
						}                                                                                                                                                             
			}                                                                                                                                                                         
			subject.updateAllObservers();                                                                                                                                             
		}                                                                                                                                                                             
	}                                                                                                                                                                                 
}                                                                                                                                                                                     
                                                                                                                                                                                      