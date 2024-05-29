package com.example.java2;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

public class DeletingStage extends FatherStage {// this class extends FatherStage so less is needed to be added here
	private Button search = new Button("Search");
	private ComboBox<String> brand = new ComboBox<String>();
	DeletingStage() {
		super();
		rootMaker();
	}

	private void rootMaker() {// fills the primaryStage with all the buttons
		super.setTask("Delete");
		super.getPrimaryStage().setTitle("Delete Item");
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
		brand.setId("DeleteComboBox");
		super.getCancel().setId("CancelDelete");
		brand.getItems().addAll("Brand", "Not Brand");
		HBox hbox = new HBox(brand);
		hbox.setSpacing(5);
		super.getGrid().add(hbox, 1, 0);
		search.setId("SearchDelete");
		super.getTask().setId("DeleteStage");
		search.addEventHandler(ActionEvent.ACTION, new MyEvents());
		brand.addEventHandler(ActionEvent.ACTION, new MyEvents());
	}

	public boolean fitchInfo() {// brings all the information needed to delete an item after the search button
								// is pressed
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
			super.getExDatetxt().setText(""+Main.getInv().getExDate(brand, type));
		} else {
			super.getPricetxt().setText("" + Main.getInv().getPrice(type));
			super.getQuntytxt().setText("" + Main.getInv().getQuantity(type));
			super.getExDatetxt().setText(""+Main.getInv().getExDate(type));

		}
		if (super.getPricetxt().getText().equals("NaN")) {
			ErrorMessageStage.setErrorMsg("Item not found");
			return false;
		} else
			return true;
	}

	public void deleteInfo() {// deletes the item after it was found
		String type = getTypetxt().getText().trim();
		if (type.trim().equals("") || type.trim().equals(null)) {
			ErrorMessageStage.setErrorMsg("Type is Empty");
		} else {
			if (getBrandtxt().isVisible() == false) {
				Main.getInv().deleteItem(type);
				;
			} else {
				String brand = getBrandtxt().getText().trim();
				if (brand.trim().equals("") || brand.trim().equals(null)) {
					ErrorMessageStage.setErrorMsg("Brand is Empty");
				} else
					System.out.println("here");
					Main.getInv().deleteItem(type,brand);
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
	}

	public void SearchPosBrand() {// changes the position of search when a brand is there
		super.getGrid().setConstraints(search, 2, 1);
	}

	public void SearchPosNoBrand() {// changes the position of search when a brand is not there
		super.getGrid().setConstraints(search, 3, 1);
	}
	public void setToggle() {
		brand.getSelectionModel().select(1);
	}

}
