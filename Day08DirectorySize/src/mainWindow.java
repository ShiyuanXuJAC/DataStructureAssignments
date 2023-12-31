
import java.io.File;
import javax.swing.JFileChooser;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP
 */
public class mainWindow extends javax.swing.JFrame {

  /**
   * Creates new form mainWindow
   */
  public mainWindow() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    btChooseDir = new javax.swing.JButton();
    sizeNonRecursive = new javax.swing.JLabel();
    sizeRecursive = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    btChooseDir.setText("Choose a directory");
    btChooseDir.setName("btChooseDir"); // NOI18N
    btChooseDir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btChooseDirActionPerformed(evt);
      }
    });

    sizeNonRecursive.setText("...");

    sizeRecursive.setText("...");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(79, 79, 79)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(btChooseDir, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
          .addComponent(sizeNonRecursive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(sizeRecursive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(54, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(btChooseDir)
        .addGap(39, 39, 39)
        .addComponent(sizeNonRecursive)
        .addGap(18, 18, 18)
        .addComponent(sizeRecursive)
        .addContainerGap(31, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private static long calDirSize(File dir) {
    long size = 0;
    if (dir.isDirectory()) {
      File[] files = dir.listFiles();
      if (files != null) {
        for (File file : files) {
          if (file.isFile()) {
            size += file.length();
          }
        }
      }
    }
    return size;
  }
  
  private static long calDirSizeRecursive(File dir){
    long size=0;
    if (dir.isDirectory()){
      File[] files=dir.listFiles();
      if (files!=null){
        for (File file:files){
          if (file.isFile()){
            size+=file.length();
          }else if (file.isDirectory()){
            size+=calDirSizeRecursive(file);
          }
        }
      }
    }
    return size;
  }
  private void btChooseDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChooseDirActionPerformed
    // TODO add your handling code here:
    JFileChooser chooser=JFileChooserHelper.getChooser();
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle("choose a dir");
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setAcceptAllFileFilterUsed(false);
    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//      System.out.println("getCurrentDirectory(): "
//              + chooser.getCurrentDirectory());
//      System.out.println("getSelectedFile() : "
//              + chooser.getSelectedFile());
      double sizeKb = calDirSize(chooser.getSelectedFile()) / 1024.0;
      double sizeKbRecursive = calDirSizeRecursive(chooser.getSelectedFile()) / 1024.0;
      sizeNonRecursive.setText(String.format("size(non-recursive): %.2f kB", sizeKb));
      sizeRecursive.setText(String.format("size(recursive): %.2f kB", sizeKbRecursive));
    } else {
      System.out.println("No Selection ");
    }
  }//GEN-LAST:event_btChooseDirActionPerformed

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
      java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new mainWindow().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btChooseDir;
  private javax.swing.JLabel sizeNonRecursive;
  private javax.swing.JLabel sizeRecursive;
  // End of variables declaration//GEN-END:variables
}
