package Vista;

import Controlador.Dao.Modelo.personaDao;
import Controlador.Dao.Modelo.simulacionDao;
import Controlador.TDA.ListaDinamica.DynamicList;
import Controlador.Tda.listas.Exepciones.EmptyList;
import Modelo.Tramite;
import Vista.Tabla.Tabla2;
import Vista.Tabla.Tabla1;
import Vista.Tabla.Tabla3;
import Vista.Tabla.TablaSimulacion;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Elias
 */
public class VistaSimulacion extends javax.swing.JFrame {
    personaDao personalesDao = new personaDao();
    simulacionDao simulacionDao = new simulacionDao();
    Tabla2 mtp = new Tabla2();
    Tabla1 mtp2 = new Tabla1();
    Tabla3 mtp3 = new Tabla3();
    TablaSimulacion mts = new TablaSimulacion();

  
    public VistaSimulacion() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void CargarSimulacion() throws EmptyList {
        mts.setPersonasTabla(simulacionDao.getListSimulacion());
        tblAtendidos.setModel(mts);
        tblAtendidos.updateUI();
    }

    private void CargarTabla() throws EmptyList {
        int numero = Integer.parseInt(txtTramites.getText());
        mtp.setPersonasTabla(tramiteAleatorio(numero));
        tblVentanilla1.setModel(mtp);
        tblVentanilla1.updateUI();
    }

    private void CargarTabla2() throws EmptyList {
        int numero2 = Integer.parseInt(txtTramites.getText());
        mtp2.setPersonasTabla(tramiteAleatorio(numero2));
        tblVentanilla2.setModel(mtp2);
        tblVentanilla2.updateUI();
    }
    
    private void CargarTabla3() throws EmptyList {
        int numero3 = Integer.parseInt(txtTramites.getText());
        mtp3.setPersonasTabla(tramiteAleatorio(numero3));
        tblVentanilla3.setModel(mtp3);
        tblVentanilla3.updateUI();
    }

    public Tramite aleatorio() {
        Random random = new Random();
        int tramiteEjecutar = random.nextInt(4);
        try {
            for (int i = 0; i < personalesDao.getListPersonas().getLength(); i++) {
                personalesDao.getListPersonas().getInfo(i);
            }
        } catch (Exception e) {
        }
        switch (tramiteEjecutar) {
            case 0:
                return new Tramite(null, "Cambio de clave", 4);
            case 1:
                return new Tramite(null, "Actualizacion de datos", 7);
            case 2:
                return new Tramite(null, "Asignacion afiliados", 15);
            case 3:
                return new Tramite(null, "Recuperacion de clave", 3);
            default:
                return null;
        }
    }

    public DynamicList<Tramite> tramiteAleatorio(int cantidad) throws EmptyList {
        DynamicList<Tramite> tramites = new DynamicList<>();
        for (int i = 0; i < cantidad; i++) {
            Tramite tramite = aleatorio();
            tramites.Agregar(tramite);
        }
        return tramites;
    }
    
    private void Ventanilla1() {
        int fila = tblVentanilla1.getSelectedRow();
        if(fila < 0){
            JOptionPane.showMessageDialog(null, "Escoga una casilla");
        }
        else{
            try {
                personalesDao.setPersona(mtp.getPersonasTabla().getInfo(fila));
                System.out.println(""+personalesDao.getPersona());
            } 
            catch (Exception e) {
            }
        }
    }
    
    private void Guardar() throws EmptyList {
        int filas = tblVentanilla1.getSelectedRow();
        Integer dg = (Integer) tblVentanilla1.getValueAt(filas, 0);
        String sasddasd = tblVentanilla1.getValueAt(filas, 1).toString();
        Integer za = (Integer) tblVentanilla1.getValueAt(filas, 2);
        Tramite g = new Tramite(dg, sasddasd, za);
        Integer IdPersona = personalesDao.getListPersonas().getLength() + 1;
        Integer IdPerson = simulacionDao.getListSimulacion().getLength() + 1;
        simulacionDao.getSimulacion().setIdSimulacion(IdPersona);
        simulacionDao.getSimulacion().setNumPersonas(IdPerson);
        simulacionDao.getSimulacion().setTotal(za);
        simulacionDao.getSimulacion().setPersona(g);
        if (simulacionDao.Persist()) {
            JOptionPane.showMessageDialog(null, "Correcto", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void Ventanilla2() {
        int fila = tblVentanilla2.getSelectedRow();
        if(fila < 0){
            JOptionPane.showMessageDialog(null, "Escoga una casilla");
        }
        else{
            try {
                personalesDao.setPersona(mtp.getPersonasTabla().getInfo(fila));
                System.out.println(""+personalesDao.getPersona());
            } 
            catch (Exception e) {
            }
        }
    }
    
    private void Guardar2() throws EmptyList {
        int filas = tblVentanilla2.getSelectedRow();
        Integer dg = (Integer) tblVentanilla2.getValueAt(filas, 0);
        String sasddasd = tblVentanilla2.getValueAt(filas, 1).toString();
        Integer za = (Integer) tblVentanilla2.getValueAt(filas, 2);
        Tramite g = new Tramite(dg, sasddasd, za);
        Integer IdPersona = personalesDao.getListPersonas().getLength() + 1;
        Integer IdPerson = simulacionDao.getListSimulacion().getLength() + 1;
        simulacionDao.getSimulacion().setIdSimulacion(IdPersona);
        simulacionDao.getSimulacion().setNumPersonas(IdPerson);
        simulacionDao.getSimulacion().setTotal(za);
        simulacionDao.getSimulacion().setPersona(g);
        if (simulacionDao.Persist()) {
            JOptionPane.showMessageDialog(null, "Correcto", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void Ventanilla3() {
        int fila = tblVentanilla3.getSelectedRow();
        if(fila < 0){
            JOptionPane.showMessageDialog(null, "Escoga una casilla");
        }
        else{
            try {
                personalesDao.setPersona(mtp.getPersonasTabla().getInfo(fila));
                System.out.println(""+personalesDao.getPersona());
            } 
            catch (Exception e) {
            }
        }
    }
    
    private void Guardar3() throws EmptyList {
        int filas = tblVentanilla3.getSelectedRow();
        Integer dg = (Integer) tblVentanilla3.getValueAt(filas, 0);
        String sasddasd = tblVentanilla3.getValueAt(filas, 1).toString();
        Integer za = (Integer) tblVentanilla3.getValueAt(filas, 2);
        Tramite g = new Tramite(dg, sasddasd, za);
        Integer IdPersona = personalesDao.getListPersonas().getLength() + 1;
        Integer IdPersonSa = simulacionDao.getListSimulacion().getLength() + 1;
        simulacionDao.getSimulacion().setIdSimulacion(IdPersona);
        simulacionDao.getSimulacion().setNumPersonas(IdPersonSa);
        simulacionDao.getSimulacion().setTotal(za);
        simulacionDao.getSimulacion().setPersona(g);
        if (simulacionDao.Persist()) {
            JOptionPane.showMessageDialog(null, "Correcto", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTramites = new javax.swing.JTextField();
        btAceptar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentanilla1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVentanilla2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVentanilla3 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAtendidos = new javax.swing.JTable();
        ventanilla1 = new javax.swing.JButton();
        total = new javax.swing.JButton();
        ventanilla2 = new javax.swing.JButton();
        ventanilla3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nùmero de Tramites");

        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ventanilla 1");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ventanilla 2");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ventanilla 3");

        tblVentanilla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblVentanilla1);

        tblVentanilla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblVentanilla2);

        tblVentanilla3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblVentanilla3);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Atencion en Ventanillas");

        tblAtendidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblAtendidos);

        ventanilla1.setText("Guardar ventanilla 1");
        ventanilla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventanilla1ActionPerformed(evt);
            }
        });

        total.setText("Total ");
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        ventanilla2.setText("Guardar ventanilla 2");
        ventanilla2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventanilla2ActionPerformed(evt);
            }
        });

        ventanilla3.setText("Guardar ventanilla 3");
        ventanilla3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventanilla3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTramites, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btAceptar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ventanilla1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(ventanilla2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ventanilla3, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(total))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTramites, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAceptar))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ventanilla1)
                    .addComponent(ventanilla2)
                    .addComponent(ventanilla3))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        // TODO add your handling code here:
        if (txtTramites.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un umero");
        } 
        else {
            try {
                CargarTabla();
                CargarTabla2();
                CargarTabla3();
            } 
            catch (Exception e) {
                
            }
        }
    }//GEN-LAST:event_btAceptarActionPerformed

    private void ventanilla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventanilla1ActionPerformed
        // TODO add your handling code here:
        try {
            Guardar();
            Ventanilla1();
            CargarSimulacion();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ventanilla1ActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
        Integer IdPersona = simulacionDao.getListSimulacion().getLength();
        JOptionPane.showMessageDialog(null, "Total Personas atendidas = "+IdPersona+"\nTiempo total = "+mts.sumarColumna(2)+" minutos");
    }//GEN-LAST:event_totalActionPerformed

    private void ventanilla2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventanilla2ActionPerformed
        // TODO add your handling code here:
        try {
            Guardar2();
            Ventanilla2();
            CargarSimulacion();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ventanilla2ActionPerformed

    private void ventanilla3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventanilla3ActionPerformed
        // TODO add your handling code here:
        try {
            Guardar3();
            Ventanilla3();
            CargarSimulacion();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ventanilla3ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaSimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaSimulacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblAtendidos;
    private javax.swing.JTable tblVentanilla1;
    private javax.swing.JTable tblVentanilla2;
    private javax.swing.JTable tblVentanilla3;
    private javax.swing.JButton total;
    private javax.swing.JTextField txtTramites;
    private javax.swing.JButton ventanilla1;
    private javax.swing.JButton ventanilla2;
    private javax.swing.JButton ventanilla3;
    // End of variables declaration//GEN-END:variables
}
