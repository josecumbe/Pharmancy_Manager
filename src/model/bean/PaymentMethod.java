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
/*    */ public class PaymentMethod
/*    */ {
/*    */   private int id;
/*    */   private Order order;
/*    */   private double money_paid;
/*    */   private String method;
/*    */   private String sub_method;
/*    */   
/*    */   public PaymentMethod() {}
/*    */   
/*    */   public PaymentMethod(Order order, double money_paid, String method) {
/* 23 */     this.order = order;
/* 24 */     this.money_paid = money_paid;
/* 25 */     this.method = method;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getId() {
/* 31 */     return this.id;
/*    */   }
/*    */   
/*    */   public Order getOrder() {
/* 35 */     return this.order;
/*    */   }
/*    */   
/*    */   public double getMoney_paid() {
/* 39 */     return this.money_paid;
/*    */   }
/*    */   
/*    */   public String getMethod() {
/* 43 */     return this.method;
/*    */   }
/*    */   
/*    */   public String getSub_method() {
/* 47 */     return this.sub_method;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setId(int id) {
/* 53 */     this.id = id;
/*    */   }
/*    */   
/*    */   public void setOrder(Order order) {
/* 57 */     this.order = order;
/*    */   }
/*    */   
/*    */   public void setMoney_paid(double money_paid) {
/* 61 */     this.money_paid = money_paid;
/*    */   }
/*    */   
/*    */   public void setMethod(String method) {
/* 65 */     this.method = method;
/*    */   }
/*    */   
/*    */   public void setSub_method(String sub_method) {
/* 69 */     this.sub_method = sub_method;
/*    */   }
/*    */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/bean/PaymentMethod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */