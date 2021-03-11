/*     */ package model.dao;
/*     */ 
/*     */ import db_connection.ConnectionFactory;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import javax.swing.JOptionPane;
/*     */ import model.bean.Drug;
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
/*     */ public class StockDAO
/*     */ {
/*  24 */   private Connection con = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(Stock stock) {
/*  30 */     this.con = ConnectionFactory.getConnection();
/*  31 */     PreparedStatement stmt = null;
/*  32 */     String sql = "INSERT INTO stock (drug_id, quantity, supplier, unit_sell_price, purchase_price, entry_date, expire_date) VALUES (?,?,?,?,?,?,?)";
/*     */ 
/*     */     
/*     */     try {
/*  36 */       stmt = this.con.prepareStatement(sql);
/*  37 */       stmt.setInt(1, stock.getDrug().getDrug_id());
/*  38 */       stmt.setDouble(2, stock.getQuantity());
/*  39 */       stmt.setString(3, stock.getSupplier());
/*  40 */       stmt.setDouble(4, stock.getUni_sell_price());
/*  41 */       stmt.setDouble(5, stock.getPurchase_price());
/*  42 */       stmt.setString(6, stock.getEntry_date());
/*  43 */       stmt.setString(7, stock.getExpire_date());
/*  44 */       stmt.executeUpdate();
/*  45 */       JOptionPane.showMessageDialog(null, "Medicamento Salvo Com Sucesso");
/*  46 */     } catch (SQLException ex) {
/*  47 */       System.err.println("Error: " + ex);
/*  48 */       JOptionPane.showMessageDialog(null, "Erro Ao Salvar, Verifique os Dados Informados e Tente Novamente");
/*     */     } finally {
/*     */       
/*  51 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Stock returnStockByDrugId(Drug drug) {
/*  56 */     this.con = ConnectionFactory.getConnection();
/*  57 */     PreparedStatement stmt = null;
/*  58 */     ResultSet rs = null;
/*  59 */     Stock stock = new Stock();
/*  60 */     int drug_id = drug.getDrug_id();
/*     */     
/*  62 */     String sql = "SELECT * FROM stock WHERE drug_id= ?";
/*     */     
/*     */     try {
/*  65 */       stmt = this.con.prepareStatement(sql);
/*  66 */       stmt.setInt(1, drug_id);
/*  67 */       rs = stmt.executeQuery();
/*     */       
/*  69 */       if (rs.next()) {
/*  70 */         stock.setStock_id(rs.getInt("stock_id"));
/*  71 */         stock.setDrug(drug);
/*  72 */         stock.setQuantity(rs.getDouble("quantity"));
/*  73 */         stock.setSupplier(rs.getString("supplier"));
/*  74 */         stock.setUni_sell_price(rs.getDouble("unit_sell_price"));
/*  75 */         stock.setPurchase_price(rs.getDouble("purchase_price"));
/*  76 */         stock.setEntry_date(rs.getString("entry_date"));
/*  77 */         stock.setExpire_date(rs.getString("expire_date"));
/*  78 */         stock.setAvailability(rs.getBoolean("availability"));
/*     */       }
/*     */     
/*  81 */     } catch (SQLException ex) {
/*  82 */       System.out.println("Error: " + ex);
/*     */     } finally {
/*  84 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*  86 */     return stock;
/*     */   }
/*     */   
/*     */   public Stock returnStockById(int stock_id) {
/*  90 */     this.con = ConnectionFactory.getConnection();
/*  91 */     PreparedStatement stmt = null;
/*  92 */     ResultSet rs = null;
/*  93 */     Stock stock = new Stock();
/*     */ 
/*     */     
/*  96 */     String sql = "SELECT * FROM stock WHERE stock_id = ?";
/*     */     
/*     */     try {
/*  99 */       stmt = this.con.prepareStatement(sql);
/* 100 */       stmt.setInt(1, stock_id);
/* 101 */       rs = stmt.executeQuery();
/* 102 */       DrugDAO dd = new DrugDAO();
/* 103 */       if (rs.next()) {
/* 104 */         Drug drug = dd.getDrugsById(rs.getInt("drug_id"));
/*     */         
/* 106 */         stock.setStock_id(rs.getInt("stock_id"));
/* 107 */         stock.setDrug(drug);
/* 108 */         stock.setQuantity(rs.getDouble("quantity"));
/* 109 */         stock.setSupplier(rs.getString("supplier"));
/* 110 */         stock.setUni_sell_price(rs.getDouble("unit_sell_price"));
/* 111 */         stock.setPurchase_price(rs.getDouble("purchase_price"));
/* 112 */         stock.setEntry_date(rs.getString("entry_date"));
/* 113 */         stock.setExpire_date(rs.getString("expire_date"));
/* 114 */         stock.setAvailability(rs.getBoolean("availability"));
/*     */       }
/*     */     
/* 117 */     } catch (SQLException ex) {
/* 118 */       System.out.println("Error: " + ex);
/*     */     } finally {
/* 120 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/* 122 */     return stock;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean updateStock(Stock stock) {
/* 128 */     this.con = ConnectionFactory.getConnection();
/*     */     
/* 130 */     PreparedStatement stmt = null;
/*     */     
/* 132 */     String sql = "UPDATE stock SET quantity = ?, supplier = ?, unit_sell_price = ?, purchase_price = ?, entry_date = ?, expire_date = ? WHERE stock_id = ?";
/*     */ 
/*     */     
/*     */     try {
/* 136 */       stmt = this.con.prepareStatement(sql);
/*     */       
/* 138 */       stmt.setDouble(1, stock.getQuantity());
/* 139 */       stmt.setString(2, stock.getSupplier());
/* 140 */       stmt.setDouble(3, stock.getUni_sell_price());
/* 141 */       stmt.setDouble(4, stock.getPurchase_price());
/* 142 */       stmt.setString(5, stock.getEntry_date());
/* 143 */       stmt.setString(6, stock.getExpire_date());
/* 144 */       stmt.setInt(7, stock.getStock_id());
/*     */       
/* 146 */       stmt.executeUpdate();
/*     */       
/* 148 */       return true;
/*     */     }
/* 150 */     catch (SQLException ex) {
/* 151 */       System.out.println("Error: " + ex);
/* 152 */       return false;
/*     */     } finally {
/* 154 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateStockWhenOrderExclude(double quantity, int stock_id) {
/* 160 */     this.con = ConnectionFactory.getConnection();
/*     */     
/* 162 */     PreparedStatement stmt = null;
/*     */     
/* 164 */     String sql = "UPDATE stock SET quantity = ? WHERE stock_id = ?";
/*     */     try {
/* 166 */       stmt = this.con.prepareStatement(sql);
/*     */       
/* 168 */       stmt.setDouble(1, quantity);
/*     */       
/* 170 */       stmt.setInt(2, stock_id);
/*     */       
/* 172 */       stmt.executeUpdate();
/*     */       
/* 174 */       return true;
/*     */     }
/* 176 */     catch (SQLException ex) {
/* 177 */       System.out.println("Error: " + ex);
/* 178 */       return false;
/*     */     } finally {
/* 180 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean deleteByStockId(int stock_id) {
/* 188 */     this.con = ConnectionFactory.getConnection();
/* 189 */     PreparedStatement stmt = null;
/* 190 */     boolean result = false;
/*     */     try {
/* 192 */       stmt = this.con.prepareStatement("DELETE FROM stock WHERE stock_id = ?");
/* 193 */       stmt.setInt(1, stock_id);
/* 194 */       stmt.executeUpdate();
/* 195 */       result = true;
/* 196 */     } catch (SQLException ex) {
/* 197 */       System.err.println("Error: " + ex);
/*     */     } finally {
/* 199 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/* 201 */     return result;
/*     */   }
/*     */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/dao/StockDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */