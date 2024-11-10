package principalpackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HorasPanel extends javax.swing.JPanel {

    public HorasPanel() {
        initComponents();
        tablemodelo();
        cargarIdsEnComboBox(); // Llamar aquí para cargar los IDs
        
          // Configurar la apariencia del botón
        btnCrear.setBackground(Color.decode("#fde9cc")); // Código hexadecimal
        btnCrear.setPreferredSize(new Dimension(120, 40)); // Ajuste de tamaño
        btnCrear.setBorder(BorderFactory.createLineBorder(Color.decode("#fde9cc"), 2, true)); // Borde redondeado
        btnCrear.setBorderPainted(false); // Eliminar borde predeterminado
          // Configurar la apariencia del botón
        btnLeer.setBackground(Color.decode("#fde9cc")); // Código hexadecimal
        btnCrear.setPreferredSize(new Dimension(120, 40)); // Ajuste de tamaño
        btnLeer.setBorder(BorderFactory.createLineBorder(Color.decode("#fde9cc"), 35, true)); // Borde redondeado
        btnLeer.setBorderPainted(false); // Eliminar borde predeterminado
          // Configurar la apariencia del botón
        btnActualizar.setBackground(Color.decode("#fde9cc")); // Código hexadecimal
        btnCrear.setPreferredSize(new Dimension(120, 40)); // Ajuste de tamaño
        btnActualizar.setBorder(BorderFactory.createLineBorder(Color.decode("#fde9cc"), 35, true)); // Borde redondeado
        btnActualizar.setBorderPainted(false); // Eliminar borde predeterminado
          // Configurar la apariencia del botón
        btnBorrar.setBackground(Color.decode("#fde9cc")); // Código hexadecimal
        btnCrear.setPreferredSize(new Dimension(120, 40)); // Ajuste de tamaño
        btnBorrar.setBorder(BorderFactory.createLineBorder(Color.decode("#fde9cc"), 35, true)); // Borde redondeado
        btnBorrar.setBorderPainted(false); // Eliminar borde predeterminado
    }

     private void cargarIdsEnComboBox() {
         
    Conexion conexion = new Conexion();
    String sql = "SELECT id FROM horas_extra";
    try (Statement st = conexion.establecerConexion().createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        // Limpiar el JComboBox antes de cargar datos
        jComboBoxID.removeAllItems();
        // Agregar la opción "Seleccionar ID"
        jComboBoxID.addItem("Seleccionar ID");

        while (rs.next()) {
              // Obtener el ID de la base de datos
            int id = rs.getInt("id");
            // Formatear el ID con ceros a la izquierda
            String idFormateado = String.format("%03d", id);  // Esto lo convierte en formato 001, 002, etc.       
            // Añadir el ID formateado al JComboBox
            jComboBoxID.addItem(idFormateado);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar IDs: " + e.getMessage());
    }
}
     
     private void tablemodelo() {
        Conexion objetoConexion = new Conexion(); //clase conexion
        DefaultTableModel modelo = new DefaultTableModel();
          String[] columnas = {
        "id", "nombre1_trabajador", "nombre2_trabajador",
        "apellido1_trabajador", "apellido2_trabajador", 
        "sueldo_diario", "horas_extra_diurnas", 
        "horas_extra_nocturnas", "horas_nocturnas"
    };

    for (String columna : columnas) {
        modelo.addColumn(columna);
    }
    tableHorasExtra.setModel(modelo);
    String sql = "SELECT " + String.join(",", columnas) + " FROM horas_extra;";
    String[] datos = new String[columnas.length];
    Statement st;
    try { 
        st = objetoConexion.establecerConexion().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            for (int i = 0; i < columnas.length; i++) {
                datos[i] = rs.getString(i + 1);
            }
            modelo.addRow(datos);   
        }
        tableHorasExtra.setModel(modelo);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error:" + e.toString());
        }
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
        tableHorasExtra = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt1nombre = new javax.swing.JTextField();
        txt2nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt1apellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt2apellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtsueldoD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txthorasextraD = new javax.swing.JTextField();
        txthorasextraN = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txthorasN = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnLeer = new javax.swing.JButton();
        jComboBoxID = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(45, 50, 80));

        tableHorasExtra.setBackground(new java.awt.Color(103, 111, 157));
        tableHorasExtra.setForeground(new java.awt.Color(255, 255, 255));
        tableHorasExtra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableHorasExtra.setGridColor(new java.awt.Color(249, 177, 122));
        tableHorasExtra.setSelectionBackground(new java.awt.Color(249, 177, 122));
        tableHorasExtra.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tableHorasExtra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHorasExtraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableHorasExtra);

        jPanel1.setBackground(new java.awt.Color(66, 71, 105));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        txt1nombre.setBackground(new java.awt.Color(103, 111, 157));
        txt1nombre.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt1nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 46, 110, 29));

        txt2nombre.setBackground(new java.awt.Color(103, 111, 157));
        txt2nombre.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt2nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 81, 110, 29));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("primer nombre: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("segundo nombre: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txt1apellido.setBackground(new java.awt.Color(103, 111, 157));
        txt1apellido.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt1apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 116, 110, 29));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("primer apellido:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        txt2apellido.setBackground(new java.awt.Color(103, 111, 157));
        txt2apellido.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt2apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 150, 110, 29));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("segundo apellido:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Sueldo diario:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 18, 129, -1));

        txtsueldoD.setBackground(new java.awt.Color(103, 111, 157));
        txtsueldoD.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtsueldoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 11, 110, 29));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Horas extra diurnas:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 53, 129, -1));

        txthorasextraD.setBackground(new java.awt.Color(103, 111, 157));
        txthorasextraD.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txthorasextraD, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 46, 110, 29));

        txthorasextraN.setBackground(new java.awt.Color(103, 111, 157));
        txthorasextraN.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txthorasextraN, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 81, 110, 29));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Horas extra nocturnas:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 88, 129, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Horas nocturnas:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 123, 129, -1));

        txthorasN.setBackground(new java.awt.Color(103, 111, 157));
        txthorasN.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txthorasN, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 116, 110, 29));

        btnCrear.setBackground(new java.awt.Color(249, 177, 122));
        btnCrear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCrear.setText("AGREGAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 130, 30));

        btnActualizar.setBackground(new java.awt.Color(249, 177, 122));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnActualizar.setText("EDITAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 130, 30));

        btnBorrar.setBackground(new java.awt.Color(249, 177, 122));
        btnBorrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBorrar.setText("ELIMINAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 130, 30));

        btnLeer.setBackground(new java.awt.Color(249, 177, 122));
        btnLeer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLeer.setText("BUSCAR");
        btnLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerActionPerformed(evt);
            }
        });
        jPanel1.add(btnLeer, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 130, 30));

        jComboBoxID.setBackground(new java.awt.Color(249, 177, 122));
        jComboBoxID.setForeground(new java.awt.Color(103, 111, 157));
        jComboBoxID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIDActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxID, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 10, 111, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableHorasExtraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHorasExtraMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) { // Verifica si se hizo un solo clic
            JTable receptor = (JTable) evt.getSource();
            // Obtener el ID desde la tabla y seleccionarlo en el JComboBox
            String id = receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString();
            jComboBoxID.setSelectedItem(id); // Selecciona el ID en el JComboBox
            // Rellenar los otros campos de texto según los valores de la tabla
            txt1nombre.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            txt2nombre.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
            txt1apellido.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString());
            txt2apellido.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4).toString());
            txtsueldoD.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 5).toString());
            txthorasextraD.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 6).toString());
            txthorasextraN.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 7).toString());
            txthorasN.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 8).toString());
        }
    }//GEN-LAST:event_tableHorasExtraMouseClicked

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
         // Obtener los valores de los campos del formulario
        String nombre1 = txt1nombre.getText();
        String nombre2 = txt2nombre.getText();
        String apellido1 = txt1apellido.getText();
        String apellido2 = txt2apellido.getText();
        double sueldo = Double.parseDouble(txtsueldoD.getText());
        int horasDiurnas = Integer.parseInt(txthorasextraD.getText());
        int horasNocturnas = Integer.parseInt(txthorasextraN.getText());
        int horasExtraNocturnas = Integer.parseInt(txthorasN.getText());
        
         // Consulta SQL para verificar si ya existe un trabajador con los mismos datos
        String checkQuery = "SELECT COUNT(*) FROM horas_extra WHERE nombre1_trabajador = ? AND nombre2_trabajador = ? AND apellido1_trabajador = ? AND apellido2_trabajador = ?";
        Conexion conexion = new Conexion();
        
        try (Connection conn = conexion.establecerConexion();
         PreparedStatement pstCheck = conn.prepareStatement(checkQuery)) {

        // Establecer los valores para la consulta de verificación
        pstCheck.setString(1, nombre1);
        pstCheck.setString(2, nombre2);
        pstCheck.setString(3, apellido1);
        pstCheck.setString(4, apellido2);
        // Ejecutar la consulta y verificar si ya existe el trabajador
        ResultSet rs = pstCheck.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(null, "Ya existe un trabajador con los mismos datos.");
            return;  // Salir del método si ya existe un trabajador con esos datos
        }
            // Si no existe, procedemos a la inserción
              String insertQuery = "INSERT INTO horas_extra (nombre1_trabajador, nombre2_trabajador, apellido1_trabajador, apellido2_trabajador, sueldo_diario, horas_extra_diurnas, horas_extra_nocturnas, horas_nocturnas) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstInsert = conn.prepareStatement(insertQuery)) {
            // Establecer los valores en la consulta SQL
            pstInsert.setString(1, nombre1);
            pstInsert.setString(2, nombre2);
            pstInsert.setString(3, apellido1);
            pstInsert.setString(4, apellido2);
            pstInsert.setDouble(5, sueldo);
            pstInsert.setInt(6, horasDiurnas);
            pstInsert.setInt(7, horasExtraNocturnas);
            pstInsert.setInt(8, horasNocturnas);
            
            // Ejecutar la inserción
            pstInsert.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + ex.getMessage());
    }

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerActionPerformed
    // Obtener el ID seleccionado del ComboBox
    String idSeleccionado = jComboBoxID.getSelectedItem().toString();
    // Verificar que el ID seleccionado no esté vacío
    if (idSeleccionado.isEmpty() || idSeleccionado.equals("Seleccionar ID")) {
        JOptionPane.showMessageDialog(null, "Por favor, selecciona un ID.");
        return;
    }
    
    // Cadena de consulta para leer los datos del trabajador seleccionado
    String query = "SELECT * FROM horas_extra WHERE id = ?";  // Consulta para seleccionar los registros del ID especificado   
    // Crear una instancia de la clase Conexion y obtener la conexión
    Conexion conexion = new Conexion();
    try (Connection conn = conexion.establecerConexion(); // Establecer conexión
         PreparedStatement pst = conn.prepareStatement(query)) {
        
        // Establecer el valor del ID en la consulta
        pst.setString(1, idSeleccionado);
        // Ejecutar la consulta
        ResultSet rs = pst.executeQuery();
        
        // Crear un DefaultTableModel para cargar los datos en la JTable
        DefaultTableModel model = (DefaultTableModel) tableHorasExtra.getModel(); 
        model.setRowCount(0);  // Limpiar la tabla antes de agregar los nuevos resultados
        
        if (rs.next()) {
            // Leer los datos de la consulta y agregarlos a la tabla
            Object[] row = new Object[8];  // Ajusta el tamaño del array según los campos que tienes
            row[0] = rs.getString("id");
            row[1] = rs.getString("nombre1_trabajador");
            row[2] = rs.getString("nombre2_trabajador");
            row[3] = rs.getString("apellido1_trabajador");
            row[4] = rs.getString("apellido2_trabajador");
            row[5] = rs.getDouble("sueldo_diario");
            row[6] = rs.getInt("horas_extra_diurnas");
            row[7] = rs.getInt("horas_extra_nocturnas");
            model.addRow(row);  // Agregar la fila a la tabla
        } else {
            // Si no se encuentran resultados, limpiar la tabla
            JOptionPane.showMessageDialog(null, "No se encontraron datos para el ID seleccionado.");
        }
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnLeerActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
    // Obtener el valor del ID seleccionado desde el JComboBox
    String idSeleccionado = jComboBoxID.getSelectedItem().toString();
    // Verificar si se seleccionó un ID válido
    if (idSeleccionado.equals("Seleccionar ID")) {
        JOptionPane.showMessageDialog(null, "Por favor, selecciona un ID.");
        return;
    }
    // Obtener los valores de los demás campos de texto
    String nombre1 = txt1nombre.getText();
    String nombre2 = txt2nombre.getText();
    String apellido1 = txt1apellido.getText();
    String apellido2 = txt2apellido.getText();
    String sueldoDiario = txtsueldoD.getText();
    String horasExtraDiurnas = txthorasextraD.getText();
    String horasExtraNocturnas = txthorasextraN.getText();
    String horasNocturnas = txthorasN.getText();
    // Crear la consulta SQL para actualizar el registro
    String consulta = "UPDATE horas_extra SET "
            + "nombre1_trabajador = ?, "
            + "nombre2_trabajador = ?, "
            + "apellido1_trabajador = ?, "
            + "apellido2_trabajador = ?, "
            + "sueldo_diario = ?, "
            + "horas_extra_diurnas = ?, "
            + "horas_extra_nocturnas = ?, "
            + "horas_nocturnas = ? "
            + "WHERE id = ?";
    
    Conexion objetoConexion = new Conexion();    
    try {
        // Preparar la consulta
        PreparedStatement ps = objetoConexion.establecerConexion().prepareStatement(consulta);        
        // Asignar los valores a la consulta
        ps.setString(1, nombre1);
        ps.setString(2, nombre2);
        ps.setString(3, apellido1);
        ps.setString(4, apellido2);
        ps.setString(5, sueldoDiario);
        ps.setString(6, horasExtraDiurnas);
        ps.setString(7, horasExtraNocturnas);
        ps.setString(8, horasNocturnas);
        ps.setString(9, idSeleccionado);
        
        // Ejecutar la actualización
        int filasAfectadas = ps.executeUpdate();        
        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(null, "Registro actualizado correctamente.");
            // Aquí puedes llamar a un método para refrescar la tabla si es necesario
            tablemodelo();
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el registro para actualizar.");
        }    
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
    }
 
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jComboBoxIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxIDActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
         // Obtener el ID seleccionado desde el ComboBox (por ejemplo, un ComboBox con IDs de trabajadores)
    String idSeleccionado = (String) jComboBoxID.getSelectedItem(); // Asegúrate de que idComboBox esté correctamente poblado
     // Verificar que el ID seleccionado no esté vacío
    if (idSeleccionado.isEmpty() || idSeleccionado.equals("Seleccionar ID")) {
        JOptionPane.showMessageDialog(null, "Por favor, selecciona un ID.");
        return;
    }
    // Confirmar la eliminación con el usuario
    int confirmacion = JOptionPane.showConfirmDialog(null, 
        "¿Estás seguro de que deseas eliminar este registro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
    if (confirmacion == JOptionPane.YES_OPTION) {
        // Realizar la consulta SQL para eliminar el trabajador con el ID seleccionado
        String consulta = "DELETE FROM horas_extra WHERE id = ?";
        // Realizar la eliminación
        Conexion conexion = new Conexion();
        try (Connection conn = conexion.establecerConexion(); 
             PreparedStatement pst = conn.prepareStatement(consulta)) { 
            // Establecer el valor del ID en la consulta
            pst.setString(1, idSeleccionado);  
            // Ejecutar la consulta
            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "El registro se ha eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un registro con ese ID.");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro: " + ex.getMessage());
        }
        
        // Actualizar la tabla si es necesario
     //   actualizarTabla();
        // Limpiar los campos si es necesario
        reiniciarCampos();
    }
    }//GEN-LAST:event_btnBorrarActionPerformed
    private void reiniciarCampos() {
        // Este método limpia los campos de texto (si es necesario).
        txt1nombre.setText("");
        txt2nombre.setText("");
        txt1apellido.setText("");
        txt2apellido.setText("");
        txtsueldoD.setText("");
        txthorasextraD.setText("");
        txthorasextraN.setText("");
        txthorasN.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnLeer;
    private javax.swing.JComboBox<String> jComboBoxID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableHorasExtra;
    private javax.swing.JTextField txt1apellido;
    private javax.swing.JTextField txt1nombre;
    private javax.swing.JTextField txt2apellido;
    private javax.swing.JTextField txt2nombre;
    private javax.swing.JTextField txthorasN;
    private javax.swing.JTextField txthorasextraD;
    private javax.swing.JTextField txthorasextraN;
    private javax.swing.JTextField txtsueldoD;
    // End of variables declaration//GEN-END:variables
}