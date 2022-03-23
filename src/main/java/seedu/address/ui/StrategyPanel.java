package seedu.address.ui;

import java.io.File;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import seedu.address.MainApp;
import seedu.address.commons.core.LogsCenter;

public class StrategyPanel extends UiPart<Region> {
    private static final String FXML = "StrategyPanel.fxml";
    private static final Logger logger = LogsCenter.getLogger(MainApp.class);
    private static final Map<String, StackPane> table = new HashMap<>();

    private static double orgSceneX;
    private static double orgSceneY;
    private static double orgCenterX;
    private static double orgCenterY;

    @FXML
    private ImageView strategyImage;
    @FXML
    private AnchorPane strategyAnchorPane;
    @FXML
    private Pane playerView;

    // Credit to http://java-buddy.blogspot.com/2013/07/move-node-to-front.html
    private final EventHandler<MouseEvent> pressHandler =
            new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgCenterX = ((StackPane) (t.getSource())).getLayoutX();
                orgCenterY = ((StackPane) (t.getSource())).getLayoutY();
                //logger.log(Level.INFO, "orgCenterX: {0}", new Object[]{orgCenterX});
                //logger.log(Level.INFO, "orgCenterY: {0}", new Object[]{orgCenterY});
            }
    };

    // Credit to http://java-buddy.blogspot.com/2013/07/move-node-to-front.html
    private final EventHandler<MouseEvent> dragHandler =
            new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newCenterX = orgCenterX + offsetX;
                double newCenterY = orgCenterY + offsetY;
                StackPane tmp = (StackPane) (t.getSource());
                tmp.setLayoutX(newCenterX);
                tmp.setLayoutY(newCenterY);
                //logger.log(Level.INFO, "newCenterX: {0} new CenterY: {1}",
                //        new Object[]{offsetX + orgCenterX, offsetY + orgCenterY});
                //logger.log(Level.INFO, "newTrueX: {0} new TrueY: {1}",
                //        new Object[]{tmp.getCenterX(), tmp.getCenterY()});
            }
    };

    /**
     * Creates a {@code StrategyPanel} with draggable circles.
     */
    public StrategyPanel(ObservableList<String> playerList) {
        super(FXML);
        strategyImage.fitWidthProperty().bind(strategyAnchorPane.widthProperty());
        strategyImage.fitHeightProperty().bind(strategyAnchorPane.heightProperty());
        strategyImage.toBack();

        playerList.addListener((ListChangeListener<String>) change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    changeOnAdd(change.getAddedSubList());
                } else if (change.wasRemoved()) {
                    changeOnDelete(change.getRemoved());
                }
            }
        });
    }

    private void changeOnAdd(List<? extends String> addedSubList) {
        for (String playerName : addedSubList) {
            if (table.containsKey(playerName)) {
                continue;
            }
            StackPane stack = new StackPane();
            initStack(stack, playerName, 100, 100, 50, Color.BLUE);
            playerView.getChildren().add(stack);
            table.put(playerName, stack);
        }
    }

    private void changeOnDelete(List<? extends String> removeList) {
        for (String playerName : removeList) {
            if (table.containsKey(playerName)) {
                playerView.getChildren().remove(table.get(playerName));
                table.remove(playerName);
            }
        }
    }

    /**
     * Changes the image contained in ImageView.
     * @param file the file reference for the image to be loaded
     */
    public void changeImageBackground(File file) {
        strategyImage.setImage((new Image((file.toURI().toString()))));
    }

    private void initCircle(Circle circle, double rad, double x, double y, Paint color) {
        circle.setRadius(rad);
        circle.setFill(color);
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle.setCursor(Cursor.HAND);
    }

    private void initText(Text text, String value, double x, double y) {
        text.setX(x);
        text.setY(y);
        text.setText(value);
        text.setFont(Font.font("Arial", 24));
        double width = text.prefWidth(-1);
        text.setX(250 - width / 2);
        text.setTextOrigin(VPos.CENTER);
    }

    private void initStack(StackPane stack, String name, double x, double y, double rad, Paint color) {
        Text text = new Text();
        initText(text, name, x, y);
        Circle cr = new Circle();
        initCircle(cr, rad, x, y, color);
        text.xProperty().bind(cr.centerXProperty());
        text.yProperty().bind(cr.centerYProperty());
        stack.getChildren().addAll(cr, text);
        stack.setOnMousePressed(pressHandler);
        stack.setOnMouseDragged(dragHandler);
    }
}
