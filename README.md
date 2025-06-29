# Mobile Automation Final Practice - Android Appium
Este repositorio contiene pruebas automatizadas para una aplicación móvil Android, construido como una práctica final que combina varios conceptos de automatización móvil aprendidos. El proyecto se centra en validar funcionalidades clave y flujos de navegación de una aplicación de demostración utilizando Appium.
## 🎯 Objetivo del Proyecto
El objetivo principal de esta práctica es aplicar un conocimiento integral de automatización móvil para automatizar escenarios específicos en dispositivos Android. Esto incluye:

* **Comprensión de Flujos Manuales:** Recrear cada escenario de prueba manualmente para comprender el comportamiento de la aplicación y los pasos necesarios para la automatización.

* **Pruebas de Navegación:** Validar la navegación de la barra de menú inferior y la visibilidad de los elementos en diferentes secciones.

* **Automatización de Formularios:** Automatizar los procesos de registro y inicio de sesión exitosos de usuarios, incluyendo consideraciones para pruebas repetibles.

* **Gestos Complejos:** Implementar gestos de deslizamiento horizontal y vertical para navegar por un carrusel y encontrar elementos específicos.

* **Independencia de las Pruebas:** Asegurar que cada caso de prueba pueda ejecutarse de forma independiente sin depender del orden de ejecución de otras pruebas.Test Independence: Ensuring each test case can run independently without relying on the execution order of other tests.

## 🛠️ Tecnologías Utilizadas
* **Appium:** Framework de automatización móvil para aplicaciones nativas, híbridas y web móviles.

* **Java:** Lenguaje de programación para escribir scripts de prueba.

* **TestNG / JUnit:** (Especifica cuál usaste. Usaré TestNG como marcador de posición, pero ajusta si usaste JUnit) Framework de pruebas para estructurar y ejecutar pruebas.

* **Maven / Gradle:** (Especifica cuál usaste. Usaré Maven como marcador de posición) Herramienta de automatización de construcción para la gestión de dependencias y la construcción de proyectos.

* **Android SDK y Emulador:** Para configurar el entorno de desarrollo de Android y dispositivos virtuales.

* **WDIO Dummy App:** La aplicación bajo prueba.
## ⚙️ Prerrequisitos
Antes de configurar y ejecutar las pruebas, asegúrate de tener lo siguiente instalado:

1. **Java Development Kit (JDK) 11+:**

   * Descargar JDK

   * Configura la variable de entorno JAVA_HOME.

2. **Android Studio:**

    * Descargar Android Studio

   * Instalar Android SDK (Tools, Platform-tools, Build-tools).

   * Configura la variable de entorno ANDROID_HOME y añade %ANDROID_HOME%\platform-tools a la ruta del sistema (PATH).

   * Crea un Dispositivo Virtual Android (AVD) usando el Administrador de AVD de Android Studio (por ejemplo, Pixel 3a, API 30).

3. **Node.js & npm:**

    * Descargar Node.js (npm viene incluido con Node.js).

4. **Servidor Appium:**

    * Instalar vía npm: npm install -g appium

   * (Opcional pero recomendado) Instalar Appium Desktop: Descargar Appium Desktop

5. **Maven / Gradle:**

    * Si usas Maven: Descargar Maven y añadir a PATH.

   * Si usas Gradle: Descargar Gradle y añadir a PATH.

6. **APK de la WDIO Dummy App:**

    * Descarga el archivo .apk desde la página de Lanzamientos de la WDIO Native Demo App. Asegúrate de descargar un archivo .apk de Android.
## 🚀 Instrucciones de Configuración
1. **Clone el Repositorio:**
2. **Instalar WDIO Dummy App:**

    * Start your Android Emulator or connect your physical Android device with USB Debugging enabled.

    * Install the downloaded .apk using ADB:

              adb install path/to/your/webdriverio-native-demo-app.apk

   * Verify the app is installed and visible on your device/emulator.

3. **Build the Project:**

    * **Usando Maven:**

              mvn clean install

    * **Usando Gradle:**

              gradle clean build

This will download all necessary dependencies and build your project.

## 📂 Estructura del Proyecto
```
your-repo-name/
├── src/
│   └── main/
│   └── test/
│       └── java/
│           └── com/globant/appWadio/
│               ├── screens/            # Clases Page Object Model para pantallas (e.g., DragScreen, FormsScreen, LoginScreen)
│               │   ├── DragScreen.java
│               │   ├── FormsScreen.java
│               │   ├── LoginScreen.java
│               │   ├── SplashScreen.java
│               │   ├── SwipeScreen.java
│               │   ├── TabMenu.java
│               │   └── WebviewScreen.java
│               ├── tests/              # Clases de prueba (e.g., LoginTest, MenuTest, SignUpTest, SwipeTest)
│               │   ├── LoginTest.java
│               │   ├── MenuTest.java
│               │   ├── SignUpTest.java
│               │   └── SwipeTest.java
│               └── utils/              # Clases utilitarias (BaseScreen, BaseTest)
│                   ├── BaseScreen.java
│                   └── BaseTest.java
├── target/
├── .gitignore
├── pom.xml
└── README.md
└── testng.xml                        # Configuración de TestNG
```
`screens/:` Contiene las clases Page Object Model para cada pantalla o componente principal de la aplicación, encapsulando interacciones y localizadores.

`tests/:` Contiene los casos de prueba reales, utilizando los objetos de página para realizar acciones y aserciones.

`utils/:` Contiene clases fundamentales como BaseScreen (para interacciones comunes de pantalla) y BaseTest (para la configuración/desmontaje de pruebas).

`testng.xml:` Archivo de configuración para TestNG, que permite definir suites de pruebas, pruebas paralelas, etc.
## ✅ Esenarios Automatizados
Este proyecto automatiza los siguientes escenarios según el documento de práctica:

1. Navegación en la Barra de Menú Inferior
    * **Precondición:** El usuario está en la pantalla de inicio (Home screen).

   * **Acción:** Navegar a cada sección (Webview, Login, Forms, Swipe, Drag) tocando sus respectivos íconos en la barra de menú inferior.

   * **Verificación:** Después de tocar en la sección del menú correspondiente, se deben realizar aserciones para verificar que todos los elementos esperados en las secciones respectivas se muestran correctamente (Verificar visibilidad y propiedades).

2. Registro Exitoso
    * **Precondición:** El usuario está en la sección de inicio de sesión (Login section).

   * **Acción:** Navegar a la sección de registro (Signup section). Rellenar todos los datos del formulario para registrarse (correo electrónico, contraseña, repetir contraseña).

   * **Consideración:** La generación de correos electrónicos asegura la repetibilidad de la prueba (por ejemplo, usando una cadena aleatoria o una marca de tiempo en el correo electrónico).

   * **Verificación:** Comprobar si el proceso de registro se completó con éxito (por ejemplo, verificando un mensaje de éxito o navegando a una pantalla de bienvenida).

3. Inicio de Sesión Exitoso
    * **Precondición:** El usuario está en la sección de inicio de sesión (Login section) y tiene un usuario creado previamente.

   * **Acción:** Navegar a la vista de inicio de sesión (Login View). Rellenar todos los datos del formulario para iniciar sesión (nombre de usuario/correo electrónico, contraseña).

   * **Verificación:** Comprobar si el proceso de inicio de sesión se completó con éxito (por ejemplo, verificando un mensaje de bienvenida o la navegación a un panel de control).

4. Deslizar Tarjetas en la Sección de Deslizamiento (Swipe)
    * **Precondición:** El usuario está en la sección de deslizamiento (Swipe section).

   * **Acción:**

     * Realizar gestos de "deslizamiento a la derecha" en las tarjetas horizontales.

     * Continuar deslizando hasta llegar a la última tarjeta.

     * Realizar gestos de "deslizamiento vertical" hasta encontrar un texto específico ("You found me!!!").

   * **Verificación:**

     * Después de cada "deslizamiento a la derecha", verificar que el contenido de la tarjeta "antigua" ya no es visible y que ha aparecido una nueva tarjeta.

     * Cuando se alcanza la última tarjeta, verificar que es la única tarjeta completamente visible en el carrusel.

     * Después del deslizamiento vertical, verificar que el texto "You found me!!!" está presente en la pantalla.
## 🏃 Como Ejecutar las Pruebas
1. **Iniciar el Servidor Appium:**

   * Abre Appium Desktop y haz clic en "Start Server".

   * O, ejecuta desde la línea de comandos: `appium`
     Asegúrate de que el servidor Appium se esté ejecutando en `http://127.0.0.1:4723`.

2. **Iniciar Emulador de Android / Conectar Dispositivo:**

   * Inicia tu Emulador de Android desde el Administrador de AVD de Android Studio.

   * O, asegúrate de que tu dispositivo físico esté conectado vía USB y que `adb devices` lo muestre.
3. **Run Tests:**

   * **Usando Maven:**
     Para ejecutar todas las pruebas:

            mvn clean test

    Para ejecutar una clase de prueba específica (por ejemplo, SwipeTest):

            mvn clean test -Dtest=SwipeTests

## ✨ Principios Clave de Diseño y Prácticas
* **Page Object Model (POM):** Todas las interacciones de pantalla y localizadores de elementos están encapsulados dentro de clases Page dedicadas, lo que mejora la legibilidad, reusabilidad y mantenibilidad del código.
* **Independencia de las Pruebas:** Cada caso de prueba está diseñado para ser autocontenido, gestionando sus propias precondiciones y limpieza, asegurando una ejecución confiable independientemente del orden.
* **Esperas Explícitas:** Se utiliza ampliamente `WebDriverWait` con `ExpectedConditions` para manejar elementos dinámicos y asegurar que los elementos estén presentes e interactuables antes de realizar acciones.
* **Localizadores Robustos:** Se utiliza una combinación de localizadores estables (`id`, `accessibility id`) y localizadores dinámicos (`uiAutomator` con `instance()`, `description`), elegidos en función de las propiedades únicas del elemento y la estabilidad en los diferentes estados de la aplicación.
* **Generación de Datos Aleatorios:** Para escenarios como el registro, se implementa la generación de correos electrónicos aleatorios para asegurar que las pruebas sean repetibles y evitar conflictos con los datos de usuarios existentes.

## ✍️ Author
**JeidKata**