/*     */ package views;
/*     */ import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
import javax.swing.JPasswordField;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.UnsupportedLookAndFeelException;
/*     */ import model.bean.User;
/*     */ import model.dao.UserDAO;
/*     */ 
/*     */ public class Login extends JFrame {
/*     */   User loggedUser;
/*     */   
/*     */   public Login() {
/*  26 */     initComponents();
/*     */   }
/*     */   private JButton jButton1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPasswordField jPasswordField1;
/*     */   private JTextField login;
/*     */   
/*     */   private void initComponents() {
/*  38 */     this.jPanel2 = new JPanel();
/*  39 */     this.jPanel1 = new JPanel();
/*  40 */     this.jLabel1 = new JLabel();
/*  41 */     this.jLabel2 = new JLabel();
/*  42 */     this.login = new JTextField();
/*  43 */     this.jLabel3 = new JLabel();
/*  44 */     this.jButton1 = new JButton();
/*  45 */     this.jPasswordField1 = new JPasswordField();
/*     */     
/*  47 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  48 */     this.jPanel2.setLayout(jPanel2Layout);
/*  49 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  50 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  51 */         .addGap(0, 100, 32767));
/*     */     
/*  53 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  54 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  55 */         .addGap(0, 100, 32767));
/*     */ 
/*     */     
/*  58 */     setDefaultCloseOperation(3);
/*  59 */     setIconImage((new ImageIcon(getClass().getResource("/images/Hospital-Red-icon.png"))).getImage());
/*  60 */     setResizable(false);
/*     */     
/*  62 */     this.jPanel1.setBackground(new Color(4, 60, 60));
/*     */     
/*  64 */     this.jLabel1.setHorizontalAlignment(0);
/*  65 */     this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/images/logo.PNG")));
/*     */     
/*  67 */     this.jLabel2.setFont(new Font("Segoe UI Semibold", 0, 14));
/*  68 */     this.jLabel2.setForeground(new Color(255, 255, 255));
/*  69 */     this.jLabel2.setText("Usuário");
/*     */     
/*  71 */     this.login.setFont(new Font("Segoe UI Light", 0, 14));
/*  72 */     this.login.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  74 */             Login.this.loginActionPerformed(evt);
/*     */           }
/*     */         });
/*  77 */     this.login.addKeyListener(new KeyAdapter() {
/*     */           public void keyPressed(KeyEvent evt) {
/*  79 */             Login.this.loginKeyPressed(evt);
/*     */           }
/*     */         });
/*     */     
/*  83 */     this.jLabel3.setFont(new Font("Segoe UI Semibold", 0, 14));
/*  84 */     this.jLabel3.setForeground(new Color(255, 255, 255));
/*  85 */     this.jLabel3.setText("Senha");
/*     */     
/*  87 */     this.jButton1.setFont(new Font("Segoe UI Semibold", 0, 18));
/*  88 */     this.jButton1.setText("ENTRAR");
/*  89 */     this.jButton1.setCursor(new Cursor(12));
/*  90 */     this.jButton1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/*  92 */             Login.this.jButton1ActionPerformed(evt);
/*     */           }
/*     */         });
/*  95 */     this.jButton1.addKeyListener(new KeyAdapter() {
/*     */           public void keyPressed(KeyEvent evt) {
/*  97 */             Login.this.jButton1KeyPressed(evt);
/*     */           }
/*     */         });
/*     */     
/* 101 */     this.jPasswordField1.setFont(new Font("Segoe UI Light", 0, 14));
/* 102 */     this.jPasswordField1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 104 */             Login.this.jPasswordField1ActionPerformed(evt);
/*     */           }
/*     */         });
/* 107 */     this.jPasswordField1.addKeyListener(new KeyAdapter() {
/*     */           public void keyPressed(KeyEvent evt) {
/* 109 */             Login.this.jPasswordField1KeyPressed(evt);
/*     */           }
/*     */         });
/*     */     
/* 113 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 114 */     this.jPanel1.setLayout(jPanel1Layout);
/* 115 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 116 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 117 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 118 */           .addGap(30, 30, 30)
/* 119 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 120 */             .addGroup(jPanel1Layout.createSequentialGroup()
/* 121 */               .addComponent(this.jLabel3)
/* 122 */               .addContainerGap(-1, 32767))
/* 123 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
/* 124 */               .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 125 */                 .addComponent(this.jPasswordField1, GroupLayout.Alignment.LEADING)
/* 126 */                 .addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -1, 303, 32767)
/* 127 */                 .addComponent(this.login, GroupLayout.Alignment.LEADING)
/* 128 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
/* 129 */                   .addComponent(this.jLabel2)
/* 130 */                   .addGap(0, 0, 32767))
/* 131 */                 .addComponent(this.jButton1, -1, -1, 32767))
/* 132 */               .addGap(30, 30, 30)))));
/*     */     
/* 134 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 135 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 136 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 137 */           .addGap(26, 26, 26)
/* 138 */           .addComponent(this.jLabel1)
/* 139 */           .addGap(32, 32, 32)
/* 140 */           .addComponent(this.jLabel2)
/* 141 */           .addGap(16, 16, 16)
/* 142 */           .addComponent(this.login, -2, 38, -2)
/* 143 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 144 */           .addComponent(this.jLabel3)
/* 145 */           .addGap(16, 16, 16)
/* 146 */           .addComponent(this.jPasswordField1, -2, 38, -2)
/* 147 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, 32767)
/* 148 */           .addComponent(this.jButton1, -2, 44, -2)
/* 149 */           .addGap(41, 41, 41)));
/*     */ 
/*     */     
/* 152 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 153 */     getContentPane().setLayout(layout);
/* 154 */     layout.setHorizontalGroup(layout
/* 155 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 156 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*     */     
/* 158 */     layout.setVerticalGroup(layout
/* 159 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 160 */         .addGroup(layout.createSequentialGroup()
/* 161 */           .addComponent(this.jPanel1, -2, -1, -2)
/* 162 */           .addGap(0, 0, 32767)));
/*     */ 
/*     */     
/* 165 */     pack();
/* 166 */     setLocationRelativeTo(null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void loginActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */   
/*     */   private void loginKey() {
/* 175 */     UserDAO ud = new UserDAO();
/* 176 */     String loginValue = this.login.getText();
/* 177 */     String passwordValue = this.jPasswordField1.getText();
/*     */     
/* 179 */     if (this.login.getText().trim().isEmpty() || this.jPasswordField1
/* 180 */       .getText().trim().isEmpty()) {
/* 181 */       JOptionPane.showMessageDialog(null, "Preencha Os Campos em Vazio!");
/*     */     } else {
/* 183 */       boolean result = ud.checkUserByLoginAndPassword(loginValue, passwordValue);
/*     */       
/* 185 */       if (result == true) {
/* 186 */         User user = ud.getUserLogged(loginValue, passwordValue);
/*     */         
/* 188 */         if (user.getAccess_type().toLowerCase().equals("bloqueado")) {
/* 189 */           JOptionPane.showMessageDialog(null, "O seu Acesso Foi Bloqueado, Contacte o Adiministrador para Desbloquear");
/*     */         }
/* 191 */         else if (user.getAccess_type().toLowerCase().equals("normal")) {
/*     */           
/* 193 */           mainWindow mh = new mainWindow();
/* 194 */           mh.setVisible(true);
/* 195 */           mh.normalView();
/* 196 */           mh.setActualUser(user);
/* 197 */           dispose();
/* 198 */         } else if (user.getAccess_type().toLowerCase().equals("admin")) {
/*     */           
/* 200 */           mainWindow mh = new mainWindow();
/* 201 */           mh.setVisible(true);
/* 202 */           mh.setActualUser(user);
/* 203 */           dispose();
/*     */         } 
/*     */       } else {
/* 206 */         JOptionPane.showMessageDialog(null, "Senha Ou Password Incorreto");
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 212 */     loginKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void jPasswordField1ActionPerformed(ActionEvent evt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void jButton1KeyPressed(KeyEvent evt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   private void jPasswordField1KeyPressed(KeyEvent evt) {
/* 227 */     if (evt.getKeyCode() == 10) {
/* 228 */       loginKey();
/*     */     }
/* 230 */     if (evt.getKeyCode() == 38) {
/* 231 */       this.login.requestFocus(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void loginKeyPressed(KeyEvent evt) {
/* 237 */     if (evt.getKeyCode() == 10) {
/* 238 */       loginKey();
/*     */     }
/* 240 */     if (evt.getKeyCode() == 40) {
/* 241 */       this.jPasswordField1.requestFocus(true);
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
/* 255 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
/* 256 */         if ("Nimbus".equals(info.getName())) {
/* 257 */           UIManager.setLookAndFeel(info.getClassName());
/*     */           break;
/*     */         } 
/*     */       } 
/* 261 */     } catch (ClassNotFoundException ex) {
/* 262 */       Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 263 */     } catch (InstantiationException ex) {
/* 264 */       Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 265 */     } catch (IllegalAccessException ex) {
/* 266 */       Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 267 */     } catch (UnsupportedLookAndFeelException ex) {
/* 268 */       Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 274 */     EventQueue.invokeLater(new Runnable() {
/*     */           public void run() {
/* 276 */             (new Login()).setVisible(true);
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/views/Login.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */