
**Proyecto Automatización Page Espn**

Descripción:
_El proyecto consiste en automatizar flujos login,disable and cancel account._
_Se utiliza framework Java Selenium with TestNG_

Precondición:
- Ejecutar en Sistema Operativo Windows
- Descarga el archivo Google ChromeDriver con la versión instalada en su local
y reemplazarla el existente en la siguiente ruta: src/test/resources/driver
- Tener instalado previamente maven en su local
- Tener instaldo jdk 8 de java
- Descargar proyecto de git(Push) a su local

Pasos para la ejecución:
1. git clone https://github.com/richie07/Espn_TestNG.git
2. mvn clean install -DskipTests
3. mvn eclipse:eclipse or mvn idea:idea
4. Ejecutar el comando cmd Windows :Tecla Win + R
5. Digitar cmd y presionar enter
6. En la consola ubicarse en la ruta del proyecto descargado (Ejm: cd C:\Users\Richard\IdeaProjects\DriveGoogle)
7. En la consola ejecutar : mvn clean install compile test
