JFLAGS = --module-path /usr/share/openjfx/lib --add-modules=javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web
JC = javac
JR = java
default: StartPageController.class WelcomeScreenController.class Main.class

StartPageController.class: StartPageController.java
	@$(JC) $(JFLAGS) StartPageController.java

WelcomeScreenController.class: WelcomeScreenController.java
	@$(JC) $(JFLAGS) WelcomeScreenController.java

Main.class: Main.java
	@$(JC) $(JFLAGS) Main.java

run:
	@$(JR) $(JFLAGS) Main

clean:
	@rm *.class