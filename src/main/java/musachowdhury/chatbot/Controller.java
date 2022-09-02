package musachowdhury.chatbot;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private static boolean chat = false;
    private static boolean chat_once = true;
    private static boolean news = false;
    private static final WebView tmp = new WebView();
    private static final WebHistory history = tmp.getEngine().getHistory();
    private static final ObservableList<WebHistory.Entry> entries = history.getEntries();
    @FXML
    BorderPane main_hook;
    @FXML
    TextField input;
    @FXML
    ListView list;
    @FXML
    Button send;
    @FXML
    Button back;
    @FXML
    Button front;
    @FXML
    Button reload;

    public Controller() {

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void show(ActionEvent e) throws IOException, InterruptedException {
        news = false;
        if (!chat) {
            ChatLabel.reset();
            BorderPane tmp = FXMLLoader.load(this.getClass().getResource("/ui/ui_2.fxml"));
            ListView push = (ListView) tmp.getCenter();
            push.getItems().add((new ChatLabel("Hey I am Chatty!\nLet's begin with some questions!")).getLabel());
            ChatLabel.reset();
            this.main_hook.setCenter(tmp);
            chat = true;
            chat_once = true;
        }

    }

    public void input(ActionEvent e) {
        this.input();
    }

    public void input() {
        if (!chat_once) {
            String hold = this.input.getText().trim().replaceAll(" +", " ");
            if (hold.length() != 0) {
                HBox tmp = (new ChatLabel(hold)).getLabel();
                this.list.getItems().add(tmp);
                this.list.scrollTo(tmp);
                this.list.getItems().add((new ChatLabel((Reply.getAns(hold))).getLabel()));


            }

            this.input.clear();
        }

    }

    public void clear(MouseEvent e) {
        if (chat_once) {
            this.input.clear();
            chat_once = false;
            this.list.getItems().add((new ChatLabel("Seems like you are about to type!\nGo ahead I am waiting . . . \n\n" +
                    "Ask me questions like,\n\n" +
                    "Death rate or Recovered people number\n\n" +
                    "Or Safety Information or About Vaccine\n\n")).getLabel());

        }

    }

    public void news(ActionEvent e) {
        chat = false;
        try {
            URL ck = new URL("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/media-resources/news");
            if (!news) {
                (ck.openConnection()).connect();
                BorderPane hold = FXMLLoader.load(this.getClass().getResource("/ui/ui_3.fxml"));
                tmp.getEngine().load("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/media-resources/news");
                tmp.setZoom(0.75D);
                hold.setCenter(tmp);
                this.main_hook.setCenter(hold);
                news = true;
            }
        } catch (Exception no) {
            main_hook.setCenter(new Label("No Internet Connection"));
            main_hook.getCenter().setStyle("-fx-font: 50px \"Arial\"; -fx-text-fill: white;");
            news = true;
        }

    }

    public void back(ActionEvent e) {
        System.out.println(history.getCurrentIndex());
        if (history.getCurrentIndex() >= 1) {
            history.go(-1);
        }

    }

    public void front(ActionEvent e) {
        if (history.getCurrentIndex() < entries.size() - 1) {
            history.go(1);
        }
    }

    public void reload(ActionEvent e) {
        tmp.getEngine().load("https://www.who.int/emergencies/diseases/novel-coronavirus-2019/media-resources/news");
    }

    public void about(ActionEvent e) throws IOException {
        news = false;
        chat = false;
        Label temp= new Label("Developed by Musa Chowdhury");
        temp.setStyle("-fx-font: bold 20px \"Arial\";");
        main_hook.setCenter(temp);

    }


}





