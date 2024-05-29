package com.example.java2;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class AddingStage extends FatherStage {
	private ToggleGroup tg = new ToggleGroup();
	private RadioButton yes = new RadioButton("Yes");
	private RadioButton no = new RadioButton("No");
	AddingStage(){
		super();
		rootMaker();
	}
	private void rootMaker(){//filles the primarystage with what is needed
		setTask("Save");
		getRoot().setBottom(getReview());
		
		yes.setToggleGroup(tg);
		no.setToggleGroup(tg);
		no.setSelected(true);
		HBox hbox = new HBox(yes, no);
		hbox.setSpacing(5);
		getGrid().add(hbox, 1, 0);
		getTask().setId("Save");
		getCancel().setId("CancelAdd");
		yes.addEventHandler(ActionEvent.ACTION, new MyEvents());
		no.addEventHandler(ActionEvent.ACTION, new MyEvents());
	}
	@Override
	public void show() {
		getPrimaryStage().show();
		
	}
	public void addItem() {//this method adds an item
		String type = getTypetxt().getText().trim();
		String exdate=getExDatetxt().getText().trim();
		if (type.trim().equals("") || type.trim().equals(null)) {
			setReview("Type is Empty");
		} else {
			try {
				int qunty = Integer.parseInt(getQuntytxt().getText().trim());
				double price = Double.parseDouble(getPricetxt().getText().trim());
				if (getBrandtxt().isVisible() == false) {
					Main.getInv().newItem(type, qunty, price,exdate);
				} else {
					String brand = getBrandtxt().getText().trim();
					if (brand.trim().equals("") || type.trim().equals(null)) {
						setReview("Brand is Empty");
					} else {
					
					Main.getInv().newItem(brand, type, qunty, price,exdate);
					}
				}
			} catch (Exception e) {
				setReview("Price and Quantity \n only accept numbers");
			}
		}
	}
	@Override
	public void close() {
		super.getPrimaryStage().close();
		
	}
	public void setToggle() {
		no.setSelected(true);
	}
}
