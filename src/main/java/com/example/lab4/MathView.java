package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "index1")
public class MathView extends VerticalLayout {
    public MathView() {
        NumberField num1 = new NumberField("Number 1");
        NumberField num2 = new NumberField("Number 2");
        TextField ans = new TextField("Answer");
        HorizontalLayout hl = new HorizontalLayout();
        Button btn1 = new Button("Vaadin button");
        Button btn2 = new Button("Vaadin button");
        Button btn3 = new Button("Vaadin button");
        btn1.addClickListener(buttonClickEvent -> {
            double n1 = num1.getValue();
            double n2 = num2.getValue();
            String out = WebClient.create()
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/plus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });

        hl.add(btn1,btn2,btn3);
        add(num1,num2,hl,ans);
    }
}
