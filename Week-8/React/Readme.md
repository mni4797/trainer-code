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
* node_modules - Used to store dependencies for your React app.
* Index.tsx - Your main entry point for your components. Interacts with your Index.html to append your components to

## What is a component?
* It is a single UI/graphical unit that is independent and reusable
* You can think of it as puzzle pieces, by itself it has a piece of picture, torgether with other pieces you get an image
* **Class Component** - They are components made by creating a class and extending React.Component
* **Functional Component** - They are components made by creating functions

## Props
* Props are a great way to pass information into a component to be used/display
    * Essentially passimg from **parent to child** component
    * It is possible to do from child to parent using callback functions
* You specify props within the parameter of the functional component
* Whenever you use that component, you must provide the necessary information as well (UNLESS IT IS OPTIONAL)
* A very big part as to make component reusable

## JSX
* An extension of JavaScript
* We are using TSX which is just the Typescript version of it
* It gives us all the power to combine both HTML and JS and have them pass/use data pretty easily
* This goes back to React philosophy which everything should be at one place
* Less known reasons why use JSX:
    * We heavily use JavaScript to render our webpages and that comes with some major risks with JS injection (XSS)

# Component Lifecycle
* Like with anything, a component have a lifespan. It will live and die. In coding, this means we have the power to controler a components life
* If a component dies, we can attached it to a functionality you may want to execute or if a component lives, do this behavior/function
* Now why does this matter a lot in frontend?

## Hooks
* A new way of messing with states rather doing the old way
* Essenetially no more dealing with the lifecycle since Hooks will re-render the page if a certain variable changed
* TLDR, if you have dynamically changing information in your webpage use **Hooks** or else it will **NOT** display the changes

## States
* While props are used to transfer information into components to use
* States are used within the component to display information to your web page
* States are **immutable**, you must use the useState() method to change the information and have it reflect that change

## Virtual DOM
* Whenever we interact with the "DOM" in React, we are actually messing with the **Virtual DOM**
* Yes there are two DOM in React, HTML DOM and Virtual DOM
* React will look into the virtual DOM and compare it with the real DOM on what is the difference between the two
* The detected diffrence will then synchronize and React will use DOM manipulation to make that change
* This syncing process is called **reconcilation**

## Conditional Rendering
* When you want to render/display certain things in React based on a condition

## Lists and Keys
* Whenever you display list of items, React needs you to add a key
* It is important for React so it can uniquely identify that specific HTML in the event you need to dynamically change its contents
* It is a massive optimization hit if you don't add keys
* Just another point as to why we add primary keys