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
* Docker Registry
    * It is the dockerhub
    * It is server-side or cloud application where you can store your images
    * Think of github but just for docker images
* .dockerignore
    * It is like .gitignore
    * It will ignore certain files in your application to not put inside the docker image

## Docker instruction vs Docker CLI
* Don't confuse wqith docker commands (docker build, docker run) that is the CLI commands we put on the terminal to tell docker daemon to do something
* The docker instructions is what we put inside the Dockerfil to make this image
* From, copy, expose, cmd, entrypoint, env, etc.
* TLDR: if you see it inside a dockerfile it is an instruction and if you see me put it on the terminal it is a docker cli

## Docker Daemon
* As we know, daemon just any background process happening in your computer that you don't really control
* It will manage our containers, image creation, conntecting to the docker registry, etc.

# More stuff with AWS
* AWS has a bunch of services that is more than just a creating a database

## AWS EC2
* EC2 stands for Elastic Computing Cloud
* A web service that provides a resizeable compute capacity in the AWS cloud
* Essentially we are renting a computer that exists in some Amazon serber that most likely have the state of art internet, computer components, maintenance crew, etc.
* We have complete control of how much "beefy" we want our server to have

# DevOps
* It is a culture that you follow in which you continuously develop your application and continuously deploy it
* DevOps are integrated with Agile planning since they have similar ideologies
* A nice magical way to have your application go from just your computer to the masses in a span of couple minutes and automatically done for you

## Continuous Integration (CI)
* The process of automating the testing and building of your code whenever you start merging two applications together
* In our github world, this is when we merge the main branch to someone's else branch that has a new feature
* Testing is done automatically as well as building and if any of these step fail, it will not attempt to **integer** that new feature to the main app.
## Continuous Delivery (CD)
* The extension of CI since CI all it does is integrate your experimental branches into the main branch and test if it works then build it.
* This step is all about getting your newly updated main application to the production level
    * hence we usually denote them as CI/CD since both are needed to really follow DevOps culture
* However, there is a **release manage that will check on everything before delivering to the users**

