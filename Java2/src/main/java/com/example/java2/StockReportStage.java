package com.example.java2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StockReportStage {//Stock Report class to save Inventory
	private  Stage primaryStage = new Stage();
	private  CheckBox yes = new CheckBox("Export a copy to a file");
	private static  TextArea ta = new TextArea();
	private  TextField tf = new TextField();
	private Label one = new Label("The following options can be used to print a report");
	private  CheckBox no = new CheckBox("TextArea");
	BorderPane root = new BorderPane();
	public static TextArea getTa() {
		return ta;
	}
	public static void setTa(TextArea ta) {
		StockReportStage.ta = ta;
	}
	public TextField getTf() {
		return tf;
	}
	public void setTf(TextField tf) {
		this.tf = tf;
	}
	public Label getOne() {
		return one;
	}
	public void setOne(Label one) {
		this.one = one;
	}
	public BorderPane getRoot() {
		return root;
	}
	public void setRoot(BorderPane root) {
		this.root = root;
	}
	StockReportStage() {
		rootMaker();
		
	}
	public void show() {
		primaryStage.show();
	}
	public void close() {
		primaryStage.close();
	}
	private void rootMaker() {//fills the Stage with everything needed
		root.setTop(one);
		root.setLeft(filling());
		root.setCenter(ta);
		tf.setVisible(false);
		ta.setVisible(false);
		Scene scene = new Scene(root, 600, 400);
		primaryStage.setTitle("Stock Report");
		ta.setMaxHeight(root.getHeight() / 1.6);
		primaryStage.setScene(scene);

	}
	private GridPane filling() {//filles the root with everything needed
		one.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
		Button two = new Button("Export");
		GridPane gridPane = new GridPane();
		HBox h1 = new HBox();
		h1.getChildren().addAll(yes, no);
		gridPane.add(h1, 0, 0);
		gridPane.add(tf, 0, 1);
		gridPane.add(two, 0, 2);
		gridPane.setHgap(2);
		gridPane.setVgap(10);
		two.setId("Export");
		yes.addEventHandler(ActionEvent.ACTION, new MyEvents());
		no.addEventHandler(ActionEvent.ACTION, new MyEvents());
		two.addEventHandler(ActionEvent.ACTION, new MyEvents());
		gridPane.setAlignment(Pos.TOP_CENTER);
		return gridPane;
	}

	private static void TextArea(ArrayList<String> strings) {//print in the text area
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < strings.size(); i++) {
			str.append(strings.get(i) + "\n");
		}
		ta.setText(str.toString());

	}

	public  void Export(ArrayList<String> strings) throws IOException {//print based on what's selected
		if(yes.isSelected()) {
			writefile(strings);
		}
		if(no.isSelected())
			TextArea(strings);
		else {
			strings.removeAll(strings);
			strings.add(" ");
			TextArea(strings);
		}
	}

	private  void writefile(ArrayList<String> strings) throws IOException {//print in a file
		String str=tf.getText().trim();
		File out=new File(str);
		FileWriter write=new FileWriter(out);
		StringBuilder bld = new StringBuilder();
		for (int i = 0; i < strings.size()-1; i++) {
			bld.append(strings.get(i) + "\n");
		}
		write.write(bld.toString());
		write.close();
	}
	public void setFieldVisible(boolean flag) {
		tf.setVisible(flag);
	}
	public void setAreaVisible(boolean flag) {
		ta.setVisible(flag);
	}
	/*******************Getters and Setters ***********************/
	public CheckBox getYes() {
		return yes;
	}
	public void setYes(CheckBox yes) {
		this.yes = yes;
	}
	public CheckBox getNo() {
		return no;
	}
	public void setNo(CheckBox no) {
		this.no = no;
	}
	public  Stage getPrimaryStage() {
		return primaryStage;
	}

	public  void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
}

//////////////////////////////////////////////////
