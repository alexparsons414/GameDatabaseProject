/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane;
import DAO.GameDAO;
import Core.Game;
/**
 *
 * @author Doubl
 */
public class GameUpdate extends javax.swing.JDialog {

    private GameDAO gameDAO;
    private TablesDisplay tablesDisplay;
    
    public GameUpdate(TablesDisplay tablesDisplay, GameDAO gameDAO){
        this.gameDAO = gameDAO;
        this.tablesDisplay = tablesDisplay;
        initComponents();
        this.setTitle("Game");
    }
    /**
     * Creates new form GameUpdate
     */
    public GameUpdate(java.awt.Frame parent, boolean modal) {
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

        consoleText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ratingText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        publisherText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        submit1 = new javax.swing.JButton();
        update1 = new javax.swing.JButton();
        delete1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Product ID* (Must belong to existing product)");

        jLabel2.setText("Console");

        jLabel3.setText("Rating (#0-10)");

        jLabel5.setText("Publisher");

        jLabel8.setText("Fields with * are required");

        submit1.setText("Submit New");
        submit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit1ActionPerformed(evt);
            }
        });

        update1.setText("Update Existing");
        update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update1ActionPerformed(evt);
            }
        });

        delete1.setText("Delete");
        delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(publisherText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ratingText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(consoleText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submit1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(consoleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(ratingText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(publisherText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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

    private void submit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit1ActionPerformed
        save();
    }//GEN-LAST:event_submit1ActionPerformed

    private void update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update1ActionPerformed
        update();
    }//GEN-LAST:event_update1ActionPerformed

    private void delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete1ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_delete1ActionPerformed

    protected void update(){
        try{
            int id = Integer.parseInt(idText.getText());
            String console = consoleText.getText(), publisher = publisherText.getText(), rating;
            if(console.equals("")){
                console = null;
            }
            if(publisher.equals("")){
                publisher = null;
            }
            if(ratingText.getText().equals("")){
                rating = null;
            }
            else if(Integer.parseInt(ratingText.getText()) > 10 || Integer.parseInt(ratingText.getText()) < 0){
                JOptionPane.showMessageDialog(this, "Error: Rating out of bounds. Rating not saved");
                rating = null;
            }
            else{
                rating = ratingText.getText() + "/10";
            }
            Game temp = new Game(id, console, rating, publisher);
            try{
                gameDAO.update(temp);
                setVisible(false);
                dispose();
                tablesDisplay.refreshView();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(tablesDisplay,"Error updating "
                        + "game: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: Please enter fields with correct information.");
        }
    }
    
    protected void save(){
        try{
            int id = Integer.parseInt(idText.getText());
            String console = consoleText.getText(), publisher = publisherText.getText(), rating;
            if(console.equals("")){
                console = null;
            }
            if(publisher.equals("")){
                publisher = null;
            }
            if(ratingText.getText().equals("")){
                rating = null;
            }
            else if(Integer.parseInt(ratingText.getText()) > 10 || Integer.parseInt(ratingText.getText()) < 0){
                JOptionPane.showMessageDialog(this, "Error: Rating out of bounds. Rating not saved");
                rating = null;
            }
            else{
                rating = ratingText.getText() + "/10";
            }
            Game temp = new Game(id, console, rating, publisher);
            try{
                gameDAO.addGame(temp);
                setVisible(false);
                dispose();
                tablesDisplay.refreshView();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(tablesDisplay,"Error adding "
                        + "game: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error: Please enter fields with correct informations.");
        }
    }
    
    protected void delete(){
        try{
            int id = Integer.parseInt(idText.getText());
            String console = consoleText.getText(), publisher = publisherText.getText(), rating;
            if(console.equals("")){
                console = null;
            }
            if(publisher.equals("")){
                publisher = null;
            }
            if(ratingText.getText().equals("")){
                rating = null;
            }
            else{
                rating = ratingText.getText() + "/10";
            }
            Game temp = new Game(id, console, rating, publisher);
            try{
                gameDAO.delete(temp);
                setVisible(false);
                dispose();
                tablesDisplay.refreshView();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(tablesDisplay,"Error deleting "
                        + "game: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(GameUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GameUpdate dialog = new GameUpdate(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField consoleText;
    private javax.swing.JButton delete1;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField publisherText;
    private javax.swing.JTextField ratingText;
    private javax.swing.JButton submit1;
    private javax.swing.JButton update1;
    // End of variables declaration//GEN-END:variables
}
