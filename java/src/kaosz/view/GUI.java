/*    */ package kaosz.view;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.SwingUtilities;
/*    */ 
/*    */ public class GUI
/*    */ {
/*    */   private JFrame window;
/*    */   public JPanel panel;
/*    */ 
public void startGUI() {
	//A GUI kirajzol�s�ra �s az azon t�rt�n� esem�nyek kezel�s�re a Java egy k�l�n sz�lat haszn�l.
	//Ezen a sz�lon ind�tjuk el a createAndShowGUI() met�dust. 
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            createAndShowGUI();
        }
    });
}
/*    */ 
/*    */   private void createAndShowGUI()
/*    */   {
/* 30 */     this.window = new JFrame("Káosz karakter generátor");
/* 31 */     this.window.setDefaultCloseOperation(3);
/*    */ 
/* 33 */     GUIControl guiControl = new GUIControl(this);
/* 34 */     guiControl.setFajokPanel();
/*    */ 
/* 36 */     this.window.setSize(600, 600);
/* 37 */     this.window.setVisible(true);
/*    */   }
/*    */ 
/*    */   public void setActualContent(Container c) {
/* 41 */     this.window.setContentPane(c);
/* 42 */     this.window.setVisible(true);
/*    */   }
/*    */ 
/*    */   public JFrame getWindow() {
/* 46 */     return this.window;
/*    */   }
/*    */ }

/* Location:           D:\szerepjáték\kaosz\kaosz karakter generator\
 * Qualified Name:     kaosz.view.GUI
 * JD-Core Version:    0.5.4
 */