/*      */ package views;
/*      */ import com.toedter.calendar.JDateChooser;
import db_connection.ConnectionFactory;
/*      */ import java.awt.CardLayout;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.MouseListener;
/*      */ import java.awt.event.MouseMotionAdapter;
/*      */ import java.sql.Connection;
/*      */ import java.text.DateFormat;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
import java.util.List;
import java.awt.EventQueue;

import java.sql.Connection;
import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.DefaultComboBoxModel;
/*      */ import javax.swing.DefaultListModel;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JList;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JPopupMenu;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.RowFilter;
/*      */ import javax.swing.UIManager;
/*      */ import javax.swing.UnsupportedLookAndFeelException;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.table.TableModel;
/*      */ import javax.swing.table.TableRowSorter;
/*      */ import model.bean.Company;
/*      */ import model.bean.Drug;
/*      */ import model.bean.Order;
/*      */ import model.bean.OrderDetails;
/*      */ import model.bean.OrderReady;
/*      */ import model.bean.PaymentMethod;
/*      */ import model.bean.Stock;
/*      */ import model.bean.Stock_1;
/*      */ import model.bean.User;
/*      */ import model.bean.UserActivity;
/*      */ import model.dao.CompanyDAO;
/*      */ import model.dao.DrugDAO;
/*      */ import model.dao.OrderDAO;
/*      */ import model.dao.OrderDetailsDAO;
/*      */ import model.dao.OrderReadyDAO;
/*      */ import model.dao.PaymentMethodDAO;
/*      */ import model.dao.StockDAO;
/*      */ import model.dao.StockDAO1;
/*      */ import model.dao.UserActivityDAO;
/*      */ import model.dao.UserDAO;
/*      */ import net.sf.jasperreports.engine.JRException;
/*      */ import net.sf.jasperreports.engine.JasperFillManager;
/*      */ import net.sf.jasperreports.engine.JasperPrint;
/*      */ import net.sf.jasperreports.engine.JasperReport;
/*      */ import net.sf.jasperreports.engine.design.JRDesignQuery;
/*      */ import net.sf.jasperreports.engine.design.JasperDesign;
/*      */ import net.sf.jasperreports.engine.xml.JRXmlLoader;
/*      */ import net.sf.jasperreports.view.JasperViewer;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperCompileManager;
/*      */ 
/*      */ public class mainWindow extends JFrame {
/*   80 */   DefaultListModel defaultListModel = new DefaultListModel();
/*   81 */   List<OrderDetails> orderSelldetails = new ArrayList<>();
/*   82 */   List<PaymentMethod> pMethodList = new ArrayList<>();
/*   83 */   double discount = 0.0D; User loggedUser; double total; int orderIdGeneral; double changeMoneyF; private JTextField Bill_nr; private JTextField CompanyContactPerson; private JDateChooser CompanyopenDate; private JPanel InventorioBtn; private JTextField TotalMoneyPeriod; private JTextField academic; private JTextField academicEdit; private JTextField academicRemove; private JComboBox<Object> accessType; private JPanel acessosBtn; private JButton addDrugBuyList; private JButton addDrugSellPoint; private JButton addPaymentPSBtn; private JTextField address; private JTextField addressEdit; private JTextField addressRemove; private JDateChooser age; private JDateChooser ageEdit; private JDateChooser ageRemove; private JTextField barCodeEdit; private JTextField barCodeEditTA; private JTextField barCodePointSell; private JTextField barCodeRemove; private JTextField barCodeSave; private JTextField barCodeSearch; private JTextField batchNrEdit; private JTextField batchNrRemove; private JTextField batchNrSave; private JTextField billNrSearch; private JTable buyListTb; private JTextField buyPriceEdit; private JTextField buyPriceRemove; private JComboBox<String> categSave; private JComboBox<String> categoryEdit; private JComboBox<String> categoryRemove; private JTextField changeMoney; private JComboBox<Object> comboBoxListRemove; private JComboBox<Object> comboUserAccess; private JTextField comercialNameEditTA; private JTextField comercialNamePointSell; private JTextField comercialNameRemove; private JTextField comercialNameSave; private JTextField companyAddress; private JButton companyEdit; private JTextField companyEmail; private JTextField companyName; private JTextField companyTelephone; private JTextField discountPointSell; private JTextField drugNameSearch; private JDateChooser entryDateEdit; private JDateChooser entryDateRemove; private JDateChooser entryDateSave; private JDateChooser expireDateEdit; private JDateChooser expireDateRemove; private JDateChooser expireDateSave; private JDateChooser finalDateField; private JComboBox<String> gender; private JComboBox<String> genderEdit; private JComboBox<String> genderRemove; private JButton generateBill; private JTextField genericNameEditTA; private JTextField genericNameRemove; private JTextField genericNameSave; private JDateChooser initDateField; private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton13; private JButton jButton14; private JButton jButton15; private JButton jButton16; private JButton jButton17; private JButton jButton18; private JButton jButton19; private JButton jButton2; private JButton jButton20; private JButton jButton21; private JButton jButton22; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton27; private JButton jButton28; private JButton jButton29; private JButton jButton3; private JButton jButton30; private JButton jButton31; private JButton jButton32; private JButton jButton33; private JButton jButton34; private JButton jButton4; private JButton jButton9; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel104; private JLabel jLabel105; private JLabel jLabel106; private JLabel jLabel107; private JLabel jLabel108; private JLabel jLabel109; private JLabel jLabel11; private JLabel jLabel110; private JLabel jLabel111; private JLabel jLabel112; private JLabel jLabel113; private JLabel jLabel114; private JLabel jLabel115; private JLabel jLabel116; private JLabel jLabel117; private JLabel jLabel118; private JLabel jLabel119; private JLabel jLabel12; private JLabel jLabel120; private JLabel jLabel121; private JLabel jLabel122; private JLabel jLabel123; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel13; private JLabel jLabel138; private JLabel jLabel139; private JLabel jLabel14; private JLabel jLabel140; private JLabel jLabel141; private JLabel jLabel142; private JLabel jLabel143; private JLabel jLabel15; private JLabel jLabel150; private JLabel jLabel151; private JLabel jLabel152; private JLabel jLabel154; private JLabel jLabel155; private JLabel jLabel156; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54;
/*      */   private JLabel jLabel55;
/*      */   private JLabel jLabel56;
/*      */   private JLabel jLabel57;
/*      */   private JLabel jLabel58;
/*      */   private JLabel jLabel59;
/*      */   private JLabel jLabel6;
/*      */   private JLabel jLabel60;
/*      */   private JLabel jLabel61;
/*      */   
/*      */   private void otherInitComponents() {
/*   94 */     this.suggestionsPopUp.add(this.suggestionsPanel);
/*   95 */     this.suggestionsPopUpRemove.add(this.suggestionsPanelRemove);
/*   96 */     this.suggestionsPopUpStock.add(this.suggestionsPanelSearchStock);
/*   97 */     this.suggestionsPopUpSell.add(this.suggestionsPanelSell);
/*      */     
/*   99 */     readTableStock();
/*  100 */     readComboUser();
/*  101 */     readUserTable();
/*  102 */     readOrdersTable();
/*      */   }
/*      */   private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel7; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel78; private JLabel jLabel79; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel87; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel92; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JLabel jLabel97; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel40; private JPanel jPanel41; private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel46; private JPanel jPanel47; private JPanel jPanel48; private JPanel jPanel49; private JPanel jPanel5; private JPanel jPanel50; private JPanel jPanel51; private JPanel jPanel52; private JPanel jPanel53; private JPanel jPanel54; private JPanel jPanel55; private JPanel jPanel56; private JPanel jPanel6; private JPanel jPanel62; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JScrollPane jScrollPane1; private JScrollPane jScrollPane10; private JScrollPane jScrollPane11; private JScrollPane jScrollPane12; private JScrollPane jScrollPane13; private JScrollPane jScrollPane14; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JScrollPane jScrollPane8; private JScrollPane jScrollPane9; private JSeparator jSeparator1; private JSeparator jSeparator2; private JSeparator jSeparator3; private JSeparator jSeparator4; private JSeparator jSeparator5; private JSeparator jSeparator6; private JSeparator jSeparator7; private JSeparator jSeparator9; private JTextField lasAccessTime; private JList<String> listOfSuggestions; private JList<String> listOfSuggestionsRemove; private JList<String> listOfSuggestionsSell; private JList<String> listOfSuggestionsStock; private JTextField loginAccess; private JTextField manufacturerEdit; private JTextField manufacturerRemove; private JTextField manufacturerSave; private JComboBox<String> maritalStatusEdit; private JComboBox<String> marital_status; private JComboBox<String> marital_statusRemove; private JComboBox<String> methodPayment; private JPanel modificarDadosDaEmpresaBtn; private JPanel modificarFuncionarioBtn; private JPanel modificarStockBtn; private JTextField moneyPaid; private JTextField nComercialEdit; private JTextField nComercialRemove; private JTextField name; private JTextField nameAccess; private JTextField nameEdit; private JTextField nameRemove; private JComboBox<Object> nameStuffSearch; private JButton newTotalBtn; private JTable orderDetailsTB; private JScrollPane ordersTable; private JTable ordersTableList; private JScrollPane paneltable; private JTextField passwordAccess; private JTable paymentMethodTB; private JPanel pontoDeVendasBtn; private JTextField prCompraSave; private JTextField prVendaSave; private JLabel qtyEditArea; private JTextField qtyEditTA; private JTextField qtyRemove; private JTextField qtySave; private JTextField qtyTextSellPoint; private JPanel relatorioDeVendasBtn; private JTextField salary; private JTextField salaryEdit; private JTextField salaryRemove; private JButton selectEdit; private JTextField sellPriceEdit; private JTextField sellPriceRemove; private JComboBox<Object> sellerComboBox; private JComboBox<Object> staffComboEdit; private JTextField stockBarCodeSearch; private JTextField stockNameSearch; private JTable stockTable; private JComboBox<String> subMethodPaymentPOS; private JButton submitDrugsSellPoint; private JPanel suggestionsPanel; private JPanel suggestionsPanelRemove; private JPanel suggestionsPanelSearchStock; private JPanel suggestionsPanelSell; private JPopupMenu suggestionsPopUp; private JPopupMenu suggestionsPopUpRemove; private JPopupMenu suggestionsPopUpSell; private JPopupMenu suggestionsPopUpStock; private JTextField supplierEdit; private JTextField supplierRemove; private JTextField supplierSave; private JTextField telephone; private JTextField telephoneEdit; private JTextField telephoneRemove; private JTextField totalInSTockMoney; private JTextField totalToPay; private JTextField unitEdit; private JTextField unitRemove; private JTextField unitSave; private JTable userActivityTB; private JTable usersTable; private JPanel verFuncionariosBtn;
/*      */   private void readTableStock() {
/*  106 */     DefaultTableModel tableModel = (DefaultTableModel)this.stockTable.getModel();
/*  107 */     tableModel.setNumRows(0);
/*      */     
/*  109 */     int index = 1;
/*  110 */     double total_money = 0.0D;
/*      */     
/*  112 */     StockDAO1 std = new StockDAO1();
/*  113 */     for (Stock_1 s : std.returnAllStocks()) {
/*  114 */       tableModel.addRow(new Object[] { 
/*  115 */             Integer.valueOf(index), s
/*  116 */             .getBar_code(), 
/*  117 */             Integer.valueOf(s.getBatch_nr()), s
/*  118 */             .getGeneric_name(), s
/*  119 */             .getComercial_name(), s
/*      */             
/*  121 */             .getCategory(), 
/*  122 */             Double.valueOf(s.getQuantity()), 
/*  123 */             Double.valueOf(s.getUnit_sell_price()), 
/*  124 */             Double.valueOf(s.getPurchase_price()), s
/*  125 */             .getSupplier(), s
/*  126 */             .getManufacturer(), s
/*  127 */             .getEntry_date(), s
/*  128 */             .getExpire_date() });
/*      */ 
/*      */       
/*  131 */       total_money += s.getQuantity() * s.getUnit_sell_price();
/*  132 */       index++;
/*      */     } 
/*      */ 
/*      */     
/*  136 */     this.totalInSTockMoney.setText(String.valueOf(total_money));
/*      */   }
/*      */ 
/*      */   
/*      */   private void readUserTable() {
/*  141 */     DefaultTableModel tableModel = (DefaultTableModel)this.usersTable.getModel();
/*  142 */     tableModel.setNumRows(0);
/*  143 */     int index = 1;
/*  144 */     UserDAO uda = new UserDAO();
/*  145 */     for (User u : uda.returnAllUsers()) {
/*  146 */       tableModel.addRow(new Object[] {
/*  147 */             Integer.valueOf(index), u
/*  148 */             .getName(), u
/*  149 */             .getBirth_date(), u
/*  150 */             .getGender(), u
/*  151 */             .getMarital_status(), u
/*  152 */             .getAddress(), 
/*  153 */             Integer.valueOf(u.getTelephone()), u
/*  154 */             .getAcademic(), 
/*  155 */             Double.valueOf(u.getSalary())
/*      */           });
/*  157 */       index++;
/*      */     } 
/*      */   }
/*      */   private void readUserTableSearchAccess(User user) {
/*  161 */     this.nameAccess.setText(user.getName());
/*  162 */     this.loginAccess.setText(user.getLogin());
/*  163 */     this.passwordAccess.setText(user.getPassword());
/*  164 */     this.accessType.setSelectedItem(user.getAccess_type());
/*      */   }
/*      */ 
/*      */   
/*      */   public void setActualUser(User user) {
/*  169 */     this.loggedUser = user;
/*      */   }
/*      */   
/*      */   private void readUserTableSearch(User user) {
/*  173 */     DefaultTableModel tableModel = (DefaultTableModel)this.usersTable.getModel();
/*  174 */     tableModel.setNumRows(0);
/*      */ 
/*      */     
/*  177 */     int index = 1;
/*      */ 
/*      */     
/*  180 */     tableModel.addRow(new Object[] {
/*  181 */           Integer.valueOf(index), user
/*  182 */           .getName(), user
/*  183 */           .getBirth_date(), user
/*  184 */           .getGender(), user
/*  185 */           .getMarital_status(), user
/*  186 */           .getAddress(), 
/*  187 */           Integer.valueOf(user.getTelephone()), user
/*  188 */           .getAcademic(), 
/*  189 */           Double.valueOf(user.getSalary())
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void setOrderPaymentAndDetailsEmpty() {
/*  196 */     DefaultTableModel tableModelD = (DefaultTableModel)this.orderDetailsTB.getModel();
/*  197 */     tableModelD.setNumRows(0);
/*      */     
/*  199 */     DefaultTableModel tableModelP = (DefaultTableModel)this.paymentMethodTB.getModel();
/*  200 */     tableModelP.setNumRows(0);
/*      */   }
/*      */   private void readOrderDetaisTable(int order_id) {
/*  203 */     DefaultTableModel tableModel = (DefaultTableModel)this.orderDetailsTB.getModel();
/*  204 */     tableModel.setNumRows(0);
/*      */     
/*  206 */     OrderDetailsDAO odd = new OrderDetailsDAO();
/*  207 */     for (OrderDetails orderDetails : odd.getOrderDetails(order_id)) {
/*  208 */       Drug d = orderDetails.getDrug();
/*  209 */       tableModel.addRow(new Object[] { d
/*  210 */             .getGeneric_name(), 
/*  211 */             Double.valueOf(orderDetails.getQuantity()), 
/*  212 */             Double.valueOf(orderDetails.getTotal_price()) });
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void readOrderPaymentMethodTable(int order_id) {
/*  218 */     DefaultTableModel tableModel = (DefaultTableModel)this.paymentMethodTB.getModel();
/*  219 */     tableModel.setNumRows(0);
/*      */     
/*  221 */     PaymentMethodDAO pm = new PaymentMethodDAO();
/*  222 */     for (PaymentMethod payM : pm.getPaymentMethods(order_id)) {
/*      */       
/*  224 */       tableModel.addRow(new Object[] { payM
/*  225 */             .getMethod(), payM
/*  226 */             .getSub_method(), 
/*  227 */             Double.valueOf(payM.getMoney_paid()) });
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void readAllOrders() {
/*  233 */     OrderDAO od = new OrderDAO();
/*  234 */     double totalSold = 0.0D;
/*      */     
/*  236 */     DefaultTableModel tableModel = (DefaultTableModel)this.ordersTableList.getModel();
/*  237 */     tableModel.setNumRows(0);
/*      */ 
/*      */     
/*  240 */     for (Order or : od.returnAllOrders()) {
/*  241 */       tableModel.addRow(new Object[] {
/*  242 */             Integer.valueOf(or.getOrder_id()), 
/*  243 */             Double.valueOf(or.getBill_money()), 
/*  244 */             Double.valueOf(or.getDiscount()), 
/*  245 */             Double.valueOf(or.getTotal_paid()), 
/*  246 */             Double.valueOf(or.getReturn_money()), or
/*  247 */             .getUser().getName(), or
/*  248 */             .getDate()
/*      */           });
/*  250 */       totalSold += or.getBill_money();
/*      */     } 
/*  252 */     this.TotalMoneyPeriod.setText(String.valueOf(totalSold));
/*      */   }
/*      */   
/*      */   private void readOrdersTable() {
/*  256 */     OrderDAO od = new OrderDAO();
/*  257 */     double totalSold = 0.0D;
/*      */     
/*  259 */     DefaultTableModel tableModel = (DefaultTableModel)this.ordersTableList.getModel();
/*  260 */     tableModel.setNumRows(0);
/*      */     
/*  262 */     for (Order or : od.returnTodayOrders()) {
/*  263 */       tableModel.addRow(new Object[] {
/*  264 */             Integer.valueOf(or.getOrder_id()), 
/*  265 */             Double.valueOf(or.getBill_money()), 
/*  266 */             Double.valueOf(or.getDiscount()), 
/*  267 */             Double.valueOf(or.getTotal_paid()), 
/*  268 */             Double.valueOf(or.getReturn_money()), or
/*  269 */             .getUser().getName(), or
/*  270 */             .getDate()
/*      */           });
/*  272 */       totalSold += or.getBill_money();
/*      */     } 
/*  274 */     this.TotalMoneyPeriod.setText(String.valueOf(totalSold));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void readOrdersTableSearch(String initDate, String finalDate) {
/*  281 */     OrderDAO od = new OrderDAO();
/*  282 */     double totalSold = 0.0D;
/*  283 */     DefaultTableModel tableModel = (DefaultTableModel)this.ordersTableList.getModel();
/*  284 */     tableModel.setNumRows(0);
/*      */ 
/*      */     
/*  287 */     for (Order or : od.returnAllOrdersByDate(initDate, finalDate)) {
/*  288 */       tableModel.addRow(new Object[] {
/*  289 */             Integer.valueOf(or.getOrder_id()), 
/*  290 */             Double.valueOf(or.getBill_money()), 
/*  291 */             Double.valueOf(or.getDiscount()), 
/*  292 */             Double.valueOf(or.getTotal_paid()), 
/*  293 */             Double.valueOf(or.getReturn_money()), or
/*  294 */             .getUser().getName(), or
/*  295 */             .getDate()
/*      */           });
/*  297 */       totalSold += or.getBill_money();
/*      */     } 
/*  299 */     this.TotalMoneyPeriod.setText(String.valueOf(totalSold));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void searchInStockByComercialName(String comercial_name) {
/*  305 */     DefaultTableModel tableModel = (DefaultTableModel)this.stockTable.getModel();
/*  306 */     tableModel.setNumRows(0);
/*      */     
/*  308 */     int index = 1;
/*  309 */     double total_money = 0.0D;
/*      */     
/*  311 */     StockDAO1 std = new StockDAO1();
/*  312 */     for (Stock_1 s : std.returnAllStocks()) {
/*  313 */       if (s.getComercial_name().equals(comercial_name.toLowerCase())) {
/*      */         
/*  315 */         tableModel.addRow(new Object[] { 
/*  316 */               Integer.valueOf(index), s
/*  317 */               .getBar_code(), 
/*  318 */               Integer.valueOf(s.getBatch_nr()), s
/*  319 */               .getGeneric_name(), s
/*  320 */               .getComercial_name(), s
/*      */               
/*  322 */               .getCategory(), 
/*  323 */               Double.valueOf(s.getQuantity()), 
/*  324 */               Double.valueOf(s.getUnit_sell_price()), 
/*  325 */               Double.valueOf(s.getPurchase_price()), s
/*  326 */               .getSupplier(), s
/*  327 */               .getManufacturer(), s
/*  328 */               .getEntry_date(), s
/*  329 */               .getExpire_date() });
/*      */ 
/*      */         
/*  332 */         total_money += s.getQuantity() * s.getUnit_sell_price();
/*  333 */         index++;
/*      */       } 
/*      */     } 
/*      */     
/*  337 */     if (tableModel.getRowCount() == 0) {
/*  338 */       JOptionPane.showMessageDialog(null, "Nenhum Resultado Para A Pesquisa");
/*      */     }
/*      */ 
/*      */     
/*  342 */     this.totalInSTockMoney.setText(String.valueOf(total_money));
/*      */   }
/*      */ 
/*      */   
/*      */   private void searchInStockByBarCode(String bar_code) {
/*  347 */     DefaultTableModel tableModel = (DefaultTableModel)this.stockTable.getModel();
/*  348 */     tableModel.setNumRows(0);
/*      */     
/*  350 */     int index = 1;
/*  351 */     double total_money = 0.0D;
/*      */     
/*  353 */     StockDAO1 std = new StockDAO1();
/*  354 */     for (Stock_1 s : std.returnAllStocks()) {
/*  355 */       if (s.getBar_code().equals(bar_code)) {
/*      */         
/*  357 */         tableModel.addRow(new Object[] { 
/*  358 */               Integer.valueOf(index), s
/*  359 */               .getBar_code(), 
/*  360 */               Integer.valueOf(s.getBatch_nr()), s
/*  361 */               .getGeneric_name(), s
/*  362 */               .getComercial_name(), s
/*      */               
/*  364 */               .getCategory(), 
/*  365 */               Double.valueOf(s.getQuantity()), 
/*  366 */               Double.valueOf(s.getUnit_sell_price()), 
/*  367 */               Double.valueOf(s.getPurchase_price()), s
/*  368 */               .getSupplier(), s
/*  369 */               .getManufacturer(), s
/*  370 */               .getEntry_date(), s
/*  371 */               .getExpire_date() });
/*      */ 
/*      */         
/*  374 */         total_money += s.getQuantity() * s.getUnit_sell_price();
/*  375 */         index++;
/*      */       } 
/*      */     } 
/*      */     
/*  379 */     if (tableModel.getRowCount() == 0) {
/*  380 */       JOptionPane.showMessageDialog(null, "Nenhum Resultado Para A Pesquisa");
/*      */     }
/*      */     
/*  383 */     this.totalInSTockMoney.setText(String.valueOf(total_money));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void readComboUser() {
/*  390 */     UserDAO ud = new UserDAO();
/*  391 */     this.staffComboEdit.removeAllItems();
/*  392 */     this.comboBoxListRemove.removeAllItems();
/*  393 */     this.nameStuffSearch.removeAllItems();
/*  394 */     this.comboUserAccess.removeAllItems();
/*  395 */     this.sellerComboBox.removeAllItems();
/*  396 */     for (User u : ud.returnAllUsers()) {
/*  397 */       this.staffComboEdit.addItem(u);
/*  398 */       this.comboBoxListRemove.addItem(u);
/*  399 */       this.nameStuffSearch.addItem(u);
/*  400 */       this.comboUserAccess.addItem(u);
/*  401 */       this.sellerComboBox.addItem(u);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void initComponents() {
/*  413 */     this.suggestionsPanel = new JPanel();
/*  414 */     this.jScrollPane9 = new JScrollPane();
/*  415 */     this.listOfSuggestions = new JList<>();
/*  416 */     this.suggestionsPopUp = new JPopupMenu();
/*  417 */     this.suggestionsPopUpRemove = new JPopupMenu();
/*  418 */     this.suggestionsPanelRemove = new JPanel();
/*  419 */     this.jScrollPane10 = new JScrollPane();
/*  420 */     this.listOfSuggestionsRemove = new JList<>();
/*  421 */     this.suggestionsPanelSearchStock = new JPanel();
/*  422 */     this.jScrollPane11 = new JScrollPane();
/*  423 */     this.listOfSuggestionsStock = new JList<>();
/*  424 */     this.suggestionsPopUpStock = new JPopupMenu();
/*  425 */     this.suggestionsPanelSell = new JPanel();
/*  426 */     this.jScrollPane14 = new JScrollPane();
/*  427 */     this.listOfSuggestionsSell = new JList<>();
/*  428 */     this.suggestionsPopUpSell = new JPopupMenu();
/*  429 */     this.jPanel3 = new JPanel();
/*  430 */     this.jPanel1 = new JPanel();
/*  431 */     this.jPanel29 = new JPanel();
/*  432 */     this.jLabel77 = new JLabel();
/*  433 */     this.jPanel4 = new JPanel();
/*  434 */     this.pontoDeVendasBtn = new JPanel();
/*  435 */     this.jLabel61 = new JLabel();
/*  436 */     this.jLabel62 = new JLabel();
/*  437 */     this.jLabel63 = new JLabel();
/*  438 */     this.relatorioDeVendasBtn = new JPanel();
/*  439 */     this.jLabel64 = new JLabel();
/*  440 */     this.jLabel65 = new JLabel();
/*  441 */     this.jLabel66 = new JLabel();
/*  442 */     this.InventorioBtn = new JPanel();
/*  443 */     this.jLabel58 = new JLabel();
/*  444 */     this.jLabel59 = new JLabel();
/*  445 */     this.jLabel60 = new JLabel();
/*  446 */     this.modificarStockBtn = new JPanel();
/*  447 */     this.jLabel55 = new JLabel();
/*  448 */     this.jLabel56 = new JLabel();
/*  449 */     this.jLabel57 = new JLabel();
/*  450 */     this.verFuncionariosBtn = new JPanel();
/*  451 */     this.jLabel34 = new JLabel();
/*  452 */     this.jLabel35 = new JLabel();
/*  453 */     this.jLabel36 = new JLabel();
/*  454 */     this.modificarFuncionarioBtn = new JPanel();
/*  455 */     this.jLabel46 = new JLabel();
/*  456 */     this.jLabel47 = new JLabel();
/*  457 */     this.jLabel48 = new JLabel();
/*  458 */     this.acessosBtn = new JPanel();
/*  459 */     this.jLabel49 = new JLabel();
/*  460 */     this.jLabel50 = new JLabel();
/*  461 */     this.jLabel51 = new JLabel();
/*  462 */     this.modificarDadosDaEmpresaBtn = new JPanel();
/*  463 */     this.jLabel52 = new JLabel();
/*  464 */     this.jLabel53 = new JLabel();
/*  465 */     this.jLabel54 = new JLabel();
/*  466 */     this.jPanel15 = new JPanel();
/*  467 */     this.jPanel2 = new JPanel();
/*  468 */     this.jPanel5 = new JPanel();
/*  469 */     this.jPanel56 = new JPanel();
/*  470 */     this.jLabel125 = new JLabel();
/*  471 */     this.jButton3 = new JButton();
/*  472 */     this.jPanel14 = new JPanel();
/*  473 */     this.jPanel6 = new JPanel();
/*  474 */     this.jPanel7 = new JPanel();
/*  475 */     this.jLabel1 = new JLabel();
/*  476 */     this.jPanel11 = new JPanel();
/*  477 */     this.jLabel5 = new JLabel();
/*  478 */     this.jLabel6 = new JLabel();
/*  479 */     this.qtyTextSellPoint = new JTextField();
/*  480 */     this.barCodePointSell = new JTextField();
/*  481 */     this.jLabel7 = new JLabel();
/*  482 */     this.comercialNamePointSell = new JTextField();
/*  483 */     this.addDrugBuyList = new JButton();
/*  484 */     this.addDrugSellPoint = new JButton();
/*  485 */     this.Bill_nr = new JTextField();
/*  486 */     this.submitDrugsSellPoint = new JButton();
/*  487 */     this.jPanel12 = new JPanel();
/*  488 */     this.jLabel8 = new JLabel();
/*  489 */     this.totalToPay = new JTextField();
/*  490 */     this.jLabel9 = new JLabel();
/*  491 */     this.discountPointSell = new JTextField();
/*  492 */     this.moneyPaid = new JTextField();
/*  493 */     this.jLabel10 = new JLabel();
/*  494 */     this.jLabel11 = new JLabel();
/*  495 */     this.subMethodPaymentPOS = new JComboBox<>();
/*  496 */     this.methodPayment = new JComboBox<>();
/*  497 */     this.jLabel12 = new JLabel();
/*  498 */     this.changeMoney = new JTextField();
/*  499 */     this.addPaymentPSBtn = new JButton();
/*  500 */     this.newTotalBtn = new JButton();
/*  501 */     this.generateBill = new JButton();
/*  502 */     this.jSeparator1 = new JSeparator();
/*  503 */     this.jScrollPane1 = new JScrollPane();
/*  504 */     this.buyListTb = new JTable();
/*  505 */     this.jButton1 = new JButton();
/*  506 */     this.jPanel9 = new JPanel();
/*  507 */     this.jPanel10 = new JPanel();
/*  508 */     this.jLabel3 = new JLabel();
/*  509 */     this.jPanel13 = new JPanel();
/*  510 */     this.jSeparator3 = new JSeparator();
/*  511 */     this.jLabel16 = new JLabel();
/*  512 */     this.sellerComboBox = new JComboBox();
/*  513 */     this.drugNameSearch = new JTextField();
/*  514 */     this.jLabel17 = new JLabel();
/*  515 */     this.jLabel18 = new JLabel();
/*  516 */     this.TotalMoneyPeriod = new JTextField();
/*  517 */     this.finalDateField = new JDateChooser();
/*  518 */     this.jLabel19 = new JLabel();
/*  519 */     this.initDateField = new JDateChooser();
/*  520 */     this.billNrSearch = new JTextField();
/*  521 */     this.jButton9 = new JButton();
/*  522 */     this.jButton10 = new JButton();
/*  523 */     this.jButton11 = new JButton();
/*  524 */     this.jButton12 = new JButton();
/*  525 */     this.jButton13 = new JButton();
/*  526 */     this.jButton15 = new JButton();
/*  527 */     this.jButton2 = new JButton();
/*  528 */     this.jButton4 = new JButton();
/*  529 */     this.jPanel17 = new JPanel();
/*  530 */     this.jScrollPane5 = new JScrollPane();
/*  531 */     this.orderDetailsTB = new JTable();
/*  532 */     this.jPanel18 = new JPanel();
/*  533 */     this.jScrollPane4 = new JScrollPane();
/*  534 */     this.paymentMethodTB = new JTable();
/*  535 */     this.ordersTable = new JScrollPane();
/*  536 */     this.jPanel27 = new JPanel();
/*  537 */     this.paneltable = new JScrollPane();
/*  538 */     this.ordersTableList = new JTable();
/*  539 */     this.jPanel19 = new JPanel();
/*  540 */     this.jPanel20 = new JPanel();
/*  541 */     this.jLabel4 = new JLabel();
/*  542 */     this.jPanel21 = new JPanel();
/*  543 */     this.jLabel14 = new JLabel();
/*  544 */     this.comboUserAccess = new JComboBox();
/*  545 */     this.jButton16 = new JButton();
/*  546 */     this.jScrollPane3 = new JScrollPane();
/*  547 */     this.jPanel50 = new JPanel();
/*  548 */     this.jPanel51 = new JPanel();
/*  549 */     this.jLabel118 = new JLabel();
/*  550 */     this.lasAccessTime = new JTextField();
/*  551 */     this.jSeparator6 = new JSeparator();
/*  552 */     this.jScrollPane8 = new JScrollPane();
/*  553 */     this.userActivityTB = new JTable();
/*  554 */     this.jPanel52 = new JPanel();
/*  555 */     this.jLabel119 = new JLabel();
/*  556 */     this.nameAccess = new JTextField();
/*  557 */     this.loginAccess = new JTextField();
/*  558 */     this.jLabel120 = new JLabel();
/*  559 */     this.passwordAccess = new JTextField();
/*  560 */     this.jLabel121 = new JLabel();
/*  561 */     this.jLabel122 = new JLabel();
/*  562 */     this.accessType = new JComboBox();
/*  563 */     this.jButton14 = new JButton();
/*  564 */     this.jPanel24 = new JPanel();
/*  565 */     this.jPanel25 = new JPanel();
/*  566 */     this.jLabel15 = new JLabel();
/*  567 */     this.jPanel26 = new JPanel();
/*  568 */     this.jPanel8 = new JPanel();
/*  569 */     this.jLabel2 = new JLabel();
/*  570 */     this.jPanel30 = new JPanel();
/*  571 */     this.jLabel20 = new JLabel();
/*  572 */     this.jPanel31 = new JPanel();
/*  573 */     this.jLabel21 = new JLabel();
/*  574 */     this.jPanel22 = new JPanel();
/*  575 */     this.jPanel23 = new JPanel();
/*  576 */     this.jLabel38 = new JLabel();
/*  577 */     this.barCodeSave = new JTextField();
/*  578 */     this.genericNameSave = new JTextField();
/*  579 */     this.jLabel39 = new JLabel();
/*  580 */     this.jLabel40 = new JLabel();
/*  581 */     this.comercialNameSave = new JTextField();
/*  582 */     this.batchNrSave = new JTextField();
/*  583 */     this.jLabel41 = new JLabel();
/*  584 */     this.jLabel42 = new JLabel();
/*  585 */     this.qtySave = new JTextField();
/*  586 */     this.jLabel43 = new JLabel();
/*  587 */     this.jLabel44 = new JLabel();
/*  588 */     this.unitSave = new JTextField();
/*  589 */     this.manufacturerSave = new JTextField();
/*  590 */     this.jLabel45 = new JLabel();
/*  591 */     this.jLabel67 = new JLabel();
/*  592 */     this.supplierSave = new JTextField();
/*  593 */     this.jLabel68 = new JLabel();
/*  594 */     this.jLabel69 = new JLabel();
/*  595 */     this.prVendaSave = new JTextField();
/*  596 */     this.jLabel70 = new JLabel();
/*  597 */     this.expireDateSave = new JDateChooser();
/*  598 */     this.entryDateSave = new JDateChooser();
/*  599 */     this.categSave = new JComboBox<>();
/*  600 */     this.jLabel71 = new JLabel();
/*  601 */     this.prCompraSave = new JTextField();
/*  602 */     this.jButton18 = new JButton();
/*  603 */     this.jButton19 = new JButton();
/*  604 */     this.jPanel32 = new JPanel();
/*  605 */     this.jLabel72 = new JLabel();
/*  606 */     this.barCodeEditTA = new JTextField();
/*  607 */     this.genericNameEditTA = new JTextField();
/*  608 */     this.jLabel73 = new JLabel();
/*  609 */     this.jLabel74 = new JLabel();
/*  610 */     this.comercialNameEditTA = new JTextField();
/*  611 */     this.batchNrEdit = new JTextField();
/*  612 */     this.jLabel75 = new JLabel();
/*  613 */     this.jLabel76 = new JLabel();
/*  614 */     this.qtyEditTA = new JTextField();
/*  615 */     this.qtyEditArea = new JLabel();
/*  616 */     this.jLabel78 = new JLabel();
/*  617 */     this.unitEdit = new JTextField();
/*  618 */     this.manufacturerEdit = new JTextField();
/*  619 */     this.jLabel79 = new JLabel();
/*  620 */     this.jLabel80 = new JLabel();
/*  621 */     this.supplierEdit = new JTextField();
/*  622 */     this.jLabel81 = new JLabel();
/*  623 */     this.jLabel82 = new JLabel();
/*  624 */     this.sellPriceEdit = new JTextField();
/*  625 */     this.jLabel83 = new JLabel();
/*  626 */     this.expireDateEdit = new JDateChooser();
/*  627 */     this.entryDateEdit = new JDateChooser();
/*  628 */     this.categoryEdit = new JComboBox<>();
/*  629 */     this.jLabel84 = new JLabel();
/*  630 */     this.buyPriceEdit = new JTextField();
/*  631 */     this.jSeparator2 = new JSeparator();
/*  632 */     this.jLabel22 = new JLabel();
/*  633 */     this.jLabel23 = new JLabel();
/*  634 */     this.nComercialEdit = new JTextField();
/*  635 */     this.barCodeEdit = new JTextField();
/*  636 */     this.selectEdit = new JButton();
/*  637 */     this.jButton22 = new JButton();
/*  638 */     this.jButton23 = new JButton();
/*  639 */     this.jPanel33 = new JPanel();
/*  640 */     this.jLabel85 = new JLabel();
/*  641 */     this.barCodeRemove = new JTextField();
/*  642 */     this.genericNameRemove = new JTextField();
/*  643 */     this.jLabel86 = new JLabel();
/*  644 */     this.jLabel87 = new JLabel();
/*  645 */     this.comercialNameRemove = new JTextField();
/*  646 */     this.batchNrRemove = new JTextField();
/*  647 */     this.jLabel88 = new JLabel();
/*  648 */     this.jLabel89 = new JLabel();
/*  649 */     this.qtyRemove = new JTextField();
/*  650 */     this.jLabel90 = new JLabel();
/*  651 */     this.jLabel91 = new JLabel();
/*  652 */     this.unitRemove = new JTextField();
/*  653 */     this.manufacturerRemove = new JTextField();
/*  654 */     this.jLabel92 = new JLabel();
/*  655 */     this.jLabel93 = new JLabel();
/*  656 */     this.supplierRemove = new JTextField();
/*  657 */     this.jLabel94 = new JLabel();
/*  658 */     this.jLabel95 = new JLabel();
/*  659 */     this.sellPriceRemove = new JTextField();
/*  660 */     this.jLabel96 = new JLabel();
/*  661 */     this.expireDateRemove = new JDateChooser();
/*  662 */     this.entryDateRemove = new JDateChooser();
/*  663 */     this.categoryRemove = new JComboBox<>();
/*  664 */     this.jLabel97 = new JLabel();
/*  665 */     this.buyPriceRemove = new JTextField();
/*  666 */     this.jSeparator4 = new JSeparator();
/*  667 */     this.jLabel24 = new JLabel();
/*  668 */     this.jLabel25 = new JLabel();
/*  669 */     this.nComercialRemove = new JTextField();
/*  670 */     this.barCodeSearch = new JTextField();
/*  671 */     this.jButton21 = new JButton();
/*  672 */     this.jButton24 = new JButton();
/*  673 */     this.jPanel34 = new JPanel();
/*  674 */     this.jPanel35 = new JPanel();
/*  675 */     this.jLabel26 = new JLabel();
/*  676 */     this.jPanel36 = new JPanel();
/*  677 */     this.jLabel27 = new JLabel();
/*  678 */     this.stockNameSearch = new JTextField();
/*  679 */     this.stockBarCodeSearch = new JTextField();
/*  680 */     this.jLabel28 = new JLabel();
/*  681 */     this.totalInSTockMoney = new JTextField();
/*  682 */     this.jButton17 = new JButton();
/*  683 */     this.jButton20 = new JButton();
/*  684 */     this.jScrollPane6 = new JScrollPane();
/*  685 */     this.jPanel16 = new JPanel();
/*  686 */     this.jScrollPane13 = new JScrollPane();
/*  687 */     this.stockTable = new JTable();
/*  688 */     this.jPanel37 = new JPanel();
/*  689 */     this.jPanel38 = new JPanel();
/*  690 */     this.jLabel29 = new JLabel();
/*  691 */     this.jPanel39 = new JPanel();
/*  692 */     this.jPanel40 = new JPanel();
/*  693 */     this.jLabel13 = new JLabel();
/*  694 */     this.jPanel41 = new JPanel();
/*  695 */     this.jLabel30 = new JLabel();
/*  696 */     this.jPanel42 = new JPanel();
/*  697 */     this.jLabel31 = new JLabel();
/*  698 */     this.jPanel43 = new JPanel();
/*  699 */     this.jPanel44 = new JPanel();
/*  700 */     this.jLabel98 = new JLabel();
/*  701 */     this.name = new JTextField();
/*  702 */     this.jLabel99 = new JLabel();
/*  703 */     this.jLabel100 = new JLabel();
/*  704 */     this.salary = new JTextField();
/*  705 */     this.jLabel101 = new JLabel();
/*  706 */     this.jLabel104 = new JLabel();
/*  707 */     this.address = new JTextField();
/*  708 */     this.jLabel105 = new JLabel();
/*  709 */     this.jLabel106 = new JLabel();
/*  710 */     this.telephone = new JTextField();
/*  711 */     this.jLabel107 = new JLabel();
/*  712 */     this.academic = new JTextField();
/*  713 */     this.age = new JDateChooser();
/*  714 */     this.gender = new JComboBox<>();
/*  715 */     this.jButton25 = new JButton();
/*  716 */     this.jButton26 = new JButton();
/*  717 */     this.marital_status = new JComboBox<>();
/*  718 */     this.jPanel45 = new JPanel();
/*  719 */     this.staffComboEdit = new JComboBox();
/*  720 */     this.jSeparator5 = new JSeparator();
/*  721 */     this.jLabel33 = new JLabel();
/*  722 */     this.jButton27 = new JButton();
/*  723 */     this.jButton28 = new JButton();
/*  724 */     this.jButton29 = new JButton();
/*  725 */     this.jLabel102 = new JLabel();
/*  726 */     this.nameEdit = new JTextField();
/*  727 */     this.ageEdit = new JDateChooser();
/*  728 */     this.jLabel103 = new JLabel();
/*  729 */     this.jLabel108 = new JLabel();
/*  730 */     this.genderEdit = new JComboBox<>();
/*  731 */     this.salaryEdit = new JTextField();
/*  732 */     this.jLabel109 = new JLabel();
/*  733 */     this.academicEdit = new JTextField();
/*  734 */     this.telephoneEdit = new JTextField();
/*  735 */     this.addressEdit = new JTextField();
/*  736 */     this.maritalStatusEdit = new JComboBox<>();
/*  737 */     this.jLabel110 = new JLabel();
/*  738 */     this.jLabel138 = new JLabel();
/*  739 */     this.jLabel139 = new JLabel();
/*  740 */     this.jLabel140 = new JLabel();
/*  741 */     this.jPanel47 = new JPanel();
/*  742 */     this.comboBoxListRemove = new JComboBox();
/*  743 */     this.jSeparator7 = new JSeparator();
/*  744 */     this.jLabel111 = new JLabel();
/*  745 */     this.jButton32 = new JButton();
/*  746 */     this.jButton33 = new JButton();
/*  747 */     this.jLabel112 = new JLabel();
/*  748 */     this.nameRemove = new JTextField();
/*  749 */     this.ageRemove = new JDateChooser();
/*  750 */     this.jLabel113 = new JLabel();
/*  751 */     this.jLabel114 = new JLabel();
/*  752 */     this.genderRemove = new JComboBox<>();
/*  753 */     this.salaryRemove = new JTextField();
/*  754 */     this.jLabel115 = new JLabel();
/*  755 */     this.academicRemove = new JTextField();
/*  756 */     this.telephoneRemove = new JTextField();
/*  757 */     this.addressRemove = new JTextField();
/*  758 */     this.marital_statusRemove = new JComboBox<>();
/*  759 */     this.jLabel116 = new JLabel();
/*  760 */     this.jLabel141 = new JLabel();
/*  761 */     this.jLabel142 = new JLabel();
/*  762 */     this.jLabel143 = new JLabel();
/*  763 */     this.jPanel46 = new JPanel();
/*  764 */     this.jPanel48 = new JPanel();
/*  765 */     this.jLabel32 = new JLabel();
/*  766 */     this.jPanel49 = new JPanel();
/*  767 */     this.jLabel37 = new JLabel();
/*  768 */     this.jButton30 = new JButton();
/*  769 */     this.jButton31 = new JButton();
/*  770 */     this.nameStuffSearch = new JComboBox();
/*  771 */     this.jScrollPane7 = new JScrollPane();
/*  772 */     this.jPanel28 = new JPanel();
/*  773 */     this.jScrollPane12 = new JScrollPane();
/*  774 */     this.usersTable = new JTable();
/*  775 */     this.jPanel53 = new JPanel();
/*  776 */     this.jPanel54 = new JPanel();
/*  777 */     this.jLabel117 = new JLabel();
/*  778 */     this.jPanel55 = new JPanel();
/*  779 */     this.jLabel123 = new JLabel();
/*  780 */     this.jLabel124 = new JLabel();
/*  781 */     this.jPanel62 = new JPanel();
/*  782 */     this.jSeparator9 = new JSeparator();
/*  783 */     this.jLabel150 = new JLabel();
/*  784 */     this.companyName = new JTextField();
/*  785 */     this.jLabel151 = new JLabel();
/*  786 */     this.jLabel152 = new JLabel();
/*  787 */     this.companyAddress = new JTextField();
/*  788 */     this.companyEmail = new JTextField();
/*  789 */     this.jLabel154 = new JLabel();
/*  790 */     this.jLabel155 = new JLabel();
/*  791 */     this.jLabel156 = new JLabel();
/*  792 */     this.CompanyopenDate = new JDateChooser();
/*  793 */     this.companyTelephone = new JTextField();
/*  794 */     this.jButton34 = new JButton();
/*  795 */     this.companyEdit = new JButton();
/*  796 */     this.CompanyContactPerson = new JTextField();
/*      */     
/*  798 */     this.listOfSuggestions.setFont(new Font("Segoe UI", 0, 14));
/*  799 */     this.listOfSuggestions.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  801 */             mainWindow.this.listOfSuggestionsMouseClicked(evt);
/*      */           }
/*      */         });
/*  804 */     this.jScrollPane9.setViewportView(this.listOfSuggestions);
/*      */     
/*  806 */     GroupLayout suggestionsPanelLayout = new GroupLayout(this.suggestionsPanel);
/*  807 */     this.suggestionsPanel.setLayout(suggestionsPanelLayout);
/*  808 */     suggestionsPanelLayout.setHorizontalGroup(suggestionsPanelLayout
/*  809 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  810 */         .addComponent(this.jScrollPane9, -1, 212, 32767));
/*      */     
/*  812 */     suggestionsPanelLayout.setVerticalGroup(suggestionsPanelLayout
/*  813 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  814 */         .addComponent(this.jScrollPane9, -1, 149, 32767));
/*      */ 
/*      */     
/*  817 */     this.suggestionsPopUp.setBorderPainted(false);
/*  818 */     this.suggestionsPopUp.setFocusable(false);
/*  819 */     this.suggestionsPopUp.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  821 */             mainWindow.this.suggestionsPopUpMouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  825 */     this.suggestionsPopUpRemove.setBorderPainted(false);
/*  826 */     this.suggestionsPopUpRemove.setFocusable(false);
/*  827 */     this.suggestionsPopUpRemove.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  829 */             mainWindow.this.suggestionsPopUpRemoveMouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  833 */     this.listOfSuggestionsRemove.setFont(new Font("Segoe UI", 0, 14));
/*  834 */     this.listOfSuggestionsRemove.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  836 */             mainWindow.this.listOfSuggestionsRemoveMouseClicked(evt);
/*      */           }
/*      */         });
/*  839 */     this.jScrollPane10.setViewportView(this.listOfSuggestionsRemove);
/*      */     
/*  841 */     GroupLayout suggestionsPanelRemoveLayout = new GroupLayout(this.suggestionsPanelRemove);
/*  842 */     this.suggestionsPanelRemove.setLayout(suggestionsPanelRemoveLayout);
/*  843 */     suggestionsPanelRemoveLayout.setHorizontalGroup(suggestionsPanelRemoveLayout
/*  844 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  845 */         .addComponent(this.jScrollPane10, -1, 212, 32767));
/*      */     
/*  847 */     suggestionsPanelRemoveLayout.setVerticalGroup(suggestionsPanelRemoveLayout
/*  848 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  849 */         .addComponent(this.jScrollPane10, -1, 149, 32767));
/*      */ 
/*      */     
/*  852 */     this.listOfSuggestionsStock.setFont(new Font("Segoe UI", 0, 14));
/*  853 */     this.listOfSuggestionsStock.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  855 */             mainWindow.this.listOfSuggestionsStockMouseClicked(evt);
/*      */           }
/*      */         });
/*  858 */     this.jScrollPane11.setViewportView(this.listOfSuggestionsStock);
/*      */     
/*  860 */     GroupLayout suggestionsPanelSearchStockLayout = new GroupLayout(this.suggestionsPanelSearchStock);
/*  861 */     this.suggestionsPanelSearchStock.setLayout(suggestionsPanelSearchStockLayout);
/*  862 */     suggestionsPanelSearchStockLayout.setHorizontalGroup(suggestionsPanelSearchStockLayout
/*  863 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  864 */         .addComponent(this.jScrollPane11, -1, 212, 32767));
/*      */     
/*  866 */     suggestionsPanelSearchStockLayout.setVerticalGroup(suggestionsPanelSearchStockLayout
/*  867 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  868 */         .addComponent(this.jScrollPane11, -1, 149, 32767));
/*      */ 
/*      */     
/*  871 */     this.suggestionsPopUpStock.setBorderPainted(false);
/*  872 */     this.suggestionsPopUpStock.setFocusable(false);
/*  873 */     this.suggestionsPopUpStock.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  875 */             mainWindow.this.suggestionsPopUpStockMouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  879 */     this.listOfSuggestionsSell.setFont(new Font("Segoe UI", 0, 14));
/*  880 */     this.listOfSuggestionsSell.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  882 */             mainWindow.this.listOfSuggestionsSellMouseClicked(evt);
/*      */           }
/*      */         });
/*  885 */     this.jScrollPane14.setViewportView(this.listOfSuggestionsSell);
/*      */     
/*  887 */     GroupLayout suggestionsPanelSellLayout = new GroupLayout(this.suggestionsPanelSell);
/*  888 */     this.suggestionsPanelSell.setLayout(suggestionsPanelSellLayout);
/*  889 */     suggestionsPanelSellLayout.setHorizontalGroup(suggestionsPanelSellLayout
/*  890 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  891 */         .addComponent(this.jScrollPane14, -1, 212, 32767));
/*      */     
/*  893 */     suggestionsPanelSellLayout.setVerticalGroup(suggestionsPanelSellLayout
/*  894 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  895 */         .addComponent(this.jScrollPane14, -1, 149, 32767));
/*      */ 
/*      */     
/*  898 */     this.suggestionsPopUpSell.setBorderPainted(false);
/*  899 */     this.suggestionsPopUpSell.setFocusable(false);
/*  900 */     this.suggestionsPopUpSell.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  902 */             mainWindow.this.suggestionsPopUpSellMouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  906 */     setDefaultCloseOperation(3);
/*  907 */     setIconImage((new ImageIcon(getClass().getResource("/images/Hospital-Red-icon.png"))).getImage());
/*  908 */     setMinimumSize(new Dimension(1600, 730));
/*      */     
/*  910 */     this.jPanel3.setBackground(new Color(0, 102, 102));
/*  911 */     this.jPanel3.setMinimumSize(new Dimension(1305, 80));
/*  912 */     this.jPanel3.setPreferredSize(new Dimension(1305, 80));
/*      */     
/*  914 */     this.jPanel1.setBackground(new Color(0, 51, 51));
/*      */     
/*  916 */     this.jPanel29.setBackground(new Color(0, 51, 51));
/*      */     
/*  918 */     this.jLabel77.setBackground(new Color(0, 51, 51));
/*  919 */     this.jLabel77.setHorizontalAlignment(0);
/*  920 */     this.jLabel77.setIcon(new ImageIcon(getClass().getResource("/images/logo.PNG")));
/*      */     
/*  922 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/*  923 */     this.jPanel29.setLayout(jPanel29Layout);
/*  924 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/*  925 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  926 */         .addComponent(this.jLabel77, -1, 300, 32767));
/*      */     
/*  928 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/*  929 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  930 */         .addGroup(jPanel29Layout.createSequentialGroup()
/*  931 */           .addComponent(this.jLabel77)
/*  932 */           .addGap(0, 4, 32767)));
/*      */ 
/*      */     
/*  935 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  936 */     this.jPanel1.setLayout(jPanel1Layout);
/*  937 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  938 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  939 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  940 */           .addComponent(this.jPanel29, -2, -1, -2)
/*  941 */           .addContainerGap(1005, 32767)));
/*      */     
/*  943 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  944 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  945 */         .addComponent(this.jPanel29, -1, -1, 32767));
/*      */ 
/*      */     
/*  948 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  949 */     this.jPanel3.setLayout(jPanel3Layout);
/*  950 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  951 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  952 */         .addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */     
/*  954 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  955 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  956 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*      */ 
/*      */     
/*  959 */     getContentPane().add(this.jPanel3, "First");
/*      */     
/*  961 */     this.jPanel4.setBackground(new Color(0, 102, 102));
/*  962 */     this.jPanel4.setMinimumSize(new Dimension(300, 456));
/*  963 */     this.jPanel4.setPreferredSize(new Dimension(300, 456));
/*      */     
/*  965 */     this.pontoDeVendasBtn.setBackground(Color.red);
/*  966 */     this.pontoDeVendasBtn.addMouseMotionListener(new MouseMotionAdapter() {
/*      */           public void mouseDragged(MouseEvent evt) {
/*  968 */             mainWindow.this.pontoDeVendasBtnMouseDragged(evt);
/*      */           }
/*      */         });
/*  971 */     this.pontoDeVendasBtn.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  973 */             mainWindow.this.pontoDeVendasBtnMouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  976 */             mainWindow.this.pontoDeVendasBtnMouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/*  979 */             mainWindow.this.pontoDeVendasBtnMouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/*  983 */     this.jLabel61.setHorizontalAlignment(0);
/*  984 */     this.jLabel61.setIcon(new ImageIcon(getClass().getResource("/images/cart.png")));
/*  985 */     this.jLabel61.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  987 */             mainWindow.this.jLabel61MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/*  990 */             mainWindow.this.jLabel61MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/*  994 */     this.jLabel62.setFont(new Font("Segoe UI", 1, 14));
/*  995 */     this.jLabel62.setForeground(new Color(255, 255, 255));
/*  996 */     this.jLabel62.setText("PONTO DE VENDAS");
/*  997 */     this.jLabel62.addMouseMotionListener(new MouseMotionAdapter() {
/*      */           public void mouseMoved(MouseEvent evt) {
/*  999 */             mainWindow.this.jLabel62MouseMoved(evt);
/*      */           }
/*      */         });
/* 1002 */     this.jLabel62.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1004 */             mainWindow.this.jLabel62MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1007 */             mainWindow.this.jLabel62MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1011 */     GroupLayout pontoDeVendasBtnLayout = new GroupLayout(this.pontoDeVendasBtn);
/* 1012 */     this.pontoDeVendasBtn.setLayout(pontoDeVendasBtnLayout);
/* 1013 */     pontoDeVendasBtnLayout.setHorizontalGroup(pontoDeVendasBtnLayout
/* 1014 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1015 */         .addGroup(GroupLayout.Alignment.TRAILING, pontoDeVendasBtnLayout.createSequentialGroup()
/* 1016 */           .addComponent(this.jLabel61, -2, 85, -2)
/* 1017 */           .addGap(0, 0, 0)
/* 1018 */           .addComponent(this.jLabel63)
/* 1019 */           .addGap(0, 0, 32767)
/* 1020 */           .addComponent(this.jLabel62, -2, 224, -2)));
/*      */     
/* 1022 */     pontoDeVendasBtnLayout.setVerticalGroup(pontoDeVendasBtnLayout
/* 1023 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1024 */         .addGroup(GroupLayout.Alignment.TRAILING, pontoDeVendasBtnLayout.createSequentialGroup()
/* 1025 */           .addContainerGap()
/* 1026 */           .addComponent(this.jLabel63)
/* 1027 */           .addGap(0, 0, 32767))
/* 1028 */         .addComponent(this.jLabel61, -1, 39, 32767)
/* 1029 */         .addComponent(this.jLabel62, -1, -1, 32767));
/*      */ 
/*      */     
/* 1032 */     this.relatorioDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 1033 */     this.relatorioDeVendasBtn.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1035 */             mainWindow.this.relatorioDeVendasBtnMouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1038 */             mainWindow.this.relatorioDeVendasBtnMouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1041 */             mainWindow.this.relatorioDeVendasBtnMouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1045 */     this.jLabel64.setHorizontalAlignment(0);
/* 1046 */     this.jLabel64.setIcon(new ImageIcon(getClass().getResource("/images/report.png")));
/* 1047 */     this.jLabel64.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1049 */             mainWindow.this.jLabel64MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1052 */             mainWindow.this.jLabel64MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1056 */     this.jLabel65.setFont(new Font("Segoe UI", 1, 14));
/* 1057 */     this.jLabel65.setForeground(new Color(255, 255, 255));
/* 1058 */     this.jLabel65.setText("RELÁTORIO DE VENDAS");
/* 1059 */     this.jLabel65.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1061 */             mainWindow.this.jLabel65MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1064 */             mainWindow.this.jLabel65MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1068 */     GroupLayout relatorioDeVendasBtnLayout = new GroupLayout(this.relatorioDeVendasBtn);
/* 1069 */     this.relatorioDeVendasBtn.setLayout(relatorioDeVendasBtnLayout);
/* 1070 */     relatorioDeVendasBtnLayout.setHorizontalGroup(relatorioDeVendasBtnLayout
/* 1071 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1072 */         .addGroup(GroupLayout.Alignment.TRAILING, relatorioDeVendasBtnLayout.createSequentialGroup()
/* 1073 */           .addComponent(this.jLabel64, -2, 85, -2)
/* 1074 */           .addGap(0, 0, 0)
/* 1075 */           .addComponent(this.jLabel66)
/* 1076 */           .addGap(0, 0, 32767)
/* 1077 */           .addComponent(this.jLabel65, -2, 224, -2)));
/*      */     
/* 1079 */     relatorioDeVendasBtnLayout.setVerticalGroup(relatorioDeVendasBtnLayout
/* 1080 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1081 */         .addGroup(GroupLayout.Alignment.TRAILING, relatorioDeVendasBtnLayout.createSequentialGroup()
/* 1082 */           .addContainerGap()
/* 1083 */           .addComponent(this.jLabel66)
/* 1084 */           .addGap(0, 0, 32767))
/* 1085 */         .addComponent(this.jLabel64, -1, 39, 32767)
/* 1086 */         .addComponent(this.jLabel65, -1, -1, 32767));
/*      */ 
/*      */     
/* 1089 */     this.InventorioBtn.setBackground(new Color(0, 153, 153));
/* 1090 */     this.InventorioBtn.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1092 */             mainWindow.this.InventorioBtnMouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1095 */             mainWindow.this.InventorioBtnMouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1098 */             mainWindow.this.InventorioBtnMouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1102 */     this.jLabel58.setHorizontalAlignment(0);
/* 1103 */     this.jLabel58.setIcon(new ImageIcon(getClass().getResource("/images/package.png")));
/* 1104 */     this.jLabel58.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1106 */             mainWindow.this.jLabel58MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1109 */             mainWindow.this.jLabel58MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1113 */     this.jLabel59.setFont(new Font("Segoe UI", 1, 14));
/* 1114 */     this.jLabel59.setForeground(new Color(255, 255, 255));
/* 1115 */     this.jLabel59.setText("INVENTÓRIO DO STOCK");
/* 1116 */     this.jLabel59.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1118 */             mainWindow.this.jLabel59MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1121 */             mainWindow.this.jLabel59MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1125 */     GroupLayout InventorioBtnLayout = new GroupLayout(this.InventorioBtn);
/* 1126 */     this.InventorioBtn.setLayout(InventorioBtnLayout);
/* 1127 */     InventorioBtnLayout.setHorizontalGroup(InventorioBtnLayout
/* 1128 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1129 */         .addGroup(GroupLayout.Alignment.TRAILING, InventorioBtnLayout.createSequentialGroup()
/* 1130 */           .addComponent(this.jLabel58, -2, 85, -2)
/* 1131 */           .addGap(0, 0, 0)
/* 1132 */           .addComponent(this.jLabel60)
/* 1133 */           .addGap(0, 0, 32767)
/* 1134 */           .addComponent(this.jLabel59, -2, 224, -2)));
/*      */     
/* 1136 */     InventorioBtnLayout.setVerticalGroup(InventorioBtnLayout
/* 1137 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1138 */         .addGroup(GroupLayout.Alignment.TRAILING, InventorioBtnLayout.createSequentialGroup()
/* 1139 */           .addContainerGap()
/* 1140 */           .addComponent(this.jLabel60)
/* 1141 */           .addGap(0, 0, 32767))
/* 1142 */         .addComponent(this.jLabel58, -1, 39, 32767)
/* 1143 */         .addComponent(this.jLabel59, -1, -1, 32767));
/*      */ 
/*      */     
/* 1146 */     this.modificarStockBtn.setBackground(new Color(0, 153, 153));
/* 1147 */     this.modificarStockBtn.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1149 */             mainWindow.this.modificarStockBtnMouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1152 */             mainWindow.this.modificarStockBtnMouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1155 */             mainWindow.this.modificarStockBtnMouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1159 */     this.jLabel55.setHorizontalAlignment(0);
/* 1160 */     this.jLabel55.setIcon(new ImageIcon(getClass().getResource("/images/package_green.png")));
/* 1161 */     this.jLabel55.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1163 */             mainWindow.this.jLabel55MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1166 */             mainWindow.this.jLabel55MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1170 */     this.jLabel56.setFont(new Font("Segoe UI", 1, 14));
/* 1171 */     this.jLabel56.setForeground(new Color(255, 255, 255));
/* 1172 */     this.jLabel56.setText("MODIFICAR STOCK");
/* 1173 */     this.jLabel56.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1175 */             mainWindow.this.jLabel56MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1178 */             mainWindow.this.jLabel56MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1182 */     GroupLayout modificarStockBtnLayout = new GroupLayout(this.modificarStockBtn);
/* 1183 */     this.modificarStockBtn.setLayout(modificarStockBtnLayout);
/* 1184 */     modificarStockBtnLayout.setHorizontalGroup(modificarStockBtnLayout
/* 1185 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1186 */         .addGroup(GroupLayout.Alignment.TRAILING, modificarStockBtnLayout.createSequentialGroup()
/* 1187 */           .addComponent(this.jLabel55, -2, 85, -2)
/* 1188 */           .addGap(0, 0, 0)
/* 1189 */           .addComponent(this.jLabel57)
/* 1190 */           .addGap(0, 0, 32767)
/* 1191 */           .addComponent(this.jLabel56, -2, 224, -2)));
/*      */     
/* 1193 */     modificarStockBtnLayout.setVerticalGroup(modificarStockBtnLayout
/* 1194 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1195 */         .addGroup(GroupLayout.Alignment.TRAILING, modificarStockBtnLayout.createSequentialGroup()
/* 1196 */           .addContainerGap()
/* 1197 */           .addComponent(this.jLabel57)
/* 1198 */           .addGap(0, 0, 32767))
/* 1199 */         .addComponent(this.jLabel55, -1, 39, 32767)
/* 1200 */         .addComponent(this.jLabel56, -1, -1, 32767));
/*      */ 
/*      */     
/* 1203 */     this.verFuncionariosBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 1205 */     this.jLabel34.setFont(new Font("Segoe UI", 1, 14));
/* 1206 */     this.jLabel34.setForeground(new Color(255, 255, 255));
/* 1207 */     this.jLabel34.setText("VER FUNCIONÁRIOS");
/* 1208 */     this.jLabel34.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1210 */             mainWindow.this.jLabel34MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1213 */             mainWindow.this.jLabel34MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1217 */     this.jLabel36.setHorizontalAlignment(0);
/* 1218 */     this.jLabel36.setIcon(new ImageIcon(getClass().getResource("/images/group.png")));
/* 1219 */     this.jLabel36.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1221 */             mainWindow.this.jLabel36MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1224 */             mainWindow.this.jLabel36MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1228 */     GroupLayout verFuncionariosBtnLayout = new GroupLayout(this.verFuncionariosBtn);
/* 1229 */     this.verFuncionariosBtn.setLayout(verFuncionariosBtnLayout);
/* 1230 */     verFuncionariosBtnLayout.setHorizontalGroup(verFuncionariosBtnLayout
/* 1231 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1232 */         .addGroup(GroupLayout.Alignment.TRAILING, verFuncionariosBtnLayout.createSequentialGroup()
/* 1233 */           .addComponent(this.jLabel36, -2, 85, -2)
/* 1234 */           .addGap(0, 0, 0)
/* 1235 */           .addComponent(this.jLabel35)
/* 1236 */           .addGap(0, 0, 32767)
/* 1237 */           .addComponent(this.jLabel34, -2, 224, -2)));
/*      */     
/* 1239 */     verFuncionariosBtnLayout.setVerticalGroup(verFuncionariosBtnLayout
/* 1240 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1241 */         .addGroup(GroupLayout.Alignment.TRAILING, verFuncionariosBtnLayout.createSequentialGroup()
/* 1242 */           .addContainerGap()
/* 1243 */           .addComponent(this.jLabel35)
/* 1244 */           .addGap(0, 0, 32767))
/* 1245 */         .addComponent(this.jLabel36, -1, 39, 32767)
/* 1246 */         .addComponent(this.jLabel34, -1, -1, 32767));
/*      */ 
/*      */     
/* 1249 */     this.modificarFuncionarioBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 1251 */     this.jLabel46.setHorizontalAlignment(0);
/* 1252 */     this.jLabel46.setIcon(new ImageIcon(getClass().getResource("/images/group_edit.png")));
/* 1253 */     this.jLabel46.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1255 */             mainWindow.this.jLabel46MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1258 */             mainWindow.this.jLabel46MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1262 */     this.jLabel47.setFont(new Font("Segoe UI", 1, 14));
/* 1263 */     this.jLabel47.setForeground(new Color(255, 255, 255));
/* 1264 */     this.jLabel47.setText("MODIFICAR FUNCIONÁRIOS");
/* 1265 */     this.jLabel47.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1267 */             mainWindow.this.jLabel47MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1270 */             mainWindow.this.jLabel47MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1274 */     GroupLayout modificarFuncionarioBtnLayout = new GroupLayout(this.modificarFuncionarioBtn);
/* 1275 */     this.modificarFuncionarioBtn.setLayout(modificarFuncionarioBtnLayout);
/* 1276 */     modificarFuncionarioBtnLayout.setHorizontalGroup(modificarFuncionarioBtnLayout
/* 1277 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1278 */         .addGroup(GroupLayout.Alignment.TRAILING, modificarFuncionarioBtnLayout.createSequentialGroup()
/* 1279 */           .addComponent(this.jLabel46, -2, 85, -2)
/* 1280 */           .addGap(0, 0, 0)
/* 1281 */           .addComponent(this.jLabel48)
/* 1282 */           .addGap(0, 0, 32767)
/* 1283 */           .addComponent(this.jLabel47, -2, 224, -2)));
/*      */     
/* 1285 */     modificarFuncionarioBtnLayout.setVerticalGroup(modificarFuncionarioBtnLayout
/* 1286 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1287 */         .addGroup(GroupLayout.Alignment.TRAILING, modificarFuncionarioBtnLayout.createSequentialGroup()
/* 1288 */           .addContainerGap()
/* 1289 */           .addComponent(this.jLabel48)
/* 1290 */           .addGap(0, 0, 32767))
/* 1291 */         .addComponent(this.jLabel46, -1, 39, 32767)
/* 1292 */         .addComponent(this.jLabel47, -1, -1, 32767));
/*      */ 
/*      */     
/* 1295 */     this.acessosBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 1297 */     this.jLabel49.setHorizontalAlignment(0);
/* 1298 */     this.jLabel49.setIcon(new ImageIcon(getClass().getResource("/images/key_go.png")));
/* 1299 */     this.jLabel49.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1301 */             mainWindow.this.jLabel49MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1304 */             mainWindow.this.jLabel49MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1308 */     this.jLabel50.setFont(new Font("Segoe UI", 1, 14));
/* 1309 */     this.jLabel50.setForeground(new Color(255, 255, 255));
/* 1310 */     this.jLabel50.setText("ACESSOS");
/* 1311 */     this.jLabel50.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1313 */             mainWindow.this.jLabel50MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1316 */             mainWindow.this.jLabel50MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1320 */     GroupLayout acessosBtnLayout = new GroupLayout(this.acessosBtn);
/* 1321 */     this.acessosBtn.setLayout(acessosBtnLayout);
/* 1322 */     acessosBtnLayout.setHorizontalGroup(acessosBtnLayout
/* 1323 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1324 */         .addGroup(GroupLayout.Alignment.TRAILING, acessosBtnLayout.createSequentialGroup()
/* 1325 */           .addComponent(this.jLabel49, -2, 85, -2)
/* 1326 */           .addGap(0, 0, 0)
/* 1327 */           .addComponent(this.jLabel51)
/* 1328 */           .addGap(0, 0, 32767)
/* 1329 */           .addComponent(this.jLabel50, -2, 224, -2)));
/*      */     
/* 1331 */     acessosBtnLayout.setVerticalGroup(acessosBtnLayout
/* 1332 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1333 */         .addGroup(GroupLayout.Alignment.TRAILING, acessosBtnLayout.createSequentialGroup()
/* 1334 */           .addContainerGap()
/* 1335 */           .addComponent(this.jLabel51)
/* 1336 */           .addGap(0, 0, 32767))
/* 1337 */         .addComponent(this.jLabel49, -1, 39, 32767)
/* 1338 */         .addComponent(this.jLabel50, -1, -1, 32767));
/*      */ 
/*      */     
/* 1341 */     this.modificarDadosDaEmpresaBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 1343 */     this.jLabel52.setHorizontalAlignment(0);
/* 1344 */     this.jLabel52.setIcon(new ImageIcon(getClass().getResource("/images/building.png")));
/* 1345 */     this.jLabel52.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1347 */             mainWindow.this.jLabel52MouseClicked(evt);
/*      */           }
/*      */         });
/* 1350 */     this.jLabel52.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 1352 */             mainWindow.this.jLabel52KeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1356 */     this.jLabel53.setFont(new Font("Segoe UI", 1, 14));
/* 1357 */     this.jLabel53.setForeground(new Color(255, 255, 255));
/* 1358 */     this.jLabel53.setText("DADOS DA EMPRESA");
/* 1359 */     this.jLabel53.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1361 */             mainWindow.this.jLabel53MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1364 */             mainWindow.this.jLabel53MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 1368 */     GroupLayout modificarDadosDaEmpresaBtnLayout = new GroupLayout(this.modificarDadosDaEmpresaBtn);
/* 1369 */     this.modificarDadosDaEmpresaBtn.setLayout(modificarDadosDaEmpresaBtnLayout);
/* 1370 */     modificarDadosDaEmpresaBtnLayout.setHorizontalGroup(modificarDadosDaEmpresaBtnLayout
/* 1371 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1372 */         .addGroup(GroupLayout.Alignment.TRAILING, modificarDadosDaEmpresaBtnLayout.createSequentialGroup()
/* 1373 */           .addComponent(this.jLabel52, -2, 85, -2)
/* 1374 */           .addGap(0, 0, 0)
/* 1375 */           .addComponent(this.jLabel54)
/* 1376 */           .addGap(0, 0, 32767)
/* 1377 */           .addComponent(this.jLabel53, -2, 224, -2)));
/*      */     
/* 1379 */     modificarDadosDaEmpresaBtnLayout.setVerticalGroup(modificarDadosDaEmpresaBtnLayout
/* 1380 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1381 */         .addGroup(GroupLayout.Alignment.TRAILING, modificarDadosDaEmpresaBtnLayout.createSequentialGroup()
/* 1382 */           .addContainerGap()
/* 1383 */           .addComponent(this.jLabel54)
/* 1384 */           .addGap(0, 0, 32767))
/* 1385 */         .addComponent(this.jLabel52, -1, 39, 32767)
/* 1386 */         .addComponent(this.jLabel53, -1, -1, 32767));
/*      */ 
/*      */     
/* 1389 */     this.jPanel15.setBackground(new Color(204, 204, 255));
/* 1390 */     this.jPanel15.setPreferredSize(new Dimension(0, 3));
/*      */     
/* 1392 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/* 1393 */     this.jPanel15.setLayout(jPanel15Layout);
/* 1394 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout
/* 1395 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1396 */         .addGap(0, 309, 32767));
/*      */     
/* 1398 */     jPanel15Layout.setVerticalGroup(jPanel15Layout
/* 1399 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1400 */         .addGap(0, 9, 32767));
/*      */ 
/*      */     
/* 1403 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 1404 */     this.jPanel4.setLayout(jPanel4Layout);
/* 1405 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 1406 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1407 */         .addComponent(this.relatorioDeVendasBtn, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1408 */         .addComponent(this.InventorioBtn, -1, -1, 32767)
/* 1409 */         .addComponent(this.modificarStockBtn, -1, -1, 32767)
/* 1410 */         .addComponent(this.verFuncionariosBtn, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1411 */         .addComponent(this.modificarFuncionarioBtn, -1, -1, 32767)
/* 1412 */         .addComponent(this.acessosBtn, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1413 */         .addComponent(this.modificarDadosDaEmpresaBtn, -1, -1, 32767)
/* 1414 */         .addComponent(this.pontoDeVendasBtn, -1, -1, 32767)
/* 1415 */         .addComponent(this.jPanel15, GroupLayout.Alignment.TRAILING, -1, 309, 32767));
/*      */     
/* 1417 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 1418 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1419 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 1420 */           .addContainerGap(-1, 32767)
/* 1421 */           .addComponent(this.pontoDeVendasBtn, -2, -1, -2)
/* 1422 */           .addGap(18, 18, 18)
/* 1423 */           .addComponent(this.relatorioDeVendasBtn, -2, -1, -2)
/* 1424 */           .addGap(18, 18, 18)
/* 1425 */           .addComponent(this.InventorioBtn, -2, -1, -2)
/* 1426 */           .addGap(18, 18, 18)
/* 1427 */           .addComponent(this.modificarStockBtn, -2, -1, -2)
/* 1428 */           .addGap(18, 18, 18)
/* 1429 */           .addComponent(this.jPanel15, -2, 9, -2)
/* 1430 */           .addGap(18, 18, 18)
/* 1431 */           .addComponent(this.verFuncionariosBtn, -2, -1, -2)
/* 1432 */           .addGap(18, 18, 18)
/* 1433 */           .addComponent(this.modificarFuncionarioBtn, -2, -1, -2)
/* 1434 */           .addGap(18, 18, 18)
/* 1435 */           .addComponent(this.acessosBtn, -2, -1, -2)
/* 1436 */           .addGap(18, 18, 18)
/* 1437 */           .addComponent(this.modificarDadosDaEmpresaBtn, -2, -1, -2)
/* 1438 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1441 */     getContentPane().add(this.jPanel4, "Before");
/*      */     
/* 1443 */     this.jPanel2.setBackground(new Color(0, 51, 51));
/* 1444 */     this.jPanel2.setPreferredSize(new Dimension(1088, 90));
/*      */     
/* 1446 */     this.jPanel5.setBackground(new Color(0, 51, 51));
/*      */     
/* 1448 */     this.jPanel56.setBackground(new Color(0, 204, 204));
/*      */     
/* 1450 */     this.jLabel125.setFont(new Font("Segoe UI Black", 0, 18));
/* 1451 */     this.jLabel125.setForeground(new Color(255, 255, 255));
/* 1452 */     this.jLabel125.setHorizontalAlignment(0);
/* 1453 */     this.jLabel125.setText("FECHAR CAIXA");
/* 1454 */     this.jLabel125.setCursor(new Cursor(12));
/* 1455 */     this.jLabel125.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1457 */             mainWindow.this.jLabel125MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1460 */             mainWindow.this.jLabel125MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1463 */             mainWindow.this.jLabel125MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1467 */     GroupLayout jPanel56Layout = new GroupLayout(this.jPanel56);
/* 1468 */     this.jPanel56.setLayout(jPanel56Layout);
/* 1469 */     jPanel56Layout.setHorizontalGroup(jPanel56Layout
/* 1470 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1471 */         .addComponent(this.jLabel125, -1, 499, 32767));
/*      */     
/* 1473 */     jPanel56Layout.setVerticalGroup(jPanel56Layout
/* 1474 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1475 */         .addGroup(jPanel56Layout.createSequentialGroup()
/* 1476 */           .addComponent(this.jLabel125, -2, 50, -2)
/* 1477 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/* 1480 */     this.jButton3.setBackground(new Color(211, 80, 48));
/* 1481 */     this.jButton3.setFont(new Font("Segoe UI Black", 0, 18));
/* 1482 */     this.jButton3.setForeground(new Color(255, 255, 255));
/* 1483 */     this.jButton3.setIcon(new ImageIcon(getClass().getResource("/images/bullet_red.png")));
/* 1484 */     this.jButton3.setText("SAIR");
/* 1485 */     this.jButton3.setCursor(new Cursor(12));
/* 1486 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1488 */             mainWindow.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1492 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1493 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1494 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1495 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1496 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1497 */           .addContainerGap(284, 32767)
/* 1498 */           .addComponent(this.jPanel56, -2, -1, -2)
/* 1499 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 174, 32767)
/* 1500 */           .addComponent(this.jButton3)));
/*      */     
/* 1502 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1503 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1504 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
/* 1505 */           .addGap(0, 0, 32767)
/* 1506 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1507 */             .addComponent(this.jPanel56, -1, -1, 32767)
/* 1508 */             .addComponent(this.jButton3, -1, -1, 32767))));
/*      */ 
/*      */     
/* 1511 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1512 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1513 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 1514 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1515 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 1516 */           .addContainerGap()
/* 1517 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 1518 */           .addContainerGap()));
/*      */     
/* 1520 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 1521 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1522 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 1523 */           .addContainerGap(23, 32767)
/* 1524 */           .addComponent(this.jPanel5, -2, -1, -2)
/* 1525 */           .addContainerGap(17, 32767)));
/*      */ 
/*      */     
/* 1528 */     getContentPane().add(this.jPanel2, "Last");
/*      */     
/* 1530 */     this.jPanel14.setMinimumSize(new Dimension(788, 497));
/* 1531 */     this.jPanel14.setLayout(new CardLayout());
/*      */     
/* 1533 */     this.jPanel6.setMinimumSize(new Dimension(1005, 586));
/*      */     
/* 1535 */     this.jLabel1.setFont(new Font("Segoe UI", 1, 18));
/* 1536 */     this.jLabel1.setForeground(new Color(102, 102, 102));
/* 1537 */     this.jLabel1.setHorizontalAlignment(0);
/* 1538 */     this.jLabel1.setText("PONTO DE VENDAS ");
/*      */     
/* 1540 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 1541 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1542 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 1543 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1544 */         .addComponent(this.jLabel1, -1, -1, 32767));
/*      */     
/* 1546 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 1547 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1548 */         .addComponent(this.jLabel1, -1, 38, 32767));
/*      */ 
/*      */     
/* 1551 */     this.jPanel11.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 1553 */     this.jLabel5.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1554 */     this.jLabel5.setText("Quantidade");
/*      */     
/* 1556 */     this.jLabel6.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1557 */     this.jLabel6.setText("Nome Comercial");
/*      */     
/* 1559 */     this.qtyTextSellPoint.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1560 */     this.qtyTextSellPoint.setCursor(new Cursor(2));
/* 1561 */     this.qtyTextSellPoint.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 1563 */             mainWindow.this.qtyTextSellPointKeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 1566 */             mainWindow.this.qtyTextSellPointKeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1570 */     this.barCodePointSell.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1571 */     this.barCodePointSell.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1573 */             mainWindow.this.barCodePointSellActionPerformed(evt);
/*      */           }
/*      */         });
/* 1576 */     this.barCodePointSell.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 1578 */             mainWindow.this.barCodePointSellKeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 1581 */             mainWindow.this.barCodePointSellKeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1585 */     this.jLabel7.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1586 */     this.jLabel7.setText("Código de Barras");
/*      */     
/* 1588 */     this.comercialNamePointSell.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1589 */     this.comercialNamePointSell.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1591 */             mainWindow.this.comercialNamePointSellActionPerformed(evt);
/*      */           }
/*      */         });
/* 1594 */     this.comercialNamePointSell.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 1596 */             mainWindow.this.comercialNamePointSellKeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 1599 */             mainWindow.this.comercialNamePointSellKeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1603 */     this.addDrugBuyList.setBackground(new Color(0, 153, 153));
/* 1604 */     this.addDrugBuyList.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1605 */     this.addDrugBuyList.setIcon(new ImageIcon(getClass().getResource("/images/cart_delete.png")));
/* 1606 */     this.addDrugBuyList.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
/* 1607 */     this.addDrugBuyList.setCursor(new Cursor(12));
/* 1608 */     this.addDrugBuyList.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1610 */             mainWindow.this.addDrugBuyListActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1614 */     this.addDrugSellPoint.setBackground(new Color(0, 153, 153));
/* 1615 */     this.addDrugSellPoint.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1616 */     this.addDrugSellPoint.setForeground(new Color(255, 255, 255));
/* 1617 */     this.addDrugSellPoint.setIcon(new ImageIcon(getClass().getResource("/images/cart_add.png")));
/* 1618 */     this.addDrugSellPoint.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
/* 1619 */     this.addDrugSellPoint.setBorderPainted(false);
/* 1620 */     this.addDrugSellPoint.setCursor(new Cursor(12));
/* 1621 */     this.addDrugSellPoint.setEnabled(false);
/* 1622 */     this.addDrugSellPoint.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1624 */             mainWindow.this.addDrugSellPointActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1628 */     this.Bill_nr.setEditable(false);
/* 1629 */     this.Bill_nr.setBackground(new Color(211, 80, 48));
/* 1630 */     this.Bill_nr.setFont(new Font("Bodoni MT Black", 0, 18));
/* 1631 */     this.Bill_nr.setHorizontalAlignment(0);
/* 1632 */     this.Bill_nr.setBorder(BorderFactory.createEtchedBorder());
/* 1633 */     this.Bill_nr.setFocusable(false);
/*      */     
/* 1635 */     this.submitDrugsSellPoint.setBackground(new Color(0, 153, 153));
/* 1636 */     this.submitDrugsSellPoint.setFont(new Font("Segoe UI Black", 0, 14));
/* 1637 */     this.submitDrugsSellPoint.setForeground(new Color(255, 255, 255));
/* 1638 */     this.submitDrugsSellPoint.setIcon(new ImageIcon(getClass().getResource("/images/cart_go.png")));
/* 1639 */     this.submitDrugsSellPoint.setText("   ENVIAR");
/* 1640 */     this.submitDrugsSellPoint.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
/* 1641 */     this.submitDrugsSellPoint.setBorderPainted(false);
/* 1642 */     this.submitDrugsSellPoint.setCursor(new Cursor(12));
/* 1643 */     this.submitDrugsSellPoint.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1645 */             mainWindow.this.submitDrugsSellPointActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1649 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 1650 */     this.jPanel11.setLayout(jPanel11Layout);
/* 1651 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 1652 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1653 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1654 */           .addContainerGap()
/* 1655 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1656 */             .addComponent(this.jLabel7, -1, -1, 32767)
/* 1657 */             .addComponent(this.jLabel5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1658 */             .addComponent(this.jLabel6, GroupLayout.Alignment.LEADING, -2, 134, -2))
/* 1659 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1660 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1661 */             .addComponent(this.qtyTextSellPoint, -2, 180, -2)
/* 1662 */             .addComponent(this.barCodePointSell, -2, 180, -2)
/* 1663 */             .addComponent(this.comercialNamePointSell, -2, 180, -2)
/* 1664 */             .addGroup(jPanel11Layout.createSequentialGroup()
/* 1665 */               .addComponent(this.addDrugBuyList, -2, 83, -2)
/* 1666 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1667 */               .addComponent(this.addDrugSellPoint, -2, 83, -2)))
/* 1668 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 115, 32767)
/* 1669 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1670 */             .addComponent(this.submitDrugsSellPoint, -1, -1, 32767)
/* 1671 */             .addComponent(this.Bill_nr, -2, 163, -2))
/* 1672 */           .addContainerGap()));
/*      */     
/* 1674 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 1675 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1676 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/* 1677 */           .addContainerGap()
/* 1678 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1679 */             .addGroup(jPanel11Layout.createSequentialGroup()
/* 1680 */               .addComponent(this.Bill_nr, -2, 54, -2)
/* 1681 */               .addGap(70, 70, 70)
/* 1682 */               .addComponent(this.submitDrugsSellPoint, -1, 69, 32767))
/* 1683 */             .addGroup(jPanel11Layout.createSequentialGroup()
/* 1684 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1685 */                 .addComponent(this.jLabel5, -2, 34, -2)
/* 1686 */                 .addComponent(this.qtyTextSellPoint, -2, 34, -2))
/* 1687 */               .addGap(18, 18, 18)
/* 1688 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1689 */                 .addComponent(this.jLabel6, -2, 34, -2)
/* 1690 */                 .addComponent(this.comercialNamePointSell, -2, 34, -2))
/* 1691 */               .addGap(18, 18, 18)
/* 1692 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1693 */                 .addComponent(this.jLabel7, -2, 34, -2)
/* 1694 */                 .addComponent(this.barCodePointSell, -2, 34, -2))
/* 1695 */               .addGap(18, 18, 18)
/* 1696 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1697 */                 .addComponent(this.addDrugBuyList, -1, 37, 32767)
/* 1698 */                 .addComponent(this.addDrugSellPoint, -1, -1, 32767))))
/* 1699 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1702 */     this.addDrugSellPoint.getAccessibleContext().setAccessibleName("addDrugToBill");
/*      */     
/* 1704 */     this.jPanel12.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 1706 */     this.jLabel8.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1707 */     this.jLabel8.setText("Valor da Fatura");
/*      */     
/* 1709 */     this.totalToPay.setEditable(false);
/* 1710 */     this.totalToPay.setBackground(new Color(211, 80, 48));
/* 1711 */     this.totalToPay.setFont(new Font("Bodoni MT Black", 0, 18));
/* 1712 */     this.totalToPay.setHorizontalAlignment(0);
/* 1713 */     this.totalToPay.setFocusable(false);
/*      */     
/* 1715 */     this.jLabel9.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1716 */     this.jLabel9.setText("Desconto (%)");
/*      */     
/* 1718 */     this.discountPointSell.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1719 */     this.discountPointSell.setHorizontalAlignment(0);
/* 1720 */     this.discountPointSell.setEnabled(false);
/* 1721 */     this.discountPointSell.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 1723 */             mainWindow.this.discountPointSellKeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 1726 */             mainWindow.this.discountPointSellKeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1730 */     this.moneyPaid.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1731 */     this.moneyPaid.setHorizontalAlignment(0);
/* 1732 */     this.moneyPaid.setEnabled(false);
/* 1733 */     this.moneyPaid.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 1735 */             mainWindow.this.moneyPaidKeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 1738 */             mainWindow.this.moneyPaidKeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1742 */     this.jLabel10.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1743 */     this.jLabel10.setText("Valor Pago");
/*      */     
/* 1745 */     this.jLabel11.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1746 */     this.jLabel11.setText("Metodo ");
/*      */     
/* 1748 */     this.subMethodPaymentPOS.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1749 */     this.subMethodPaymentPOS.setEnabled(false);
/*      */     
/* 1751 */     this.methodPayment.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1752 */     this.methodPayment.setModel(new DefaultComboBoxModel<>(new String[] { "__Selecione", "Espécie", "POS" }));
/* 1753 */     this.methodPayment.setEnabled(false);
/* 1754 */     this.methodPayment.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1756 */             mainWindow.this.methodPaymentActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1760 */     this.jLabel12.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1761 */     this.jLabel12.setText("Retorno ($)");
/*      */     
/* 1763 */     this.changeMoney.setEditable(false);
/* 1764 */     this.changeMoney.setBackground(new Color(211, 80, 48));
/* 1765 */     this.changeMoney.setFont(new Font("Segoe UI Black", 0, 14));
/* 1766 */     this.changeMoney.setHorizontalAlignment(0);
/* 1767 */     this.changeMoney.setFocusable(false);
/*      */     
/* 1769 */     this.addPaymentPSBtn.setBackground(new Color(0, 153, 153));
/* 1770 */     this.addPaymentPSBtn.setFont(new Font("Segoe UI", 1, 14));
/* 1771 */     this.addPaymentPSBtn.setForeground(new Color(255, 255, 255));
/* 1772 */     this.addPaymentPSBtn.setText("ADICIONAR");
/* 1773 */     this.addPaymentPSBtn.setCursor(new Cursor(12));
/* 1774 */     this.addPaymentPSBtn.setEnabled(false);
/* 1775 */     this.addPaymentPSBtn.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1777 */             mainWindow.this.addPaymentPSBtnActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1781 */     this.newTotalBtn.setBackground(new Color(0, 153, 153));
/* 1782 */     this.newTotalBtn.setFont(new Font("Segoe UI", 1, 14));
/* 1783 */     this.newTotalBtn.setForeground(new Color(255, 255, 255));
/* 1784 */     this.newTotalBtn.setText("NOVO TOTAL");
/* 1785 */     this.newTotalBtn.setCursor(new Cursor(12));
/* 1786 */     this.newTotalBtn.setEnabled(false);
/* 1787 */     this.newTotalBtn.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1789 */             mainWindow.this.newTotalBtnActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1793 */     this.generateBill.setBackground(new Color(0, 153, 153));
/* 1794 */     this.generateBill.setFont(new Font("Segoe UI Black", 1, 14));
/* 1795 */     this.generateBill.setForeground(new Color(255, 255, 255));
/* 1796 */     this.generateBill.setText("GERAR FATURA");
/* 1797 */     this.generateBill.setCursor(new Cursor(12));
/* 1798 */     this.generateBill.setEnabled(false);
/* 1799 */     this.generateBill.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1801 */             mainWindow.this.generateBillActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1805 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 1806 */     this.jPanel12.setLayout(jPanel12Layout);
/* 1807 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 1808 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1809 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1810 */           .addContainerGap()
/* 1811 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1812 */             .addComponent(this.jSeparator1)
/* 1813 */             .addComponent(this.generateBill, -1, -1, 32767)
/* 1814 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1815 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1816 */                 .addComponent(this.jLabel12, -1, -1, 32767)
/* 1817 */                 .addComponent(this.jLabel11, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1818 */                 .addComponent(this.jLabel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1819 */                 .addComponent(this.jLabel8, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1820 */                 .addComponent(this.jLabel10, GroupLayout.Alignment.TRAILING, -1, -1, 32767))
/* 1821 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1822 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1823 */                 .addComponent(this.newTotalBtn, -1, -1, 32767)
/* 1824 */                 .addComponent(this.moneyPaid)
/* 1825 */                 .addComponent(this.discountPointSell)
/* 1826 */                 .addComponent(this.totalToPay)
/* 1827 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
/* 1828 */                   .addComponent(this.methodPayment, -2, 111, -2)
/* 1829 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 120, 32767)
/* 1830 */                   .addComponent(this.subMethodPaymentPOS, -2, 111, -2))
/* 1831 */                 .addComponent(this.changeMoney)
/* 1832 */                 .addComponent(this.addPaymentPSBtn, -1, -1, 32767))))
/* 1833 */           .addContainerGap()));
/*      */     
/* 1835 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 1836 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1837 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1838 */           .addContainerGap()
/* 1839 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1840 */             .addComponent(this.totalToPay, -2, 54, -2)
/* 1841 */             .addComponent(this.jLabel8, -2, 34, -2))
/* 1842 */           .addGap(30, 30, 30)
/* 1843 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1844 */             .addComponent(this.discountPointSell, -2, 34, -2)
/* 1845 */             .addComponent(this.jLabel9, -2, 34, -2))
/* 1846 */           .addGap(18, 18, 18)
/* 1847 */           .addComponent(this.newTotalBtn, -1, 36, 32767)
/* 1848 */           .addGap(13, 13, 13)
/* 1849 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 1850 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1851 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1852 */             .addComponent(this.moneyPaid, -2, 34, -2)
/* 1853 */             .addComponent(this.jLabel10, -2, 34, -2))
/* 1854 */           .addGap(18, 18, 18)
/* 1855 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1856 */             .addComponent(this.jLabel11, -2, 34, -2)
/* 1857 */             .addComponent(this.subMethodPaymentPOS, -2, 34, -2)
/* 1858 */             .addComponent(this.methodPayment, -2, 34, -2))
/* 1859 */           .addGap(18, 18, 18)
/* 1860 */           .addComponent(this.addPaymentPSBtn, -1, 37, 32767)
/* 1861 */           .addGap(18, 18, 18)
/* 1862 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1863 */             .addComponent(this.changeMoney, -2, 34, -2)
/* 1864 */             .addComponent(this.jLabel12, -2, 34, -2))
/* 1865 */           .addGap(18, 18, 18)
/* 1866 */           .addComponent(this.generateBill, -2, 62, -2)
/* 1867 */           .addGap(10, 10, 10)));
/*      */ 
/*      */     
/* 1870 */     this.buyListTb.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1871 */     this.buyListTb.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "N. Medicamento", "Quantidade", "Preço/Unidade", "Preço Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1879 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1884 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1887 */     this.jScrollPane1.setViewportView(this.buyListTb);
/*      */     
/* 1889 */     this.jButton1.setBackground(new Color(211, 80, 48));
/* 1890 */     this.jButton1.setFont(new Font("Segoe UI Black", 0, 14));
/* 1891 */     this.jButton1.setForeground(new Color(255, 255, 255));
/* 1892 */     this.jButton1.setText("CANCELAR");
/* 1893 */     this.jButton1.setCursor(new Cursor(12));
/* 1894 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1896 */             mainWindow.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1900 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1901 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1902 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 1903 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1904 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1905 */           .addGap(50, 50, 50)
/* 1906 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1907 */             .addComponent(this.jPanel7, -1, -1, 32767)
/* 1908 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1909 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1910 */                 .addComponent(this.jButton1, -2, 158, -2)
/* 1911 */                 .addComponent(this.jPanel11, -1, -1, 32767)
/* 1912 */                 .addComponent(this.jScrollPane1))
/* 1913 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 113, 32767)
/* 1914 */               .addComponent(this.jPanel12, -2, -1, -2)))
/* 1915 */           .addContainerGap(50, 32767)));
/*      */     
/* 1917 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 1918 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1919 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1920 */           .addContainerGap(-1, 32767)
/* 1921 */           .addComponent(this.jPanel7, -2, -1, -2)
/* 1922 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1923 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1924 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1925 */               .addComponent(this.jPanel11, -2, -1, -2)
/* 1926 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1927 */               .addComponent(this.jScrollPane1, -2, 194, -2)
/* 1928 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1929 */               .addComponent(this.jButton1, -2, 64, -2))
/* 1930 */             .addComponent(this.jPanel12, -2, -1, -2))
/* 1931 */           .addContainerGap(37, 32767)));
/*      */ 
/*      */     
/* 1934 */     this.jPanel14.add(this.jPanel6, "pontoDeVendas");
/*      */     
/* 1936 */     this.jLabel3.setFont(new Font("Segoe UI", 1, 18));
/* 1937 */     this.jLabel3.setForeground(new Color(102, 102, 102));
/* 1938 */     this.jLabel3.setHorizontalAlignment(0);
/* 1939 */     this.jLabel3.setText("RELÁTORIO DE VENDAS");
/*      */     
/* 1941 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1942 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1943 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1944 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1945 */         .addComponent(this.jLabel3, -1, 1204, 32767));
/*      */     
/* 1947 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1948 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1949 */         .addComponent(this.jLabel3, -1, 38, 32767));
/*      */ 
/*      */     
/* 1952 */     this.jPanel13.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 1954 */     this.jLabel16.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1955 */     this.jLabel16.setText("Nome do Vendedor");
/*      */     
/* 1957 */     this.sellerComboBox.setFont(new Font("Segoe UI Semibold", 0, 14));
/*      */     
/* 1959 */     this.drugNameSearch.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1960 */     this.drugNameSearch.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1962 */             mainWindow.this.drugNameSearchKeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1966 */     this.jLabel17.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1967 */     this.jLabel17.setText("Nome do Medicamento");
/*      */     
/* 1969 */     this.jLabel18.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1970 */     this.jLabel18.setText("Número da fatura");
/*      */     
/* 1972 */     this.TotalMoneyPeriod.setEditable(false);
/* 1973 */     this.TotalMoneyPeriod.setBackground(new Color(204, 51, 0));
/* 1974 */     this.TotalMoneyPeriod.setFont(new Font("Segoe UI Black", 0, 18));
/* 1975 */     this.TotalMoneyPeriod.setForeground(new Color(255, 255, 255));
/* 1976 */     this.TotalMoneyPeriod.setHorizontalAlignment(0);
/* 1977 */     this.TotalMoneyPeriod.setFocusable(false);
/* 1978 */     this.TotalMoneyPeriod.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1980 */             mainWindow.this.TotalMoneyPeriodActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1984 */     this.finalDateField.setDateFormatString("yyyy-MM-dd");
/*      */     
/* 1986 */     this.jLabel19.setFont(new Font("Segoe UI", 0, 14));
/* 1987 */     this.jLabel19.setText("Até");
/*      */     
/* 1989 */     this.initDateField.setDateFormatString("yyyy-MM-dd");
/*      */     
/* 1991 */     this.billNrSearch.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 1992 */     this.billNrSearch.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1994 */             mainWindow.this.billNrSearchKeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1998 */     this.jButton9.setBackground(new Color(0, 153, 153));
/* 1999 */     this.jButton9.setFont(new Font("Segoe UI Black", 0, 14));
/* 2000 */     this.jButton9.setForeground(new Color(255, 255, 255));
/* 2001 */     this.jButton9.setIcon(new ImageIcon(getClass().getResource("/images/find.png")));
/* 2002 */     this.jButton9.setCursor(new Cursor(12));
/* 2003 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2005 */             mainWindow.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2009 */     this.jButton10.setBackground(new Color(0, 153, 153));
/* 2010 */     this.jButton10.setFont(new Font("Segoe UI Black", 0, 14));
/* 2011 */     this.jButton10.setForeground(new Color(255, 255, 255));
/* 2012 */     this.jButton10.setIcon(new ImageIcon(getClass().getResource("/images/find.png")));
/* 2013 */     this.jButton10.setCursor(new Cursor(12));
/* 2014 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2016 */             mainWindow.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2020 */     this.jButton11.setBackground(new Color(0, 153, 153));
/* 2021 */     this.jButton11.setFont(new Font("Segoe UI Black", 0, 14));
/* 2022 */     this.jButton11.setForeground(new Color(255, 255, 255));
/* 2023 */     this.jButton11.setText("Pesquisar");
/* 2024 */     this.jButton11.setCursor(new Cursor(12));
/* 2025 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2027 */             mainWindow.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2031 */     this.jButton12.setBackground(new Color(0, 153, 153));
/* 2032 */     this.jButton12.setFont(new Font("Segoe UI Black", 0, 14));
/* 2033 */     this.jButton12.setForeground(new Color(255, 255, 255));
/* 2034 */     this.jButton12.setText("Todas");
/* 2035 */     this.jButton12.setCursor(new Cursor(12));
/* 2036 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2038 */             mainWindow.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2042 */     this.jButton13.setBackground(new Color(204, 51, 0));
/* 2043 */     this.jButton13.setFont(new Font("Segoe UI Black", 0, 14));
/* 2044 */     this.jButton13.setForeground(new Color(255, 255, 255));
/* 2045 */     this.jButton13.setText("Excluir Venda");
/* 2046 */     this.jButton13.setCursor(new Cursor(12));
/* 2047 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2049 */             mainWindow.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2053 */     this.jButton15.setBackground(new Color(0, 153, 153));
/* 2054 */     this.jButton15.setFont(new Font("Segoe UI Black", 0, 14));
/* 2055 */     this.jButton15.setForeground(new Color(255, 255, 255));
/* 2056 */     this.jButton15.setText("Hoje");
/* 2057 */     this.jButton15.setCursor(new Cursor(12));
/* 2058 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2060 */             mainWindow.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2064 */     this.jButton2.setBackground(new Color(0, 153, 153));
/* 2065 */     this.jButton2.setFont(new Font("Segoe UI Black", 0, 14));
/* 2066 */     this.jButton2.setForeground(new Color(255, 255, 255));
/* 2067 */     this.jButton2.setText("Relatorio");
/* 2068 */     this.jButton2.setCursor(new Cursor(12));
/* 2069 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2071 */             mainWindow.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2075 */     this.jButton4.setBackground(new Color(0, 153, 153));
/* 2076 */     this.jButton4.setFont(new Font("Segoe UI Black", 0, 14));
/* 2077 */     this.jButton4.setForeground(new Color(255, 255, 255));
/* 2078 */     this.jButton4.setText("Relatorio Dia");
/* 2079 */     this.jButton4.setCursor(new Cursor(12));
/* 2080 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2082 */             mainWindow.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2086 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 2087 */     this.jPanel13.setLayout(jPanel13Layout);
/* 2088 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 2089 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2090 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 2091 */           .addContainerGap()
/* 2092 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2093 */             .addComponent(this.jSeparator3)
/* 2094 */             .addGroup(jPanel13Layout.createSequentialGroup()
/* 2095 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2096 */                 .addGroup(jPanel13Layout.createSequentialGroup()
/* 2097 */                   .addComponent(this.jLabel16, -1, -1, 32767)
/* 2098 */                   .addGap(54, 54, 54))
/* 2099 */                 .addComponent(this.jLabel17, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2100 */                 .addComponent(this.jLabel18, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2101 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2102 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2103 */                 .addComponent(this.drugNameSearch)
/* 2104 */                 .addComponent(this.sellerComboBox, 0, 209, 32767)
/* 2105 */                 .addComponent(this.billNrSearch))
/* 2106 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2107 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2108 */                 .addComponent(this.jButton9, -2, 58, -2)
/* 2109 */                 .addComponent(this.jButton10, -2, 58, -2))
/* 2110 */               .addGap(35, 35, 35)
/* 2111 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2112 */                 .addGroup(jPanel13Layout.createSequentialGroup()
/* 2113 */                   .addComponent(this.jButton4, -2, 187, -2)
/* 2114 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2115 */                   .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2116 */                     .addComponent(this.jButton11, -1, 192, 32767)
/* 2117 */                     .addComponent((Component)this.initDateField, -1, -1, 32767))
/* 2118 */                   .addGap(22, 22, 22)
/* 2119 */                   .addComponent(this.jLabel19, -2, 21, -2)
/* 2120 */                   .addGap(18, 18, 18)
/* 2121 */                   .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2122 */                     .addComponent(this.TotalMoneyPeriod, GroupLayout.Alignment.TRAILING)
/* 2123 */                     .addComponent((Component)this.finalDateField, GroupLayout.Alignment.TRAILING, -1, 217, 32767)))
/* 2124 */                 .addGroup(jPanel13Layout.createSequentialGroup()
/* 2125 */                   .addComponent(this.jButton2, -2, 187, -2)
/* 2126 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2127 */                   .addComponent(this.jButton12, -2, 87, -2)
/* 2128 */                   .addGap(18, 18, 18)
/* 2129 */                   .addComponent(this.jButton15, -2, 84, -2)
/* 2130 */                   .addGap(63, 63, 63)
/* 2131 */                   .addComponent(this.jButton13, -2, 217, -2)))))
/* 2132 */           .addContainerGap()));
/*      */     
/* 2134 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 2135 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2136 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 2137 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2138 */             .addGroup(jPanel13Layout.createSequentialGroup()
/* 2139 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2140 */                 .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2141 */                   .addComponent(this.jLabel18, -2, 31, -2)
/* 2142 */                   .addComponent(this.billNrSearch, -2, 31, -2))
/* 2143 */                 .addComponent(this.jLabel19, -2, 28, -2))
/* 2144 */               .addGap(11, 11, 11)
/* 2145 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2146 */                 .addComponent(this.jLabel17, -2, 31, -2)
/* 2147 */                 .addComponent(this.drugNameSearch, -2, 31, -2)
/* 2148 */                 .addComponent(this.jButton9, -2, 31, -2)))
/* 2149 */             .addGroup(jPanel13Layout.createSequentialGroup()
/* 2150 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2151 */                 .addComponent((Component)this.finalDateField, -1, 28, 32767)
/* 2152 */                 .addComponent((Component)this.initDateField, -1, -1, 32767))
/* 2153 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2154 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2155 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2156 */                   .addComponent(this.jButton11, -1, -1, 32767)
/* 2157 */                   .addComponent(this.jButton4, -2, 31, -2))
/* 2158 */                 .addGroup(jPanel13Layout.createSequentialGroup()
/* 2159 */                   .addComponent(this.TotalMoneyPeriod, -2, -1, -2)
/* 2160 */                   .addGap(0, 0, 32767)))))
/* 2161 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2162 */           .addComponent(this.jSeparator3, -2, 2, -2)
/* 2163 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2164 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2165 */             .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2166 */               .addComponent(this.jLabel16, -1, -1, 32767)
/* 2167 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2168 */                 .addComponent(this.sellerComboBox, -2, 31, -2)
/* 2169 */                 .addComponent(this.jButton10, -2, 31, -2)))
/* 2170 */             .addComponent(this.jButton2, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 2171 */             .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2172 */               .addComponent(this.jButton13, -2, 31, -2)
/* 2173 */               .addComponent(this.jButton12, -2, 31, -2)
/* 2174 */               .addComponent(this.jButton15, -2, 31, -2)))
/* 2175 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2178 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, "Detalhes - Medicamentos", 0, 0, new Font("Segoe UI Black", 0, 12)));
/*      */     
/* 2180 */     this.orderDetailsTB.setFont(new Font("Segoe UI Light", 0, 14));
/* 2181 */     this.orderDetailsTB.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "N. Generico", "Quant.", "Total" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2189 */     this.jScrollPane5.setViewportView(this.orderDetailsTB);
/*      */     
/* 2191 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 2192 */     this.jPanel17.setLayout(jPanel17Layout);
/* 2193 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 2194 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2195 */         .addComponent(this.jScrollPane5, -1, 347, 32767));
/*      */     
/* 2197 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 2198 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2199 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 2200 */           .addContainerGap()
/* 2201 */           .addComponent(this.jScrollPane5, -2, 0, 32767)
/* 2202 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2205 */     this.jPanel18.setBorder(BorderFactory.createTitledBorder(null, "Detalhes - Metodos de Pagamento", 0, 0, new Font("Segoe UI Black", 0, 12)));
/*      */     
/* 2207 */     this.paymentMethodTB.setFont(new Font("Segoe UI Light", 0, 14));
/* 2208 */     this.paymentMethodTB.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Metodo", "Sub_Metodo", "Valor" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2216 */           boolean[] canEdit = new boolean[] { false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2221 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2224 */     this.jScrollPane4.setViewportView(this.paymentMethodTB);
/*      */     
/* 2226 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/* 2227 */     this.jPanel18.setLayout(jPanel18Layout);
/* 2228 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/* 2229 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2230 */         .addComponent(this.jScrollPane4, -2, 0, 32767));
/*      */     
/* 2232 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/* 2233 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2234 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 2235 */           .addContainerGap()
/* 2236 */           .addComponent(this.jScrollPane4, -1, 100, 32767)
/* 2237 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2240 */     this.ordersTableList.setFont(new Font("Segoe UI Semilight", 0, 14));
/* 2241 */     this.ordersTableList.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },  }, (Object[])new String[] { "N. Fatura", "Valor Da Fatura", "Desconto (%)", "Total Pago", "Retorno", "Vendedor", "Data" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2252 */     this.ordersTableList.setCursor(new Cursor(12));
/* 2253 */     this.ordersTableList.setSelectionBackground(new Color(255, 153, 153));
/* 2254 */     this.ordersTableList.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2256 */             mainWindow.this.ordersTableListMouseClicked(evt);
/*      */           }
/*      */         });
/* 2259 */     this.ordersTableList.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2261 */             mainWindow.this.ordersTableListKeyPressed(evt);
/*      */           }
/*      */         });
/* 2264 */     this.paneltable.setViewportView(this.ordersTableList);
/*      */     
/* 2266 */     GroupLayout jPanel27Layout = new GroupLayout(this.jPanel27);
/* 2267 */     this.jPanel27.setLayout(jPanel27Layout);
/* 2268 */     jPanel27Layout.setHorizontalGroup(jPanel27Layout
/* 2269 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2270 */         .addGap(0, 873, 32767)
/* 2271 */         .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2272 */           .addComponent(this.paneltable, GroupLayout.Alignment.TRAILING, -1, 873, 32767)));
/*      */     
/* 2274 */     jPanel27Layout.setVerticalGroup(jPanel27Layout
/* 2275 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2276 */         .addGap(0, 369, 32767)
/* 2277 */         .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2278 */           .addGroup(jPanel27Layout.createSequentialGroup()
/* 2279 */             .addComponent(this.paneltable, -2, 307, -2)
/* 2280 */             .addGap(0, 62, 32767))));
/*      */ 
/*      */     
/* 2283 */     this.ordersTable.setViewportView(this.jPanel27);
/*      */     
/* 2285 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 2286 */     this.jPanel9.setLayout(jPanel9Layout);
/* 2287 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 2288 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2289 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/* 2290 */           .addGap(50, 50, 50)
/* 2291 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2292 */             .addGroup(jPanel9Layout.createSequentialGroup()
/* 2293 */               .addComponent(this.ordersTable, -1, 839, 32767)
/* 2294 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2295 */               .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2296 */                 .addComponent(this.jPanel17, -1, -1, 32767)
/* 2297 */                 .addComponent(this.jPanel18, -1, -1, 32767)))
/* 2298 */             .addComponent(this.jPanel13, -1, -1, 32767)
/* 2299 */             .addComponent(this.jPanel10, -1, -1, 32767))
/* 2300 */           .addGap(50, 50, 50)));
/*      */     
/* 2302 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 2303 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2304 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 2305 */           .addContainerGap(-1, 32767)
/* 2306 */           .addComponent(this.jPanel10, -2, -1, -2)
/* 2307 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2308 */           .addComponent(this.jPanel13, -2, -1, -2)
/* 2309 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2310 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2311 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/* 2312 */               .addComponent(this.jPanel17, -1, -1, 32767)
/* 2313 */               .addGap(18, 18, 18)
/* 2314 */               .addComponent(this.jPanel18, -2, -1, -2))
/* 2315 */             .addComponent(this.ordersTable, -2, 324, -2))
/* 2316 */           .addContainerGap(69, 32767)));
/*      */ 
/*      */     
/* 2319 */     this.jPanel14.add(this.jPanel9, "relatorioDeVendas");
/*      */     
/* 2321 */     this.jLabel4.setFont(new Font("Segoe UI", 1, 18));
/* 2322 */     this.jLabel4.setForeground(new Color(102, 102, 102));
/* 2323 */     this.jLabel4.setHorizontalAlignment(0);
/* 2324 */     this.jLabel4.setText("ACESSOS E ACTIVIDADE DO FUNCIONÁRIO");
/*      */     
/* 2326 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 2327 */     this.jPanel20.setLayout(jPanel20Layout);
/* 2328 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 2329 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2330 */         .addComponent(this.jLabel4, -1, -1, 32767));
/*      */     
/* 2332 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 2333 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2334 */         .addComponent(this.jLabel4, -1, 38, 32767));
/*      */ 
/*      */     
/* 2337 */     this.jPanel21.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 2339 */     this.jLabel14.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 2340 */     this.jLabel14.setText("Nome do Funcionário ");
/*      */     
/* 2342 */     this.comboUserAccess.setFont(new Font("Segoe UI Semibold", 0, 14));
/*      */     
/* 2344 */     this.jButton16.setBackground(new Color(0, 153, 153));
/* 2345 */     this.jButton16.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 2346 */     this.jButton16.setForeground(new Color(255, 255, 255));
/* 2347 */     this.jButton16.setText("BUSCAR");
/* 2348 */     this.jButton16.setCursor(new Cursor(12));
/* 2349 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2351 */             mainWindow.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2355 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/* 2356 */     this.jPanel21.setLayout(jPanel21Layout);
/* 2357 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/* 2358 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2359 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 2360 */           .addGap(160, 160, 160)
/* 2361 */           .addComponent(this.jLabel14, -2, 176, -2)
/* 2362 */           .addGap(18, 18, 18)
/* 2363 */           .addComponent(this.comboUserAccess, -2, 189, -2)
/* 2364 */           .addGap(48, 48, 48)
/* 2365 */           .addComponent(this.jButton16, -2, 189, -2)
/* 2366 */           .addContainerGap(460, 32767)));
/*      */     
/* 2368 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/* 2369 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2370 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
/* 2371 */           .addContainerGap(30, 32767)
/* 2372 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2373 */             .addComponent(this.jLabel14, -1, -1, 32767)
/* 2374 */             .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2375 */               .addComponent(this.comboUserAccess, -2, 31, -2)
/* 2376 */               .addComponent(this.jButton16, -2, 31, -2)))
/* 2377 */           .addGap(15, 15, 15)));
/*      */ 
/*      */     
/* 2380 */     this.jPanel51.setBorder(BorderFactory.createTitledBorder(null, "Actividade", 0, 0, new Font("Segoe UI Black", 0, 14)));
/*      */     
/* 2382 */     this.jLabel118.setFont(new Font("Segoe UI", 1, 14));
/* 2383 */     this.jLabel118.setText("Data do Último Acesso");
/*      */     
/* 2385 */     this.lasAccessTime.setEditable(false);
/* 2386 */     this.lasAccessTime.setBackground(new Color(240, 216, 192));
/* 2387 */     this.lasAccessTime.setFont(new Font("Segoe UI", 1, 14));
/* 2388 */     this.lasAccessTime.setHorizontalAlignment(0);
/* 2389 */     this.lasAccessTime.setFocusable(false);
/*      */     
/* 2391 */     this.userActivityTB.setModel(new DefaultTableModel(new Object[][] { { null, null }, { null, null }, { null, null }, { null, null },  }, (Object[])new String[] { "Data", "Valor Vendido" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2402 */     this.jScrollPane8.setViewportView(this.userActivityTB);
/*      */     
/* 2404 */     GroupLayout jPanel51Layout = new GroupLayout(this.jPanel51);
/* 2405 */     this.jPanel51.setLayout(jPanel51Layout);
/* 2406 */     jPanel51Layout.setHorizontalGroup(jPanel51Layout
/* 2407 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2408 */         .addGroup(jPanel51Layout.createSequentialGroup()
/* 2409 */           .addGroup(jPanel51Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2410 */             .addComponent(this.jSeparator6)
/* 2411 */             .addGroup(jPanel51Layout.createSequentialGroup()
/* 2412 */               .addComponent(this.jLabel118)
/* 2413 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2414 */               .addComponent(this.lasAccessTime, -2, 196, -2)
/* 2415 */               .addGap(0, 0, 32767))
/* 2416 */             .addGroup(jPanel51Layout.createSequentialGroup()
/* 2417 */               .addContainerGap()
/* 2418 */               .addComponent(this.jScrollPane8, -2, 0, 32767)))
/* 2419 */           .addContainerGap()));
/*      */     
/* 2421 */     jPanel51Layout.setVerticalGroup(jPanel51Layout
/* 2422 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2423 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
/* 2424 */           .addGroup(jPanel51Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2425 */             .addComponent(this.jLabel118, -2, 31, -2)
/* 2426 */             .addComponent(this.lasAccessTime, -2, 31, -2))
/* 2427 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2428 */           .addComponent(this.jSeparator6, -2, 10, -2)
/* 2429 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2430 */           .addComponent(this.jScrollPane8, -2, 0, 32767)));
/*      */ 
/*      */     
/* 2433 */     this.jPanel52.setBorder(BorderFactory.createTitledBorder(null, "Modificar Acessos", 0, 0, new Font("Segoe UI Black", 0, 14)));
/*      */     
/* 2435 */     this.jLabel119.setFont(new Font("Segoe UI", 1, 14));
/* 2436 */     this.jLabel119.setText("Nome");
/*      */     
/* 2438 */     this.nameAccess.setEditable(false);
/* 2439 */     this.nameAccess.setBackground(new Color(240, 216, 192));
/* 2440 */     this.nameAccess.setFont(new Font("Segoe UI", 1, 14));
/* 2441 */     this.nameAccess.setHorizontalAlignment(0);
/* 2442 */     this.nameAccess.setFocusable(false);
/*      */     
/* 2444 */     this.loginAccess.setFont(new Font("Segoe UI", 0, 14));
/* 2445 */     this.loginAccess.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2447 */             mainWindow.this.loginAccessKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2451 */     this.jLabel120.setFont(new Font("Segoe UI", 1, 14));
/* 2452 */     this.jLabel120.setText("Usuário");
/*      */     
/* 2454 */     this.passwordAccess.setFont(new Font("Segoe UI", 0, 14));
/* 2455 */     this.passwordAccess.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2457 */             mainWindow.this.passwordAccessKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2461 */     this.jLabel121.setFont(new Font("Segoe UI", 1, 14));
/* 2462 */     this.jLabel121.setText("Senha");
/*      */     
/* 2464 */     this.jLabel122.setFont(new Font("Segoe UI", 1, 14));
/* 2465 */     this.jLabel122.setText("Tipo de Acesso");
/*      */     
/* 2467 */     this.accessType.setModel(new DefaultComboBoxModel<>(new String[] { "ADMIN", "NORMAL", "BLOQUEADO" }));
/* 2468 */     this.accessType.setSelectedItem((Object)null);
/* 2469 */     this.accessType.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2471 */             mainWindow.this.accessTypeKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2475 */     this.jButton14.setBackground(new Color(0, 153, 153));
/* 2476 */     this.jButton14.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 2477 */     this.jButton14.setForeground(new Color(255, 255, 255));
/* 2478 */     this.jButton14.setText("SALVAR");
/* 2479 */     this.jButton14.setCursor(new Cursor(12));
/* 2480 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2482 */             mainWindow.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2486 */     GroupLayout jPanel52Layout = new GroupLayout(this.jPanel52);
/* 2487 */     this.jPanel52.setLayout(jPanel52Layout);
/* 2488 */     jPanel52Layout.setHorizontalGroup(jPanel52Layout
/* 2489 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2490 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
/* 2491 */           .addGap(49, 49, 49)
/* 2492 */           .addGroup(jPanel52Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2493 */             .addComponent(this.jLabel122, -1, -1, 32767)
/* 2494 */             .addComponent(this.jLabel121, -1, -1, 32767)
/* 2495 */             .addComponent(this.jLabel120, -1, -1, 32767)
/* 2496 */             .addComponent(this.jLabel119, -1, -1, 32767))
/* 2497 */           .addGap(18, 18, 32767)
/* 2498 */           .addGroup(jPanel52Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2499 */             .addComponent(this.jButton14, -1, 283, 32767)
/* 2500 */             .addComponent(this.nameAccess)
/* 2501 */             .addComponent(this.loginAccess)
/* 2502 */             .addComponent(this.passwordAccess)
/* 2503 */             .addComponent(this.accessType, 0, 283, 32767))
/* 2504 */           .addGap(64, 64, 64)));
/*      */     
/* 2506 */     jPanel52Layout.setVerticalGroup(jPanel52Layout
/* 2507 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2508 */         .addGroup(jPanel52Layout.createSequentialGroup()
/* 2509 */           .addContainerGap()
/* 2510 */           .addGroup(jPanel52Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2511 */             .addComponent(this.jLabel119, -2, 31, -2)
/* 2512 */             .addComponent(this.nameAccess, -2, 31, -2))
/* 2513 */           .addGap(18, 18, 18)
/* 2514 */           .addGroup(jPanel52Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2515 */             .addComponent(this.jLabel120, -2, 31, -2)
/* 2516 */             .addComponent(this.loginAccess, -2, 31, -2))
/* 2517 */           .addGap(18, 18, 18)
/* 2518 */           .addGroup(jPanel52Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2519 */             .addComponent(this.jLabel121, -2, 31, -2)
/* 2520 */             .addComponent(this.passwordAccess, -2, 31, -2))
/* 2521 */           .addGap(18, 18, 18)
/* 2522 */           .addGroup(jPanel52Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2523 */             .addComponent(this.jLabel122, -2, 31, -2)
/* 2524 */             .addComponent(this.accessType, -2, 31, -2))
/* 2525 */           .addGap(18, 18, 18)
/* 2526 */           .addComponent(this.jButton14, -2, 31, -2)
/* 2527 */           .addContainerGap(58, 32767)));
/*      */ 
/*      */     
/* 2530 */     GroupLayout jPanel50Layout = new GroupLayout(this.jPanel50);
/* 2531 */     this.jPanel50.setLayout(jPanel50Layout);
/* 2532 */     jPanel50Layout.setHorizontalGroup(jPanel50Layout
/* 2533 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2534 */         .addGroup(jPanel50Layout.createSequentialGroup()
/* 2535 */           .addContainerGap(50, 32767)
/* 2536 */           .addComponent(this.jPanel51, -2, -1, -2)
/* 2537 */           .addGap(18, 18, 32767)
/* 2538 */           .addComponent(this.jPanel52, -2, 513, -2)
/* 2539 */           .addContainerGap(409, 32767)));
/*      */     
/* 2541 */     jPanel50Layout.setVerticalGroup(jPanel50Layout
/* 2542 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2543 */         .addGroup(jPanel50Layout.createSequentialGroup()
/* 2544 */           .addContainerGap()
/* 2545 */           .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2546 */             .addComponent(this.jPanel51, -1, -1, 32767)
/* 2547 */             .addComponent(this.jPanel52, -1, -1, 32767))
/* 2548 */           .addContainerGap(145, 32767)));
/*      */ 
/*      */     
/* 2551 */     this.jScrollPane3.setViewportView(this.jPanel50);
/*      */     
/* 2553 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/* 2554 */     this.jPanel19.setLayout(jPanel19Layout);
/* 2555 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/* 2556 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2557 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
/* 2558 */           .addGap(30, 30, 30)
/* 2559 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2560 */             .addComponent(this.jPanel21, -1, -1, 32767)
/* 2561 */             .addComponent(this.jPanel20, -1, -1, 32767)
/* 2562 */             .addComponent(this.jScrollPane3, GroupLayout.Alignment.LEADING, -2, 0, 32767))
/* 2563 */           .addGap(30, 30, 30)));
/*      */     
/* 2565 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/* 2566 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2567 */         .addGroup(jPanel19Layout.createSequentialGroup()
/* 2568 */           .addContainerGap(-1, 32767)
/* 2569 */           .addComponent(this.jPanel20, -2, -1, -2)
/* 2570 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2571 */           .addComponent(this.jPanel21, -2, -1, -2)
/* 2572 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2573 */           .addComponent(this.jScrollPane3, -2, 371, -2)
/* 2574 */           .addContainerGap(80, 32767)));
/*      */ 
/*      */     
/* 2577 */     this.jPanel14.add(this.jPanel19, "acessos");
/*      */     
/* 2579 */     this.jLabel15.setFont(new Font("Segoe UI", 1, 18));
/* 2580 */     this.jLabel15.setForeground(new Color(102, 102, 102));
/* 2581 */     this.jLabel15.setHorizontalAlignment(0);
/* 2582 */     this.jLabel15.setText("MODIFICAR STOCK");
/*      */     
/* 2584 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/* 2585 */     this.jPanel25.setLayout(jPanel25Layout);
/* 2586 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/* 2587 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2588 */         .addComponent(this.jLabel15, -1, 1244, 32767));
/*      */     
/* 2590 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/* 2591 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2592 */         .addComponent(this.jLabel15, -1, 38, 32767));
/*      */ 
/*      */     
/* 2595 */     this.jPanel26.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 2597 */     this.jPanel8.setBackground(new Color(211, 80, 48));
/*      */     
/* 2599 */     this.jLabel2.setBackground(new Color(211, 80, 48));
/* 2600 */     this.jLabel2.setFont(new Font("Segoe UI", 1, 14));
/* 2601 */     this.jLabel2.setForeground(new Color(255, 255, 255));
/* 2602 */     this.jLabel2.setHorizontalAlignment(0);
/* 2603 */     this.jLabel2.setText("ADICIONAR");
/* 2604 */     this.jLabel2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2606 */             mainWindow.this.jLabel2MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2609 */             mainWindow.this.jLabel2MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 2613 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 2614 */     this.jPanel8.setLayout(jPanel8Layout);
/* 2615 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 2616 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2617 */         .addComponent(this.jLabel2, -1, 181, 32767));
/*      */     
/* 2619 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 2620 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2621 */         .addComponent(this.jLabel2, -1, 34, 32767));
/*      */ 
/*      */     
/* 2624 */     this.jPanel30.setBackground(new Color(0, 153, 153));
/*      */     
/* 2626 */     this.jLabel20.setFont(new Font("Segoe UI", 1, 14));
/* 2627 */     this.jLabel20.setForeground(new Color(255, 255, 255));
/* 2628 */     this.jLabel20.setHorizontalAlignment(0);
/* 2629 */     this.jLabel20.setText("EDITAR");
/* 2630 */     this.jLabel20.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2632 */             mainWindow.this.jLabel20MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2635 */             mainWindow.this.jLabel20MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 2639 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/* 2640 */     this.jPanel30.setLayout(jPanel30Layout);
/* 2641 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/* 2642 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2643 */         .addComponent(this.jLabel20, -1, 181, 32767));
/*      */     
/* 2645 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/* 2646 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2647 */         .addComponent(this.jLabel20, -1, -1, 32767));
/*      */ 
/*      */     
/* 2650 */     this.jPanel31.setBackground(new Color(0, 153, 153));
/*      */     
/* 2652 */     this.jLabel21.setFont(new Font("Segoe UI", 1, 14));
/* 2653 */     this.jLabel21.setForeground(new Color(255, 255, 255));
/* 2654 */     this.jLabel21.setHorizontalAlignment(0);
/* 2655 */     this.jLabel21.setText("REMOVER");
/* 2656 */     this.jLabel21.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2658 */             mainWindow.this.jLabel21MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 2661 */             mainWindow.this.jLabel21MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 2665 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/* 2666 */     this.jPanel31.setLayout(jPanel31Layout);
/* 2667 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/* 2668 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2669 */         .addComponent(this.jLabel21, -1, 181, 32767));
/*      */     
/* 2671 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/* 2672 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2673 */         .addComponent(this.jLabel21, -1, -1, 32767));
/*      */ 
/*      */     
/* 2676 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/* 2677 */     this.jPanel26.setLayout(jPanel26Layout);
/* 2678 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/* 2679 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2680 */         .addGroup(jPanel26Layout.createSequentialGroup()
/* 2681 */           .addContainerGap(-1, 32767)
/* 2682 */           .addComponent(this.jPanel8, -2, -1, -2)
/* 2683 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2684 */           .addComponent(this.jPanel30, -2, -1, -2)
/* 2685 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2686 */           .addComponent(this.jPanel31, -2, -1, -2)
/* 2687 */           .addContainerGap(-1, 32767)));
/*      */     
/* 2689 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/* 2690 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2691 */         .addGroup(jPanel26Layout.createSequentialGroup()
/* 2692 */           .addGap(35, 35, 35)
/* 2693 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2694 */             .addComponent(this.jPanel8, -1, -1, 32767)
/* 2695 */             .addComponent(this.jPanel30, -1, -1, 32767)
/* 2696 */             .addComponent(this.jPanel31, -1, -1, 32767))
/* 2697 */           .addContainerGap(31, 32767)));
/*      */ 
/*      */     
/* 2700 */     this.jPanel22.setPreferredSize(new Dimension(579, 104));
/* 2701 */     this.jPanel22.setLayout(new CardLayout());
/*      */     
/* 2703 */     this.jPanel23.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 2705 */     this.jLabel38.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 2706 */     this.jLabel38.setText("Código de Barras");
/*      */     
/* 2708 */     this.barCodeSave.setFont(new Font("Segoe UI", 0, 14));
/* 2709 */     this.barCodeSave.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2711 */             mainWindow.this.barCodeSaveKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2715 */     this.genericNameSave.setFont(new Font("Segoe UI", 0, 14));
/* 2716 */     this.genericNameSave.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2718 */             mainWindow.this.genericNameSaveKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2722 */     this.jLabel39.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 2723 */     this.jLabel39.setText("N. Genérico");
/*      */     
/* 2725 */     this.jLabel40.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 2726 */     this.jLabel40.setText("N. Comercial");
/*      */     
/* 2728 */     this.comercialNameSave.setFont(new Font("Segoe UI", 0, 14));
/* 2729 */     this.comercialNameSave.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2731 */             mainWindow.this.comercialNameSaveKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2735 */     this.batchNrSave.setFont(new Font("Segoe UI", 0, 14));
/* 2736 */     this.batchNrSave.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2738 */             mainWindow.this.batchNrSaveKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2742 */     this.jLabel41.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 2743 */     this.jLabel41.setText("Batch N°");
/*      */     
/* 2745 */     this.jLabel42.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 2746 */     this.jLabel42.setText("Catgoria");
/*      */     
/* 2748 */     this.qtySave.setFont(new Font("Segoe UI", 0, 14));
/* 2749 */     this.qtySave.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2751 */             mainWindow.this.qtySaveKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2755 */     this.jLabel43.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 2756 */     this.jLabel43.setText("Quantidade");
/*      */     
/* 2758 */     this.jLabel44.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 2759 */     this.jLabel44.setText("Unidade");
/*      */     
/* 2761 */     this.unitSave.setFont(new Font("Segoe UI", 0, 14));
/* 2762 */     this.unitSave.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2764 */             mainWindow.this.unitSaveActionPerformed(evt);
/*      */           }
/*      */         });
/* 2767 */     this.unitSave.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2769 */             mainWindow.this.unitSaveKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2773 */     this.manufacturerSave.setFont(new Font("Segoe UI", 0, 14));
/* 2774 */     this.manufacturerSave.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2776 */             mainWindow.this.manufacturerSaveKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2780 */     this.jLabel45.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 2781 */     this.jLabel45.setText("Fabricante");
/*      */     
/* 2783 */     this.jLabel67.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 2784 */     this.jLabel67.setText("Fornecedor");
/*      */     
/* 2786 */     this.supplierSave.setFont(new Font("Segoe UI", 0, 14));
/* 2787 */     this.supplierSave.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2789 */             mainWindow.this.supplierSaveKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2793 */     this.jLabel68.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 2794 */     this.jLabel68.setText("Data de Entrada");
/*      */     
/* 2796 */     this.jLabel69.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 2797 */     this.jLabel69.setText("Data de Validade");
/*      */     
/* 2799 */     this.prVendaSave.setFont(new Font("Segoe UI", 0, 14));
/* 2800 */     this.prVendaSave.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2802 */             mainWindow.this.prVendaSaveKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2806 */     this.jLabel70.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 2807 */     this.jLabel70.setText("Preço de Venda");
/*      */     
/* 2809 */     this.expireDateSave.setDateFormatString("yyyy-MM-dd");
/* 2810 */     this.expireDateSave.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2812 */             mainWindow.this.expireDateSaveKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2816 */     this.entryDateSave.setDateFormatString("yyyy-MM-dd");
/* 2817 */     this.entryDateSave.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2819 */             mainWindow.this.entryDateSaveKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2823 */     this.categSave.setFont(new Font("Segoe UI", 0, 14));
/* 2824 */     this.categSave.setModel(new DefaultComboBoxModel<>(new String[] { "pós", "granulados", "comprimidos", "drágeas", "cápsulas", "supositórios", "óvulos", "soluções", "xaropes", "elixires", "suspensões", "emulsões", "injetáveis", "tinturas", "extratos" }));
/* 2825 */     this.categSave.setPreferredSize(new Dimension(6, 20));
/* 2826 */     this.categSave.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2828 */             mainWindow.this.categSaveKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2832 */     this.jLabel71.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 2833 */     this.jLabel71.setText("Preço de Compra");
/*      */     
/* 2835 */     this.prCompraSave.setFont(new Font("Segoe UI", 0, 14));
/* 2836 */     this.prCompraSave.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 2838 */             mainWindow.this.prCompraSaveKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2842 */     this.jButton18.setBackground(new Color(0, 153, 153));
/* 2843 */     this.jButton18.setFont(new Font("Segoe UI", 1, 14));
/* 2844 */     this.jButton18.setForeground(new Color(255, 255, 255));
/* 2845 */     this.jButton18.setText("SALVAR");
/* 2846 */     this.jButton18.setCursor(new Cursor(12));
/* 2847 */     this.jButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2849 */             mainWindow.this.jButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2853 */     this.jButton19.setBackground(new Color(0, 153, 153));
/* 2854 */     this.jButton19.setFont(new Font("Segoe UI", 1, 14));
/* 2855 */     this.jButton19.setForeground(new Color(255, 255, 255));
/* 2856 */     this.jButton19.setText("CANCELAR");
/* 2857 */     this.jButton19.setCursor(new Cursor(12));
/* 2858 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2860 */             mainWindow.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2864 */     GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
/* 2865 */     this.jPanel23.setLayout(jPanel23Layout);
/* 2866 */     jPanel23Layout.setHorizontalGroup(jPanel23Layout
/* 2867 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2868 */         .addGroup(jPanel23Layout.createSequentialGroup()
/* 2869 */           .addContainerGap(-1, 32767)
/* 2870 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2871 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 2872 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2873 */                 .addComponent(this.jLabel38, -1, 137, 32767)
/* 2874 */                 .addComponent(this.jLabel39, -1, -1, 32767))
/* 2875 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2876 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2877 */                 .addComponent(this.barCodeSave)
/* 2878 */                 .addComponent(this.genericNameSave, -2, 209, -2))
/* 2879 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 81, 32767)
/* 2880 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2881 */                 .addComponent(this.jLabel44, -1, -1, 32767)
/* 2882 */                 .addComponent(this.jLabel45, -1, 137, 32767))
/* 2883 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2884 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2885 */                 .addComponent(this.unitSave)
/* 2886 */                 .addComponent(this.manufacturerSave, -2, 209, -2)))
/* 2887 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 2888 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2889 */                 .addComponent(this.jLabel40, -1, 137, 32767)
/* 2890 */                 .addComponent(this.jLabel41, -1, -1, 32767))
/* 2891 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2892 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2893 */                 .addComponent(this.comercialNameSave)
/* 2894 */                 .addComponent(this.batchNrSave, -2, 209, -2))
/* 2895 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, 32767)
/* 2896 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2897 */                 .addComponent(this.jLabel67, -1, -1, 32767)
/* 2898 */                 .addComponent(this.jLabel68, -1, 137, 32767))
/* 2899 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2900 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2901 */                 .addComponent(this.supplierSave)
/* 2902 */                 .addComponent((Component)this.entryDateSave, -1, 209, 32767)))
/* 2903 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
/* 2904 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2905 */                 .addComponent(this.jLabel42, -1, -1, 32767)
/* 2906 */                 .addComponent(this.jLabel43, -1, 137, 32767))
/* 2907 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2908 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2909 */                 .addComponent(this.qtySave, -1, 209, 32767)
/* 2910 */                 .addComponent(this.categSave, 0, -1, 32767))
/* 2911 */               .addGap(18, 18, 32767)
/* 2912 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2913 */                 .addComponent(this.jLabel71, -1, 137, 32767)
/* 2914 */                 .addComponent(this.jLabel69, -1, 137, 32767)
/* 2915 */                 .addComponent(this.jLabel70, -1, -1, 32767))
/* 2916 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2917 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2918 */                 .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2919 */                   .addComponent(this.prVendaSave, -2, 209, -2)
/* 2920 */                   .addComponent((Component)this.expireDateSave, -2, 209, -2))
/* 2921 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2922 */                   .addGroup(jPanel23Layout.createSequentialGroup()
/* 2923 */                     .addComponent(this.jButton19)
/* 2924 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2925 */                     .addComponent(this.jButton18, -2, 98, -2))
/* 2926 */                   .addComponent(this.prCompraSave, -2, 209, -2)))))
/* 2927 */           .addContainerGap(-1, 32767)));
/*      */     
/* 2929 */     jPanel23Layout.setVerticalGroup(jPanel23Layout
/* 2930 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2931 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
/* 2932 */           .addContainerGap(-1, 32767)
/* 2933 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2934 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 2935 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2936 */                 .addComponent(this.jLabel38, -2, 31, -2)
/* 2937 */                 .addComponent(this.barCodeSave, -2, 31, -2))
/* 2938 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2939 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2940 */                 .addComponent(this.jLabel39, -2, 31, -2)
/* 2941 */                 .addComponent(this.genericNameSave, -2, 31, -2)))
/* 2942 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 2943 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2944 */                 .addComponent(this.jLabel44, -2, 31, -2)
/* 2945 */                 .addComponent(this.unitSave, -2, 31, -2))
/* 2946 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2947 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2948 */                 .addComponent(this.jLabel45, -2, 31, -2)
/* 2949 */                 .addComponent(this.manufacturerSave, -2, 31, -2))))
/* 2950 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2951 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2952 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 2953 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2954 */                 .addComponent(this.jLabel40, -2, 31, -2)
/* 2955 */                 .addComponent(this.comercialNameSave, -2, 31, -2))
/* 2956 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2957 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2958 */                 .addComponent(this.jLabel41, -2, 31, -2)
/* 2959 */                 .addComponent(this.batchNrSave, -2, 31, -2)))
/* 2960 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 2961 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2962 */                 .addComponent(this.jLabel67, -2, 31, -2)
/* 2963 */                 .addComponent(this.supplierSave, -2, 31, -2))
/* 2964 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2965 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2966 */                 .addComponent((Component)this.entryDateSave, -2, 33, -2)
/* 2967 */                 .addComponent(this.jLabel68, -2, 31, -2))))
/* 2968 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2969 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2970 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 2971 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2972 */                 .addComponent(this.jLabel42, -2, 31, -2)
/* 2973 */                 .addComponent(this.categSave, -2, 31, -2))
/* 2974 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2975 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2976 */                 .addComponent(this.jLabel43, -2, 31, -2)
/* 2977 */                 .addComponent(this.qtySave, -2, 31, -2)))
/* 2978 */             .addGroup(jPanel23Layout.createSequentialGroup()
/* 2979 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2980 */                 .addComponent((Component)this.expireDateSave, GroupLayout.Alignment.TRAILING, -2, 33, -2)
/* 2981 */                 .addComponent(this.jLabel69, -2, 31, -2))
/* 2982 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2983 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2984 */                 .addComponent(this.jLabel70, -2, 31, -2)
/* 2985 */                 .addComponent(this.prVendaSave, -2, 31, -2))))
/* 2986 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2987 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2988 */             .addComponent(this.jLabel71, -2, 31, -2)
/* 2989 */             .addComponent(this.prCompraSave, -2, 31, -2))
/* 2990 */           .addGap(33, 33, 33)
/* 2991 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2992 */             .addComponent(this.jButton18, -2, 34, -2)
/* 2993 */             .addComponent(this.jButton19, -2, 34, -2))
/* 2994 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2997 */     this.jPanel22.add(this.jPanel23, "modificarStockAdicionar");
/*      */     
/* 2999 */     this.jPanel32.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 3001 */     this.jLabel72.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3002 */     this.jLabel72.setText("Código de Barras");
/*      */     
/* 3004 */     this.barCodeEditTA.setFont(new Font("Segoe UI", 0, 14));
/* 3005 */     this.barCodeEditTA.setEnabled(false);
/* 3006 */     this.barCodeEditTA.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3008 */             mainWindow.this.barCodeEditTAKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3012 */     this.genericNameEditTA.setFont(new Font("Segoe UI", 0, 14));
/* 3013 */     this.genericNameEditTA.setEnabled(false);
/* 3014 */     this.genericNameEditTA.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3016 */             mainWindow.this.genericNameEditTAKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3020 */     this.jLabel73.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3021 */     this.jLabel73.setText("N. Generico");
/*      */     
/* 3023 */     this.jLabel74.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3024 */     this.jLabel74.setText("N. Comercial");
/*      */     
/* 3026 */     this.comercialNameEditTA.setFont(new Font("Segoe UI", 0, 14));
/* 3027 */     this.comercialNameEditTA.setEnabled(false);
/* 3028 */     this.comercialNameEditTA.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3030 */             mainWindow.this.comercialNameEditTAKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3034 */     this.batchNrEdit.setFont(new Font("Segoe UI", 0, 14));
/* 3035 */     this.batchNrEdit.setEnabled(false);
/* 3036 */     this.batchNrEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3038 */             mainWindow.this.batchNrEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3042 */     this.jLabel75.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3043 */     this.jLabel75.setText("Batch N°");
/*      */     
/* 3045 */     this.jLabel76.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3046 */     this.jLabel76.setText("Catgoria");
/*      */     
/* 3048 */     this.qtyEditTA.setFont(new Font("Segoe UI", 0, 14));
/* 3049 */     this.qtyEditTA.setEnabled(false);
/* 3050 */     this.qtyEditTA.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3052 */             mainWindow.this.qtyEditTAKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3056 */     this.qtyEditArea.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3057 */     this.qtyEditArea.setText("Quantidade");
/*      */     
/* 3059 */     this.jLabel78.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3060 */     this.jLabel78.setText("Unidade");
/*      */     
/* 3062 */     this.unitEdit.setFont(new Font("Segoe UI", 0, 14));
/* 3063 */     this.unitEdit.setEnabled(false);
/* 3064 */     this.unitEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3066 */             mainWindow.this.unitEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3070 */     this.manufacturerEdit.setFont(new Font("Segoe UI", 0, 14));
/* 3071 */     this.manufacturerEdit.setEnabled(false);
/* 3072 */     this.manufacturerEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3074 */             mainWindow.this.manufacturerEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3078 */     this.jLabel79.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3079 */     this.jLabel79.setText("Fabricante");
/*      */     
/* 3081 */     this.jLabel80.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3082 */     this.jLabel80.setText("Fornecedor");
/*      */     
/* 3084 */     this.supplierEdit.setFont(new Font("Segoe UI", 0, 14));
/* 3085 */     this.supplierEdit.setEnabled(false);
/* 3086 */     this.supplierEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3088 */             mainWindow.this.supplierEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3092 */     this.jLabel81.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3093 */     this.jLabel81.setText("Data de Entrada");
/*      */     
/* 3095 */     this.jLabel82.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3096 */     this.jLabel82.setText("Data de Validade");
/*      */     
/* 3098 */     this.sellPriceEdit.setFont(new Font("Segoe UI", 0, 14));
/* 3099 */     this.sellPriceEdit.setEnabled(false);
/* 3100 */     this.sellPriceEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3102 */             mainWindow.this.sellPriceEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3106 */     this.jLabel83.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3107 */     this.jLabel83.setText("Preço de Venda");
/*      */     
/* 3109 */     this.expireDateEdit.setDateFormatString("yyyy-MM-dd");
/* 3110 */     this.expireDateEdit.setEnabled(false);
/* 3111 */     this.expireDateEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3113 */             mainWindow.this.expireDateEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3117 */     this.entryDateEdit.setDateFormatString("yyyy-MM-dd");
/* 3118 */     this.entryDateEdit.setEnabled(false);
/* 3119 */     this.entryDateEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3121 */             mainWindow.this.entryDateEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3125 */     this.categoryEdit.setFont(new Font("Segoe UI", 0, 14));
/* 3126 */     this.categoryEdit.setModel(new DefaultComboBoxModel<>(new String[] { "pós", "granulados", "comprimidos", "drágeas", "cápsulas", "supositórios", "óvulos", "soluções", "xaropes", "elixires", "suspensões", "emulsões", "injetáveis", "tinturas", "extratos" }));
/* 3127 */     this.categoryEdit.setEnabled(false);
/* 3128 */     this.categoryEdit.setPreferredSize(new Dimension(6, 20));
/* 3129 */     this.categoryEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3131 */             mainWindow.this.categoryEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3135 */     this.jLabel84.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3136 */     this.jLabel84.setText("Preço de Compra");
/*      */     
/* 3138 */     this.buyPriceEdit.setFont(new Font("Segoe UI", 0, 14));
/* 3139 */     this.buyPriceEdit.setEnabled(false);
/* 3140 */     this.buyPriceEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3142 */             mainWindow.this.buyPriceEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3146 */     this.jLabel22.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3147 */     this.jLabel22.setText("N. Comercial");
/*      */     
/* 3149 */     this.jLabel23.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3150 */     this.jLabel23.setText("Código de Barras");
/*      */     
/* 3152 */     this.nComercialEdit.setFont(new Font("Segoe UI", 0, 14));
/* 3153 */     this.nComercialEdit.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3155 */             mainWindow.this.nComercialEditMouseClicked(evt);
/*      */           }
/*      */         });
/* 3158 */     this.nComercialEdit.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3160 */             mainWindow.this.nComercialEditActionPerformed(evt);
/*      */           }
/*      */         });
/* 3163 */     this.nComercialEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3165 */             mainWindow.this.nComercialEditKeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 3168 */             mainWindow.this.nComercialEditKeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 3172 */     this.barCodeEdit.setFont(new Font("Segoe UI", 0, 14));
/* 3173 */     this.barCodeEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3175 */             mainWindow.this.barCodeEditKeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 3178 */             mainWindow.this.barCodeEditKeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 3182 */     this.selectEdit.setBackground(new Color(0, 153, 153));
/* 3183 */     this.selectEdit.setFont(new Font("Segoe UI", 1, 14));
/* 3184 */     this.selectEdit.setForeground(new Color(255, 255, 255));
/* 3185 */     this.selectEdit.setText("SELECIONAR");
/* 3186 */     this.selectEdit.setCursor(new Cursor(12));
/* 3187 */     this.selectEdit.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3189 */             mainWindow.this.selectEditActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3193 */     this.jButton22.setBackground(new Color(0, 153, 153));
/* 3194 */     this.jButton22.setFont(new Font("Segoe UI", 1, 14));
/* 3195 */     this.jButton22.setForeground(new Color(255, 255, 255));
/* 3196 */     this.jButton22.setText("SALVAR");
/* 3197 */     this.jButton22.setCursor(new Cursor(12));
/* 3198 */     this.jButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3200 */             mainWindow.this.jButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3204 */     this.jButton23.setBackground(new Color(0, 153, 153));
/* 3205 */     this.jButton23.setFont(new Font("Segoe UI", 1, 14));
/* 3206 */     this.jButton23.setForeground(new Color(255, 255, 255));
/* 3207 */     this.jButton23.setText("CANCELAR");
/* 3208 */     this.jButton23.setCursor(new Cursor(12));
/* 3209 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3211 */             mainWindow.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3215 */     GroupLayout jPanel32Layout = new GroupLayout(this.jPanel32);
/* 3216 */     this.jPanel32.setLayout(jPanel32Layout);
/* 3217 */     jPanel32Layout.setHorizontalGroup(jPanel32Layout
/* 3218 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3219 */         .addGroup(jPanel32Layout.createSequentialGroup()
/* 3220 */           .addGap(56, 56, 56)
/* 3221 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3222 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 3223 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3224 */                 .addComponent(this.jLabel22, -2, 93, -2)
/* 3225 */                 .addComponent(this.jLabel23, -2, 113, -2))
/* 3226 */               .addGap(34, 34, 34)
/* 3227 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3228 */                 .addComponent(this.barCodeEdit, -1, 210, 32767)
/* 3229 */                 .addComponent(this.nComercialEdit))
/* 3230 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3231 */               .addComponent(this.selectEdit)
/* 3232 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 3233 */               .addComponent(this.jButton23)
/* 3234 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3235 */               .addComponent(this.jButton22, -2, 98, -2))
/* 3236 */             .addComponent(this.jSeparator2, GroupLayout.Alignment.TRAILING)
/* 3237 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 3238 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3239 */                 .addComponent(this.jLabel72, -1, 137, 32767)
/* 3240 */                 .addComponent(this.jLabel73, -1, -1, 32767))
/* 3241 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3242 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3243 */                 .addComponent(this.barCodeEditTA)
/* 3244 */                 .addComponent(this.genericNameEditTA, -2, 209, -2))
/* 3245 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 116, 32767)
/* 3246 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3247 */                 .addComponent(this.jLabel78, -1, -1, 32767)
/* 3248 */                 .addComponent(this.jLabel79, -1, 137, 32767))
/* 3249 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3250 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3251 */                 .addComponent(this.unitEdit)
/* 3252 */                 .addComponent(this.manufacturerEdit, -2, 209, -2)))
/* 3253 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 3254 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3255 */                 .addComponent(this.jLabel74, -1, 137, 32767)
/* 3256 */                 .addComponent(this.jLabel75, -1, -1, 32767))
/* 3257 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3258 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3259 */                 .addComponent(this.comercialNameEditTA)
/* 3260 */                 .addComponent(this.batchNrEdit, -2, 209, -2))
/* 3261 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 3262 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3263 */                 .addComponent(this.jLabel80, -1, -1, 32767)
/* 3264 */                 .addComponent(this.jLabel81, -1, 137, 32767))
/* 3265 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3266 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3267 */                 .addComponent(this.supplierEdit)
/* 3268 */                 .addComponent((Component)this.entryDateEdit, -1, 209, 32767)))
/* 3269 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
/* 3270 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3271 */                 .addComponent(this.jLabel76, -1, -1, 32767)
/* 3272 */                 .addComponent(this.qtyEditArea, -1, 137, 32767))
/* 3273 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3274 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3275 */                 .addComponent(this.qtyEditTA, -1, 209, 32767)
/* 3276 */                 .addComponent(this.categoryEdit, 0, -1, 32767))
/* 3277 */               .addGap(18, 18, 32767)
/* 3278 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3279 */                 .addComponent(this.jLabel84, -1, 137, 32767)
/* 3280 */                 .addComponent(this.jLabel82, -1, 137, 32767)
/* 3281 */                 .addComponent(this.jLabel83, -1, -1, 32767))
/* 3282 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3283 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3284 */                 .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 3285 */                   .addComponent(this.sellPriceEdit, -2, 209, -2)
/* 3286 */                   .addComponent((Component)this.expireDateEdit, -2, 209, -2))
/* 3287 */                 .addComponent(this.buyPriceEdit, GroupLayout.Alignment.TRAILING, -2, 209, -2))))
/* 3288 */           .addGap(56, 56, 56)));
/*      */     
/* 3290 */     jPanel32Layout.setVerticalGroup(jPanel32Layout
/* 3291 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3292 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
/* 3293 */           .addGap(15, 15, 15)
/* 3294 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3295 */             .addComponent(this.jLabel22)
/* 3296 */             .addComponent(this.nComercialEdit, -2, -1, -2))
/* 3297 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 3298 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3299 */             .addComponent(this.jLabel23)
/* 3300 */             .addComponent(this.barCodeEdit, -2, -1, -2)
/* 3301 */             .addComponent(this.selectEdit)
/* 3302 */             .addComponent(this.jButton22)
/* 3303 */             .addComponent(this.jButton23))
/* 3304 */           .addGap(0, 0, 32767)
/* 3305 */           .addComponent(this.jSeparator2, -2, 10, -2)
/* 3306 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3307 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3308 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 3309 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3310 */                 .addComponent(this.jLabel72, -2, 31, -2)
/* 3311 */                 .addComponent(this.barCodeEditTA, -2, 31, -2))
/* 3312 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3313 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3314 */                 .addComponent(this.jLabel73, -2, 31, -2)
/* 3315 */                 .addComponent(this.genericNameEditTA, -2, 31, -2)))
/* 3316 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 3317 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3318 */                 .addComponent(this.jLabel78, -2, 31, -2)
/* 3319 */                 .addComponent(this.unitEdit, -2, 31, -2))
/* 3320 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3321 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3322 */                 .addComponent(this.jLabel79, -2, 31, -2)
/* 3323 */                 .addComponent(this.manufacturerEdit, -2, 31, -2))))
/* 3324 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3325 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3326 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 3327 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3328 */                 .addComponent(this.jLabel74, -2, 31, -2)
/* 3329 */                 .addComponent(this.comercialNameEditTA, -2, 31, -2))
/* 3330 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3331 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3332 */                 .addComponent(this.jLabel75, -2, 31, -2)
/* 3333 */                 .addComponent(this.batchNrEdit, -2, 31, -2)))
/* 3334 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 3335 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3336 */                 .addComponent(this.jLabel80, -2, 31, -2)
/* 3337 */                 .addComponent(this.supplierEdit, -2, 31, -2))
/* 3338 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3339 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3340 */                 .addComponent((Component)this.entryDateEdit, -2, 33, -2)
/* 3341 */                 .addComponent(this.jLabel81, -2, 31, -2))))
/* 3342 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3343 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3344 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 3345 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3346 */                 .addComponent(this.jLabel76, -2, 31, -2)
/* 3347 */                 .addComponent(this.categoryEdit, -2, 31, -2))
/* 3348 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3349 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3350 */                 .addComponent(this.qtyEditArea, -2, 31, -2)
/* 3351 */                 .addComponent(this.qtyEditTA, -2, 31, -2)))
/* 3352 */             .addGroup(jPanel32Layout.createSequentialGroup()
/* 3353 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3354 */                 .addComponent((Component)this.expireDateEdit, GroupLayout.Alignment.TRAILING, -2, 33, -2)
/* 3355 */                 .addComponent(this.jLabel82, -2, 31, -2))
/* 3356 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3357 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3358 */                 .addComponent(this.jLabel83, -2, 31, -2)
/* 3359 */                 .addComponent(this.sellPriceEdit, -2, 31, -2))))
/* 3360 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3361 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3362 */             .addComponent(this.jLabel84, -2, 31, -2)
/* 3363 */             .addComponent(this.buyPriceEdit, -2, 31, -2))
/* 3364 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3367 */     this.jPanel22.add(this.jPanel32, "modificarStockEditar");
/*      */     
/* 3369 */     this.jPanel33.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 3371 */     this.jLabel85.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3372 */     this.jLabel85.setText("Código de Barras");
/*      */     
/* 3374 */     this.barCodeRemove.setFont(new Font("Segoe UI", 0, 14));
/* 3375 */     this.barCodeRemove.setEnabled(false);
/*      */     
/* 3377 */     this.genericNameRemove.setFont(new Font("Segoe UI", 0, 14));
/* 3378 */     this.genericNameRemove.setEnabled(false);
/*      */     
/* 3380 */     this.jLabel86.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3381 */     this.jLabel86.setText("N. Genérico");
/*      */     
/* 3383 */     this.jLabel87.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3384 */     this.jLabel87.setText("N. Comercial");
/*      */     
/* 3386 */     this.comercialNameRemove.setFont(new Font("Segoe UI", 0, 14));
/* 3387 */     this.comercialNameRemove.setEnabled(false);
/*      */     
/* 3389 */     this.batchNrRemove.setFont(new Font("Segoe UI", 0, 14));
/* 3390 */     this.batchNrRemove.setEnabled(false);
/*      */     
/* 3392 */     this.jLabel88.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3393 */     this.jLabel88.setText("Batch N°");
/*      */     
/* 3395 */     this.jLabel89.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3396 */     this.jLabel89.setText("Catgoria");
/*      */     
/* 3398 */     this.qtyRemove.setFont(new Font("Segoe UI", 0, 14));
/* 3399 */     this.qtyRemove.setEnabled(false);
/* 3400 */     this.qtyRemove.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3402 */             mainWindow.this.qtyRemoveKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3406 */     this.jLabel90.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3407 */     this.jLabel90.setText("Quantidade");
/*      */     
/* 3409 */     this.jLabel91.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3410 */     this.jLabel91.setText("Unidade");
/*      */     
/* 3412 */     this.unitRemove.setFont(new Font("Segoe UI", 0, 14));
/* 3413 */     this.unitRemove.setEnabled(false);
/*      */     
/* 3415 */     this.manufacturerRemove.setFont(new Font("Segoe UI", 0, 14));
/* 3416 */     this.manufacturerRemove.setEnabled(false);
/*      */     
/* 3418 */     this.jLabel92.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3419 */     this.jLabel92.setText("Fabricante");
/*      */     
/* 3421 */     this.jLabel93.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3422 */     this.jLabel93.setText("Fornecedor");
/*      */     
/* 3424 */     this.supplierRemove.setFont(new Font("Segoe UI", 0, 14));
/* 3425 */     this.supplierRemove.setEnabled(false);
/*      */     
/* 3427 */     this.jLabel94.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3428 */     this.jLabel94.setText("Data de Entrada");
/*      */     
/* 3430 */     this.jLabel95.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3431 */     this.jLabel95.setText("Data de Validade");
/*      */     
/* 3433 */     this.sellPriceRemove.setFont(new Font("Segoe UI", 0, 14));
/* 3434 */     this.sellPriceRemove.setEnabled(false);
/* 3435 */     this.sellPriceRemove.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3437 */             mainWindow.this.sellPriceRemoveKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3441 */     this.jLabel96.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3442 */     this.jLabel96.setText("Preço de Venda");
/*      */     
/* 3444 */     this.expireDateRemove.setDateFormatString("yyyy-MM-dd");
/* 3445 */     this.expireDateRemove.setEnabled(false);
/*      */     
/* 3447 */     this.entryDateRemove.setDateFormatString("yyyy-MM-dd");
/* 3448 */     this.entryDateRemove.setEnabled(false);
/*      */     
/* 3450 */     this.categoryRemove.setFont(new Font("Segoe UI", 0, 14));
/* 3451 */     this.categoryRemove.setModel(new DefaultComboBoxModel<>(new String[] { "pós", "granulados", "comprimidos", "drágeas", "cápsulas", "supositórios", "óvulos", "soluções", "xaropes", "elixires", "suspensões", "emulsões", "injetáveis", "tinturas", "extratos" }));
/* 3452 */     this.categoryRemove.setEnabled(false);
/* 3453 */     this.categoryRemove.setPreferredSize(new Dimension(6, 20));
/*      */     
/* 3455 */     this.jLabel97.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3456 */     this.jLabel97.setText("Preço de Compra");
/*      */     
/* 3458 */     this.buyPriceRemove.setFont(new Font("Segoe UI", 0, 14));
/* 3459 */     this.buyPriceRemove.setEnabled(false);
/* 3460 */     this.buyPriceRemove.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3462 */             mainWindow.this.buyPriceRemoveKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3466 */     this.jLabel24.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3467 */     this.jLabel24.setText("N. Comercial");
/*      */     
/* 3469 */     this.jLabel25.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3470 */     this.jLabel25.setText("Código de Barras");
/*      */     
/* 3472 */     this.nComercialRemove.setFont(new Font("Segoe UI", 0, 14));
/* 3473 */     this.nComercialRemove.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3475 */             mainWindow.this.nComercialRemoveActionPerformed(evt);
/*      */           }
/*      */         });
/* 3478 */     this.nComercialRemove.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3480 */             mainWindow.this.nComercialRemoveKeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 3483 */             mainWindow.this.nComercialRemoveKeyReleased(evt);
/*      */           }
/*      */           public void keyTyped(KeyEvent evt) {
/* 3486 */             mainWindow.this.nComercialRemoveKeyTyped(evt);
/*      */           }
/*      */         });
/*      */     
/* 3490 */     this.barCodeSearch.setFont(new Font("Segoe UI", 0, 14));
/* 3491 */     this.barCodeSearch.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3493 */             mainWindow.this.barCodeSearchKeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 3496 */             mainWindow.this.barCodeSearchKeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 3500 */     this.jButton21.setBackground(new Color(0, 153, 153));
/* 3501 */     this.jButton21.setFont(new Font("Segoe UI", 1, 14));
/* 3502 */     this.jButton21.setForeground(new Color(255, 255, 255));
/* 3503 */     this.jButton21.setText("SELECIONAR");
/* 3504 */     this.jButton21.setCursor(new Cursor(12));
/* 3505 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3507 */             mainWindow.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3511 */     this.jButton24.setBackground(new Color(0, 153, 153));
/* 3512 */     this.jButton24.setFont(new Font("Segoe UI", 1, 14));
/* 3513 */     this.jButton24.setForeground(new Color(255, 255, 255));
/* 3514 */     this.jButton24.setText("REMOVER");
/* 3515 */     this.jButton24.setCursor(new Cursor(12));
/* 3516 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3518 */             mainWindow.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3522 */     GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
/* 3523 */     this.jPanel33.setLayout(jPanel33Layout);
/* 3524 */     jPanel33Layout.setHorizontalGroup(jPanel33Layout
/* 3525 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3526 */         .addGroup(jPanel33Layout.createSequentialGroup()
/* 3527 */           .addGap(56, 56, 56)
/* 3528 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3529 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 3530 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3531 */                 .addComponent(this.jLabel24, -2, 93, -2)
/* 3532 */                 .addComponent(this.jLabel25, -2, 113, -2))
/* 3533 */               .addGap(34, 34, 34)
/* 3534 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3535 */                 .addComponent(this.barCodeSearch, -1, 210, 32767)
/* 3536 */                 .addComponent(this.nComercialRemove))
/* 3537 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3538 */               .addComponent(this.jButton21)
/* 3539 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 3540 */               .addComponent(this.jButton24))
/* 3541 */             .addComponent(this.jSeparator4, GroupLayout.Alignment.TRAILING)
/* 3542 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 3543 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3544 */                 .addComponent(this.jLabel85, -1, 137, 32767)
/* 3545 */                 .addComponent(this.jLabel86, -1, -1, 32767))
/* 3546 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3547 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3548 */                 .addComponent(this.barCodeRemove)
/* 3549 */                 .addComponent(this.genericNameRemove, -2, 209, -2))
/* 3550 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 116, 32767)
/* 3551 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3552 */                 .addComponent(this.jLabel91, -1, -1, 32767)
/* 3553 */                 .addComponent(this.jLabel92, -1, 137, 32767))
/* 3554 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3555 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3556 */                 .addComponent(this.unitRemove)
/* 3557 */                 .addComponent(this.manufacturerRemove, -2, 209, -2)))
/* 3558 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 3559 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3560 */                 .addComponent(this.jLabel87, -1, 137, 32767)
/* 3561 */                 .addComponent(this.jLabel88, -1, -1, 32767))
/* 3562 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3563 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3564 */                 .addComponent(this.comercialNameRemove)
/* 3565 */                 .addComponent(this.batchNrRemove, -2, 209, -2))
/* 3566 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 3567 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3568 */                 .addComponent(this.jLabel93, -1, -1, 32767)
/* 3569 */                 .addComponent(this.jLabel94, -1, 137, 32767))
/* 3570 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3571 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3572 */                 .addComponent(this.supplierRemove)
/* 3573 */                 .addComponent((Component)this.entryDateRemove, -1, 209, 32767)))
/* 3574 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
/* 3575 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3576 */                 .addComponent(this.jLabel89, -1, -1, 32767)
/* 3577 */                 .addComponent(this.jLabel90, -1, 137, 32767))
/* 3578 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3579 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3580 */                 .addComponent(this.qtyRemove, -1, 209, 32767)
/* 3581 */                 .addComponent(this.categoryRemove, 0, -1, 32767))
/* 3582 */               .addGap(18, 18, 32767)
/* 3583 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3584 */                 .addComponent(this.jLabel97, -1, 137, 32767)
/* 3585 */                 .addComponent(this.jLabel95, -1, 137, 32767)
/* 3586 */                 .addComponent(this.jLabel96, -1, -1, 32767))
/* 3587 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3588 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3589 */                 .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 3590 */                   .addComponent(this.sellPriceRemove, -2, 209, -2)
/* 3591 */                   .addComponent((Component)this.expireDateRemove, -2, 209, -2))
/* 3592 */                 .addComponent(this.buyPriceRemove, GroupLayout.Alignment.TRAILING, -2, 209, -2))))
/* 3593 */           .addGap(56, 56, 56)));
/*      */     
/* 3595 */     jPanel33Layout.setVerticalGroup(jPanel33Layout
/* 3596 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3597 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
/* 3598 */           .addGap(15, 15, 15)
/* 3599 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3600 */             .addComponent(this.jLabel24)
/* 3601 */             .addComponent(this.nComercialRemove, -2, -1, -2))
/* 3602 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 3603 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3604 */             .addComponent(this.jLabel25)
/* 3605 */             .addComponent(this.barCodeSearch, -2, -1, -2)
/* 3606 */             .addComponent(this.jButton21)
/* 3607 */             .addComponent(this.jButton24))
/* 3608 */           .addGap(0, 0, 32767)
/* 3609 */           .addComponent(this.jSeparator4, -2, 10, -2)
/* 3610 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3611 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3612 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 3613 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3614 */                 .addComponent(this.jLabel85, -2, 31, -2)
/* 3615 */                 .addComponent(this.barCodeRemove, -2, 31, -2))
/* 3616 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3617 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3618 */                 .addComponent(this.jLabel86, -2, 31, -2)
/* 3619 */                 .addComponent(this.genericNameRemove, -2, 31, -2)))
/* 3620 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 3621 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3622 */                 .addComponent(this.jLabel91, -2, 31, -2)
/* 3623 */                 .addComponent(this.unitRemove, -2, 31, -2))
/* 3624 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3625 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3626 */                 .addComponent(this.jLabel92, -2, 31, -2)
/* 3627 */                 .addComponent(this.manufacturerRemove, -2, 31, -2))))
/* 3628 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3629 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3630 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 3631 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3632 */                 .addComponent(this.jLabel87, -2, 31, -2)
/* 3633 */                 .addComponent(this.comercialNameRemove, -2, 31, -2))
/* 3634 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3635 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3636 */                 .addComponent(this.jLabel88, -2, 31, -2)
/* 3637 */                 .addComponent(this.batchNrRemove, -2, 31, -2)))
/* 3638 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 3639 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3640 */                 .addComponent(this.jLabel93, -2, 31, -2)
/* 3641 */                 .addComponent(this.supplierRemove, -2, 31, -2))
/* 3642 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3643 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3644 */                 .addComponent((Component)this.entryDateRemove, -2, 33, -2)
/* 3645 */                 .addComponent(this.jLabel94, -2, 31, -2))))
/* 3646 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3647 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3648 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 3649 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3650 */                 .addComponent(this.jLabel89, -2, 31, -2)
/* 3651 */                 .addComponent(this.categoryRemove, -2, 31, -2))
/* 3652 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3653 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3654 */                 .addComponent(this.jLabel90, -2, 31, -2)
/* 3655 */                 .addComponent(this.qtyRemove, -2, 31, -2)))
/* 3656 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 3657 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3658 */                 .addComponent((Component)this.expireDateRemove, GroupLayout.Alignment.TRAILING, -2, 33, -2)
/* 3659 */                 .addComponent(this.jLabel95, -2, 31, -2))
/* 3660 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3661 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3662 */                 .addComponent(this.jLabel96, -2, 31, -2)
/* 3663 */                 .addComponent(this.sellPriceRemove, -2, 31, -2))))
/* 3664 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3665 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3666 */             .addComponent(this.jLabel97, -2, 31, -2)
/* 3667 */             .addComponent(this.buyPriceRemove, -2, 31, -2))
/* 3668 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3671 */     this.jPanel22.add(this.jPanel33, "modificarStockRemover");
/*      */     
/* 3673 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/* 3674 */     this.jPanel24.setLayout(jPanel24Layout);
/* 3675 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/* 3676 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3677 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
/* 3678 */           .addGap(30, 30, 30)
/* 3679 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 3680 */             .addComponent(this.jPanel26, -1, -1, 32767)
/* 3681 */             .addComponent(this.jPanel25, -1, -1, 32767))
/* 3682 */           .addGap(30, 30, 30))
/* 3683 */         .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3684 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
/* 3685 */             .addContainerGap(180, 32767)
/* 3686 */             .addComponent(this.jPanel22, -2, 944, -2)
/* 3687 */             .addContainerGap(180, 32767))));
/*      */     
/* 3689 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/* 3690 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3691 */         .addGroup(jPanel24Layout.createSequentialGroup()
/* 3692 */           .addContainerGap(-1, 32767)
/* 3693 */           .addComponent(this.jPanel25, -2, -1, -2)
/* 3694 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3695 */           .addComponent(this.jPanel26, -2, -1, -2)
/* 3696 */           .addGap(437, 437, 437))
/* 3697 */         .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3698 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
/* 3699 */             .addContainerGap(180, 32767)
/* 3700 */             .addComponent(this.jPanel22, -2, 379, -2)
/* 3701 */             .addContainerGap(39, 32767))));
/*      */ 
/*      */     
/* 3704 */     this.jPanel14.add(this.jPanel24, "modificarStock");
/*      */     
/* 3706 */     this.jLabel26.setFont(new Font("Segoe UI", 1, 18));
/* 3707 */     this.jLabel26.setForeground(new Color(102, 102, 102));
/* 3708 */     this.jLabel26.setHorizontalAlignment(0);
/* 3709 */     this.jLabel26.setText("INVENTÓRIO DO STOCK");
/*      */     
/* 3711 */     GroupLayout jPanel35Layout = new GroupLayout(this.jPanel35);
/* 3712 */     this.jPanel35.setLayout(jPanel35Layout);
/* 3713 */     jPanel35Layout.setHorizontalGroup(jPanel35Layout
/* 3714 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3715 */         .addComponent(this.jLabel26, -1, -1, 32767));
/*      */     
/* 3717 */     jPanel35Layout.setVerticalGroup(jPanel35Layout
/* 3718 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3719 */         .addComponent(this.jLabel26, -1, 38, 32767));
/*      */ 
/*      */     
/* 3722 */     this.jPanel36.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 3724 */     this.jLabel27.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3725 */     this.jLabel27.setText("Nome Comercial");
/*      */     
/* 3727 */     this.stockNameSearch.setFont(new Font("Segoe UI", 0, 14));
/* 3728 */     this.stockNameSearch.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3730 */             mainWindow.this.stockNameSearchKeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 3733 */             mainWindow.this.stockNameSearchKeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 3737 */     this.stockBarCodeSearch.setFont(new Font("Segoe UI", 0, 14));
/* 3738 */     this.stockBarCodeSearch.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 3740 */             mainWindow.this.stockBarCodeSearchKeyPressed(evt);
/*      */           }
/*      */           public void keyReleased(KeyEvent evt) {
/* 3743 */             mainWindow.this.stockBarCodeSearchKeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 3747 */     this.jLabel28.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3748 */     this.jLabel28.setText("Código de Barras");
/*      */     
/* 3750 */     this.totalInSTockMoney.setEditable(false);
/* 3751 */     this.totalInSTockMoney.setBackground(new Color(211, 80, 48));
/* 3752 */     this.totalInSTockMoney.setFont(new Font("Segoe UI Black", 1, 18));
/* 3753 */     this.totalInSTockMoney.setForeground(new Color(255, 255, 255));
/* 3754 */     this.totalInSTockMoney.setHorizontalAlignment(0);
/* 3755 */     this.totalInSTockMoney.setFocusable(false);
/*      */     
/* 3757 */     this.jButton17.setBackground(new Color(0, 153, 153));
/* 3758 */     this.jButton17.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3759 */     this.jButton17.setForeground(new Color(255, 255, 255));
/* 3760 */     this.jButton17.setText("BUSCAR");
/* 3761 */     this.jButton17.setCursor(new Cursor(12));
/* 3762 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3764 */             mainWindow.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3768 */     this.jButton20.setBackground(new Color(0, 153, 153));
/* 3769 */     this.jButton20.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3770 */     this.jButton20.setForeground(new Color(255, 255, 255));
/* 3771 */     this.jButton20.setText("TODOS");
/* 3772 */     this.jButton20.setCursor(new Cursor(12));
/* 3773 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3775 */             mainWindow.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3779 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/* 3780 */     this.jPanel36.setLayout(jPanel36Layout);
/* 3781 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/* 3782 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3783 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 3784 */           .addContainerGap()
/* 3785 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 3786 */             .addComponent(this.jLabel28, GroupLayout.Alignment.LEADING, -1, 176, 32767)
/* 3787 */             .addComponent(this.jLabel27, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 3788 */           .addGap(18, 18, 18)
/* 3789 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3790 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
/* 3791 */               .addComponent(this.jButton20, -2, 133, -2)
/* 3792 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3793 */               .addComponent(this.jButton17, -2, 132, -2))
/* 3794 */             .addComponent(this.stockNameSearch)
/* 3795 */             .addComponent(this.stockBarCodeSearch))
/* 3796 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 3797 */           .addComponent(this.totalInSTockMoney, -2, 199, -2)
/* 3798 */           .addContainerGap()));
/*      */     
/* 3800 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/* 3801 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3802 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 3803 */           .addContainerGap()
/* 3804 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3805 */             .addComponent(this.totalInSTockMoney, -2, 46, -2)
/* 3806 */             .addGroup(jPanel36Layout.createSequentialGroup()
/* 3807 */               .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3808 */                 .addComponent(this.jLabel27, -2, 31, -2)
/* 3809 */                 .addComponent(this.stockNameSearch, -2, 31, -2))
/* 3810 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3811 */               .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3812 */                 .addComponent(this.jLabel28, -2, 31, -2)
/* 3813 */                 .addComponent(this.stockBarCodeSearch, -2, 31, -2))))
/* 3814 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 3815 */           .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3816 */             .addComponent(this.jButton17, -1, 30, 32767)
/* 3817 */             .addComponent(this.jButton20, -1, -1, 32767))
/* 3818 */           .addGap(12, 12, 12)));
/*      */ 
/*      */     
/* 3821 */     this.stockTable.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 3822 */     this.stockTable.setModel(new DefaultTableModel(new Object[][] { 
    { null, null, null, null, null, null, null, null, null, null, null, null, 
        null }, { null, null, null, null, null, null, null, null, null, null, 
            null, null, null }, { null, null, null, null, null, null, null, null,
                null, null, null, null, null }, { null, null, null, null, null, 
                    null, null, null, null, null, null, null, null },  }, 
        (Object[])new String[] { "Item", "C. de Barras", "Batch Nr", "N. Genérico", 
            "N. Comercial", "Categoria", "Quantidade", "Pr. de Venda", 
            "Pr. de Compra", "Fornecedor", "Fabricante", "D. de Entrada", 
            "D. de Validade" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 3833 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3838 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 3841 */     this.stockTable.setIntercellSpacing(new Dimension(2, 2));
/* 3842 */     this.jScrollPane13.setViewportView(this.stockTable);
/* 3843 */     if (this.stockTable.getColumnModel().getColumnCount() > 0) {
/* 3844 */       this.stockTable.getColumnModel().getColumn(6).setResizable(false);
/* 3845 */       this.stockTable.getColumnModel().getColumn(12).setResizable(false);
/*      */     } 
/*      */     
/* 3848 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/* 3849 */     this.jPanel16.setLayout(jPanel16Layout);
/* 3850 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/* 3851 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3852 */         .addGroup(jPanel16Layout.createSequentialGroup()
/* 3853 */           .addComponent(this.jScrollPane13, -2, 1293, -2)
/* 3854 */           .addGap(0, 0, 32767)));
/*      */     
/* 3856 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/* 3857 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3858 */         .addComponent(this.jScrollPane13, -1, 372, 32767));
/*      */ 
/*      */     
/* 3861 */     this.jScrollPane6.setViewportView(this.jPanel16);
/*      */     
/* 3863 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/* 3864 */     this.jPanel34.setLayout(jPanel34Layout);
/* 3865 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/* 3866 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3867 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
/* 3868 */           .addGap(30, 30, 30)
/* 3869 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 3870 */             .addComponent(this.jPanel36, -1, -1, 32767)
/* 3871 */             .addComponent(this.jPanel35, -1, -1, 32767)
/* 3872 */             .addComponent(this.jScrollPane6, GroupLayout.Alignment.LEADING, -1, 1244, 32767))
/* 3873 */           .addGap(30, 30, 30)));
/*      */     
/* 3875 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/* 3876 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3877 */         .addGroup(jPanel34Layout.createSequentialGroup()
/* 3878 */           .addContainerGap(-1, 32767)
/* 3879 */           .addComponent(this.jPanel35, -2, -1, -2)
/* 3880 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3881 */           .addComponent(this.jPanel36, -2, -1, -2)
/* 3882 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3883 */           .addComponent(this.jScrollPane6, -1, 389, 32767)
/* 3884 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3887 */     this.jPanel14.add(this.jPanel34, "inventorioDoStock");
/*      */     
/* 3889 */     this.jLabel29.setFont(new Font("Segoe UI", 1, 18));
/* 3890 */     this.jLabel29.setForeground(new Color(102, 102, 102));
/* 3891 */     this.jLabel29.setHorizontalAlignment(0);
/* 3892 */     this.jLabel29.setText("MODIFICAR FUNCIONÁRIO");
/*      */     
/* 3894 */     GroupLayout jPanel38Layout = new GroupLayout(this.jPanel38);
/* 3895 */     this.jPanel38.setLayout(jPanel38Layout);
/* 3896 */     jPanel38Layout.setHorizontalGroup(jPanel38Layout
/* 3897 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3898 */         .addComponent(this.jLabel29, -1, 1244, 32767));
/*      */     
/* 3900 */     jPanel38Layout.setVerticalGroup(jPanel38Layout
/* 3901 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3902 */         .addComponent(this.jLabel29, -1, 38, 32767));
/*      */ 
/*      */     
/* 3905 */     this.jPanel39.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 3907 */     this.jPanel40.setBackground(new Color(211, 80, 48));
/*      */     
/* 3909 */     this.jLabel13.setBackground(new Color(211, 80, 48));
/* 3910 */     this.jLabel13.setFont(new Font("Segoe UI", 1, 14));
/* 3911 */     this.jLabel13.setForeground(new Color(255, 255, 255));
/* 3912 */     this.jLabel13.setHorizontalAlignment(0);
/* 3913 */     this.jLabel13.setText("ADICIONAR");
/* 3914 */     this.jLabel13.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3916 */             mainWindow.this.jLabel13MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 3919 */             mainWindow.this.jLabel13MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 3923 */     GroupLayout jPanel40Layout = new GroupLayout(this.jPanel40);
/* 3924 */     this.jPanel40.setLayout(jPanel40Layout);
/* 3925 */     jPanel40Layout.setHorizontalGroup(jPanel40Layout
/* 3926 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3927 */         .addComponent(this.jLabel13, -1, 181, 32767));
/*      */     
/* 3929 */     jPanel40Layout.setVerticalGroup(jPanel40Layout
/* 3930 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3931 */         .addComponent(this.jLabel13, -1, 34, 32767));
/*      */ 
/*      */     
/* 3934 */     this.jPanel41.setBackground(new Color(0, 153, 153));
/*      */     
/* 3936 */     this.jLabel30.setFont(new Font("Segoe UI", 1, 14));
/* 3937 */     this.jLabel30.setForeground(new Color(255, 255, 255));
/* 3938 */     this.jLabel30.setHorizontalAlignment(0);
/* 3939 */     this.jLabel30.setText("EDITAR");
/* 3940 */     this.jLabel30.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3942 */             mainWindow.this.jLabel30MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 3945 */             mainWindow.this.jLabel30MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 3949 */     GroupLayout jPanel41Layout = new GroupLayout(this.jPanel41);
/* 3950 */     this.jPanel41.setLayout(jPanel41Layout);
/* 3951 */     jPanel41Layout.setHorizontalGroup(jPanel41Layout
/* 3952 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3953 */         .addComponent(this.jLabel30, -1, 181, 32767));
/*      */     
/* 3955 */     jPanel41Layout.setVerticalGroup(jPanel41Layout
/* 3956 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3957 */         .addComponent(this.jLabel30, -1, -1, 32767));
/*      */ 
/*      */     
/* 3960 */     this.jPanel42.setBackground(new Color(0, 153, 153));
/*      */     
/* 3962 */     this.jLabel31.setFont(new Font("Segoe UI", 1, 14));
/* 3963 */     this.jLabel31.setForeground(new Color(255, 255, 255));
/* 3964 */     this.jLabel31.setHorizontalAlignment(0);
/* 3965 */     this.jLabel31.setText("REMOVER");
/* 3966 */     this.jLabel31.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3968 */             mainWindow.this.jLabel31MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 3971 */             mainWindow.this.jLabel31MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 3975 */     GroupLayout jPanel42Layout = new GroupLayout(this.jPanel42);
/* 3976 */     this.jPanel42.setLayout(jPanel42Layout);
/* 3977 */     jPanel42Layout.setHorizontalGroup(jPanel42Layout
/* 3978 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3979 */         .addComponent(this.jLabel31, -1, 181, 32767));
/*      */     
/* 3981 */     jPanel42Layout.setVerticalGroup(jPanel42Layout
/* 3982 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3983 */         .addComponent(this.jLabel31, -1, -1, 32767));
/*      */ 
/*      */     
/* 3986 */     GroupLayout jPanel39Layout = new GroupLayout(this.jPanel39);
/* 3987 */     this.jPanel39.setLayout(jPanel39Layout);
/* 3988 */     jPanel39Layout.setHorizontalGroup(jPanel39Layout
/* 3989 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3990 */         .addGroup(jPanel39Layout.createSequentialGroup()
/* 3991 */           .addContainerGap(-1, 32767)
/* 3992 */           .addComponent(this.jPanel40, -2, -1, -2)
/* 3993 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3994 */           .addComponent(this.jPanel41, -2, -1, -2)
/* 3995 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3996 */           .addComponent(this.jPanel42, -2, -1, -2)
/* 3997 */           .addContainerGap(-1, 32767)));
/*      */     
/* 3999 */     jPanel39Layout.setVerticalGroup(jPanel39Layout
/* 4000 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4001 */         .addGroup(jPanel39Layout.createSequentialGroup()
/* 4002 */           .addGap(35, 35, 35)
/* 4003 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4004 */             .addComponent(this.jPanel40, -1, -1, 32767)
/* 4005 */             .addComponent(this.jPanel41, -1, -1, 32767)
/* 4006 */             .addComponent(this.jPanel42, -1, -1, 32767))
/* 4007 */           .addContainerGap(31, 32767)));
/*      */ 
/*      */     
/* 4010 */     this.jPanel43.setPreferredSize(new Dimension(579, 104));
/* 4011 */     this.jPanel43.setLayout(new CardLayout());
/*      */     
/* 4013 */     this.jPanel44.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 4015 */     this.jLabel98.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4016 */     this.jLabel98.setText("Nome");
/*      */     
/* 4018 */     this.name.setFont(new Font("Segoe UI", 0, 14));
/* 4019 */     this.name.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4021 */             mainWindow.this.nameKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4025 */     this.jLabel99.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4026 */     this.jLabel99.setText("Idade");
/*      */     
/* 4028 */     this.jLabel100.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4029 */     this.jLabel100.setText("Sexo");
/*      */     
/* 4031 */     this.salary.setFont(new Font("Segoe UI", 0, 14));
/* 4032 */     this.salary.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4034 */             mainWindow.this.salaryKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4038 */     this.jLabel101.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4039 */     this.jLabel101.setText("Salário");
/*      */     
/* 4041 */     this.jLabel104.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4042 */     this.jLabel104.setText("Estado Civil");
/*      */     
/* 4044 */     this.address.setFont(new Font("Segoe UI", 0, 14));
/* 4045 */     this.address.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4047 */             mainWindow.this.addressKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4051 */     this.jLabel105.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4052 */     this.jLabel105.setText("Endereço");
/*      */     
/* 4054 */     this.jLabel106.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4055 */     this.jLabel106.setText("Telefone");
/*      */     
/* 4057 */     this.telephone.setFont(new Font("Segoe UI", 0, 14));
/* 4058 */     this.telephone.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4060 */             mainWindow.this.telephoneKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4064 */     this.jLabel107.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4065 */     this.jLabel107.setText("Formação");
/*      */     
/* 4067 */     this.academic.setFont(new Font("Segoe UI", 0, 14));
/* 4068 */     this.academic.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4070 */             mainWindow.this.academicKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4074 */     this.age.setDateFormatString("yyyy-MM-dd");
/* 4075 */     this.age.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4077 */             mainWindow.this.ageKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4081 */     this.gender.setFont(new Font("Segoe UI", 0, 14));
/* 4082 */     this.gender.setModel(new DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Outro" }));
/* 4083 */     this.gender.setPreferredSize(new Dimension(6, 20));
/* 4084 */     this.gender.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4086 */             mainWindow.this.genderKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4090 */     this.jButton25.setBackground(new Color(0, 153, 153));
/* 4091 */     this.jButton25.setFont(new Font("Segoe UI", 1, 14));
/* 4092 */     this.jButton25.setForeground(new Color(255, 255, 255));
/* 4093 */     this.jButton25.setText("SALVAR");
/* 4094 */     this.jButton25.setCursor(new Cursor(12));
/* 4095 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4097 */             mainWindow.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4101 */     this.jButton26.setBackground(new Color(0, 153, 153));
/* 4102 */     this.jButton26.setFont(new Font("Segoe UI", 1, 14));
/* 4103 */     this.jButton26.setForeground(new Color(255, 255, 255));
/* 4104 */     this.jButton26.setText("CANCELAR");
/* 4105 */     this.jButton26.setCursor(new Cursor(12));
/* 4106 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4108 */             mainWindow.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4112 */     this.marital_status.setFont(new Font("Segoe UI", 0, 14));
/* 4113 */     this.marital_status.setModel(new DefaultComboBoxModel<>(new String[] { "Casado(a)", "Solteiro(a)" }));
/* 4114 */     this.marital_status.setPreferredSize(new Dimension(6, 20));
/* 4115 */     this.marital_status.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4117 */             mainWindow.this.marital_statusKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4121 */     GroupLayout jPanel44Layout = new GroupLayout(this.jPanel44);
/* 4122 */     this.jPanel44.setLayout(jPanel44Layout);
/* 4123 */     jPanel44Layout.setHorizontalGroup(jPanel44Layout
/* 4124 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4125 */         .addGroup(jPanel44Layout.createSequentialGroup()
/* 4126 */           .addContainerGap(-1, 32767)
/* 4127 */           .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4128 */             .addGroup(jPanel44Layout.createSequentialGroup()
/* 4129 */               .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4130 */                 .addComponent(this.jLabel98, -1, 137, 32767)
/* 4131 */                 .addComponent(this.jLabel99, -1, -1, 32767))
/* 4132 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4133 */               .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4134 */                 .addComponent(this.name, -2, 209, -2)
/* 4135 */                 .addComponent((Component)this.age, -2, 209, -2))
/* 4136 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 4137 */               .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4138 */                 .addComponent(this.jLabel104, -1, -1, 32767)
/* 4139 */                 .addComponent(this.jLabel105, -1, 137, 32767))
/* 4140 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4141 */               .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4142 */                 .addComponent(this.address, -2, 209, -2)
/* 4143 */                 .addComponent(this.marital_status, -2, 209, -2)))
/* 4144 */             .addGroup(jPanel44Layout.createSequentialGroup()
/* 4145 */               .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4146 */                 .addComponent(this.jLabel100, -1, 137, 32767)
/* 4147 */                 .addComponent(this.jLabel101, -1, -1, 32767))
/* 4148 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4149 */               .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4150 */                 .addComponent(this.salary, -2, 209, -2)
/* 4151 */                 .addComponent(this.gender, -2, 209, -2))
/* 4152 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 4153 */               .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4154 */                 .addComponent(this.jLabel106, -1, -1, 32767)
/* 4155 */                 .addComponent(this.jLabel107, -1, 137, 32767))
/* 4156 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4157 */               .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4158 */                 .addComponent(this.telephone, -2, 209, -2)
/* 4159 */                 .addComponent(this.academic, -2, 209, -2)
/* 4160 */                 .addGroup(jPanel44Layout.createSequentialGroup()
/* 4161 */                   .addComponent(this.jButton26)
/* 4162 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4163 */                   .addComponent(this.jButton25, -2, 98, -2)))))
/* 4164 */           .addContainerGap(-1, 32767)));
/*      */     
/* 4166 */     jPanel44Layout.setVerticalGroup(jPanel44Layout
/* 4167 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4168 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
/* 4169 */           .addContainerGap(-1, 32767)
/* 4170 */           .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4171 */             .addGroup(jPanel44Layout.createSequentialGroup()
/* 4172 */               .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4173 */                 .addComponent(this.jLabel98, -2, 31, -2)
/* 4174 */                 .addComponent(this.name, -2, 31, -2))
/* 4175 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4176 */               .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4177 */                 .addComponent(this.jLabel99, -2, 31, -2)
/* 4178 */                 .addComponent((Component)this.age, -2, 33, -2)))
/* 4179 */             .addGroup(jPanel44Layout.createSequentialGroup()
/* 4180 */               .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4181 */                 .addComponent(this.jLabel104, -2, 31, -2)
/* 4182 */                 .addComponent(this.marital_status, -2, 31, -2))
/* 4183 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4184 */               .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4185 */                 .addComponent(this.jLabel105, -2, 31, -2)
/* 4186 */                 .addComponent(this.address, -2, 31, -2))))
/* 4187 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4188 */           .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4189 */             .addGroup(jPanel44Layout.createSequentialGroup()
/* 4190 */               .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4191 */                 .addComponent(this.jLabel100, -2, 31, -2)
/* 4192 */                 .addComponent(this.gender, -2, 31, -2))
/* 4193 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4194 */               .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4195 */                 .addComponent(this.jLabel101, -2, 31, -2)
/* 4196 */                 .addComponent(this.salary, -2, 31, -2)))
/* 4197 */             .addGroup(jPanel44Layout.createSequentialGroup()
/* 4198 */               .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4199 */                 .addComponent(this.jLabel106, -2, 31, -2)
/* 4200 */                 .addComponent(this.telephone, -2, 31, -2))
/* 4201 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4202 */               .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4203 */                 .addComponent(this.jLabel107, -2, 31, -2)
/* 4204 */                 .addComponent(this.academic, -2, 31, -2))))
/* 4205 */           .addGap(60, 60, 60)
/* 4206 */           .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4207 */             .addComponent(this.jButton25, -2, 34, -2)
/* 4208 */             .addComponent(this.jButton26, -2, 34, -2))
/* 4209 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 4212 */     this.jPanel43.add(this.jPanel44, "modificarFuncionarioAdicionar");
/*      */     
/* 4214 */     this.jPanel45.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 4216 */     this.staffComboEdit.setPreferredSize(new Dimension(6, 20));
/*      */     
/* 4218 */     this.jLabel33.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4219 */     this.jLabel33.setText("Nome");
/*      */     
/* 4221 */     this.jButton27.setBackground(new Color(0, 153, 153));
/* 4222 */     this.jButton27.setFont(new Font("Segoe UI", 1, 14));
/* 4223 */     this.jButton27.setForeground(new Color(255, 255, 255));
/* 4224 */     this.jButton27.setText("SELECIONAR");
/* 4225 */     this.jButton27.setCursor(new Cursor(12));
/* 4226 */     this.jButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4228 */             mainWindow.this.jButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4232 */     this.jButton28.setBackground(new Color(0, 153, 153));
/* 4233 */     this.jButton28.setFont(new Font("Segoe UI", 1, 14));
/* 4234 */     this.jButton28.setForeground(new Color(255, 255, 255));
/* 4235 */     this.jButton28.setText("SALVAR");
/* 4236 */     this.jButton28.setCursor(new Cursor(12));
/* 4237 */     this.jButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4239 */             mainWindow.this.jButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4243 */     this.jButton29.setBackground(new Color(0, 153, 153));
/* 4244 */     this.jButton29.setFont(new Font("Segoe UI", 1, 14));
/* 4245 */     this.jButton29.setForeground(new Color(255, 255, 255));
/* 4246 */     this.jButton29.setText("CANCELAR");
/* 4247 */     this.jButton29.setCursor(new Cursor(12));
/* 4248 */     this.jButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4250 */             mainWindow.this.jButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4254 */     this.jLabel102.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4255 */     this.jLabel102.setText("Nome");
/*      */     
/* 4257 */     this.nameEdit.setFont(new Font("Segoe UI", 0, 14));
/* 4258 */     this.nameEdit.setEnabled(false);
/* 4259 */     this.nameEdit.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4261 */             mainWindow.this.nameEditActionPerformed(evt);
/*      */           }
/*      */         });
/* 4264 */     this.nameEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4266 */             mainWindow.this.nameEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4270 */     this.ageEdit.setDateFormatString("yyyy-MM-dd");
/* 4271 */     this.ageEdit.setEnabled(false);
/* 4272 */     this.ageEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4274 */             mainWindow.this.ageEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4278 */     this.jLabel103.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4279 */     this.jLabel103.setText("Idade");
/*      */     
/* 4281 */     this.jLabel108.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4282 */     this.jLabel108.setText("Sexo");
/*      */     
/* 4284 */     this.genderEdit.setFont(new Font("Segoe UI", 0, 14));
/* 4285 */     this.genderEdit.setModel(new DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Outro" }));
/* 4286 */     this.genderEdit.setEnabled(false);
/* 4287 */     this.genderEdit.setPreferredSize(new Dimension(6, 20));
/* 4288 */     this.genderEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4290 */             mainWindow.this.genderEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4294 */     this.salaryEdit.setFont(new Font("Segoe UI", 0, 14));
/* 4295 */     this.salaryEdit.setEnabled(false);
/* 4296 */     this.salaryEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4298 */             mainWindow.this.salaryEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4302 */     this.jLabel109.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4303 */     this.jLabel109.setText("Salário");
/*      */     
/* 4305 */     this.academicEdit.setFont(new Font("Segoe UI", 0, 14));
/* 4306 */     this.academicEdit.setEnabled(false);
/* 4307 */     this.academicEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4309 */             mainWindow.this.academicEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4313 */     this.telephoneEdit.setFont(new Font("Segoe UI", 0, 14));
/* 4314 */     this.telephoneEdit.setEnabled(false);
/* 4315 */     this.telephoneEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4317 */             mainWindow.this.telephoneEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4321 */     this.addressEdit.setFont(new Font("Segoe UI", 0, 14));
/* 4322 */     this.addressEdit.setEnabled(false);
/* 4323 */     this.addressEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4325 */             mainWindow.this.addressEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4329 */     this.maritalStatusEdit.setFont(new Font("Segoe UI", 0, 14));
/* 4330 */     this.maritalStatusEdit.setModel(new DefaultComboBoxModel<>(new String[] { "Solteiro(a)", "Casado(a)" }));
/* 4331 */     this.maritalStatusEdit.setEnabled(false);
/* 4332 */     this.maritalStatusEdit.setPreferredSize(new Dimension(6, 20));
/* 4333 */     this.maritalStatusEdit.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4335 */             mainWindow.this.maritalStatusEditKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4339 */     this.jLabel110.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4340 */     this.jLabel110.setText("Estado Civil");
/*      */     
/* 4342 */     this.jLabel138.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4343 */     this.jLabel138.setText("Endereço");
/*      */     
/* 4345 */     this.jLabel139.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4346 */     this.jLabel139.setText("Telefone");
/*      */     
/* 4348 */     this.jLabel140.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4349 */     this.jLabel140.setText("Formação");
/*      */     
/* 4351 */     GroupLayout jPanel45Layout = new GroupLayout(this.jPanel45);
/* 4352 */     this.jPanel45.setLayout(jPanel45Layout);
/* 4353 */     jPanel45Layout.setHorizontalGroup(jPanel45Layout
/* 4354 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4355 */         .addGroup(jPanel45Layout.createSequentialGroup()
/* 4356 */           .addGap(56, 56, 56)
/* 4357 */           .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4358 */             .addGroup(jPanel45Layout.createSequentialGroup()
/* 4359 */               .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4360 */                 .addGroup(jPanel45Layout.createSequentialGroup()
/* 4361 */                   .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4362 */                     .addComponent(this.jLabel102, -1, -1, 32767)
/* 4363 */                     .addComponent(this.jLabel103, -2, 137, -2))
/* 4364 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4365 */                   .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4366 */                     .addComponent(this.nameEdit, -2, 209, -2)
/* 4367 */                     .addComponent((Component)this.ageEdit, -2, 209, -2)))
/* 4368 */                 .addGroup(jPanel45Layout.createSequentialGroup()
/* 4369 */                   .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4370 */                     .addComponent(this.jLabel108, -1, -1, 32767)
/* 4371 */                     .addComponent(this.jLabel109, -2, 137, -2))
/* 4372 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4373 */                   .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4374 */                     .addComponent(this.salaryEdit, -2, 209, -2)
/* 4375 */                     .addComponent(this.genderEdit, -2, 209, -2))))
/* 4376 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 4377 */               .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4378 */                 .addGroup(jPanel45Layout.createSequentialGroup()
/* 4379 */                   .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4380 */                     .addComponent(this.jLabel110, -1, -1, 32767)
/* 4381 */                     .addComponent(this.jLabel138, -2, 137, -2))
/* 4382 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4383 */                   .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4384 */                     .addComponent(this.addressEdit, -2, 209, -2)
/* 4385 */                     .addComponent(this.maritalStatusEdit, -2, 209, -2)))
/* 4386 */                 .addGroup(jPanel45Layout.createSequentialGroup()
/* 4387 */                   .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4388 */                     .addComponent(this.jLabel139, -1, -1, 32767)
/* 4389 */                     .addComponent(this.jLabel140, -2, 137, -2))
/* 4390 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4391 */                   .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4392 */                     .addComponent(this.telephoneEdit, -2, 209, -2)
/* 4393 */                     .addComponent(this.academicEdit, -2, 209, -2)))))
/* 4394 */             .addGroup(jPanel45Layout.createSequentialGroup()
/* 4395 */               .addComponent(this.jLabel33, -2, 113, -2)
/* 4396 */               .addGap(35, 35, 35)
/* 4397 */               .addComponent(this.staffComboEdit, -2, 211, -2)
/* 4398 */               .addGap(18, 18, 18)
/* 4399 */               .addComponent(this.jButton27)
/* 4400 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 4401 */               .addComponent(this.jButton29)
/* 4402 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4403 */               .addComponent(this.jButton28, -2, 98, -2))
/* 4404 */             .addComponent(this.jSeparator5, GroupLayout.Alignment.TRAILING))
/* 4405 */           .addGap(56, 56, 56)));
/*      */     
/* 4407 */     jPanel45Layout.setVerticalGroup(jPanel45Layout
/* 4408 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4409 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
/* 4410 */           .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4411 */             .addGroup(jPanel45Layout.createSequentialGroup()
/* 4412 */               .addGap(46, 46, 46)
/* 4413 */               .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4414 */                 .addComponent(this.jLabel33)
/* 4415 */                 .addComponent(this.staffComboEdit, -2, 31, -2))
/* 4416 */               .addGap(18, 18, 32767))
/* 4417 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
/* 4418 */               .addContainerGap(-1, 32767)
/* 4419 */               .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4420 */                 .addComponent(this.jButton27)
/* 4421 */                 .addComponent(this.jButton29)
/* 4422 */                 .addComponent(this.jButton28))
/* 4423 */               .addGap(18, 18, 18)))
/* 4424 */           .addComponent(this.jSeparator5, -2, 10, -2)
/* 4425 */           .addGap(18, 18, 18)
/* 4426 */           .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4427 */             .addGroup(jPanel45Layout.createSequentialGroup()
/* 4428 */               .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4429 */                 .addComponent(this.jLabel102, -2, 31, -2)
/* 4430 */                 .addComponent(this.nameEdit, -2, 31, -2))
/* 4431 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4432 */               .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4433 */                 .addComponent(this.jLabel103, -2, 31, -2)
/* 4434 */                 .addComponent((Component)this.ageEdit, -2, 33, -2))
/* 4435 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4436 */               .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4437 */                 .addComponent(this.jLabel108, -2, 31, -2)
/* 4438 */                 .addComponent(this.genderEdit, -2, 31, -2))
/* 4439 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4440 */               .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4441 */                 .addComponent(this.jLabel109, -2, 31, -2)
/* 4442 */                 .addComponent(this.salaryEdit, -2, 31, -2)))
/* 4443 */             .addGroup(jPanel45Layout.createSequentialGroup()
/* 4444 */               .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4445 */                 .addComponent(this.jLabel110, -2, 31, -2)
/* 4446 */                 .addComponent(this.maritalStatusEdit, -2, 31, -2))
/* 4447 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4448 */               .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4449 */                 .addComponent(this.jLabel138, -2, 31, -2)
/* 4450 */                 .addComponent(this.addressEdit, -2, 31, -2))
/* 4451 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4452 */               .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4453 */                 .addComponent(this.jLabel139, -2, 31, -2)
/* 4454 */                 .addComponent(this.telephoneEdit, -2, 31, -2))
/* 4455 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4456 */               .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4457 */                 .addComponent(this.jLabel140, -2, 31, -2)
/* 4458 */                 .addComponent(this.academicEdit, -2, 31, -2))))
/* 4459 */           .addGap(116, 116, 116)));
/*      */ 
/*      */     
/* 4462 */     this.jPanel43.add(this.jPanel45, "modificarFuncionarioEditar");
/*      */     
/* 4464 */     this.jPanel47.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 4466 */     this.comboBoxListRemove.setPreferredSize(new Dimension(6, 20));
/*      */     
/* 4468 */     this.jLabel111.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4469 */     this.jLabel111.setText("Nome");
/*      */     
/* 4471 */     this.jButton32.setBackground(new Color(0, 153, 153));
/* 4472 */     this.jButton32.setFont(new Font("Segoe UI", 1, 14));
/* 4473 */     this.jButton32.setForeground(new Color(255, 255, 255));
/* 4474 */     this.jButton32.setText("SELECIONAR");
/* 4475 */     this.jButton32.setCursor(new Cursor(12));
/* 4476 */     this.jButton32.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4478 */             mainWindow.this.jButton32ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4482 */     this.jButton33.setBackground(new Color(0, 153, 153));
/* 4483 */     this.jButton33.setFont(new Font("Segoe UI", 1, 14));
/* 4484 */     this.jButton33.setForeground(new Color(255, 255, 255));
/* 4485 */     this.jButton33.setText("REMOVER");
/* 4486 */     this.jButton33.setCursor(new Cursor(12));
/* 4487 */     this.jButton33.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4489 */             mainWindow.this.jButton33ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4493 */     this.jLabel112.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4494 */     this.jLabel112.setText("Nome");
/*      */     
/* 4496 */     this.nameRemove.setFont(new Font("Segoe UI", 0, 14));
/* 4497 */     this.nameRemove.setEnabled(false);
/*      */     
/* 4499 */     this.ageRemove.setDateFormatString("yyyy-MM-dd");
/* 4500 */     this.ageRemove.setEnabled(false);
/*      */     
/* 4502 */     this.jLabel113.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4503 */     this.jLabel113.setText("Idade");
/*      */     
/* 4505 */     this.jLabel114.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4506 */     this.jLabel114.setText("Sexo");
/*      */     
/* 4508 */     this.genderRemove.setFont(new Font("Segoe UI", 0, 14));
/* 4509 */     this.genderRemove.setModel(new DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Outro" }));
/* 4510 */     this.genderRemove.setEnabled(false);
/* 4511 */     this.genderRemove.setPreferredSize(new Dimension(6, 20));
/*      */     
/* 4513 */     this.salaryRemove.setFont(new Font("Segoe UI", 0, 14));
/* 4514 */     this.salaryRemove.setEnabled(false);
/*      */     
/* 4516 */     this.jLabel115.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4517 */     this.jLabel115.setText("Salário");
/*      */     
/* 4519 */     this.academicRemove.setFont(new Font("Segoe UI", 0, 14));
/* 4520 */     this.academicRemove.setEnabled(false);
/*      */     
/* 4522 */     this.telephoneRemove.setFont(new Font("Segoe UI", 0, 14));
/* 4523 */     this.telephoneRemove.setEnabled(false);
/*      */     
/* 4525 */     this.addressRemove.setFont(new Font("Segoe UI", 0, 14));
/* 4526 */     this.addressRemove.setEnabled(false);
/*      */     
/* 4528 */     this.marital_statusRemove.setFont(new Font("Segoe UI", 0, 14));
/* 4529 */     this.marital_statusRemove.setModel(new DefaultComboBoxModel<>(new String[] { "Solteiro(a)", "Casado(a)" }));
/* 4530 */     this.marital_statusRemove.setEnabled(false);
/* 4531 */     this.marital_statusRemove.setPreferredSize(new Dimension(6, 20));
/*      */     
/* 4533 */     this.jLabel116.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4534 */     this.jLabel116.setText("Estado Civil");
/*      */     
/* 4536 */     this.jLabel141.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4537 */     this.jLabel141.setText("Endereço");
/*      */     
/* 4539 */     this.jLabel142.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4540 */     this.jLabel142.setText("Telefone");
/*      */     
/* 4542 */     this.jLabel143.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4543 */     this.jLabel143.setText("Formação");
/*      */     
/* 4545 */     GroupLayout jPanel47Layout = new GroupLayout(this.jPanel47);
/* 4546 */     this.jPanel47.setLayout(jPanel47Layout);
/* 4547 */     jPanel47Layout.setHorizontalGroup(jPanel47Layout
/* 4548 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4549 */         .addGroup(jPanel47Layout.createSequentialGroup()
/* 4550 */           .addGap(56, 56, 56)
/* 4551 */           .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4552 */             .addGroup(jPanel47Layout.createSequentialGroup()
/* 4553 */               .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4554 */                 .addGroup(jPanel47Layout.createSequentialGroup()
/* 4555 */                   .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4556 */                     .addComponent(this.jLabel112, -1, -1, 32767)
/* 4557 */                     .addComponent(this.jLabel113, -2, 137, -2))
/* 4558 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4559 */                   .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4560 */                     .addComponent(this.nameRemove, -2, 209, -2)
/* 4561 */                     .addComponent((Component)this.ageRemove, -2, 209, -2)))
/* 4562 */                 .addGroup(jPanel47Layout.createSequentialGroup()
/* 4563 */                   .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4564 */                     .addComponent(this.jLabel114, -1, -1, 32767)
/* 4565 */                     .addComponent(this.jLabel115, -2, 137, -2))
/* 4566 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4567 */                   .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4568 */                     .addComponent(this.salaryRemove, -2, 209, -2)
/* 4569 */                     .addComponent(this.genderRemove, -2, 209, -2))))
/* 4570 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 4571 */               .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4572 */                 .addGroup(jPanel47Layout.createSequentialGroup()
/* 4573 */                   .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4574 */                     .addComponent(this.jLabel116, -1, -1, 32767)
/* 4575 */                     .addComponent(this.jLabel141, -2, 137, -2))
/* 4576 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4577 */                   .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4578 */                     .addComponent(this.addressRemove, -2, 209, -2)
/* 4579 */                     .addComponent(this.marital_statusRemove, -2, 209, -2)))
/* 4580 */                 .addGroup(jPanel47Layout.createSequentialGroup()
/* 4581 */                   .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4582 */                     .addComponent(this.jLabel142, -1, -1, 32767)
/* 4583 */                     .addComponent(this.jLabel143, -2, 137, -2))
/* 4584 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4585 */                   .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4586 */                     .addComponent(this.telephoneRemove, -2, 209, -2)
/* 4587 */                     .addComponent(this.academicRemove, -2, 209, -2)))))
/* 4588 */             .addGroup(jPanel47Layout.createSequentialGroup()
/* 4589 */               .addComponent(this.jLabel111, -2, 113, -2)
/* 4590 */               .addGap(35, 35, 35)
/* 4591 */               .addComponent(this.comboBoxListRemove, -2, 211, -2)
/* 4592 */               .addGap(18, 18, 18)
/* 4593 */               .addComponent(this.jButton32)
/* 4594 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 4595 */               .addComponent(this.jButton33, -2, 98, -2))
/* 4596 */             .addComponent(this.jSeparator7, GroupLayout.Alignment.TRAILING))
/* 4597 */           .addGap(56, 56, 56)));
/*      */     
/* 4599 */     jPanel47Layout.setVerticalGroup(jPanel47Layout
/* 4600 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4601 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
/* 4602 */           .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4603 */             .addGroup(jPanel47Layout.createSequentialGroup()
/* 4604 */               .addGap(46, 46, 46)
/* 4605 */               .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4606 */                 .addComponent(this.jLabel111)
/* 4607 */                 .addComponent(this.comboBoxListRemove, -2, 31, -2))
/* 4608 */               .addGap(18, 18, 32767))
/* 4609 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
/* 4610 */               .addContainerGap(-1, 32767)
/* 4611 */               .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4612 */                 .addComponent(this.jButton32)
/* 4613 */                 .addComponent(this.jButton33))
/* 4614 */               .addGap(18, 18, 18)))
/* 4615 */           .addComponent(this.jSeparator7, -2, 10, -2)
/* 4616 */           .addGap(18, 18, 18)
/* 4617 */           .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4618 */             .addGroup(jPanel47Layout.createSequentialGroup()
/* 4619 */               .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4620 */                 .addComponent(this.jLabel112, -2, 31, -2)
/* 4621 */                 .addComponent(this.nameRemove, -2, 31, -2))
/* 4622 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4623 */               .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4624 */                 .addComponent(this.jLabel113, -2, 31, -2)
/* 4625 */                 .addComponent((Component)this.ageRemove, -2, 33, -2))
/* 4626 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4627 */               .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4628 */                 .addComponent(this.jLabel114, -2, 31, -2)
/* 4629 */                 .addComponent(this.genderRemove, -2, 31, -2))
/* 4630 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4631 */               .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4632 */                 .addComponent(this.jLabel115, -2, 31, -2)
/* 4633 */                 .addComponent(this.salaryRemove, -2, 31, -2)))
/* 4634 */             .addGroup(jPanel47Layout.createSequentialGroup()
/* 4635 */               .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4636 */                 .addComponent(this.jLabel116, -2, 31, -2)
/* 4637 */                 .addComponent(this.marital_statusRemove, -2, 31, -2))
/* 4638 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4639 */               .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4640 */                 .addComponent(this.jLabel141, -2, 31, -2)
/* 4641 */                 .addComponent(this.addressRemove, -2, 31, -2))
/* 4642 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4643 */               .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4644 */                 .addComponent(this.jLabel142, -2, 31, -2)
/* 4645 */                 .addComponent(this.telephoneRemove, -2, 31, -2))
/* 4646 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4647 */               .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4648 */                 .addComponent(this.jLabel143, -2, 31, -2)
/* 4649 */                 .addComponent(this.academicRemove, -2, 31, -2))))
/* 4650 */           .addGap(116, 116, 116)));
/*      */ 
/*      */     
/* 4653 */     this.jPanel43.add(this.jPanel47, "modificarFuncionarioRemover");
/*      */     
/* 4655 */     GroupLayout jPanel37Layout = new GroupLayout(this.jPanel37);
/* 4656 */     this.jPanel37.setLayout(jPanel37Layout);
/* 4657 */     jPanel37Layout.setHorizontalGroup(jPanel37Layout
/* 4658 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4659 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
/* 4660 */           .addGap(30, 30, 30)
/* 4661 */           .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 4662 */             .addComponent(this.jPanel39, -1, -1, 32767)
/* 4663 */             .addComponent(this.jPanel38, -1, -1, 32767))
/* 4664 */           .addGap(30, 30, 30))
/* 4665 */         .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4666 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
/* 4667 */             .addContainerGap(180, 32767)
/* 4668 */             .addComponent(this.jPanel43, -2, 944, -2)
/* 4669 */             .addContainerGap(180, 32767))));
/*      */     
/* 4671 */     jPanel37Layout.setVerticalGroup(jPanel37Layout
/* 4672 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4673 */         .addGroup(jPanel37Layout.createSequentialGroup()
/* 4674 */           .addContainerGap(-1, 32767)
/* 4675 */           .addComponent(this.jPanel38, -2, -1, -2)
/* 4676 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4677 */           .addComponent(this.jPanel39, -2, -1, -2)
/* 4678 */           .addGap(439, 439, 439))
/* 4679 */         .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4680 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
/* 4681 */             .addContainerGap(180, 32767)
/* 4682 */             .addComponent(this.jPanel43, -2, 379, -2)
/* 4683 */             .addContainerGap(39, 32767))));
/*      */ 
/*      */     
/* 4686 */     this.jPanel14.add(this.jPanel37, "modificarFuncionario");
/*      */     
/* 4688 */     this.jLabel32.setFont(new Font("Segoe UI", 1, 18));
/* 4689 */     this.jLabel32.setForeground(new Color(102, 102, 102));
/* 4690 */     this.jLabel32.setHorizontalAlignment(0);
/* 4691 */     this.jLabel32.setText("VER LISTA DE FUNCIONÁRIOS");
/*      */     
/* 4693 */     GroupLayout jPanel48Layout = new GroupLayout(this.jPanel48);
/* 4694 */     this.jPanel48.setLayout(jPanel48Layout);
/* 4695 */     jPanel48Layout.setHorizontalGroup(jPanel48Layout
/* 4696 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4697 */         .addComponent(this.jLabel32, -1, -1, 32767));
/*      */     
/* 4699 */     jPanel48Layout.setVerticalGroup(jPanel48Layout
/* 4700 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4701 */         .addComponent(this.jLabel32, -1, 38, 32767));
/*      */ 
/*      */     
/* 4704 */     this.jPanel49.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 4706 */     this.jLabel37.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4707 */     this.jLabel37.setText("Nome do Funcionário ");
/*      */     
/* 4709 */     this.jButton30.setBackground(new Color(0, 153, 153));
/* 4710 */     this.jButton30.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4711 */     this.jButton30.setForeground(new Color(255, 255, 255));
/* 4712 */     this.jButton30.setText("BUSCAR");
/* 4713 */     this.jButton30.setCursor(new Cursor(12));
/* 4714 */     this.jButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4716 */             mainWindow.this.jButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4720 */     this.jButton31.setBackground(new Color(0, 153, 153));
/* 4721 */     this.jButton31.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4722 */     this.jButton31.setForeground(new Color(255, 255, 255));
/* 4723 */     this.jButton31.setText("TODOS");
/* 4724 */     this.jButton31.setCursor(new Cursor(12));
/* 4725 */     this.jButton31.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4727 */             mainWindow.this.jButton31ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4731 */     GroupLayout jPanel49Layout = new GroupLayout(this.jPanel49);
/* 4732 */     this.jPanel49.setLayout(jPanel49Layout);
/* 4733 */     jPanel49Layout.setHorizontalGroup(jPanel49Layout
/* 4734 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4735 */         .addGroup(jPanel49Layout.createSequentialGroup()
/* 4736 */           .addContainerGap()
/* 4737 */           .addComponent(this.jLabel37, -2, 176, -2)
/* 4738 */           .addGap(18, 18, 18)
/* 4739 */           .addGroup(jPanel49Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4740 */             .addComponent(this.jButton30, -1, 189, 32767)
/* 4741 */             .addComponent(this.nameStuffSearch, 0, -1, 32767))
/* 4742 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 4743 */           .addComponent(this.jButton31, -2, 133, -2)
/* 4744 */           .addContainerGap()));
/*      */     
/* 4746 */     jPanel49Layout.setVerticalGroup(jPanel49Layout
/* 4747 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4748 */         .addGroup(jPanel49Layout.createSequentialGroup()
/* 4749 */           .addGap(29, 29, 29)
/* 4750 */           .addGroup(jPanel49Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4751 */             .addComponent(this.jLabel37, -2, 31, -2)
/* 4752 */             .addComponent(this.nameStuffSearch, -1, 33, 32767))
/* 4753 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4754 */           .addGroup(jPanel49Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4755 */             .addComponent(this.jButton30, -1, 30, 32767)
/* 4756 */             .addComponent(this.jButton31, -1, -1, 32767))
/* 4757 */           .addGap(33, 33, 33)));
/*      */ 
/*      */     
/* 4760 */     this.usersTable.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4761 */     this.usersTable.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null, null }, }, (Object[])new String[] { "Item", "Nome", "Idade", "Sexo", "Estado Civil", "Endereço", "Telefone", "Formação", "Salário" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 4772 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4777 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4780 */     this.jScrollPane12.setViewportView(this.usersTable);
/*      */     
/* 4782 */     GroupLayout jPanel28Layout = new GroupLayout(this.jPanel28);
/* 4783 */     this.jPanel28.setLayout(jPanel28Layout);
/* 4784 */     jPanel28Layout.setHorizontalGroup(jPanel28Layout
/* 4785 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4786 */         .addGap(0, 1242, 32767)
/* 4787 */         .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4788 */           .addComponent(this.jScrollPane12, -1, 1242, 32767)));
/*      */     
/* 4790 */     jPanel28Layout.setVerticalGroup(jPanel28Layout
/* 4791 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4792 */         .addGap(0, 383, 32767)
/* 4793 */         .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4794 */           .addComponent(this.jScrollPane12, -1, 383, 32767)));
/*      */ 
/*      */     
/* 4797 */     this.jScrollPane7.setViewportView(this.jPanel28);
/*      */     
/* 4799 */     GroupLayout jPanel46Layout = new GroupLayout(this.jPanel46);
/* 4800 */     this.jPanel46.setLayout(jPanel46Layout);
/* 4801 */     jPanel46Layout.setHorizontalGroup(jPanel46Layout
/* 4802 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4803 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
/* 4804 */           .addGap(30, 30, 30)
/* 4805 */           .addGroup(jPanel46Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 4806 */             .addComponent(this.jPanel49, -1, -1, 32767)
/* 4807 */             .addComponent(this.jPanel48, -1, -1, 32767)
/* 4808 */             .addComponent(this.jScrollPane7, GroupLayout.Alignment.LEADING))
/* 4809 */           .addGap(30, 30, 30)));
/*      */     
/* 4811 */     jPanel46Layout.setVerticalGroup(jPanel46Layout
/* 4812 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4813 */         .addGroup(jPanel46Layout.createSequentialGroup()
/* 4814 */           .addContainerGap(-1, 32767)
/* 4815 */           .addComponent(this.jPanel48, -2, -1, -2)
/* 4816 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4817 */           .addComponent(this.jPanel49, -2, -1, -2)
/* 4818 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4819 */           .addComponent(this.jScrollPane7)
/* 4820 */           .addContainerGap()));
/*      */ 
/*      */     
/* 4823 */     this.jPanel14.add(this.jPanel46, "verFuncionario");
/*      */     
/* 4825 */     this.jLabel117.setFont(new Font("Segoe UI", 1, 18));
/* 4826 */     this.jLabel117.setForeground(new Color(102, 102, 102));
/* 4827 */     this.jLabel117.setHorizontalAlignment(0);
/* 4828 */     this.jLabel117.setText("DADOS DA EMPRESA");
/*      */     
/* 4830 */     GroupLayout jPanel54Layout = new GroupLayout(this.jPanel54);
/* 4831 */     this.jPanel54.setLayout(jPanel54Layout);
/* 4832 */     jPanel54Layout.setHorizontalGroup(jPanel54Layout
/* 4833 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4834 */         .addComponent(this.jLabel117, -1, 1244, 32767));
/*      */     
/* 4836 */     jPanel54Layout.setVerticalGroup(jPanel54Layout
/* 4837 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4838 */         .addComponent(this.jLabel117, -1, 38, 32767));
/*      */ 
/*      */     
/* 4841 */     this.jPanel55.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 4843 */     this.jLabel123.setFont(new Font("Segoe UI Light", 0, 14));
/* 4844 */     this.jLabel123.setHorizontalAlignment(0);
/* 4845 */     this.jLabel123.setText("nos campos abaixo. Caso já tenha as informações registadas e pretende fazer modificações, clique em Editar.");
/*      */     
/* 4847 */     this.jLabel124.setFont(new Font("Segoe UI Light", 0, 14));
/* 4848 */     this.jLabel124.setHorizontalAlignment(0);
/* 4849 */     this.jLabel124.setText("Caso Ainda não tenha registado as informações da sua empresa, por favor informe os dados  ");
/*      */     
/* 4851 */     GroupLayout jPanel55Layout = new GroupLayout(this.jPanel55);
/* 4852 */     this.jPanel55.setLayout(jPanel55Layout);
/* 4853 */     jPanel55Layout.setHorizontalGroup(jPanel55Layout
/* 4854 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4855 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
/* 4856 */           .addContainerGap()
/* 4857 */           .addComponent(this.jLabel123, -1, -1, 32767)
/* 4858 */           .addContainerGap())
/* 4859 */         .addGroup(jPanel55Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4860 */           .addGroup(jPanel55Layout.createSequentialGroup()
/* 4861 */             .addContainerGap()
/* 4862 */             .addComponent(this.jLabel124, -1, 921, 32767)
/* 4863 */             .addContainerGap())));
/*      */     
/* 4865 */     jPanel55Layout.setVerticalGroup(jPanel55Layout
/* 4866 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4867 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
/* 4868 */           .addContainerGap(47, 32767)
/* 4869 */           .addComponent(this.jLabel123, -2, 23, -2)
/* 4870 */           .addGap(30, 30, 30))
/* 4871 */         .addGroup(jPanel55Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4872 */           .addGroup(jPanel55Layout.createSequentialGroup()
/* 4873 */             .addGap(21, 21, 21)
/* 4874 */             .addComponent(this.jLabel124, -2, 25, -2)
/* 4875 */             .addContainerGap(54, 32767))));
/*      */ 
/*      */     
/* 4878 */     this.jPanel62.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 4880 */     this.jLabel150.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4881 */     this.jLabel150.setText("Nome da Empresa");
/*      */     
/* 4883 */     this.companyName.setEnabled(false);
/*      */     
/* 4885 */     this.jLabel151.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4886 */     this.jLabel151.setText("Endereço");
/*      */     
/* 4888 */     this.jLabel152.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4889 */     this.jLabel152.setText("Pessoa de Contato");
/*      */     
/* 4891 */     this.companyAddress.setEnabled(false);
/*      */     
/* 4893 */     this.companyEmail.setEnabled(false);
/*      */     
/* 4895 */     this.jLabel154.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4896 */     this.jLabel154.setText("Telefone");
/*      */     
/* 4898 */     this.jLabel155.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4899 */     this.jLabel155.setText("E-mail");
/*      */     
/* 4901 */     this.jLabel156.setFont(new Font("Segoe UI Semibold", 0, 14));
/* 4902 */     this.jLabel156.setText("Data de Abertura");
/*      */     
/* 4904 */     this.CompanyopenDate.setDateFormatString("yyyy-MM-dd");
/* 4905 */     this.CompanyopenDate.setEnabled(false);
/*      */     
/* 4907 */     this.companyTelephone.setEnabled(false);
/* 4908 */     this.companyTelephone.addKeyListener(new KeyAdapter() {
/*      */           public void keyPressed(KeyEvent evt) {
/* 4910 */             mainWindow.this.companyTelephoneKeyPressed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4914 */     this.jButton34.setBackground(new Color(0, 153, 153));
/* 4915 */     this.jButton34.setFont(new Font("Segoe UI", 1, 14));
/* 4916 */     this.jButton34.setForeground(new Color(255, 255, 255));
/* 4917 */     this.jButton34.setText("SALVAR");
/* 4918 */     this.jButton34.setCursor(new Cursor(12));
/* 4919 */     this.jButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4921 */             mainWindow.this.jButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4925 */     this.companyEdit.setBackground(new Color(0, 153, 153));
/* 4926 */     this.companyEdit.setFont(new Font("Segoe UI", 1, 14));
/* 4927 */     this.companyEdit.setForeground(new Color(255, 255, 255));
/* 4928 */     this.companyEdit.setText("EDITAR");
/* 4929 */     this.companyEdit.setCursor(new Cursor(12));
/* 4930 */     this.companyEdit.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4932 */             mainWindow.this.companyEditActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4936 */     this.CompanyContactPerson.setEnabled(false);
/*      */     
/* 4938 */     GroupLayout jPanel62Layout = new GroupLayout(this.jPanel62);
/* 4939 */     this.jPanel62.setLayout(jPanel62Layout);
/* 4940 */     jPanel62Layout.setHorizontalGroup(jPanel62Layout
/* 4941 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4942 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
/* 4943 */           .addGap(56, 56, 56)
/* 4944 */           .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4945 */             .addGroup(jPanel62Layout.createSequentialGroup()
/* 4946 */               .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4947 */                 .addGroup(jPanel62Layout.createSequentialGroup()
/* 4948 */                   .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4949 */                     .addComponent(this.jLabel150, -1, -1, 32767)
/* 4950 */                     .addComponent(this.jLabel151, -2, 137, -2))
/* 4951 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4952 */                   .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4953 */                     .addComponent(this.companyName, -2, 209, -2)
/* 4954 */                     .addComponent(this.companyAddress, -2, 209, -2)))
/* 4955 */                 .addGroup(jPanel62Layout.createSequentialGroup()
/* 4956 */                   .addComponent(this.jLabel152, -2, 137, -2)
/* 4957 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4958 */                   .addComponent(this.CompanyContactPerson, -2, 209, -2)))
/* 4959 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 416, 32767)
/* 4960 */               .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4961 */                 .addGroup(jPanel62Layout.createSequentialGroup()
/* 4962 */                   .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4963 */                     .addComponent(this.jLabel154, -1, -1, 32767)
/* 4964 */                     .addComponent(this.jLabel155, -2, 137, -2))
/* 4965 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4966 */                   .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4967 */                     .addComponent(this.companyEmail, -2, 209, -2)
/* 4968 */                     .addComponent(this.companyTelephone, -2, 209, -2)))
/* 4969 */                 .addGroup(jPanel62Layout.createSequentialGroup()
/* 4970 */                   .addComponent(this.jLabel156, -2, 137, -2)
/* 4971 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4972 */                   .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4973 */                     .addGroup(jPanel62Layout.createSequentialGroup()
/* 4974 */                       .addComponent(this.companyEdit, -2, 94, -2)
/* 4975 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 4976 */                       .addComponent(this.jButton34, -2, 94, -2))
/* 4977 */                     .addComponent((Component)this.CompanyopenDate, -2, 209, -2)))))
/* 4978 */             .addComponent(this.jSeparator9, GroupLayout.Alignment.TRAILING))
/* 4979 */           .addGap(56, 56, 56)));
/*      */     
/* 4981 */     jPanel62Layout.setVerticalGroup(jPanel62Layout
/* 4982 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4983 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
/* 4984 */           .addContainerGap(96, 32767)
/* 4985 */           .addComponent(this.jSeparator9, -2, 10, -2)
/* 4986 */           .addGap(18, 18, 18)
/* 4987 */           .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4988 */             .addGroup(jPanel62Layout.createSequentialGroup()
/* 4989 */               .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4990 */                 .addComponent(this.jLabel150, -2, 31, -2)
/* 4991 */                 .addComponent(this.companyName, -2, 31, -2))
/* 4992 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4993 */               .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4994 */                 .addComponent(this.jLabel151, -2, 31, -2)
/* 4995 */                 .addComponent(this.companyAddress, -2, 31, -2))
/* 4996 */               .addGap(11, 11, 11)
/* 4997 */               .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4998 */                 .addComponent(this.jLabel152, -2, 31, -2)
/* 4999 */                 .addComponent(this.CompanyContactPerson, -2, 31, -2)))
/* 5000 */             .addGroup(jPanel62Layout.createSequentialGroup()
/* 5001 */               .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 5002 */                 .addComponent(this.jLabel154, -2, 31, -2)
/* 5003 */                 .addComponent(this.companyTelephone, -2, 31, -2))
/* 5004 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 5005 */               .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 5006 */                 .addComponent(this.jLabel155, -2, 31, -2)
/* 5007 */                 .addComponent(this.companyEmail, -2, 31, -2))
/* 5008 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 5009 */               .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 5010 */                 .addComponent(this.jLabel156, -2, 31, -2)
/* 5011 */                 .addComponent((Component)this.CompanyopenDate, -2, 33, -2))))
/* 5012 */           .addGap(31, 31, 31)
/* 5013 */           .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 5014 */             .addComponent(this.jButton34, -2, 32, -2)
/* 5015 */             .addComponent(this.companyEdit, -2, 32, -2))
/* 5016 */           .addGap(97, 97, 97)));
/*      */ 
/*      */     
/* 5019 */     GroupLayout jPanel53Layout = new GroupLayout(this.jPanel53);
/* 5020 */     this.jPanel53.setLayout(jPanel53Layout);
/* 5021 */     jPanel53Layout.setHorizontalGroup(jPanel53Layout
/* 5022 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 5023 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
/* 5024 */           .addGap(30, 30, 30)
/* 5025 */           .addGroup(jPanel53Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 5026 */             .addComponent(this.jPanel62, -1, -1, 32767)
/* 5027 */             .addComponent(this.jPanel55, -1, -1, 32767)
/* 5028 */             .addComponent(this.jPanel54, -1, -1, 32767))
/* 5029 */           .addGap(30, 30, 30)));
/*      */     
/* 5031 */     jPanel53Layout.setVerticalGroup(jPanel53Layout
/* 5032 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 5033 */         .addGroup(jPanel53Layout.createSequentialGroup()
/* 5034 */           .addContainerGap(-1, 32767)
/* 5035 */           .addComponent(this.jPanel54, -2, -1, -2)
/* 5036 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 5037 */           .addComponent(this.jPanel55, -2, -1, -2)
/* 5038 */           .addGap(18, 18, 18)
/* 5039 */           .addComponent(this.jPanel62, -1, -1, 32767)
/* 5040 */           .addContainerGap()));
/*      */ 
/*      */     
/* 5043 */     this.jPanel14.add(this.jPanel53, "dadosDaEmpresa");
/*      */     
/* 5045 */     getContentPane().add(this.jPanel14, "Center");
/*      */     
/* 5047 */     pack();
/* 5048 */     setLocationRelativeTo(null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void pontoDeVendasBtnMouseDragged(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void relatorioDeVendasBtnMouseEntered(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void relatorioDeVendasBtnMouseExited(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void InventorioBtnMouseEntered(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void InventorioBtnMouseExited(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void modificarStockBtnMouseEntered(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void modificarStockBtnMouseExited(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void pontoDeVendasBtnMouseEntered(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void pontoDeVendasBtnMouseExited(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void pontoDeVendasBtnMouseClicked(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void relatorioDeVendasBtnMouseClicked(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void InventorioBtnMouseClicked(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void modificarStockBtnMouseClicked(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel34MouseClicked(MouseEvent evt) {
/* 5120 */     this.verFuncionariosBtn.setBackground(Color.red);
/* 5121 */     this.modificarFuncionarioBtn.setBackground(new Color(0, 153, 153));
/* 5122 */     this.acessosBtn.setBackground(new Color(0, 153, 153));
/* 5123 */     this.modificarDadosDaEmpresaBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5125 */     this.pontoDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5126 */     this.relatorioDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5127 */     this.InventorioBtn.setBackground(new Color(0, 153, 153));
/* 5128 */     this.modificarStockBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5130 */     CardLayout cl = (CardLayout)this.jPanel14.getLayout();
/* 5131 */     cl.show(this.jPanel14, "verFuncionario");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel47MouseClicked(MouseEvent evt) {
/* 5137 */     this.verFuncionariosBtn.setBackground(new Color(0, 153, 153));
/* 5138 */     this.modificarFuncionarioBtn.setBackground(Color.red);
/* 5139 */     this.acessosBtn.setBackground(new Color(0, 153, 153));
/* 5140 */     this.modificarDadosDaEmpresaBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5142 */     this.pontoDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5143 */     this.relatorioDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5144 */     this.InventorioBtn.setBackground(new Color(0, 153, 153));
/* 5145 */     this.modificarStockBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5147 */     CardLayout cl = (CardLayout)this.jPanel14.getLayout();
/* 5148 */     cl.show(this.jPanel14, "modificarFuncionario");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel50MouseClicked(MouseEvent evt) {
/* 5154 */     this.verFuncionariosBtn.setBackground(new Color(0, 153, 153));
/* 5155 */     this.modificarFuncionarioBtn.setBackground(new Color(0, 153, 153));
/* 5156 */     this.acessosBtn.setBackground(Color.red);
/* 5157 */     this.modificarDadosDaEmpresaBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5159 */     this.pontoDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5160 */     this.relatorioDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5161 */     this.InventorioBtn.setBackground(new Color(0, 153, 153));
/* 5162 */     this.modificarStockBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5164 */     CardLayout cl = (CardLayout)this.jPanel14.getLayout();
/* 5165 */     cl.show(this.jPanel14, "acessos");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel53MouseClicked(MouseEvent evt) {
/* 5171 */     this.verFuncionariosBtn.setBackground(new Color(0, 153, 153));
/* 5172 */     this.modificarFuncionarioBtn.setBackground(new Color(0, 153, 153));
/* 5173 */     this.acessosBtn.setBackground(new Color(0, 153, 153));
/* 5174 */     this.modificarDadosDaEmpresaBtn.setBackground(Color.red);
/*      */     
/* 5176 */     this.pontoDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5177 */     this.relatorioDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5178 */     this.InventorioBtn.setBackground(new Color(0, 153, 153));
/* 5179 */     this.modificarStockBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5181 */     CardLayout cl = (CardLayout)this.jPanel14.getLayout();
/* 5182 */     cl.show(this.jPanel14, "dadosDaEmpresa");
/*      */     
/* 5184 */     CompanyDAO cdao = new CompanyDAO();
/* 5185 */     Company cmp = cdao.returnCompany();
/* 5186 */     this.companyName.setText(cmp.getName());
/* 5187 */     this.companyAddress.setText(cmp.getAddress());
/* 5188 */     this.CompanyContactPerson.setText(cmp.getContact_person());
/* 5189 */     this.companyTelephone.setText(String.valueOf(cmp.getTelephone()));
/* 5190 */     this.companyEmail.setText(cmp.getEmail());
/*      */     
/* 5192 */     String openDateStr = cmp.getOpen_date();
/* 5193 */     DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/*      */     try {
/* 5195 */       Date openDateValue = formatter.parse(openDateStr);
/* 5196 */       this.CompanyopenDate.setDate(openDateValue);
/* 5197 */     } catch (ParseException ex) {
/* 5198 */       System.err.println("Error: " + ex);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 5203 */     if (cdao.returnCompany().getName() == null) {
/* 5204 */       this.companyEdit.setEnabled(false);
/*      */     } else {
/* 5206 */       this.companyEdit.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel56MouseClicked(MouseEvent evt) {
/* 5212 */     this.pontoDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5213 */     this.relatorioDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5214 */     this.InventorioBtn.setBackground(new Color(0, 153, 153));
/* 5215 */     this.modificarStockBtn.setBackground(Color.red);
/*      */     
/* 5217 */     this.verFuncionariosBtn.setBackground(new Color(0, 153, 153));
/* 5218 */     this.modificarFuncionarioBtn.setBackground(new Color(0, 153, 153));
/* 5219 */     this.acessosBtn.setBackground(new Color(0, 153, 153));
/* 5220 */     this.modificarDadosDaEmpresaBtn.setBackground(new Color(0, 153, 153));
/* 5221 */     CardLayout cl = (CardLayout)this.jPanel14.getLayout();
/* 5222 */     cl.show(this.jPanel14, "modificarStock");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel59MouseClicked(MouseEvent evt) {
/* 5228 */     this.pontoDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5229 */     this.relatorioDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5230 */     this.InventorioBtn.setBackground(Color.red);
/* 5231 */     this.modificarStockBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5233 */     this.verFuncionariosBtn.setBackground(new Color(0, 153, 153));
/* 5234 */     this.modificarFuncionarioBtn.setBackground(new Color(0, 153, 153));
/* 5235 */     this.acessosBtn.setBackground(new Color(0, 153, 153));
/* 5236 */     this.modificarDadosDaEmpresaBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5238 */     CardLayout cl = (CardLayout)this.jPanel14.getLayout();
/* 5239 */     cl.show(this.jPanel14, "inventorioDoStock");
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel62MouseClicked(MouseEvent evt) {
/* 5244 */     this.pontoDeVendasBtn.setBackground(Color.red);
/* 5245 */     this.relatorioDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5246 */     this.InventorioBtn.setBackground(new Color(0, 153, 153));
/* 5247 */     this.modificarStockBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5249 */     this.verFuncionariosBtn.setBackground(new Color(0, 153, 153));
/* 5250 */     this.modificarFuncionarioBtn.setBackground(new Color(0, 153, 153));
/* 5251 */     this.acessosBtn.setBackground(new Color(0, 153, 153));
/* 5252 */     this.modificarDadosDaEmpresaBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5254 */     CardLayout cl = (CardLayout)this.jPanel14.getLayout();
/* 5255 */     cl.show(this.jPanel14, "pontoDeVendas");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel65MouseClicked(MouseEvent evt) {
/* 5262 */     this.pontoDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5263 */     this.relatorioDeVendasBtn.setBackground(Color.red);
/* 5264 */     this.InventorioBtn.setBackground(new Color(0, 153, 153));
/* 5265 */     this.modificarStockBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5267 */     this.verFuncionariosBtn.setBackground(new Color(0, 153, 153));
/* 5268 */     this.modificarFuncionarioBtn.setBackground(new Color(0, 153, 153));
/* 5269 */     this.acessosBtn.setBackground(new Color(0, 153, 153));
/* 5270 */     this.modificarDadosDaEmpresaBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5272 */     CardLayout cl = (CardLayout)this.jPanel14.getLayout();
/* 5273 */     cl.show(this.jPanel14, "relatorioDeVendas");
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel61MouseClicked(MouseEvent evt) {
/* 5278 */     this.pontoDeVendasBtn.setBackground(Color.red);
/* 5279 */     this.relatorioDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5280 */     this.InventorioBtn.setBackground(new Color(0, 153, 153));
/* 5281 */     this.modificarStockBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5283 */     this.verFuncionariosBtn.setBackground(new Color(0, 153, 153));
/* 5284 */     this.modificarFuncionarioBtn.setBackground(new Color(0, 153, 153));
/* 5285 */     this.acessosBtn.setBackground(new Color(0, 153, 153));
/* 5286 */     this.modificarDadosDaEmpresaBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5288 */     CardLayout cl = (CardLayout)this.jPanel14.getLayout();
/* 5289 */     cl.show(this.jPanel14, "pontoDeVendas");
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel64MouseClicked(MouseEvent evt) {
/* 5294 */     this.pontoDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5295 */     this.relatorioDeVendasBtn.setBackground(Color.red);
/* 5296 */     this.InventorioBtn.setBackground(new Color(0, 153, 153));
/* 5297 */     this.modificarStockBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5299 */     this.verFuncionariosBtn.setBackground(new Color(0, 153, 153));
/* 5300 */     this.modificarFuncionarioBtn.setBackground(new Color(0, 153, 153));
/* 5301 */     this.acessosBtn.setBackground(new Color(0, 153, 153));
/* 5302 */     this.modificarDadosDaEmpresaBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5304 */     CardLayout cl = (CardLayout)this.jPanel14.getLayout();
/* 5305 */     cl.show(this.jPanel14, "relatorioDeVendas");
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel58MouseClicked(MouseEvent evt) {
/* 5310 */     this.pontoDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5311 */     this.relatorioDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5312 */     this.InventorioBtn.setBackground(Color.red);
/* 5313 */     this.modificarStockBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5315 */     this.verFuncionariosBtn.setBackground(new Color(0, 153, 153));
/* 5316 */     this.modificarFuncionarioBtn.setBackground(new Color(0, 153, 153));
/* 5317 */     this.acessosBtn.setBackground(new Color(0, 153, 153));
/* 5318 */     this.modificarDadosDaEmpresaBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5320 */     CardLayout cl = (CardLayout)this.jPanel14.getLayout();
/* 5321 */     cl.show(this.jPanel14, "inventorioDoStock");
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel55MouseClicked(MouseEvent evt) {
/* 5326 */     this.pontoDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5327 */     this.relatorioDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5328 */     this.InventorioBtn.setBackground(new Color(0, 153, 153));
/* 5329 */     this.modificarStockBtn.setBackground(Color.red);
/*      */     
/* 5331 */     this.verFuncionariosBtn.setBackground(new Color(0, 153, 153));
/* 5332 */     this.modificarFuncionarioBtn.setBackground(new Color(0, 153, 153));
/* 5333 */     this.acessosBtn.setBackground(new Color(0, 153, 153));
/* 5334 */     this.modificarDadosDaEmpresaBtn.setBackground(new Color(0, 153, 153));
/* 5335 */     CardLayout cl = (CardLayout)this.jPanel14.getLayout();
/* 5336 */     cl.show(this.jPanel14, "modificarStock");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel62MouseEntered(MouseEvent evt) {
/* 5342 */     this.pontoDeVendasBtn.setCursor(Cursor.getPredefinedCursor(12));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel61MouseEntered(MouseEvent evt) {
/* 5347 */     this.pontoDeVendasBtn.setCursor(Cursor.getPredefinedCursor(12));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel65MouseEntered(MouseEvent evt) {
/* 5352 */     this.relatorioDeVendasBtn.setCursor(Cursor.getPredefinedCursor(12));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel64MouseEntered(MouseEvent evt) {
/* 5357 */     this.relatorioDeVendasBtn.setCursor(Cursor.getPredefinedCursor(12));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel59MouseEntered(MouseEvent evt) {
/* 5362 */     this.InventorioBtn.setCursor(Cursor.getPredefinedCursor(12));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel58MouseEntered(MouseEvent evt) {
/* 5368 */     this.InventorioBtn.setCursor(Cursor.getPredefinedCursor(12));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel56MouseEntered(MouseEvent evt) {
/* 5373 */     this.modificarStockBtn.setCursor(Cursor.getPredefinedCursor(12));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel55MouseEntered(MouseEvent evt) {
/* 5378 */     this.modificarStockBtn.setCursor(Cursor.getPredefinedCursor(12));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel62MouseMoved(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jLabel36MouseClicked(MouseEvent evt) {
/* 5387 */     this.verFuncionariosBtn.setBackground(Color.red);
/* 5388 */     this.modificarFuncionarioBtn.setBackground(new Color(0, 153, 153));
/* 5389 */     this.acessosBtn.setBackground(new Color(0, 153, 153));
/* 5390 */     this.modificarDadosDaEmpresaBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5392 */     this.pontoDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5393 */     this.relatorioDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5394 */     this.InventorioBtn.setBackground(new Color(0, 153, 153));
/* 5395 */     this.modificarStockBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5397 */     CardLayout cl = (CardLayout)this.jPanel14.getLayout();
/* 5398 */     cl.show(this.jPanel14, "verFuncionario");
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel46MouseClicked(MouseEvent evt) {
/* 5403 */     this.verFuncionariosBtn.setBackground(new Color(0, 153, 153));
/* 5404 */     this.modificarFuncionarioBtn.setBackground(Color.red);
/* 5405 */     this.acessosBtn.setBackground(new Color(0, 153, 153));
/* 5406 */     this.modificarDadosDaEmpresaBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5408 */     this.pontoDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5409 */     this.relatorioDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5410 */     this.InventorioBtn.setBackground(new Color(0, 153, 153));
/* 5411 */     this.modificarStockBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5413 */     CardLayout cl = (CardLayout)this.jPanel14.getLayout();
/* 5414 */     cl.show(this.jPanel14, "modificarFuncionario");
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel49MouseClicked(MouseEvent evt) {
/* 5419 */     this.verFuncionariosBtn.setBackground(new Color(0, 153, 153));
/* 5420 */     this.modificarFuncionarioBtn.setBackground(new Color(0, 153, 153));
/* 5421 */     this.acessosBtn.setBackground(Color.red);
/* 5422 */     this.modificarDadosDaEmpresaBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5424 */     this.pontoDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5425 */     this.relatorioDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5426 */     this.InventorioBtn.setBackground(new Color(0, 153, 153));
/* 5427 */     this.modificarStockBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5429 */     CardLayout cl = (CardLayout)this.jPanel14.getLayout();
/* 5430 */     cl.show(this.jPanel14, "acessos");
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel52MouseClicked(MouseEvent evt) {
/* 5435 */     this.verFuncionariosBtn.setBackground(new Color(0, 153, 153));
/* 5436 */     this.modificarFuncionarioBtn.setBackground(new Color(0, 153, 153));
/* 5437 */     this.acessosBtn.setBackground(new Color(0, 153, 153));
/* 5438 */     this.modificarDadosDaEmpresaBtn.setBackground(Color.red);
/*      */     
/* 5440 */     this.pontoDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5441 */     this.relatorioDeVendasBtn.setBackground(new Color(0, 153, 153));
/* 5442 */     this.InventorioBtn.setBackground(new Color(0, 153, 153));
/* 5443 */     this.modificarStockBtn.setBackground(new Color(0, 153, 153));
/*      */     
/* 5445 */     CardLayout cl = (CardLayout)this.jPanel14.getLayout();
/* 5446 */     cl.show(this.jPanel14, "dadosDaEmpresa");
/*      */     
/* 5448 */     CompanyDAO cdao = new CompanyDAO();
/* 5449 */     Company cmp = cdao.returnCompany();
/* 5450 */     this.companyName.setText(cmp.getName());
/* 5451 */     this.companyAddress.setText(cmp.getAddress());
/* 5452 */     this.CompanyContactPerson.setText(cmp.getContact_person());
/* 5453 */     this.companyTelephone.setText(String.valueOf(cmp.getTelephone()));
/* 5454 */     this.companyEmail.setText(cmp.getEmail());
/*      */     
/* 5456 */     String openDateStr = cmp.getOpen_date();
/* 5457 */     DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/*      */     try {
/* 5459 */       Date openDateValue = formatter.parse(openDateStr);
/* 5460 */       this.CompanyopenDate.setDate(openDateValue);
/* 5461 */     } catch (ParseException ex) {
/* 5462 */       System.err.println("Error: " + ex);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 5467 */     if (cdao.returnCompany().getName() == null) {
/* 5468 */       this.companyEdit.setEnabled(false);
/*      */     } else {
/* 5470 */       this.companyEdit.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel34MouseEntered(MouseEvent evt) {
/* 5476 */     this.verFuncionariosBtn.setCursor(Cursor.getPredefinedCursor(12));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel36MouseEntered(MouseEvent evt) {
/* 5482 */     this.verFuncionariosBtn.setCursor(Cursor.getPredefinedCursor(12));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel47MouseEntered(MouseEvent evt) {
/* 5487 */     this.modificarFuncionarioBtn.setCursor(Cursor.getPredefinedCursor(12));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel46MouseEntered(MouseEvent evt) {
/* 5492 */     this.modificarFuncionarioBtn.setCursor(Cursor.getPredefinedCursor(12));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel50MouseEntered(MouseEvent evt) {
/* 5497 */     this.acessosBtn.setCursor(Cursor.getPredefinedCursor(12));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel49MouseEntered(MouseEvent evt) {
/* 5502 */     this.acessosBtn.setCursor(Cursor.getPredefinedCursor(12));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel53MouseEntered(MouseEvent evt) {
/* 5507 */     this.modificarDadosDaEmpresaBtn.setCursor(Cursor.getPredefinedCursor(12));
/*      */   }
/*      */ 
/*      */   
/*      */   private void barCodePointSellActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void comercialNamePointSellActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   public mainWindow()
/*      */   {
/* 5517 */     this.total = 0.0D;
/*      */     initComponents();
/*      */     otherInitComponents(); } private void submitDrugsSellPointActionPerformed(ActionEvent evt) {
/* 5520 */     if (this.buyListTb.getRowCount() == 0) {
/* 5521 */       JOptionPane.showMessageDialog(this, "Nenhum Medicamento adicionado na Fatura!", "Campos Vazios", 2);
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 5526 */       for (int i = 0; i < this.buyListTb.getRowCount(); i++) {
/* 5527 */         Double Amount = Double.valueOf(Double.parseDouble(this.buyListTb.getValueAt(i, 3) + ""));
/* 5528 */         this.total = Amount.doubleValue() + this.total;
/*      */       } 
/* 5530 */       this.totalToPay.setText(String.valueOf(this.total));
/*      */       
/* 5532 */       this.generateBill.setEnabled(true);
/* 5533 */       this.addPaymentPSBtn.setEnabled(true);
/*      */       
/* 5535 */       this.discountPointSell.setEnabled(true);
/* 5536 */       this.methodPayment.setEnabled(true);
/* 5537 */       this.moneyPaid.setEnabled(true);
/* 5538 */       this.subMethodPaymentPOS.setEnabled(true);
/*      */       
/* 5540 */       this.comercialNamePointSell.setEnabled(false);
/* 5541 */       this.barCodePointSell.setEnabled(false);
/* 5542 */       this.qtyTextSellPoint.setEnabled(false);
/* 5543 */       this.addDrugBuyList.setEnabled(false);
/*      */       
/* 5545 */       this.addDrugSellPoint.setEnabled(false);
/*      */       
/* 5547 */       this.submitDrugsSellPoint.setEnabled(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private String getActualDate() {
/* 5554 */     Date date = new Date();
/* 5555 */     String modifiedDate = (new SimpleDateFormat("yyyy-MM-dd")).format(date);
/* 5556 */     return modifiedDate;
/*      */   }
/*      */   
/*      */   private int getTotalPaid() {
/* 5560 */     int total = 0;
/* 5561 */     for (PaymentMethod p : this.pMethodList) {
/* 5562 */       total = (int)(total + p.getMoney_paid());
/*      */     }
/*      */     
/* 5565 */     return total;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean checkQuantity(int stock_id, double req_qty) {
/* 5570 */     boolean result = false;
/*      */     
/* 5572 */     OrderDAO odao = new OrderDAO();
/*      */     
/* 5574 */     double quantity = odao.quantityInStock(stock_id);
/*      */     
/* 5576 */     if (quantity >= req_qty && req_qty > 0.0D) {
/* 5577 */       result = true;
/*      */     }
/* 5579 */     return result;
/*      */   }
/*      */   
/*      */   private boolean deductFromSttock() {
/* 5583 */     OrderDetailsDAO odDAO = new OrderDetailsDAO();
/* 5584 */     StockDAO sdao = new StockDAO();
/* 5585 */     OrderDAO odao = new OrderDAO();
/*      */     
/* 5587 */     boolean result = true;
/*      */     
/* 5589 */     for (OrderDetails order1 : this.orderSelldetails) {
/* 5590 */       double quantity = order1.getQuantity();
/*      */       
/* 5592 */       Stock stock = sdao.returnStockByDrugId(order1.getDrug());
/* 5593 */       int stockId = stock.getStock_id();
/* 5594 */       result = odao.deductFromStock(stockId, quantity);
/* 5595 */       if (!result) {
/* 5596 */         result = false;
/*      */       }
/*      */     } 
/*      */     
/* 5600 */     return result;
/*      */   }
/*      */   
/*      */   private void setOrderDetails(Order order) {
/* 5604 */     OrderDetailsDAO odDAO = new OrderDetailsDAO();
/* 5605 */     for (OrderDetails order1 : this.orderSelldetails) {
/* 5606 */       order1.setOrder(order);
/* 5607 */       odDAO.saveOrderDetails(order1);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void setPaymentMethods(Order order) {
/* 5613 */     PaymentMethodDAO pDAO = new PaymentMethodDAO();
/* 5614 */     for (PaymentMethod p : this.pMethodList) {
/* 5615 */       p.setOrder(order);
/* 5616 */       pDAO.savePaymentMethod(p);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void emptySellPoint() {
/* 5622 */     this.qtyTextSellPoint.setText((String)null);
/*      */     
/* 5624 */     this.totalToPay.setText((String)null);
/* 5625 */     this.discountPointSell.setText((String)null);
/* 5626 */     this.moneyPaid.setText((String)null);
/* 5627 */     this.changeMoney.setText((String)null);
/*      */ 
/*      */     
/* 5630 */     this.discountPointSell.setEnabled(false);
/* 5631 */     this.newTotalBtn.setEnabled(false);
/* 5632 */     this.moneyPaid.setEnabled(false);
/* 5633 */     this.methodPayment.setEnabled(false);
/* 5634 */     this.subMethodPaymentPOS.setEnabled(false);
/* 5635 */     this.addPaymentPSBtn.setEnabled(false);
/* 5636 */     this.generateBill.setEnabled(false);
/*      */     
/* 5638 */     this.comercialNamePointSell.setEnabled(true);
/* 5639 */     this.comercialNamePointSell.setText((String)null);
/* 5640 */     this.barCodePointSell.setEnabled(true);
/* 5641 */     this.barCodePointSell.setText((String)null);
/* 5642 */     this.qtyTextSellPoint.setEnabled(true);
/* 5643 */     this.qtyTextSellPoint.setText((String)null);
/* 5644 */     this.addDrugBuyList.setEnabled(true);
/*      */     
/* 5646 */     this.submitDrugsSellPoint.setEnabled(true);
/* 5647 */     DefaultTableModel tableModel = (DefaultTableModel)this.buyListTb.getModel();
/* 5648 */     tableModel.setNumRows(0);
/* 5649 */     this.discount = 0.0D;
/* 5650 */     this.total = 0.0D;
/* 5651 */     this.changeMoneyF = 0.0D;
/* 5652 */     this.orderSelldetails.clear();
/* 5653 */     this.pMethodList.clear();
/*      */   }
/*      */ 
/*      */   
/*      */   public void printReceipt() {
/* 5658 */     DefaultTableModel jmodel = new DefaultTableModel();
/*      */     
/* 5660 */     CompanyDAO cd = new CompanyDAO();
/* 5661 */     Company cp = cd.returnCompany();
/*      */ 
/*      */ 
/*      */     
/* 5665 */     jmodel = (DefaultTableModel)this.buyListTb.getModel();
/*      */     
/* 5667 */     Print_reciept printR = new Print_reciept();
/* 5668 */     printR.jTextArea1.setText("               *** RECIBO DE COMPRA ***            \n              " + cp
/* 5669 */         .getName() + "              \n                       " + cp
/* 5670 */         .getAddress() + "                       \n                           NUIT 400890625\n                            Tel: " + cp
/*      */ 
/*      */ 
/*      */         
/* 5674 */         .getTelephone() + "\nE-mail: " + cp
/* 5675 */         .getEmail() + "\n\n-------------------------------------------------------\nDATA:\t                             " + 
/*      */         
/* 5677 */         getActualDate() + "\nFATURA N°:\t                             " + 
/* 5678 */         String.valueOf(this.orderIdGeneral) + "\n-------------------------------------------------------\n");
/*      */     
/* 5680 */     printR.jTextArea1.setText(printR.jTextArea1.getText() + "                                   ITEMS:\n");
/* 5681 */     DrugDAO ddao = new DrugDAO();
/* 5682 */     for (int i = 0; i < jmodel.getRowCount(); i++) {
/*      */       
/* 5684 */       Drug drug = ddao.getDrugsByGenericName((String)jmodel.getValueAt(i, 0));
/*      */       
/* 5686 */       double item_qty = ((Double)jmodel.getValueAt(i, 1)).doubleValue();
/* 5687 */       System.out.println(item_qty);
/*      */       
/* 5689 */       int item_qty_int = (int)item_qty;
/* 5690 */       String item_total = String.valueOf(jmodel.getValueAt(i, 3));
/* 5691 */       System.out.println(item_qty_int);
/*      */ 
/*      */       
/* 5694 */       printR.jTextArea1.setText(printR.jTextArea1.getText() + String.valueOf(item_qty_int) + " x " + drug.getComercial_name() + " ...... " + item_total + " MTN\n");
/*      */     } 
/* 5696 */     printR.jTextArea1.setText(printR.jTextArea1.getText() + "_________________________________\n");
/* 5697 */     printR.jTextArea1.setText(printR.jTextArea1.getText() + "TOTAL............................... " + String.valueOf(this.total) + " MTN\n");
/* 5698 */     printR.jTextArea1.setText(printR.jTextArea1.getText() + "DESCONTO......................... " + String.valueOf(this.discount) + " %\n");
/* 5699 */     printR.jTextArea1.setText(printR.jTextArea1.getText() + "RETORNO........................... " + String.valueOf(this.changeMoneyF) + " MTN\n");
/* 5700 */     printR.jTextArea1.setText(printR.jTextArea1.getText() + "-------------------------------------------------------\n\n");
/*      */     
/* 5702 */     printR.jTextArea1.setText(printR.jTextArea1.getText() + "                  Melhoras e Volte Sempre\n");
/* 5703 */     printR.jTextArea1.setText(printR.jTextArea1.getText() + "     *** SERVINDO COM DINAMISMO ***\n");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5708 */     printR.setVisible(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void generateBillActionPerformed(ActionEvent evt) {
/* 5715 */     if (this.changeMoney.getText().trim().isEmpty() || this.totalToPay.getText().trim().isEmpty()) {
/* 5716 */       JOptionPane.showMessageDialog(this, "Informe os Dados Em Falta");
/* 5717 */     } else if (Double.parseDouble(this.totalToPay.getText()) > 0.0D) {
/* 5718 */       JOptionPane.showMessageDialog(this, "Pague o Valor Remanescente");
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */ 
/*      */       
/* 5727 */       UserDAO ud = new UserDAO();
/*      */       
/* 5729 */       User atualUser = this.loggedUser;
/* 5730 */       this.changeMoneyF = Double.parseDouble(this.changeMoney.getText());
/*      */       
/* 5732 */       Order order = new Order();
/* 5733 */       order.setUser(atualUser);
/* 5734 */       order.setDate(getActualDate());
/* 5735 */       order.setTotal_paid(getTotalPaid());
/* 5736 */       order.setBill_money(getTotalPaid() - this.changeMoneyF);
/* 5737 */       order.setDiscount(this.discount);
/* 5738 */       order.setReturn_money(this.changeMoneyF);
/*      */       
/* 5740 */       OrderDAO orderDAO = new OrderDAO();
/*      */ 
/*      */       
/* 5743 */       boolean result = deductFromSttock();
/* 5744 */       if (result == true) {
/* 5745 */         orderDAO.saveOrder(order);
/*      */         
/* 5747 */         int order_id = orderDAO.lastAddedOrderId();
/* 5748 */         this.orderIdGeneral = order_id;
/* 5749 */         order.setOrder_id(order_id);
/*      */         
/* 5751 */         setOrderDetails(order);
/* 5752 */         printReceipt();
/*      */ 
/*      */ 
/*      */         
/* 5756 */         setPaymentMethods(order);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 5762 */         readTableStock();
/* 5763 */         emptySellPoint();
/* 5764 */         readOrdersTable();
/*      */         
/* 5766 */         int nextBillNr = order_id + 1;
/* 5767 */         this.Bill_nr.setText(String.valueOf(nextBillNr));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void TotalMoneyPeriodActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 5780 */     String billNumber = this.billNrSearch.getText();
/* 5781 */     if (!billNumber.isEmpty()) {
/* 5782 */       searchByBillNr(billNumber);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 5788 */     String initDate = ((JTextField)this.initDateField.getDateEditor().getUiComponent()).getText();
/*      */     
/* 5790 */     String finalDate = ((JTextField)this.finalDateField.getDateEditor().getUiComponent()).getText();
/*      */     
/* 5792 */     if (!initDate.isEmpty() && !finalDate.isEmpty()) {
/* 5793 */       searchBySeller((String)null);
/* 5794 */       searchByBillNr((String)null);
/* 5795 */       readOrdersTableSearch(initDate, finalDate);
/* 5796 */       setOrderPaymentAndDetailsEmpty();
/*      */     } else {
/* 5798 */       JOptionPane.showMessageDialog(null, "Informe a data em vazio", "Campo Vazio", 2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 5805 */     setOrderPaymentAndDetailsEmpty();
/* 5806 */     searchBySeller((String)null);
/* 5807 */     searchByBillNr((String)null);
/* 5808 */     readAllOrders();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 5813 */     if (this.ordersTableList.getSelectedRow() != -1) {
/* 5814 */       int order_id = ((Integer)this.ordersTableList.getValueAt(this.ordersTableList.getSelectedRow(), 0)).intValue();
/* 5815 */       boolean result = false;
/* 5816 */       OrderReadyDAO orderRDAO = new OrderReadyDAO();
/* 5817 */       for (OrderReady or : orderRDAO.returnAllOrder()) {
/*      */ 
/*      */         
/* 5820 */         if (or.getBill_nr() == order_id)
/*      */         {
/* 5822 */           result = orderRDAO.removeOrderReady(or);
/*      */         }
/*      */       } 
/*      */       
/* 5826 */       if (result == true) {
/* 5827 */         JOptionPane.showMessageDialog(null, "Removido com Sucesso");
/* 5828 */         readTableStock();
/* 5829 */         readOrdersTable();
/* 5830 */         setOrderPaymentAndDetailsEmpty();
/*      */       }
/*      */       else {
/*      */         
/* 5834 */         JOptionPane.showMessageDialog(null, "Falha ao Remover");
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 5839 */       JOptionPane.showMessageDialog(this, "Selecione Produto!");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void nComercialEditActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel2MouseClicked(MouseEvent evt) {
/* 5850 */     this.jPanel8.setBackground(Color.red);
/* 5851 */     this.jPanel30.setBackground(new Color(0, 153, 153));
/* 5852 */     this.jPanel31.setBackground(new Color(0, 153, 153));
/*      */     
/* 5854 */     CardLayout c2 = (CardLayout)this.jPanel22.getLayout();
/* 5855 */     c2.show(this.jPanel22, "modificarStockAdicionar");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel2MouseEntered(MouseEvent evt) {
/* 5861 */     this.jPanel8.setCursor(new Cursor(12));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel20MouseClicked(MouseEvent evt) {
/* 5866 */     this.jPanel8.setBackground(new Color(0, 153, 153));
/* 5867 */     this.jPanel30.setBackground(Color.red);
/* 5868 */     this.jPanel31.setBackground(new Color(0, 153, 153));
/*      */     
/* 5870 */     CardLayout c2 = (CardLayout)this.jPanel22.getLayout();
/* 5871 */     c2.show(this.jPanel22, "modificarStockEditar");
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel20MouseEntered(MouseEvent evt) {
/* 5876 */     this.jPanel30.setCursor(new Cursor(12));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel21MouseClicked(MouseEvent evt) {
/* 5881 */     this.jPanel8.setBackground(new Color(0, 153, 153));
/* 5882 */     this.jPanel30.setBackground(new Color(0, 153, 153));
/* 5883 */     this.jPanel31.setBackground(Color.red);
/*      */     
/* 5885 */     CardLayout c2 = (CardLayout)this.jPanel22.getLayout();
/* 5886 */     c2.show(this.jPanel22, "modificarStockRemover");
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel21MouseEntered(MouseEvent evt) {
/* 5891 */     this.jPanel31.setCursor(new Cursor(12));
/*      */   }
/*      */ 
/*      */   
/*      */   private void nComercialRemoveActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void emptyRemove() {
/* 5898 */     this.nComercialEdit.setEditable(true);
/* 5899 */     this.barCodeEdit.setEditable(true);
/* 5900 */     this.barCodeEditTA.setEnabled(false);
/* 5901 */     this.barCodeEditTA.setText("");
/*      */     
/* 5903 */     this.genericNameEditTA.setEnabled(false);
/* 5904 */     this.genericNameEditTA.setText("");
/*      */     
/* 5906 */     this.comercialNameEditTA.setEnabled(false);
/* 5907 */     this.comercialNameEditTA.setText("");
/*      */     
/* 5909 */     this.batchNrEdit.setEnabled(false);
/* 5910 */     this.batchNrEdit.setText("");
/*      */     
/* 5912 */     this.categoryEdit.setEnabled(false);
/*      */     
/* 5914 */     this.qtyEditTA.setEnabled(false);
/* 5915 */     this.qtyEditTA.setText("");
/*      */     
/* 5917 */     this.unitEdit.setEnabled(false);
/* 5918 */     this.unitEdit.setText("");
/*      */     
/* 5920 */     this.manufacturerEdit.setEnabled(false);
/* 5921 */     this.manufacturerEdit.setText("");
/*      */     
/* 5923 */     this.supplierEdit.setEnabled(false);
/* 5924 */     this.supplierEdit.setText("");
/*      */     
/* 5926 */     this.entryDateEdit.setEnabled(false);
/* 5927 */     this.entryDateEdit.setDate(null);
/*      */     
/* 5929 */     this.expireDateEdit.setEnabled(false);
/* 5930 */     this.expireDateEdit.setDate(null);
/*      */     
/* 5932 */     this.sellPriceEdit.setEnabled(false);
/* 5933 */     this.sellPriceEdit.setText("");
/*      */     
/* 5935 */     this.buyPriceEdit.setEnabled(false);
/* 5936 */     this.buyPriceEdit.setText("");
/*      */   }
/*      */   
/*      */   private void emptyEdit() {
/* 5940 */     this.nameEdit.setEnabled(false);
/* 5941 */     this.nameEdit.setText((String)null);
/*      */     
/* 5943 */     this.ageEdit.setEnabled(false);
/* 5944 */     this.ageEdit.setDate(null);
/*      */     
/* 5946 */     this.genderEdit.setEnabled(false);
/* 5947 */     this.genderEdit.setSelectedItem((Object)null);
/*      */     
/* 5949 */     this.salaryEdit.setEnabled(false);
/* 5950 */     this.salaryEdit.setText((String)null);
/*      */     
/* 5952 */     this.maritalStatusEdit.setEnabled(false);
/* 5953 */     this.maritalStatusEdit.setSelectedItem((Object)null);
/*      */     
/* 5955 */     this.addressEdit.setEnabled(false);
/* 5956 */     this.addressEdit.setText((String)null);
/*      */     
/* 5958 */     this.telephoneEdit.setEnabled(false);
/* 5959 */     this.telephoneEdit.setText((String)null);
/*      */     
/* 5961 */     this.academicEdit.setEnabled(false);
/* 5962 */     this.academicEdit.setText((String)null);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 5967 */     emptyRemove();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel13MouseClicked(MouseEvent evt) {
/* 5972 */     this.jPanel40.setBackground(Color.red);
/* 5973 */     this.jPanel41.setBackground(new Color(0, 153, 153));
/* 5974 */     this.jPanel42.setBackground(new Color(0, 153, 153));
/*      */     
/* 5976 */     CardLayout c2 = (CardLayout)this.jPanel43.getLayout();
/* 5977 */     c2.show(this.jPanel43, "modificarFuncionarioAdicionar");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel13MouseEntered(MouseEvent evt) {
/* 5983 */     this.jPanel40.setCursor(new Cursor(12));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel30MouseClicked(MouseEvent evt) {
/* 5988 */     this.jPanel40.setBackground(new Color(0, 153, 153));
/* 5989 */     this.jPanel41.setBackground(Color.red);
/* 5990 */     this.jPanel42.setBackground(new Color(0, 153, 153));
/*      */     
/* 5992 */     CardLayout c2 = (CardLayout)this.jPanel43.getLayout();
/* 5993 */     c2.show(this.jPanel43, "modificarFuncionarioEditar");
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel30MouseEntered(MouseEvent evt) {
/* 5998 */     this.jPanel41.setCursor(new Cursor(12));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel31MouseClicked(MouseEvent evt) {
/* 6004 */     this.jPanel40.setBackground(new Color(0, 153, 153));
/* 6005 */     this.jPanel41.setBackground(new Color(0, 153, 153));
/* 6006 */     this.jPanel42.setBackground(Color.red);
/*      */     
/* 6008 */     CardLayout c2 = (CardLayout)this.jPanel43.getLayout();
/* 6009 */     c2.show(this.jPanel43, "modificarFuncionarioRemover");
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel31MouseEntered(MouseEvent evt) {
/* 6014 */     this.jPanel42.setCursor(new Cursor(12));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton29ActionPerformed(ActionEvent evt) {
/* 6020 */     emptyEdit();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton33ActionPerformed(ActionEvent evt) {
/* 6025 */     if (!this.nameRemove.getText().trim().isEmpty()) {
/* 6026 */       User user = (User)this.comboBoxListRemove.getSelectedItem();
/* 6027 */       int user_id = user.getUser_id();
/* 6028 */       UserDAO udao = new UserDAO();
/* 6029 */       udao.deleteByUserId(user_id);
/* 6030 */       JOptionPane.showMessageDialog(null, "Usuário Eliminado com Sucesso");
/* 6031 */       readComboUser();
/* 6032 */       readUserTable();
/*      */       
/* 6034 */       this.nameRemove.setText((String)null);
/* 6035 */       this.genderRemove.setEnabled(false);
/* 6036 */       this.ageRemove.setDate(null);
/* 6037 */       this.academicRemove.setText((String)null);
/* 6038 */       this.salaryRemove.setText((String)null);
/* 6039 */       this.telephoneRemove.setText((String)null);
/* 6040 */       this.marital_statusRemove.setEnabled(false);
/* 6041 */       this.addressRemove.setText((String)null);
/*      */     } else {
/*      */       
/* 6044 */       JOptionPane.showMessageDialog(null, "Nenhum Usuário Selecionado");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void nameEditActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void qtyTextSellPointKeyPressed(KeyEvent evt) {
/* 6054 */     char c = evt.getKeyChar();
/* 6055 */     if (c >= '0' && c <= '9') {
/* 6056 */       this.qtyTextSellPoint.setEditable(true);
/* 6057 */       this.addDrugSellPoint.setEnabled(true);
/*      */     }
/* 6059 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 6060 */       .getExtendedKeyCode() == 127 || evt
/* 6061 */       .getExtendedKeyCode() == 38 || evt
/* 6062 */       .getExtendedKeyCode() == 40) {
/* 6063 */       this.qtyTextSellPoint.setEditable(true);
/*      */     } else {
/*      */       
/* 6066 */       this.qtyTextSellPoint.setEditable(false);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 6071 */     if (evt.getKeyCode() == 40) {
/* 6072 */       this.comercialNamePointSell.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void qtyTextSellPointKeyReleased(KeyEvent evt) {
/* 6078 */     if (this.qtyTextSellPoint.getText().isEmpty()) {
/* 6079 */       this.qtyTextSellPoint.setEditable(false);
/* 6080 */       this.addDrugSellPoint.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   private void addDrug() {
/* 6084 */     if (this.comercialNamePointSell.getText().trim().isEmpty() && this.barCodePointSell
/* 6085 */       .getText().trim().isEmpty()) {
/* 6086 */       JOptionPane.showMessageDialog(null, "Informe o Nome Genérico ou o Código de Barras do Medicamento", "Campo Vazio", 2);
/*      */     
/*      */     }
/* 6089 */     else if (!this.comercialNamePointSell.getText().trim().isEmpty()) {
/*      */       
/* 6091 */       double quantity = Double.parseDouble(this.qtyTextSellPoint.getText());
/* 6092 */       String comercial_name = this.comercialNamePointSell.getText();
/*      */       
/* 6094 */       Drug checkDrug = new Drug();
/* 6095 */       checkDrug.setComercial_name(comercial_name);
/* 6096 */       DrugDAO dd = new DrugDAO();
/* 6097 */       boolean result = dd.checkDrugByComercialName(checkDrug);
/*      */       
/* 6099 */       if (result == true) {
/*      */ 
/*      */         
/* 6102 */         StockDAO sd = new StockDAO();
/*      */ 
/*      */ 
/*      */         
/* 6106 */         Drug d = dd.getDrugsByComercialName(comercial_name);
/* 6107 */         Stock st = sd.returnStockByDrugId(d);
/*      */         
/* 6109 */         boolean validate_qty = checkQuantity(st.getStock_id(), quantity);
/*      */         
/* 6111 */         if (validate_qty == true) {
/* 6112 */           OrderDetails od = new OrderDetails();
/*      */           
/* 6114 */           st.getUni_sell_price();
/*      */           
/* 6116 */           double total_price = st.getUni_sell_price() * quantity;
/*      */           
/* 6118 */           od.setQuantity(quantity);
/* 6119 */           od.setDrug(d);
/* 6120 */           od.setTotal_price(total_price);
/*      */           
/* 6122 */           this.orderSelldetails.add(od);
/*      */           
/* 6124 */           DefaultTableModel df = (DefaultTableModel)this.buyListTb.getModel();
/* 6125 */           df.addRow(new Object[] { od
/*      */                 
/* 6127 */                 .getDrug().getGeneric_name(), 
/* 6128 */                 Double.valueOf(od.getQuantity()), 
/* 6129 */                 Double.valueOf(st.getUni_sell_price()), 
/* 6130 */                 Double.valueOf(total_price) });
/*      */ 
/*      */           
/* 6133 */           this.comercialNamePointSell.setText((String)null);
/* 6134 */           this.barCodePointSell.setText((String)null);
/* 6135 */           this.comercialNamePointSell.setEnabled(true);
/* 6136 */           this.barCodePointSell.setEnabled(true);
/*      */         } else {
/* 6138 */           JOptionPane.showMessageDialog(null, "Quantidade do Medicamento em Stock Insuficiente!");
/*      */         } 
/*      */       } else {
/* 6141 */         JOptionPane.showMessageDialog(null, "Medicamento não Existe!", "Erro", 2);
/*      */       }
/*      */     
/* 6144 */     } else if (!this.barCodePointSell.getText().trim().isEmpty()) {
/* 6145 */       double quantity = Double.parseDouble(this.qtyTextSellPoint.getText());
/* 6146 */       String code_bar = this.barCodePointSell.getText();
/*      */       
/* 6148 */       DrugDAO dd = new DrugDAO();
/* 6149 */       boolean result = dd.checkDrugByBarCode(code_bar);
/*      */       
/* 6151 */       if (result == true) {
/* 6152 */         StockDAO sd = new StockDAO();
/*      */         
/* 6154 */         OrderDetails od = new OrderDetails();
/*      */         
/* 6156 */         Drug d = dd.getDrugByBarCode(code_bar);
/* 6157 */         Stock st = sd.returnStockByDrugId(d);
/*      */         
/* 6159 */         st.getUni_sell_price();
/*      */         
/* 6161 */         double total_price = st.getUni_sell_price() * quantity;
/*      */         
/* 6163 */         od.setQuantity(quantity);
/* 6164 */         od.setDrug(d);
/* 6165 */         od.setTotal_price(total_price);
/*      */         
/* 6167 */         this.orderSelldetails.add(od);
/*      */         
/* 6169 */         DefaultTableModel df = (DefaultTableModel)this.buyListTb.getModel();
/* 6170 */         df.addRow(new Object[] { od
/*      */               
/* 6172 */               .getDrug().getGeneric_name(), 
/* 6173 */               Double.valueOf(od.getQuantity()), 
/* 6174 */               Double.valueOf(st.getUni_sell_price()), 
/* 6175 */               Double.valueOf(total_price) });
/*      */ 
/*      */         
/* 6178 */         this.comercialNamePointSell.setText((String)null);
/* 6179 */         this.barCodePointSell.setText((String)null);
/* 6180 */         this.comercialNamePointSell.setEnabled(true);
/* 6181 */         this.barCodePointSell.setEnabled(true);
/*      */       } else {
/*      */         
/* 6184 */         JOptionPane.showMessageDialog(null, "Medicamento não Existe!", "Erro", 2);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void addDrugSellPointActionPerformed(ActionEvent evt) {
/* 6192 */     addDrug();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void discountPointSellKeyPressed(KeyEvent evt) {
/* 6200 */     char c = evt.getKeyChar();
/* 6201 */     if (c >= '0' && c <= '9') {
/* 6202 */       this.discountPointSell.setEditable(true);
/* 6203 */       this.newTotalBtn.setEnabled(true);
/*      */     }
/* 6205 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 6206 */       .getExtendedKeyCode() == 127) {
/* 6207 */       this.discountPointSell.setEditable(true);
/* 6208 */       this.newTotalBtn.setEnabled(true);
/*      */     }
/*      */     else {
/*      */       
/* 6212 */       this.discountPointSell.setEditable(false);
/* 6213 */       this.newTotalBtn.setEnabled(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void discountPointSellKeyReleased(KeyEvent evt) {
/* 6221 */     if (this.discountPointSell.getText().isEmpty()) {
/* 6222 */       this.discountPointSell.setEditable(false);
/* 6223 */       this.newTotalBtn.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void newTotalBtnActionPerformed(ActionEvent evt) {
/* 6228 */     if (Double.parseDouble(this.discountPointSell.getText()) > 100.0D) {
/* 6229 */       JOptionPane.showMessageDialog(this, "Desconto deve ser Menor ou Igual a 100%", "Erro Desconto", 2);
/*      */     } else {
/* 6231 */       double total = Double.parseDouble(this.totalToPay.getText());
/* 6232 */       double discountPS = Double.parseDouble(this.discountPointSell.getText());
/* 6233 */       double discountMoney = total * discountPS / 100.0D;
/* 6234 */       double newTotal = total - discountMoney;
/* 6235 */       this.totalToPay.setText(String.valueOf(newTotal));
/*      */ 
/*      */       
/* 6238 */       this.discount = discountPS;
/*      */       
/* 6240 */       this.discountPointSell.setText("");
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void addPaymentPSBtnActionPerformed(ActionEvent evt) {
/* 6246 */     if (this.moneyPaid.getText().trim().isEmpty() || this.methodPayment
/* 6247 */       .getSelectedItem().toString().isEmpty() || this.methodPayment
/* 6248 */       .getSelectedItem().toString() == "__Selecione") {
/* 6249 */       JOptionPane.showMessageDialog(this, "Informe o Valor Pago e o metodo", "Campos Vazios", 2);
/*      */     }
/*      */     else {
/*      */       
/* 6253 */       PaymentMethod pMethod = new PaymentMethod();
/* 6254 */       pMethod.setMethod(this.methodPayment.getSelectedItem().toString());
/* 6255 */       if (this.methodPayment.getSelectedItem().toString().equals("POS")) {
/* 6256 */         pMethod.setSub_method(this.subMethodPaymentPOS.getSelectedItem().toString());
/*      */       } else {
/* 6258 */         pMethod.setSub_method("N/A");
/*      */       } 
/* 6260 */       pMethod.setMoney_paid(Double.parseDouble(this.moneyPaid.getText()));
/* 6261 */       this.pMethodList.add(pMethod);
/*      */ 
/*      */ 
/*      */       
/* 6265 */       double totalTPay = Double.parseDouble(this.totalToPay.getText());
/* 6266 */       double changeMoneyA = totalTPay - Double.parseDouble(this.moneyPaid.getText());
/*      */       
/* 6268 */       if (changeMoneyA < 0.0D) {
/* 6269 */         this.changeMoney.setText(String.valueOf(Double.parseDouble(this.moneyPaid.getText()) - totalTPay));
/* 6270 */         this.totalToPay.setText("0");
/* 6271 */         this.moneyPaid.setEnabled(false);
/*      */       
/*      */       }
/*      */       else {
/*      */         
/* 6276 */         this.totalToPay.setText(String.valueOf(changeMoneyA));
/* 6277 */         this.changeMoney.setText("0");
/*      */       } 
/* 6279 */       this.moneyPaid.setText((String)null);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void methodPaymentActionPerformed(ActionEvent evt) {
/* 6285 */     String[] subItems1 = { "Millennium Bim", "BCI", "MOZABANCO", "Ecobank", "ABSA", "Banc ABC", "UNICO", "FNB", "Fist Capital", "Standard Bank", "UBA", "Outro" };
/*      */ 
/*      */     
/* 6288 */     String item = (String)this.methodPayment.getSelectedItem();
/* 6289 */     if (item == "POS") {
/* 6290 */       this.subMethodPaymentPOS.setModel(new DefaultComboBoxModel<>(subItems1));
/*      */     } else {
/* 6292 */       this.subMethodPaymentPOS.setModel(new DefaultComboBoxModel<>());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void moneyPaidKeyPressed(KeyEvent evt) {
/* 6298 */     char c = evt.getKeyChar();
/* 6299 */     if (c >= '0' && c <= '9') {
/* 6300 */       this.moneyPaid.setEditable(true);
/* 6301 */       this.addPaymentPSBtn.setEnabled(true);
/*      */     }
/* 6303 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 6304 */       .getExtendedKeyCode() == 127 || evt
/* 6305 */       .getExtendedKeyCode() == 46) {
/* 6306 */       this.moneyPaid.setEditable(true);
/* 6307 */       this.addPaymentPSBtn.setEnabled(true);
/*      */     }
/*      */     else {
/*      */       
/* 6311 */       this.moneyPaid.setEditable(false);
/* 6312 */       this.addPaymentPSBtn.setEnabled(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void moneyPaidKeyReleased(KeyEvent evt) {
/* 6319 */     if (this.moneyPaid.getText().isEmpty()) {
/* 6320 */       this.moneyPaid.setEditable(false);
/* 6321 */       this.addPaymentPSBtn.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void batchNrSaveKeyPressed(KeyEvent evt) {
/* 6326 */     char c = evt.getKeyChar();
/* 6327 */     if (c >= '0' && c <= '9') {
/* 6328 */       this.batchNrSave.setEditable(true);
/*      */     }
/* 6330 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 6331 */       .getExtendedKeyCode() == 127) {
/* 6332 */       this.batchNrSave.setEditable(true);
/*      */     } else {
/* 6334 */       this.batchNrSave.setEditable(false);
/*      */     } 
/*      */ 
/*      */     
/* 6338 */     if (evt.getKeyCode() == 40)
/* 6339 */       this.categSave.requestFocus(true); 
/* 6340 */     if (evt.getKeyCode() == 38) {
/* 6341 */       this.comercialNameSave.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void qtySaveKeyPressed(KeyEvent evt) {
/* 6347 */     char c = evt.getKeyChar();
/* 6348 */     if (c >= '0' && c <= '9') {
/* 6349 */       this.qtySave.setEditable(true);
/*      */     }
/* 6351 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 6352 */       .getExtendedKeyCode() == 127 || evt
/* 6353 */       .getExtendedKeyCode() == 46) {
/* 6354 */       this.qtySave.setEditable(true);
/*      */     } else {
/* 6356 */       this.qtySave.setEditable(false);
/*      */     } 
/*      */ 
/*      */     
/* 6360 */     if (evt.getKeyCode() == 40)
/* 6361 */       this.unitSave.requestFocus(true); 
/* 6362 */     if (evt.getKeyCode() == 38) {
/* 6363 */       this.categSave.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void prVendaSaveKeyPressed(KeyEvent evt) {
/* 6369 */     char c = evt.getKeyChar();
/* 6370 */     if (c >= '0' && c <= '9') {
/* 6371 */       this.prVendaSave.setEditable(true);
/*      */     }
/* 6373 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 6374 */       .getExtendedKeyCode() == 127 || evt
/* 6375 */       .getExtendedKeyCode() == 46) {
/* 6376 */       this.prVendaSave.setEditable(true);
/*      */     } else {
/* 6378 */       this.prVendaSave.setEditable(false);
/*      */     } 
/*      */ 
/*      */     
/* 6382 */     if (evt.getKeyCode() == 40)
/* 6383 */       this.prCompraSave.requestFocus(true); 
/* 6384 */     if (evt.getKeyCode() == 38) {
/* 6385 */       this.expireDateSave.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void prCompraSaveKeyPressed(KeyEvent evt) {
/* 6391 */     char c = evt.getKeyChar();
/* 6392 */     if (c >= '0' && c <= '9') {
/* 6393 */       this.prCompraSave.setEditable(true);
/*      */     }
/* 6395 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 6396 */       .getExtendedKeyCode() == 127 || evt
/* 6397 */       .getExtendedKeyCode() == 46) {
/* 6398 */       this.prCompraSave.setEditable(true);
/*      */     } else {
/* 6400 */       this.prCompraSave.setEditable(false);
/*      */     } 
/*      */ 
/*      */     
/* 6404 */     if (evt.getKeyCode() == 38) {
/* 6405 */       this.prVendaSave.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void batchNrEditKeyPressed(KeyEvent evt) {
/* 6411 */     char c = evt.getKeyChar();
/* 6412 */     if (c >= '0' && c <= '9') {
/* 6413 */       this.batchNrEdit.setEditable(true);
/*      */     }
/* 6415 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 6416 */       .getExtendedKeyCode() == 127) {
/* 6417 */       this.batchNrEdit.setEditable(true);
/*      */     } else {
/* 6419 */       this.batchNrEdit.setEditable(false);
/*      */     } 
/*      */     
/* 6422 */     if (evt.getKeyCode() == 40)
/* 6423 */       this.categoryEdit.requestFocus(true); 
/* 6424 */     if (evt.getKeyCode() == 38) {
/* 6425 */       this.comercialNameEditTA.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void qtyEditTAKeyPressed(KeyEvent evt) {
/* 6431 */     char c = evt.getKeyChar();
/* 6432 */     if (c >= '0' && c <= '9') {
/* 6433 */       this.qtySave.setEditable(true);
/*      */     }
/* 6435 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 6436 */       .getExtendedKeyCode() == 127) {
/* 6437 */       this.qtySave.setEditable(true);
/*      */     } else {
/* 6439 */       this.qtySave.setEditable(false);
/*      */     } 
/*      */     
/* 6442 */     if (evt.getKeyCode() == 40)
/* 6443 */       this.unitEdit.requestFocus(true); 
/* 6444 */     if (evt.getKeyCode() == 38) {
/* 6445 */       this.categoryEdit.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void sellPriceEditKeyPressed(KeyEvent evt) {
/* 6451 */     char c = evt.getKeyChar();
/* 6452 */     if (c >= '0' && c <= '9') {
/* 6453 */       this.sellPriceEdit.setEditable(true);
/*      */     }
/* 6455 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 6456 */       .getExtendedKeyCode() == 127 || evt
/* 6457 */       .getExtendedKeyCode() == 46) {
/* 6458 */       this.sellPriceEdit.setEditable(true);
/*      */     } else {
/* 6460 */       this.sellPriceEdit.setEditable(false);
/*      */     } 
/*      */ 
/*      */     
/* 6464 */     if (evt.getKeyCode() == 40)
/* 6465 */       this.buyPriceEdit.requestFocus(true); 
/* 6466 */     if (evt.getKeyCode() == 38) {
/* 6467 */       this.expireDateEdit.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void buyPriceEditKeyPressed(KeyEvent evt) {
/* 6473 */     char c = evt.getKeyChar();
/* 6474 */     if (c >= '0' && c <= '9') {
/* 6475 */       this.buyPriceEdit.setEditable(true);
/*      */     }
/* 6477 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 6478 */       .getExtendedKeyCode() == 127 || evt
/* 6479 */       .getExtendedKeyCode() == 46) {
/*      */       
/* 6481 */       this.buyPriceEdit.setEditable(true);
/*      */     } else {
/* 6483 */       this.buyPriceEdit.setEditable(false);
/*      */     } 
/*      */     
/* 6486 */     if (evt.getKeyCode() == 38) {
/* 6487 */       this.sellPriceEdit.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void qtyRemoveKeyPressed(KeyEvent evt) {
/* 6493 */     char c = evt.getKeyChar();
/* 6494 */     if (c >= '0' && c <= '9') {
/* 6495 */       this.qtyRemove.setEditable(true);
/*      */     }
/* 6497 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 6498 */       .getExtendedKeyCode() == 127) {
/*      */       
/* 6500 */       this.qtyRemove.setEditable(true);
/*      */     } else {
/* 6502 */       this.qtyRemove.setEditable(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void sellPriceRemoveKeyPressed(KeyEvent evt) {
/* 6509 */     char c = evt.getKeyChar();
/* 6510 */     if (c >= '0' && c <= '9') {
/* 6511 */       this.sellPriceRemove.setEditable(true);
/*      */     }
/* 6513 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 6514 */       .getExtendedKeyCode() == 127 || evt
/* 6515 */       .getExtendedKeyCode() == 46) {
/*      */       
/* 6517 */       this.sellPriceRemove.setEditable(true);
/*      */     } else {
/* 6519 */       this.sellPriceRemove.setEditable(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void buyPriceRemoveKeyPressed(KeyEvent evt) {
/* 6526 */     char c = evt.getKeyChar();
/* 6527 */     if (c >= '0' && c <= '9') {
/* 6528 */       this.buyPriceRemove.setEditable(true);
/*      */     }
/* 6530 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 6531 */       .getExtendedKeyCode() == 127 || evt
/* 6532 */       .getExtendedKeyCode() == 46) {
/*      */       
/* 6534 */       this.buyPriceRemove.setEditable(true);
/*      */     } else {
/* 6536 */       this.buyPriceRemove.setEditable(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void nComercialRemoveKeyPressed(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void barCodeSearchKeyPressed(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private ArrayList getSuggestionsOfCommercialNames() {
/* 6552 */     ArrayList<String> suggestions = new ArrayList<>();
/* 6553 */     DrugDAO dd = new DrugDAO();
/* 6554 */     for (Drug d : dd.returnAllDrugs()) {
/* 6555 */       suggestions.add(d.getComercial_name().toLowerCase());
/*      */     }
/*      */     
/* 6558 */     for (String dn : suggestions) {
/* 6559 */       this.defaultListModel.addElement(dn);
/*      */     }
/* 6561 */     this.listOfSuggestions.setModel(this.defaultListModel);
/* 6562 */     this.listOfSuggestions.setSelectionMode(0);
/*      */     
/* 6564 */     this.listOfSuggestionsRemove.setModel(this.defaultListModel);
/* 6565 */     this.listOfSuggestionsRemove.setSelectionMode(0);
/*      */     
/* 6567 */     this.listOfSuggestionsStock.setModel(this.defaultListModel);
/* 6568 */     this.listOfSuggestionsStock.setSelectionMode(0);
/*      */     
/* 6570 */     this.listOfSuggestionsSell.setModel(this.defaultListModel);
/* 6571 */     this.listOfSuggestionsSell.setSelectionMode(0);
/*      */     
/* 6573 */     return suggestions;
/*      */   }
/*      */   
/*      */   private void reurnSuggestionPopUp(String text) {
/* 6577 */     DefaultListModel<String> dlmsuggestion = new DefaultListModel();
/* 6578 */     ArrayList<String> drugNames = getSuggestionsOfCommercialNames();
/*      */     
/* 6580 */     for (String drugName : drugNames) {
/* 6581 */       String startName = drugName.toLowerCase();
/* 6582 */       if (startName.contains(text.toLowerCase())) {
/* 6583 */         dlmsuggestion.addElement(startName);
/*      */       }
/*      */     } 
/* 6586 */     this.defaultListModel.clear();
/* 6587 */     this.defaultListModel = dlmsuggestion;
/* 6588 */     if (!this.defaultListModel.isEmpty()) {
/* 6589 */       this.listOfSuggestions.setModel(this.defaultListModel);
/* 6590 */       this.suggestionsPopUp.show(this.nComercialEdit, 0, this.nComercialEdit.getHeight());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void returnSuggestionPopUpRemove(String text) {
/* 6595 */     DefaultListModel<String> dlmsuggestion = new DefaultListModel();
/* 6596 */     ArrayList<String> drugNames = getSuggestionsOfCommercialNames();
/*      */     
/* 6598 */     for (String drugName : drugNames) {
/* 6599 */       String startName = drugName.toLowerCase();
/* 6600 */       if (startName.contains(text.toLowerCase())) {
/* 6601 */         dlmsuggestion.addElement(startName);
/*      */       }
/*      */     } 
/* 6604 */     this.defaultListModel.clear();
/* 6605 */     this.defaultListModel = dlmsuggestion;
/* 6606 */     if (!this.defaultListModel.isEmpty()) {
/* 6607 */       this.listOfSuggestionsRemove.setModel(this.defaultListModel);
/* 6608 */       this.suggestionsPopUpRemove.show(this.nComercialRemove, 0, this.nComercialRemove.getHeight());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void returnSuggestionPopUpStock(String text) {
/* 6614 */     DefaultListModel<String> dlmsuggestion = new DefaultListModel();
/* 6615 */     ArrayList<String> drugNames = getSuggestionsOfCommercialNames();
/*      */     
/* 6617 */     for (String drugName : drugNames) {
/* 6618 */       String startName = drugName.toLowerCase();
/* 6619 */       if (startName.contains(text.toLowerCase())) {
/* 6620 */         dlmsuggestion.addElement(startName);
/*      */       }
/*      */     } 
/* 6623 */     this.defaultListModel.clear();
/* 6624 */     this.defaultListModel = dlmsuggestion;
/* 6625 */     if (!this.defaultListModel.isEmpty()) {
/* 6626 */       this.listOfSuggestionsStock.setModel(this.defaultListModel);
/* 6627 */       this.suggestionsPopUpStock.show(this.stockNameSearch, 0, this.stockNameSearch.getHeight());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void reurnSuggestionSell(String text) {
/* 6633 */     DefaultListModel<String> dlmsuggestion = new DefaultListModel();
/* 6634 */     ArrayList<String> drugNames = getSuggestionsOfCommercialNames();
/*      */     
/* 6636 */     for (String drugName : drugNames) {
/* 6637 */       String startName = drugName.toLowerCase();
/* 6638 */       if (startName.contains(text.toLowerCase())) {
/* 6639 */         dlmsuggestion.addElement(startName);
/*      */       }
/*      */     } 
/* 6642 */     this.defaultListModel.clear();
/* 6643 */     this.defaultListModel = dlmsuggestion;
/* 6644 */     if (!this.defaultListModel.isEmpty()) {
/* 6645 */       this.listOfSuggestionsSell.setModel(this.defaultListModel);
/* 6646 */       this.suggestionsPopUpSell.show(this.comercialNamePointSell, 0, this.comercialNamePointSell.getHeight());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void nComercialEditKeyPressed(KeyEvent evt) {
/* 6652 */     String search = this.nComercialEdit.getText().trim();
/*      */     
/* 6654 */     if (!search.equals("")) {
/* 6655 */       this.barCodeEdit.setEnabled(false);
/*      */     } else {
/*      */       
/* 6658 */       this.barCodeEdit.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void barCodeEditKeyPressed(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void barCodeEditKeyReleased(KeyEvent evt) {
/* 6672 */     String search = this.barCodeEdit.getText().trim();
/*      */     
/* 6674 */     if (!search.equals("")) {
/* 6675 */       this.nComercialEdit.setEnabled(false);
/*      */     } else {
/*      */       
/* 6678 */       this.nComercialEdit.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void nComercialEditKeyReleased(KeyEvent evt) {
/* 6684 */     String textForSearch = this.nComercialEdit.getText();
/* 6685 */     String search = this.nComercialEdit.getText().trim();
/*      */     
/* 6687 */     if (!search.equals("")) {
/* 6688 */       this.barCodeEdit.setEnabled(false);
/* 6689 */       reurnSuggestionPopUp(textForSearch);
/*      */     } else {
/*      */       
/* 6692 */       this.barCodeEdit.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void nComercialRemoveKeyTyped(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void nComercialRemoveKeyReleased(KeyEvent evt) {
/* 6703 */     String textForSearch = this.nComercialRemove.getText();
/* 6704 */     String search = this.nComercialRemove.getText().trim();
/*      */     
/* 6706 */     if (!search.equals("")) {
/* 6707 */       this.barCodeSearch.setEnabled(false);
/* 6708 */       returnSuggestionPopUpRemove(textForSearch);
/*      */     } else {
/*      */       
/* 6711 */       this.barCodeSearch.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void barCodeSearchKeyReleased(KeyEvent evt) {
/* 6718 */     String search = this.barCodeSearch.getText().trim();
/*      */     
/* 6720 */     if (!search.equals("")) {
/* 6721 */       this.nComercialRemove.setEnabled(false);
/*      */     } else {
/*      */       
/* 6724 */       this.nComercialRemove.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void billNrSearchKeyReleased(KeyEvent evt) {
/* 6731 */     String search = this.billNrSearch.getText().trim();
/*      */     
/* 6733 */     if (!search.equals("")) {
/* 6734 */       this.drugNameSearch.setEnabled(false);
/*      */     } else {
/*      */       
/* 6737 */       this.drugNameSearch.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void drugNameSearchKeyReleased(KeyEvent evt) {
/* 6744 */     String search = this.drugNameSearch.getText().trim();
/*      */     
/* 6746 */     if (!search.equals("")) {
/* 6747 */       this.billNrSearch.setEnabled(false);
/*      */     }
/*      */     else {
/*      */       
/* 6751 */       this.billNrSearch.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void stockNameSearchKeyReleased(KeyEvent evt) {
/* 6757 */     String search = this.stockNameSearch.getText().trim();
/*      */     
/* 6759 */     if (!search.equals("")) {
/* 6760 */       this.stockBarCodeSearch.setEnabled(false);
/* 6761 */       returnSuggestionPopUpStock(search);
/*      */     } else {
/*      */       
/* 6764 */       this.stockBarCodeSearch.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void stockBarCodeSearchKeyReleased(KeyEvent evt) {
/* 6770 */     String search = this.stockBarCodeSearch.getText().trim();
/*      */     
/* 6772 */     if (!search.equals("")) {
/* 6773 */       this.stockNameSearch.setEnabled(false);
/*      */     } else {
/*      */       
/* 6776 */       this.stockNameSearch.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton18ActionPerformed(ActionEvent evt) {
/* 6782 */     if (this.barCodeSave.getText().trim().isEmpty() || this.genericNameSave
/* 6783 */       .getText().trim().isEmpty() || this.comercialNameSave
/* 6784 */       .getText().trim().isEmpty() || this.batchNrSave
/* 6785 */       .getText().trim().isEmpty() || this.qtySave
/* 6786 */       .getText().trim().isEmpty() || this.unitSave
/* 6787 */       .getText().trim().isEmpty() || this.manufacturerSave
/* 6788 */       .getText().trim().isEmpty() || this.supplierSave
/* 6789 */       .getText().trim().isEmpty() || this.expireDateSave
/* 6790 */       .getDate().toString().isEmpty() || this.entryDateSave
/* 6791 */       .getDate().toString().isEmpty() || this.prVendaSave
/* 6792 */       .getText().trim().isEmpty() || this.prCompraSave
/* 6793 */       .getText().trim().isEmpty()) {
/* 6794 */       JOptionPane.showMessageDialog(null, "Por favor, Preencha todos os campos exigidos", "Campo Vazio", 2);
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/* 6800 */       Drug drug = new Drug(Integer.parseInt(this.batchNrSave.getText()), this.genericNameSave.getText().toLowerCase(), this.comercialNameSave.getText().toLowerCase(), this.categSave.getSelectedItem().toString(), this.unitSave.getText(), this.manufacturerSave.getText(), this.barCodeSave.getText());
/*      */       
/* 6802 */       DrugDAO dDao = new DrugDAO();
/*      */ 
/*      */ 
/*      */       
/* 6806 */       if (dDao.checkDrugByBarCode(this.barCodeSave.getText()) == true || dDao
/* 6807 */         .checkDrugByComercialName(drug) == true || dDao
/* 6808 */         .checkDrugByBatchNr(drug) == true || dDao
/* 6809 */         .checkDrugByGenericName(drug) == true) {
/* 6810 */         if (dDao.checkDrugByBarCode(this.barCodeSave.getText()) == true) {
/* 6811 */           JOptionPane.showMessageDialog(null, "Medicamento Com esse Código de Barras Já Existe no Stock");
/* 6812 */         } else if (dDao.checkDrugByComercialName(drug) == true) {
/* 6813 */           JOptionPane.showMessageDialog(null, "Medicamento Com esse Nome Comercial Já Existe no Stock");
/* 6814 */         } else if (dDao.checkDrugByBatchNr(drug) == true) {
/* 6815 */           JOptionPane.showMessageDialog(null, "Medicamento Com esse Batch Nr Já Existe no Stocka");
/* 6816 */         } else if (dDao.checkDrugByGenericName(drug) == true) {
/* 6817 */           JOptionPane.showMessageDialog(null, "Medicamento Com esse Nome Genérico Já Existe no Stocka");
/*      */         } 
/*      */       } else {
/*      */         
/* 6821 */         dDao.save(drug);
/*      */         
/* 6823 */         int drug_id = dDao.retrieveDrugID(drug);
/*      */         
/* 6825 */         drug.setDrug_id(drug_id);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6831 */         Stock stock = new Stock(drug, Double.parseDouble(this.qtySave.getText()), this.supplierSave.getText(), Double.parseDouble(this.prVendaSave.getText()), Double.parseDouble(this.prCompraSave.getText()), ((JTextField)this.entryDateSave.getDateEditor().getUiComponent()).getText(), ((JTextField)this.expireDateSave.getDateEditor().getUiComponent()).getText(), true);
/*      */         
/* 6833 */         StockDAO sDao = new StockDAO();
/* 6834 */         sDao.save(stock);
/* 6835 */         readTableStock();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 6844 */     this.barCodeSave.setText((String)null);
/*      */     
/* 6846 */     this.genericNameSave.setText((String)null);
/* 6847 */     this.comercialNameSave.setText((String)null);
/* 6848 */     this.batchNrSave.setText((String)null);
/* 6849 */     this.qtySave.setText((String)null);
/* 6850 */     this.unitSave.setText((String)null);
/* 6851 */     this.manufacturerSave.setText((String)null);
/* 6852 */     this.supplierSave.setText((String)null);
/* 6853 */     this.entryDateSave.setDate(null);
/* 6854 */     this.expireDateSave.setDate(null);
/* 6855 */     this.prVendaSave.setText((String)null);
/* 6856 */     this.prCompraSave.setText((String)null);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 6861 */     if (this.name.getText().trim().isEmpty() || this.gender.getSelectedItem().toString().trim().isEmpty() || this.age
/* 6862 */       .getDate().toString().isEmpty() || this.academic
/* 6863 */       .getText().trim().isEmpty() || this.marital_status
/* 6864 */       .getSelectedItem().toString().trim().isEmpty() || this.address
/* 6865 */       .getText().trim().isEmpty() || this.salary
/* 6866 */       .getText().trim().isEmpty() || this.telephone
/* 6867 */       .getText().trim().isEmpty()) {
/*      */       
/* 6869 */       JOptionPane.showMessageDialog(this, "Informe os dados em falta");
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/* 6875 */       User user = new User(this.name.getText().toLowerCase(), this.gender.getSelectedItem().toString(), ((JTextField)this.age.getDateEditor().getUiComponent()).getText(), this.academic.getText(), this.marital_status.getSelectedItem().toString(), Double.parseDouble(this.salary.getText()), this.address.getText(), Integer.parseInt(this.telephone.getText()));
/*      */ 
/*      */ 
/*      */       
/* 6879 */       UserDAO udao = new UserDAO();
/*      */       
/* 6881 */       if (udao.checkUserByName(user)) {
/* 6882 */         JOptionPane.showMessageDialog(null, "Usuário já existe!");
/*      */       }
/* 6884 */       else if (!udao.checkUserByName(user)) {
/* 6885 */         udao.saveGeneral(user);
/* 6886 */         JOptionPane.showMessageDialog(null, "Usuário foi Criado");
/* 6887 */         readComboUser();
/* 6888 */         emptyCreateUser();
/* 6889 */         readUserTable();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void nComercialEditMouseClicked(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void listOfSuggestionsMouseClicked(MouseEvent evt) {
/* 6904 */     String text = this.listOfSuggestions.getSelectedValue();
/* 6905 */     this.nComercialEdit.setText(text);
/*      */     
/* 6907 */     System.err.print(this.nComercialEdit.getName());
/* 6908 */     if (this.nComercialEdit.getText() != null) {
/* 6909 */       this.suggestionsPopUp.setVisible(false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void suggestionsPopUpMouseClicked(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void suggestionsPopUpRemoveMouseClicked(MouseEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void listOfSuggestionsRemoveMouseClicked(MouseEvent evt) {
/* 6925 */     String text = this.listOfSuggestionsRemove.getSelectedValue();
/* 6926 */     this.nComercialRemove.setText(text);
/* 6927 */     System.err.print(this.nComercialRemove.getName());
/* 6928 */     if (this.nComercialRemove.getText() != null) {
/* 6929 */       this.suggestionsPopUpRemove.setVisible(false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void selectEditActionPerformed(ActionEvent evt) {
/* 6936 */     DrugDAO dd = new DrugDAO();
/* 6937 */     if (!this.nComercialEdit.getText().trim().isEmpty()) {
/*      */       
/* 6939 */       String searchName = this.nComercialEdit.getText();
/*      */ 
/*      */ 
/*      */       
/* 6943 */       if (!getSuggestionsOfCommercialNames().contains(searchName.toLowerCase())) {
/* 6944 */         JOptionPane.showMessageDialog(null, "Medicamento Inexistente no Stock", "Sem Resultado", 2);
/*      */       }
/*      */       else {
/*      */         
/* 6948 */         Drug d = dd.getDrugsByComercialName(searchName);
/* 6949 */         StockDAO sd = new StockDAO();
/* 6950 */         Stock s = sd.returnStockByDrugId(d);
/*      */         
/* 6952 */         this.barCodeEditTA.setEnabled(true);
/* 6953 */         this.barCodeEditTA.setText(d.getBar_code());
/*      */         
/* 6955 */         this.genericNameEditTA.setEnabled(true);
/* 6956 */         this.genericNameEditTA.setText(d.getGeneric_name());
/*      */         
/* 6958 */         this.comercialNameEditTA.setEnabled(true);
/* 6959 */         this.comercialNameEditTA.setText(d.getComercial_name());
/*      */         
/* 6961 */         this.batchNrEdit.setEnabled(true);
/* 6962 */         this.batchNrEdit.setText(String.valueOf(d.getBatch_nr()));
/*      */         
/* 6964 */         this.categoryEdit.setEnabled(true);
/* 6965 */         this.categoryEdit.setSelectedItem(d.getCategory());
/*      */         
/* 6967 */         this.qtyEditTA.setEnabled(true);
/* 6968 */         this.qtyEditTA.setText(String.valueOf(s.getQuantity()));
/*      */         
/* 6970 */         this.unitEdit.setEnabled(true);
/* 6971 */         this.unitEdit.setText(d.getUnit());
/*      */         
/* 6973 */         this.manufacturerEdit.setEnabled(true);
/* 6974 */         this.manufacturerEdit.setText(d.getManufacturer());
/*      */         
/* 6976 */         this.supplierEdit.setEnabled(true);
/* 6977 */         this.supplierEdit.setText(s.getSupplier());
/*      */         
/* 6979 */         String entryDateStr = s.getEntry_date();
/* 6980 */         String expireDateEditStr = s.getExpire_date();
/*      */         
/* 6982 */         DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/*      */         
/*      */         try {
/* 6985 */           Date entryDate = formatter.parse(entryDateStr);
/* 6986 */           Date expireDate = formatter.parse(expireDateEditStr);
/*      */           
/* 6988 */           this.entryDateEdit.setEnabled(true);
/* 6989 */           this.entryDateEdit.setDate(expireDate);
/*      */           
/* 6991 */           this.expireDateEdit.setEnabled(true);
/* 6992 */           this.expireDateEdit.setDate(entryDate);
/* 6993 */         } catch (ParseException ex) {
/* 6994 */           System.err.println("Error: " + ex);
/*      */         } 
/*      */         
/* 6997 */         this.sellPriceEdit.setEnabled(true);
/* 6998 */         this.sellPriceEdit.setText(String.valueOf(s.getUni_sell_price()));
/*      */         
/* 7000 */         this.buyPriceEdit.setEnabled(true);
/* 7001 */         this.buyPriceEdit.setText(String.valueOf(s.getPurchase_price()));
/*      */         
/* 7003 */         this.nComercialEdit.setEditable(false);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 7009 */     if (!this.barCodeEdit.getText().trim().isEmpty()) {
/* 7010 */       String searchBarCode = this.barCodeEdit.getText();
/* 7011 */       if (!dd.checkDrugByBarCode(searchBarCode)) {
/* 7012 */         JOptionPane.showMessageDialog(null, "Medicamento Inexistente no Stock", "Sem Resultado", 2);
/*      */       }
/*      */       else {
/*      */         
/* 7016 */         Drug d = dd.getDrugByBarCode(searchBarCode);
/* 7017 */         StockDAO sd = new StockDAO();
/* 7018 */         Stock s = sd.returnStockByDrugId(d);
/*      */         
/* 7020 */         this.barCodeEditTA.setEnabled(true);
/* 7021 */         this.barCodeEditTA.setText(d.getBar_code());
/*      */         
/* 7023 */         this.genericNameEditTA.setEnabled(true);
/* 7024 */         this.genericNameEditTA.setText(d.getGeneric_name());
/*      */         
/* 7026 */         this.comercialNameEditTA.setEnabled(true);
/* 7027 */         this.comercialNameEditTA.setText(d.getComercial_name());
/*      */         
/* 7029 */         this.batchNrEdit.setEnabled(true);
/* 7030 */         this.batchNrEdit.setText(String.valueOf(d.getBatch_nr()));
/*      */         
/* 7032 */         this.categoryEdit.setEnabled(true);
/* 7033 */         this.categoryEdit.setSelectedItem(d.getCategory());
/*      */         
/* 7035 */         this.qtyEditTA.setEnabled(true);
/* 7036 */         this.qtyEditTA.setText(String.valueOf(s.getQuantity()));
/*      */         
/* 7038 */         this.unitEdit.setEnabled(true);
/* 7039 */         this.unitEdit.setText(d.getUnit());
/*      */         
/* 7041 */         this.manufacturerEdit.setEnabled(true);
/* 7042 */         this.manufacturerEdit.setText(d.getManufacturer());
/*      */         
/* 7044 */         this.supplierEdit.setEnabled(true);
/* 7045 */         this.supplierEdit.setText(s.getSupplier());
/*      */         
/* 7047 */         String entryDateStr = s.getEntry_date();
/* 7048 */         String expireDateEditStr = s.getExpire_date();
/*      */         
/* 7050 */         DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/*      */         
/*      */         try {
/* 7053 */           Date entryDate = formatter.parse(entryDateStr);
/* 7054 */           Date expireDate = formatter.parse(expireDateEditStr);
/*      */           
/* 7056 */           this.entryDateEdit.setEnabled(true);
/* 7057 */           this.entryDateEdit.setDate(expireDate);
/*      */           
/* 7059 */           this.expireDateEdit.setEnabled(true);
/* 7060 */           this.expireDateEdit.setDate(entryDate);
/* 7061 */         } catch (ParseException ex) {
/* 7062 */           System.err.println("Error: " + ex);
/*      */         } 
/*      */         
/* 7065 */         this.sellPriceEdit.setEnabled(true);
/* 7066 */         this.sellPriceEdit.setText(String.valueOf(s.getUni_sell_price()));
/*      */         
/* 7068 */         this.buyPriceEdit.setEnabled(true);
/* 7069 */         this.buyPriceEdit.setText(String.valueOf(s.getPurchase_price()));
/*      */         
/* 7071 */         this.barCodeEdit.setEditable(false);
/*      */       } 
/*      */     } 
/*      */     
/* 7075 */     if (this.barCodeEdit.getText().trim().isEmpty() && this.nComercialEdit.getText().trim().isEmpty()) {
/* 7076 */       JOptionPane.showMessageDialog(null, "Informe o Nome Comercial ou o Código de Barras do Medicamento", "Campo Vazio", 2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 7083 */     DrugDAO dd = new DrugDAO();
/* 7084 */     if (!this.nComercialRemove.getText().trim().isEmpty()) {
/* 7085 */       String searchName = this.nComercialRemove.getText();
/*      */ 
/*      */       
/* 7088 */       if (!getSuggestionsOfCommercialNames().contains(searchName.toLowerCase())) {
/* 7089 */         JOptionPane.showMessageDialog(null, "Medicamento Inexistente no Stock", "Sem Resultado", 2);
/*      */       }
/*      */       else {
/*      */         
/* 7093 */         Drug d = dd.getDrugsByComercialName(searchName);
/* 7094 */         StockDAO sd = new StockDAO();
/* 7095 */         Stock s = sd.returnStockByDrugId(d);
/*      */         
/* 7097 */         this.barCodeRemove.setText(d.getBar_code());
/*      */         
/* 7099 */         this.genericNameRemove.setText(d.getGeneric_name());
/*      */         
/* 7101 */         this.comercialNameRemove.setText(d.getComercial_name());
/*      */         
/* 7103 */         this.batchNrRemove.setText(String.valueOf(d.getBatch_nr()));
/*      */ 
/*      */         
/* 7106 */         this.categoryRemove.setSelectedItem(d.getCategory());
/*      */ 
/*      */         
/* 7109 */         this.qtyRemove.setText(String.valueOf(s.getQuantity()));
/*      */ 
/*      */         
/* 7112 */         this.unitRemove.setText(d.getUnit());
/*      */         
/* 7114 */         this.manufacturerRemove.setText(d.getManufacturer());
/*      */ 
/*      */         
/* 7117 */         this.supplierRemove.setText(s.getSupplier());
/*      */         
/* 7119 */         String entryDateStr = s.getEntry_date();
/* 7120 */         String expireDateEditStr = s.getExpire_date();
/*      */         
/* 7122 */         DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/*      */         
/*      */         try {
/* 7125 */           Date entryDate = formatter.parse(entryDateStr);
/* 7126 */           Date expireDate = formatter.parse(expireDateEditStr);
/*      */ 
/*      */           
/* 7129 */           this.entryDateRemove.setDate(expireDate);
/*      */           
/* 7131 */           this.expireDateRemove.setDate(entryDate);
/* 7132 */         } catch (ParseException ex) {
/* 7133 */           System.err.println("Error: " + ex);
/*      */         } 
/*      */ 
/*      */         
/* 7137 */         this.sellPriceRemove.setText(String.valueOf(s.getUni_sell_price()));
/*      */         
/* 7139 */         this.buyPriceRemove.setText(String.valueOf(s.getPurchase_price()));
/*      */       } 
/*      */     } 
/*      */     
/* 7143 */     if (!this.barCodeSearch.getText().trim().isEmpty()) {
/* 7144 */       String searchBarCode = this.barCodeSearch.getText();
/* 7145 */       if (!dd.checkDrugByBarCode(searchBarCode)) {
/* 7146 */         JOptionPane.showMessageDialog(null, "Medicamento Inexistente no Stock", "Sem Resultado", 2);
/*      */       }
/*      */       else {
/*      */         
/* 7150 */         Drug d = dd.getDrugByBarCode(searchBarCode);
/* 7151 */         StockDAO sd = new StockDAO();
/* 7152 */         Stock s = sd.returnStockByDrugId(d);
/*      */         
/* 7154 */         this.barCodeRemove.setText(d.getBar_code());
/*      */         
/* 7156 */         this.genericNameRemove.setText(d.getGeneric_name());
/*      */         
/* 7158 */         this.comercialNameRemove.setText(d.getComercial_name());
/*      */         
/* 7160 */         this.batchNrRemove.setText(String.valueOf(d.getBatch_nr()));
/*      */ 
/*      */         
/* 7163 */         this.categoryRemove.setSelectedItem(d.getCategory());
/*      */ 
/*      */         
/* 7166 */         this.qtyRemove.setText(String.valueOf(s.getQuantity()));
/*      */ 
/*      */         
/* 7169 */         this.unitRemove.setText(d.getUnit());
/*      */         
/* 7171 */         this.manufacturerRemove.setText(d.getManufacturer());
/*      */ 
/*      */         
/* 7174 */         this.supplierRemove.setText(s.getSupplier());
/*      */         
/* 7176 */         String entryDateStr = s.getEntry_date();
/* 7177 */         String expireDateEditStr = s.getExpire_date();
/*      */         
/* 7179 */         DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/*      */         
/*      */         try {
/* 7182 */           Date entryDate = formatter.parse(entryDateStr);
/* 7183 */           Date expireDate = formatter.parse(expireDateEditStr);
/*      */ 
/*      */           
/* 7186 */           this.entryDateRemove.setDate(expireDate);
/*      */           
/* 7188 */           this.expireDateRemove.setDate(entryDate);
/* 7189 */         } catch (ParseException ex) {
/* 7190 */           System.err.println("Error: " + ex);
/*      */         } 
/*      */ 
/*      */         
/* 7194 */         this.sellPriceRemove.setText(String.valueOf(s.getUni_sell_price()));
/*      */         
/* 7196 */         this.buyPriceRemove.setText(String.valueOf(s.getPurchase_price()));
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 7202 */     if (this.barCodeSearch.getText().trim().isEmpty() && this.nComercialRemove.getText().trim().isEmpty()) {
/* 7203 */       JOptionPane.showMessageDialog(null, "Informe o Nome Comercial ou o Código de Barras do Medicamento", "Campo Vazio", 2);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void setEmptyRemove() {
/* 7209 */     this.barCodeRemove.setText((String)null);
/* 7210 */     this.genericNameRemove.setText((String)null);
/* 7211 */     this.comercialNameRemove.setText((String)null);
/* 7212 */     this.batchNrRemove.setText((String)null);
/* 7213 */     this.qtyRemove.setText((String)null);
/* 7214 */     this.unitRemove.setText((String)null);
/* 7215 */     this.manufacturerRemove.setText((String)null);
/* 7216 */     this.supplierRemove.setText((String)null);
/* 7217 */     this.entryDateRemove.setDate(null);
/* 7218 */     this.expireDateRemove.setDate(null);
/* 7219 */     this.sellPriceRemove.setText((String)null);
/* 7220 */     this.buyPriceRemove.setText((String)null);
/*      */   }
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 7224 */     if (!this.nComercialRemove.getText().trim().isEmpty() || 
/* 7225 */       !this.barCodeSearch.getText().trim().isEmpty()) {
/* 7226 */       DrugDAO dd = new DrugDAO();
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 7231 */       Drug drug = new Drug(Integer.parseInt(this.batchNrRemove.getText()), this.genericNameRemove.getText(), this.comercialNameRemove.getText(), this.categoryRemove.getSelectedItem().toString(), this.unitRemove.getText(), this.manufacturerRemove.getText(), this.barCodeRemove.getText());
/*      */ 
/*      */ 
/*      */       
/* 7235 */       Drug drugS = dd.getDrugsByComercialName(this.comercialNameRemove.getText());
/* 7236 */       int drug_id = drugS.getDrug_id();
/* 7237 */       drug.setDrug_id(drug_id);
/*      */ 
/*      */       
/* 7240 */       StockDAO sDao = new StockDAO();
/* 7241 */       Stock stockID = sDao.returnStockByDrugId(drug);
/* 7242 */       int stock_id = stockID.getStock_id();
/*      */ 
/*      */       
/* 7245 */       DrugDAO dDao = new DrugDAO();
/* 7246 */       if (dDao.checkDrug(drug) == true) {
/*      */         
/* 7248 */         sDao.deleteByStockId(stock_id);
/* 7249 */         dDao.deleteByDrugId(drug_id);
/*      */         
/* 7251 */         JOptionPane.showMessageDialog(null, "Stock Deletado com Sucesso!");
/* 7252 */         readTableStock();
/* 7253 */         setEmptyRemove();
/*      */       }
/*      */       else {
/*      */         
/* 7257 */         JOptionPane.showMessageDialog(null, "Stock Nao Existe!");
/*      */       } 
/*      */     } else {
/* 7260 */       JOptionPane.showMessageDialog(null, "Informe o Nome Comercial Ou Código de Barras do Medicamento");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void saveEdition() {
/* 7265 */     if (this.barCodeEditTA.getText().trim().isEmpty() || this.genericNameEditTA.getText().trim().isEmpty() || this.batchNrEdit
/* 7266 */       .getText().trim().isEmpty() || this.categoryEdit
/* 7267 */       .getSelectedItem().toString().trim().isEmpty() || this.qtyEditTA
/* 7268 */       .getText().trim().isEmpty() || this.buyPriceEdit
/* 7269 */       .getText().trim().isEmpty() || this.supplierEdit
/* 7270 */       .getText().trim().isEmpty() || this.manufacturerEdit
/* 7271 */       .getText().trim().isEmpty() || this.entryDateEdit
/* 7272 */       .getDate().toString().isEmpty() || this.expireDateEdit
/* 7273 */       .getDate().toString().isEmpty() || this.comercialNameEditTA
/* 7274 */       .getText().trim().isEmpty() || this.unitEdit
/* 7275 */       .getText().trim().isEmpty() || this.sellPriceEdit
/* 7276 */       .getText().trim().isEmpty()) {
/* 7277 */       JOptionPane.showMessageDialog(this, "Informe os dados em falta", "Campo Vazio", 2);
/*      */     } else {
/* 7279 */       DrugDAO dd = new DrugDAO();
/* 7280 */       String barCode = null;
/* 7281 */       if (!this.nComercialEdit.getText().trim().isEmpty()) {
/* 7282 */         barCode = dd.getDrugsByComercialName(this.nComercialEdit.getText()).getBar_code();
/* 7283 */       } else if (!this.barCodeEdit.getText().trim().isEmpty()) {
/* 7284 */         barCode = this.barCodeEdit.getText();
/* 7285 */         this.barCodeEdit.setEditable(false);
/*      */       } 
/*      */       
/* 7288 */       Drug drugS = dd.getDrugsByComercialName(this.nComercialEdit.getText());
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 7293 */       Drug drug = new Drug(Integer.parseInt(this.batchNrEdit.getText()), this.genericNameEditTA.getText(), this.comercialNameEditTA.getText(), this.categoryEdit.getSelectedItem().toString(), this.unitEdit.getText(), this.manufacturerEdit.getText(), this.barCodeEditTA.getText());
/*      */ 
/*      */       
/* 7296 */       drug.setDrug_id(drugS.getDrug_id());
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 7301 */       StockDAO sd = new StockDAO();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 7307 */       Stock stock = new Stock(drug, Double.parseDouble(this.qtyEditTA.getText()), this.supplierEdit.getText(), Double.parseDouble(this.sellPriceEdit.getText()), Double.parseDouble(this.buyPriceEdit.getText()), ((JTextField)this.entryDateEdit.getDateEditor().getUiComponent()).getText(), ((JTextField)this.expireDateEdit.getDateEditor().getUiComponent()).getText(), true);
/*      */       
/* 7309 */       Stock stock1 = sd.returnStockByDrugId(drug);
/* 7310 */       stock.setStock_id(stock1.getStock_id());
/*      */ 
/*      */       
/* 7313 */       if (dd.checkDrugByBarCodeException(drug) || dd
/* 7314 */         .checkDrugByCommercialNameException(drug) || dd
/* 7315 */         .checkDrugByBatchNrException(drug) || dd
/* 7316 */         .checkDrugByGenericNameException(drug)) {
/* 7317 */         if (dd.checkDrugByBarCodeException(drug) == true) {
/* 7318 */           JOptionPane.showMessageDialog(null, "Medicamento Com esse Código de Barras Já Existe no Stock");
/* 7319 */         } else if (dd.checkDrugByCommercialNameException(drug) == true) {
/* 7320 */           JOptionPane.showMessageDialog(null, "Medicamento Com esse Nome Comercial Já Existe no Stock");
/* 7321 */         } else if (dd.checkDrugByBatchNrException(drug) == true) {
/* 7322 */           JOptionPane.showMessageDialog(null, "Medicamento Com esse Batch Nr Já Existe no Stocka");
/* 7323 */         } else if (dd.checkDrugByGenericNameException(drug) == true) {
/* 7324 */           JOptionPane.showMessageDialog(null, "Medicamento Com esse Nome Genérico Já Existe no Stocka");
/*      */         } 
/*      */       } else {
/*      */         
/* 7328 */         boolean resultD = dd.updateDrug(drug);
/*      */         
/* 7330 */         boolean resultS = sd.updateStock(stock);
/* 7331 */         if (resultD == true && resultS == true) {
/* 7332 */           JOptionPane.showMessageDialog(null, "Stock Editado com Sucesso", "Sucesso", 2);
/* 7333 */           emptyRemove();
/* 7334 */           this.barCodeEdit.setText((String)null);
/* 7335 */           this.nComercialEdit.setText((String)null);
/* 7336 */           readTableStock();
/*      */         } else {
/* 7338 */           JOptionPane.showMessageDialog(null, "Erro ao Salvar as Alterações ", "Erro", 2);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton22ActionPerformed(ActionEvent evt) {
/* 7345 */     saveEdition();
/*      */   }
/*      */ 
/*      */   
/*      */   private void listOfSuggestionsStockMouseClicked(MouseEvent evt) {
/* 7350 */     String text = this.listOfSuggestionsStock.getSelectedValue();
/* 7351 */     this.stockNameSearch.setText(text);
/* 7352 */     if (this.stockNameSearch.getText() != null) {
/* 7353 */       this.suggestionsPopUpStock.setVisible(false);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void suggestionsPopUpStockMouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   public void searchStock() {
/* 7362 */     if (!this.stockNameSearch.getText().trim().isEmpty()) {
/* 7363 */       searchInStockByComercialName(this.stockNameSearch.getText());
/* 7364 */     } else if (!this.stockBarCodeSearch.getText().trim().isEmpty()) {
/* 7365 */       searchInStockByBarCode(this.stockBarCodeSearch.getText());
/*      */     } else {
/* 7367 */       JOptionPane.showMessageDialog(null, "Informe O nome Comercial ou Código de Barras Para Buscar", "Campo Vazio", 2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 7374 */     searchStock();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 7379 */     readTableStock();
/*      */   }
/*      */ 
/*      */   
/*      */   private void telephoneKeyPressed(KeyEvent evt) {
/* 7384 */     char c = evt.getKeyChar();
/* 7385 */     if (c >= '0' && c <= '9') {
/* 7386 */       this.telephone.setEditable(true);
/*      */     }
/* 7388 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 7389 */       .getExtendedKeyCode() == 127) {
/*      */       
/* 7391 */       this.telephone.setEditable(true);
/*      */     } else {
/* 7393 */       this.telephone.setEditable(false);
/*      */     } 
/*      */     
/* 7396 */     if (evt.getKeyCode() == 40)
/* 7397 */       this.academic.requestFocus(true); 
/* 7398 */     if (evt.getKeyCode() == 38) {
/* 7399 */       this.address.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void salaryKeyPressed(KeyEvent evt) {
/* 7405 */     char c = evt.getKeyChar();
/* 7406 */     if (c >= '0' && c <= '9') {
/* 7407 */       this.salary.setEditable(true);
/*      */     }
/* 7409 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 7410 */       .getExtendedKeyCode() == 127 || evt
/* 7411 */       .getExtendedKeyCode() == 46) {
/* 7412 */       this.salary.setEditable(true);
/*      */     } else {
/* 7414 */       this.salary.setEditable(false);
/*      */     } 
/*      */     
/* 7417 */     if (evt.getKeyCode() == 40)
/* 7418 */       this.marital_status.requestFocus(true); 
/* 7419 */     if (evt.getKeyCode() == 38) {
/* 7420 */       this.gender.requestFocus(true);
/*      */     }
/*      */   }
/*      */   
/*      */   private void emptyCreateUser() {
/* 7425 */     this.name.setText((String)null);
/* 7426 */     this.gender.setEnabled(true);
/* 7427 */     this.age.setDate(null);
/* 7428 */     this.academic.setText((String)null);
/* 7429 */     this.salary.setText((String)null);
/* 7430 */     this.telephone.setText((String)null);
/* 7431 */     this.marital_status.setEnabled(true);
/* 7432 */     this.address.setText((String)null);
/*      */   }
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 7436 */     emptyCreateUser();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton32ActionPerformed(ActionEvent evt) {
/* 7441 */     if (this.comboBoxListRemove.getSelectedItem() == null) {
/* 7442 */       JOptionPane.showMessageDialog(null, "Nenhum Usuario Foi Selecionado");
/*      */     } else {
/*      */       
/* 7445 */       User user = (User)this.comboBoxListRemove.getSelectedItem();
/*      */       
/* 7447 */       UserDAO udao = new UserDAO();
/* 7448 */       User user2 = udao.getUserByName(user.getName());
/*      */ 
/*      */       
/* 7451 */       this.nameRemove.setText(user2.getName());
/*      */ 
/*      */       
/* 7454 */       String ageDateStr = user2.getBirth_date();
/*      */       
/* 7456 */       DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/*      */       
/*      */       try {
/* 7459 */         Date ageDate = formatter.parse(ageDateStr);
/* 7460 */         this.ageRemove.setDate(ageDate);
/* 7461 */       } catch (ParseException ex) {
/* 7462 */         System.err.println("Error: " + ex);
/*      */       } 
/*      */       
/* 7465 */       this.genderRemove.setSelectedItem(user2.getGender());
/*      */ 
/*      */       
/* 7468 */       this.salaryRemove.setText(String.valueOf(user2.getSalary()));
/*      */ 
/*      */       
/* 7471 */       this.marital_statusRemove.setSelectedItem(user2.getMarital_status());
/*      */ 
/*      */       
/* 7474 */       this.addressRemove.setText(user2.getAddress());
/*      */ 
/*      */       
/* 7477 */       this.telephoneRemove.setText(String.valueOf(user2.getTelephone()));
/*      */ 
/*      */       
/* 7480 */       this.academicRemove.setText(user2.getAcademic());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton27ActionPerformed(ActionEvent evt) {
/* 7490 */     if (this.staffComboEdit.getSelectedItem() == null) {
/* 7491 */       JOptionPane.showMessageDialog(null, "Nenhum Usuario Foi Selecionado");
/*      */     } else {
/*      */       
/* 7494 */       User user = (User)this.staffComboEdit.getSelectedItem();
/*      */       
/* 7496 */       UserDAO udao = new UserDAO();
/* 7497 */       User user2 = udao.getUserByName(user.getName());
/*      */       
/* 7499 */       this.nameEdit.setEnabled(true);
/* 7500 */       this.nameEdit.setText(user2.getName());
/*      */ 
/*      */       
/* 7503 */       String ageDateStr = user2.getBirth_date();
/*      */       
/* 7505 */       DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/*      */       
/*      */       try {
/* 7508 */         Date ageDate = formatter.parse(ageDateStr);
/* 7509 */         this.ageEdit.setEnabled(true);
/* 7510 */         this.ageEdit.setDate(ageDate);
/* 7511 */       } catch (ParseException ex) {
/* 7512 */         System.err.println("Error: " + ex);
/*      */       } 
/*      */       
/* 7515 */       this.genderEdit.setEnabled(true);
/* 7516 */       this.genderEdit.setSelectedItem(user2.getGender());
/*      */       
/* 7518 */       this.salaryEdit.setEnabled(true);
/* 7519 */       this.salaryEdit.setText(String.valueOf(user2.getSalary()));
/*      */       
/* 7521 */       this.maritalStatusEdit.setEnabled(true);
/* 7522 */       this.maritalStatusEdit.setSelectedItem(user2.getMarital_status());
/*      */       
/* 7524 */       this.addressEdit.setEnabled(true);
/* 7525 */       this.addressEdit.setText(user2.getAddress());
/*      */       
/* 7527 */       this.telephoneEdit.setEnabled(true);
/* 7528 */       this.telephoneEdit.setText(String.valueOf(user2.getTelephone()));
/*      */       
/* 7530 */       this.academicEdit.setEnabled(true);
/* 7531 */       this.academicEdit.setText(user2.getAcademic());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void telephoneEditKeyPressed(KeyEvent evt) {
/* 7537 */     char c = evt.getKeyChar();
/* 7538 */     if (c >= '0' && c <= '9') {
/* 7539 */       this.telephoneEdit.setEditable(true);
/*      */     }
/* 7541 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 7542 */       .getExtendedKeyCode() == 127) {
/*      */       
/* 7544 */       this.telephoneEdit.setEditable(true);
/*      */     } else {
/* 7546 */       this.telephoneEdit.setEditable(false);
/*      */     } 
/*      */     
/* 7549 */     if (evt.getKeyCode() == 40)
/* 7550 */       this.academicEdit.requestFocus(true); 
/* 7551 */     if (evt.getKeyCode() == 38) {
/* 7552 */       this.addressEdit.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void salaryEditKeyPressed(KeyEvent evt) {
/* 7558 */     char c = evt.getKeyChar();
/* 7559 */     if (c >= '0' && c <= '9') {
/* 7560 */       this.salaryEdit.setEditable(true);
/*      */     }
/* 7562 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 7563 */       .getExtendedKeyCode() == 127 || evt
/* 7564 */       .getExtendedKeyCode() == 46) {
/* 7565 */       this.salaryEdit.setEditable(true);
/*      */     } else {
/* 7567 */       this.salaryEdit.setEditable(false);
/*      */     } 
/*      */     
/* 7570 */     if (evt.getKeyCode() == 40)
/* 7571 */       this.maritalStatusEdit.requestFocus(true); 
/* 7572 */     if (evt.getKeyCode() == 38) {
/* 7573 */       this.genderEdit.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton28ActionPerformed(ActionEvent evt) {
/* 7579 */     if (this.nameEdit.getText().trim().isEmpty() || this.genderEdit.getSelectedItem().toString().trim().isEmpty() || this.ageEdit
/* 7580 */       .getDate().toString().isEmpty() || this.academicEdit
/* 7581 */       .getText().trim().isEmpty() || this.maritalStatusEdit
/* 7582 */       .getSelectedItem().toString().trim().isEmpty() || this.addressEdit
/* 7583 */       .getText().trim().isEmpty() || this.salaryEdit
/* 7584 */       .getText().trim().isEmpty() || this.telephoneEdit
/* 7585 */       .getText().trim().isEmpty()) {
/*      */       
/* 7587 */       JOptionPane.showMessageDialog(this, "Informe os dados em falta");
/*      */     } else {
/*      */       
/* 7590 */       User userSelected = (User)this.staffComboEdit.getSelectedItem();
/*      */       
/* 7592 */       User user = new User();
/* 7593 */       user.setUser_id(userSelected.getUser_id());
/* 7594 */       user.setName(this.nameEdit.getText().toLowerCase());
/* 7595 */       user.setAcademic(this.academicEdit.getText());
/* 7596 */       user.setGender(this.genderEdit.getSelectedItem().toString());
/* 7597 */       user.setBirth_date(((JTextField)this.ageEdit.getDateEditor().getUiComponent()).getText());
/* 7598 */       user.setMarital_status(this.maritalStatusEdit.getSelectedItem().toString());
/* 7599 */       user.setAddress(this.addressEdit.getText());
/* 7600 */       user.setSalary(Double.parseDouble(this.salaryEdit.getText()));
/* 7601 */       user.setTelephone(Integer.parseInt(this.telephoneEdit.getText()));
/*      */       
/* 7603 */       UserDAO ud = new UserDAO();
/* 7604 */       if (ud.checkUserByNameException(user)) {
/* 7605 */         JOptionPane.showMessageDialog(null, "Usuário já existe!");
/*      */       } else {
/* 7607 */         boolean result = ud.updateUserGeneral(user);
/*      */         
/* 7609 */         if (result == true) {
/*      */           
/* 7611 */           JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
/* 7612 */           emptyEdit();
/*      */           
/* 7614 */           readComboUser();
/* 7615 */           readUserTable();
/*      */         } else {
/*      */           
/* 7618 */           JOptionPane.showMessageDialog(null, "Erro ao Editar");
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton31ActionPerformed(ActionEvent evt) {
/* 7628 */     readUserTable();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton30ActionPerformed(ActionEvent evt) {
/* 7633 */     User user = (User)this.nameStuffSearch.getSelectedItem();
/* 7634 */     readUserTableSearch(user);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 7639 */     User user = (User)this.comboUserAccess.getSelectedItem();
/* 7640 */     readUserTableSearchAccess(user);
/* 7641 */     readActivityTable(user);
/* 7642 */     String lastAccess = user.getAccess_time();
/* 7643 */     this.lasAccessTime.setText(lastAccess);
/*      */   }
/*      */   
/*      */   private void readActivityTable(User user) {
/* 7647 */     DefaultTableModel tableModel = (DefaultTableModel)this.userActivityTB.getModel();
/* 7648 */     tableModel.setNumRows(0);
/*      */     
/* 7650 */     UserActivityDAO ud = new UserActivityDAO();
/* 7651 */     for (UserActivity u : ud.returnUserActivityById(user)) {
/* 7652 */       tableModel.addRow(new Object[] { u
/* 7653 */             .getDate(), 
/* 7654 */             Double.valueOf(u.getMoney_sold()) });
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void changeAccess() {
/* 7660 */     if (this.loginAccess.getText().isEmpty() || this.passwordAccess.getText().isEmpty() || this.accessType
/* 7661 */       .getSelectedItem().toString().isEmpty()) {
/* 7662 */       JOptionPane.showMessageDialog(null, "Informe os Dados em Falta", "Dados em Falta", 2);
/*      */     } else {
/* 7664 */       UserDAO ud = new UserDAO();
/*      */       
/* 7666 */       User u = (User)this.comboUserAccess.getSelectedItem();
/* 7667 */       u.setLogin(this.loginAccess.getText());
/* 7668 */       u.setPassword(this.passwordAccess.getText());
/* 7669 */       u.setAccess_type(this.accessType.getSelectedItem().toString());
/* 7670 */       ud.updateUserAccess(u);
/* 7671 */       JOptionPane.showMessageDialog(null, "Acessos Alterados");
/* 7672 */       this.loginAccess.setText((String)null);
/* 7673 */       this.passwordAccess.setText((String)null);
/* 7674 */       this.accessType.setSelectedItem((Object)null);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 7680 */     changeAccess();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton34ActionPerformed(ActionEvent evt) {
/* 7685 */     if (this.companyName.getText().trim().isEmpty() || this.companyAddress.getText().trim().isEmpty() || this.CompanyContactPerson
/* 7686 */       .getText().trim().isEmpty() || this.companyTelephone.getText().trim().isEmpty() || this.companyEmail
/* 7687 */       .getText().trim().isEmpty() || this.CompanyopenDate.getDate().toString().trim().isEmpty()) {
/* 7688 */       JOptionPane.showMessageDialog(null, "Preencha Todos os Campos em Vazio");
/*      */     } else {
/* 7690 */       Company cmp1 = new Company();
/*      */ 
/*      */       
/* 7693 */       cmp1.setName(this.companyName.getText());
/* 7694 */       cmp1.setAddress(this.companyAddress.getText());
/* 7695 */       cmp1.setContact_person(this.CompanyContactPerson.getText());
/* 7696 */       cmp1.setTelephone(Integer.parseInt(this.companyTelephone.getText()));
/* 7697 */       cmp1.setEmail(this.companyEmail.getText());
/* 7698 */       cmp1.setOpen_date(((JTextField)this.CompanyopenDate.getDateEditor().getUiComponent()).getText());
/*      */       
/* 7700 */       CompanyDAO ddao = new CompanyDAO();
/* 7701 */       int camp_id = ddao.returnCompany().getCompany_id();
/* 7702 */       cmp1.setCompany_id(camp_id);
/* 7703 */       boolean result = ddao.updateCompany(cmp1);
/*      */       
/* 7705 */       if (result == true) {
/* 7706 */         JOptionPane.showMessageDialog(null, "Dados Da Empresa Salvos com Sucesso!");
/* 7707 */         this.companyName.setEnabled(false);
/* 7708 */         this.companyAddress.setEnabled(false);
/* 7709 */         this.CompanyContactPerson.setEnabled(false);
/* 7710 */         this.companyTelephone.setEnabled(false);
/* 7711 */         this.companyEmail.setEnabled(false);
/* 7712 */         this.CompanyopenDate.setEnabled(false);
/*      */       } else {
/* 7714 */         JOptionPane.showMessageDialog(null, "Erro ao Salvar");
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void companyEditActionPerformed(ActionEvent evt) {
/* 7721 */     this.companyName.setEnabled(true);
/* 7722 */     this.companyAddress.setEnabled(true);
/* 7723 */     this.CompanyContactPerson.setEnabled(true);
/* 7724 */     this.companyTelephone.setEnabled(true);
/* 7725 */     this.companyEmail.setEnabled(true);
/* 7726 */     this.CompanyopenDate.setEnabled(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void companyTelephoneKeyPressed(KeyEvent evt) {
/* 7731 */     char c = evt.getKeyChar();
/* 7732 */     if (c >= '0' && c <= '9') {
/* 7733 */       this.companyTelephone.setEditable(true);
/*      */     }
/* 7735 */     else if (evt.getExtendedKeyCode() == 8 || evt
/* 7736 */       .getExtendedKeyCode() == 127) {
/* 7737 */       this.companyTelephone.setEditable(true);
/*      */     } else {
/* 7739 */       this.companyTelephone.setEditable(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel52KeyPressed(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void comercialNamePointSellKeyReleased(KeyEvent evt) {
/* 7750 */     String search = this.comercialNamePointSell.getText().trim();
/*      */     
/* 7752 */     if (!search.equals("")) {
/* 7753 */       this.barCodePointSell.setEnabled(false);
/* 7754 */       reurnSuggestionSell(search);
/*      */     } else {
/*      */       
/* 7757 */       this.barCodePointSell.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void barCodePointSellKeyReleased(KeyEvent evt) {
/* 7764 */     String search = this.barCodePointSell.getText().trim();
/*      */     
/* 7766 */     if (!search.equals("")) {
/* 7767 */       this.comercialNamePointSell.setEnabled(false);
/*      */     } else {
/*      */       
/* 7770 */       this.comercialNamePointSell.setEnabled(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void listOfSuggestionsSellMouseClicked(MouseEvent evt) {
/* 7777 */     String text = this.listOfSuggestionsSell.getSelectedValue();
/* 7778 */     this.comercialNamePointSell.setText(text);
/* 7779 */     if (this.comercialNamePointSell.getText() != null) {
/* 7780 */       this.suggestionsPopUpSell.setVisible(false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void suggestionsPopUpSellMouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void addDrugBuyListActionPerformed(ActionEvent evt) {
/* 7790 */     if (this.buyListTb.getSelectedRow() != -1) {
/* 7791 */       Object drug_name = this.buyListTb.getValueAt(this.buyListTb.getSelectedRow(), 0);
/*      */       
/* 7793 */       Iterator<OrderDetails> it = this.orderSelldetails.iterator();
/* 7794 */       while (it.hasNext()) {
/* 7795 */         OrderDetails od = it.next();
/* 7796 */         if (od.getDrug().getGeneric_name() == drug_name) {
/* 7797 */           it.remove();
/*      */           
/* 7799 */           DefaultTableModel buylist = (DefaultTableModel)this.buyListTb.getModel();
/* 7800 */           buylist.removeRow(this.buyListTb.getSelectedRow());
/*      */         } 
/*      */       } 
/*      */     } else {
/*      */       
/* 7805 */       JOptionPane.showMessageDialog(null, "Selecione Produto!", "Erro", 2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 7812 */     emptySellPoint();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void ordersTableListKeyPressed(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void ordersTableListMouseClicked(MouseEvent evt) {
/* 7822 */     int order_id = ((Integer)this.ordersTableList.getValueAt(this.ordersTableList.getSelectedRow(), 0)).intValue();
/* 7823 */     readOrderDetaisTable(order_id);
/* 7824 */     readOrderPaymentMethodTable(order_id);
/*      */   }
/*      */   private void searchBySeller(String seller) {
/* 7827 */     TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(this.ordersTableList.getModel());
/* 7828 */     this.ordersTableList.setRowSorter(rowSorter);
/* 7829 */     if (seller == null) {
/* 7830 */       rowSorter.setRowFilter(null);
/*      */     } else {
/* 7832 */       rowSorter.setRowFilter(RowFilter.regexFilter(seller, new int[0]));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void normalView() {
/* 7841 */     this.InventorioBtn.setEnabled(false);
/* 7842 */     this.jLabel58.setEnabled(false);
/* 7843 */     MouseListener[] ml1 = this.jLabel58.getMouseListeners();
/* 7844 */     for (MouseListener m : ml1) {
/* 7845 */       this.jLabel58.removeMouseListener(m);
/*      */     }
/* 7847 */     MouseListener[] ml2 = this.jLabel59.getMouseListeners();
/* 7848 */     this.jLabel59.setEnabled(false);
/* 7849 */     for (MouseListener m : ml2) {
/* 7850 */       this.jLabel59.removeMouseListener(m);
/*      */     }
/*      */     
/* 7853 */     this.modificarStockBtn.setEnabled(false);
/* 7854 */     this.jLabel56.setEnabled(false);
/* 7855 */     MouseListener[] ml3 = this.jLabel56.getMouseListeners();
/* 7856 */     for (MouseListener m : ml3) {
/* 7857 */       this.jLabel56.removeMouseListener(m);
/*      */     }
/* 7859 */     MouseListener[] ml4 = this.jLabel55.getMouseListeners();
/* 7860 */     this.jLabel55.setEnabled(false);
/* 7861 */     for (MouseListener m : ml4) {
/* 7862 */       this.jLabel55.removeMouseListener(m);
/*      */     }
/*      */     
/* 7865 */     this.verFuncionariosBtn.setEnabled(false);
/* 7866 */     this.jLabel34.setEnabled(false);
/* 7867 */     MouseListener[] ml5 = this.jLabel34.getMouseListeners();
/* 7868 */     for (MouseListener m : ml5) {
/* 7869 */       this.jLabel34.removeMouseListener(m);
/*      */     }
/* 7871 */     MouseListener[] ml6 = this.jLabel36.getMouseListeners();
/* 7872 */     this.jLabel36.setEnabled(false);
/* 7873 */     for (MouseListener m : ml6) {
/* 7874 */       this.jLabel36.removeMouseListener(m);
/*      */     }
/*      */ 
/*      */     
/* 7878 */     this.modificarFuncionarioBtn.setEnabled(false);
/* 7879 */     this.jLabel47.setEnabled(false);
/* 7880 */     MouseListener[] ml7 = this.jLabel47.getMouseListeners();
/* 7881 */     for (MouseListener m : ml7) {
/* 7882 */       this.jLabel47.removeMouseListener(m);
/*      */     }
/* 7884 */     MouseListener[] ml8 = this.jLabel46.getMouseListeners();
/* 7885 */     this.jLabel46.setEnabled(false);
/* 7886 */     for (MouseListener m : ml8) {
/* 7887 */       this.jLabel46.removeMouseListener(m);
/*      */     }
/*      */ 
/*      */     
/* 7891 */     this.acessosBtn.setEnabled(false);
/* 7892 */     this.jLabel50.setEnabled(false);
/* 7893 */     MouseListener[] ml9 = this.jLabel50.getMouseListeners();
/* 7894 */     for (MouseListener m : ml9) {
/* 7895 */       this.jLabel50.removeMouseListener(m);
/*      */     }
/* 7897 */     MouseListener[] ml10 = this.jLabel49.getMouseListeners();
/* 7898 */     this.jLabel49.setEnabled(false);
/* 7899 */     for (MouseListener m : ml10) {
/* 7900 */       this.jLabel49.removeMouseListener(m);
/*      */     }
/*      */ 
/*      */     
/* 7904 */     this.modificarDadosDaEmpresaBtn.setEnabled(false);
/* 7905 */     this.jLabel53.setEnabled(false);
/* 7906 */     MouseListener[] ml11 = this.jLabel53.getMouseListeners();
/* 7907 */     for (MouseListener m : ml11) {
/* 7908 */       this.jLabel53.removeMouseListener(m);
/*      */     }
/* 7910 */     MouseListener[] ml12 = this.jLabel52.getMouseListeners();
/* 7911 */     this.jLabel52.setEnabled(false);
/* 7912 */     for (MouseListener m : ml12) {
/* 7913 */       this.jLabel52.removeMouseListener(m);
/*      */     }
/*      */     
/* 7916 */     this.jButton13.setEnabled(false);
/*      */   }
/*      */   
/*      */   private void searchByBillNr(String billNumber) {
/* 7920 */     TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(this.ordersTableList.getModel());
/* 7921 */     this.ordersTableList.setRowSorter(rowSorter);
/* 7922 */     if (billNumber == null) {
/* 7923 */       rowSorter.setRowFilter(null);
/*      */     } else {
/* 7925 */       rowSorter.setRowFilter(RowFilter.regexFilter(billNumber, new int[] { 0 }));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 7930 */     User u = (User)this.sellerComboBox.getSelectedItem();
/* 7931 */     String seller = u.getName();
/* 7932 */     searchBySeller(seller);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel125MouseClicked(MouseEvent evt) {
/* 7937 */     UserActivityDAO uad = new UserActivityDAO();
/* 7938 */     UserActivity ua = new UserActivity();
/* 7939 */     ua.setDate(getActualDate());
/* 7940 */     User user = this.loggedUser;
/* 7941 */     ua.setUser(user);
/*      */     
/* 7943 */     OrderDAO od = new OrderDAO();
/* 7944 */     double moneySoldByUser = 0.0D;
/* 7945 */     for (Order o : od.returnAllOrders()) {
/* 7946 */       if (o.getUser().getUser_id() == ua.getUser().getUser_id() && o
/* 7947 */         .getDate().equals(ua.getDate())) {
/* 7948 */         moneySoldByUser += o.getBill_money();
/*      */       }
/*      */     } 
/*      */     
/* 7952 */     ua.setMoney_sold(moneySoldByUser);
/*      */     
/* 7954 */     String total_sold_by_user = String.valueOf(moneySoldByUser);
/*      */ 
/*      */     
/* 7957 */     JPanel panel = new JPanel();
/* 7958 */     JLabel valorTotal = new JLabel("Total de Venda Hoje");
/* 7959 */     JTextField tField = new JTextField(10);
/* 7960 */     tField.setText(total_sold_by_user);
/* 7961 */     tField.enable(false);
/* 7962 */     JLabel senha = new JLabel("Senha Pessoal");
/* 7963 */     JTextField senhaField = new JTextField(15);
/* 7964 */     panel.add(valorTotal);
/* 7965 */     panel.add(tField);
/* 7966 */     panel.add(senha);
/* 7967 */     panel.add(senhaField);
/*      */     
/* 7969 */     UIManager.put("OptionPane.okButtonText", "Fechar Caixa");
/* 7970 */     UIManager.put("OptionPane.cancelButtonText", "Cancelar");
/*      */ 
/*      */     
/* 7973 */     int n = JOptionPane.showConfirmDialog(this, panel, "Fechar Caixa", 2, 3);
/*      */ 
/*      */     
/* 7976 */     String password = senhaField.getText();
/* 7977 */     String login = user.getLogin();
/*      */ 
/*      */     
/* 7980 */     UserDAO u = new UserDAO();
/* 7981 */     if (n == 0) {
/* 7982 */       boolean result = u.checkUserByLoginAndPassword(login, password);
/* 7983 */       if (result == true) {
/* 7984 */         u.updateUserAcessTime(user, getActualDate());
/*      */         
/* 7986 */         uad.saveActivity(ua);
/* 7987 */         printReport();
/* 7988 */         JOptionPane.showMessageDialog(this, "CAIXA FECHADO", "Fechar Caixa", 0);
/* 7989 */         dispose();
/*      */       } else {
/* 7991 */         JOptionPane.showMessageDialog(this, "SENHA INCORRETA", "Fechar Caixa", 0);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jLabel125MouseEntered(MouseEvent evt) {
/* 8000 */     this.jPanel56.setBackground(Color.red);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jLabel125MouseExited(MouseEvent evt) {
/* 8005 */     this.jPanel56.setBackground(new Color(0, 153, 153));
/*      */   }
/*      */ 
/*      */   
/*      */   private void barCodePointSellKeyPressed(KeyEvent evt) {
/* 8010 */     if (evt.getKeyCode() == 10 && this.addDrugSellPoint.isEnabled() == true)
/* 8011 */       addDrug(); 
/* 8012 */     if (evt.getKeyCode() == 38) {
/* 8013 */       this.comercialNamePointSell.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void comercialNamePointSellKeyPressed(KeyEvent evt) {
/* 8019 */     if (evt.getKeyCode() == 10 && this.addDrugSellPoint.isEnabled() == true) {
/* 8020 */       addDrug();
/*      */     }
/* 8022 */     if (evt.getKeyCode() == 38)
/* 8023 */       this.qtyTextSellPoint.requestFocus(true); 
/* 8024 */     if (evt.getKeyCode() == 40) {
/* 8025 */       this.barCodePointSell.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 8031 */     UIManager.put("OptionPane.okButtonText", "Sim");
/* 8032 */     UIManager.put("OptionPane.cancelButtonText", "Não");
/* 8033 */     int n = JOptionPane.showConfirmDialog(this, "Tem certeza de que deseja Sair?", "SAIR", 2, 3);
/*      */ 
/*      */     
/* 8036 */     if (n == 0) {
/* 8037 */       dispose();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void loginAccessKeyPressed(KeyEvent evt) {
/* 8043 */     if (evt.getKeyCode() == 40) {
/* 8044 */       this.passwordAccess.requestFocus(true);
/*      */     }
/* 8046 */     if (evt.getKeyCode() == 10) {
/* 8047 */       changeAccess();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void passwordAccessKeyPressed(KeyEvent evt) {
/* 8053 */     if (evt.getKeyCode() == 38) {
/* 8054 */       this.loginAccess.requestFocus(true);
/*      */     }
/* 8056 */     if (evt.getKeyCode() == 40) {
/* 8057 */       this.accessType.requestFocus(true);
/*      */     }
/* 8059 */     if (evt.getKeyCode() == 10) {
/* 8060 */       changeAccess();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void accessTypeKeyPressed(KeyEvent evt) {
/* 8066 */     if (evt.getKeyCode() == 38) {
/* 8067 */       this.passwordAccess.requestFocus(true);
/*      */     }
/* 8069 */     if (evt.getKeyCode() == 10) {
/* 8070 */       changeAccess();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void barCodeSaveKeyPressed(KeyEvent evt) {
/* 8076 */     if (evt.getKeyCode() == 40) {
/* 8077 */       this.genericNameSave.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void genericNameSaveKeyPressed(KeyEvent evt) {
/* 8083 */     if (evt.getKeyCode() == 40)
/* 8084 */       this.comercialNameSave.requestFocus(true); 
/* 8085 */     if (evt.getKeyCode() == 38) {
/* 8086 */       this.barCodeSave.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void comercialNameSaveKeyPressed(KeyEvent evt) {
/* 8092 */     if (evt.getKeyCode() == 40)
/* 8093 */       this.batchNrSave.requestFocus(true); 
/* 8094 */     if (evt.getKeyCode() == 38) {
/* 8095 */       this.genericNameSave.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void categSaveKeyPressed(KeyEvent evt) {
/* 8102 */     if (evt.getKeyCode() == 40)
/* 8103 */       this.qtySave.requestFocus(true); 
/* 8104 */     if (evt.getKeyCode() == 38) {
/* 8105 */       this.batchNrSave.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void unitSaveActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void unitSaveKeyPressed(KeyEvent evt) {
/* 8116 */     if (evt.getKeyCode() == 40)
/* 8117 */       this.manufacturerSave.requestFocus(true); 
/* 8118 */     if (evt.getKeyCode() == 38) {
/* 8119 */       this.qtySave.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void manufacturerSaveKeyPressed(KeyEvent evt) {
/* 8125 */     if (evt.getKeyCode() == 40)
/* 8126 */       this.supplierSave.requestFocus(true); 
/* 8127 */     if (evt.getKeyCode() == 38) {
/* 8128 */       this.unitSave.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void entryDateSaveKeyPressed(KeyEvent evt) {
/* 8134 */     if (evt.getKeyCode() == 40)
/* 8135 */       this.expireDateSave.requestFocus(true); 
/* 8136 */     if (evt.getKeyCode() == 38) {
/* 8137 */       this.manufacturerSave.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void expireDateSaveKeyPressed(KeyEvent evt) {
/* 8143 */     if (evt.getKeyCode() == 40)
/* 8144 */       this.prVendaSave.requestFocus(true); 
/* 8145 */     if (evt.getKeyCode() == 38) {
/* 8146 */       this.entryDateSave.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void supplierSaveKeyPressed(KeyEvent evt) {
/* 8152 */     if (evt.getKeyCode() == 40)
/* 8153 */       this.entryDateSave.requestFocus(true); 
/* 8154 */     if (evt.getKeyCode() == 38) {
/* 8155 */       this.manufacturerSave.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void barCodeEditTAKeyPressed(KeyEvent evt) {
/* 8161 */     if (evt.getKeyCode() == 40)
/* 8162 */       this.genericNameEditTA.requestFocus(true); 
/* 8163 */     if (evt.getKeyCode() == 10) {
/* 8164 */       saveEdition();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void genericNameEditTAKeyPressed(KeyEvent evt) {
/* 8170 */     if (evt.getKeyCode() == 40)
/* 8171 */       this.comercialNameEditTA.requestFocus(true); 
/* 8172 */     if (evt.getKeyCode() == 38) {
/* 8173 */       this.barCodeEditTA.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void comercialNameEditTAKeyPressed(KeyEvent evt) {
/* 8179 */     if (evt.getKeyCode() == 40)
/* 8180 */       this.batchNrEdit.requestFocus(true); 
/* 8181 */     if (evt.getKeyCode() == 38) {
/* 8182 */       this.genericNameEditTA.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void categoryEditKeyPressed(KeyEvent evt) {
/* 8188 */     if (evt.getKeyCode() == 40)
/* 8189 */       this.qtyEditTA.requestFocus(true); 
/* 8190 */     if (evt.getKeyCode() == 38) {
/* 8191 */       this.batchNrEdit.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void manufacturerEditKeyPressed(KeyEvent evt) {
/* 8197 */     if (evt.getKeyCode() == 40)
/* 8198 */       this.supplierEdit.requestFocus(true); 
/* 8199 */     if (evt.getKeyCode() == 38) {
/* 8200 */       this.unitEdit.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void unitEditKeyPressed(KeyEvent evt) {
/* 8206 */     if (evt.getKeyCode() == 40)
/* 8207 */       this.manufacturerEdit.requestFocus(true); 
/* 8208 */     if (evt.getKeyCode() == 38) {
/* 8209 */       this.qtyEditTA.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void supplierEditKeyPressed(KeyEvent evt) {
/* 8215 */     if (evt.getKeyCode() == 40)
/* 8216 */       this.entryDateEdit.requestFocus(true); 
/* 8217 */     if (evt.getKeyCode() == 38) {
/* 8218 */       this.manufacturerEdit.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void entryDateEditKeyPressed(KeyEvent evt) {
/* 8224 */     if (evt.getKeyCode() == 40)
/* 8225 */       this.expireDateEdit.requestFocus(true); 
/* 8226 */     if (evt.getKeyCode() == 38) {
/* 8227 */       this.supplierEdit.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void expireDateEditKeyPressed(KeyEvent evt) {
/* 8235 */     if (evt.getKeyCode() == 40)
/* 8236 */       this.sellPriceEdit.requestFocus(true); 
/* 8237 */     if (evt.getKeyCode() == 38) {
/* 8238 */       this.entryDateEdit.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void nameKeyPressed(KeyEvent evt) {
/* 8244 */     if (evt.getKeyCode() == 40) {
/* 8245 */       this.age.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void ageKeyPressed(KeyEvent evt) {
/* 8251 */     if (evt.getKeyCode() == 40)
/* 8252 */       this.gender.requestFocus(true); 
/* 8253 */     if (evt.getKeyCode() == 38) {
/* 8254 */       this.name.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void genderKeyPressed(KeyEvent evt) {
/* 8260 */     if (evt.getKeyCode() == 40)
/* 8261 */       this.salary.requestFocus(true); 
/* 8262 */     if (evt.getKeyCode() == 38) {
/* 8263 */       this.age.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void marital_statusKeyPressed(KeyEvent evt) {
/* 8269 */     if (evt.getKeyCode() == 40)
/* 8270 */       this.address.requestFocus(true); 
/* 8271 */     if (evt.getKeyCode() == 38) {
/* 8272 */       this.salary.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void addressKeyPressed(KeyEvent evt) {
/* 8278 */     if (evt.getKeyCode() == 40)
/* 8279 */       this.telephone.requestFocus(true); 
/* 8280 */     if (evt.getKeyCode() == 38) {
/* 8281 */       this.marital_status.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void academicKeyPressed(KeyEvent evt) {
/* 8288 */     if (evt.getKeyCode() == 38) {
/* 8289 */       this.telephone.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void nameEditKeyPressed(KeyEvent evt) {
/* 8295 */     if (evt.getKeyCode() == 40) {
/* 8296 */       this.ageEdit.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void ageEditKeyPressed(KeyEvent evt) {
/* 8302 */     if (evt.getKeyCode() == 40)
/* 8303 */       this.genderEdit.requestFocus(true); 
/* 8304 */     if (evt.getKeyCode() == 38) {
/* 8305 */       this.nameEdit.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void genderEditKeyPressed(KeyEvent evt) {
/* 8311 */     if (evt.getKeyCode() == 40)
/* 8312 */       this.salaryEdit.requestFocus(true); 
/* 8313 */     if (evt.getKeyCode() == 38) {
/* 8314 */       this.ageEdit.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void maritalStatusEditKeyPressed(KeyEvent evt) {
/* 8320 */     if (evt.getKeyCode() == 40)
/* 8321 */       this.addressEdit.requestFocus(true); 
/* 8322 */     if (evt.getKeyCode() == 38) {
/* 8323 */       this.salaryEdit.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void addressEditKeyPressed(KeyEvent evt) {
/* 8329 */     if (evt.getKeyCode() == 40)
/* 8330 */       this.telephoneEdit.requestFocus(true); 
/* 8331 */     if (evt.getKeyCode() == 38) {
/* 8332 */       this.maritalStatusEdit.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void academicEditKeyPressed(KeyEvent evt) {
/* 8338 */     if (evt.getKeyCode() == 38) {
/* 8339 */       this.telephoneEdit.requestFocus(true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void stockBarCodeSearchKeyPressed(KeyEvent evt) {
/* 8345 */     if (evt.getKeyCode() == 10) {
/* 8346 */       searchStock();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void stockNameSearchKeyPressed(KeyEvent evt) {
/* 8352 */     if (evt.getKeyCode() == 10) {
/* 8353 */       searchStock();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 8359 */     setOrderPaymentAndDetailsEmpty();
/* 8360 */     searchBySeller((String)null);
/* 8361 */     searchByBillNr((String)null);
/* 8362 */     readOrdersTable();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 8367 */     String initDate = ((JTextField)this.initDateField.getDateEditor().getUiComponent()).getText();
/*      */     
/* 8369 */     String finalDate = ((JTextField)this.finalDateField.getDateEditor().getUiComponent()).getText();
/*      */     
/* 8371 */     if (!initDate.isEmpty() && !finalDate.isEmpty()) {
/* 8372 */       printMonthReport(initDate, finalDate);
/*      */     } else {
/* 8374 */       JOptionPane.showMessageDialog(null, "Informe a data em vazio", "Campo Vazio", 2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void printMonthReport(String data1, String data2) {
/*      */     try {
/* 8382 */       Connection con = ConnectionFactory.getConnection();
/* 8383 */       String src = "/home/jose/NetBeansProjects/Pharmancy/src/reports/RelatorioVendasVariavel.jrxml";
/*      */ 
/*      */ 
/*      */       
/* 8387 */       JasperDesign jd = JRXmlLoader.load(src);
/* 8388 */       JRDesignQuery query = new JRDesignQuery();
/* 8389 */       query.setText("SELECT order_details.quantity AS Quantidade, order_details.total_price AS Preço_Total, stock.unit_sell_price AS Preço_Unidade, drug.comercial_name AS Nome, users.name AS Vendedor, order_sell.date AS Data\n\nFROM order_details \n    INNER JOIN order_sell ON order_details.order_id = order_sell.order_id\n    INNER JOIN stock ON  order_details.stock_id= stock.stock_id\n    INNER JOIN drug ON stock.drug_id= drug.drug_id\n    INNER JOIN users ON order_sell.user_id=users.user_id\nWHERE order_sell.date BETWEEN '" + data1 + "' AND '" + data2 + "' ORDER BY order_sell.date ASC");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 8397 */       jd.setQuery(query);
/* 8398 */       JasperReport jr = JasperCompileManager.compileReport(jd);
/*      */       
/* 8400 */       Map<String, Object> parameters = new HashMap<>();
/* 8401 */       parameters.put("ReportTitle", "De " + data1 + " a " + data2 + "");
/*      */       
/* 8403 */       JasperPrint jp = JasperFillManager.fillReport(jr, parameters, con);
/*      */       
/* 8405 */       JasperViewer.viewReport(jp, false);
/* 8406 */     } catch (JRException ex) {
/* 8407 */       Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void printReport() {
/*      */     try {
/* 8413 */       Connection con = ConnectionFactory.getConnection();
/* 8414 */       String src = "/home/jose/NetBeansProjects/Pharmancy/src/reports/RelatorioVendas.jrxml";
/* 8415 */       String date = getActualDate();
/*      */ 
/*      */       
/* 8418 */       JasperDesign jd = JRXmlLoader.load(src);
/* 8419 */       JRDesignQuery query = new JRDesignQuery();
/* 8420 */       query.setText("SELECT order_details.quantity AS Quantidade, order_details.total_price AS Preço_Total, stock.unit_sell_price AS Preço_Unidade, drug.comercial_name AS Nome, users.name AS Vendedor, order_sell.date AS Data\n\nFROM order_details\n    INNER JOIN order_sell ON order_details.order_id = order_sell.order_id\n    INNER JOIN stock ON  order_details.stock_id= stock.stock_id\n    INNER JOIN drug ON stock.drug_id= drug.drug_id\n    INNER JOIN users ON order_sell.user_id=users.user_id\n    WHERE order_sell.date='" + date + "' ORDER BY order_sell.date ASC");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 8428 */       jd.setQuery(query);
/* 8429 */       JasperReport jr = JasperCompileManager.compileReport(jd);
/* 8430 */       JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
/*      */       
/* 8432 */       JasperViewer.viewReport(jp, false);
/* 8433 */     } catch (JRException ex) {
/* 8434 */       Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */     } 
/*      */   }
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 8438 */     printReport();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void main(String[] args) {
/*      */     try {
/* 8451 */       for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
/* 8452 */         if ("Nimbus".equals(info.getName())) {
/* 8453 */           UIManager.setLookAndFeel(info.getClassName());
/*      */           break;
/*      */         } 
/*      */       } 
/* 8457 */     } catch (ClassNotFoundException ex) {
/* 8458 */       Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 8459 */     } catch (InstantiationException ex) {
/* 8460 */       Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 8461 */     } catch (IllegalAccessException ex) {
/* 8462 */       Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 8463 */     } catch (UnsupportedLookAndFeelException ex) {
/* 8464 */       Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 8469 */     EventQueue.invokeLater(new Runnable() {
/*      */           public void run() {
/* 8471 */             (new mainWindow()).setVisible(true);
/*      */           }
/*      */         });
/*      */   }
/*      */ }


/* Location:              /home/jose/Documents/FarSetUp/bin/PharmancyV2.jar!/views/mainWindow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */