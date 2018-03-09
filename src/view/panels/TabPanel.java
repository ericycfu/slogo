package view.panels;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;


public class TabPanel {

    private HBox tabs;
    private TabPane tabPane;
    private Tab addTab;
    private Controller CONTROLLER;
    private int counter;

    public TabPanel(Controller c) {
	counter = 0;
	tabPane = new TabPane();
	CONTROLLER = c;
	tabConstructor();
	makeAddTab();
	tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
	    @Override
	    public void changed(ObservableValue<? extends Tab> arg0, Tab oldTab, Tab newTab) {
		int index = tabPane.getTabs().indexOf(newTab);
		if(index == counter -1) return;
		CONTROLLER.switchContext(index);
	    }
	});
    }

    public TabPane construct() {
	tabs = new HBox(tabPane);
	tabs.setPadding(new Insets(0,0,0,0));
	return tabPane;
    }

    public Tab tabConstructor() {
	Tab tab = constructTab();
	counter++;
	tabPane.getTabs().add(tab);
	return tab;
    }

    private Tab constructTab() {
	HBox temp = new HBox();
	Tab tab = new Tab();
	tab.setGraphic(new Circle(0, 0, 10));
	temp.setAlignment(Pos.CENTER);
	tab.setContent(temp);
	return tab;
    }

    private void makeAddTab() {
	addTab = tabConstructor();
	addTab.setText("+");
	addTab.setOnSelectionChanged(new EventHandler<Event>() {
	    @Override
	    public void handle(Event t) {
		if (addTab.isSelected()) {
		    tabConstructor();
		    Tab currTab = tabPane.getTabs().get(tabPane.getTabs().size() -1);
		    tabPane.getSelectionModel().select(currTab);
		    CONTROLLER.addContext();
		    tabPane.getTabs().remove(addTab);
		    tabPane.getTabs().add(addTab);
		}
	    }
	    });
    }
}