
package com.g2inc.scap.editor.gui.wizards.xccdf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import com.g2inc.scap.editor.gui.resources.EditorMessages;
import com.g2inc.scap.editor.gui.wizards.Wizard;
import com.g2inc.scap.editor.gui.wizards.WizardPage;
import com.g2inc.scap.library.domain.SCAPDocumentTypeEnum;

public class CreateXCCDFSchemaChoicePage extends WizardPage
{
    private CreateXCCDFWizard parentWiz = null;

    private void initComponents2()
    {
        schemaCombo.removeAllItems();
        for (SCAPDocumentTypeEnum schemaType : SCAPDocumentTypeEnum.values())
        {
            if (schemaType != null && schemaType.equals(SCAPDocumentTypeEnum.XCCDF_114))
            {
                schemaCombo.addItem(schemaType);
            }
        }

        schemaCombo.setSelectedItem(SCAPDocumentTypeEnum.XCCDF_114);
        
        schemaCombo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                parentWiz.setSchemaType((SCAPDocumentTypeEnum)schemaCombo.getSelectedItem());
                parentWiz.enableNextButton();
            }
        });
    }

    /** Creates new form ChoseVariableTypeWizardPage */
    public CreateXCCDFSchemaChoicePage()
    {
        initComponents();
        initComponents2();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        notePanel = new javax.swing.JPanel();
        noteLabel = new javax.swing.JLabel();
        schemaChoicePanel = new javax.swing.JPanel();
        choiceLabel = new javax.swing.JLabel();
        schemaCombo = new javax.swing.JComboBox();

        setMinimumSize(new java.awt.Dimension(250, 300));
        setPreferredSize(new java.awt.Dimension(250, 300));
        setLayout(new java.awt.GridBagLayout());

        notePanel.setLayout(new java.awt.GridBagLayout());

        noteLabel.setText("<HTML>Select an XCCDF Schema Version for the new XCCDF Document</HTML>");
        noteLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 7, 7, 7);
        notePanel.add(noteLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.01;
        add(notePanel, gridBagConstraints);

        schemaChoicePanel.setLayout(new java.awt.GridBagLayout());

        choiceLabel.setText("XCCDF Schema Version");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 6, 5, 0);
        schemaChoicePanel.add(choiceLabel, gridBagConstraints);

        schemaCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 12);
        schemaChoicePanel.add(schemaCombo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.8;
        add(schemaChoicePanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public Object getData()
    {
        return schemaCombo.getSelectedItem();
    }

    @Override
    public void setData(Object data)
    {
    }

    @Override
    public void setWizard(Wizard wizard)
    {
        parentWiz = (CreateXCCDFWizard) wizard;
        setSatisfied(true);
        parentWiz.setSchemaType((SCAPDocumentTypeEnum)schemaCombo.getSelectedItem());
        parentWiz.enableNextButton();
    }

    @Override
    public String getPageTitle()
    {
        return EditorMessages.XCCDF + " Schema Version";
    }

    public JComboBox getSchemaCombo()
    {
        return schemaCombo;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel choiceLabel;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JPanel notePanel;
    private javax.swing.JPanel schemaChoicePanel;
    private javax.swing.JComboBox schemaCombo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void performFinish()
    {
    }
}