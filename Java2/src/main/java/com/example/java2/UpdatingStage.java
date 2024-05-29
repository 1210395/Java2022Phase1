package com.example.java2;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

public class UpdatingStage extends FatherStage {//this stage extends FatherStage 
	private Button search = new Button("Search");
	private ComboBox<String> brand = new ComboBox<String>();
	UpdatingStage() {
		super();
		rootMaker();
	}

	private void rootMaker() {//fills the primaryStage
		super.setTask("Update");
		super.getPrimaryStage().setTitle("Update Item");
		super.getTask().addEventHandler(ActionEvent.ACTION, new MyEvents());
		search.setVisible(false);
		brand.setPrefWidth(200);
		brand.setEditable(true);
		super.getTypetxt().setEditable(false);
		super.getPricetxt().setEditable(false);
		super.getQuntytxt().setEditable(false);
		super.getPrimaryStage().setWidth(600);
		super.getGrid().getChildren().removeAll(super.getBrand());
		super.getGrid().setConstraints(super.getHbox(), 1, 5);
		super.getGrid().setConstraints(super.getBrandtxt(), 9, 9);
		super.getGrid().add(search, 2, 1);
		brand.setId("UpdateComboBox");
		super.getCancel().setId("CancelUpdate");
		brand.getItems().addAll("Brand", "Not Brand");
		HBox hbox = new HBox(brand);
		hbox.setSpacing(5);
		super.getGrid().add(hbox, 1, 0);
		search.setId("SearchUpdate");
		super.getTask().setId("Update");
		
		search.addEventHandler(ActionEvent.ACTION, new MyEvents());
		brand.addEventHandler(ActionEvent.ACTION, new MyEvents());
	}
	public  boolean fitchInfo() {//brings all the information needed by the update method
		String type = super.getTypetxt().getText().trim();
		String brand = super.getBrandtxt().getText().trim();
		if (super.getBrandtxt().isVisible()) {
			if (brand.trim().equals("") || brand.trim().equals(null)) {
				ErrorMessageStage.setErrorMsg("Brand is empty");
				return false;
			}
		}
		if (type.trim().equals("") || type.trim().equals(null)) {
			ErrorMessageStage.setErrorMsg("Type is Empty");
			return false;
		}
		if (super.getBrandtxt().isVisible()) {
			super.getPricetxt().setText("" + Main.getInv().getPrice(brand, type));
			super.getQuntytxt().setText("" + Main.getInv().getQuantity(brand, type));
			super.getExDatetxt().setText(""+Main.getInv().getExDate(type, brand));
		} else {
			super.getPricetxt().setText("" + Main.getInv().getPrice(type));
			super.getQuntytxt().setText("" + Main.getInv().getQuantity(type));
			super.getExDatetxt().setText(""+Main.getInv().getExDate(type));

		}
		if (super.getPricetxt().getText().equals("NaN")) {
			ErrorMessageStage.setErrorMsg("Item not found");
			return false;
		}
		else
			return true;
	}
	public  void updateInfo() {//updates the item 
		String type = super.getTypetxt().getText().trim();
		if (type.trim().equals("") || type.trim().equals(null)) {
			ErrorMessageStage.setErrorMsg("Type is Empty");
		} else {
			try {
				int qunty = Integer.parseInt(super.getQuntytxt().getText());
				double price = Double.parseDouble(super.getPricetxt().getText());
				String date=getExDatetxt().getText().trim();
				if (super.getBrandtxt().isVisible() == false) {
					Main.getInv().update(type, qunty);
					Main.getInv().update(type, price);
					Main.getInv().update(type, date);
				} else {
					String brand = super.getBrandtxt().getText();
					if (brand.trim().equals("") || brand.trim().equals(null)) {
						ErrorMessageStage.setErrorMsg("Brand is Empty");
					} else {
						Main.getInv().update(brand, type, qunty);
						Main.getInv().update(brand, type, price);
						Main.getInv().update(brand, type, date);
					}
				}
			} catch (Exception e) {
				ErrorMessageStage.setErrorMsg("Price and Quantity \n only accept numbers");
			}
		}
	}

	@Override
	public void show() {
		super.getPrimaryStage().show();

	}

	@Override
	public void close() {
		super.getPrimaryStage().close();

	}
	public void SearchVisibilty(boolean flag) {
		search.setVisible(flag);
	}public void SearchPosBrand() {//same as DeletingClass
		super.getGrid().setConstraints(search, 2, 1);
	}
	public void SearchPosNoBrand() {//same as DeletingClass
		super.getGrid().setConstraints(search, 3, 1);
	}
	public void setToggle() {
		brand.getSelectionModel().select(1);
	}
	
}
