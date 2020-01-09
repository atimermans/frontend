package com.example;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;


@SpringUI
@Theme("valo")
public class TodoUI extends UI {

    private VerticalLayout layout;

    @Override
    protected void init(VaadinRequest request) {

        /* ----------------------------------------------------------------- */

        Label menuTitle = new Label("Menu");
        menuTitle.addStyleName(ValoTheme.MENU_TITLE);


        Button defaultView = new Button("All Tasks", event -> getNavigator().navigateTo(""));
        defaultView.addStyleName(ValoTheme.BUTTON_LINK);
        defaultView.addStyleName(ValoTheme.MENU_ITEM);
        Button view1 = new Button("Label 1", event -> getNavigator().navigateTo("view1"));
        view1.addStyleName(ValoTheme.BUTTON_LINK);
        view1.addStyleName(ValoTheme.MENU_ITEM);
        Button view2 = new Button("Label 2", event -> getNavigator().navigateTo("view2"));
        view2.addStyleName(ValoTheme.BUTTON_LINK);
        view2.addStyleName(ValoTheme.MENU_ITEM);

        // Layout Para el menu lateral
        CssLayout menu = new CssLayout(menuTitle,defaultView,view1,view2);
        menu.addStyleName(ValoTheme.MENU_ROOT);

        // Layout Para la parte de contenido
        CssLayout viewContainer = new CssLayout();

        //todo: Comprobar con Vertical Layout
        HorizontalLayout mainLayout = new HorizontalLayout(menu, viewContainer);
        mainLayout.setSizeFull();
        setContent(mainLayout);

        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addView("", DefaultView.class);
        navigator.addView("view1", View1.class);
        navigator.addView("view2", View2.class);


        /* ----------------------------------------------------------------- */
    }

}
