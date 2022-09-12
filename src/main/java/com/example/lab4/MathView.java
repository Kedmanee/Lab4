package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Route(value = "index1")
public class MathView extends VerticalLayout {
    public MathView() {
        NumberField num1 = new NumberField("Number 1");
        NumberField num2 = new NumberField("Number 2");
        TextField ans = new TextField("Answer");
        HorizontalLayout hl = new HorizontalLayout();
        Button btn1 = new Button("+");
        Button btn2 = new Button("-");
        Button btn3 = new Button("x");
        Button btn4 = new Button("/");
        Button btn5 = new Button("Mod");
        Button btn6 = new Button("Max");

        btn1.addClickListener(buttonClickEvent -> {
            double n1 = num1.getValue();
            double n2 = num2.getValue();
            String out = WebClient.create()
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/plus/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });
        btn2.addClickListener(buttonClickEvent -> {
            double n1 = num1.getValue();
            double n2 = num2.getValue();
            String out = WebClient.create()
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/minus/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });
        btn3.addClickListener(buttonClickEvent -> {
            double n1 = num1.getValue();
            double n2 = num2.getValue();
            String out = WebClient.create()
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/multiply/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });
        btn3.addClickListener(buttonClickEvent -> {
            double n1 = num1.getValue();
            double n2 = num2.getValue();
            String out = WebClient.create()
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/multiply/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });
        btn4.addClickListener(buttonClickEvent -> {
            double n1 = num1.getValue();
            double n2 = num2.getValue();
            String out = WebClient.create()
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/divide/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });
        btn5.addClickListener(buttonClickEvent -> {
            double n1 = num1.getValue();
            double n2 = num2.getValue();
            String out = WebClient.create()
                    .get() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/mod/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });
        btn6.addClickListener(buttonClickEvent -> {
            double n1 = num1.getValue();
            double n2 = num2.getValue();
            String out = WebClient.create()
                    .post() // กําหนดรูปแบบการสื3อสาร
                    .uri("http://localhost:8080/max")
                    .body(Mono.just(new MaxValue(n1, n2)), MaxValue.class)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });

        hl.add(btn1,btn2,btn3,btn4,btn5,btn6);
        add(num1,num2,hl,ans);
    }
}
