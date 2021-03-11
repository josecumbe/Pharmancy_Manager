/*    */ package model.dao;
/*    */ 
/*    */ import db_connection.ConnectionFactory;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import model.bean.Stock_1;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StockDAO1
/*    */ {
/* 25 */   private Connection con = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Stock_1> returnAllStocks() {
/* 31 */     this.con = ConnectionFactory.getConnection();
/* 32 */     PreparedStatement stmt = null;
/* 33 */     ResultSet rs = null;
/*    */     
/* 35 */     List<Stock_1> allStock = new ArrayList<>();
/*    */     
/* 37 */     String sql = "SELECT d.bar_code, d.generic_name, d.comercial_name, d.batch_nr, d.category, s.quantity, s.unit_sell_price, s.purchase_price, s.supplier, d.manufacturer, s.entry_date, s.expire_date FROM drug d INNER JOIN stock s on d.drug_id = s.drug_id";
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 44 */       stmt = this.con.prepareStatement(sql);
/* 45 */       rs = stmt.executeQuery();
/*    */       
/* 47 */       while (rs.next()) {
/* 48 */         Stock_1 s = new Stock_1();
/* 49 */         s.setBar_Code(rs.getString("bar_code"));
/* 50 */         s.setGeneric_name(rs.getString("generic_name"));
/* 51 */         s.setComercial_name(rs.getString("comercial_name"));
/* 52 */         s.setBatch_nr(rs.getInt("batch_nr"));
/* 53 */         s.setCategory(rs.getString("category"));
/* 54 */         s.setQuantity(rs.getInt("quantity"));
/* 55 */         s.setUnit_sell_price(rs.getDouble("unit_sell_price"));
/* 56 */         s.setPurchase_price(rs.getDouble("purchase_price"));
/* 57 */         s.setSupplier(rs.getString("supplier"));
/* 58 */         s.setManufacturer(rs.getString("manufacturer"));
/* 59 */         s.setEntry_date(rs.getString("entry_date"));
/* 60 */         s.setExpire_date(rs.getString("expire_date"));
/*    */         
/* 62 */         allStock.add(s);
/*    */       } 
/* 64 */     } catch (SQLException ex) {
/* 65 */       System.err.println("Error: " + ex);
/*    */     } finally {
/* 67 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*    */     } 
/* 69 */     return allStock;
/*    */   }
/*    */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/dao/StockDAO1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */