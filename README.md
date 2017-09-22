# Programación Orientada a Objetos
TP3 de Clase de Programación Avanzada.

# POO
# JUnit

### Integrantes del equipo

* Fabián Escobar ([FabianNorbertoEscobar](https://github.com/FabianNorbertoEscobar))
* Pablo López ([pabloL0pez](https://github.com/pabloL0pez))
* Micaela Ramos ([RamosMicaela](https://github.com/RamosMicaela))
* Lucas Secchi ([Secchi1](https://github.com/Secchi1))

## Sobre la tecnología

### Herramientas utilizadas

* Java 1.7
* JUnit 4

## Especificacion

### Unidades
- Los soldados pueden atacar cuerpo a cuerpo a otras unidades si tienen suficiente energía. Cada
ataque les consume 10 puntos de energía, y comienzan con 100. Restauran energía si reciben la
pocion de agua. Infringen un daño de 10 puntos y comienzan con 200 de salud.
- Los arqueros pueden atacar a una distancia de entre 2 y 5 respecto de su enemigo, y si tienen
suficientes flechas. Comienzan con 20 flechas en su carcaj, y pueden recargar si reciben un
paquete de seis flechas. Infringen un dano de 5 puntos, y comienzan con 50 de salud.
- Los lanceros pueden atacar a una distancia de 1 a 3, sin condicion. Infringen un daño de 25
puntos, y comienzan con 150 de salud.
- Los caballeros pueden atacar a una distancia de 1 a 2, siempre que su caballo no se haya puesto
rebelde. Infringe un dano de 50 puntos y comienza con 200 de salud. Un caballo se pone rebelde
luego de 3 ataques, y puede calmarse si recibe una pocion de agua.

### Items
Las unidades de este juego de estrategia pueden equiparse con uno o mas items. Los mismos no
son excluyentes, seran:
- Un escudo, que aumenta la defensa ante ataques. Quien posea un escudo recibira solamente el
40 % del valor del ataque.
- Una capa, que duplica la energ ́ıa de la unidad. Sin embargo, reduce la fuerza de los ataques en
un 10 % porque obstaculiza su movimiento.
- Un punal, que aumenta la fuerza de los ataques en 3 puntos pero reduce la defensa tambien en
3 puntos por inutilizar la otra mano.
