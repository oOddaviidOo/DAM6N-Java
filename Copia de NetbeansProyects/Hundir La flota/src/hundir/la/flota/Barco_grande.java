/*    */ package hundir.la.flota;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Barco_grande
/*    */ {
/*    */   private int tamañoBarcoX;
/*    */   private int tamañoBarcoY;
/*    */   
/*    */   public Barco_grande(int tamañoBarcoX, int tamañoBarcoY) {
/* 11 */     this.tamañoBarcoX = tamañoBarcoX;
/* 12 */     this.tamañoBarcoY = tamañoBarcoY;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ArrayList<Punto> coordenadasBarco() {
/* 18 */     ArrayList<Punto> puntosBarcoGrande = new ArrayList<>();
/*    */     
/* 20 */     int xInicial = (int)(Math.random() * (800 - this.tamañoBarcoX));
/* 21 */     int yInicial = (int)(Math.random() * (550 - this.tamañoBarcoY));
/*    */     
/* 23 */     Punto A = new Punto(xInicial, yInicial);
/* 24 */     Punto B = new Punto(xInicial + this.tamañoBarcoX, yInicial);
/* 25 */     Punto C = new Punto(xInicial + this.tamañoBarcoX, yInicial + this.tamañoBarcoY);
/* 26 */     Punto D = new Punto(xInicial, yInicial + this.tamañoBarcoY);
/*    */     
/* 28 */     puntosBarcoGrande.add(A);
/* 29 */     puntosBarcoGrande.add(B);
/* 30 */     puntosBarcoGrande.add(C);
/* 31 */     puntosBarcoGrande.add(D);
/*    */     
/* 33 */     return puntosBarcoGrande;
/*    */   }
/*    */ }


/* Location:              F:\Repositorio Clase\Interfaces\Soluciones y jar de Boris\Hundir_la_flota.jar!\hundir\la\flota\Barco_grande.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.1
 */