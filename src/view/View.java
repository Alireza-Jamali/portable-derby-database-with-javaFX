package view;

import database.DatabaseService;
import entity.TableContents;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class View extends Application {
    
    String temp;
    ArrayList<TableContents> tableList;
    DatabaseService dbb;
    private TableView<TableContents> table = new TableView<>();
    private final ObservableList<TableContents> data
            = FXCollections.observableArrayList(dataFetcher());

    Button resetBtn = new Button();
    int resetCounter = 3;
    
    private ArrayList<TableContents> dataFetcher() {

        tableList = new ArrayList<>();
        dbb = new DatabaseService();
        ResultSet rs = dbb.getRows();
        try {
            while (rs.next()) {

                tableList.add(new TableContents(rs.getString("DATE"), rs.getTime("ENTRY"), rs.getTime("EXIT"), rs.getInt("COFFEESHOP"), rs.getString("LEAVE")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tableList;
    }

    @Override
    public void start(Stage stage) {
        
        

        resetBtn.setText("Reset");
        
        table.setRowFactory(row -> new TableRow<TableContents>() {
            @Override
            public void updateItem(TableContents item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setStyle("");
                } else {
                    if (item.getDate().contains("p")) {
                        for (int i = 0; i < getChildren().size(); i++) {

                            ((Labeled) getChildren().get(i)).setTextFill(Color.web("#444F41"));
                            ((Labeled) getChildren().get(i)).setStyle("-fx-background-color: #85C073");
                        }
                    } else {
                      
                    }

                    if (item.getDate().contains("j")) {
                        for (int i = 0; i < getChildren().size(); i++) {

                            ((Labeled) getChildren().get(i)).setTextFill(Color.web("#FE5555"));
                            ((Labeled) getChildren().get(i)).setStyle("-fx-background-color: #FE5555");
                        }
                    } else {
                     
                    }

                }
            }
        });

        Scene scene = new Scene(new Group());
        stage.setTitle("محاسبه ساعات کاری");
        stage.setWidth(519);
        stage.setHeight(840);

        Label ezafValue = new Label();
        Label ezafLabel = new Label(":اضافه کار");

        Label takhirValue = new Label();
        Label takhirLabel = new Label(":کسری");

        Label coffeeValue = new Label();
        Label coffeeLabel = new Label(":کافی شاپ");

        Label effEzafValue = new Label();
        Label effEzafLabel = new Label(":اضافه کار موثر");
        
        Label leaveValue = new Label();
        Label leaveLabel = new Label(":مرخصی");

        table.setEditable(true);
        table.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        table.setMinHeight(785);
        table.setMaxWidth(320);

        EventHandler dateHandler = (EventHandler<CellEditEvent<TableContents, String>>) (CellEditEvent<TableContents, String> t) -> {
            ((TableContents) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDate(t.getNewValue());
        };
        EventHandler enrtyHandler = (EventHandler<CellEditEvent<TableContents, String>>) (CellEditEvent<TableContents, String> t) -> {
            ((TableContents) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEntry(t.getNewValue());
        };
        EventHandler exitHandler = (EventHandler<CellEditEvent<TableContents, String>>) (CellEditEvent<TableContents, String> t) -> {
            ((TableContents) t.getTableView().getItems().get(t.getTablePosition().getRow())).setExit(t.getNewValue());
        };

        EventHandler leaveHandler = (EventHandler<CellEditEvent<TableContents, String>>) (CellEditEvent<TableContents, String> t) -> {
            ((TableContents) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLeave(t.getNewValue());
        };
        EventHandler coffeeShopHandler = (EventHandler<CellEditEvent<TableContents, String>>) (CellEditEvent<TableContents, String> t) -> {
            ((TableContents) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCoffeeShop(t.getNewValue());
        };

        dbb.effEzaf = 0;
        dbb.ezaf = 0;
        dbb.kasri = 0;
        dbb.renderLabels();
        ezafValue.setText(dbb.ezafT);
        takhirValue.setText(dbb.kasriT);
        effEzafValue.setText(dbb.effEzafT);

        effEzafValue.setTranslateY(-865);
        effEzafValue.setTranslateX(350);

        effEzafLabel.setTranslateY(-888);
        effEzafLabel.setTranslateX(390);

        //----------------------------------------------تاریخ
        TableColumn dateColumn = new TableColumn("تاریخ");
        dateColumn.setSortable(false);
        dateColumn.setEditable(true);
        dateColumn.setMinWidth(45);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateColumn.setCellFactory(CenteredAlignedCallback.forTableColumnCenteredAligned());
        dateColumn.setOnEditCommit(dateHandler);
        

        EventHandler dateEh = event -> {
            if ("EDIT_START".equals(event.getEventType().toString())) {

                TableContents tc = table.getSelectionModel().getSelectedItem();
                temp = tc.getDate();
            }
            if ("EDIT_COMMIT".equals(event.getEventType().toString())) {

                TableContents tc = table.getSelectionModel().getSelectedItem();
                String tempDate = tc.getDate();
                dbb.insertDate(tempDate, temp);
                if(tempDate.contains("p")) {
                    dbb.insertExit(tempDate, "13:00:00");
                    tc.setExit("13:00");
                }else {
                    dbb.insertExit(tempDate, "17:00:00");
                    tc.setExit("17:00");
                }
                temp = tempDate;
            }
        };
        dateColumn.addEventHandler(EventType.ROOT, dateEh);

        //------------------------------------------کسری
        takhirValue.setTranslateY(-760);
        takhirValue.setTranslateX(350);

        takhirLabel.setTranslateY(-783);
        takhirLabel.setTranslateX(390);
        EventHandler entryEh = event -> {
            if ("EDIT_COMMIT".equals(event.getEventType().toString())) {
                dbb.effEzaf = 0;
                dbb.ezaf = 0;
                dbb.kasri = 0;
                TableContents tc = table.getSelectionModel().getSelectedItem();
                String date = tc.getDate();
                dbb.insertEntry(date, tc.getEntry());
               
                    dbb.renderLabels();
                

                ezafValue.setText(String.valueOf(dbb.ezafT));
                takhirValue.setText(String.valueOf(dbb.kasriT));
                effEzafValue.setText(String.valueOf(dbb.effEzafT));
            }
        };
        TableColumn entryColumn = new TableColumn("ورود");
        entryColumn.setEditable(true);
        entryColumn.setSortable(false);
        entryColumn.setMinWidth(65);
        entryColumn.setCellValueFactory(new PropertyValueFactory<>("entry"));
        entryColumn.setCellFactory(CenteredAlignedCallback.forTableColumnCenteredAligned());
        entryColumn.setOnEditCommit(enrtyHandler);
        entryColumn.addEventHandler(EventType.ROOT, entryEh);

        //--------------------------------------اضافه کار
        ezafValue.setTranslateY(-830);
        ezafValue.setTranslateX(350);

        ezafLabel.setTranslateY(-853);
        ezafLabel.setTranslateX(390);
        TableColumn exitColumn = new TableColumn("خروج");
        exitColumn.setEditable(true);
        exitColumn.setSortable(false);
        exitColumn.setMinWidth(65);
        exitColumn.setCellValueFactory(new PropertyValueFactory<>("exit"));
        exitColumn.setCellFactory(CenteredAlignedCallback.forTableColumnCenteredAligned());
        exitColumn.setOnEditCommit(exitHandler);
        EventHandler exitEh = event -> {
            dbb.effEzaf = 0;
            dbb.ezaf = 0;
            dbb.kasri = 0;
            if ("EDIT_COMMIT".equals(event.getEventType().toString())) {
                TableContents tc = table.getSelectionModel().getSelectedItem();
                String date = tc.getDate();
                dbb.insertExit(date, tc.getExit());
              
                    dbb.renderLabels();
                
                ezafValue.setText(dbb.ezafT);
                takhirValue.setText(dbb.kasriT);
                effEzafValue.setText(dbb.effEzafT);
            }
        };
        exitColumn.addEventHandler(EventType.ROOT, exitEh);

        //----------------------------------------------------------مرخصی
        leaveValue.setText(dbb.sumLeave());
        leaveValue.setTranslateY(-830);
        leaveValue.setTranslateX(350);

        leaveLabel.setTranslateY(-853);
        leaveLabel.setTranslateX(390);
        
        TableColumn leaveColumn = new TableColumn("مرخصی");
        leaveColumn.setEditable(true);
        leaveColumn.setSortable(false);
        leaveColumn.setMinWidth(65);
        leaveColumn.setCellValueFactory(new PropertyValueFactory<>("leave"));
        leaveColumn.setCellFactory(CenteredAlignedCallback.forTableColumnCenteredAligned());
        leaveColumn.setOnEditCommit(leaveHandler);
        EventHandler leaveEh = event -> {

            if ("EDIT_COMMIT".equals(event.getEventType().toString())) {
                TableContents tc = table.getSelectionModel().getSelectedItem();
                dbb.insertLeave(tc.getDate(), tc.getLeave());
                leaveValue.setText(String.valueOf(dbb.sumLeave()));
            }
        };
        leaveColumn.addEventHandler(EventType.ROOT, leaveEh);

        //-------------------------------------------------------------کافی شاپ
        coffeeValue.setText(dbb.sumCoffee());
        coffeeValue.setTranslateY(-760);
        coffeeValue.setTranslateX(348);

        coffeeLabel.setTranslateY(-783);
        coffeeLabel.setTranslateX(390);
        TableColumn coffeeColumn = new TableColumn("کافی شاپ");
        coffeeColumn.setEditable(true);
        coffeeColumn.setSortable(false);
        coffeeColumn.setMinWidth(75);
        coffeeColumn.setCellValueFactory(new PropertyValueFactory<>("coffeeShop"));
        coffeeColumn.setCellFactory(CenteredAlignedCallback.forTableColumnCenteredAligned());
        coffeeColumn.setOnEditCommit(coffeeShopHandler);
        EventHandler coffeeEh = event -> {

            if ("EDIT_COMMIT".equals(event.getEventType().toString())) {
                TableContents tc = table.getSelectionModel().getSelectedItem();
                dbb.insertCoffeeShop(tc.getDate(), Integer.parseInt(tc.getCoffeeShop()));
                coffeeValue.setText(dbb.sumCoffee());
            }
        };
        coffeeColumn.addEventHandler(EventType.ROOT, coffeeEh);
        //---------------------------------------------------------------------------------------------

        resetBtn.setTranslateY(-560);
        resetBtn.setTranslateX(390);
        resetBtn.setMinWidth(57);
        
        resetBtn.setOnAction(event -> {
            
            switch(resetCounter) {
            
                case -2 : 
                    stage.close();
                    resetCounter--;
                    break;
                case -1 : 
                    resetBtn.setText("Exit");
                    resetCounter--;
                    break;
                case 0 :    
                    resetBtn.setText("BOOM!");
                    dbb.reset();
                    resetCounter--;
                    break;
                default :
                    resetBtn.setText(String.valueOf(resetCounter--));
            }     
        });
        
        table.setItems(data);
        table.getColumns().addAll(dateColumn, entryColumn, exitColumn, coffeeColumn, leaveColumn);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));

        vbox.getChildren().addAll(table, resetBtn, takhirValue, takhirLabel, ezafValue, ezafLabel, coffeeValue, coffeeLabel, effEzafValue, effEzafLabel, leaveValue, leaveLabel);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();

//        stage.setOnCloseRequest(value -> {
//        
//            try {
//                dbb.cn.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        });

          
       

    }

    public static void main(String[] args) {

        launch(args);
    }
}
