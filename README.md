# Almundo CallCenter

Existe un call center donde hay 3 tipos de empleados: operador, supervisor y director. El proceso de la atención de una llamada telefónica en primera instancia debe ser atendida por un operador, si no hay ninguno libre debe ser atendida por un supervisor, y de no haber tampoco supervisores libres debe ser atendida por un director.

- Diseñar el modelado de clases y diagramas UML necesarios para documentar y comunicar el diseño.
- Debe existir una clase Dispatcher encargada de manejar las llamadas, y debe contener el método dispatchCall para que las asigne a los empleados disponibles.
- La clase Dispatcher debe tener la capacidad de poder procesar 10 llamadas al mismo tiempo (de modo concurrente).
- Cada llamada puede durar un tiempo aleatorio entre 5 y 10 segundos.
- Debe tener un test unitario donde lleguen 10 llamadas.

## Build 

>mvn clean install

## UML Diagram
![Alt text](https://raw.githubusercontent.com/ealtamar2/AlmundoCallCenter/master/DiagramaUMLAlmundo.png?raw=true "Diagrama UML")


## Description
 
- Para la ejecucion de la prueba se utilizo la case ThreadPoolExecutor de Java. En la implementacion se simula un newFixedThreadPool con un máximo de 10 threads, esto significa que si más de 10 tareas se envían a ejecutar sólo 5 se ejecutaran y el resto se bloqueará hasta que haya un thread libre para procesarlos dando solucion cuando no hay Empleados disponbles para atender las llamadas. Sin embargo, tambien se implementas los test con JUnit donde se demuestra lo anterior.

- Para la solucion de mas de 10 llamas concurrentes y/o cuando no hay empleados libres, se usa la cola LinkedBlockingQueue por defecto del ExecutorService, ya que esta maneja un bloqueo mientras no hayan recursos disponibles, una vez se liberen los recursos esta toma las llamadas en espera automatcamente. 

## Authors

* **Eduardo Altamar* - *Initial work* - [ealtamar2](https://github.com/ealtamar2)
