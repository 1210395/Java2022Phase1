package com.example.java2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChoose {//makes a stage to let the user choose any text file he wants
	FileChoose() throws FileNotFoundException{
		Stage prime=new Stage();
		FileChooser choose=new FileChooser();
		choose.setTitle("File Chooser");
		File file=choose.showOpenDialog(prime);
		HBox r = new HBox();
		r.setSpacing(20);
		Scene sc = new Scene(r,350,100);
		prime.setScene(sc);
		prime.setTitle(" file chooser");
		prime.show();
		if (file != null) {
/***********splitting and Reading the file and saving in Inv*************************/
			prime.close();
			FileReader read=new FileReader(file);
			Scanner in=new Scanner(read);
			while(in.hasNextLine()) {
				String [] str=in.nextLine().split(" ");
				if(str.length==9) {
					String type=str[0].trim();
					String exdate=str[8].trim();
					int qunty=Integer.parseInt(str[3].trim());
					double price=Double.parseDouble(str[5].trim());
					Main.getInv().newItem(type, qunty, price,exdate);
				}else if(str.length==10) {
					String brand=str[0].trim();
					String type=str[1].trim();
					String exdate=str[9].trim();
					int qunty=Integer.parseInt(str[4].trim());
					double price=Double.parseDouble(str[6].trim());
					Main.getInv().newItem(brand, type, qunty, price,exdate);
				}else {
					
				}
			}
			}
		
	}
}
