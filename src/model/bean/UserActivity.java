/*    */ package model.bean;
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
/*    */ public class UserActivity
/*    */ {
/*    */   private User user;
/*    */   private String date;
/*    */   private double money_sold;
/*    */   
/*    */   public UserActivity() {}
/*    */   
/*    */   public UserActivity(User user, String date, double money_sold) {
/* 21 */     this.user = user;
/* 22 */     this.date = date;
/* 23 */     this.money_sold = money_sold;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public User getUser() {
/* 29 */     return this.user;
/*    */   }
/*    */   
/*    */   public String getDate() {
/* 33 */     return this.date;
/*    */   }
/*    */   
/*    */   public double getMoney_sold() {
/* 37 */     return this.money_sold;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setUser(User user) {
/* 43 */     this.user = user;
/*    */   }
/*    */   
/*    */   public void setDate(String date) {
/* 47 */     this.date = date;
/*    */   }
/*    */   
/*    */   public void setMoney_sold(double money_sold) {
/* 51 */     this.money_sold = money_sold;
/*    */   }
/*    */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/bean/UserActivity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */