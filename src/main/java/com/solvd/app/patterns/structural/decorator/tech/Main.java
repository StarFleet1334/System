package com.solvd.app.patterns.structural.decorator.tech;

import com.solvd.app.patterns.structural.decorator.tech.Applications.Facebook;

public class Main {
    public static void main(String[] args) {
        NotifierDecorator notifierDecorator = new Facebook(
                new Storage()
        );

        notifierDecorator.call("Ilia","Mariami");
        notifierDecorator.call("Jake","Marry");
        System.out.println(notifierDecorator.getCall_sessions());
    }
}
