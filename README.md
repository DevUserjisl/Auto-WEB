# Automation ParaBank - Screenplay Pattern

Pruebas automatizadas de la aplicación ParaBank usando **Cucumber** y **Screenplay Pattern**.

## 📋 Requisitos

- Java 11+
- Maven 3.6+


## 📊 Stack Tecnológico

- **Cucumber 7.14.0** - BDD y escritura de scenarios
- **Serenity BDD 3.6.12** - Screenplay Pattern y reportes
- **Selenium WebDriver** - Automatización Web
- **TestNG 7.9.0** - Ejecución y gestión de tests
- **JavaFaker 1.0.2** - Generación de datos aleatorios para pruebas

## ▶️ Ejecutar Pruebas

```bash
mvn clean test
```



## 📁 Estructura del Proyecto

```
src/test/java/com/bdd/
├── interactions/       # Acciones atómicas
├── models/            # Modelos de datos
├── questions/         # Validaciones
├── tasks/             # Tareas compuestas
├── userinterfaces/    # Selectores UI
└── utils/             # Utilidades

src/test/resources/
├── features/          # Archivos .feature (Gherkin)
└── data/              # Datos de prueba JSON
```



