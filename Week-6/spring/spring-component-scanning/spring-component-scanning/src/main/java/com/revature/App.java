package com.revature;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
import com.revature.fighters.Fighter;

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
        System.out.println("Creating beans container");
        try (AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class)) {
            System.out.println("Bean container created");
            Fighter knight = container.getBean("kFighter", Fighter.class);
            knight.goToTraining();
            System.out.println(knight.getName());
            System.out.println(knight.getWeapon());

            Fighter zFighter = container.getBean("zFighter", Fighter.class);
            zFighter.goToTraining();
            System.out.println(zFighter.getName());
            System.out.println(zFighter.getWeapon());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
