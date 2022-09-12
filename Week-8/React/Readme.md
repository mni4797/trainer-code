# Introduction to React
* It is a frontend Javascript/Typescript library to develop websites
    * Notice it is just a library
* It is **Single Page Application**
    * Allows us to navigate through our website without reloading the entire page or calling on the server
    * You have only one HTML page and you utilize JS heavily to dynamically change your website to **appear** like you went to a different page
    * Advantages:
        * Quick load times since your local computer/phone will do the majority of the leg work and deosn't need to talk to the server for an HTML doc
        * Provides pleasant user experience with mobile due to unstable network connections
    * Disadvantages:
        * Web crawlers will have a hard time finding specific section of your website
        * Uses a lot of your computing resources and your computer is doing the majority of the "thinking" to render the website to your browser
* It is **component-based**
    * Done with having one HTML document that will specify one web page in your website
    * Instead, they modularized a website a bit more further
    * A components are `building blocks that makes your entire website`
    * This was made so you can reuse multiple components in different places but displayed a little bit different

## Library vs. Framework
* Easy distinction is a library is a lot less function/features compared to a framework
* Technical distinction - Frameworks have a lot more control over the flow of your code and how to run it (IoC)
    * Spring controls most of your object creation and also have specific pipelines it goes through every time you run Spring

## Different important files in React
* Package.json - used to find dependencies for the React app
* tsconfig.json - Used to configure our transpilation process
* node_modules - Used to store dependencies for your React app