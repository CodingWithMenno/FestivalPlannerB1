package festivalPlanner.gui.gui_views;

import festivalPlanner.data_system.Data;
import festivalPlanner.data_system.Stage;
import festivalPlanner.gui.SceneHandler;
import festivalPlanner.gui.gui_controllers.StageViewController;
import festivalplanner_guiModules.buttons.showButton;
import festivalplanner_guiModules.inputfields.*;
import festivalplanner_guiModules.text.titles.DynamicTitle;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.sql.SQLException;

/**
 * This class opens a new window where you can add new stages.
 */

public class StageView extends StackPane {

    private SceneHandler sceneHandler;
    private EventView eventView;
    private Data data;
    public StageViewController controller;


    public StageView(SceneHandler sceneHandler, EventView eventView, Data data){
        this.sceneHandler = sceneHandler;
        this.eventView = eventView;
        this.data = data;
        this.controller = new StageViewController(data);
        this.controller.setPlaces();

        setWidth(1280);
        setHeight(800);
        setStyle("-fx-background-color: #35477D;");
        getChildren().add(createStackPane());
    }

    public StackPane createStackPane() {

        StackPane stackPane = new StackPane(); //deze stackpane kun je in bouwen
        stackPane.setMinSize(800, 570);
        stackPane.setMaxSize(800, 570);

        stackPane.setStyle("-fx-background-color: #FFFFFF;" +
                "-fx-background-radius: 30; " +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 20, 0.0 , 2 , 2 );"
        );

        Button BackButton = new showButton("X", 30, 30);
        stackPane.getChildren().add(BackButton);
        BackButton.setOnAction(event -> {
            try {
                this.sceneHandler.toMainView();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        BackButton.setLayoutX(370);
        BackButton.setLayoutY(-255);
        BackButton.setTranslateX(370);
        BackButton.setTranslateY(-255);

        DynamicTitle title = new DynamicTitle("Stage", 40);
        place(title,-300,-220);

        DynamicTitle secondTitle = new DynamicTitle("Add Stage", 21);
        place(secondTitle,-300,-150);

        DynamicTitle thirdTitle = new DynamicTitle("All Stages", 21);
        place(thirdTitle,110,-150);

        DynamicTitle stageName = new DynamicTitle("Stage Name", 17);
        place(stageName,-301,-90);

        DynamicTitle Capacity = new DynamicTitle("Capacity",17);
        place(Capacity,-316,-30);

        DynamicTitle indoor = new DynamicTitle("Indoor", 17);
        place(indoor,-323,30);

        DynamicTitle Placement = new DynamicTitle("Placement", 17);
        place(Placement,-308,90);

        DynamicTitle firstAidKits = new DynamicTitle("First Aid Kits", 17);
        place(firstAidKits,-300,155);

        //Fields

        TextField stageNameField = new FPTextField("Stage Name");
        place(stageNameField, -120, -90);

        TextField CapacityField = new FPTextField("Amount", 80, 40);
        place(CapacityField, -153, -30);

        CheckBox indoorField = new FPCheckBox();
        place(indoorField, -153, 30);

        FPComboBoxString placementField = new FPComboBoxString("Place");
        place(placementField, -121, 90);
        placementField.setItems(this.controller.getPlaces());

        TextField firstAidKitsField = new FPTextField("Amount", 80, 40);
        place(firstAidKitsField, -153, 155);

        showButton addStage = new showButton("Save ", 90, 35);
        place(addStage, -28, 230);

        showButton clearButton = new showButton("Clear All ", 90, 35);
        place(clearButton, -148, 230);

        showButton removeStage = new showButton("Remove ", 90, 35);
        place(removeStage, 310, 230);

        ListView<Stage> listViewStages = new ListView<>();
        listViewStages.setStyle("-fx-background-color: #FFFFFF; " +
                "-fx-text-fill: #B76F88; " +
                "-fx-font-size: 15; " +
                "-fx-font-family: Helvetica; ");

        listViewStages.setItems(data.getStages());
        place(listViewStages,200,45);
        listViewStages.setMinSize(200,320);
        listViewStages.setMaxSize(200,320);

        showButton show = new showButton("Show", 90, 35);
        place(show, 190, 230);

        stackPane.getChildren().addAll(title, secondTitle, thirdTitle, show, stageName, Capacity, indoor, Placement, firstAidKits, stageNameField, listViewStages, CapacityField, indoorField, placementField, firstAidKitsField, addStage , clearButton, removeStage, makeLine(), makeLine2());


        removeStage.setOnAction(event -> {
            data.removeStage(listViewStages.getSelectionModel().getSelectedItem());
        });


        /**
         * this part checks for doubles or and adds a stage.
         */
        addStage.setOnAction(event -> {

            int capacityAmount = 0;
            int firstAidKitsAmount = 0;

            try {
                capacityAmount = Integer.parseInt(CapacityField.getText());
                firstAidKitsAmount = Integer.parseInt(firstAidKitsField.getText());

                Stage stage = new Stage(stageNameField.getText(),
                        capacityAmount,
                        indoorField.isSelected(),
                        placementField.getSelectionModel().getSelectedItem(),
                        firstAidKitsAmount);


                if (data.getStages().size() != 0) {
                    int alreadyExist = 0;
                    int place = 0;
                    for (int i = 0; i < data.getStages().size(); i++) {
                        if (data.getStages().get(i).getName().equals(stage.getName())) {
                            alreadyExist = 1;
                            place = i;
                        }
                    }

                    if (alreadyExist == 1) {

                        Alert dialog = new Alert(Alert.AlertType.WARNING,"You are about to overwrite the info of "+ stageNameField.getText()+",\n are you sure about that?");
                        dialog.setTitle("Overwriting stage");
                        dialog.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
                        int finalPlace = place;
                        int finalPlace1 = place;
                        dialog.showAndWait().ifPresent(buttonType -> {
                            if (buttonType == ButtonType.YES) {

                                data.getStages().get(finalPlace1).setName(stage.getName());
                                data.getStages().get(finalPlace1).setCapacity(stage.getCapacity());
//                                data.getStages().get(finalPlace1).setPlacement(stage.getPlacement());
                                data.getStages().get(finalPlace1).setFirstAidKits(stage.getFirstAidKits());
                                data.getStages().get(finalPlace1).setIndoor(stage.isIndoor());
                                data.getStages().get(finalPlace1).setSurface(stage.getSurface());

                            }
                            data.updateFileIO();
                        });

                    } else if(placementField.getSelectionModel().getSelectedItem() == null){
                        placementField.invalidInputStyle();
                    } else {
                        this.data.addToStages(stage);
                        placementField.defaultStyle();
                        this.controller.setPlaces();
                    }
                } else {
                    this.data.addToStages(stage);
                    placementField.defaultStyle();
                    this.controller.setPlaces();
                }

                stageNameField.setText("");
                CapacityField.setText("");
                indoorField.setSelected(false);
                firstAidKitsField.setText("");

            } catch (Exception e) {
                CapacityField.setText("Error");
                firstAidKitsField.setText("Error");
            }

        });

        clearButton.setOnAction(event -> {
            stageNameField.setText("");
            CapacityField.setText("");
            indoorField.setSelected(false);
            firstAidKitsField.setText("");
        });

        removeStage.setOnAction(event -> {

            data.removeStage(listViewStages.getSelectionModel().getSelectedItem());
            this.controller.setPlaces();

        });

        show.setOnAction(event -> {

            Stage selected = listViewStages.getSelectionModel().getSelectedItem();

            stageNameField.setText(selected.getName());
            CapacityField.setText(String.valueOf(selected.getCapacity()));
            indoorField.setSelected(selected.isIndoor());
            firstAidKitsField.setText(String.valueOf(selected.getFirstAidKits()));


        });



        return stackPane;
    }

    private void place(Node node, int x, int y) {
        node.setLayoutX(x);
        node.setLayoutY(y);
        node.setTranslateX(x);
        node.setTranslateY(y);
    }

    public HBox makeLine() {

        HBox hBox = new HBox();
        hBox.setMinSize(700, 2);
        hBox.setMaxSize(700, 2);
        place(hBox, 0, -170);
        hBox.setStyle("-fx-background-color: #EEEEEE;");

        return hBox;
    }

    public HBox makeLine2() {

        HBox hBox = new HBox();
        hBox.setMinSize(2, 400);
        hBox.setMaxSize(2, 400);
        place(hBox, 40, 50);
        hBox.setStyle("-fx-background-color: #EEEEEE;");

        return hBox;
    }
}
