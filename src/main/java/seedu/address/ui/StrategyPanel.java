package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
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
import seedu.address.model.task.Task;

public class StrategyPanel extends UiPart<Region> {
    private static final String FXML = "StrategyPanel.fxml";
    private static final Logger logger = LogsCenter.getLogger(MainApp.class);

    private static double orgSceneX;
    private static double orgSceneY;
    private static double orgCenterX;
    private static double orgCenterY;

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

        StackPane stack = new StackPane();
        for (String playerName : playerList) {
            initStack(stack, playerName, 100, 100, 50, Color.BLUE);
        }
        playerView.getChildren().addAll(stack);
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
