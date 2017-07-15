package com.umg.financiero.visual;

import com.umg.financiero.clases.Sucursal;

import javax.swing.*;
import java.awt.event.*;

public class empresa extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSlider clientes;
    private JTextField empresa;
    private JTextField direccion;
    private JTextField telefono;
    public Sucursal suc;

    public empresa() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

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
    }

    private void onOK() {
        // add your code here
        String varEmpresa = empresa.getText();
        String varDireccion = direccion.getText();
        String varTelefono = telefono.getText();
        Integer varClientes = clientes.getMaximum();

        suc = new Sucursal(varClientes);
        suc.setCodigo(1);
        suc.setNombre(varEmpresa);
        suc.setDireccion(varDireccion);
        suc.setTelefono(varTelefono);

        JOptionPane.showMessageDialog(this, "Los datos guardados son " + suc, "Aviso", JOptionPane.INFORMATION_MESSAGE);

    }

    private void onCancel() {
        // add your code here if necessary
        this.dispose();
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
