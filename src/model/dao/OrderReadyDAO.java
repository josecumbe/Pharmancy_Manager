/*     */ package model.dao;
/*     */ 
/*     */ import db_connection.ConnectionFactory;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import model.bean.OrderDetails;
/*     */ import model.bean.OrderReady;
/*     */ import model.bean.Stock;
/*     */ import model.bean.User;
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
/*     */ public class OrderReadyDAO
/*     */ {
/*  27 */   private Connection con = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public List<OrderReady> returnAllOrder() {
/*  32 */     this.con = ConnectionFactory.getConnection();
/*  33 */     PreparedStatement stmt = null;
/*  34 */     ResultSet rs = null;
/*     */     
/*  36 */     List<OrderReady> allOrders = new ArrayList<>();
/*     */     
/*  38 */     String sql = "SELECT o.order_id, o.discount, o.total_Paid, d.generic_name, od.quantity, s.unit_sell_price, od.total_price,pm.money_paid,pm.method, pm.sub_method, u.name, o.date FROM ((((order_details od INNER JOIN order_sell o on od.order_id=o.order_id) INNER JOIN payment_method pm on pm.order_id=o.order_id) INNER JOIN stock s on s.stock_id=od.stock_id) INNER JOIN drug d on d.drug_id=s.drug_id) INNER JOIN users u on u.user_id = o.user_id;";
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  44 */       stmt = this.con.prepareStatement(sql);
/*  45 */       rs = stmt.executeQuery();
/*     */       
/*  47 */       while (rs.next()) {
/*  48 */         OrderReady o = new OrderReady();
/*  49 */         o.setBill_nr(rs.getInt("order_id"));
/*  50 */         o.setDescount(rs.getDouble("discount"));
/*  51 */         o.setBill_total_paid(rs.getDouble("total_Paid"));
/*  52 */         o.setDrug_sold(rs.getString("generic_name"));
/*  53 */         o.setQuantity_sold(rs.getDouble("quantity"));
/*  54 */         o.setPrice_per_unit(rs.getDouble("unit_sell_price"));
/*  55 */         o.setTotal_price(rs.getDouble("total_price"));
/*  56 */         o.setMoney_paid(rs.getDouble("money_paid"));
/*  57 */         o.setMethod_of_payment(rs.getString("method"));
/*  58 */         o.setSub_method_of_payment(rs.getString("sub_method"));
/*  59 */         o.setSeller(rs.getString("name"));
/*  60 */         o.setDate(rs.getString("date"));
/*     */         
/*  62 */         allOrders.add(o);
/*     */       } 
/*  64 */     } catch (SQLException ex) {
/*  65 */       System.err.println("Error: " + ex);
/*     */     } finally {
/*  67 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*  69 */     return allOrders;
/*     */   }
/*     */   
/*     */   public double todayTotalMoney(String date) {
/*  73 */     this.con = ConnectionFactory.getConnection();
/*  74 */     PreparedStatement stmt = null;
/*  75 */     ResultSet rs = null;
/*     */     
/*  77 */     double total = 0.0D;
/*  78 */     String sql = "SELECT date, bill_money FROM order_sell WHERE date=?";
/*     */     try {
/*  80 */       stmt = this.con.prepareStatement(sql);
/*  81 */       stmt.setString(1, date);
/*  82 */       rs = stmt.executeQuery();
/*     */       
/*  84 */       while (rs.next()) {
/*  85 */         total += rs.getDouble("bill_money");
/*     */       }
/*  87 */     } catch (SQLException ex) {
/*  88 */       System.err.println("Error: " + ex);
/*     */     } finally {
/*  90 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*  92 */     return total;
/*     */   }
/*     */   
/*     */   public double todayMoneyByUser(User user, String date) {
/*  96 */     this.con = ConnectionFactory.getConnection();
/*  97 */     PreparedStatement stmt = null;
/*  98 */     ResultSet rs = null;
/*     */     
/* 100 */     double total = 0.0D;
/* 101 */     String sql = "SELECT os.date, os.total_Paid FROM order_sell os WHERE os.user_id =? and os.date=?";
/*     */     try {
/* 103 */       stmt = this.con.prepareStatement(sql);
/* 104 */       stmt.setInt(1, user.getUser_id());
/* 105 */       stmt.setString(2, date);
/* 106 */       rs = stmt.executeQuery();
/*     */       
/* 108 */       while (rs.next()) {
/* 109 */         total += rs.getDouble("total_Paid");
/*     */       }
/* 111 */     } catch (SQLException ex) {
/* 112 */       System.err.println("Error: " + ex);
/*     */     } finally {
/* 114 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/* 116 */     return total;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeOrderReady(OrderReady orderReady) {
/* 121 */     OrderDetailsDAO oddao = new OrderDetailsDAO();
/* 122 */     PaymentMethodDAO pdao = new PaymentMethodDAO();
/* 123 */     OrderDAO odao = new OrderDAO();
/*     */ 
/*     */ 
/*     */     
/* 127 */     StockDAO s = new StockDAO();
/*     */     
/* 129 */     OrderDetailsDAO od = new OrderDetailsDAO();
/* 130 */     for (OrderDetails odd : od.getDrugsForOrderReady(orderReady.getBill_nr())) {
/*     */ 
/*     */       
/* 133 */       double deducted_quantity = odd.getQuantity();
/* 134 */       System.err.println(odd.getDrug());
/*     */       
/* 136 */       int stock_id = getStock_Id(orderReady.getBill_nr());
/*     */ 
/*     */       
/* 139 */       Stock stockValues = s.returnStockById(stock_id);
/* 140 */       double quantity_stock = stockValues.getQuantity();
/*     */       
/* 142 */       double newQuantity = deducted_quantity + quantity_stock;
/*     */       
/* 144 */       s.updateStockWhenOrderExclude(newQuantity, stock_id);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 149 */     pdao.removeOrderPMByID(orderReady.getBill_nr());
/* 150 */     oddao.removeOrderDetailsByOrderId(orderReady.getBill_nr());
/* 151 */     odao.removeOrderByID(orderReady.getBill_nr());
/*     */ 
/*     */     
/* 154 */     return true;
/*     */   }
/*     */   
/*     */   public int getStock_Id(int order_id) {
/* 158 */     this.con = ConnectionFactory.getConnection();
/* 159 */     PreparedStatement stmt = null;
/* 160 */     ResultSet rs = null;
/*     */     
/* 162 */     int total = 0;
/* 163 */     String sql = "SELECT stock_id FROM order_details WHERE order_id =?";
/*     */     try {
/* 165 */       stmt = this.con.prepareStatement(sql);
/* 166 */       stmt.setInt(1, order_id);
/* 167 */       rs = stmt.executeQuery();
/*     */       
/* 169 */       while (rs.next()) {
/* 170 */         total = rs.getInt("stock_id");
/*     */       }
/*     */     }
/* 173 */     catch (SQLException ex) {
/* 174 */       System.err.println("Error: " + ex);
/*     */     } finally {
/* 176 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/* 178 */     return total;
/*     */   }
/*     */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/dao/OrderReadyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */