# javafx-bindings-demo

**javafx-bindings-demo** is a simple JavaFX form that demonstrates the use of bidirectional bindings and FXML.

## Requirements
Java version 9 or up is needed because of the FXML file.  You could probably lower that to Java 8 by changing the version number in the FXML.

## Launching
Import the code into your favorite IDE, or launch by hand:

    cd javafx-bindings-demo\src
    javac net\snortum\javafx\bindingsdemo\*.java
    java net.snortum.javafx.bindingsdemo.Main

## Using 
There are four "rows" in the fake DB (played tonight by ArrayList).  Change a field and it stays changed until the program is exited.  All the controller does when the Next or Prev button is pushed is to unbind the current row, move the index, and bind the new row.  The bound row is displayed and the modifications are recorded without further programming.

## FXML
I used an FXML file with the controller set.  The TextFields and the button handlers are injected into BookController.java automatically when the FXML file is loaded by the FXMLLoader class.  I inject the Stage into the controller, as it needs this to properly close the window and shutdown the program.

I used SceneBuilder to create the FXML file.  This is built into the NetBeans IDE, or you can download it already built for your system from [Gluon](http://gluonhq.com/products/scene-builder/).

## TODO
* Add a simple database and create a DBA
* Make Add and Delete buttons
* Add a POM file to build and run via Maven?