package festivalPlanner.gui.gui_views;

import festivalPlanner.gui.SceneHandler;
import festivalPlanner.gui.gui_controllers.ArtistViewController;
import festivalplanner_guiModules.buttons.FPButton;
import festivalplanner_guiModules.inputfields.FPInputFields;
import festivalplanner_guiModules.inputfields.FPTextField;
import festivalplanner_guiModules.inputfields.FPUsernameField;
import festivalplanner_guiModules.text.titles.DinamicTitle;
import festivalplanner_guiModules.text.titles.SubTitleBold;
import festivalplanner_guiModules.text.titles.TitleTextStyle;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import org.jfree.fx.FXGraphics2D;

import java.awt.*;

public class ArtistView extends StackPane {

    private SceneHandler sceneHandler;
    private MainView mainView;

    public ArtistView(SceneHandler sceneHandler){
        this.sceneHandler = sceneHandler;
        this.mainView = mainView;

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
                "-fx-background-radius: 30; "+
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

        DinamicTitle title = new DinamicTitle("Artist", 40);

        title.setLayoutX(-300);
        title.setLayoutY(-200);
        title.setTranslateX(-300);
        title.setTranslateY(-200);
        stackPane.getChildren().add(title);

        DinamicTitle addArtist = new DinamicTitle("Add Artist", 20);

        addArtist.setLayoutX(-303);
        addArtist.setLayoutY(-130);
        addArtist.setTranslateX(-303);
        addArtist.setTranslateY(-130);
        stackPane.getChildren().add(addArtist);

        DinamicTitle  artistName= new DinamicTitle("Artist Name", 17);

        artistName.setLayoutX(-303);
        artistName.setLayoutY(-70);
        artistName.setTranslateX(-303);
        artistName.setTranslateY(-70);
        stackPane.getChildren().add(artistName);

        DinamicTitle  artistAge = new DinamicTitle("Age", 17);

        artistAge.setLayoutX(-303);
        artistAge.setLayoutY(-10);
        artistAge.setTranslateX(-303);
        artistAge.setTranslateY(-10);
        stackPane.getChildren().add(artistAge);

        DinamicTitle artistGenre = new DinamicTitle("Genre", 17);

        artistGenre.setLayoutX(-303);
        artistGenre.setLayoutY(50);
        artistGenre.setTranslateX(-303);
        artistGenre.setTranslateY(50);
        stackPane.getChildren().add(artistGenre);

        DinamicTitle profileImage = new DinamicTitle("Profile Image", 17);

        profileImage.setLayoutX(-303);
        profileImage.setLayoutY(110);
        profileImage.setTranslateX(-303);
        profileImage.setTranslateY(110);
        stackPane.getChildren().add(profileImage);

        DinamicTitle description = new DinamicTitle("Description", 17);

        description.setLayoutX(-303);
        description.setLayoutY(180);
        description.setTranslateX(-303);
        description.setTranslateY(180);
        stackPane.getChildren().add(description);

        FPTextField name = new FPTextField("Artist Name");

        name.setLayoutX(-153);
        name.setLayoutY(-70);
        name.setTranslateX(-153);
        name.setTranslateY(-70);
        stackPane.getChildren().add(name);

        FPTextField age = new FPTextField("Age");

        age.setLayoutX(-153);
        age.setLayoutY(-10);
        age.setTranslateX(-153);
        age.setTranslateY(-10);
        stackPane.getChildren().add(age);

        FPTextField genre = new FPTextField("Genre");

        genre.setLayoutX(-153);
        genre.setLayoutY(50);
        genre.setTranslateX(-153);
        genre.setTranslateY(50);
        stackPane.getChildren().add(genre);

        FPButton open = new FPButton("Open", 100, 48);

        open.setLayoutX(-153);
        open.setLayoutY(110);
        open.setTranslateX(-153);
        open.setTranslateY(110);
        stackPane.getChildren().add(open);




        return stackPane;
    }

//    public void draw(FXGraphics2D graphics){
//
//        FXGraphics2D graphics = new FXGraphics2D();
//        graphics.setColor(Color.black);
//        graphics.fillRect(0, 0, 700, 5);
//
//        draw(graphics);
//
//
//    }
}
