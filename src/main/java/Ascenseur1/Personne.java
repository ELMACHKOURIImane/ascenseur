/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ascenseur1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Personne implements Runnable  {
    
    private int Etage ; 
    private int numeroP ; 
    private Asenceur ascenseur ;

    public Personne(int Etage, Asenceur As , int numeroP) {
        this.Etage = Etage;
        this.ascenseur = As ; 
        this.numeroP = numeroP ;   
    }
public void appel(){
System.out.println("La personne "+numeroP+" appele l'ascenseur");
}
    public int getEtage() {
        return Etage;
    }

    @Override
    public void run() {
         this.appel();
    try { 
        Thread.sleep((long) (5000*Math.random()));
    } catch (InterruptedException ex) {
        Logger.getLogger(Asenceur.class.getName()).log(Level.SEVERE, null, ex);
    }
    this.ascenseur.acceptAppel(this);
    this.ascenseur.Mouve(this);
    }
    public int goTo(int etage)
	{
		int yEtage = 0;
		switch(etage)
		{
			case 1 :
				yEtage = 378;
				break;
			case 2 :
				yEtage = 285;
				break;
			case 3 :
				yEtage = 192;
				break;
			case 4 :
				yEtage = 99;
				break;
			case 5 :
				yEtage = 6;
				break;
		}
		return yEtage;
	}
public static void main(String[] agrs){
//       Asenceur As = new Asenceur(5 , 1 );
//    Personne p = new Personne(3 , As , 2) ;
//    Personne p1 = new Personne(2 , As, 1) ;
//    Thread Th = new Thread(p) ;
//    Thread Th1 = new Thread(p1) ;
//    Th.start();
//    Th1.start();
     
}  

    
    
}
