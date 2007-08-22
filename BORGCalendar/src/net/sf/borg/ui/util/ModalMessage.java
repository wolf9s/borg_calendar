/*
This file is part of BORG.

    BORG is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    BORG is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with BORG; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

Copyright 2003 by Mike Berger
*/
/*
 * helpscrn.java
 *
 * Created on October 5, 2003, 8:55 AM
 */

package net.sf.borg.ui.util;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import net.sf.borg.common.Resource;



public class ModalMessage extends JDialog {
 
    public ModalMessage(String s, boolean enabled) {
        initComponents();    
        jTextArea.setText(s);
        okButton.setEnabled(enabled);
        setModal(true);       
    }

    public void setEnabled(boolean e)
    {
    	okButton.setEnabled(e);
    }
    public void setText(String s)
    {
    	jTextArea.setText(s);
    }
    
    public void appendText(String s)
    {
    	String t = jTextArea.getText();
    	t += "\n" + s;
    	jTextArea.setText(t);
    }
    
    private void initComponents()//GEN-BEGIN:initComponents
    {
    	//this.setUndecorated(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("BORG");
        this.setSize(165, 300);
        this.setContentPane(getJPanel());
        
        pack();
        
        Dimension screenSize =
            Toolkit.getDefaultToolkit().getScreenSize();
          Dimension labelSize = jScrollPane.getPreferredSize();
          setLocation(screenSize.width/2 - (labelSize.width/2),
                      screenSize.height/2 - (labelSize.height/2));
    }
    
    
    private JPanel jPanel = null;
	private JScrollPane jScrollPane = null;
	private JTextArea jTextArea = null;
	
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;  // Generated
			gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;  // Generated
			gridBagConstraints1.gridy = 1;  // Generated
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;  // Generated
			gridBagConstraints.gridy = 0;  // Generated
			gridBagConstraints.weightx = 1.0;  // Generated
			gridBagConstraints.weighty = 1.0;  // Generated
			gridBagConstraints.insets = new java.awt.Insets(4,4,4,4);  // Generated
			gridBagConstraints.gridx = 0;  // Generated
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());  // Generated
			jPanel.add(getJScrollPane(), gridBagConstraints);  // Generated
			jPanel.add(getButtonPanel(), gridBagConstraints1);
		}
		return jPanel;
	}



	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setPreferredSize(new java.awt.Dimension(600,200));  // Generated
			jScrollPane.setViewportView(getJTextArea());  // Generated
		}
		return jScrollPane;
	}



	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setEditable(false);  // Generated
			jTextArea.setLineWrap(true);  // Generated
		}
		return jTextArea;
	}

	/**
	 * This method initializes buttonPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel buttonPanel = null;
	private JPanel getButtonPanel() {
		if (buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.add(getOkButton(), null);  // Generated
			
		}
		return buttonPanel;
	}



	/**
	 * This method initializes okButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton okButton = null;
	private JButton getOkButton() {
		if (okButton == null) {
			okButton = new JButton();
			okButton.setText(Resource.getResourceString("OK"));
			okButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					doOk();
				}
			});
		}
		return okButton;
	}

	private void doOk()
	{
		this.dispose();
	}


	public static void main( String args[])
    {
		final ModalMessage mm = new ModalMessage("duh\nduh\nduh", false);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
		    	mm.setVisible(true);				
			}
		});
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
		    	mm.appendText("another line");
		    	mm.setEnabled(true);				
			}
		});
    	
    }
}  //  @jve:decl-index=0:visual-constraint="10,10"