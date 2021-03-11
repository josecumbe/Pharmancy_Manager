/*     */ package model.dao;
/*     */ 
/*     */ import db_connection.ConnectionFactory;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import model.bean.Drug;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DrugDAO
/*     */ {
/*  30 */   private Connection con = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkDrug(Drug drug) {
/*  37 */     this.con = ConnectionFactory.getConnection();
/*  38 */     PreparedStatement stmt = null;
/*  39 */     ResultSet rs = null;
/*  40 */     String sql = "SELECT * FROM drug WHERE batch_nr =?";
/*     */     
/*     */     try {
/*  43 */       stmt = this.con.prepareStatement(sql);
/*  44 */       stmt.setInt(1, drug.getBatch_nr());
/*  45 */       rs = stmt.executeQuery();
/*  46 */       if (rs.next()) {
/*  47 */         return true;
/*     */       }
/*  49 */       return false;
/*     */     }
/*  51 */     catch (SQLException ex) {
/*  52 */       System.err.println("Error: " + ex);
/*  53 */       return false;
/*     */     } finally {
/*  55 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int retrieveDrugID(Drug drug) {
/*  60 */     this.con = ConnectionFactory.getConnection();
/*  61 */     PreparedStatement stmt = null;
/*  62 */     int drug_id = 0;
/*  63 */     ResultSet rs = null;
/*     */     
/*  65 */     String sql = "SELECT * FROM drug WHERE batch_nr = ?";
/*     */     try {
/*  67 */       stmt = this.con.prepareStatement(sql);
/*  68 */       stmt.setInt(1, drug.getBatch_nr());
/*  69 */       rs = stmt.executeQuery();
/*     */       
/*  71 */       if (rs.next() == true) {
/*  72 */         drug_id = rs.getInt("drug_id");
/*  73 */         return drug_id;
/*     */       } 
/*  75 */       return drug_id;
/*     */     
/*     */     }
/*  78 */     catch (SQLException ex) {
/*  79 */       System.err.println("Error: " + ex);
/*  80 */       return drug_id;
/*     */     } finally {
/*  82 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*     */   }
/*     */   public boolean save(Drug drug) {
/*  86 */     this.con = ConnectionFactory.getConnection();
/*  87 */     PreparedStatement stmt = null;
/*     */     
/*  89 */     String sql = "INSERT INTO drug (batch_nr, generic_name, comercial_name,category, unit, manufacturer, bar_code) VALUES (?,?,?,?,?,?,?)";
/*     */ 
/*     */     
/*     */     try {
/*  93 */       stmt = this.con.prepareStatement(sql);
/*  94 */       stmt.setInt(1, drug.getBatch_nr());
/*  95 */       stmt.setString(2, drug.getGeneric_name());
/*  96 */       stmt.setString(3, drug.getComercial_name());
/*  97 */       stmt.setString(4, drug.getCategory());
/*  98 */       stmt.setString(5, drug.getUnit());
/*  99 */       stmt.setString(6, drug.getManufacturer());
/* 100 */       stmt.setString(7, drug.getBar_code());
/* 101 */       stmt.executeUpdate();
/* 102 */       return true;
/*     */     }
/* 104 */     catch (SQLException ex) {
/* 105 */       System.err.println("Error: " + ex);
/* 106 */       return false;
/*     */     } finally {
/* 108 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<Drug> returnAllDrugs() {
/* 113 */     this.con = ConnectionFactory.getConnection();
/* 114 */     PreparedStatement stmt = null;
/* 115 */     ResultSet rs = null;
/*     */     
/* 117 */     List<Drug> drugs = new ArrayList<>();
/*     */     
/* 119 */     String sql = "SELECT * FROM drug";
/*     */     try {
/* 121 */       stmt = this.con.prepareStatement(sql);
/* 122 */       rs = stmt.executeQuery();
/*     */       
/* 124 */       while (rs.next()) {
/* 125 */         Drug drug = new Drug();
/* 126 */         drug.setDrug_id(rs.getInt("drug_id"));
/* 127 */         drug.setBatch_nr(rs.getInt("batch_nr"));
/* 128 */         drug.setGeneric_name(rs.getString("generic_name"));
/* 129 */         drug.setComercial_name(rs.getString("comercial_name"));
/* 130 */         drug.setCategory(rs.getString("category"));
/* 131 */         drug.setUnit(rs.getString("unit"));
/* 132 */         drug.setManufacturer(rs.getString("manufacturer"));
/*     */         
/* 134 */         drugs.add(drug);
/*     */       }
/*     */     
/* 137 */     } catch (SQLException ex) {
/* 138 */       System.err.println("Error: " + ex);
/*     */     } finally {
/* 140 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*     */     
/* 143 */     return drugs;
/*     */   }
/*     */   
/*     */   public boolean updateDrug(Drug drug) {
/* 147 */     this.con = ConnectionFactory.getConnection();
/*     */     
/* 149 */     PreparedStatement stmt = null;
/*     */     
/* 151 */     String sql = "UPDATE drug SET batch_nr = ?, generic_name = ?, comercial_name = ?, category = ?, unit = ?, manufacturer = ?, bar_code = ? WHERE drug_id = ?";
/*     */ 
/*     */     
/*     */     try {
/* 155 */       stmt = this.con.prepareStatement(sql);
/* 156 */       stmt.setInt(1, drug.getBatch_nr());
/* 157 */       stmt.setString(2, drug.getGeneric_name());
/* 158 */       stmt.setString(3, drug.getComercial_name());
/* 159 */       stmt.setString(4, drug.getCategory());
/* 160 */       stmt.setString(5, drug.getUnit());
/* 161 */       stmt.setString(6, drug.getManufacturer());
/* 162 */       stmt.setString(7, drug.getBar_code());
/* 163 */       stmt.setInt(8, drug.getDrug_id());
/*     */       
/* 165 */       stmt.executeUpdate();
/*     */       
/* 167 */       return true;
/* 168 */     } catch (SQLException ex) {
/* 169 */       System.out.println("Error: " + ex);
/* 170 */       return false;
/*     */     } finally {
/* 172 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean deleteByDrugId(int drug_id) {
/* 177 */     this.con = ConnectionFactory.getConnection();
/* 178 */     PreparedStatement stmt = null;
/* 179 */     boolean result = false;
/*     */     try {
/* 181 */       stmt = this.con.prepareStatement("DELETE FROM drug WHERE drug_id = ?");
/* 182 */       stmt.setInt(1, drug_id);
/* 183 */       stmt.executeUpdate();
/* 184 */       result = true;
/* 185 */     } catch (SQLException ex) {
/* 186 */       System.err.println("Error: " + ex);
/* 187 */       result = false;
/*     */     } finally {
/* 189 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/* 191 */     return result;
/*     */   }
/*     */   
/*     */   public boolean deleteByDrugBarCode(String bar_code) {
/* 195 */     this.con = ConnectionFactory.getConnection();
/* 196 */     PreparedStatement stmt = null;
/* 197 */     boolean result = false;
/*     */     try {
/* 199 */       stmt = this.con.prepareStatement("DELETE FROM drug WHERE bar_code = ?");
/* 200 */       stmt.setString(1, bar_code);
/* 201 */       stmt.executeUpdate();
/* 202 */       result = true;
/* 203 */     } catch (SQLException ex) {
/* 204 */       System.err.println("Error: " + ex);
/*     */     } finally {
/*     */       
/* 207 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/* 209 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public Drug getDrugsByBatchNr(int batch_nr) {
/* 214 */     this.con = ConnectionFactory.getConnection();
/* 215 */     PreparedStatement stmt = null;
/* 216 */     ResultSet rs = null;
/*     */     
/* 218 */     String sql = "SELECT * FROM drug WHERE batch_nr = ?";
/* 219 */     Drug drug = new Drug();
/*     */     try {
/* 221 */       stmt = this.con.prepareStatement(sql);
/* 222 */       stmt.setInt(1, batch_nr);
/* 223 */       rs = stmt.executeQuery();
/*     */       
/* 225 */       drug.setDrug_id(rs.getInt("drug_id"));
/* 226 */       drug.setBatch_nr(rs.getInt("batch_nr"));
/* 227 */       drug.setGeneric_name(rs.getString("generic_name"));
/* 228 */       drug.setComercial_name(rs.getString("comercial_name"));
/* 229 */       drug.setCategory(rs.getString("category"));
/* 230 */       drug.setUnit(rs.getString("unit"));
/* 231 */       drug.setManufacturer(rs.getString("manufacturer"));
/*     */     }
/* 233 */     catch (SQLException ex) {
/* 234 */       System.err.println("Error: " + ex);
/*     */     } finally {
/*     */       
/* 237 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/* 239 */     return drug;
/*     */   }
/*     */ 
/*     */   
/*     */   public Drug getDrugsByGenericName(String generic_name) {
/* 244 */     this.con = ConnectionFactory.getConnection();
/* 245 */     PreparedStatement stmt = null;
/* 246 */     ResultSet rs = null;
/*     */     
/* 248 */     String sql = "SELECT * FROM drug WHERE generic_name = ?";
/* 249 */     Drug drug = new Drug();
/*     */     try {
/* 251 */       stmt = this.con.prepareStatement(sql);
/* 252 */       stmt.setString(1, generic_name);
/* 253 */       rs = stmt.executeQuery();
/*     */       
/* 255 */       drug.setDrug_id(rs.getInt("drug_id"));
/* 256 */       drug.setBatch_nr(rs.getInt("batch_nr"));
/* 257 */       drug.setGeneric_name(rs.getString("generic_name"));
/* 258 */       drug.setComercial_name(rs.getString("comercial_name"));
/* 259 */       drug.setCategory(rs.getString("category"));
/* 260 */       drug.setUnit(rs.getString("unit"));
/* 261 */       drug.setManufacturer(rs.getString("manufacturer"));
/*     */     }
/* 263 */     catch (SQLException ex) {
/* 264 */       System.err.println("Error: " + ex);
/*     */     } finally {
/*     */       
/* 267 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/* 269 */     return drug;
/*     */   }
/*     */   public boolean checkDrugByComercialName(Drug drug) {
/* 272 */     this.con = ConnectionFactory.getConnection();
/* 273 */     PreparedStatement stmt = null;
/* 274 */     ResultSet rs = null;
/* 275 */     boolean result = false;
/*     */     
/* 277 */     String sql = "SELECT * FROM drug WHERE comercial_name = ?";
/*     */     try {
/* 279 */       stmt = this.con.prepareStatement(sql);
/* 280 */       stmt.setString(1, drug.getComercial_name());
/* 281 */       rs = stmt.executeQuery();
/* 282 */       if (rs.next()) {
/* 283 */         result = true;
/*     */       } else {
/* 285 */         result = false;
/*     */       } 
/* 287 */     } catch (SQLException ex) {
/* 288 */       System.err.println("Error: " + ex);
/*     */     } finally {
/*     */       
/* 291 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/* 293 */     return result;
/*     */   }
/*     */   
/*     */   public boolean checkDrugByBarCode(String bar_code) {
/* 297 */     this.con = ConnectionFactory.getConnection();
/* 298 */     PreparedStatement stmt = null;
/* 299 */     ResultSet rs = null;
/* 300 */     boolean result = false;
/*     */     
/* 302 */     String sql = "SELECT * FROM drug WHERE bar_code = ?";
/*     */     try {
/* 304 */       stmt = this.con.prepareStatement(sql);
/* 305 */       stmt.setString(1, bar_code);
/* 306 */       rs = stmt.executeQuery();
/* 307 */       if (rs.next()) {
/* 308 */         result = true;
/*     */       } else {
/* 310 */         result = false;
/*     */       } 
/* 312 */     } catch (SQLException ex) {
/* 313 */       System.err.println("Error: " + ex);
/*     */     } finally {
/*     */       
/* 316 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/* 318 */     return result;
/*     */   }
/*     */   
/*     */   public Drug getDrugByBarCode(String barcode) {
/* 322 */     this.con = ConnectionFactory.getConnection();
/* 323 */     PreparedStatement stmt = null;
/* 324 */     ResultSet rs = null;
/* 325 */     Drug drug = new Drug();
/*     */     
/* 327 */     String sql = "SELECT * FROM drug WHERE bar_code = ?";
/*     */     try {
/* 329 */       stmt = this.con.prepareStatement(sql);
/* 330 */       stmt.setString(1, barcode);
/* 331 */       rs = stmt.executeQuery();
/* 332 */       if (rs.next()) {
/* 333 */         drug.setDrug_id(rs.getInt("drug_id"));
/* 334 */         drug.setBatch_nr(rs.getInt("batch_nr"));
/* 335 */         drug.setBar_code(rs.getString("bar_code"));
/* 336 */         drug.setGeneric_name(rs.getString("generic_name"));
/* 337 */         drug.setComercial_name(rs.getString("comercial_name"));
/* 338 */         drug.setCategory(rs.getString("category"));
/* 339 */         drug.setUnit(rs.getString("unit"));
/* 340 */         drug.setManufacturer(rs.getString("manufacturer"));
/*     */       } 
/* 342 */     } catch (SQLException ex) {
/* 343 */       System.err.println("Error: " + ex);
/*     */     } finally {
/* 345 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/* 347 */     return drug;
/*     */   }
/*     */   
/*     */   public Drug getDrugsByComercialName(String comercial_name) {
/* 351 */     this.con = ConnectionFactory.getConnection();
/* 352 */     PreparedStatement stmt = null;
/* 353 */     ResultSet rs = null;
/*     */     
/* 355 */     String sql = "SELECT * FROM drug WHERE comercial_name = ?";
/* 356 */     Drug drug = new Drug();
/*     */     try {
/* 358 */       stmt = this.con.prepareStatement(sql);
/* 359 */       stmt.setString(1, comercial_name);
/* 360 */       rs = stmt.executeQuery();
/*     */       
/* 362 */       drug.setDrug_id(rs.getInt("drug_id"));
/* 363 */       drug.setBatch_nr(rs.getInt("batch_nr"));
/* 364 */       drug.setBar_code(rs.getString("bar_code"));
/* 365 */       drug.setGeneric_name(rs.getString("generic_name"));
/* 366 */       drug.setComercial_name(rs.getString("comercial_name"));
/* 367 */       drug.setCategory(rs.getString("category"));
/* 368 */       drug.setUnit(rs.getString("unit"));
/* 369 */       drug.setManufacturer(rs.getString("manufacturer"));
/*     */     }
/* 371 */     catch (SQLException ex) {
/* 372 */       System.err.println("Error: " + ex);
/*     */     } finally {
/*     */       
/* 375 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/* 377 */     return drug;
/*     */   }
/*     */   public boolean checkDrugByBatchNr(Drug drug) {
/* 380 */     this.con = ConnectionFactory.getConnection();
/* 381 */     PreparedStatement stmt = null;
/* 382 */     ResultSet rs = null;
/* 383 */     String sql = "SELECT * FROM drug WHERE batch_nr =? AND batch_nr NOT IN (SELECT batch_nr FROM drug WHERE batch_nr=0)";
/*     */     
/*     */     try {
/* 386 */       stmt = this.con.prepareStatement(sql);
/* 387 */       stmt.setInt(1, drug.getBatch_nr());
/* 388 */       rs = stmt.executeQuery();
/* 389 */       if (rs.next()) {
/* 390 */         return true;
/*     */       }
/* 392 */       return false;
/*     */     }
/* 394 */     catch (SQLException ex) {
/* 395 */       System.err.println("Error: " + ex);
/* 396 */       return false;
/*     */     } finally {
/* 398 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean checkDrugByBatchNrException(Drug drug) {
/* 403 */     this.con = ConnectionFactory.getConnection();
/* 404 */     PreparedStatement stmt = null;
/* 405 */     ResultSet rs = null;
/* 406 */     String sql = "SELECT * FROM drug WHERE batch_nr =? AND drug_id NOT IN (SELECT drug_id FROM drug WHERE drug_id = ? OR batch_nr=0)";
/*     */ 
/*     */     
/*     */     try {
/* 410 */       stmt = this.con.prepareStatement(sql);
/* 411 */       stmt.setInt(1, drug.getBatch_nr());
/* 412 */       stmt.setInt(2, drug.getDrug_id());
/* 413 */       rs = stmt.executeQuery();
/* 414 */       if (rs.next()) {
/* 415 */         return true;
/*     */       }
/* 417 */       return false;
/*     */     }
/* 419 */     catch (SQLException ex) {
/* 420 */       System.err.println("Error: " + ex);
/* 421 */       return false;
/*     */     } finally {
/* 423 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean checkDrugByBarCodeException(Drug drug) {
/* 428 */     this.con = ConnectionFactory.getConnection();
/* 429 */     PreparedStatement stmt = null;
/* 430 */     ResultSet rs = null;
/* 431 */     String sql = "SELECT * FROM drug WHERE bar_code =? AND drug_id NOT IN (SELECT drug_id FROM drug WHERE drug_id = ?)";
/* 432 */     System.out.print(drug.getDrug_id());
/*     */     try {
/* 434 */       stmt = this.con.prepareStatement(sql);
/* 435 */       stmt.setString(1, drug.getBar_code());
/* 436 */       stmt.setInt(2, drug.getDrug_id());
/* 437 */       rs = stmt.executeQuery();
/* 438 */       if (rs.next()) {
/* 439 */         return true;
/*     */       }
/* 441 */       return false;
/*     */     }
/* 443 */     catch (SQLException ex) {
/* 444 */       System.err.println("Error: " + ex);
/* 445 */       return false;
/*     */     } finally {
/* 447 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean checkDrugByCommercialNameException(Drug drug) {
/* 452 */     this.con = ConnectionFactory.getConnection();
/* 453 */     PreparedStatement stmt = null;
/* 454 */     ResultSet rs = null;
/* 455 */     String sql = "SELECT * FROM drug WHERE comercial_name =? AND drug_id NOT IN (SELECT drug_id FROM drug WHERE drug_id = ?)";
/* 456 */     System.out.print(drug.getDrug_id());
/*     */     
/*     */     try {
/* 459 */       stmt = this.con.prepareStatement(sql);
/* 460 */       stmt.setString(1, drug.getComercial_name());
/* 461 */       stmt.setInt(2, drug.getDrug_id());
/* 462 */       rs = stmt.executeQuery();
/* 463 */       if (rs.next()) {
/* 464 */         return true;
/*     */       }
/* 466 */       return false;
/*     */     }
/* 468 */     catch (SQLException ex) {
/* 469 */       System.err.println("Error: " + ex);
/* 470 */       return false;
/*     */     } finally {
/* 472 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean checkDrugByGenericNameException(Drug drug) {
/* 477 */     this.con = ConnectionFactory.getConnection();
/* 478 */     PreparedStatement stmt = null;
/* 479 */     ResultSet rs = null;
/* 480 */     String sql = "SELECT * FROM drug WHERE generic_name =? AND drug_id NOT IN (SELECT drug_id FROM drug WHERE drug_id = ?)";
/*     */ 
/*     */     
/*     */     try {
/* 484 */       stmt = this.con.prepareStatement(sql);
/* 485 */       stmt.setString(1, drug.getGeneric_name());
/* 486 */       stmt.setInt(2, drug.getDrug_id());
/* 487 */       rs = stmt.executeQuery();
/* 488 */       if (rs.next()) {
/* 489 */         return true;
/*     */       }
/* 491 */       return false;
/*     */     }
/* 493 */     catch (SQLException ex) {
/* 494 */       System.err.println("Error: " + ex);
/* 495 */       return false;
/*     */     } finally {
/* 497 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean checkDrugByGenericName(Drug drug) {
/* 502 */     this.con = ConnectionFactory.getConnection();
/* 503 */     PreparedStatement stmt = null;
/* 504 */     ResultSet rs = null;
/* 505 */     String sql = "SELECT * FROM drug WHERE generic_name =?";
/*     */     
/*     */     try {
/* 508 */       stmt = this.con.prepareStatement(sql);
/* 509 */       stmt.setString(1, drug.getGeneric_name());
/* 510 */       rs = stmt.executeQuery();
/* 511 */       if (rs.next()) {
/* 512 */         return true;
/*     */       }
/* 514 */       return false;
/*     */     }
/* 516 */     catch (SQLException ex) {
/* 517 */       System.err.println("Error: " + ex);
/* 518 */       return false;
/*     */     } finally {
/* 520 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Drug getDrugsById(int drug_id) {
/* 525 */     this.con = ConnectionFactory.getConnection();
/* 526 */     PreparedStatement stmt = null;
/* 527 */     ResultSet rs = null;
/*     */     
/* 529 */     String sql = "SELECT * FROM drug WHERE drug_id = ?";
/* 530 */     Drug drug = new Drug();
/*     */     try {
/* 532 */       stmt = this.con.prepareStatement(sql);
/* 533 */       stmt.setInt(1, drug_id);
/* 534 */       rs = stmt.executeQuery();
/*     */       
/* 536 */       drug.setDrug_id(rs.getInt("drug_id"));
/* 537 */       drug.setBatch_nr(rs.getInt("batch_nr"));
/* 538 */       drug.setGeneric_name(rs.getString("generic_name"));
/* 539 */       drug.setComercial_name(rs.getString("comercial_name"));
/* 540 */       drug.setCategory(rs.getString("category"));
/* 541 */       drug.setUnit(rs.getString("unit"));
/* 542 */       drug.setManufacturer(rs.getString("manufacturer"));
/*     */     }
/* 544 */     catch (SQLException ex) {
/* 545 */       System.err.println("Error: " + ex);
/*     */     } finally {
/*     */       
/* 548 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/* 550 */     return drug;
/*     */   }
/*     */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/dao/DrugDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */