/**************************************************************************
OmegaT - Computer Assisted Translation (CAT) tool 
          with fuzzy matching, translation memory, keyword search, 
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2013, 2015 Enrique Estevez
               Home page: http://www.omegat.org/
               Support center: http://groups.yahoo.com/group/OmegaT/

 This file is part of OmegaT.

 OmegaT is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 OmegaT is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **************************************************************************/

package org.omegat.filters2.text.bundles;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.AbstractAction;


import org.omegat.util.OStrings;
import org.omegat.util.gui.DockingUI;
import org.omegat.util.gui.StaticUIUtils;

/**
 * Modal dialog to edit the Java Resource Bundles filter options.
 * 
 * Code modified from the file: MozillaDTDOptionsDialog.java
 * 
 * @author Enrique Estevez (keko.gl@gmail.com)
 */
@SuppressWarnings("serial")
public class ResourceBundleOptionsDialog extends javax.swing.JDialog {
    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;

    private final Map<String, String> options;

    /**
     * Creates new form ResourceBundleDTDOptionsDialog
     */
    public ResourceBundleOptionsDialog(Dialog parent, Map<String, String> options) {
        super(parent, true);
        this.options = new TreeMap<String, String>(options);
        initComponents();

        String removeStringsUntranslated = options.get(ResourceBundleFilter.OPTION_REMOVE_STRINGS_UNTRANSLATED);
        removeStringsUntranslatedCB.setSelected("true".equalsIgnoreCase(removeStringsUntranslated));

        String notConvertCharacters = options.get(ResourceBundleFilter.OPTION_DONT_UNESCAPE_U_LITERALS);
        dontUnescapeULiteralsCB.setSelected("true".equalsIgnoreCase(notConvertCharacters));
        
        StaticUIUtils.setEscapeAction(this, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
        DockingUI.displayCentered(this);
    }

    /** @return the return status of this dialog - one of RET_OK or RET_CANCEL */
    public int getReturnStatus() {
        return returnStatus;
    }

    /** Returns updated options. */
    public Map<String, String> getOptions() {
        return options;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        removeStringsUntranslatedCB = new javax.swing.JCheckBox();
        dontUnescapeULiteralsCB = new javax.swing.JCheckBox();
        buttonPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setTitle(OStrings.getString("RB_FILTER_OPTIONS_TITLE")); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(removeStringsUntranslatedCB, OStrings.getString("RB_FILTER_REMOVE_STRINGS_UNTRANSLATED")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(removeStringsUntranslatedCB, gridBagConstraints);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/omegat/Bundle"); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(dontUnescapeULiteralsCB, bundle.getString("RB_FILTER_NOT_CONVERT_UNICODE_CHARACTERS")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(dontUnescapeULiteralsCB, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        buttonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        org.openide.awt.Mnemonics.setLocalizedText(okButton, OStrings.getString("BUTTON_OK")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(okButton);

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, OStrings.getString("BUTTON_CANCEL")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(cancelButton);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
}//GEN-LAST:event_closeDialog

private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        options.put(ResourceBundleFilter.OPTION_REMOVE_STRINGS_UNTRANSLATED, Boolean.toString(removeStringsUntranslatedCB.isSelected()));
        options.put(ResourceBundleFilter.OPTION_DONT_UNESCAPE_U_LITERALS, Boolean.toString(dontUnescapeULiteralsCB.isSelected()));
        doClose(RET_OK);
}//GEN-LAST:event_okButtonActionPerformed

private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
}//GEN-LAST:event_cancelButtonActionPerformed

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox dontUnescapeULiteralsCB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox removeStringsUntranslatedCB;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}
