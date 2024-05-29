package com.example.java2;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;

public class MyEvents implements EventHandler<ActionEvent> {
	public static AddingStage add = new AddingStage();//creates an object 
	public static UpdatingStage update = new UpdatingStage();//creates an object 
	public static DeletingStage delete = new DeletingStage();//creates an object 
	public static StockReportStage stock = new StockReportStage();//creates an object 
	public static ErrorMessageStage error = new ErrorMessageStage();//creates an object 

	@Override
	public void handle(ActionEvent e) {
		if (e.getSource() instanceof Button) {
			if (((Button) e.getSource()).getId().equals("Add")) {//opens add class
				add.setVisible(false);
				add.show();
				add.setToggle();
			} else if (((Button) e.getSource()).getId().equals("Modify")) {//opens update class
				update.setVisible(false);
				update.show();
				update.setToggle();
			}else if (((Button) e.getSource()).getId().equals("Read From File")) {//opens filechoose class
				try {
					new FileChoose();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (((Button) e.getSource()).getId().equals("Report")) {//opens report class
				stock.show();
			} else if (((Button) e.getSource()).getId().equals("Delete")) {//opens delete class
				delete.setVisible(false);
				delete.show();
				delete.setToggle();
			} else if (((Button) e.getSource()).getId().equals("Save")) {//saves item into inventory
				add.addItem();
			} else if (((Button) e.getSource()).getId().equals("Update")) {//updates item
				update.updateInfo();
				update.setEditable(false);
			} else if (((Button) e.getSource()).getId().equals("ok")) {//closes error message
				error.close();
			} else if (((Button) e.getSource()).getId().equals("DeleteStage")) {//deletes an item
				delete.deleteInfo();
				delete.setEditable(false);
			} else if (((Button) e.getSource()).getId().equals("SearchUpdate")) {//searches for item in update
				boolean flag = update.fitchInfo();
				if (flag == false) {
					error.show();
				} else
					update.setEditable(true);

			} else if (((Button) e.getSource()).getId().equals("SearchDelete")) {//searches for item in delete
				boolean flag = delete.fitchInfo();
				if (flag == false) {
					error.show();
				} else
					update.setEditable(true);
			} else if (((Button) e.getSource()).getId().equals("Export")) {//prints data in textarea or file
				try {
					stock.Export(Main.getInv().stockReport());
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			} else if (((Button) e.getSource()).getId().equals("CancelAdd")) {//closes add
				add.close();
			} else if (((Button) e.getSource()).getId().equals("CancelUpdate")) {//closes update
				update.close();
			} else if (((Button) e.getSource()).getId().equals("CancelDelete")) {//closes delete
				delete.close();
			}
		} else if (e.getSource() instanceof CheckBox) {//changes the visibility of textarea and file in stock class depending on the checkboxs there
			if(stock.getNo().isSelected())
				stock.setAreaVisible(true);
			else
				stock.setAreaVisible(false);
			if(stock.getYes().isSelected())
				stock.setFieldVisible(true);
			else
				stock.setFieldVisible(false);
		} else if (e.getSource() instanceof RadioButton) {
			if (((RadioButton) e.getSource()).getText().equals("No")) {
				add.setVisible(false);
			}
			if (((RadioButton) e.getSource()).getText().equals("Yes")) {
				add.setVisible(true);
			}
		} else if (e.getSource() instanceof ComboBox) {
			if (((ComboBox<?>) e.getSource()).getId().equals("UpdateComboBox")) {//sets editable and the visibility of brand depending on what the user chooses
				String x = (String) ((ComboBox<?>) e.getSource()).getValue();
				if (x.equals("Brand")) {
					update.setTypeEditable(true);
					update.SearchPosNoBrand();
					update.getGrid().setConstraints(update.getBrandtxt(), 2, 1);
					update.SearchVisibilty(true);
					update.setVisible(true);
				} else if (x.equals("Not Brand")) {
					update.setTypeEditable(true);
					update.SearchPosBrand();
					update.SearchVisibilty(true);
					update.setVisible(false);
				} else {
					update.setEditable(false);
					update.SearchVisibilty(false);
				}

			}
			if (((ComboBox<?>) e.getSource()).getId().equals("DeleteComboBox")) {//sets editable and the visibility of brand depending on what the user chooses
				String x = (String) ((ComboBox<?>) e.getSource()).getValue();
				if (x.equals("Brand")) {
					delete.setTypeEditable(true);
					delete.SearchPosNoBrand();
					delete.getGrid().setConstraints(delete.getBrandtxt(), 2, 1);
					delete.SearchVisibilty(true);
					delete.setVisible(true);
				} else if (x.equals("Not Brand")) {
					delete.setTypeEditable(true);
					delete.SearchPosBrand();
					delete.SearchVisibilty(true);
					delete.setVisible(false);
				} else {
					delete.setEditable(false);
					delete.SearchVisibilty(false);
				}

			}
		}
	}
}
