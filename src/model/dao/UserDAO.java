/*     */ package model.dao;
/*     */ 
/*     */ import db_connection.ConnectionFactory;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import model.bean.User;
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
/*     */ public class UserDAO
/*     */ {
/*  25 */   private Connection con = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean saveGeneral(User user) {
/*  32 */     this.con = ConnectionFactory.getConnection();
/*  33 */     PreparedStatement stmt = null;
/*     */     
/*     */     try {
/*  36 */       String sql = "INSERT INTO users (name, gender, birth_date, academic, marital_status, salary, address, telephone) VALUES (?,?,?,?,?,?,?,?)";
/*     */       
/*  38 */       stmt = this.con.prepareStatement(sql);
/*  39 */       stmt.setString(1, user.getName());
/*  40 */       stmt.setString(2, user.getGender());
/*  41 */       stmt.setString(3, user.getBirth_date());
/*  42 */       stmt.setString(4, user.getAcademic());
/*  43 */       stmt.setString(5, user.getMarital_status());
/*  44 */       stmt.setDouble(6, user.getSalary());
/*  45 */       stmt.setString(7, user.getAddress());
/*  46 */       stmt.setInt(8, user.getTelephone());
/*  47 */       stmt.executeUpdate();
/*  48 */       return true;
/*     */     }
/*  50 */     catch (SQLException ex) {
/*  51 */       System.err.println("Error: " + ex);
/*  52 */       return false;
/*     */     } finally {
/*  54 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateUserGeneral(User user) {
/*  60 */     this.con = ConnectionFactory.getConnection();
/*     */     
/*  62 */     PreparedStatement stmt = null;
/*     */     
/*  64 */     String sql = "UPDATE users SET name = ?, gender = ?, academic = ?, marital_status = ?, salary = ?, telephone = ?, birth_date = ?, address = ? WHERE user_id = ?";
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  70 */       stmt = this.con.prepareStatement(sql);
/*     */       
/*  72 */       stmt.setString(1, user.getName());
/*  73 */       stmt.setString(2, user.getGender());
/*  74 */       stmt.setString(3, user.getAcademic());
/*  75 */       stmt.setString(4, user.getMarital_status());
/*  76 */       stmt.setDouble(5, user.getSalary());
/*  77 */       stmt.setInt(6, user.getTelephone());
/*  78 */       stmt.setString(7, user.getBirth_date());
/*  79 */       stmt.setString(8, user.getAddress());
/*  80 */       stmt.setInt(9, user.getUser_id());
/*     */       
/*  82 */       stmt.executeUpdate();
/*     */       
/*  84 */       return true;
/*     */     }
/*  86 */     catch (SQLException ex) {
/*  87 */       System.out.println("Error: " + ex);
/*  88 */       return false;
/*     */     } finally {
/*  90 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean updateUserAcessTime(User user, String actualDate) {
/*  95 */     this.con = ConnectionFactory.getConnection();
/*     */     
/*  97 */     PreparedStatement stmt = null;
/*  98 */     boolean result = false;
/*  99 */     String sql = "UPDATE users SET access_time = ? WHERE user_id = ?";
/*     */ 
/*     */     
/*     */     try {
/* 103 */       stmt = this.con.prepareStatement(sql);
/*     */       
/* 105 */       stmt.setString(1, actualDate);
/* 106 */       stmt.setInt(2, user.getUser_id());
/*     */ 
/*     */       
/* 109 */       stmt.executeUpdate();
/*     */       
/* 111 */       result = true;
/*     */     }
/* 113 */     catch (SQLException ex) {
/* 114 */       System.out.println("Error: " + ex);
/* 115 */       return false;
/*     */     } finally {
/* 117 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/* 119 */     return result;
/*     */   }
/*     */   
/*     */   public boolean updateUserAccess(User user) {
/* 123 */     this.con = ConnectionFactory.getConnection();
/*     */     
/* 125 */     PreparedStatement stmt = null;
/*     */     
/* 127 */     String sql = "UPDATE users SET login = ?, password =?, access_type = ? WHERE user_id = ?";
/*     */     
/*     */     try {
/* 130 */       stmt = this.con.prepareStatement(sql);
/*     */       
/* 132 */       stmt.setString(1, user.getLogin());
/* 133 */       stmt.setString(2, user.getPassword());
/* 134 */       stmt.setString(3, user.getAccess_type());
/* 135 */       stmt.setInt(4, user.getUser_id());
/*     */       
/* 137 */       stmt.executeUpdate();
/*     */       
/* 139 */       return true;
/*     */     }
/* 141 */     catch (SQLException ex) {
/* 142 */       System.out.println("Error: " + ex);
/* 143 */       return false;
/*     */     } finally {
/* 145 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */   
/*     */   public User getUserByName(String name) {
/* 150 */     this.con = ConnectionFactory.getConnection();
/* 151 */     PreparedStatement stmt = null;
/* 152 */     ResultSet rs = null;
/*     */     
/* 154 */     User user = new User();
/*     */     
/* 156 */     String sql = "SELECT * FROM users WHERE name = ?";
/*     */     
/*     */     try {
/* 159 */       stmt = this.con.prepareStatement(sql);
/* 160 */       stmt.setString(1, name);
/* 161 */       rs = stmt.executeQuery();
/*     */       
/* 163 */       if (rs.next()) {
/* 164 */         user.setUser_id(rs.getInt("user_id"));
/* 165 */         user.setName(rs.getString("name"));
/* 166 */         user.setGender(rs.getString("gender"));
/* 167 */         user.setBirth_date(rs.getString("birth_date"));
/* 168 */         user.setAcademic(rs.getString("academic"));
/* 169 */         user.setMarital_status(rs.getString("marital_status"));
/* 170 */         user.setAccess_type(rs.getString("access_type"));
/* 171 */         user.setPassword(rs.getString("password"));
/* 172 */         user.setTelephone(rs.getInt("telephone"));
/* 173 */         user.setLogin(rs.getString("login"));
/* 174 */         user.setAccess_time(rs.getString("access_time"));
/* 175 */         user.setAddress(rs.getString("address"));
/* 176 */         user.setSalary(rs.getDouble("salary"));
/*     */       }
/*     */     
/*     */     }
/* 180 */     catch (SQLException ex) {
/* 181 */       System.out.println("Error: " + ex);
/*     */     } finally {
/* 183 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/* 185 */     return user;
/*     */   }
/*     */   
/*     */   public User getUserById(int id) {
/* 189 */     this.con = ConnectionFactory.getConnection();
/* 190 */     PreparedStatement stmt = null;
/* 191 */     ResultSet rs = null;
/*     */     
/* 193 */     User user = new User();
/*     */     
/* 195 */     String sql = "SELECT * FROM users WHERE user_id = ?";
/*     */     
/*     */     try {
/* 198 */       stmt = this.con.prepareStatement(sql);
/* 199 */       stmt.setInt(1, id);
/* 200 */       rs = stmt.executeQuery();
/*     */       
/* 202 */       if (rs.next()) {
/* 203 */         user.setUser_id(rs.getInt("user_id"));
/* 204 */         user.setName(rs.getString("name"));
/* 205 */         user.setGender(rs.getString("gender"));
/* 206 */         user.setBirth_date(rs.getString("birth_date"));
/* 207 */         user.setAcademic(rs.getString("academic"));
/* 208 */         user.setMarital_status(rs.getString("marital_status"));
/* 209 */         user.setAccess_type(rs.getString("access_type"));
/* 210 */         user.setPassword(rs.getString("password"));
/* 211 */         user.setTelephone(rs.getInt("telephone"));
/* 212 */         user.setLogin(rs.getString("login"));
/* 213 */         user.setAccess_time(rs.getString("access_time"));
/* 214 */         user.setAddress(rs.getString("address"));
/* 215 */         user.setSalary(rs.getDouble("salary"));
/*     */       }
/*     */     
/*     */     }
/* 219 */     catch (SQLException ex) {
/* 220 */       System.out.println("Error: " + ex);
/*     */     } finally {
/* 222 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/* 224 */     return user;
/*     */   }
/*     */   
/*     */   public boolean checkUserByName(User user) {
/* 228 */     this.con = ConnectionFactory.getConnection();
/* 229 */     PreparedStatement stmt = null;
/* 230 */     ResultSet rs = null;
/*     */     
/* 232 */     String sql = "SELECT * FROM users WHERE name = ?";
/*     */     
/*     */     try {
/* 235 */       stmt = this.con.prepareStatement(sql);
/* 236 */       stmt.setString(1, user.getName().toLowerCase());
/* 237 */       rs = stmt.executeQuery();
/*     */       
/* 239 */       if (rs.next()) {
/* 240 */         return true;
/*     */       }
/* 242 */       return false;
/*     */     
/*     */     }
/* 245 */     catch (SQLException ex) {
/* 246 */       System.out.println("Error: " + ex);
/* 247 */       return false;
/*     */     } finally {
/* 249 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean checkUserByNameException(User user) {
/* 254 */     this.con = ConnectionFactory.getConnection();
/* 255 */     PreparedStatement stmt = null;
/* 256 */     ResultSet rs = null;
/*     */     
/* 258 */     String sql = "SELECT * FROM users WHERE name = ? AND user_id NOT IN (SELECT user_id FROM users WHERE user_id=?)";
/*     */     
/*     */     try {
/* 261 */       stmt = this.con.prepareStatement(sql);
/* 262 */       stmt.setString(1, user.getName().toLowerCase());
/* 263 */       stmt.setInt(2, user.getUser_id());
/* 264 */       rs = stmt.executeQuery();
/*     */       
/* 266 */       if (rs.next()) {
/* 267 */         return true;
/*     */       }
/* 269 */       return false;
/*     */     
/*     */     }
/* 272 */     catch (SQLException ex) {
/* 273 */       System.out.println("Error: " + ex);
/* 274 */       return false;
/*     */     } finally {
/* 276 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<User> returnAllUsers() {
/* 281 */     this.con = ConnectionFactory.getConnection();
/* 282 */     PreparedStatement stmt = null;
/* 283 */     ResultSet rs = null;
/*     */     
/* 285 */     List<User> users = new ArrayList<>();
/*     */     
/* 287 */     String sql = "SELECT * FROM users";
/*     */     try {
/* 289 */       stmt = this.con.prepareStatement(sql);
/* 290 */       rs = stmt.executeQuery();
/*     */       
/* 292 */       while (rs.next()) {
/* 293 */         User user = new User();
/* 294 */         user.setUser_id(rs.getInt("user_id"));
/* 295 */         user.setName(rs.getString("name"));
/* 296 */         user.setGender(rs.getString("gender"));
/* 297 */         user.setBirth_date(rs.getString("birth_date"));
/* 298 */         user.setAcademic(rs.getString("academic"));
/* 299 */         user.setMarital_status(rs.getString("marital_status"));
/* 300 */         user.setAccess_type(rs.getString("access_type"));
/* 301 */         user.setPassword(rs.getString("password"));
/* 302 */         user.setTelephone(rs.getInt("telephone"));
/* 303 */         user.setLogin(rs.getString("login"));
/* 304 */         user.setAddress(rs.getString("address"));
/* 305 */         user.setAccess_time(rs.getString("access_time"));
/* 306 */         user.setSalary(rs.getDouble("salary"));
/* 307 */         users.add(user);
/*     */       }
/*     */     
/* 310 */     } catch (SQLException ex) {
/* 311 */       System.err.println("Error: " + ex);
/*     */     } finally {
/* 313 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/*     */     
/* 316 */     return users;
/*     */   }
/*     */   public void deleteByUserId(int user_id) {
/* 319 */     this.con = ConnectionFactory.getConnection();
/* 320 */     PreparedStatement stmt = null;
/*     */     try {
/* 322 */       stmt = this.con.prepareStatement("DELETE FROM users WHERE user_id = ?");
/* 323 */       stmt.setInt(1, user_id);
/* 324 */       stmt.executeUpdate();
/* 325 */     } catch (SQLException ex) {
/* 326 */       System.err.println("Error: " + ex);
/*     */     } finally {
/* 328 */       ConnectionFactory.closeConnection(this.con, stmt);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean checkUserByLoginAndPassword(String login, String password) {
/* 333 */     this.con = ConnectionFactory.getConnection();
/* 334 */     PreparedStatement stmt = null;
/* 335 */     ResultSet rs = null;
/* 336 */     boolean result = false;
/* 337 */     String sql = "SELECT * FROM users WHERE login =? and password =?";
/*     */     try {
/* 339 */       stmt = this.con.prepareStatement(sql);
/* 340 */       stmt.setString(1, login);
/* 341 */       stmt.setString(2, password);
/* 342 */       rs = stmt.executeQuery();
/* 343 */       if (rs.next()) {
/* 344 */         result = true;
/*     */       } else {
/* 346 */         result = false;
/*     */       } 
/* 348 */     } catch (SQLException ex) {
/* 349 */       System.err.println("Error: " + ex);
/*     */     } finally {
/* 351 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/* 353 */     return result;
/*     */   }
/*     */   
/*     */   public User getUserLogged(String login, String password) {
/* 357 */     this.con = ConnectionFactory.getConnection();
/* 358 */     PreparedStatement stmt = null;
/* 359 */     ResultSet rs = null;
/* 360 */     User user = new User();
/* 361 */     String sql = "SELECT * FROM users WHERE login =? and password =?";
/*     */     try {
/* 363 */       stmt = this.con.prepareStatement(sql);
/* 364 */       stmt.setString(1, login);
/* 365 */       stmt.setString(2, password);
/* 366 */       rs = stmt.executeQuery();
/* 367 */       if (rs.next())
/*     */       {
/* 369 */         user.setUser_id(rs.getInt("user_id"));
/* 370 */         user.setAccess_type(rs.getString("access_type"));
/* 371 */         user.setLogin(rs.getString("login"));
/* 372 */         user.setAccess_time(rs.getString("access_time"));
/* 373 */         user.setName(rs.getString("name"));
/* 374 */         user.setPassword(rs.getString("password"));
/*     */       }
/*     */     
/*     */     }
/* 378 */     catch (SQLException ex) {
/* 379 */       System.err.println("Error: " + ex);
/*     */     } finally {
/* 381 */       ConnectionFactory.closeConnection(this.con, stmt, rs);
/*     */     } 
/* 383 */     return user;
/*     */   }
/*     */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/model/dao/UserDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */