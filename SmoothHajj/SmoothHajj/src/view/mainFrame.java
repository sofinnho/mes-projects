/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Entities.Extra;
import Entities.Login;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.Vector;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import tools.JDatePickerPanel;
import utils.Setting;
import view.Hadj.HadjMan;
/**
 *
 * @author Amine
 */
public class mainFrame extends javax.swing.JFrame {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("ExtraPU");
    private EntityManager manager = factory.createEntityManager();
    
    public static final String Theme = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
    public static JDatePickerPanel JDatePickerPanel;
    
    public Login login;
    
    public static String uname = "decharge@abousofiane.com";
    public static String pwd   = "$MohamedAnis2013$";
    
    public Timer timer = new Timer();
    /**
     * Creates new form MainFrame
     */
    public mainFrame(Login l) {
        setWindowStyle();
        //setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        login = l;
        if(login.getUserType().equals("admin")) {
            UserPanel.setBackground(Color.blue);
        } else if(login.getUsername().toLowerCase().equals("zone")) {
            
            tbClients.setEnabled(false);
            
        } else if(login.getUsername().toLowerCase().equals("commercial")) {
            
        }
        Username.setText(login.getUsername());
        
        refreshLists();
        
        tbClientsActionPerformed(null);
    }
    
    private void setWindowStyle() {
        try{
            manager.getTransaction().begin();
            Extra EXT = manager.createNamedQuery("Extra.GetExtra", Extra.class).getSingleResult();
            UIManager.setLookAndFeel("com.jtattoo.plaf."+EXT.getTheme());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        initComponents();
        
        //this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        // Set Windows Icon
        List<Image> icons = new ArrayList<Image>();
        icons.add(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        this.setIconImages(icons);
        // Set Window In Screen Center
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    private void refreshLists() {
        //Vector<String> results = listFiles();
        //Folders.setListData(results);
    }
    
    private Vector<String> listFiles() {
        Vector<String> results = new Vector<String>();
        try {
            String path = new File(".").getCanonicalPath();
            path = path+"/Data/";
            File[] files = new File(path).listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    if(!file.getName().contains("trace")) results.add(file.getName().substring(0, file.getName().indexOf(".")));
                }
            }
            //System.out.println(results.toString());
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur survenue lors de la recherche de dossiers !");
            System.exit(-1);
        }
        return results;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DP = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        tbClients = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        tbSetting = new javax.swing.JButton();
        UserPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        General = new javax.swing.JMenu();
        mDisconnect = new javax.swing.JMenuItem();
        mExit = new javax.swing.JMenuItem();
        File = new javax.swing.JMenu();
        Setup = new javax.swing.JMenu();
        mSettings = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mOutils = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hackathon");
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        DP.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DP.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DPMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout DPLayout = new javax.swing.GroupLayout(DP);
        DP.setLayout(DPLayout);
        DPLayout.setHorizontalGroup(
            DPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DPLayout.setVerticalGroup(
            DPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        tbClients.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/client32.png"))); // NOI18N
        tbClients.setToolTipText("Livreur");
        tbClients.setFocusable(false);
        tbClients.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbClients.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbClientsActionPerformed(evt);
            }
        });
        jToolBar1.add(tbClients);
        jToolBar1.add(jSeparator2);

        tbSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/production32.png"))); // NOI18N
        tbSetting.setFocusable(false);
        tbSetting.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbSetting.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbSettingActionPerformed(evt);
            }
        });
        jToolBar1.add(tbSetting);

        UserPanel.setBackground(new java.awt.Color(115, 176, 154));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/help.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Wellcome");

        jLabel3.setText("Mr.");

        Username.setText("admin");

        javax.swing.GroupLayout UserPanelLayout = new javax.swing.GroupLayout(UserPanel);
        UserPanel.setLayout(UserPanelLayout);
        UserPanelLayout.setHorizontalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(UserPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Username)))
                .addContainerGap())
        );
        UserPanelLayout.setVerticalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(UserPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Username)))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        General.setText("General");

        mDisconnect.setText("Se deconnecter");
        mDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mDisconnectActionPerformed(evt);
            }
        });
        General.add(mDisconnect);

        mExit.setText("Quitter");
        mExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mExitActionPerformed(evt);
            }
        });
        General.add(mExit);

        jMenuBar1.add(General);

        File.setText("File");
        jMenuBar1.add(File);

        Setup.setText("Setup");

        mSettings.setText("Components");
        mSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSettingsActionPerformed(evt);
            }
        });
        Setup.add(mSettings);

        jMenuBar1.add(Setup);

        jMenu2.setText("Annexes");
        jMenuBar1.add(jMenu2);

        mOutils.setText("Tools");
        jMenuBar1.add(mOutils);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(UserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1054, Short.MAX_VALUE))
            .addComponent(DP)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JDesktopPane getDesktopPane() {
        return DP;
    }
    
    private void DPMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DPMouseMoved
        //System.out.println(evt.getX());
        //if(evt.getX() < 30) HyperLinks.setVisible(true); else HyperLinks.setVisible(false);
    }//GEN-LAST:event_DPMouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        
    }//GEN-LAST:event_formMouseMoved

    public javax.swing.JDesktopPane getDP() {
        return DP;
    }
    
    private void mSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSettingsActionPerformed
        
    }//GEN-LAST:event_mSettingsActionPerformed

    private void mExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mExitActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Voulez Vous Vraiment Quitter ?", "alert", JOptionPane.OK_CANCEL_OPTION) == 0)
        System.exit(0);
    }//GEN-LAST:event_mExitActionPerformed

    private void mDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDisconnectActionPerformed
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mDisconnectActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        timer.cancel();
        timer.purge();
    }//GEN-LAST:event_formWindowClosed

    private void tbClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbClientsActionPerformed
        HadjMan HadjMan = new HadjMan(this);
        DP.add(HadjMan);
        HadjMan.setVisible(true);
    }//GEN-LAST:event_tbClientsActionPerformed

    private void tbSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbSettingActionPerformed
        new Setting(this).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tbSettingActionPerformed

    public boolean delBonDechargeEmails() {
        boolean deleted = true;
        String hostval = "pop.ipage.com";
        try {
            Properties propvals = new Properties();
            propvals.put("mail.pop3.host", hostval);
            propvals.put("mail.pop3.port", "995");
            propvals.put("mail.pop3.starttls.enable", "true");
            Session emailSessionObj = Session.getDefaultInstance(propvals);  
            //Create POP3 store object and connect with the server
            Store storeObj = emailSessionObj.getStore("pop3s");
            storeObj.connect(hostval, uname, pwd);
            //Create folder object and open it in read-only mode
            Folder emailFolderObj = storeObj.getFolder("INBOX");
            emailFolderObj.open(Folder.READ_WRITE);
            //Fetch messages from the folder and print in a loop
            Message[] messageobjs = emailFolderObj.getMessages(); 
            for (int i = 0, n = messageobjs.length; i < n; i++) {
                Message indvidualmsg = messageobjs[i];
                indvidualmsg.setFlag(Flags.Flag.DELETED, true);
            }
            emailFolderObj.close(true);
            storeObj.close();
            deleted = true;
        } catch (Exception exp) {
            exp.printStackTrace();
            deleted = false;
        }
        
        return deleted;
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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login login = new Login(); login.setUsername("admin"); login.setPassword("*****"); login.setUserType("commercial");
                new mainFrame(login).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DP;
    private javax.swing.JMenu File;
    private javax.swing.JMenu General;
    private javax.swing.JMenu Setup;
    private javax.swing.JPanel UserPanel;
    private javax.swing.JLabel Username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mDisconnect;
    private javax.swing.JMenuItem mExit;
    private javax.swing.JMenu mOutils;
    private javax.swing.JMenuItem mSettings;
    private javax.swing.JButton tbClients;
    private javax.swing.JButton tbSetting;
    // End of variables declaration//GEN-END:variables
}
