package application;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainController implements Initializable {
	Connection connection;

	public MainController() {

		connection = SQL_Connection.Connector();
		if (connection == null)
			System.exit(1);

	}

	// the listview id for ui linking
	@FXML
	ListView<String> listView;

	// textField id for linking
	@FXML
	TextField text = new TextField();

	// making a list to store result which only takes a list 
	ObservableList<String> list;

	// making a normal list to pass to observable list
	List<String> Nlist = new ArrayList<String>();

	public void SQL_Engine() {
		// getting the text from text field area
		String input = text.getText();
		String test = "";

		try {
			if (input.isEmpty()) {

				String sql = "select construct as name, speed, opcycle, Type,Price from" + " Engine join Ship"
						+ " on Engine.shiptype=Ship.shipid";
				PreparedStatement stmt = connection.prepareStatement(sql);
				ResultSet res = stmt.executeQuery();

				while (res.next()) {
					test = "NAME: " + res.getString("name") + "   SPEED: " + res.getString("speed") + "   OPCYCLE: "
							+ res.getString("opcycle") + "   TYPE: " + res.getString("Type") + "   Price: $"
							+ res.getString("Price");
					Nlist.add(test);// adding item to the normal list

				}

			} else {
				String sql = "select construct as name, speed, opcycle,Type, Price from" + " Engine join Ship"
						+ " on Engine.shiptype=Ship.shipid" + " where Engine.construct like ?";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, input);//we use setString when there is a ? in the sql statement, the second argument replace ?
				ResultSet res = stmt.executeQuery();

				// getting the result and storing them into a list
				while (res.next()) {
					test = "NAME: " + res.getString("name") + "   SPEED: " + res.getString("speed") + "   OPCYCLE :"
							+ res.getString("opcycle") + "   TYPE: " + res.getString("Type") + "   Price: $"
							+ res.getString("Price");
					Nlist.add(test);// adding item to the normal list

				}

				// if the search box found no result the we put that into the
				// list
				if (test.isEmpty()) {
					Nlist.add("SORRY SERACH NOT FOUND !, check spelling");
				}
			}

			list = FXCollections.observableArrayList(Nlist);
			// adding item to a list
			listView.setItems(list);// adding the normal list to observable list
			Nlist.clear();

		} catch (SQLException e) {
			System.out.println(e);

		}
	}

	public void SQL_Battery() {
		// getting the text from text field area
		String input = text.getText();
		String test = "";

		try {
			if (input.isEmpty()) {

				String sql = "select Model , Caliber, Modifcation, Type,Price from" + " Battery join Ship"
						+ " on Battery.shiptype=Ship.shipid";
				PreparedStatement stmt = connection.prepareStatement(sql);
				ResultSet res = stmt.executeQuery();

				while (res.next()) {
					test = "MODEL: " + res.getString("Model") + "   CALIBER: " + res.getString("Caliber")
							+ "   MODIFICATION: " + res.getString("Modifcation") + "   TYPE: " + res.getString("Type")
							+ "   Price: $" + res.getString("Price");
					Nlist.add(test);// adding item to the normal list

				}

			} else {
				String sql = "select Model , Caliber, Modifcation, Type,Price from" + " Battery join Ship"
						+ " on Battery.shiptype=Ship.shipid" + " where Battery.Model like ?";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, input);
				ResultSet res = stmt.executeQuery();

				// getting the result and storing them into a list
				while (res.next()) {
					test = "MODEL: " + res.getString("Model") + "   CALIBER: " + res.getString("Caliber")
							+ "   MODIFICATION: " + res.getString("Modifcation") + "   TYPE: " + res.getString("Type")
							+ "   Price: $" + res.getString("Price");
					Nlist.add(test);// adding item to the normal list

				}

				// if the search box found no result the we put that into the
				// list
				if (test.isEmpty()) {
					Nlist.add("SORRY SERACH NOT FOUND !, check spelling");
				}
			}

			list = FXCollections.observableArrayList(Nlist);
			// adding item to a list
			listView.setItems(list);// adding the normal list to observable list
			Nlist.clear();

		} catch (SQLException e) {
			System.out.println(e);

		}

	}

	public void SQL_Torpedo() {
		// getting the text from text field area
		String input = text.getText();
		String test = "";

		try {
			if (input.isEmpty()) {

				String sql = "select Torpedo.Type as name , Length, Ship.Type as Type,Price from" +
				" Torpedo join Ship"
						+ " on Torpedo.shiptype=Ship.shipid";
				PreparedStatement stmt = connection.prepareStatement(sql);
				ResultSet res = stmt.executeQuery();

				while (res.next()) {
					test = "NAME: " + res.getString("name") + "   LENGTH: " + res.getString("Length")
							+ "   TYPE: " + res.getString("Type")
							+ "   Price: $" + res.getString("Price");
					Nlist.add(test);// adding item to the normal list
				}

			} else {
				String sql = "select Torpedo.Type as name , Length, Ship.Type as Type,Price from"
						+" Torpedo join Ship"
						+ " on Torpedo.shiptype=Ship.shipid"
						+ " where Torpedo.Type like ?";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, input);
				ResultSet res = stmt.executeQuery();

				// getting the result and storing them into a list
				while (res.next()) {
					test = "NAME: " + res.getString("name") + "   LENGTH: " + res.getString("Length")
							+ "   TYPE: " + res.getString("Type")
							+ "   Price: $" + res.getString("Price");
					Nlist.add(test);// adding item to the normal list
				}

				// if the search box found no result the we put that into the
				// list
				if (test.isEmpty()) {
					Nlist.add("SORRY SEARCH NOT FOUND!, check spelling");
				}
			}

			list = FXCollections.observableArrayList(Nlist);
			// adding item to a list
			listView.setItems(list);// adding the normal list to observable list
			Nlist.clear();

		} catch (SQLException e) {
			System.out.println(e);

		}

	}
	
	public void SQL_Ship()
	{
		// getting the text from text field area
				String input = text.getText();
				String test = "";

				try {
					if (input.isEmpty()) {

						String sql = "select Type as name, purpose" +
						" from Ship";
						PreparedStatement stmt = connection.prepareStatement(sql);
						ResultSet res = stmt.executeQuery();

						while (res.next()) {
							test = "NAME: " + res.getString("name") + "   PURPOSE: " + res.getString("purpose");
							Nlist.add(test);// adding item to the normal list
						}

					} else {
						String sql ="select Type as name, purpose" +
								" from Ship"+
								" where Type like ?";
						PreparedStatement stmt = connection.prepareStatement(sql);
						stmt.setString(1, input);
						ResultSet res = stmt.executeQuery();

						// getting the result and storing them into a list
						while (res.next()) {
							test = "NAME: " + res.getString("name") + "   PURPOSE: " + res.getString("purpose");
							Nlist.add(test);// adding item to the normal list
						}

						// if the search box found no result the we put that into the
						// list
						if (test.isEmpty()) {
							Nlist.add("SORRY SERACH NOT FOUND !, check spelling");
						}
					}

					list = FXCollections.observableArrayList(Nlist);
					// adding item to a list
					listView.setItems(list);// adding the normal list to observable list
					Nlist.clear();

				} catch (SQLException e) {
					System.out.println(e);

				}
	}

	// button function that call sql statement for Engine
	public void EngineBTN(ActionEvent event)

	{
		SQL_Engine();
	}

	// button function that calls sql statement for Battery
	public void BatteryBTN(ActionEvent event) {
		SQL_Battery();
	}

	// button to call sql statement for Torpedo
	public void TorpedoBTN(ActionEvent event) {
		SQL_Torpedo();
	}
	
	//butoon function that calls sql statement for Ship
	public void ShipBTN(ActionEvent event)
	{
		SQL_Ship();
	}
	
	public void ClearBTN(ActionEvent event)
	{
		Nlist.clear();
		listView.setItems(null);// adding the normal list to observable list
		text.clear();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// must have function

	}

}
