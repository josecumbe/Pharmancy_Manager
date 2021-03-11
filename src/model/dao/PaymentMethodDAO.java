/*     */ package model.dao;
/*     */ 
/*     */ import db_connection.ConnectionFactory;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import model.bean.PaymentMethod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PaymentMethodDAO
/*     */ {
/*  24 */   private Connection con = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean savePaymentMethod(PaymentMethod pMethod) {
/*  30 */     this.con = ConnectionFactory.getConnection();
/*     */     
/*  32 */     PreparedStatement stmt = null;
/*  33 */     String sql = "INSERT INTO payment_method (order_id, money_paid, method, sub_method) VALUES (?,?,?,?)";
/*     */     
/*     */     try {
/*  36 */       stmt = this.con.prepareStatement(sql);
/*     */       
/*  38 */       stmt.setInt(1, pMethod.getOrder().getOrder_id());
/*  39 */       stmt.setDouble(2, pMethod.getMoney_paid());
/*  40 */       stmt.setString(3, pMethod.getMethod());
/*  41 */       stmt.setString(4, pMethod.getSub_method());
/*     */       
/*  43 */       stmt.executeUpdate();
/*     */       
/*  45 */       return true;
/*  46 */     } catch (SQLException ex) {
/*  47 */       System.err.println("Error: " + ex);
/*  48 */       return false;
/*     */     } finally {
/*  50 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void removeOrderPMByID(int order_id) {
/*  55 */     this.con = ConnectionFactory.getConnection();
/*     */     
/*  57 */     PreparedStatement stmt = null;
/*  58 */     String sql = "DELETE FROM payment_method WHERE order_id =?";
/*     */     
/*     */     try {
/*  61 */       stmt = this.con.prepareStatement(sql);
/*  62 */       stmt.setInt(1, order_id);
/*  63 */       stmt.executeUpdate();
/*  64 */     } catch (SQLException ex) {
/*  65 */       System.out.println("Error: " + ex);
/*     */     } finally {
/*  67 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<PaymentMethod> getPaymentMethods(int order_id) {
/*  73 */     this.con = ConnectionFactory.getConnection();
/*     */     
/*  75 */     List<PaymentMethod> listOfOrdersDetails = new ArrayList<>();
/*  76 */     PreparedStatement stmt = null;
/*  77 */     ResultSet rs = null;
/*  78 */     String sql = "SELECT * FROM payment_method WHERE order_id=?";
/*     */     
/*     */     try {
/*  81 */       stmt = this.con.prepareStatement(sql);
/*  82 */       stmt.setInt(1, order_id);
/*  83 */       rs = stmt.executeQuery();
/*     */       
/*  85 */       StockDAO sd = new StockDAO();
/*  86 */       while (rs.next())
/*     */       {
/*  88 */         PaymentMethod pm = new PaymentMethod();
/*     */         
/*  90 */         pm.setMethod(rs.getString("method"));
/*  91 */         pm.setSub_method(rs.getString("sub_method"));
/*  92 */         pm.setMoney_paid(rs.getDouble("money_paid"));
/*     */         
/*  94 */         listOfOrdersDetails.add(pm);
/*     */       }
/*     */     
/*  97 */     } catch (SQLException ex) {
/*  98 */       System.err.println("Error: " + ex);
/*     */     } finally {
/* 100 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/* 102 */     return listOfOrdersDetails;
/*     */   }
/*     */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/dao/PaymentMethodDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */