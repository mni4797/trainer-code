package com.revature;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
import com.revature.models.Fighter;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Building bean container");
        // instead of passing a classpath of XML file, we pass it java class that we
        // define our beans in
        try (AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class)) {
            System.out.println("Container configured");
            Fighter knight = container.getBean("MrBean", Fighter.class);
            knight.goToTraining();

            Fighter sFighter = container.getBean("BeanieBaby", Fighter.class);
            sFighter.goToTraining();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
