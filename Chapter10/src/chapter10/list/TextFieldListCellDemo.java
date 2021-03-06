/* 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 */
package chapter10.list;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

/**
 *
 * @author sgrinev
 */
public class TextFieldListCellDemo extends Application {

    @Override
    public void start(Stage stage) {
        ObservableList<Integer> items = FXCollections.observableArrayList(
                100, 200, 500, 1000);
        
        ListView<Integer> list = new ListView<>(items);
        list.setEditable(true);
        list.setCellFactory(TextFieldListCell.forListView(new IntegerStringConverter()));
        
        items.addListener((ListChangeListener.Change<? extends Integer> change) -> {
            System.out.println(change);
        });
        
        stage.setTitle("TextFieldListCell Demo");
        stage.setScene(new Scene(new StackPane(list), 200, 200));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
