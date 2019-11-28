/*     */ package hundir.la.flota;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class PanelCentral
/*     */   extends JPanel
/*     */   implements MouseListener {
/*     */   JLabel etiquetaDisparosDisponibles;
/*     */   ArrayList<Punto> coordenadasBarcoGrande;
/*     */   ArrayList<Punto> coordenadasBarcoMediano;
/*     */   ArrayList<Punto> coordenadasBarcoPequeño;
/*     */   ArrayList<Punto> bombardeo;
/*     */   int cantidadDisparosDisponibles;
/*     */   int anchuraBarcoGrande;
/*     */   int alturaBarcoGrande;
/*     */   int anchuraBarcoMediano;
/*     */   int alturaBarcoMediano;
/*     */   int anchuraBarcoPequeño;
/*     */   int alturaBarcoPequeño;
/*     */   int impactoX;
/*     */   int impactoY;
/*     */   boolean hundidoGrande;
/*     */   boolean hundidoMediano;
/*     */   boolean hundidoPequeño;
/*     */   
/*     */   public PanelCentral(JLabel etiquetaDisparosDisponibles) {
/*  34 */     this.etiquetaDisparosDisponibles = etiquetaDisparosDisponibles;
/*  35 */     setBackground(Color.BLUE);
/*     */     
/*  37 */     this.bombardeo = new ArrayList<>();
/*     */     
/*  39 */     this.hundidoGrande = false;
/*  40 */     this.hundidoMediano = false;
/*  41 */     this.hundidoPequeño = false;
/*     */     
/*  43 */     this.anchuraBarcoGrande = 250;
/*  44 */     this.alturaBarcoGrande = 150;
/*  45 */     this.anchuraBarcoMediano = 150;
/*  46 */     this.alturaBarcoMediano = 75;
/*  47 */     this.anchuraBarcoPequeño = 100;
/*  48 */     this.alturaBarcoPequeño = 50;
/*     */     
/*  50 */     addMouseListener(this);
/*     */ 
/*     */ 
/*     */     
/*  54 */     this.cantidadDisparosDisponibles = 50;
/*  55 */     etiquetaDisparosDisponibles.setText(this.cantidadDisparosDisponibles + "");
/*     */     
/*  57 */     Barco_grande barcoGrande = new Barco_grande(this.anchuraBarcoGrande, this.alturaBarcoGrande);
/*  58 */     this.coordenadasBarcoGrande = barcoGrande.coordenadasBarco();
/*     */     
/*  60 */     Barco_mediano barcoMediano = new Barco_mediano(this.anchuraBarcoMediano, this.alturaBarcoMediano, this.coordenadasBarcoGrande);
/*  61 */     this.coordenadasBarcoMediano = barcoMediano.coordenadasBarco();
/*     */     
/*  63 */     Barco_pequeño barcoPequeño = new Barco_pequeño(this.anchuraBarcoPequeño, this.alturaBarcoPequeño, this.coordenadasBarcoGrande, this.coordenadasBarcoMediano);
/*  64 */     this.coordenadasBarcoPequeño = barcoPequeño.coordenadasBarco();
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseClicked(MouseEvent e) {
/*  69 */     this.impactoX = (int)e.getPoint().getX();
/*  70 */     this.impactoY = (int)e.getPoint().getY();
/*  71 */     Punto disparo = new Punto(this.impactoX, this.impactoY);
/*     */     
/*  73 */     this.bombardeo.add(disparo);
/*     */     
/*  75 */     if (this.impactoX > ((Punto)this.coordenadasBarcoGrande.get(0)).getX() && this.impactoX < ((Punto)this.coordenadasBarcoGrande.get(1)).getX() && this.impactoY > ((Punto)this.coordenadasBarcoGrande
/*  76 */       .get(0)).getY() && this.impactoY < ((Punto)this.coordenadasBarcoGrande.get(3)).getY() && !this.hundidoGrande) {
/*     */       
/*  78 */       this.cantidadDisparosDisponibles--;
/*  79 */       this.etiquetaDisparosDisponibles.setText(this.cantidadDisparosDisponibles + "");
/*  80 */       this.hundidoGrande = true;
/*     */       
/*  82 */       JOptionPane.showMessageDialog(null, "HAS HUNDIDO EL BARCO GRANDE!!");
/*  83 */       repaint();
/*     */     }
/*  85 */     else if (this.impactoX > ((Punto)this.coordenadasBarcoMediano.get(0)).getX() && this.impactoX < ((Punto)this.coordenadasBarcoMediano.get(1)).getX() && this.impactoY > ((Punto)this.coordenadasBarcoMediano
/*  86 */       .get(0)).getY() && this.impactoY < ((Punto)this.coordenadasBarcoMediano.get(3)).getY() && !this.hundidoMediano) {
/*     */       
/*  88 */       this.cantidadDisparosDisponibles--;
/*  89 */       this.etiquetaDisparosDisponibles.setText(this.cantidadDisparosDisponibles + "");
/*  90 */       this.hundidoMediano = true;
/*     */       
/*  92 */       JOptionPane.showMessageDialog(null, "HAS HUNDIDO EL BARCO MEDIANO!!");
/*  93 */       repaint();
/*     */     }
/*  95 */     else if (this.impactoX > ((Punto)this.coordenadasBarcoPequeño.get(0)).getX() && this.impactoX < ((Punto)this.coordenadasBarcoPequeño.get(1)).getX() && this.impactoY > ((Punto)this.coordenadasBarcoPequeño
/*  96 */       .get(0)).getY() && this.impactoY < ((Punto)this.coordenadasBarcoPequeño.get(3)).getY() && !this.hundidoPequeño) {
/*     */       
/*  98 */       this.cantidadDisparosDisponibles--;
/*  99 */       this.etiquetaDisparosDisponibles.setText(this.cantidadDisparosDisponibles + "");
/* 100 */       this.hundidoPequeño = true;
/* 101 */       JOptionPane.showMessageDialog(null, "HAS HUNDIDO EL BARCO PEQUEÑO!!");
/* 102 */       repaint();
/*     */     } else {
/*     */       
/* 105 */       this.cantidadDisparosDisponibles--;
/* 106 */       this.etiquetaDisparosDisponibles.setText(this.cantidadDisparosDisponibles + "");
/* 107 */       repaint();
/*     */     } 
/*     */     
/* 110 */     if (this.cantidadDisparosDisponibles == 0) {
/* 111 */       JOptionPane.showMessageDialog(null, "HAS PERDIDO");
/* 112 */       System.exit(0);
/*     */     } 
/*     */     
/* 115 */     if (this.hundidoGrande == true && this.hundidoMediano == true && this.hundidoPequeño == true) {
/* 116 */       JOptionPane.showMessageDialog(null, "ENHORABUENA, HAS HUNDIDO TODA LA FLOTA!!!!!");
/* 117 */       System.exit(0);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void paint(Graphics g) {
/* 122 */     super.paint(g);
/* 123 */     if (this.cantidadDisparosDisponibles <= 50)
/*     */     {
/* 125 */       for (int i = 0; i < this.bombardeo.size(); i++) {
/* 126 */         g.setColor(Color.WHITE);
/* 127 */         Punto disparo = this.bombardeo.get(i);
/* 128 */         g.fillArc(disparo.getX() - 4, disparo.getY() - 4, 8, 8, 0, 360);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 134 */     if (this.hundidoGrande == true) {
/* 135 */       g.setColor(Color.RED);
/* 136 */       g.fillRect(((Punto)this.coordenadasBarcoGrande.get(0)).getX(), ((Punto)this.coordenadasBarcoGrande.get(0)).getY(), this.anchuraBarcoGrande, this.alturaBarcoGrande);
/*     */     } 
/* 138 */     if (this.hundidoMediano == true) {
/* 139 */       g.setColor(Color.YELLOW);
/* 140 */       g.fillRect(((Punto)this.coordenadasBarcoMediano.get(0)).getX(), ((Punto)this.coordenadasBarcoMediano.get(0)).getY(), this.anchuraBarcoMediano, this.alturaBarcoMediano);
/*     */     } 
/* 142 */     if (this.hundidoPequeño == true) {
/* 143 */       g.setColor(Color.PINK);
/* 144 */       g.fillRect(((Punto)this.coordenadasBarcoPequeño.get(0)).getX(), ((Punto)this.coordenadasBarcoPequeño.get(0)).getY(), this.anchuraBarcoPequeño, this.alturaBarcoPequeño);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void mousePressed(MouseEvent e) {}
/*     */   
/*     */   public void mouseReleased(MouseEvent e) {}
/*     */   
/*     */   public void mouseEntered(MouseEvent e) {}
/*     */   
/*     */   public void mouseExited(MouseEvent e) {}
/*     */ }


/* Location:              F:\Repositorio Clase\Interfaces\Soluciones y jar de Boris\Hundir_la_flota.jar!\hundir\la\flota\PanelCentral.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.1
 */