package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.concurrent.atomic.AtomicLong;

import Dao.DBConnect;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

public class AdminViewAccounts {

	// Creating a TableView For the AdminView Tables
	@SuppressWarnings("rawtypes")
	private ObservableList<ObservableList> Recorddata;
	@SuppressWarnings("rawtypes")
	private TableView tableview;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void ViewAdminAccount(String sql) {
		tableview = new TableView();
		DBConnect admincon = new DBConnect();
		Recorddata = FXCollections.observableArrayList();
		try {
			Connection conn = admincon.getConnection();
	        String SQL = sql;
			ResultSet admindata = conn.createStatement().executeQuery(SQL);
			for (int i = 0; i < admindata.getMetaData().getColumnCount(); i++) {
				final int j = i;
				TableColumn col = new TableColumn(admindata.getMetaData().getColumnName(i + 1));
				col.setCellValueFactory(
						new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {

							public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
								return new SimpleStringProperty(param.getValue().get(j).toString());
							}

						});
				tableview.getColumns().add(col);
			}

			int adminrowid = 0;
			while (admindata.next()) {
				// Iterate Row
				ObservableList<String> row = FXCollections.observableArrayList();
				for (int i = 1; i <= admindata.getMetaData().getColumnCount(); i++) {
					// Iterate Column, grab data
					row.add(admindata.getString(i));
				}
				Recorddata.add(row);
			}
			tableview.setColumnResizePolicy((param) -> true);
			Platform.runLater(() -> ResizeTableView(tableview));
			tableview.setItems(Recorddata);
			Scene secondScene = new Scene(tableview, 600, 400);
			Stage secondStage = new Stage();
			secondStage.setTitle("Present DataRecord");
			secondStage.setScene(secondScene);
			secondStage.show();
			Main.stage.setOnCloseRequest((WindowEvent event1) -> {
				System.out.println("Main window closed");

			});

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error on Building Data");
		}
	}

	public void ResizeTableView(TableView<?> adminview) {

		AtomicLong wh = new AtomicLong();
		adminview.getColumns().forEach(col -> {
			wh.addAndGet((long) col.getWidth());
		});
		double tbwth= adminview.getWidth();

		if (tbwth > wh.get()) {
			adminview.getColumns().forEach(col -> {
				col.setPrefWidth(col.getWidth() + ((tbwth - wh.get()) / adminview.getColumns().size()));
			});
		}
	}
}