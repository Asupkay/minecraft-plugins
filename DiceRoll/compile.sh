javac -cp lib/spigot-api.jar -d bin/ src/com/obscurityGames/diceRoll/Main.java
cp src/plugin.yml bin/plugin.yml
cp src/config.yml bin/config.yml
 
jar -cvf DiceRoll.jar -C bin .
