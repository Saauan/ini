
## About INI

INI has been designed to keep distributed computing as simple as it can be. It natively handles processes, deployment, communication and synchronization.

INI is not meant to be a general-purpose language. It will not address all programming issues programmers can face. On the other hand, it will help programmers to efficiently build and deploy distributed data pipelines or calculations.

By default, INI uses Kafka as a broker.

### Language Design Philosophy

INI has been built around a simple construct called a *rule*, which follows the syntax below:

```javascript
rule := guard '{' statements '}'
```

Rules are the heart of the language and since there are no other control flow structure (besides the ``case`` construct), this choice forces the programmers to write well-structured and readable code. To some programmers, this constraint will feel uncomfortable. However, the benefit of this approach, besides code clarity, is also that it is well-suited to be formally verified and validated with Model Checking, as shown in Truong Giang Le's PhD thesis: https://tel.archives-ouvertes.fr/tel-00953368/document. 

One of INI's main design drive is that it is able to generate Promela code that can be formally verified with the Spin model checker (feature still under development). 

### Typical Uses/Applications

- IoT/Robotics
- Distributed Computing
- Multi-Agent Systems
- Critical Systems

### INI Main Features

- Process oriented: programmers can define processes that will run on INI nodes.
- Reactive and event-driven: processes react to events, including consume events that allow for inter-process communication.
- Rule-based: processes and functions rely on rules for readability purpose.
- Functional style: programmers familiar with functional programming can use functions and recursion.
- Auto-deployment: processes and functions are automatically deployed with annotations, either in push or in pull mode.
- Type inference: programs are strongly typed-checked with type inference (still under development).

## Examples

The goal of these examples is to give a first overview of the INI syntax and semantics.

### Functional-style factorial function

For pure local calculations, INI programmers can define functions. Here is a typical factorial calculation with INI. 

```javascript
function fac(n) {
  n == 1 {
    return 1
  }
  n > 1 {
    return n * fac2(n-1)
  }
}
```

Note the absence of a switch in the body of the function. That is because, in INI, only rules (``rule := guard '{' statements '}'``) are allowed as first-level statements. 

### Rule-based-style factorial function

In INI, all the rules continue to be executed until none is applicable anymore or if the function has returned (using an explicit ``return`` statement). In practice, it means that one can use a rule-based flavor to program a function. For instance, here is the factorial implementation with a rule-based style.

```javascript
function fac(n) {
  @init() {
    f=1
    i=2
  }
  // this rule will loop until i > n
  i <= n {
    f=f*i++
  }
  @end() {
    return f
  }
}
```

The second rule, guarded by ``i <= n``, continues to be executed until the ``i`` variable value become greater than ``n``. In INI, looping can be implemented this way, which means that there is no need for having loops as control flow constructs in the language. This design choice keeps the language small and simple, thus making INI programs usually easy to read and maintain.

Finally, note the ``@init`` and ``@end`` rules, which are called "event rules". The ``@init`` event is a one-shot event that is evaluated before all other rules, while the ``@end`` event is a one-shot event evaluated once no rules are left to be applied. 

### A process awaking every second

In INI, processes look pretty similar to functions but actually implement a quite different execution semantics. On contrary to a function, a process always runs asynchronously and reacts to its environment through events. A process definition can only contain rules and event rules, i.e. actions that are triggered when a condition is fulfilled, or when an event is fired. By default, a process will never end, unless none of the rules can apply anymore and all the events are terminated. 

The following INI program creates a process that will be notified every second (1000ms) by the ``@every`` event. It then evaluate the rule's action to print a tick and increments the tick count hold by the ``i`` variable.

```javascript
process main() {
  @init() {
    i = 1
  }
  @every() [time=1000] {
    println("tick "+(i++))
  }
}
```

Note the ``[time=1000]`` construct, which configures the ``@every`` event rule to be fired every second. This construct will be commonly used in INI programs and is called an *annotation*.

### A simple 3-process data pipeline

Since processes are asynchronous, they cannot return values like functions do. So, process communicate through channels (similarly to Pi calculus and most agent-based systems). Processes can produce data in channels using the ``produce`` function, and consume data from channel using the ``@consume`` event.

In the following program, the ``main`` process creates two sub-processes by calling ``p``. Each sub-process consumes a data from an ``in`` channel and produces the incremented result to an ``out`` channel. Thus, it creates a pipeline that ultimately sends back the data incremented twice to the main process.

```javascript
process main() {
  @init() {
    p("c1", "c2")
    p("c2", "c")
    println("processes started")
    produce("c1", 1)
  }
  c:@consume(v) [channel="c"] {
    println("end of pipeline: "+v)
    stop(c)
  }
}

process p(in, out) {
  c:@consume(v) [channel=in] {
    println(in+": "+v)
    produce(out, v+1)
    stop(c)
  }
}
```

The above program behaves as depicted here:

- ``main`` creates two sub-processes ``p("c1", "c2")`` and ``p("c2", "c")``,
- ``main`` sends the data ``1`` to the ``"c1"`` channel (``produce("c1", 1)``),
- ``1`` is consumed from ``"c1"`` by ``p("c1", "c2")``, and ``2`` is produced to ``"c2"``,
- ``2`` is consumed from ``"c2"`` by ``p("c2", "c")``, and ``3`` is produced to ``"c"``,
- finally, ``3`` is consumed from ``"c"`` by ``main``, and the pipeline stops there.

Note the use of the ``stop`` function in the ``@consume`` event rules. This is not mandatory but if you don't stop the consumer, the process will never end. Here, we want the processes to terminate once they have handled the data.

## INI nodes and auto-deployment

By default spawned processes are deployed on the current node (called ``main`` if unspecified). However, by simply using annotations, the programmer can decide on which (remote) INI node the process shall be spawned. There are two ways to deploy processes or functions:

- Push the process/function on a remote node.
- Pull the process/function from a remote node.

Given the pipeline example explained above, to push/spawn the ``p`` processes to nodes ``n1`` and ``n2`` (assuming that these nodes have been properly launched), we just add the following annotations:

```javascript
[...]
  @init() {
    p("c1", "c2") [node="n1"]
    p("c2", "c")  [node="n2"]
    println("processes started")
    produce("c1", 1)
  }
[...]
``` 

A key point to remember is that when a process is spawned to a remote node, the required code (processes and functions) will be automatically fetched from the spawning node. So there is no need for the programmer to pre-deploy manually any piece of program on the INI nodes. INI will take care of all this transparently.

## Getting started

### Build and run

Install and start Apache Kafka:

```console
$ cd kafka_{version}
$ bin/zookeeper-server-start.sh config/zookeeper.properties
$ bin/kafka-server-start.sh config/server.properties
```

Build with:

```console
$ cd {ini_root_dir}
$ maven package
```

Lauch INI program (UNIX-based OS):

```console
$ cd {ini_root_dir}
$ bin/ini {ini_file}
```

### Configuration

For development (JUnit tests), INI uses the ``development`` environment, which defaults to a locally-installed Kafka broker. In order to use another Kafka instance, modify the ``ini_config.json`` configuration file to set the right connection parameters.

Ultimately, once moving an INI program to production, you should modify the ``production`` environment to connect to the production Kafka broker. Then, select the ``production`` environment by setting the ``INI_ENV`` system environment variable to ``production``, or by using the ``--env`` option when running INI.


