/*     */ package model.dao;
/*     */ 
/*     */ import db_connection.ConnectionFactory;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import javax.swing.JOptionPane;
/*     */ import model.bean.Company;
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
/*     */ public class CompanyDAO
/*     */ {
/*  23 */   private Connection con = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveCompany(Company company) {
/*  30 */     this.con = ConnectionFactory.getConnection();
/*  31 */     PreparedStatement stmt = null;
/*  32 */     String sql = "INSERT INTO company (name, address, contact_person, email, open_date, telephone) VALUES (?,?,?,?,?,?)";
/*     */     
/*     */     try {
/*  35 */       stmt = this.con.prepareStatement(sql);
/*  36 */       stmt.setString(1, company.getName());
/*  37 */       stmt.setString(2, company.getAddress());
/*  38 */       stmt.setString(3, company.getContact_person());
/*  39 */       stmt.setString(4, company.getEmail());
/*  40 */       stmt.setString(5, company.getOpen_date());
/*  41 */       stmt.setInt(6, company.getTelephone());
/*     */ 
/*     */       
/*  44 */       stmt.executeUpdate();
/*     */       
/*  46 */       JOptionPane.showMessageDialog(null, "Dados da Empresa Salvos com Sucesso");
/*  47 */     } catch (SQLException ex) {
/*  48 */       System.err.println("Error: " + ex);
/*  49 */       JOptionPane.showMessageDialog(null, "Erro Ao Salvar");
/*     */     } finally {
/*  51 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Company returnCompany() {
/*  56 */     this.con = ConnectionFactory.getConnection();
/*  57 */     PreparedStatement stmt = null;
/*  58 */     ResultSet rs = null;
/*  59 */     String sql = "SELECT * FROM company LIMIT 1";
/*  60 */     Company company = new Company();
/*     */     try {
/*  62 */       stmt = this.con.prepareStatement(sql);
/*     */       
/*  64 */       rs = stmt.executeQuery();
/*     */       
/*  66 */       if (rs.next()) {
/*  67 */         company.setCompany_id(rs.getInt("company_id"));
/*  68 */         company.setName(rs.getString("name"));
/*  69 */         company.setAddress(rs.getString("address"));
/*  70 */         company.setContact_person(rs.getString("contact_person"));
/*  71 */         company.setEmail(rs.getString("email"));
/*  72 */         company.setOpen_date(rs.getString("open_date"));
/*  73 */         company.setTelephone(rs.getInt("telephone"));
/*     */       }
/*     */     
/*  76 */     } catch (SQLException ex) {
/*  77 */       System.err.println("Error: " + ex);
/*     */     } finally {
/*  79 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*  81 */     return company;
/*     */   }
/*     */   
/*     */   public boolean updateCompany(Company company) {
/*  85 */     this.con = ConnectionFactory.getConnection();
/*     */     
/*  87 */     PreparedStatement stmt = null;
/*     */     
/*  89 */     String sql = "UPDATE company SET name = ?, address= ?, contact_person = ?, email = ?, open_date = ?, telephone = ? WHERE company_id = ?";
/*     */     
/*     */     try {
/*  92 */       stmt = this.con.prepareStatement(sql);
/*     */       
/*  94 */       stmt.setString(1, company.getName());
/*  95 */       stmt.setString(2, company.getAddress());
/*  96 */       stmt.setString(3, company.getContact_person());
/*  97 */       stmt.setString(4, company.getEmail());
/*  98 */       stmt.setString(5, company.getOpen_date());
/*  99 */       stmt.setInt(6, company.getTelephone());
/* 100 */       stmt.setInt(7, company.getCompany_id());
/*     */       
/* 102 */       stmt.executeUpdate();
/*     */       
/* 104 */       return true;
/*     */     }
/* 106 */     catch (SQLException ex) {
/* 107 */       System.out.println("Error: " + ex);
/* 108 */       return false;
/*     */     } finally {
/* 110 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/dao/CompanyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */