
package principalpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DashboardFrame extends javax.swing.JFrame {

    
    public DashboardFrame() {
        initComponents();
        
        this.setTitle("Sistema de Analisis Financiero");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizar la ventana al iniciar
        // Cargar el ícono desde el classpath
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/LogoAnf.png"));
        setIconImage(icono);
        panelPantalla.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20)); // Padding de 20 píxeles en cada lado
       
        //Conexion objetoConexion = new Conexion();
        //objetoConexion.establecerConexion();
        InicioPanel p1=new InicioPanel();
        p1.setLocation(0,0);
        panelContenido.removeAll();
        panelContenido.revalidate();
        panelContenido.repaint();  
        panelContenido.setLayout(new BorderLayout()); // Cambiar el layout a BorderLayout
        panelContenido.add(p1, BorderLayout.CENTER);  // Agregar el panel al centro
        
        // Configurar la apariencia del botón
        btnInicio.setBackground(Color.decode("#1d2d44")); // Código hexadecimal
        btnInicio.setForeground(Color.WHITE); // Color del texto (blanco)
        btnInicio.setFont(new Font("Arial", Font.BOLD, 16)); // Fuente y tamaño del texto
        btnInicio.setBorder(BorderFactory.createLineBorder(Color.decode("#182b31"), 2, true)); // Borde redondeado
        btnInicio.setBorderPainted(false); // Eliminar borde predeterminado
     
         // Configurar la apariencia del botón
        btnPlanilla.setBackground(Color.decode("#1d2d44")); // Código hexadecimal
        btnPlanilla.setForeground(Color.WHITE); // Color del texto (blanco)
        btnPlanilla.setFont(new Font("Arial", Font.BOLD, 16)); // Fuente y tamaño del texto
        btnPlanilla.setBorder(BorderFactory.createLineBorder(Color.decode("#182b31"), 2, true)); // Borde redondeado
        btnPlanilla.setBorderPainted(false); // Eliminar borde predeterminado
  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPantalla = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        panelContenido = new javax.swing.JPanel();
        btnPlanilla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SistemaFinanciero");
        setBackground(new java.awt.Color(51, 51, 51));

        panelPantalla.setBackground(new java.awt.Color(224, 225, 221));
        panelPantalla.setPreferredSize(null);

        btnInicio.setText("INICIO");
        btnInicio.setAlignmentX(0.5F);
        btnInicio.setFocusPainted(false);
        btnInicio.setFocusable(false);
        btnInicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        panelContenido.setBackground(java.awt.Color.lightGray);
        panelContenido.setAlignmentY(0.0F);
        panelContenido.setPreferredSize(null);

        javax.swing.GroupLayout panelContenidoLayout = new javax.swing.GroupLayout(panelContenido);
        panelContenido.setLayout(panelContenidoLayout);
        panelContenidoLayout.setHorizontalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelContenidoLayout.setVerticalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        btnPlanilla.setText("PLANILLA");
        btnPlanilla.setFocusPainted(false);
        btnPlanilla.setFocusable(false);
        btnPlanilla.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPlanilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlanillaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPantallaLayout = new javax.swing.GroupLayout(panelPantalla);
        panelPantalla.setLayout(panelPantallaLayout);
        panelPantallaLayout.setHorizontalGroup(
            panelPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelPantallaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPlanilla, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
            .addComponent(panelContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPantallaLayout.setVerticalGroup(
            panelPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPantallaLayout.createSequentialGroup()
                .addGroup(panelPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btnPlanilla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPantalla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlanillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlanillaActionPerformed
        // TODO add your handling code here:
        PlanillaPanel p1=new PlanillaPanel();
        //p1.setSize(1080,640);
        p1.setLocation(0,0);
        panelContenido.removeAll();
        panelContenido.add(p1,BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
        
    }//GEN-LAST:event_btnPlanillaActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        // TODO add your handling code here:
        InicioPanel p1=new InicioPanel();
       // p1.setSize(1080,640);
        p1.setLocation(0,0);
        panelContenido.removeAll();
        panelContenido.add(p1,BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }//GEN-LAST:event_btnInicioActionPerformed

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
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnPlanilla;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelPantalla;
    // End of variables declaration//GEN-END:variables
}
