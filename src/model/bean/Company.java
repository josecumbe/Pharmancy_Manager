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
/*    */ public class Company
/*    */ {
/*    */   private int company_id;
/*    */   private String name;
/*    */   private String address;
/*    */   private String contact_person;
/*    */   private String email;
/*    */   private String open_date;
/*    */   private int telephone;
/*    */   
/*    */   public Company() {}
/*    */   
/*    */   public Company(String name, String address, String contact_person, String email, String open_date, int telephone) {
/* 26 */     this.name = name;
/* 27 */     this.address = address;
/* 28 */     this.contact_person = contact_person;
/* 29 */     this.email = email;
/* 30 */     this.open_date = open_date;
/* 31 */     this.telephone = telephone;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getCompany_id() {
/* 37 */     return this.company_id;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 41 */     return this.name;
/*    */   }
/*    */   
/*    */   public String getAddress() {
/* 45 */     return this.address;
/*    */   }
/*    */   
/*    */   public String getContact_person() {
/* 49 */     return this.contact_person;
/*    */   }
/*    */   
/*    */   public String getEmail() {
/* 53 */     return this.email;
/*    */   }
/*    */   
/*    */   public String getOpen_date() {
/* 57 */     return this.open_date;
/*    */   }
/*    */   
/*    */   public int getTelephone() {
/* 61 */     return this.telephone;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setCompany_id(int company_id) {
/* 67 */     this.company_id = company_id;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 71 */     this.name = name;
/*    */   }
/*    */   
/*    */   public void setAddress(String address) {
/* 75 */     this.address = address;
/*    */   }
/*    */   
/*    */   public void setContact_person(String contact_person) {
/* 79 */     this.contact_person = contact_person;
/*    */   }
/*    */   
/*    */   public void setEmail(String email) {
/* 83 */     this.email = email;
/*    */   }
/*    */   
/*    */   public void setOpen_date(String open_date) {
/* 87 */     this.open_date = open_date;
/*    */   }
/*    */   
/*    */   public void setTelephone(int telephone) {
/* 91 */     this.telephone = telephone;
/*    */   }
/*    */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/bean/Company.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */