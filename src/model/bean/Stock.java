/*     */ package model.bean;
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
/*     */ 
/*     */ public class Stock
/*     */ {
/*     */   private int stock_id;
/*     */   private Drug drug;
/*     */   private double quantity;
/*     */   private String supplier;
/*     */   private double uni_sell_price;
/*     */   private double purchase_price;
/*     */   private String entry_date;
/*     */   private String expire_date;
/*     */   private boolean availability;
/*     */   
/*     */   public Stock() {}
/*     */   
/*     */   public Stock(Drug drug, double quantity, String supplier, double uni_sell_price, double purchase_price, String entry_date, String expire_date, boolean availability) {
/*  29 */     this.drug = drug;
/*  30 */     this.quantity = quantity;
/*  31 */     this.supplier = supplier;
/*  32 */     this.uni_sell_price = uni_sell_price;
/*  33 */     this.purchase_price = purchase_price;
/*  34 */     this.entry_date = entry_date;
/*  35 */     this.expire_date = expire_date;
/*  36 */     this.availability = availability;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStock_id() {
/*  42 */     return this.stock_id;
/*     */   }
/*     */   
/*     */   public Drug getDrug() {
/*  46 */     return this.drug;
/*     */   }
/*     */   
/*     */   public double getQuantity() {
/*  50 */     return this.quantity;
/*     */   }
/*     */   
/*     */   public String getSupplier() {
/*  54 */     return this.supplier;
/*     */   }
/*     */   
/*     */   public double getUni_sell_price() {
/*  58 */     return this.uni_sell_price;
/*     */   }
/*     */   
/*     */   public double getPurchase_price() {
/*  62 */     return this.purchase_price;
/*     */   }
/*     */   
/*     */   public String getEntry_date() {
/*  66 */     return this.entry_date;
/*     */   }
/*     */   
/*     */   public String getExpire_date() {
/*  70 */     return this.expire_date;
/*     */   }
/*     */   
/*     */   public boolean isAvailability() {
/*  74 */     return this.availability;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStock_id(int stock_id) {
/*  80 */     this.stock_id = stock_id;
/*     */   }
/*     */   
/*     */   public void setDrug(Drug drug) {
/*  84 */     this.drug = drug;
/*     */   }
/*     */   
/*     */   public void setQuantity(double quantity) {
/*  88 */     this.quantity = quantity;
/*     */   }
/*     */   
/*     */   public void setSupplier(String supplier) {
/*  92 */     this.supplier = supplier;
/*     */   }
/*     */   
/*     */   public void setUni_sell_price(double uni_sell_price) {
/*  96 */     this.uni_sell_price = uni_sell_price;
/*     */   }
/*     */   
/*     */   public void setPurchase_price(double purchase_price) {
/* 100 */     this.purchase_price = purchase_price;
/*     */   }
/*     */   
/*     */   public void setEntry_date(String entry_date) {
/* 104 */     this.entry_date = entry_date;
/*     */   }
/*     */   
/*     */   public void setExpire_date(String expire_date) {
/* 108 */     this.expire_date = expire_date;
/*     */   }
/*     */   
/*     */   public void setAvailability(boolean availability) {
/* 112 */     this.availability = availability;
/*     */   }
/*     */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/bean/Stock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */