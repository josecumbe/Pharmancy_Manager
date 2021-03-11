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
/*     */ public class Drug
/*     */ {
/*     */   private int drug_id;
/*     */   private int batch_nr;
/*     */   private String generic_name;
/*     */   private String comercial_name;
/*     */   private String category;
/*     */   private String unit;
/*     */   private String manufacturer;
/*     */   private String bar_code;
/*     */   
/*     */   public Drug() {}
/*     */   
/*     */   public Drug(int batch_nr, String generic_name, String comercial_name, String category, String unit, String manufacturer, String bar_code) {
/*  27 */     this.batch_nr = batch_nr;
/*  28 */     this.generic_name = generic_name;
/*  29 */     this.comercial_name = comercial_name;
/*  30 */     this.category = category;
/*  31 */     this.unit = unit;
/*  32 */     this.manufacturer = manufacturer;
/*  33 */     this.bar_code = bar_code;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDrug_id() {
/*  39 */     return this.drug_id;
/*     */   }
/*     */   
/*     */   public int getBatch_nr() {
/*  43 */     return this.batch_nr;
/*     */   }
/*     */   
/*     */   public String getGeneric_name() {
/*  47 */     return this.generic_name;
/*     */   }
/*     */   
/*     */   public String getComercial_name() {
/*  51 */     return this.comercial_name;
/*     */   }
/*     */   
/*     */   public String getCategory() {
/*  55 */     return this.category;
/*     */   }
/*     */   
/*     */   public String getUnit() {
/*  59 */     return this.unit;
/*     */   }
/*     */   
/*     */   public String getManufacturer() {
/*  63 */     return this.manufacturer;
/*     */   }
/*     */   
/*     */   public String getBar_code() {
/*  67 */     return this.bar_code;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDrug_id(int drug_id) {
/*  72 */     this.drug_id = drug_id;
/*     */   }
/*     */   
/*     */   public void setBatch_nr(int batch_nr) {
/*  76 */     this.batch_nr = batch_nr;
/*     */   }
/*     */   
/*     */   public void setGeneric_name(String generic_name) {
/*  80 */     this.generic_name = generic_name;
/*     */   }
/*     */   
/*     */   public void setComercial_name(String comercial_name) {
/*  84 */     this.comercial_name = comercial_name;
/*     */   }
/*     */   
/*     */   public void setCategory(String category) {
/*  88 */     this.category = category;
/*     */   }
/*     */   
/*     */   public void setUnit(String unit) {
/*  92 */     this.unit = unit;
/*     */   }
/*     */   
/*     */   public void setManufacturer(String manufacturer) {
/*  96 */     this.manufacturer = manufacturer;
/*     */   }
/*     */   
/*     */   public void setBar_code(String bar_code) {
/* 100 */     this.bar_code = bar_code;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 105 */     return getGeneric_name();
/*     */   }
/*     */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/bean/Drug.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */