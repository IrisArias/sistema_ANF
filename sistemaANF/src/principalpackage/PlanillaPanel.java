package principalpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PlanillaPanel extends javax.swing.JPanel {

    public PlanillaPanel() {
        initComponents();
        tablemodelo();
        cargarIdsEnComboBox(); // Llamar aquí para cargar los IDs
        cargarInstituciones(); // Llamar aquí para cargar los IDs
        
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
        //String sql = "SELECT p.id, i.nombre FROM planillat p INNER JOIN instituciones i ON p.id_institucion = i.id";
        String sql = "SELECT id FROM planillat";
        try (Statement st = conexion.establecerConexion().createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            // Limpiar los JComboBox antes de cargar los datos
            jComboBoxID.removeAllItems();
            jComboBoxID.addItem("Seleccionar ID");
            // comboBoxInst.addItem("Seleccionar Institución");
            while (rs.next()) {
                // Obtener el ID y el nombre de la institución desde la base de datos
                int id = rs.getInt("id");
                String idFormateado = String.format("%03d", id);  // Esto lo convierte en formato 001, 002, etc.       
                // Añadir el ID formateado al JComboBox
                jComboBoxID.addItem(idFormateado);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
        }
    }
    private void cargarInstituciones() {
    Conexion conexion = new Conexion();
    String sql = "SELECT nombre FROM instituciones";

    try (Statement st = conexion.establecerConexion().createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        // Limpiar el ComboBox antes de cargar los datos
        comboBoxInst.removeAllItems();
        comboBoxInst.addItem("Seleccionar Institución");
        // Cargar los nombres de las instituciones en el ComboBox
        while (rs.next()) {
            String nombreInstitucion = rs.getString("nombre");
            comboBoxInst.addItem(nombreInstitucion);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar instituciones: " + e.getMessage());
    }
}

    private void tablemodelo() {
        Conexion objetoConexion = new Conexion(); //clase conexion
        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = {
            "id", "salario", "pago_adicional",
            "monto_vacacional", "ingreso_base", "dias",
            "horas", "dias_vacacion", "aporte_laboral",
            "aporte_patronal", "total_aporte",
            "cotizacion_obligatoria_empleador", "total_fondo",
            "cuenta_garantia_solidaria", "comision_afp",
            "total_a_pagar","id_institucion"
        };
        for (String columna : columnas) {
            modelo.addColumn(columna);
        }
        tablePlanilla.setModel(modelo);
        String sql = "SELECT " + String.join(",", columnas) + " FROM planillat;";
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
            tablePlanilla.setModel(modelo);
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

        jPanel1 = new javax.swing.JPanel();
        txtPlanilla = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePlanilla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        labelN = new javax.swing.JLabel();
        labelPuesto = new javax.swing.JLabel();
        labelFechaIngreso = new javax.swing.JLabel();
        labelFechaInicio = new javax.swing.JLabel();
        labelFechafin = new javax.swing.JLabel();
        labelTiempo = new javax.swing.JLabel();
        labelSueldo = new javax.swing.JLabel();
        labelCantidade = new javax.swing.JLabel();
        txtsalario = new javax.swing.JTextField();
        txtpagoadicional = new javax.swing.JTextField();
        txtmontovacacional = new javax.swing.JTextField();
        txtdias = new javax.swing.JTextField();
        txthoras = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jComboBoxID = new javax.swing.JComboBox<>();
        comboBoxInst = new javax.swing.JComboBox<>();
        labelFechafin1 = new javax.swing.JLabel();
        txtingresobase = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnLeer = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setAutoscrolls(true);

        jPanel1.setBackground(new java.awt.Color(45, 50, 80));

        txtPlanilla.setForeground(new java.awt.Color(255, 255, 255));
        txtPlanilla.setText("PLANILLA UNICA DE COTIZACIONES PREVISIONALES Y DE SEGURIDAD SOCIAL");

        tablePlanilla.setBackground(new java.awt.Color(103, 111, 157));
        tablePlanilla.setForeground(new java.awt.Color(255, 255, 255));
        tablePlanilla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablePlanilla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePlanillaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePlanilla);

        jPanel2.setBackground(new java.awt.Color(66, 71, 105));
        jPanel2.setLayout(null);

        labelN.setForeground(new java.awt.Color(255, 255, 255));
        labelN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelN.setText("N°:");
        jPanel2.add(labelN);
        labelN.setBounds(20, 20, 40, 14);

        labelPuesto.setForeground(new java.awt.Color(255, 255, 255));
        labelPuesto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPuesto.setText("institucion:");
        jPanel2.add(labelPuesto);
        labelPuesto.setBounds(2, 60, 60, 30);

        labelFechaIngreso.setForeground(new java.awt.Color(255, 255, 255));
        labelFechaIngreso.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelFechaIngreso.setText("salario:");
        jPanel2.add(labelFechaIngreso);
        labelFechaIngreso.setBounds(30, 110, 80, 30);

        labelFechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        labelFechaInicio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelFechaInicio.setText("pago adicional:");
        jPanel2.add(labelFechaInicio);
        labelFechaInicio.setBounds(10, 154, 100, 30);

        labelFechafin.setForeground(new java.awt.Color(255, 255, 255));
        labelFechafin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelFechafin.setText("monto vacacional:");
        jPanel2.add(labelFechafin);
        labelFechafin.setBounds(0, 190, 110, 30);

        labelTiempo.setForeground(new java.awt.Color(255, 255, 255));
        labelTiempo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTiempo.setText("dias:");
        jPanel2.add(labelTiempo);
        labelTiempo.setBounds(250, 50, 80, 30);

        labelSueldo.setForeground(new java.awt.Color(255, 255, 255));
        labelSueldo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSueldo.setText("horas:");
        jPanel2.add(labelSueldo);
        labelSueldo.setBounds(250, 90, 80, 30);

        labelCantidade.setForeground(new java.awt.Color(255, 255, 255));
        labelCantidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCantidade.setText("dias vacacion:");
        jPanel2.add(labelCantidade);
        labelCantidade.setBounds(230, 130, 100, 30);

        txtsalario.setBackground(new java.awt.Color(103, 111, 157));
        txtsalario.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtsalario);
        txtsalario.setBounds(120, 110, 90, 30);

        txtpagoadicional.setBackground(new java.awt.Color(103, 111, 157));
        txtpagoadicional.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtpagoadicional);
        txtpagoadicional.setBounds(120, 150, 90, 30);

        txtmontovacacional.setBackground(new java.awt.Color(103, 111, 157));
        txtmontovacacional.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtmontovacacional);
        txtmontovacacional.setBounds(120, 190, 90, 30);

        txtdias.setBackground(new java.awt.Color(103, 111, 157));
        txtdias.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtdias);
        txtdias.setBounds(340, 50, 90, 30);

        txthoras.setBackground(new java.awt.Color(103, 111, 157));
        txthoras.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txthoras);
        txthoras.setBounds(340, 90, 90, 30);

        txtCantidad.setBackground(new java.awt.Color(103, 111, 157));
        txtCantidad.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtCantidad);
        txtCantidad.setBounds(340, 130, 90, 30);

        jComboBoxID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIDActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxID);
        jComboBoxID.setBounds(70, 10, 140, 40);

        comboBoxInst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxInst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxInstActionPerformed(evt);
            }
        });
        jPanel2.add(comboBoxInst);
        comboBoxInst.setBounds(70, 60, 140, 40);

        labelFechafin1.setForeground(new java.awt.Color(255, 255, 255));
        labelFechafin1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelFechafin1.setText("ingreso base:");
        jPanel2.add(labelFechafin1);
        labelFechafin1.setBounds(220, 10, 110, 30);

        txtingresobase.setBackground(new java.awt.Color(103, 111, 157));
        txtingresobase.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtingresobase);
        txtingresobase.setBounds(340, 10, 90, 30);

        btnCrear.setBackground(new java.awt.Color(249, 177, 122));
        btnCrear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCrear.setText("AGREGAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel2.add(btnCrear);
        btnCrear.setBounds(459, 23, 150, 40);

        btnLeer.setBackground(new java.awt.Color(249, 177, 122));
        btnLeer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLeer.setText("BUSCAR");
        btnLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerActionPerformed(evt);
            }
        });
        jPanel2.add(btnLeer);
        btnLeer.setBounds(460, 70, 150, 40);

        btnActualizar.setBackground(new java.awt.Color(249, 177, 122));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnActualizar.setText("EDITAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnActualizar);
        btnActualizar.setBounds(460, 120, 150, 40);

        btnBorrar.setBackground(new java.awt.Color(249, 177, 122));
        btnBorrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBorrar.setText("ELIMINAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar);
        btnBorrar.setBounds(460, 170, 150, 40);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtPlanilla)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPlanilla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablePlanillaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePlanillaMouseClicked
    if (evt.getClickCount() == 1) { // Verifica si se hizo un solo clic
        JTable receptor = (JTable) evt.getSource();
        
        // Obtener el ID desde la tabla y seleccionarlo en el JComboBox
        String id = receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString();
        jComboBoxID.setSelectedItem(id); // Selecciona el ID en el JComboBox
        
        // Rellenar los otros campos de texto según los valores de la tabla
        txtsalario.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
        txtpagoadicional.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
        txtmontovacacional.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString());
        txtingresobase.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4).toString());
        txtdias.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 5).toString());
        txthoras.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 6).toString());
        txtCantidad.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 7).toString());
        /*txtaportelaboral.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 8).toString());
        txtAportePatronal.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 9).toString());
        txtTotalAporte.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 10).toString());
        txtCotizacionObligatoriaEmpleador.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 11).toString());
        txtTotalFondo.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 12).toString());
        txtCuentaGarantiaSolidaria.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 13).toString());
        txtComisionAfp.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 14).toString());
        txtTotalAPagar.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 15).toString());
        */
        // Establecer el ID de la institución en su respectivo campo de texto (si se necesita mostrarlo)
        String idInstitucion = receptor.getModel().getValueAt(receptor.getSelectedRow(), 16).toString();
        comboBoxInst.setSelectedItem(idInstitucion); // Asumir que tienes un JComboBox para las instituciones
    }          
    }//GEN-LAST:event_tablePlanillaMouseClicked

    private void jComboBoxIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxIDActionPerformed

    private void comboBoxInstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxInstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxInstActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // Obtenemos los valores de los campos del formulario
        double salario = Double.parseDouble(txtsalario.getText());
        double pagoAdicional = Double.parseDouble(txtpagoadicional.getText());
        double montoVacacional = Double.parseDouble(txtmontovacacional.getText());
        double ingresoBase = Double.parseDouble(txtingresobase.getText());

        int dias = Integer.parseInt(txtdias.getText());
        int horas = Integer.parseInt(txthoras.getText());
        int diasVacacion = Integer.parseInt(txtCantidad.getText());

    // Obtener la institución seleccionada
    String institucion = comboBoxInst.getSelectedItem().toString();
    int institucionID = 0;
    if (institucion.equals("AFP CECER")) {
        institucionID = 1; // ID para AFP CECER
    } else if (institucion.equals("AFP CONFÍA")) {
        institucionID = 2; // ID para AFP CONFIA
    } else {
        JOptionPane.showMessageDialog(null, "Selecciona una institución válida.");
        return;
    }   
 
        double aporteLaboral = Math.round(((ingresoBase > 1000) ? 30 : ingresoBase * 0.03) * 100.0) / 100.0;  // Cálculo de aporte laboral
        double aportePatronal = Math.round(((ingresoBase > 1000) ? 75 : ingresoBase * 0.075) * 100.0) / 100.0;  // Cálculo de aporte patronal
        double totalAporte = Math.round((aporteLaboral + aportePatronal) * 100.0) / 100.0;    // Cálculo del total aporte (suma de aporte laboral y aporte patronal)   

        double afpAfiliado = Math.round((ingresoBase * 0.0725) * 100.0) / 100.0; // 7.25% de ingreso base // Cálculo del AFP afiliado (7.25% del ingreso base)
        double afpEmpleador = Math.round((ingresoBase * 0.0175) * 100.0) / 100.0;  // Cálculo de AFP empleador (1.75% de ingreso base)
        double totalFondo = Math.round((afpAfiliado + afpEmpleador) * 100.0) / 100.0;  // Suma de los dos AFP para obtener el Total Fondo

        double cuentaSolidaria = Math.round((ingresoBase * 0.06) * 100.0) / 100.0;  // Cálculo de cuenta solidaria (6% de ingreso base)
        double comisionAfp = Math.round((ingresoBase * 0.01) * 100.0) / 100.0;  // Cálculo de comisión AFP (1% de ingreso base)
        double totalPagar = Math.round((totalFondo + cuentaSolidaria + comisionAfp) * 100.0) / 100.0;

        // Añadir el nuevo registro directamente a la tabla
    DefaultTableModel modelo = (DefaultTableModel) tablePlanilla.getModel();
    modelo.addRow(new Object[] {
        // Incluye otros valores que deseas mostrar en la tabla
        ingresoBase,
        aporteLaboral,
        aportePatronal,
        totalAporte,
        
        afpAfiliado,
        afpEmpleador,
        totalFondo ,
        
        cuentaSolidaria,
        comisionAfp,
        totalPagar 
    });
    
    // Crear la conexión e insertar los datos
Conexion conexion = new Conexion();
String sql = "INSERT INTO planillat (salario, pago_adicional, monto_vacacional, ingreso_base, dias, horas, dias_vacacion, "
           + "aporte_laboral, aporte_patronal, total_aporte, cotizacion_obligatoria_empleador, total_fondo, "
           + "cuenta_garantia_solidaria, comision_afp, total_a_pagar, id_institucion) "
           + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

try (PreparedStatement pst = conexion.establecerConexion().prepareStatement(sql)) {
    // Establecer los parámetros en el PreparedStatement
    pst.setDouble(1, salario);
    pst.setDouble(2, pagoAdicional);
    pst.setDouble(3, montoVacacional);
    pst.setDouble(4, ingresoBase);
    pst.setInt(5, dias);
    pst.setInt(6, horas);
    pst.setInt(7, diasVacacion);
    
    pst.setDouble(8, aporteLaboral); // Revisa si es aporte laboral
    pst.setDouble(9, aportePatronal);
    pst.setDouble(10, totalAporte);

    pst.setDouble(11, afpAfiliado); // Verifica si es cotización obligatoria empleador
    pst.setDouble(12, totalFondo);
    
    pst.setDouble(13, cuentaSolidaria);
    pst.setDouble(14, comisionAfp);
    pst.setDouble(15, totalPagar);
    pst.setInt(16, institucionID); // Suponiendo que 'institucionID' es un entero

    pst.executeUpdate();
    JOptionPane.showMessageDialog(null, "Registro creado exitosamente.");
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Error al crear el registro: " + e.getMessage());
}
          
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerActionPerformed
    // Obtener el ID seleccionado del JComboBox
    String idSeleccionado = jComboBoxID.getSelectedItem().toString();    
    // Verificar que el ID seleccionado no esté vacío o sea el valor predeterminado
    if (idSeleccionado.isEmpty() || idSeleccionado.equals("Seleccionar ID")) {
        JOptionPane.showMessageDialog(null, "Por favor, selecciona un ID.");
        return;
    }
   //  String query = "SELECT * FROM instituciones WHERE id = ?";  // Consulta para seleccionar los registros del ID especificado    
      // Cadena de consulta para leer los datos de la base de datos con el ID seleccionado
    String query = "SELECT p.id, p.salario, p.pago_adicional, p.monto_vacacional, p.ingreso_base, p.dias, p.horas, "
                 + "p.dias_vacacion, p.aporte_laboral, p.aporte_patronal, p.total_aporte, p.cotizacion_obligatoria_empleador, "
                 + "p.total_fondo, p.cuenta_garantia_solidaria, p.comision_afp, p.total_a_pagar, "
                 + "i.id AS id_institucion, i.nombre AS nombre_institucion "
                 + "FROM planillat p "
                 + "INNER JOIN instituciones i ON p.id_institucion = i.id "
                 + "WHERE p.id = ?";  // Consulta SQL usando el ID

   
// Crear una instancia de la clase Conexion y obtener la conexión
    Conexion conexion = new Conexion();
    try (Connection conn = conexion.establecerConexion(); // Establecer conexión
         PreparedStatement pst = conn.prepareStatement(query)) {
        
        // Establecer el valor del ID en la consulta
        pst.setString(1, idSeleccionado);
        // Ejecutar la consulta
        ResultSet rs = pst.executeQuery();
        
        // Crear un DefaultTableModel para cargar los datos en la JTable
        DefaultTableModel model = (DefaultTableModel) tablePlanilla.getModel(); 
        model.setRowCount(0);  // Limpiar la tabla antes de agregar los nuevos resultados
        
        if (rs.next()) {
            // Leer los datos de la consulta y agregarlos a la tabla
            Object[] row = new Object[17];  // Ajusta el tamaño del array según los campos que tienes
            row[0] = rs.getString("id");
            row[1] = rs.getDouble("salario");
            row[2] = rs.getDouble("pago_adicional");
            row[3] = rs.getDouble("monto_vacacional");
            row[4] = rs.getDouble("ingreso_base");
            row[5] = rs.getInt("dias");
            row[6] = rs.getInt("horas");
            row[7] = rs.getInt("dias_vacacion");
            row[8] = rs.getDouble("aporte_laboral");
            row[9] = rs.getDouble("aporte_patronal");
            row[10] = rs.getDouble("total_aporte");
            row[11] = rs.getDouble("cotizacion_obligatoria_empleador");
            row[12] = rs.getDouble("total_fondo");
            row[13] = rs.getDouble("cuenta_garantia_solidaria");
            row[14] = rs.getDouble("comision_afp");
            row[15] = rs.getDouble("total_a_pagar");
            row[16] = rs.getString("id_institucion"); // Agregar id_institucion
            model.addRow(row);  // Agregar la fila a la tabla
        } else {
            // Si no se encuentran resultados, mostrar un mensaje
            JOptionPane.showMessageDialog(null, "No se encontraron datos para el ID seleccionado.");
        }
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + ex.getMessage());
    }       
    }//GEN-LAST:event_btnLeerActionPerformed
    private String obtenerIdInstitucion(String nombreInstitucion) {
    String query = "SELECT id FROM instituciones WHERE nombre = ?";
    Conexion conexion = new Conexion();
    try (Connection conn = conexion.establecerConexion();
         PreparedStatement pst = conn.prepareStatement(query)) {
        
        pst.setString(1, nombreInstitucion);
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            return rs.getString("id");  // Devolver el ID de la institución
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener el ID de la institución: " + ex.getMessage());
    }
    return null;  // Retornar null si no se encuentra el ID
}

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // Obtener el ID seleccionado del JComboBox
        String idSeleccionado = jComboBoxID.getSelectedItem().toString();
        // Verificar que el ID seleccionado no esté vacío o sea el valor predeterminado
        if (idSeleccionado.isEmpty() || idSeleccionado.equals("Seleccionar ID")) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un ID.");
            return;
        }
        // Obtener los valores que el usuario haya ingresado en los campos de texto
        double nuevoSalario = Double.parseDouble(txtsalario.getText());
        double nuevoPagoAdicional = Double.parseDouble(txtpagoadicional.getText());
        double nuevoMontoVacacional = Double.parseDouble(txtmontovacacional.getText());
        double nuevoIngresoBase = Double.parseDouble(txtingresobase.getText());
        int nuevosDias = Integer.parseInt(txtdias.getText());
        int nuevasHoras = Integer.parseInt(txthoras.getText());
        int nuevosDiasVacacion = Integer.parseInt(txtCantidad.getText());
        // Calcular automáticamente los valores que dependen de otros campos
        double nuevoAporteLaboral = (nuevoIngresoBase > 1000) ? 30 : nuevoIngresoBase * 0.03;  // Aporte laboral
        double nuevoAportePatronal = (nuevoIngresoBase > 1000) ? 75 : nuevoIngresoBase * 0.075;  // Aporte patronal
        double nuevoTotalAporte = nuevoAporteLaboral + nuevoAportePatronal;  // Total aporte

        double nuevoAfpAfiliado = nuevoIngresoBase * 0.0725; // AFP afiliado (7.25%)
        double nuevoAfpEmpleador = nuevoIngresoBase * 0.0175;  // AFP empleador (1.75%)
        double nuevoTotalFondo = nuevoAfpAfiliado + nuevoAfpEmpleador;  // Total fondo (AFP)

        double nuevaCuentaGarantiaSolidaria = nuevoIngresoBase * 0.06;  // Cuenta garantía solidaria (6%)
        double nuevaComisionAfp = nuevoIngresoBase * 0.01;  // Comisión AFP (1%)
        double nuevoTotalAPagar = nuevoTotalFondo + nuevaCuentaGarantiaSolidaria + nuevaComisionAfp;  // Total a pagar

         // Obtener el valor seleccionado de la institución (nombre) y convertirlo a ID
    String nombreInstitucion = comboBoxInst.getSelectedItem().toString();
    String idInstitucion = obtenerIdInstitucion(nombreInstitucion); // Llamada al método que obtiene el ID

    if (idInstitucion == null) {
        JOptionPane.showMessageDialog(null, "Error: No se encontró el ID de la institución.");
        return;
    }
        // Consulta para actualizar todos los datos
        String query = "UPDATE planillat SET "
                + "salario = ?, pago_adicional = ?, monto_vacacional = ?, ingreso_base = ?, dias = ?, horas = ?, "
                + "dias_vacacion = ?, aporte_laboral = ?, aporte_patronal = ?, total_aporte = ?, "
                + "cotizacion_obligatoria_empleador = ?, total_fondo = ?, cuenta_garantia_solidaria = ?, "
                + "comision_afp = ?, total_a_pagar = ?, id_institucion = ? "
                + "WHERE id = ?";

        // Crear una instancia de la clase Conexion y obtener la conexión
        Conexion conexion = new Conexion();
        try (Connection conn = conexion.establecerConexion(); // Establecer conexión
                PreparedStatement pst = conn.prepareStatement(query)) {
            // Establecer los valores de los parámetros en la consulta
            pst.setDouble(1, nuevoSalario);
            pst.setDouble(2, nuevoPagoAdicional);
            pst.setDouble(3, nuevoMontoVacacional);
            pst.setDouble(4, nuevoIngresoBase);
            pst.setInt(5, nuevosDias);
            pst.setInt(6, nuevasHoras);
            pst.setInt(7, nuevosDiasVacacion);
            pst.setDouble(8, nuevoAporteLaboral);
            pst.setDouble(9, nuevoAportePatronal);
            pst.setDouble(10, nuevoTotalAporte);
            pst.setDouble(11, nuevoAfpAfiliado + nuevoAfpEmpleador); // Cotización obligatoria (AFP total)
            pst.setDouble(12, nuevoTotalFondo);
            pst.setDouble(13, nuevaCuentaGarantiaSolidaria);
            pst.setDouble(14, nuevaComisionAfp);
            pst.setDouble(15, nuevoTotalAPagar);
            pst.setString(16, idInstitucion);  // Establecer el valor de la institución
            pst.setString(17, idSeleccionado);  // Establecer el ID para actualizar el registro correcto

            // Ejecutar la consulta de actualización
            int filasAfectadas = pst.executeUpdate();

            // Verificar si se actualizó algún registro
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el registro para actualizar.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // Obtener el ID seleccionado desde el ComboBox (por ejemplo, un ComboBox con IDs de trabajadores)
        String idSeleccionado = (String) jComboBoxID.getSelectedItem(); // Asegúrate de que idComboBox esté correctamente poblado
        String idSeleccionadoinst = (String) comboBoxInst.getSelectedItem(); // Asegúrate de que idComboBox esté correctamente poblado
        
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
            String consulta = "DELETE FROM planillat WHERE id = ?";
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

            reiniciarCampos();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed
     private void reiniciarCampos() {
        // Este método limpia los campos de texto (si es necesario).
        txtsalario.setText("");
        txtpagoadicional.setText("");
        txtmontovacacional.setText("");
        txtingresobase.setText("");
        txtdias.setText("");
        txthoras.setText("");
        txtCantidad.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnLeer;
    private javax.swing.JComboBox<String> comboBoxInst;
    private javax.swing.JComboBox<String> jComboBoxID;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCantidade;
    private javax.swing.JLabel labelFechaIngreso;
    private javax.swing.JLabel labelFechaInicio;
    private javax.swing.JLabel labelFechafin;
    private javax.swing.JLabel labelFechafin1;
    private javax.swing.JLabel labelN;
    private javax.swing.JLabel labelPuesto;
    private javax.swing.JLabel labelSueldo;
    private javax.swing.JLabel labelTiempo;
    private javax.swing.JTable tablePlanilla;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JLabel txtPlanilla;
    private javax.swing.JTextField txtdias;
    private javax.swing.JTextField txthoras;
    private javax.swing.JTextField txtingresobase;
    private javax.swing.JTextField txtmontovacacional;
    private javax.swing.JTextField txtpagoadicional;
    private javax.swing.JTextField txtsalario;
    // End of variables declaration//GEN-END:variables
}
