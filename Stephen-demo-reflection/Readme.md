# S.O.L.I.D Design Principles
* They are five design principles intended to make software designs more understandable, flexible, and maintainable
    * Kinda like the OOP pillars, but it is just rules to follow to write better code
## Single Responsible Principle
* A class should have one and only one reason to change
* If one class has more responsibility, just segregate them into many classes 
* Ex: Software Engineer class should just manage anything related to creating a program and shouldn't also have the responsiblity to manage financial forms. Instead, segragate the two class and create a Accountant class that will hold that responsiblity
## Open/Closed Principle
* A class should be open for extensions but closed for modification
* It just means you can add new funcitonality without changing existing code
* A great way to do this is uing interfaces
    * Such as us using dependency injection with interfaces
    * Or using Imenu interface and all our code we wrote in program.cs works just fine with any of our new C# classes
## Liskov Substitution Principle
* Derived class should be substitutable for their base class implementation
* It just means derived classes should not behave in such a way that it will not cause problems when used instead of a base class
* One way to avoid breaking is using the base class implementation as well as your derived class implementation
## Interface Segregation Principle
* You should not be forced to implement methods that you don't need in an interface
* Just segregate the interface into multiple interfaces
## Dependency Inversion Principle
* High and low level modules should depend on abstractions but not on each other
* If a class uses the design and implementaiton of another class, it raises the risk that change one class could break the other class
* To fix, we must both let them depend on abstractions 


# Reflection API
* Gives us the capabilities to select classes and their classes members while the code is running
* Usually the way we select classes and their class members is writing on the source code
* However, what if we want it to be dynamic?
    * With reflection, we can potentially select a field and change its access modifier
    * We can potentially select every method from a class and go ahead and run it
    * Coupled with annotations, you can make things that is otherwise impossible
* A bit of warning, reflection is deemed for advance java programmers, you need to be comfortable with compiler and runtime and as well as memory management

## Cons
* Performance
    * JVM inheritly has optimization functionality but by using Reflections, JVM has problems running these optimizations. So overall, using reflections is slower compared to not using it
* Security
    * Reflections Api won't work if you run your app in a machine that doesn't have the right permissions. It needs special runtime permissions

## Annotations
* Gives metadata information about a particular class or class member
* Allows us to change the behavior of a functionality depending on the information provided
    * Ex: Our Test annotation enabled() will determine if it should run the unit test or ignore it