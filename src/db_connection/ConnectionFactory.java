/*    */ package db_connection;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
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
/*    */ 
/*    */ public class ConnectionFactory
/*    */ {
/*    */   private static final String DRIVER = "org.sqlite.JDBC";
/*    */   private static final String URL = "jdbc:sqlite:pharmancy.db";
/*    */   
/*    */   public static Connection getConnection() {
/*    */     try {
/* 28 */       Class.forName(DRIVER);
/* 29 */       return DriverManager.getConnection(URL);
/*    */     }
/* 31 */     catch (ClassNotFoundException|SQLException ex) {
/* 32 */       throw new RuntimeException("Erro na conexão", ex);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void closeConnection(Connection con) {
/* 37 */     if (con != null) {
/*    */       try {
/* 39 */         con.close();
/* 40 */       } catch (SQLException ex) {
/* 41 */         System.err.println("Erro: " + ex);
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   public static void closeConnection(Connection con, PreparedStatement stmt) {
/* 47 */     if (stmt != null) {
/*    */       try {
/* 49 */         stmt.close();
/* 50 */       } catch (SQLException ex) {
/* 51 */         System.err.println("Erro: " + ex);
/*    */       } 
/*    */     }
/* 54 */     closeConnection(con);
/*    */   }
/*    */   
/*    */   public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
/* 58 */     if (rs != null) {
/*    */       try {
/* 60 */         stmt.close();
/* 61 */       } catch (SQLException ex) {
/* 62 */         System.err.println("Erro: " + ex);
/*    */       } 
/*    */     }
/* 65 */     closeConnection(con, stmt);
/*    */   }
/*    */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/db_connection/ConnectionFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */