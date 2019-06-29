javac -cp lib/spigot-api.jar -d bin/ src/com/obscurityGames/roleplayChat/*.java
cp src/plugin.yml bin/plugin.yml
cp src/config.yml bin/config.yml
 
jar -cvf RoleplayChat.jar -C bin .
