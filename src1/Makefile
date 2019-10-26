JFLAGS = --module-path /usr/share/openjfx/lib --add-modules=javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web
JC = javac
JR = java
default: Screen3controller.class Screen2controller.class Screen1controller.class WelcomeScreenController.class Game.class

Screen3controller.class: Screen3controller.java
	@$(JC) $(JFLAGS) Screen3controller.java

Screen2controller.class: Screen2controller.java
	@$(JC) $(JFLAGS) Screen2controller.java

Screen1controller.class: Screen1controller.java
	@$(JC) $(JFLAGS) Screen1controller.java

WelcomeScreenController.class: WelcomeScreenController.java
	@$(JC) $(JFLAGS) WelcomeScreenController.java

Game.class: Game.java
	@$(JC) $(JFLAGS) Game.java

run:
	@$(JR) $(JFLAGS) Game

clean:
	@rm *.class