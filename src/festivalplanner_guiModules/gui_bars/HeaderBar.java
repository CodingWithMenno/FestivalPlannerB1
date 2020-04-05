package festivalplanner_guiModules.gui_bars;

import festivalplanner_guiModules.text.titles.SubTitleStyle;
import festivalplanner_guiModules.text.titles.TitleTextStyle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class HeaderBar extends HBox {

    /**
     * This extension to the JavaFX HBox is used to create a custom, fixed header bar for the application.
     * The String parameter is the festival name that appears on the top left of the application.
     * The festival name changes depending on the currently logged in user.
     * @param festivalName
     */
    public HeaderBar(String festivalName) {

        setMinSize(1280, 40);
        setPrefSize(1280, 40);
        setMaxSize(1280, 40);

        setStyle("-fx-background-color: #EEEEEE;");

        getChildren().addAll(logoAndDivision(), festivalName(festivalName));

        setAlignment(Pos.CENTER_LEFT);

        setPadding(new Insets(0, 0, 0, 30));
    }

    private Node logoAndDivision() {

        return new TitleTextStyle("FP | ");

    }

    public Node festivalName(String festivalName) {

        return new SubTitleStyle(festivalName);
    }

}
