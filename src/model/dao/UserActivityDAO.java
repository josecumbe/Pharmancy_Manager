/*    */ package model.dao;
/*    */ 
/*    */ import db_connection.ConnectionFactory;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import model.bean.User;
/*    */ import model.bean.UserActivity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserActivityDAO
/*    */ {
/* 23 */   private Connection con = null;
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean saveActivity(UserActivity userActivity) {
/* 28 */     this.con = ConnectionFactory.getConnection();
/*    */     
/* 30 */     PreparedStatement stmt = null;
/*    */     
/* 32 */     boolean result = false;
/* 33 */     String sql = "INSERT INTO user_activity (user_id, date, money_sold) VALUES (?,?,?)";
/*    */     try {
/* 35 */       stmt = this.con.prepareStatement(sql);
/* 36 */       stmt.setInt(1, userActivity.getUser().getUser_id());
/* 37 */       stmt.setString(2, userActivity.getDate());
/* 38 */       stmt.setDouble(3, userActivity.getMoney_sold());
/* 39 */       stmt.executeUpdate();
/* 40 */       result = true;
/* 41 */     } catch (SQLException ex) {
/* 42 */       System.err.println("Error: " + ex);
/*    */     } finally {
/* 44 */       ConnectionFactory.closeConnection(this.con, stmt);
/*    */     } 
/* 46 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<UserActivity> returnUserActivityById(User user) {
/* 52 */     this.con = ConnectionFactory.getConnection();
/* 53 */     List<UserActivity> userActivityList = new ArrayList<>();
/* 54 */     PreparedStatement stmt = null;
/* 55 */     ResultSet rs = null;
/*    */     
/* 57 */     String sql = "SELECT * FROM user_activity WHERE user_id =? ORDER BY date DESC LIMIT 7";
/*    */     try {
/* 59 */       stmt = this.con.prepareStatement(sql);
/* 60 */       stmt.setInt(1, user.getUser_id());
/* 61 */       rs = stmt.executeQuery();
/*    */       
/* 63 */       UserDAO ud = new UserDAO();
/* 64 */       while (rs.next()) {
/* 65 */         UserActivity userAct = new UserActivity();
/* 66 */         userAct.setUser(ud.getUserById(rs.getInt("user_id")));
/* 67 */         userAct.setDate(rs.getString("date"));
/* 68 */         userAct.setMoney_sold(rs.getDouble("money_sold"));
/*    */         
/* 70 */         userActivityList.add(userAct);
/*    */       } 
/* 72 */     } catch (SQLException ex) {
/* 73 */       System.err.println("Error: " + ex);
/*    */     } finally {
/* 75 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*    */     } 
/* 77 */     return userActivityList;
/*    */   }
/*    */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/dao/UserActivityDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */