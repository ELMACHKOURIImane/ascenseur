/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ascenseur2;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author DELL
 */
public class Asenceur extends Thread {
private int placeOcupes =0 ; 
private ArrayList<Personne> personnesIn = new ArrayList<Personne>();
private Asenceur Etages[] ; 
int nbr_Etages ; 
int idAscenseur ; 
int positionActull ; 
private JLabel lblEtage ;
private JRadioButton btnMonter ;
private JRadioButton btnDescender ;
private JRadioButton btnArreter ; 
 
private JRadioButton btnEtages[] ; 

Personne p ; 
    public Asenceur( int nbr_Etages ,int idAscenseur, JLabel lblEtage , JRadioButton Monter , JRadioButton Descender ,JRadioButton []btnEtages , JRadioButton btnArreter ) {
        this.Etages  = new Asenceur[nbr_Etages];
        this.nbr_Etages = nbr_Etages;
        this.positionActull =  1 ;
        this.idAscenseur = idAscenseur ; 
        this.lblEtage = lblEtage ; 
        this.btnMonter = Monter ;
        this.btnDescender =  Descender ; 
        this.btnEtages = btnEtages ;
        this.btnArreter = btnArreter ; 
    }
synchronized boolean acceptAppel(Personne personne ){
    if(this.placeOcupes <4 ){
        personnesIn.add(personne);
        placeOcupes++ ; 
        System.out.format("La distination est %s \n", personne.getEtage());
        return true ; 
    }
    else {
        System.out.println("L'ascenseur est plein ");
        return false ; 
    }
}
synchronized void leaveAscenseur(Personne p){
    this.placeOcupes-- ; 
    personnesIn.remove(p) ; 
    System.out.format("L'ascenseur est dans l'etage %s ", p.getEtage()) ; 
}
synchronized void Mouve(Personne p ){
    while(this.positionActull < p.getEtage() ){ 
        System.out.println("L'ascenseur est entrain de monter ");
        try {
            Thread.sleep((long) (3000*Math.random()));
        } catch (InterruptedException ex) {
            Logger.getLogger(Asenceur.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.lblEtage.setLocation(6,p.goTo(positionActull));
        this.btnEtages[positionActull-1].setSelected(true);
        System.out.println(this); 
       this.Etages[positionActull] = this.Etages[positionActull++] ; 
       btnMonter.setSelected(true);
        try {
            Thread.sleep((long) (3000*Math.random()));
        } catch (InterruptedException ex) {
            Logger.getLogger(Asenceur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        while(this.positionActull > p.getEtage()){
           System.out.println("L'ascenseur est entrain de descendre ");
        try {
            Thread.sleep((long) (3000*Math.random()));
        } catch (InterruptedException ex) {
            Logger.getLogger(Asenceur.class.getName()).log(Level.SEVERE, null, ex);
        }
            this.lblEtage.setLocation(6,p.goTo(positionActull));
           this.btnEtages[positionActull-1].setSelected(true);
            System.out.println(this);
           this.Etages[positionActull] = this.Etages[positionActull--] ;
           btnDescender.setSelected(true);
        try {
            Thread.sleep((long) (3000*Math.random()));
        } catch (InterruptedException ex) {
            Logger.getLogger(Asenceur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       if(this.positionActull == p.getEtage()){
       System.out.println("L'ascenseur est arreter "); 
       this.lblEtage.setLocation(6,p.goTo(positionActull));
        this.btnEtages[positionActull-1].setSelected(true);
        System.out.println(this); 
       this.btnArreter.setSelected(true); 
       this.leaveAscenseur(p);
        } 
    
}
   @Override
    public String toString() {
        return " L'ascenseur numero "+this.idAscenseur+" est dans l'etage "+this.positionActull ; 
    }
}
