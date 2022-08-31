# Docker
* It is a way of packaging our application that has a bunch of dependencies (SDK, Runtime, Maven dependencies) that we had to install to even run the application properly into one single package that we can send to multiple computers and have it run flawlessly without the need to have anything setup in your computer.
* It is a containerization ecosystem

## What is the purpose of Docker?
* Imagine you need to deliver your application to a lot of people
* But hey to even start using your application you gotta tell the person to download this file (manually)
* And then this file needs another file to run and this file needs another another file to run
* Just think of all the game launchers you use nowadays like steam or epic store, when you get a game you just need to press one button and that actually downloads everything you will ever need for that game even its dependencies
* This is where Docker shines, just give the person an image and bam you can run the application

## What is Virtualization? (VM)
* It is a creation virtual machine that simulates a real computer with an operation OS
* A tightly isolated software container wtih an OS and application inside that you want to run
* You can create multiple Vms in one single physical computer
    * They do not interact with each other because they are **Isolated** meaning one VM cannot interact with your main OS or other VMs
* There is another layer called a **Hypervisor** interacts with all the VMs to essentially dictact how much computing resource to each VM
    * Extremly costly in terms of computing resources (RAM, CPU, Disk space, etc.)
    * Ex: Running an Windows OS in your computer would need at least 2 gb of ram and MacOS will need at least 4 gbs of ram

## What is Containerization?
* Type of VM that is faster/lightweight compared to your traditional VM
* Instead of having individual OS for each application, you can share **ONE** OS for each application
    * To give you an idea why that is a LOT more lightweight:
        * Windows 11 OS needs at least 18 gbs of harddrive, needs at least 4 gbs of ram
        * MacOS needs at least 12 gbs, at least 4 gbs of ram
        * AND you still need to run your very own computers OS system
* How does it accomplish running all in one shared OS?
    * It involves bundling an application together with all the configuration files, libraries, and dependencies required
    * Basically get everything the application needs to run it
* When creating a container, the allocation of resoruces is dynamic
    * Meaning it will use as much resrouces the container needs to run the application
    * Ex: If running your app requires 1 gb of ram then it will just need that 1 gb of ram and will either increase or decrease that required depending on the workload
    * Vastly different from a traditional VM that must have at least 4 gb of ram available to even start

## Docker artifacts/terminology
* Dockerfile
    * **IT IS NOT THE DOCKER IMAGE**
    * It is just a text document that will dictate to the docker daemon how to **MAKE** an image
* Docker Image
    * They are standalone package that includes everything for the application to run such as the code itself, dependencies, configuration, etc.
    * They are immutable file and represents an application and its virtual environment at a specific point of time
* Docker Container
    * An image cannot run on its own. It needs docker container to run the image
    * In other words, containers are the runnable instance of a docker image
    * Think of a CD, it has all the information you need to start an application/play music/ play movie but it needs a CD player to actually run your CD
     


