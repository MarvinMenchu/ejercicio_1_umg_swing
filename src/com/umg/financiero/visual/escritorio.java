package com.umg.financiero.visual;

import javax.swing.*;
import java.awt.event.*;

public class escritorio extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton btnSalir;
    private JButton datosEmpresaButton;
    private JButton clientesButton;
    private JButton cuentasButton;
    private JButton transaccionesButton;

    public escritorio() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


        btnSalir.addActionListener(new ActionListener() {
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
        datosEmpresaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empresa emp = new empresa();
                //emp.setSize(500, 500);
                emp.pack();
                emp.setVisible(true);
            }
        });
        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliente cli = new cliente();
                cli.pack();
                cli.setVisible(true);
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        escritorio dialog = new escritorio();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
