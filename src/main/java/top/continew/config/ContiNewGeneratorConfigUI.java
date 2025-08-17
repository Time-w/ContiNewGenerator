package top.continew.config;

import java.util.Objects;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import top.continew.constant.GenerateConstant;

/**
 * @author Administrator
 * @date 2025-08-18 0:01
 */
public class ContiNewGeneratorConfigUI {

	private JPanel rootPanel;
	private JTextField responseExcludeTextField;
	private JTextField requestExcludeTextField;
	private JTextField requiredExcludeTextField;
	private JTextField queryExcludeTextField;
	private JComboBox<String> stringTypeComboBox;
	private JComboBox<String> numberTypeComboBox;
	private JComboBox<String> dateTypeComboBox;
	private JCheckBox highlightCheckBox;
	private JComboBox<String> booleanTypeComboBox;
	ContiNewConfigPersistent contiNewConfigPersistent = ContiNewConfigPersistent.getInstance();

	public JComponent createComponent() {
		stringTypeComboBox.setModel(new DefaultComboBoxModel<>(GenerateConstant.QUERY_TYPE_OPTIONS));
		numberTypeComboBox.setModel(new DefaultComboBoxModel<>(GenerateConstant.QUERY_TYPE_OPTIONS));
		dateTypeComboBox.setModel(new DefaultComboBoxModel<>(GenerateConstant.QUERY_TYPE_OPTIONS));
		booleanTypeComboBox.setModel(new DefaultComboBoxModel<>(GenerateConstant.QUERY_TYPE_OPTIONS));
		if (contiNewConfigPersistent.getHightLight() == null) {
			contiNewConfigPersistent.setHightLight(true);
		}
		if (contiNewConfigPersistent.getRequestExcludeText() == null) {
			contiNewConfigPersistent.setRequestExcludeText("createUser,createTime,updateUser,updateTime,deleteUser,deleteTime,delFlag,isDeleted,deletedBy");
		}
		if (contiNewConfigPersistent.getResponseExcludeText() == null) {
			contiNewConfigPersistent.setResponseExcludeText("id,createUser,createTime,updateUser,updateTime,deleteUser,deleteTime,delFlag,isDeleted,deletedBy");
		}
		if (contiNewConfigPersistent.getRequiredExcludeText() == null) {
			contiNewConfigPersistent.setRequiredExcludeText("id,createUser,createTime,updateUser,updateTime,deleteUser,deleteTime,delFlag,isDeleted,deletedBy");
		}
		if (contiNewConfigPersistent.getQueryExcludeText() == null) {
			contiNewConfigPersistent.setQueryExcludeText("createUser,createTime,updateUser,updateTime,deleteUser,deleteTime,delFlag,isDeleted,deletedBy");
		}
		if (contiNewConfigPersistent.getStringType() == null) {
			contiNewConfigPersistent.setStringType("LIKE '%s%'");
		}
		if (contiNewConfigPersistent.getNumberType() == null) {
			contiNewConfigPersistent.setNumberType("=");
		}
		if (contiNewConfigPersistent.getDateType() == null) {
			contiNewConfigPersistent.setDateType("BETWEEN");
		}
		if (contiNewConfigPersistent.getBooleanType() == null) {
			contiNewConfigPersistent.setBooleanType("=");
		}
		return rootPanel;
	}

	public void apply() {
		contiNewConfigPersistent.setHightLight(highlightCheckBox.isSelected());
		contiNewConfigPersistent.setRequestExcludeText(requestExcludeTextField.getText());
		contiNewConfigPersistent.setResponseExcludeText(responseExcludeTextField.getText());
		contiNewConfigPersistent.setRequiredExcludeText(requiredExcludeTextField.getText());
		contiNewConfigPersistent.setQueryExcludeText(queryExcludeTextField.getText());
		contiNewConfigPersistent.setStringType((String) stringTypeComboBox.getSelectedItem());
		contiNewConfigPersistent.setNumberType((String) numberTypeComboBox.getSelectedItem());
		contiNewConfigPersistent.setDateType((String) dateTypeComboBox.getSelectedItem());
		contiNewConfigPersistent.setBooleanType((String) booleanTypeComboBox.getSelectedItem());
	}

	public void reset() {
		highlightCheckBox.setSelected(contiNewConfigPersistent.getHightLight());
		requestExcludeTextField.setText(contiNewConfigPersistent.getRequestExcludeText());
		responseExcludeTextField.setText(contiNewConfigPersistent.getResponseExcludeText());
		requiredExcludeTextField.setText(contiNewConfigPersistent.getRequiredExcludeText());
		queryExcludeTextField.setText(contiNewConfigPersistent.getQueryExcludeText());
		stringTypeComboBox.setSelectedItem(contiNewConfigPersistent.getStringType());
		numberTypeComboBox.setSelectedItem(contiNewConfigPersistent.getNumberType());
		dateTypeComboBox.setSelectedItem(contiNewConfigPersistent.getDateType());
		booleanTypeComboBox.setSelectedItem(contiNewConfigPersistent.getBooleanType());
	}

	public boolean isModified() {
		return contiNewConfigPersistent.getHightLight() != highlightCheckBox.isSelected() ||
				!Objects.equals(contiNewConfigPersistent.getRequestExcludeText(), requestExcludeTextField.getText()) ||
				!Objects.equals(contiNewConfigPersistent.getResponseExcludeText(), responseExcludeTextField.getText()) ||
				!Objects.equals(contiNewConfigPersistent.getRequiredExcludeText(), requiredExcludeTextField.getText()) ||
				!Objects.equals(contiNewConfigPersistent.getQueryExcludeText(), queryExcludeTextField.getText()) ||
				!Objects.equals(contiNewConfigPersistent.getStringType(), (String) stringTypeComboBox.getSelectedItem()) ||
				!Objects.equals(contiNewConfigPersistent.getNumberType(), (String) numberTypeComboBox.getSelectedItem()) ||
				!Objects.equals(contiNewConfigPersistent.getDateType(), (String) dateTypeComboBox.getSelectedItem()) ||
				!Objects.equals(contiNewConfigPersistent.getBooleanType(), (String) booleanTypeComboBox.getSelectedItem());

	}
}
