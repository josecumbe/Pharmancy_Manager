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
/*    */ 
/*    */ 
/*    */ public class Order
/*    */ {
/*    */   private int order_id;
/*    */   private User user;
/*    */   private String date;
/*    */   private double total_paid;
/*    */   private double bill_money;
/*    */   private double discount;
/*    */   private double return_money;
/*    */   
/*    */   public Order() {}
/*    */   
/*    */   public Order(User user, String date, double total_paid, double bill_money, double discount, double return_money) {
/* 27 */     this.user = user;
/* 28 */     this.date = date;
/* 29 */     this.total_paid = total_paid;
/* 30 */     this.discount = discount;
/* 31 */     this.return_money = return_money;
/* 32 */     this.bill_money = bill_money;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getOrder_id() {
/* 39 */     return this.order_id;
/*    */   }
/*    */   
/*    */   public User getUser() {
/* 43 */     return this.user;
/*    */   }
/*    */   
/*    */   public String getDate() {
/* 47 */     return this.date;
/*    */   }
/*    */   
/*    */   public double getTotal_paid() {
/* 51 */     return this.total_paid;
/*    */   }
/*    */   
/*    */   public double getBill_money() {
/* 55 */     return this.bill_money;
/*    */   }
/*    */   
/*    */   public double getDiscount() {
/* 59 */     return this.discount;
/*    */   }
/*    */   
/*    */   public double getReturn_money() {
/* 63 */     return this.return_money;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setOrder_id(int order_id) {
/* 69 */     this.order_id = order_id;
/*    */   }
/*    */   
/*    */   public void setUser(User user) {
/* 73 */     this.user = user;
/*    */   }
/*    */   
/*    */   public void setDate(String date) {
/* 77 */     this.date = date;
/*    */   }
/*    */   
/*    */   public void setTotal_paid(double total_paid) {
/* 81 */     this.total_paid = total_paid;
/*    */   }
/*    */   
/*    */   public void setBill_money(double bill_money) {
/* 85 */     this.bill_money = bill_money;
/*    */   }
/*    */   
/*    */   public void setDiscount(double discount) {
/* 89 */     this.discount = discount;
/*    */   }
/*    */   
/*    */   public void setReturn_money(double return_money) {
/* 93 */     this.return_money = return_money;
/*    */   }
/*    */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/bean/Order.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */