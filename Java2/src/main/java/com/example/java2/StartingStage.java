package com.example.java2;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StartingStage {//the Main Stage
	private Stage primaryStage = new Stage();

	StartingStage() {
		rootMaker();
	}

	private void rootMaker() {//fills the Stage
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 600, 400);
		root.setCenter(vBox());
		root.setBottom(hBox());
		root.setStyle("-fx-background-color: grey;");
		primaryStage.setTitle("Inventory Management System");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private HBox hBox() {//all buttons
		HBox hbox = new HBox();
		Button add = new Button("Add");
		Button modi = new Button("Modify");
		Button del = new Button("Delete");
		Button rep = new Button("Stock Report");
		Button read = new Button("Read From File");
		add.setId("Add");
		modi.setId("Modify");
		del.setId("Delete");
		rep.setId("Report");
		read.setId("Read From File");
		add.addEventHandler(ActionEvent.ACTION, new MyEvents());
		del.addEventHandler(ActionEvent.ACTION, new MyEvents());
		modi.addEventHandler(ActionEvent.ACTION, new MyEvents());
		rep.addEventHandler(ActionEvent.ACTION, new MyEvents());
		read.addEventHandler(ActionEvent.ACTION, new MyEvents());
		hbox.setSpacing(10);
		hbox.getChildren().addAll(add,modi,del,rep,read);
		hbox.setPadding(new Insets(15, 15, 15, 15));
		hbox.setAlignment(Pos.CENTER);
		return hbox;
	}

	private VBox vBox() {//everything other than the buttons
		VBox vbox = new VBox();
		Label invMang = new Label("Inventory Management System: Comp 2311 Project, Phase 2");
		ImageView bckground = new ImageView(new Image("file:///C:/Users/moaha/IdeaProjects/Java2/src/main/resources/inventoryManagement.jpg"));
		bckground.setRotate(45);
		invMang.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
		invMang.setOpacity(0.7);
		invMang.setTextFill(Color.MIDNIGHTBLUE);
		bckground.setFitHeight(200);
		bckground.setFitWidth(250);
		vbox.getChildren().addAll(invMang, bckground);
		vbox.setAlignment(Pos.TOP_CENTER);
		vbox.setSpacing(70);
		return vbox;
	}
}
