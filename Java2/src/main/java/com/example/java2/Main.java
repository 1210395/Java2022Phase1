	package com.example.java2;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private static Inventory inv = new Inventory("1");//makes an object of class inventory to hold all items
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			new StartingStage();//replaced main stage with this class
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
/********************Getters and Setters********************/
	public static Inventory getInv() {
		return inv;
	}

	public static void setInv(Inventory inv) {
		Main.inv = inv;
	}
}
