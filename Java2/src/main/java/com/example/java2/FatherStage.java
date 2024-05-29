package com.example.java2;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public abstract class FatherStage {//the main class that has what at least 2 classes have in common
	private Stage primaryStage = new Stage();
	private Button task = new Button();
	private Button cancel = new Button("Cancel");

	private HBox hbox = new HBox();
	private GridPane grid = new GridPane();
	private Label brandtwo = new Label("Brand:");
	private TextField brandtxt = new TextField();
	private TextField typetxt = new TextField();
	private TextField pricetxt = new TextField();
	private TextField quntytxt = new TextField();
	private TextField exDatetxt = new TextField();
	private static Label Review = new Label("");
	private BorderPane root = new BorderPane();
	private Scene scene = new Scene(root, 400, 400);

	FatherStage() {
		rootMaker();
	}

	private void rootMaker() {
		root.setCenter(grid());
		root.setStyle("-fx-background-color: grey;");
		getReview().setFont(Font.font("Helvetica ", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
		getReview().setPadding(new Insets(0, 120, 70, 70));

		primaryStage.setTitle("Add new Item");
		primaryStage.setScene(scene);
	}

	public GridPane grid() {
		hbox.setSpacing(5);
		hbox.setSpacing(10);
		hbox.getChildren().addAll(task, cancel);
		hbox.setPadding(new Insets(15, 15, 15, 15));
		Label brand = new Label("Brand:");
		Label type = new Label("Type:");
		Label price = new Label("Price:");
		Label qunty = new Label("Quantity:");
		Label exdate = new Label("Expiration date:");
		typetxt.setPromptText("Enter the type");
		pricetxt.setPromptText("Enter the price");
		quntytxt.setPromptText("enter the Quantity");
		brandtxt.setPromptText("Enter the brand");
		exDatetxt.setPromptText("Enter the expiration date");
		brandtwo.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
		brand.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
		type.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
		price.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
		qunty.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
		brand.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
		grid.add(brand, 0, 0);
		grid.add(type, 0, 1);
		grid.add(price, 0, 2);
		grid.add(qunty, 0, 3);
		grid.add(exdate, 0, 4);
		grid.add(brandtwo, 0, 5);
		grid.add(typetxt, 1, 1);
		grid.add(pricetxt, 1, 2);
		grid.add(quntytxt, 1, 3);
		grid.add(brandtxt, 1, 5);
		grid.add(exDatetxt, 1, 4);
		grid.add(hbox, 1, 7);
		grid.setHgap(2);
		grid.setVgap(10);
		grid.setAlignment(Pos.TOP_CENTER);
		task.addEventHandler(ActionEvent.ACTION, new MyEvents());
		cancel.addEventHandler(ActionEvent.ACTION, new MyEvents());
		return grid;
	}
	public TextField getExDatetxt() {
		return exDatetxt;
	}

	public void setExDatetxt(TextField exDatetxt) {
		this.exDatetxt = exDatetxt;
	}

	public void setEditable(boolean flag) {//makes the textfields edit free when needed or the oppesite
		pricetxt.setEditable(flag);
		quntytxt.setEditable(flag);
		;
	}
	public void setTypeEditable(boolean flag) {//makes the type textfield and brand edit free when needed or the oppesite
		brandtxt.setEditable(flag);
		getTypetxt().setEditable(flag);
	}

	public void setVisible(boolean flag) {
		brandtwo.setVisible(flag);
		brandtxt.setVisible(flag);
	}

	public void setDisabled(boolean flag) {
		brandtwo.setDisable(flag);
		brandtxt.setDisable(flag);
	}

	public abstract void show();

	public abstract void close();
/*****************************Getters and Setters*******************/
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Button getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task.setText(task);
	}

	public HBox getHbox() {
		return hbox;
	}

	public void setHbox(HBox hbox) {
		this.hbox = hbox;
	}

	public GridPane getGrid() {
		return grid;
	}

	public void setGrid(GridPane grid) {
		this.grid = grid;
	}

	public TextField getBrandtxt() {
		return brandtxt;
	}

	public void setBrandtxt(TextField brandtxt) {
		this.brandtxt = brandtxt;
	}

	public TextField getTypetxt() {
		return typetxt;
	}

	public void setTypetxt(TextField typetxt) {
		this.typetxt = typetxt;
	}

	public TextField getPricetxt() {
		return pricetxt;
	}

	public void setPricetxt(TextField pricetxt) {
		this.pricetxt = pricetxt;
	}

	public TextField getQuntytxt() {
		return quntytxt;
	}

	public void setQuntytxt(TextField quntytxt) {
		this.quntytxt = quntytxt;
	}
	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}
	public Label getBrand() {
		return brandtwo;
	}

	public void setBrand(Label brand) {
		this.brandtwo = brand;
	}

	public static Label getReview() {
		return Review;
	}

	public static void setReview(String review) {
		Review.setText(review);
	}

	public BorderPane getRoot() {
		return root;
	}

	public void setRoot(BorderPane root) {
		this.root = root;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

}