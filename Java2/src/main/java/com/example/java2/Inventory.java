package com.example.java2;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Inventory {
	private ArrayList<Item> list = new ArrayList<Item>();
	private String category;

	public Inventory(String category) {
		this.category = category;
	}

	public void newItem(String type, int quantity, double price, String exdate) {// adds a new item to the arraylist of
																					// items
		if (findItem(type, true) == -1) {
			list.add(new Item(type, exdate).setPrice(price).setQuantity(quantity));
			FatherStage.getReview().setTextFill(Color.GREEN);
			FatherStage.setReview("Item Added !");// instead of printing on cmd a label is used to print in AddingStage
													// screen
		}
	}

	public void newItem(String brand, String type, int quantity, double price, String exdate) {// adds a new brand o the
																								// arraylist of
		// items
		if (findItem(type, true, brand) == -1) {
			list.add(new Brand(brand, type, exdate).setPrice(price).setQuantity(quantity));
			FatherStage.getReview().setTextFill(Color.GREEN);
			FatherStage.setReview("Brand Added !");
		}
	}

	public void setQuantity(String type, int quantity) {// sets the quantity for an already existing item
		if (findItem(type, false) != -1) {
			list.get(findItem(type, false)).setQuantity(quantity);
		}
	}

	public void setQuantity(String brand, String type, int quantity) {// sets the quantity for an already existing item
		if (findItem(type, false, brand) != -1) {
			list.get(findItem(type, false, brand)).setQuantity(quantity);
		}
	}

	public void setPrice(String type, double price) {// sets the price for an already existing item
		if (findItem(type, false) != -1) {
			list.get(findItem(type, false)).setPrice(price);
		}
	}

	public void setPrice(String brand, String type, double price) {// sets the price for an already existing item
		if (findItem(type, false, brand) != -1) {
			list.get(findItem(type, false)).setPrice(price);
		}
	}

	public String getExDate(String type) {
		if (findItem(type, false) != -1) {
			return list.get(findItem(type, false)).getExdate();
		}
		return null;
	}

	public String getExDate( String brand,String type) {
		if (findItem(type, false, brand) != -1) {
			return list.get(findItem(type, false,brand)).getExdate();
		}
		return null;
	}

	public int getQuantity(String type) {// returns the stock of a certain item
		if (findItem(type, false) != -1) {
			return list.get(findItem(type, false)).getQuantity();
		}
		return -1;
	}

	public int getQuantity(String brand, String type) {// returns the stock of a certain brand
		if (findItem(type, false, brand) != -1) {
			return list.get(findItem(type, false, brand)).getQuantity();
		}
		return 0;
	}

	public double getPrice(String type) {// returns the price of a certain item
		if (findItem(type, false) != -1) {
			return list.get(findItem(type, false)).getPrice();
		}
		return Double.NaN;
	}

	public double getPrice(String brand, String type) {// returns the price of a certain brand
		if (findItem(type, false, brand) != -1) {
			return list.get(findItem(type, false, brand)).getPrice();
		}
		return Double.NaN;
	}

	public void update(String type, int qtyIncrease) {// updates the stock of an already existing item
		if (findItem(type, false) != -1) {
			list.get(findItem(type, false)).update(qtyIncrease);
		}
	}

	public void update(String brand, String type, int qtyIncrease) {// updates the stock of an already existing brand
		if (findItem(type, false, brand) != -1) {
			list.get(findItem(type, false, brand)).update(qtyIncrease);
		}
	}

	public void update(String type, double adjustmentFactor) {// updates the price of an already existing item
		if (findItem(type, false) != -1) {
			list.get(findItem(type, false)).update(adjustmentFactor);
		}
	}

	public void update(String brand, String type, double adjustmentFactor) {// updates the price of an already existing
																			// brand
		if (findItem(type, false, brand) != -1) {
			list.get(findItem(type, false, brand)).update(adjustmentFactor);
		}
	}

	public void update(String brand, String type, String date) {// updates the price of an already existing
		// brand
		if (findItem(type, false, brand) != -1) {
			list.get(findItem(type, false, brand)).setExdate(date);
		}
	}
	public void update( String type, String date) {// updates the price of an already existing
		// brand
		if (findItem(type, false) != -1) {
			list.get(findItem(type, false)).setExdate(date);
		}
	}

	private int findItem(String type, boolean warningIfFound) {// searches for the item in the array list until it finds
																// it
		int brandsFound = 0;
		int itemsFound = 0;
		int index = -1;
		FatherStage.getReview().setTextFill(Color.RED);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getType().equals(type)) {
				if (list.get(i) instanceof Brand)
					brandsFound++;
				else
					itemsFound++;
				index = i;
			}
		}
		if (itemsFound == 0 && !warningIfFound) {
			FatherStage.setReview("Cannot find " + type);
		}
		if (itemsFound != 0 && warningIfFound) {
			FatherStage.setReview(type + " already exists");
		}
		if (brandsFound >= 1) {
			FatherStage.setReview("Found more than one brand of " + type);
		}
		if (itemsFound == 1)
			return index;
		return -1;
	}

	private int findItem(String type, boolean warningIfFound, String brand) {// searches for the brand in the array list
																				// until it finds it
		int itemsFound = 0;
		int index = -1;
		FatherStage.getReview().setTextFill(Color.RED);
		for (int i = 0; i < list.size(); i++) {
			if (type.equals(list.get(i).getType()) && list.get(i) instanceof Brand
					&& brand.equals(((Brand) list.get(i)).getBrand())) {
				itemsFound++;
				index = i;
			}
		}
		if (itemsFound == 0 && !warningIfFound) {
			FatherStage.setReview("Cannot find " + brand + " " + type);
		}
		if (itemsFound != 0 && warningIfFound) {
			FatherStage.setReview("already exists");
		}
		if (itemsFound == 1)
			return index;

		else
			return -1;
	}

	public ArrayList<String> stockReport() {// changed the return type to arraylist so the program can print in a file
											// and text area
		ArrayList<String> strings = new ArrayList<>();
		double sum = 0;
		for (int j = 0; j < list.size(); j++) {
			Item i = list.get(j);
			if (i instanceof Brand)
				strings.add(((Brand) i).getBrand() + " " + i.getType() + " -in stock: " + i.getQuantity() + " ,price:$ "
						+ i.getPrice() + " expiration Date: " + i.getExdate());
			else
				strings.add(i.getType() + " -in stock: " + i.getQuantity() + " ,price:$ " + i.getPrice()
						+ " expiration Date: " + i.getExdate());
			sum += (i.getPrice() * i.getQuantity());
		}
		strings.add("Total value: " + sum);
		return strings;
	}

	public void deleteItem(String type, String brand) {
		if (findItem(type, false, brand) != -1) {
			list.remove(findItem(type, false, brand));
		}
	}

	public void deleteItem(String type) {
		if (findItem(type, false) != -1) {
			list.remove(findItem(type, false));
		}
	}
}
