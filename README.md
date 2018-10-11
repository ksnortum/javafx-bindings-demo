# javafx-bindings-demo

**javafx-bindings-demo** is a simple JavaFX form that demonstrates the use of bidirectional bindings and FXML.

## Note
If you want to run on Java 10 or lower, checkout the branch _pre-javafx-11_. 

## Requirements
* Java version 11
* Maven version 3.5 or up (tested on 3.5.4)

## Launching
* At the command line, _cd_ to the root of your project (the directory that contains the _pom.xml_ file). 
* Issue the command:

        mvn compile exec:java

## Using 
There are four "rows" in the fake DB (played tonight by ArrayList).  Change a field and it stays changed until the program is exited.  All the controller does when the Next or Prev button is pushed is to unbind the current row, move the index, and bind the new row.  The bound row is displayed and the modifications are recorded without further programming.

## FXML
I used an FXML file with the controller set.  The TextFields and the button handlers are injected into BookController.java automatically when the FXML file is loaded by the FXMLLoader class.  I inject the Stage into the controller, as it needs this to properly close the window and shutdown the program.

I used SceneBuilder to create the FXML file.  This is built into the IntelliJ and NetBeans IDEs, or you can download it already built for your system from [Gluon](http://gluonhq.com/products/scene-builder/).

## TODO
* Add a simple database and create a DBA
* Make Add and Delete buttons