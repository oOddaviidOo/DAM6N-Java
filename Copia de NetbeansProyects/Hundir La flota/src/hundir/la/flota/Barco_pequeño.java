/*    */ package hundir.la.flota;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Barco_pequeño
/*    */ {
/*    */   private int tamañoBarcoX;
/*    */   private int tamañoBarcoY;
/*    */   private ArrayList<Punto> puntosBarcoGrande;
/*    */   private ArrayList<Punto> puntosBarcoMediano;
/*    */   
/*    */   public Barco_pequeño(int tamañoBarcoX, int tamañoBarcoY, ArrayList<Punto> puntosBarcoGrande, ArrayList<Punto> puntosBarcoMediano) {
/* 13 */     this.tamañoBarcoX = tamañoBarcoX;
/* 14 */     this.tamañoBarcoY = tamañoBarcoY;
/* 15 */     this.puntosBarcoGrande = puntosBarcoGrande;
/* 16 */     this.puntosBarcoMediano = puntosBarcoMediano;
/*    */   }
/*    */   
/*    */   public ArrayList<Punto> coordenadasBarco() {
/* 20 */     ArrayList<Punto> puntosBarcoPequeño = new ArrayList<>();
/* 21 */     boolean puntosCorrectos = false;
/*    */     
/* 23 */     while (!puntosCorrectos) {
/* 24 */       puntosCorrectos = true;
/*    */       
/* 26 */       int xInicial = (int)(Math.random() * (800 - this.tamañoBarcoX));
/* 27 */       int yInicial = (int)(Math.random() * (550 - this.tamañoBarcoY));
/*    */       
/* 29 */       Punto A = new Punto(xInicial, yInicial);
/* 30 */       Punto B = new Punto(xInicial + this.tamañoBarcoX, yInicial);
/* 31 */       Punto C = new Punto(xInicial + this.tamañoBarcoX, yInicial + this.tamañoBarcoY);
/* 32 */       Punto D = new Punto(xInicial, yInicial + this.tamañoBarcoY);
/*    */       
/* 34 */       if (A.getX() > ((Punto)this.puntosBarcoGrande.get(0)).getX() && A.getX() < ((Punto)this.puntosBarcoGrande.get(2)).getX() && A
/* 35 */         .getY() > ((Punto)this.puntosBarcoGrande.get(0)).getY() && A.getY() < ((Punto)this.puntosBarcoGrande.get(2)).getY()) {
/* 36 */         puntosCorrectos = false;
/*    */       }
/*    */       
/* 39 */       if (B.getX() > ((Punto)this.puntosBarcoGrande.get(0)).getX() && B.getX() < ((Punto)this.puntosBarcoGrande.get(2)).getX() && B
/* 40 */         .getY() > ((Punto)this.puntosBarcoGrande.get(0)).getY() && B.getY() < ((Punto)this.puntosBarcoGrande.get(2)).getY()) {
/* 41 */         puntosCorrectos = false;
/*    */       }
/*    */       
/* 44 */       if (C.getX() > ((Punto)this.puntosBarcoGrande.get(0)).getX() && C.getX() < ((Punto)this.puntosBarcoGrande.get(2)).getX() && C
/* 45 */         .getY() > ((Punto)this.puntosBarcoGrande.get(0)).getY() && C.getY() < ((Punto)this.puntosBarcoGrande.get(2)).getY()) {
/* 46 */         puntosCorrectos = false;
/*    */       }
/*    */       
/* 49 */       if (D.getX() > ((Punto)this.puntosBarcoGrande.get(0)).getX() && D.getX() < ((Punto)this.puntosBarcoGrande.get(2)).getX() && D
/* 50 */         .getY() > ((Punto)this.puntosBarcoGrande.get(0)).getY() && D.getY() < ((Punto)this.puntosBarcoGrande.get(2)).getY()) {
/* 51 */         puntosCorrectos = false;
/*    */       }
/*    */       
/* 54 */       if (A.getX() > ((Punto)this.puntosBarcoMediano.get(0)).getX() && A.getX() < ((Punto)this.puntosBarcoMediano.get(2)).getX() && A
/* 55 */         .getY() > ((Punto)this.puntosBarcoMediano.get(0)).getY() && A.getY() < ((Punto)this.puntosBarcoMediano.get(2)).getY()) {
/* 56 */         puntosCorrectos = false;
/*    */       }
/*    */       
/* 59 */       if (B.getX() > ((Punto)this.puntosBarcoMediano.get(0)).getX() && B.getX() < ((Punto)this.puntosBarcoMediano.get(2)).getX() && B
/* 60 */         .getY() > ((Punto)this.puntosBarcoMediano.get(0)).getY() && B.getY() < ((Punto)this.puntosBarcoMediano.get(2)).getY()) {
/* 61 */         puntosCorrectos = false;
/*    */       }
/*    */       
/* 64 */       if (C.getX() > ((Punto)this.puntosBarcoMediano.get(0)).getX() && C.getX() < ((Punto)this.puntosBarcoMediano.get(2)).getX() && C
/* 65 */         .getY() > ((Punto)this.puntosBarcoMediano.get(0)).getY() && C.getY() < ((Punto)this.puntosBarcoMediano.get(2)).getY()) {
/* 66 */         puntosCorrectos = false;
/*    */       }
/*    */       
/* 69 */       if (D.getX() > ((Punto)this.puntosBarcoMediano.get(0)).getX() && D.getX() < ((Punto)this.puntosBarcoMediano.get(2)).getX() && D
/* 70 */         .getY() > ((Punto)this.puntosBarcoMediano.get(0)).getY() && D.getY() < ((Punto)this.puntosBarcoMediano.get(2)).getY()) {
/* 71 */         puntosCorrectos = false;
/*    */       }
/*    */ 
/*    */       
/* 75 */       if (puntosCorrectos == true) {
/* 76 */         puntosBarcoPequeño.add(A);
/* 77 */         puntosBarcoPequeño.add(B);
/* 78 */         puntosBarcoPequeño.add(C);
/* 79 */         puntosBarcoPequeño.add(D);
/*    */       } 
/*    */     } 
/*    */     
/* 83 */     return puntosBarcoPequeño;
/*    */   }
/*    */ }


/* Location:              F:\Repositorio Clase\Interfaces\Soluciones y jar de Boris\Hundir_la_flota.jar!\hundir\la\flota\Barco_pequeño.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.1
 */