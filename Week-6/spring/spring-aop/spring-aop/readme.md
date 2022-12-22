# Spring AOP

AOP stands for _Aspect Oriented Programming_. AOP is a programming paradigm that aims to increase modularity by allowing the separation of _cross-cutting concerns_. It does this by _adding additional behavior to existing code without modifying the code itself._

Instead we can declare the new code and new behaviors separately.

**?** What are "cross-cutting concerns"?

**A** A cross cutting concern is a concern that is valid across your program. Like logging. It's common knowledge to know that logging is a coding best practice but we often forget to add it to our code.

# AOP Vocabulary

**Aspect**-a modularization of a concern that cuts across multiple classes. A service that gets used all over the place

**JoinPoint**-a point during the execution of a program, such as the execution of a method or the handling of an exception. A joinpoint is a _candidate point_ in the Program Execution of the application where an aspect can be plugged in. This point could be a method being called, an exception being thrown, or even a field being modified. These are the points where your aspect’s code can be inserted into the normal flow of your application to add new behavior.

**Advice**- an action taken by an aspect at a particular Joinpoint. Different types of advice include “around,” “before,” and “after.”

**Pointcut**- a predicate that helps match an Advice to be applied by an Aspect at a particular JoinPoint.We often associate the Advice with a Pointcut expression, and it runs at any Joinpoint matched by the Pointcut.

A _pointcut_ defines at what joinpoints, the associated Advice should be applied. Advice can be applied at any joinpoint supported by the AOP framework. Of course, you don’t want to apply all of your aspects at all of the possible joinpoints. Pointcuts allow you to specify where you want your advice to be applied. Often you specify these pointcuts using explicit class and method names or through regular expressions that define matching class and method name patterns. Some AOP frameworks allow you to create dynamic pointcuts that determine whether to apply advice based on runtime decisions, such as the value of method parameters.

_Pointcut vs JoinPoint_

A Joinpoint is an opportunity within code for you to apply an aspect...just an opportunity. Once you take that opportunity and select one or more Joinpoints and apply an aspect to them, you've got a Pointcut.
