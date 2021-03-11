/*     */ package model.dao;
/*     */ 
/*     */ import db_connection.ConnectionFactory;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import model.bean.Drug;
/*     */ import model.bean.OrderDetails;
/*     */ import model.bean.Stock;
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
/*     */ 
/*     */ public class OrderDetailsDAO
/*     */ {
/*  29 */   private Connection con = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveOrderDetails(OrderDetails oDetails) {
/*  34 */     this.con = ConnectionFactory.getConnection();
/*     */     
/*  36 */     PreparedStatement stmt = null;
/*  37 */     String sql = "INSERT INTO order_details (order_id, stock_id, quantity, total_price) VALUES (?,?,?,?)";
/*     */     
/*  39 */     StockDAO sdao = new StockDAO();
/*  40 */     Stock s = sdao.returnStockByDrugId(oDetails.getDrug());
/*     */     
/*     */     try {
/*  43 */       stmt = this.con.prepareStatement(sql);
/*  44 */       stmt.setInt(1, oDetails.getOrder().getOrder_id());
/*  45 */       stmt.setInt(2, s.getStock_id());
/*  46 */       stmt.setDouble(3, oDetails.getQuantity());
/*  47 */       stmt.setDouble(4, oDetails.getTotal_price());
/*  48 */       stmt.executeUpdate();
/*  49 */     } catch (SQLException ex) {
/*  50 */       Logger.getLogger(OrderDetailsDAO.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } finally {
/*  52 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OrderDetails> getOrderDetails(int order_id) {
/*  58 */     this.con = ConnectionFactory.getConnection();
/*     */     
/*  60 */     List<OrderDetails> listOfOrdersDetails = new ArrayList<>();
/*  61 */     PreparedStatement stmt = null;
/*  62 */     ResultSet rs = null;
/*  63 */     String sql = "SELECT * FROM order_details WHERE order_id=?";
/*     */     
/*     */     try {
/*  66 */       stmt = this.con.prepareStatement(sql);
/*  67 */       stmt.setInt(1, order_id);
/*  68 */       rs = stmt.executeQuery();
/*     */       
/*  70 */       StockDAO sd = new StockDAO();
/*  71 */       while (rs.next())
/*     */       {
/*  73 */         DrugDAO dd = new DrugDAO();
/*  74 */         OrderDetails od = new OrderDetails();
/*  75 */         Stock stock = sd.returnStockById(rs.getInt("stock_id"));
/*  76 */         Drug drug = stock.getDrug();
/*     */         
/*  78 */         od.setDrug(drug);
/*  79 */         od.setQuantity(rs.getDouble("quantity"));
/*  80 */         od.setTotal_price(rs.getDouble("total_price"));
/*     */ 
/*     */         
/*  83 */         listOfOrdersDetails.add(od);
/*     */       }
/*     */     
/*  86 */     } catch (SQLException ex) {
/*  87 */       System.err.println("Error: " + ex);
/*     */     } finally {
/*  89 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*  91 */     return listOfOrdersDetails;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OrderDetails> getDrugsForOrderReady(int order_id) {
/*  96 */     this.con = ConnectionFactory.getConnection();
/*     */     
/*  98 */     List<OrderDetails> listOfOrdersToUpdate = new ArrayList<>();
/*  99 */     PreparedStatement stmt = null;
/* 100 */     ResultSet rs = null;
/* 101 */     String sql = "SELECT * FROM order_details WHERE order_id=?";
/*     */     
/*     */     try {
/* 104 */       stmt = this.con.prepareStatement(sql);
/* 105 */       stmt.setInt(1, order_id);
/* 106 */       rs = stmt.executeQuery();
/*     */       
/* 108 */       StockDAO sd = new StockDAO();
/* 109 */       while (rs.next()) {
/* 110 */         OrderDetails od = new OrderDetails();
/*     */         
/* 112 */         od.setQuantity(rs.getDouble("quantity"));
/* 113 */         Stock s = sd.returnStockById(rs.getInt("stock_id"));
/*     */         
/* 115 */         od.setDrug(s.getDrug());
/* 116 */         System.out.print(od.getDrug());
/*     */ 
/*     */         
/* 119 */         listOfOrdersToUpdate.add(od);
/*     */       }
/*     */     
/* 122 */     } catch (SQLException ex) {
/* 123 */       System.err.println("Error: " + ex);
/*     */     } finally {
/* 125 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/* 127 */     return listOfOrdersToUpdate;
/*     */   }
/*     */   
/*     */   public void removeOrderDetailsByOrderId(int order_id) {
/* 131 */     this.con = ConnectionFactory.getConnection();
/*     */     
/* 133 */     PreparedStatement stmt = null;
/* 134 */     String sql = "DELETE FROM order_details WHERE order_id =?";
/*     */     
/*     */     try {
/* 137 */       stmt = this.con.prepareStatement(sql);
/* 138 */       stmt.setInt(1, order_id);
/* 139 */       stmt.executeUpdate();
/* 140 */     } catch (SQLException ex) {
/* 141 */       System.out.println("Error: " + ex);
/*     */     } finally {
/* 143 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/dao/OrderDetailsDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */