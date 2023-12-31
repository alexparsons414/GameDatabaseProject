/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Core.Employees;
import DAO.EmployeesDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Doubl
 */
public class EmployeesUpdate extends javax.swing.JDialog {

    private EmployeesDAO employeesDAO;
    private TablesDisplay tablesDisplay;
    
    public EmployeesUpdate(TablesDisplay tablesDisplay, EmployeesDAO employeesDAO){
        this.employeesDAO = employeesDAO;
        this.tablesDisplay = tablesDisplay;
        initComponents();
        this.setTitle("Employee");
    }
    /**
     * Creates new form EmployeesUpdate
     */
    public EmployeesUpdate(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dobText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fText = new javax.swing.JTextField();
        zipText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        stateText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cityText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        addressText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ssnText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        corporateText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        districtText = new javax.swing.JTextField();
        storeText = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        managerText = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        positionText = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        sexText = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        salaryText = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        delete1 = new javax.swing.JButton();
        update1 = new javax.swing.JButton();
        submit1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel7.setText("Date of Birth (YYYY/MM/DD)");

        jLabel9.setText("Last Name");

        jLabel4.setText("First Name");

        jLabel6.setText("Zip Code");

        jLabel5.setText("State");

        jLabel3.setText("City");

        jLabel2.setText("Address");

        jLabel1.setText("SSN*");

        jLabel10.setText("Corporate ID");

        jLabel11.setText("District ID");

        jLabel12.setText("Game Store ID");

        jLabel13.setText("Manager SSN");

        jLabel14.setText("Position");

        jLabel15.setText("Sex");

        jLabel16.setText("Salary");

        delete1.setText("Delete");
        delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete1ActionPerformed(evt);
            }
        });

        update1.setText("Update Existing");
        update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update1ActionPerformed(evt);
            }
        });

        submit1.setText("Submit New");
        submit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Fields with * are required");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(corporateText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(districtText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(storeText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(managerText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(positionText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dobText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zipText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ssnText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submit1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(update1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete1)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(ssnText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(stateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(zipText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(fText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(lText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(dobText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(salaryText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(sexText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(positionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(managerText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(storeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(districtText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(corporateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(delete1)
                        .addComponent(update1)
                        .addComponent(submit1))
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete1ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_delete1ActionPerformed

    private void update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update1ActionPerformed
        update();
    }//GEN-LAST:event_update1ActionPerformed

    private void submit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit1ActionPerformed
        save();
    }//GEN-LAST:event_submit1ActionPerformed

    protected void update(){
        try{
            String ssn = ssnText.getText(), fName = fText.getText(), 
                    lName = lText.getText(), address = addressText.getText(), 
                    city = cityText.getText(), state = stateText.getText(), 
                    zip = zipText.getText(), 
                    dob = dobText.getText(), sex = sexText.getText(), 
                    position = positionText.getText(),
                    manager = managerText.getText();
            int salary, gameStoreID, districtID, corporateID;
            if(salaryText.getText().equals("")){
                salary = -1;
            }
            else{
                salary = Integer.parseInt(salaryText.getText());
            }
            if(storeText.getText().equals("")){
                gameStoreID = -1;
            }
            else{
                gameStoreID = Integer.parseInt(storeText.getText());
            }
            if(districtText.getText().equals("")){
                districtID = -1;
            }
            else{
                districtID = Integer.parseInt(districtText.getText());
            }
            if(corporateText.getText().equals("")){
                corporateID = -1;
            }
            else{
                corporateID = Integer.parseInt(corporateText.getText());
            }
            if(fName.equals("")){
                fName = null;
            }
            if(lName.equals("")){
                lName = null;
            }
            if(address.equals("")){
                address = null;
            }
            if(city.equals("")){
                city = null;
            }
            if(state.equals("")){
                state = null;
            }
            if(zip.equals("")){
                zip = null;
            }
            if(dob.equals("")){
                dob = null;
            }
            if(manager.equals("")){
                    manager = null;
            }
            if(position.equals("")){
                    position = null;
            }
            if(sex.equals("")){
                    sex = null;
            }
            Employees temp = new Employees(ssn, address, city, state, zip, 
                    fName, lName, dob, sex, position, manager, gameStoreID, 
                    districtID, corporateID, salary);
            try{
                employeesDAO.update(temp);
                setVisible(false);
                dispose();
                tablesDisplay.refreshView();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(tablesDisplay,"Error updating "
                        + "employee: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: Please enter an integer.");
        }
    }
    
    protected void save(){
        try{
            String ssn = ssnText.getText(), fName = fText.getText(), 
                    lName = lText.getText(), address = addressText.getText(), 
                    city = cityText.getText(), state = stateText.getText(), 
                    zip = zipText.getText(), 
                    dob = dobText.getText(), sex = sexText.getText(), 
                    position = positionText.getText(),
                    manager = managerText.getText();
            int salary, gameStoreID, districtID, corporateID;
            if(salaryText.getText().equals("")){
                salary = -1;
            }
            else{
                salary = Integer.parseInt(salaryText.getText());
            }
            if(storeText.getText().equals("")){
                gameStoreID = -1;
            }
            else{
                gameStoreID = Integer.parseInt(storeText.getText());
            }
            if(districtText.getText().equals("")){
                districtID = -1;
            }
            else{
                districtID = Integer.parseInt(districtText.getText());
            }
            if(corporateText.getText().equals("")){
                corporateID = -1;
            }
            else{
                corporateID = Integer.parseInt(corporateText.getText());
            }
            if(fName.equals("")){
                fName = null;
            }
            if(lName.equals("")){
                lName = null;
            }
            if(address.equals("")){
                address = null;
            }
            if(city.equals("")){
                city = null;
            }
            if(state.equals("")){
                state = null;
            }
            if(zip.equals("")){
                zip = null;
            }
            if(dob.equals("")){
                dob = null;
            }
            if(manager.equals("")){
                    manager = null;
            }
            if(position.equals("")){
                    position = null;
            }
            if(sex.equals("")){
                    sex = null;
            }
            Employees temp = new Employees(ssn, address, city, state, zip, 
                    fName, lName, dob, sex, position, manager, gameStoreID, 
                    districtID, corporateID, salary);
            try{
                employeesDAO.addEmployee(temp);
                setVisible(false);
                dispose();
                tablesDisplay.refreshView();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(tablesDisplay,"Error adding "
                        + "employee: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: Please enter fields with correct information.");
        }
    }
    
    protected void delete(){
        try{
            String ssn = ssnText.getText(), fName = fText.getText(), 
                    lName = lText.getText(), address = addressText.getText(), 
                    city = cityText.getText(), state = stateText.getText(), 
                    zip = zipText.getText(), 
                    dob = dobText.getText(), sex = sexText.getText(), 
                    position = positionText.getText(),
                    manager = managerText.getText();
            int salary, gameStoreID, districtID, corporateID;
            if(salaryText.getText().equals("")){
                salary = -1;
            }
            else{
                salary = Integer.parseInt(salaryText.getText());
            }
            if(storeText.getText().equals("")){
                gameStoreID = -1;
            }
            else{
                gameStoreID = Integer.parseInt(storeText.getText());
            }
            if(districtText.getText().equals("")){
                districtID = -1;
            }
            else{
                districtID = Integer.parseInt(districtText.getText());
            }
            if(corporateText.getText().equals("")){
                corporateID = -1;
            }
            else{
                corporateID = Integer.parseInt(corporateText.getText());
            }
            if(fName.equals("")){
                fName = null;
            }
            if(lName.equals("")){
                lName = null;
            }
            if(address.equals("")){
                address = null;
            }
            if(city.equals("")){
                city = null;
            }
            if(state.equals("")){
                state = null;
            }
            if(zip.equals("")){
                zip = null;
            }
            if(dob.equals("")){
                dob = null;
            }
            if(manager.equals("")){
                    manager = null;
            }
            if(position.equals("")){
                    position = null;
            }
            if(sex.equals("")){
                    sex = null;
            }
            Employees temp = new Employees(ssn, address, city, state, zip, 
                    fName, lName, dob, sex, position, manager, gameStoreID, 
                    districtID, corporateID, salary);
            try{
                employeesDAO.delete(temp);
                setVisible(false);
                dispose();
                tablesDisplay.refreshView();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(tablesDisplay,"Error deleting "
                        + "employee: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: Please enter fields with correct information.");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeesUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeesUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeesUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeesUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EmployeesUpdate dialog = new EmployeesUpdate(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressText;
    private javax.swing.JTextField cityText;
    private javax.swing.JTextField corporateText;
    private javax.swing.JButton delete1;
    private javax.swing.JTextField districtText;
    private javax.swing.JTextField dobText;
    private javax.swing.JTextField fText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lText;
    private javax.swing.JTextField managerText;
    private javax.swing.JTextField positionText;
    private javax.swing.JTextField salaryText;
    private javax.swing.JTextField sexText;
    private javax.swing.JTextField ssnText;
    private javax.swing.JTextField stateText;
    private javax.swing.JTextField storeText;
    private javax.swing.JButton submit1;
    private javax.swing.JButton update1;
    private javax.swing.JTextField zipText;
    // End of variables declaration//GEN-END:variables
}
