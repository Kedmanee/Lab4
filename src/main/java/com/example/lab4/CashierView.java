package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "index2")
public class CashierView extends VerticalLayout {
    public CashierView() {
        TextField change = new TextField("เงินทอน");
        change.setPrefixComponent(new Span("$"));
        change.getStyle().set("width", "130px");
        Button btn1 = new Button("คำนวณเงินทอน");
        TextField b1000 = new TextField();
        b1000.setPrefixComponent(new Span("$1000: "));
        b1000.getStyle().set("width", "130px");
        TextField b500 = new TextField();
        b500.setPrefixComponent(new Span("$500: "));
        b500.getStyle().set("width", "130px");
        TextField b100 = new TextField();
        b100.setPrefixComponent(new Span("$100: "));
        b100.getStyle().set("width", "130px");
        TextField b20 = new TextField();
        b20.setPrefixComponent(new Span("$20: "));
        b20.getStyle().set("width", "130px");
        TextField b10 = new TextField();
        b10.setPrefixComponent(new Span("$10: "));
        b10.getStyle().set("width", "130px");
        TextField b5 = new TextField();
        b5.setPrefixComponent(new Span("$5: "));
        b5.getStyle().set("width", "130px");
        TextField b1 = new TextField();
        b1.setPrefixComponent(new Span("$1: "));
        b1.getStyle().set("width", "130px");
        btn1.addClickListener(buttonClickEvent -> {
            int c = Integer.parseInt(change.getValue());
            Change out = WebClient.create()
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/getChange/"+c)
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();
            b1000.setValue(String.valueOf(out.getB1000()));
            b500.setValue(String.valueOf(out.getB500()));
            b100.setValue(String.valueOf(out.getB100()));
            b20.setValue(String.valueOf(out.getB20()));
            b10.setValue(String.valueOf(out.getB10()));
            b5.setValue(String.valueOf(out.getB5()));
            b1.setValue(String.valueOf(out.getB1()));
        });

        add(change,btn1,b1000,b500,b100,b20,b10,b5,b1);
    }
}
