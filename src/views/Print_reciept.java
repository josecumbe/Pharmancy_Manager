/*     */ package views;
/*     */ 
/*     */ import java.awt.Cursor;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.print.PrinterException;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ 
/*     */ public class Print_reciept extends JFrame {
/*     */   private JButton jButton1;
/*     */   
/*     */   public Print_reciept() {
/*  23 */     initComponents();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private JScrollPane jScrollPane1;
/*     */ 
/*     */   
/*     */   public JTextArea jTextArea1;
/*     */ 
/*     */ 
/*     */   
/*     */   private void initComponents() {
/*  36 */     this.jScrollPane1 = new JScrollPane();
/*  37 */     this.jTextArea1 = new JTextArea();
/*  38 */     this.jButton1 = new JButton();
/*     */     
/*  40 */     setDefaultCloseOperation(2);
/*  41 */     setTitle("Imprimir Fatura");
/*  42 */     setCursor(new Cursor(0));
/*  43 */     setResizable(false);
/*     */     
/*  45 */     this.jTextArea1.setColumns(20);
/*  46 */     this.jTextArea1.setFont(new Font("Calibri", 0, 10));
/*  47 */     this.jTextArea1.setRows(5);
/*  48 */     this.jTextArea1.setToolTipText("");
/*  49 */     this.jScrollPane1.setViewportView(this.jTextArea1);
/*     */     
/*  51 */     this.jButton1.setText("IMPRIMIR");
/*  52 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  54 */             Print_reciept.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*     */     
/*  58 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  59 */     getContentPane().setLayout(layout);
/*  60 */     layout.setHorizontalGroup(layout
/*  61 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  62 */         .addGroup(layout.createSequentialGroup()
/*  63 */           .addContainerGap()
/*  64 */           .addComponent(this.jButton1, -1, -1, 32767)
/*  65 */           .addContainerGap())
/*  66 */         .addGroup(layout.createSequentialGroup()
/*  67 */           .addGap(48, 48, 48)
/*  68 */           .addComponent(this.jScrollPane1, -2, 189, -2)
/*  69 */           .addContainerGap(58, 32767)));
/*     */     
/*  71 */     layout.setVerticalGroup(layout
/*  72 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  73 */         .addGroup(layout.createSequentialGroup()
/*  74 */           .addGap(19, 19, 19)
/*  75 */           .addComponent(this.jScrollPane1, -1, 416, 32767)
/*  76 */           .addGap(18, 18, 18)
/*  77 */           .addComponent(this.jButton1, -2, 35, -2)
/*  78 */           .addContainerGap()));
/*     */ 
/*     */     
/*  81 */     pack();
/*  82 */     setLocationRelativeTo(null);
/*     */   }
/*     */ 
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/*     */     try {
/*  88 */       this.jTextArea1.print();
/*  89 */     } catch (PrinterException ex) {
/*  90 */       Logger.getLogger(Print_reciept.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*     */     try {
/* 104 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
/* 105 */         if ("Nimbus".equals(info.getName())) {
/* 106 */           UIManager.setLookAndFeel(info.getClassName());
/*     */           break;
/*     */         } 
/*     */       } 
/* 110 */     } catch (ClassNotFoundException ex) {
/* 111 */       Logger.getLogger(Print_reciept.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 112 */     } catch (InstantiationException ex) {
/* 113 */       Logger.getLogger(Print_reciept.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 114 */     } catch (IllegalAccessException ex) {
/* 115 */       Logger.getLogger(Print_reciept.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 116 */     } catch (UnsupportedLookAndFeelException ex) {
/* 117 */       Logger.getLogger(Print_reciept.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 122 */     EventQueue.invokeLater(new Runnable() {
/*     */           public void run() {
/* 124 */             (new Print_reciept()).setVisible(true);
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/views/Print_reciept.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */