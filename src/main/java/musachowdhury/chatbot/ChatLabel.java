package musachowdhury.chatbot;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;

class ChatLabel {
    private static int cnt = 0;
    private static final String style = "-fx-background-radius: 10px;-fx-background-color: black;-fx-text-fill : #ffffff;-fx-label-padding: 15px 10px 10px 10px ;-fx-font: bold italic 12px \"Arial\";";
    private final HBox hold;
    private final Label msg;

    ChatLabel(String s) {
        Image bot = new Image(getClass().getResourceAsStream("/icon/bot.png"));
        ImageView logo = new ImageView(bot);
        Image user = new Image(getClass().getResourceAsStream("/icon/you.png"));
        ImageView you = new ImageView(user);
        this.hold = new HBox();
        this.msg = new Label(s);
        logo.setFitHeight(50.0D);
        logo.setFitWidth(50.0D);
        you.setFitHeight(50.0D);
        you.setFitWidth(50.0D);
        this.hold.setStyle("fx-background-color : transparent;");
        this.hold.setPadding(new Insets(10.0D, 10.0D, 10.0D, 10.0D));
        this.msg.setWrapText(true);
        this.msg.setTextAlignment(TextAlignment.JUSTIFY);
        this.msg.setMaxWidth(230.0D);
        this.msg.setStyle(style);
        if (cnt % 2 == 0) {
            this.hold.setAlignment(Pos.CENTER_LEFT);
            this.hold.getChildren().add(logo);
            this.hold.getChildren().add(this.msg);
        } else {
            this.hold.setAlignment(Pos.CENTER_RIGHT);
            this.hold.getChildren().add(this.msg);
            this.hold.getChildren().add(you);
        }

        ++cnt;
    }

    public static void reset() {
        cnt = 0;
    }

    public HBox getLabel() {
        return this.hold;
    }
}








