import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import java.time.*; // Methods to get system time

public class ClockFX extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("UMB JavaFX Clock");
    ZonedDateTime zdt = ZonedDateTime.now();
    System.out.println(zdt);
    String zoneLabel = String.format("Date and Time for  %s is         \n", zdt.getZone());
    Label lbl1 = new Label(zoneLabel);
    lbl1.setFont(Font.font("Arial", 17));
    lbl1.setStyle("-fx-background-color: yellow");
    //btn.setOnAction( (event) -> Platform.exit() );


    zdt = ZonedDateTime.now();
    String str2 = "Starting Clock now ..."; //String.format("%s %d, %d at %02d:%02d:%02d              ", zdt.getMonth(),
      //zdt.getDayOfMonth(), zdt.getYear(), zdt.getHour(), zdt.getMinute(), zdt.getSecond());
    Label lbl2 = new Label(str2);
    lbl2.setFont(Font.font("Arial", 24));
    lbl2.setStyle("-fx-background-color: cyan");

    GridPane root=new GridPane();
    root.addRow(0, lbl1);
    root.addRow(1, lbl2);
    primaryStage.setScene(new Scene(root, 320, 50));
    primaryStage.show();

    //This Timeline is set to run every second
    Timeline oneSecondsLoop = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent e) -> {
      final ZonedDateTime fzdt = ZonedDateTime.now();
      final String s2 = String.format("%s %d, %d at %02d:%02d:%02d        ", fzdt.getMonth(),
        fzdt.getDayOfMonth(), fzdt.getYear(), fzdt.getHour(), fzdt.getMinute(), fzdt.getSecond());
      lbl2.setText(s2);
      System.out.println(fzdt);
    }));
    oneSecondsLoop.setCycleCount(Timeline.INDEFINITE);//Set to run Timeline forever
    oneSecondsLoop.play();
  }
}