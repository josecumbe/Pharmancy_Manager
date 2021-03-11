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
/*     */ public class OrderReady
/*     */ {
/*     */   private int bill_nr;
/*     */   private double descount;
/*     */   private double bill_total_paid;
/*     */   private String drug_sold;
/*     */   private double quantity_sold;
/*     */   private double price_per_unit;
/*     */   private double total_price;
/*     */   private double money_paid;
/*     */   private String method_of_payment;
/*     */   private String sub_method_of_payment;
/*     */   private String seller;
/*     */   private String date;
/*     */   
/*     */   public OrderReady() {}
/*     */   
/*     */   public OrderReady(int bill_nr, double descount, double bill_total_paid, String drug_sold, double quantity_sold, double price_per_unit, double total_price, double money_paid, String method_of_payment, String sub_method_of_payment, String seller, String date) {
/*  32 */     this.bill_nr = bill_nr;
/*  33 */     this.descount = descount;
/*  34 */     this.bill_total_paid = bill_total_paid;
/*  35 */     this.drug_sold = drug_sold;
/*  36 */     this.quantity_sold = quantity_sold;
/*  37 */     this.price_per_unit = price_per_unit;
/*  38 */     this.total_price = total_price;
/*  39 */     this.money_paid = money_paid;
/*  40 */     this.method_of_payment = method_of_payment;
/*  41 */     this.sub_method_of_payment = sub_method_of_payment;
/*  42 */     this.seller = seller;
/*  43 */     this.date = date;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBill_nr() {
/*  49 */     return this.bill_nr;
/*     */   }
/*     */   
/*     */   public double getDescount() {
/*  53 */     return this.descount;
/*     */   }
/*     */   
/*     */   public double getBill_total_paid() {
/*  57 */     return this.bill_total_paid;
/*     */   }
/*     */   
/*     */   public String getDrug_sold() {
/*  61 */     return this.drug_sold;
/*     */   }
/*     */   
/*     */   public double getQuantity_sold() {
/*  65 */     return this.quantity_sold;
/*     */   }
/*     */   
/*     */   public double getPrice_per_unit() {
/*  69 */     return this.price_per_unit;
/*     */   }
/*     */   
/*     */   public double getTotal_price() {
/*  73 */     return this.total_price;
/*     */   }
/*     */   
/*     */   public double getMoney_paid() {
/*  77 */     return this.money_paid;
/*     */   }
/*     */   
/*     */   public String getMethod_of_payment() {
/*  81 */     return this.method_of_payment;
/*     */   }
/*     */   
/*     */   public String getSub_method_of_payment() {
/*  85 */     return this.sub_method_of_payment;
/*     */   }
/*     */   
/*     */   public String getSeller() {
/*  89 */     return this.seller;
/*     */   }
/*     */   
/*     */   public String getDate() {
/*  93 */     return this.date;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBill_nr(int bill_nr) {
/* 100 */     this.bill_nr = bill_nr;
/*     */   }
/*     */   
/*     */   public void setDescount(double descount) {
/* 104 */     this.descount = descount;
/*     */   }
/*     */   
/*     */   public void setBill_total_paid(double bill_total_paid) {
/* 108 */     this.bill_total_paid = bill_total_paid;
/*     */   }
/*     */   
/*     */   public void setDrug_sold(String drug_sold) {
/* 112 */     this.drug_sold = drug_sold;
/*     */   }
/*     */   
/*     */   public void setQuantity_sold(double quantity_sold) {
/* 116 */     this.quantity_sold = quantity_sold;
/*     */   }
/*     */   
/*     */   public void setPrice_per_unit(double price_per_unit) {
/* 120 */     this.price_per_unit = price_per_unit;
/*     */   }
/*     */   
/*     */   public void setTotal_price(double total_price) {
/* 124 */     this.total_price = total_price;
/*     */   }
/*     */   
/*     */   public void setMoney_paid(double money_paid) {
/* 128 */     this.money_paid = money_paid;
/*     */   }
/*     */   
/*     */   public void setMethod_of_payment(String method_of_payment) {
/* 132 */     this.method_of_payment = method_of_payment;
/*     */   }
/*     */   
/*     */   public void setSub_method_of_payment(String sub_method_of_payment) {
/* 136 */     this.sub_method_of_payment = sub_method_of_payment;
/*     */   }
/*     */   
/*     */   public void setSeller(String seller) {
/* 140 */     this.seller = seller;
/*     */   }
/*     */   
/*     */   public void setDate(String date) {
/* 144 */     this.date = date;
/*     */   }
/*     */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/bean/OrderReady.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */