# Polymorphism

- "poly" means many + "morph" means forms = many forms (i.e ability of an object to take on many forms)
- the ability of your code to behave a certain way based on context
- for example, with method overriding the method being executed differs if you call the original method from a base class implementation or the overridden method from the child class implementation.

## Polymorphism in your code

1. Method Overriding
   - When a child class changes the implementation of a method in a parent class
   - Method signature is the same but the implementation is different
   - Good example: toString method, in the Object class the default behavior is to print out where in memory this object exists in, but if you override it, you can define how you want instances of your class to be presented as a string
2. Method Overloading
   - When you have 2 methods that have the same name, they behave differently depending on the parameters given
   - Method signature would be different: parameters should be different (either in type or order), the return type can also be different
   - for methods in the same type
   - Good example: Constructor overloading, if you have a mix of constructors in one class
3. Generics
   - Placeholder types, you defer setting the type to the developer/ user of the particular class
   - Good example: Collections API, you set the type of element the collection would be storing, eg, ArrayList<Type goes here>
4. Covariance
   - when you pass and instance of a child to a reference that expects the parent
   - Good Example: List<T> someList = new ArrayList<>()
   - The parent reference would utilize the implementation of the child class for its methods
