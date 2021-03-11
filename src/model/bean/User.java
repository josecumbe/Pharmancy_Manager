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
/*     */ public class User
/*     */ {
/*     */   private int user_id;
/*     */   private String name;
/*     */   private String login;
/*     */   private String gender;
/*     */   private String birth_date;
/*     */   private String academic;
/*     */   private String marital_status;
/*     */   private String access_type;
/*     */   private String password;
/*     */   private String address;
/*     */   private int telephone;
/*     */   private double salary;
/*     */   private String access_time;
/*     */   
/*     */   public User() {}
/*     */   
/*     */   public User(String name, String gender, String birth_date, String academic, String marital_status, double salary, String address, int telephone) {
/*  31 */     this.name = name;
/*  32 */     this.gender = gender;
/*  33 */     this.birth_date = birth_date;
/*  34 */     this.academic = academic;
/*  35 */     this.marital_status = marital_status;
/*  36 */     this.salary = salary;
/*  37 */     this.address = address;
/*  38 */     this.telephone = telephone;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getUser_id() {
/*  44 */     return this.user_id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  48 */     return this.name;
/*     */   }
/*     */   
/*     */   public String getLogin() {
/*  52 */     return this.login;
/*     */   }
/*     */   
/*     */   public String getGender() {
/*  56 */     return this.gender;
/*     */   }
/*     */   
/*     */   public String getBirth_date() {
/*  60 */     return this.birth_date;
/*     */   }
/*     */   
/*     */   public String getAcademic() {
/*  64 */     return this.academic;
/*     */   }
/*     */   
/*     */   public String getMarital_status() {
/*  68 */     return this.marital_status;
/*     */   }
/*     */   
/*     */   public String getAccess_type() {
/*  72 */     return this.access_type;
/*     */   }
/*     */   
/*     */   public String getPassword() {
/*  76 */     return this.password;
/*     */   }
/*     */   
/*     */   public String getAddress() {
/*  80 */     return this.address;
/*     */   }
/*     */   
/*     */   public int getTelephone() {
/*  84 */     return this.telephone;
/*     */   }
/*     */   
/*     */   public double getSalary() {
/*  88 */     return this.salary;
/*     */   }
/*     */   
/*     */   public String getAccess_time() {
/*  92 */     return this.access_time;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUser_id(int user_id) {
/*  98 */     this.user_id = user_id;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 102 */     this.name = name;
/*     */   }
/*     */   
/*     */   public void setLogin(String login) {
/* 106 */     this.login = login;
/*     */   }
/*     */   
/*     */   public void setGender(String gender) {
/* 110 */     this.gender = gender;
/*     */   }
/*     */   
/*     */   public void setBirth_date(String birth_date) {
/* 114 */     this.birth_date = birth_date;
/*     */   }
/*     */   
/*     */   public void setAcademic(String academic) {
/* 118 */     this.academic = academic;
/*     */   }
/*     */   
/*     */   public void setMarital_status(String marital_status) {
/* 122 */     this.marital_status = marital_status;
/*     */   }
/*     */   
/*     */   public void setAccess_type(String access_type) {
/* 126 */     this.access_type = access_type;
/*     */   }
/*     */   
/*     */   public void setPassword(String password) {
/* 130 */     this.password = password;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/* 134 */     this.address = address;
/*     */   }
/*     */   
/*     */   public void setTelephone(int telephone) {
/* 138 */     this.telephone = telephone;
/*     */   }
/*     */   
/*     */   public void setSalary(double salary) {
/* 142 */     this.salary = salary;
/*     */   }
/*     */   
/*     */   public void setAccess_time(String access_time) {
/* 146 */     this.access_time = access_time;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     return getName();
/*     */   }
/*     */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/bean/User.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */