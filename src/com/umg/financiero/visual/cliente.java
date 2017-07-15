package com.umg.financiero.visual;

import com.umg.financiero.clases.Cliente;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

public class cliente extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField codigo;
    private JTextField nombre;
    private JComboBox sexo;
    private JTextField id;
    private JFormattedTextField fechaNacimiento;
    private JTable table1;
    private JButton eliminarButton;
    private JButton agregarButton;

    public List<Cliente> listaClientes = new ArrayList<>();
    private JTable tabla;
    private DefaultTableModel modelo;



    public cliente() {

        setContentPane(contentPane);
        setModal(true);

        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Sexo");
        modelo.addColumn("Id");
        modelo.addColumn("Fecha Nacimiento");
        table1.setModel(modelo);



        getRootPane().setDefaultButton(buttonOK);


        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Cliente cli = new Cliente();


                cli.setCodigo(Integer.parseInt(codigo.getText()));
                cli.setNombre(nombre.getText());
                cli.setSexo((String) sexo.getSelectedItem());
                cli.setId(id.getText());
                cli.setFechaNacimiento(Date.valueOf(fechaNacimiento.getText()));
                listaClientes.add(cli);

                modelo.addRow(new Object[]{codigo.getText(), nombre.getText(), (String) sexo.getSelectedItem(),
                        id.getText(), fechaNacimiento.getText()});
                codigo.setText("");
                nombre.setText("");
                id.setText("");
                fechaNacimiento.setText("");

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.removeRow(table1.getSelectedRow());
            }
        });
    }


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        cliente dialog = new cliente();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
