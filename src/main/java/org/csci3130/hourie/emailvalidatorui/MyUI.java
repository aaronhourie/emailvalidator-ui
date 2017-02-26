package org.csci3130.hourie.emailvalidatorui;

import javax.servlet.annotation.WebServlet;

import org.csci3130.hourie.emailvalidator.EmailValidator;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    /**
     * Worked from the Vaadin MyUI basic example. 
     */
    @Override
    protected void init(VaadinRequest vaadinRequest) {
      
        EmailValidator emailValidator = EmailValidator.getInstance();
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField email = new TextField();
        email.setCaption("Type an email here:");

        Button button = new Button("Validate");
        button.addClickListener( e -> {
            if (emailValidator.isValid(email.getValue())){
              layout.addComponent(new Label("The email: " + email.getValue() 
                      + " is valid.")); 
            }
            else {
              layout.addComponent(new Label("The email: " + email.getValue() 
              + " is invalid.")); 
            }
        });
        
        layout.addComponents(email, button);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
