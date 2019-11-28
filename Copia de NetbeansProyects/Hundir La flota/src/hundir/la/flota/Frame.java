/*    */ package hundir.la.flota;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Color;
/*    */ import java.awt.FlowLayout;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Frame
/*    */   extends JFrame
/*    */ {
/*    */   BorderLayout layoutBordes;
/*    */   FlowLayout layoutFlotante;
/*    */   JPanel panelInferior;
/*    */   PanelCentral panelCentral;
/*    */   JLabel etiquetaAvisaDisparos;
/*    */   JLabel etiquetaDisparosDisponibles;
/*    */   
/*    */   public Frame() {
/* 23 */     setTitle("SUPER HUNDIR LA FLOTA MAXI");
/* 24 */     setSize(800, 600);
/* 25 */     setDefaultCloseOperation(3);
/* 26 */     setResizable(false);
/*    */     
/* 28 */     this.layoutFlotante = new FlowLayout();
/* 29 */     this.layoutBordes = new BorderLayout();
/* 30 */     this.panelInferior = new JPanel();
/* 31 */     this.etiquetaAvisaDisparos = new JLabel("Disparos Disponibles: ");
/* 32 */     this.etiquetaDisparosDisponibles = new JLabel();
/* 33 */     this.panelCentral = new PanelCentral(this.etiquetaDisparosDisponibles);
/* 34 */     this.panelCentral.setBackground(Color.BLUE);
/*    */     
/* 36 */     this.panelInferior.setLayout(this.layoutFlotante);
/*    */     
/* 38 */     this.panelInferior.add(this.etiquetaAvisaDisparos);
/* 39 */     this.panelInferior.add(this.etiquetaDisparosDisponibles);
/*    */     
/* 41 */     setLayout(this.layoutBordes);
/* 42 */     add(this.panelInferior, "South");
/* 43 */     add(this.panelCentral, "Center");
/*    */   }
/*    */ }


/* Location:              F:\Repositorio Clase\Interfaces\Soluciones y jar de Boris\Hundir_la_flota.jar!\hundir\la\flota\Frame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.1
 */