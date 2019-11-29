JFLAGS = --module-path /usr/share/openjfx/lib --add-modules=javafx.base,javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web
JC = javac
JR = java
default:Living.class Zombies.class NormalZombie.class Sun.class InGameMenuController.class levelScreenController.class EntryScreenControllerExisting.class UsernamePageController.class LoginPageController.class EntryScreenControllerNew.class Screen3controller.class Screen2controller.class Screen1controller.class WelcomeScreenController.class Game.class

Sun.class: Sun.java
	@$(JC) $(JFLAGS) Sun.java

NormalZombie.class : NormalZombie.java
	@$(JC) $(JFLAGS) NormalZombie.java

Zombies.class: Zombies.java
	@$(JC) $(JFLAGS) Zombies.java


Living.class: Living.java
	@$(JC) $(JFLAGS) Living.java


InGameMenuController.class: InGameMenuController.java
	@$(JC) $(JFLAGS) InGameMenuController.java

levelScreenController.class: levelScreenController.java
	@$(JC) $(JFLAGS) levelScreenController.java

EntryScreenControllerExisting.class: EntryScreenControllerExisting.java
	@$(JC) $(JFLAGS) EntryScreenControllerExisting.java

UsernamePageController.class: UsernamePageController.java
	@$(JC) $(JFLAGS) UsernamePageController.java

LoginPageController.class: LoginPageController.java
	@$(JC) $(JFLAGS) LoginPageController.java

EntryScreenControllerNew.class: EntryScreenControllerNew.java
	@$(JC) $(JFLAGS) EntryScreenControllerNew.java

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