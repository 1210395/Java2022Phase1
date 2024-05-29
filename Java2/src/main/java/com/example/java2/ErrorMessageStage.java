package com.example.java2;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ErrorMessageStage {//this class is used for when an error happens
	private static Label errorMsg=new Label("");
	
	private  Stage error = new Stage();
	ErrorMessageStage(){
		Button ok = new Button("ok");
		HBox hbox = new HBox(ok);
		BorderPane scene = new BorderPane();
		errorMsg.setAlignment(Pos.CENTER);
		errorMsg.setTextFill(Color.RED);
		scene.setCenter(errorMsg);
		hbox.setPadding(new Insets(0, 0, 15, 0));
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		errorMsg.setAlignment(Pos.CENTER);
		scene.setBottom(hbox);
		Scene sceneerror = new Scene(scene, 280, 120);
		error.setScene(sceneerror);
		error.setTitle("Error");
		ok.setId("ok");
		ok.addEventHandler(ActionEvent.ACTION, new MyEvents());
	}
	public void show() {
		errorMsg.setFont(Font.font("Helvetica ", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 12));
		error.show();
		
	}


	public void close() {
		error.close();
		errorMsg.setFont(Font.font("Helvetica ", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 20));
	}
	public  Stage getError() {
		return this.error;
	}
	public static Label getErrorMsg() {
		return errorMsg;
	}
	public static void setErrorMsg(String errorMsg) {
		ErrorMessageStage.errorMsg.setText(errorMsg);;
	}
}
