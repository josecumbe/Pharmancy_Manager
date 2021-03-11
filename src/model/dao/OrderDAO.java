/*     */ package model.dao;
/*     */ 
/*     */ import db_connection.ConnectionFactory;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import model.bean.Order;
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
/*     */ public class OrderDAO
/*     */ {
/*  27 */   private Connection con = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean saveOrder(Order order) {
/*  33 */     this.con = ConnectionFactory.getConnection();
/*     */     
/*  35 */     PreparedStatement stmt = null;
/*  36 */     String sql = "INSERT INTO order_sell (user_id, date, total_Paid, bill_money, discount, return_money) VALUES (?,?,?,?,?,?)";
/*     */ 
/*     */     
/*     */     try {
/*  40 */       stmt = this.con.prepareStatement(sql);
/*     */       
/*  42 */       stmt.setInt(1, order.getUser().getUser_id());
/*  43 */       stmt.setString(2, order.getDate());
/*  44 */       stmt.setDouble(3, order.getTotal_paid());
/*  45 */       stmt.setDouble(4, order.getBill_money());
/*  46 */       stmt.setDouble(5, order.getDiscount());
/*  47 */       stmt.setDouble(6, order.getReturn_money());
/*     */ 
/*     */       
/*  50 */       stmt.executeUpdate();
/*     */       
/*  52 */       return true;
/*  53 */     } catch (SQLException ex) {
/*  54 */       System.err.println("Error: " + ex);
/*  55 */       return false;
/*     */     } finally {
/*  57 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Order> returnAllOrdersByDate(String initDate, String finalDate) {
/*  64 */     this.con = ConnectionFactory.getConnection();
/*  65 */     PreparedStatement stmt = null;
/*  66 */     ResultSet rs = null;
/*     */     
/*  68 */     List<Order> orders = new ArrayList<>();
/*     */     
/*  70 */     String sql = "SELECT * FROM order_sell WHERE date BETWEEN ? AND ? ORDER BY order_id DESC";
/*     */     try {
/*  72 */       stmt = this.con.prepareStatement(sql);
/*  73 */       stmt.setString(1, initDate);
/*  74 */       stmt.setString(2, finalDate);
/*  75 */       rs = stmt.executeQuery();
/*  76 */       UserDAO user = new UserDAO();
/*  77 */       while (rs.next()) {
/*  78 */         Order order = new Order();
/*  79 */         order.setOrder_id(rs.getInt("order_id"));
/*  80 */         order.setBill_money(rs.getDouble("bill_money"));
/*  81 */         order.setDate(rs.getString("date"));
/*  82 */         order.setDiscount(rs.getDouble("discount"));
/*  83 */         order.setReturn_money(rs.getDouble("return_money"));
/*  84 */         order.setTotal_paid(rs.getDouble("total_Paid"));
/*  85 */         order.setUser(user.getUserById(rs.getInt("user_id")));
/*     */         
/*  87 */         orders.add(order);
/*     */       }
/*     */     
/*  90 */     } catch (SQLException ex) {
/*  91 */       System.err.println("Error: " + ex);
/*     */     } finally {
/*  93 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*     */     
/*  96 */     return orders;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Order> returnTodayOrders() {
/* 101 */     this.con = ConnectionFactory.getConnection();
/* 102 */     PreparedStatement stmt = null;
/* 103 */     ResultSet rs = null;
/*     */     
/* 105 */     List<Order> orders = new ArrayList<>();
/*     */     
/* 107 */     Date date = new Date();
/* 108 */     String modifiedDate = (new SimpleDateFormat("yyyy-MM-dd")).format(date);
/*     */     
/* 110 */     String sql = "SELECT * FROM order_sell WHERE date = ? ORDER BY order_id DESC";
/*     */     try {
/* 112 */       stmt = this.con.prepareStatement(sql);
/* 113 */       stmt.setString(1, modifiedDate);
/* 114 */       rs = stmt.executeQuery();
/* 115 */       UserDAO user = new UserDAO();
/* 116 */       while (rs.next()) {
/* 117 */         Order order = new Order();
/* 118 */         order.setOrder_id(rs.getInt("order_id"));
/* 119 */         order.setBill_money(rs.getDouble("bill_money"));
/* 120 */         order.setDate(rs.getString("date"));
/* 121 */         order.setDiscount(rs.getDouble("discount"));
/* 122 */         order.setReturn_money(rs.getDouble("return_money"));
/* 123 */         order.setTotal_paid(rs.getDouble("total_Paid"));
/* 124 */         order.setUser(user.getUserById(rs.getInt("user_id")));
/*     */         
/* 126 */         orders.add(order);
/*     */       }
/*     */     
/* 129 */     } catch (SQLException ex) {
/* 130 */       System.err.println("Error: " + ex);
/*     */     } finally {
/* 132 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*     */     
/* 135 */     return orders;
/*     */   }
/*     */   
/*     */   public List<Order> returnAllOrders() {
/* 139 */     this.con = ConnectionFactory.getConnection();
/* 140 */     PreparedStatement stmt = null;
/* 141 */     ResultSet rs = null;
/*     */     
/* 143 */     List<Order> orders = new ArrayList<>();
/*     */     
/* 145 */     String sql = "SELECT * FROM order_sell ORDER BY order_id DESC";
/*     */     try {
/* 147 */       stmt = this.con.prepareStatement(sql);
/* 148 */       rs = stmt.executeQuery();
/* 149 */       UserDAO user = new UserDAO();
/* 150 */       while (rs.next()) {
/* 151 */         Order order = new Order();
/* 152 */         order.setOrder_id(rs.getInt("order_id"));
/* 153 */         order.setBill_money(rs.getDouble("bill_money"));
/* 154 */         order.setDate(rs.getString("date"));
/* 155 */         order.setDiscount(rs.getDouble("discount"));
/* 156 */         order.setReturn_money(rs.getDouble("return_money"));
/* 157 */         order.setTotal_paid(rs.getDouble("total_Paid"));
/* 158 */         order.setUser(user.getUserById(rs.getInt("user_id")));
/*     */         
/* 160 */         orders.add(order);
/*     */       }
/*     */     
/* 163 */     } catch (SQLException ex) {
/* 164 */       System.err.println("Error: " + ex);
/*     */     } finally {
/* 166 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*     */     
/* 169 */     return orders;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int lastAddedOrderId() {
/* 175 */     this.con = ConnectionFactory.getConnection();
/*     */     
/* 177 */     PreparedStatement stmt = null;
/* 178 */     ResultSet rs = null;
/* 179 */     String sql = "SELECT MAX(order_id) FROM order_sell";
/* 180 */     int result = 0;
/*     */     
/*     */     try {
/* 183 */       stmt = this.con.prepareStatement(sql);
/* 184 */       rs = stmt.executeQuery();
/* 185 */       if (rs.next()) {
/* 186 */         result = rs.getInt("MAX(order_id)");
/*     */       }
/* 188 */     } catch (SQLException ex) {
/* 189 */       System.err.println("Error: " + ex);
/*     */     } finally {
/* 191 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/* 193 */     return result;
/*     */   }
/*     */   
/*     */   public double quantityInStock(int stock_id) {
/* 197 */     this.con = ConnectionFactory.getConnection();
/*     */     
/* 199 */     PreparedStatement stmt = null;
/* 200 */     ResultSet rs = null;
/* 201 */     String sql = "SELECT * FROM stock WHERE stock_id = ?";
/* 202 */     double result = 0.0D;
/*     */     
/*     */     try {
/* 205 */       stmt = this.con.prepareStatement(sql);
/* 206 */       stmt.setInt(1, stock_id);
/* 207 */       rs = stmt.executeQuery();
/*     */ 
/*     */       
/* 210 */       result = rs.getDouble("quantity");
/*     */     
/*     */     }
/* 213 */     catch (SQLException ex) {
/* 214 */       System.err.println("Error: " + ex);
/*     */     } finally {
/* 216 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/* 218 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean deductFromStock(int stock_id, double quantity) {
/* 224 */     this.con = ConnectionFactory.getConnection();
/* 225 */     double qtyInStock = quantityInStock(stock_id);
/* 226 */     System.out.println("stok : " + qtyInStock + " local: " + quantity);
/*     */     
/* 228 */     if (qtyInStock >= quantity) {
/*     */       
/* 230 */       double newQuantity = qtyInStock - quantity;
/* 231 */       StockDAO sdao = new StockDAO();
/* 232 */       Stock s = sdao.returnStockById(stock_id);
/* 233 */       s.setQuantity(newQuantity);
/* 234 */       sdao.updateStock(s);
/* 235 */       return true;
/*     */     } 
/* 237 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeOrderByID(int order_id) {
/* 242 */     this.con = ConnectionFactory.getConnection();
/*     */     
/* 244 */     PreparedStatement stmt = null;
/* 245 */     String sql = "DELETE FROM order_sell WHERE order_id =?";
/*     */     
/*     */     try {
/* 248 */       stmt = this.con.prepareStatement(sql);
/* 249 */       stmt.setInt(1, order_id);
/* 250 */       stmt.executeUpdate();
/* 251 */     } catch (SQLException ex) {
/* 252 */       System.out.println("Error: " + ex);
/*     */     } finally {
/* 254 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/dao/OrderDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */