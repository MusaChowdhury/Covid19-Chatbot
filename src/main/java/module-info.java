module musachowdhury.chatbot {
    requires javafx.controls;
    requires javafx.fxml;


    opens musachowdhury.chatbot to javafx.fxml;
    exports musachowdhury.chatbot;
}