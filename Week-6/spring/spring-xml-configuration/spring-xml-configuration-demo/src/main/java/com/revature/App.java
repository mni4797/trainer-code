package com.revature;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        System.out.println("build the bean container");
        try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("beans.xml")) {
            System.out.println("Bean container created! Ready to serve");
            Fighter knight = container.getBean(Knight.class);
            // Fighter knight = new Knight(new SpringTraining()); ^
            knight.goToTraining();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
