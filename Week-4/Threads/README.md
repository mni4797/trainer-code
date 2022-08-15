# Threads

## Keywords

Thread

- Runnable Interface
- Individual Processes
- Thread State

Multithreading

- Synchronization
- Thread Safety
- Race Conditions
- Parallel processing
- Concurrent processing

---

## Thread

What is a thread? Threads in general represent a line of execution. All java applications have at least 1 thread, the main thread. You also have threads running processes in the background called your daemon threads. An example of this is the thread JVM's garbage collector is running on.

## Creating threads

You can create threads 2 ways:

1. Extend the thread class
2. Implement the Runnable interface (Functional interface)

Implementing the Runnable interface is actually recommended. The Thread class defines the worker. The runnable interface defines the job the worker will perform. Because most of the time you just want to define the job that the thread runs, it's better to implement the interface that defines that AKA Runnable.

## Multithreading

Multithreading is a specialized form of multitasking. With multiple threads executing different actions you get to accomplish more.

Benefits:

- For faster processings of background/batch tasks
  - EX daemon thread in GC
- To take advantage of modern processors
- For reducing response times
- To serve multiple users at the same time
  - For http servers

**?** Who gets to decide the order of running threads???

**A** Thread scheduler.

**?** Do threads run in parallel? Do they run concurrently??? What's the difference?

**A** Depends on the system. In a machine with a singular CPU, threads are executed concurrently. Conncurrent means that the CPU is doing one thing at a time (because CPUs can only do one thing at a time) but it switches tasks quickly to give the illusion that it's doing the things at the same time. In a multiprocessor system, you can run a thread on each processor. This phenomenon of multiple threads running at the same time is what running in parallel is.

---

## Red Flags of multithreading

Shared resources is an issue. You can't really check to see how the other thread is affecting the resource. State of shared resource becomes amibiguous.

Too many threads is also a problem. Instead of executing, the thread scheduler is just switching between the multiple threads.

## Synchronization of resources

Synchronization of resources when you have hold of a resource you have means of letting other threads know its your turn to have the resource.

Implementing this in java is super simple, whenever you have a block of code or a resource you want only one thread to access it at a time, you use the synchronized keyword.

## Thread Safety

Every thread that accesses a resource shares the state of the resource. No thread has a different version of that resource. All threads have a shared "awareness" of the current state of the resource.

## Some problems with syncing your code

- Slows things down
- Deadlock, Dining Philosopher's problem
  - Western standoff, thread starvation

## Thread Pooling

The concept of having a set number of threads that are available to execute certain logic. By limiting the number of threads you are keeping your system from being overloded/overworked.

It's easy enough to implement thread pooling with the Executor interface!

Implemented by http servers like Apache Tomcat.
