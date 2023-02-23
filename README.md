
# La Tondeuse Automatique

Ce programme permet d'à l'aide d n fichier à l'entrée, programmer les instructions de déplacement des tondeuses sur une pelouse afin de tondre cette dernière de manière automatique.

## Comment ça marche
Le programme s'execute en ligne de commande de la manière suivante:
 
    java -jar .\target\tondeuse-1.0-SNAPSHOT.jar .\tondeuse.txt

- tondeuse-1.0-SNAPSHOT.jar : est le fichier d'instructions
- tondeuse.txt : est le fichier d'instructions

*Lorsqu'une tondeuse achève une série d'instructions, elle communique sa position
et son orientation en écrivant dans la console*

## Format du fichier d'instructions
Les lignes suivantes réprésentent le contenu du fichier et la signification en commentaire

```js

  5 5//Coordonnées x et y de l'agle supérieur droite de la pelouse. L'angle inférieur gauche est 0 0
  1 2 N //Coordonnées x et y et l'orientation initial de la première tondeuse
  GAGAGAGAA //Série d'instructions de la première tondeuse
  3 3 E //Coordonnées x et y et l'orientation initial de la deuxième tondeuse
  AADAADADDA //Série d'instructions de la deuxième tondeuse

```

### Codes d'instruction:
- A : Avancer
- D : Droite
- G : Gauche

### Code orientation:
- N : North
- E : East
- S : South
- W : West

## Cloner, empaqueter et exécuter
Dans les étapes suivantes, nous allons cloner, construire et exécuter l’application.
**Prérequis**
Java 1.8

### Cloner
    git clone git@github.com:ulrichlele/tondeuse.git

### Empaqueter
    cd tondeuse/
    mvn package

## Exécuter
    java -jar target/tondeuse-1.0-SNAPSHOT.jar tondeuse.txt
 
### Contenu du fichier tondeuse.txt
 
  ```js
    5 5
    1 2 N
    GAGAGAGAA
    3 3 E
    AADAADADDA
    3 1 W
    AGADADADAGGA
    0 0 N
    ADAGADAGADAGADAGADAD
  ```

### Résultat

  ```js
    1 3 N
    5 1 E
    1 1 W
    5 5 S
  ```
