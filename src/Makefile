JFLAGS = --module-path /usr/share/openjfx/lib --add-modules=javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web
JC = javac
JR = java
default: PlayGamePageController.class StartPageController.class WelcomeScreenController.class Game.class

PlayGamePageController.class: PlayGamePageController.java
	@$(JC) $(JFLAGS) PlayGamePageController.java

StartPageController.class: StartPageController.java
	@$(JC) $(JFLAGS) StartPageController.java

WelcomeScreenController.class: WelcomeScreenController.java
	@$(JC) $(JFLAGS) WelcomeScreenController.java

Game.class: Game.java
	@$(JC) $(JFLAGS) Game.java

run:
	@$(JR) $(JFLAGS) Game

clean:
	@rm *.class