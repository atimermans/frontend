package com.example;

import com.vaadin.annotations.Theme;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class DefaultView extends VerticalLayout implements View {

    // ToDo: Revisar el funcionamiento de @Autowired (Por que funciona en UI pero no en View)
    @Autowired
    TodoList todoList;

    public DefaultView() {
        setSizeFull();

        Label header = new Label("TAP: TODO");
        header.addStyleName(ValoTheme.LABEL_H1);
        addComponent(header);

        addForm();
        addTodoList();
        addActionButtons();
    }


    private void addForm() {
        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setWidth("100%");

        TextField taskField = new TextField();
        taskField.focus();
        Button addButton = new Button("");

        formLayout.addComponentsAndExpand(taskField);
        formLayout.addComponent(addButton);
        addComponent(formLayout);

        addButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        addButton.setIcon(VaadinIcons.ARROW_RIGHT);

        addButton.addClickListener(click -> {
            // ToDo: Revisar lo que se recibe por todoList
            todoList.addTodo(new Todo(taskField.getValue()));
            taskField.setValue("");
            taskField.focus();
        });
        addButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
    }

    private void addTodoList() {

        // ToDo: Revisar lo que se recibe por todoList y descomentar una vez arreglado
        // Especificando las tareas con cualquier label
        //addComponent(todoList);
    }

    private void addActionButtons() {
        Button deleteButton = new Button("");
        deleteButton.setIcon(VaadinIcons.TRASH);
        // ToDo: Revisar lo que se recibe por todoList
        deleteButton.addClickListener(click -> todoList.deleteCompleted());
        addComponent(deleteButton);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}