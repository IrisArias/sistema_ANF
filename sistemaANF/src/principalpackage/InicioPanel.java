/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principalpackage;

/**
 *
 * @author AP
 */
public class InicioPanel extends javax.swing.JPanel {

    /**
     * Creates new form InicioPanel
     */
    public InicioPanel() {
        initComponents();
        txtinfoEmpresa.setLineWrap(true); // Ajustar las líneas al ancho del JTextArea
        txtinfoEmpresa.setWrapStyleWord(true); // Ajuste de líneas por palabras completas

        // Configurar el JTextArea para que no tenga fondo ni borde visibles
        txtinfoEmpresa.setOpaque(false); // Hace que el fondo sea transparente
        txtinfoEmpresa.setBorder(null);  // Elimina el borde
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtinfoEmpresa = new javax.swing.JTextArea();

        txtinfoEmpresa.setEditable(false);
        txtinfoEmpresa.setBackground(new java.awt.Color(240, 240, 240));
        txtinfoEmpresa.setColumns(20);
        txtinfoEmpresa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtinfoEmpresa.setRows(5);
        txtinfoEmpresa.setText("Misión: Ofrecer nuestros productos, servicios de reparación y mantenimiento de motocicletas con alta calidad y eficiencia, brindando un servicio confiable y profesional que garantice la satisfacción total de nuestros clientes. \n\nVisión: Convertirnos en la empresa líder en la venta de productos, servicios de reparación y mantenimiento de motocicletas en San Salvador, reconocidos por la excelencia en el servicio y la innovación en nuestro rubro. ");
        txtinfoEmpresa.setAutoscrolls(false);
        txtinfoEmpresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtinfoEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtinfoEmpresa.setFocusable(false);
        txtinfoEmpresa.setOpaque(false);
        txtinfoEmpresa.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(txtinfoEmpresa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtinfoEmpresa;
    // End of variables declaration//GEN-END:variables
}