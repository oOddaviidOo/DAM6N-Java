/*    */ package hundir.la.flota;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Barco_mediano
/*    */ {
/*    */   private int tamañoBarcoX;
/*    */   private int tamañoBarcoY;
/*    */   private ArrayList<Punto> puntosBarcoGrande;
/*    */   
/*    */   public Barco_mediano(int tamañoBarcoX, int tamañoBarcoY, ArrayList<Punto> puntosBarcoGrande) {
/* 12 */     this.tamañoBarcoX = tamañoBarcoX;
/* 13 */     this.tamañoBarcoY = tamañoBarcoY;
/* 14 */     this.puntosBarcoGrande = puntosBarcoGrande;
/*    */   }
/*    */   
/*    */   public ArrayList<Punto> coordenadasBarco() {
/* 18 */     ArrayList<Punto> puntosBarcoMediano = new ArrayList<>();
/* 19 */     boolean puntosCorrectos = false;
/*    */     
/* 21 */     while (!puntosCorrectos) {
/* 22 */       puntosCorrectos = true;
/*    */       
/* 24 */       int xInicial = (int)(Math.random() * (800 - this.tamañoBarcoX));
/* 25 */       int yInicial = (int)(Math.random() * (550 - this.tamañoBarcoY));
/*    */       
/* 27 */       Punto A = new Punto(xInicial, yInicial);
/* 28 */       Punto B = new Punto(xInicial + this.tamañoBarcoX, yInicial);
/* 29 */       Punto C = new Punto(xInicial + this.tamañoBarcoX, yInicial + this.tamañoBarcoY);
/* 30 */       Punto D = new Punto(xInicial, yInicial + this.tamañoBarcoY);
/*    */ 
/*    */ 
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
/* 54 */       if (puntosCorrectos == true) {
/* 55 */         puntosBarcoMediano.add(A);
/* 56 */         puntosBarcoMediano.add(B);
/* 57 */         puntosBarcoMediano.add(C);
/* 58 */         puntosBarcoMediano.add(D);
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 64 */     return puntosBarcoMediano;
/*    */   }
/*    */ }


/* Location:              F:\Repositorio Clase\Interfaces\Soluciones y jar de Boris\Hundir_la_flota.jar!\hundir\la\flota\Barco_mediano.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.1
 */