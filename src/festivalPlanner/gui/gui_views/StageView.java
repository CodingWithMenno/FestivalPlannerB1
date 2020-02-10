package festivalPlanner.gui.gui_views;

import festivalPlanner.data_system.Artist;
import festivalPlanner.data_system.Stage;
import festivalPlanner.gui.SceneHandler;
import festivalPlanner.gui.gui_controllers.StageViewController;
import festivalplanner_guiModules.buttons.FPButton;
import festivalplanner_guiModules.inputfields.*;
import festivalplanner_guiModules.text.titles.DinamicTitle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class StageView extends StackPane{

    private SceneHandler sceneHandler;
    private MainView mainView;
    private ObservableList<Stage> stages = FXCollections.observableArrayList();
    private EventView eventView;

    public StageView(SceneHandler sceneHandler, EventView eventView){
        this.sceneHandler = sceneHandler;
        this.mainView = mainView;
        this.eventView = eventView;

        setWidth(1280);
        setHeight(800);
        setStyle("-fx-background-color: #35477D;" );
        getChildren().add(createStackPane());
    }

    public StackPane createStackPane(){

        StackPane stackPane = new StackPane(); //deze stackpane kun je in bouwen
        stackPane.setMinSize(800,570);
        stackPane.setMaxSize(800,570);

        stackPane.setStyle("-fx-background-color: #FFFFFF;" +
                "-fx-background-radius: 30; " +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 20, 0.0 , 2 , 2 );"
        );

        Button BackButton = new FPButton("X",30,30);
        stackPane.getChildren().add(BackButton);
        BackButton.setOnAction(event -> {
            this.sceneHandler.toMainView();
        });

        BackButton.setLayoutX(370);
        BackButton.setLayoutY(-255);
        BackButton.setTranslateX(370);
        BackButton.setTranslateY(-255);

        DinamicTitle title = new DinamicTitle("Stage", 40);
        place(title,-300,-220);

        DinamicTitle secondTitle = new DinamicTitle("Add Stage", 21);
        place(secondTitle,-300,-150);

        DinamicTitle thirdTitle = new DinamicTitle("All Stages", 21);
        place(thirdTitle,110,-150);

        DinamicTitle stageName = new DinamicTitle("Stage Name", 17);
        place(stageName,-300,-90);

        DinamicTitle Capacity = new DinamicTitle("Capacity",17);
        place(Capacity,-300,-30);

        DinamicTitle indoor = new DinamicTitle("Indoor", 17);
        place(indoor,-300,30);

        DinamicTitle emergencyExits = new DinamicTitle("Emergency Exits", 17);
        place(emergencyExits,-300,90);

        DinamicTitle firstAidKits = new DinamicTitle("First Aid Kits", 17);
        place(firstAidKits,-300,155);

        //Fields

        TextField stageNameField = new FPTextField("Stage Name");
        place(stageNameField,-153,-90);

        TextField CapacityField = new FPTextField("Amount",80,40);
        place(CapacityField,-153,-30);

        CheckBox indoorField = new FPCheckBox("Indoor");
        place(indoorField,-153,30);

        TextField emergencyExitsField = new FPTextField("Amount",80,40);
        place(emergencyExitsField,-153,90);

        TextField firstAidKitsField = new FPTextField("Amount",80,40);
        place(firstAidKitsField,-153,155);

        FPButton addStage = new FPButton("Add ", 90, 35);
        place(addStage,-50,230);

        FPButton clearButton = new FPButton("Clear All ", 90, 35);
        place(clearButton,-170,230);

        FPButton removeStage = new FPButton("Remove ", 90, 35);
        place(removeStage,310,230);

        ListView<Stage> listViewStages = new ListView<>();
        listViewStages.setItems(this.stages);
        place(listViewStages,100,0);
        listViewStages.setMinSize(200,400);
        listViewStages.setMaxSize(200,400);

        FPButton show = new FPButton("Show", 90, 35);
        place(show, 190, 230);

        stackPane.getChildren().addAll(title,secondTitle,thirdTitle,show, stageName,Capacity,indoor,emergencyExits,firstAidKits,stageNameField,listViewStages,CapacityField,indoorField,emergencyExitsField,firstAidKitsField,addStage,clearButton,removeStage,makeLine(),makeLine2());



        addStage.setOnAction(event -> {

            int capacityAmount = 0;
            int emergencyExitsAmount =0;
            int firstAidKitsAmount =0;

            try {
                capacityAmount = Integer.parseInt(CapacityField.getText());
                emergencyExitsAmount = Integer.parseInt(emergencyExitsField.getText());
                firstAidKitsAmount = Integer.parseInt(firstAidKitsField.getText());

                Stage stage = new Stage(stageNameField.getText(),
                        capacityAmount,
                        indoorField.isSelected(),
                        emergencyExitsAmount,
                        firstAidKitsAmount);

                int alreadyExist = 0;
                int place = 0;

                if (stages.size() != 0) {

                    for (int i = 0; i < stages.size() - 1; i++) {
                        if (stages.get(i).getName().equals(stage.getName())) {
                            alreadyExist = 1;
                            place = i;

                        }

                    }

                    if (alreadyExist == 1) {

                        System.out.println("jaman");

                        stages.get(place).setName(stage.getName());
                        stages.get(place).setCapacity(stage.getCapacity());
                        stages.get(place).setEmergencyExits(stage.getEmergencyExits());
                        stages.get(place).setFirstAidKits(stage.getFirstAidKits());
                        stages.get(place).setIndoor(stage.isIndoor());
                        stages.get(place).setSurface(stage.getSurface());


                    } else {
//                        this.eventView.addStageToList(stage);
                        this.stages.add(stage);
                    }
                } else {
//                    this.eventView.addStageToList(stage);
                    this.stages.add(stage);
                }

//                this.stages.add(stage);

                    stageNameField.setText("");
                    CapacityField.setText("");
                    indoorField.setSelected(false);
                    emergencyExitsField.setText("");
                    firstAidKitsField.setText("");


            }
            catch(Exception e) {
                CapacityField.setText("Error");
                emergencyExitsField.setText("Error");
                firstAidKitsField.setText("Error");
            }



        });

        clearButton.setOnAction(event -> {
            stageNameField.setText("");
            CapacityField.setText("");
            indoorField.setSelected(false);
            emergencyExitsField.setText("");
            firstAidKitsField.setText("");

        });

        removeStage.setOnAction(event -> {

            stages.remove(listViewStages.getSelectionModel().getSelectedItem());


        });

        show.setOnAction(event -> {

            Stage selected = listViewStages.getSelectionModel().getSelectedItem();

            stageNameField.setText(selected.getName());
            CapacityField.setText(String.valueOf(selected.getCapacity()));
            indoorField.setSelected(selected.isIndoor());
            emergencyExitsField.setText(String.valueOf(selected.getEmergencyExits()));
            firstAidKitsField.setText(String.valueOf(selected.getFirstAidKits()));


                });

        //Under this comment only : Functionality

//        addButton.setOnAction(event -> {
//
//            this.eventView.addStageToList(new Stage(nameField.getText(),Integer.parseInt(capacityField.getText()),Integer.parseInt(surfaceField.getText()),indoorButton.isSelected(),Integer.parseInt(emergencyText.getText()),Integer.parseInt(firstAidText.getText())));

//            try {
//
//                String name = stageName.getText();
//                int capacity = Integer.parseInt(capacityField.getText());
//                int surface = Integer.parseInt(surfaceField.getText());
//                boolean isIndoor = indoorButton.isSelected();
//                int emergencyExit = Integer.parseInt(emergencyText.getText());
//                int firstAid = Integer.parseInt(firstAidText.getText());
//
//                this.stages.add(new Stage(name, capacity, surface, isIndoor, emergencyExit, firstAid));
//                System.out.println(this.stages);
//
//            } catch (NumberFormatException | NullPointerException e) {
//                e.printStackTrace();
//            }
//        });

        return stackPane;
    }

    private void place(Node node,int x, int y) {
        node.setLayoutX(x);
        node.setLayoutY(y);
        node.setTranslateX(x);
        node.setTranslateY(y);
    }

    public HBox makeLine(){

        HBox hBox = new HBox();
        hBox.setMinSize(700, 2);
        hBox.setMaxSize(700, 2);
        place(hBox,0,-170);
        hBox.setStyle("-fx-background-color: #EEEEEE;");

        return hBox;
    }

    public HBox makeLine2(){

        HBox hBox = new HBox();
        hBox.setMinSize(2, 400);
        hBox.setMaxSize(2, 400);
        place(hBox,40,50);
        hBox.setStyle("-fx-background-color: #EEEEEE;");

        return hBox;
    }
}
