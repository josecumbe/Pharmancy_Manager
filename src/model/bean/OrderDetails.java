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
/*    */ public class OrderDetails
/*    */ {
/*    */   private int id;
/*    */   private Order order;
/*    */   private Drug drug;
/*    */   private double quantity;
/*    */   private double total_price;
/*    */   
/*    */   public OrderDetails() {}
/*    */   
/*    */   public OrderDetails(Order order, Drug drug, double quantity, double total_price) {
/* 23 */     this.order = order;
/* 24 */     this.drug = drug;
/* 25 */     this.quantity = quantity;
/* 26 */     this.total_price = total_price;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getId() {
/* 32 */     return this.id;
/*    */   }
/*    */   
/*    */   public Order getOrder() {
/* 36 */     return this.order;
/*    */   }
/*    */   
/*    */   public Drug getDrug() {
/* 40 */     return this.drug;
/*    */   }
/*    */   
/*    */   public double getQuantity() {
/* 44 */     return this.quantity;
/*    */   }
/*    */   
/*    */   public double getTotal_price() {
/* 48 */     return this.total_price;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setId(int id) {
/* 54 */     this.id = id;
/*    */   }
/*    */   
/*    */   public void setOrder(Order order) {
/* 58 */     this.order = order;
/*    */   }
/*    */   
/*    */   public void setDrug(Drug drug) {
/* 62 */     this.drug = drug;
/*    */   }
/*    */   
/*    */   public void setQuantity(double quantity) {
/* 66 */     this.quantity = quantity;
/*    */   }
/*    */   
/*    */   public void setTotal_price(double total_price) {
/* 70 */     this.total_price = total_price;
/*    */   }
/*    */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/bean/OrderDetails.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */