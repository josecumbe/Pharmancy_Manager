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
/*     */ public class Stock_1
/*     */ {
/*     */   private String bar_code;
/*     */   private String generic_name;
/*     */   private String comercial_name;
/*     */   private int batch_nr;
/*     */   private String category;
/*     */   private double quantity;
/*     */   private double unit_sell_price;
/*     */   private double purchase_price;
/*     */   private String supplier;
/*     */   private String manufacturer;
/*     */   private String entry_date;
/*     */   private String expire_date;
/*     */   
/*     */   public Stock_1() {}
/*     */   
/*     */   public Stock_1(String bar_code, String generic_name, String comercial_name, int batch_nr, String category, double quantity, double unit_sell_price, double purchase_price, String supplier, String manufacturer, String entry_date, String expire_date) {
/*  31 */     this.bar_code = bar_code;
/*  32 */     this.generic_name = generic_name;
/*  33 */     this.comercial_name = comercial_name;
/*  34 */     this.batch_nr = batch_nr;
/*  35 */     this.category = category;
/*  36 */     this.quantity = quantity;
/*  37 */     this.unit_sell_price = unit_sell_price;
/*  38 */     this.purchase_price = purchase_price;
/*  39 */     this.supplier = supplier;
/*  40 */     this.manufacturer = manufacturer;
/*  41 */     this.entry_date = entry_date;
/*  42 */     this.expire_date = expire_date;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGeneric_name() {
/*  50 */     return this.generic_name;
/*     */   }
/*     */   
/*     */   public String getComercial_name() {
/*  54 */     return this.comercial_name;
/*     */   }
/*     */   
/*     */   public int getBatch_nr() {
/*  58 */     return this.batch_nr;
/*     */   }
/*     */   
/*     */   public String getCategory() {
/*  62 */     return this.category;
/*     */   }
/*     */   
/*     */   public double getQuantity() {
/*  66 */     return this.quantity;
/*     */   }
/*     */   
/*     */   public double getUnit_sell_price() {
/*  70 */     return this.unit_sell_price;
/*     */   }
/*     */   
/*     */   public double getPurchase_price() {
/*  74 */     return this.purchase_price;
/*     */   }
/*     */   
/*     */   public String getSupplier() {
/*  78 */     return this.supplier;
/*     */   }
/*     */   
/*     */   public String getManufacturer() {
/*  82 */     return this.manufacturer;
/*     */   }
/*     */   
/*     */   public String getEntry_date() {
/*  86 */     return this.entry_date;
/*     */   }
/*     */   
/*     */   public String getExpire_date() {
/*  90 */     return this.expire_date;
/*     */   }
/*     */   
/*     */   public String getBar_code() {
/*  94 */     return this.bar_code;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setGeneric_name(String generic_name) {
/*  99 */     this.generic_name = generic_name;
/*     */   }
/*     */   
/*     */   public void setComercial_name(String comercial_name) {
/* 103 */     this.comercial_name = comercial_name;
/*     */   }
/*     */   
/*     */   public void setBatch_nr(int batch_nr) {
/* 107 */     this.batch_nr = batch_nr;
/*     */   }
/*     */   
/*     */   public void setCategory(String category) {
/* 111 */     this.category = category;
/*     */   }
/*     */   
/*     */   public void setQuantity(double quantity) {
/* 115 */     this.quantity = quantity;
/*     */   }
/*     */   
/*     */   public void setUnit_sell_price(double unit_sell_price) {
/* 119 */     this.unit_sell_price = unit_sell_price;
/*     */   }
/*     */   
/*     */   public void setPurchase_price(double purchase_price) {
/* 123 */     this.purchase_price = purchase_price;
/*     */   }
/*     */   
/*     */   public void setSupplier(String supplier) {
/* 127 */     this.supplier = supplier;
/*     */   }
/*     */   
/*     */   public void setManufacturer(String manufacturer) {
/* 131 */     this.manufacturer = manufacturer;
/*     */   }
/*     */   
/*     */   public void setEntry_date(String entry_date) {
/* 135 */     this.entry_date = entry_date;
/*     */   }
/*     */   
/*     */   public void setExpire_date(String expire_date) {
/* 139 */     this.expire_date = expire_date;
/*     */   }
/*     */   
/*     */   public void setBar_Code(String bar_code) {
/* 143 */     this.bar_code = bar_code;
/*     */   }
/*     */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/bean/Stock_1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */