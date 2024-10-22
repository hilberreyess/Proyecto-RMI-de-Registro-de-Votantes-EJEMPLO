# Proyecto RMI de Registro de Votantes

Este es un ejemplo de un proyecto RMI (Remote Method Invocation) que simula un sistema de registro de votantes. El proyecto permite a los usuarios registrar su información de votación de manera remota a través de una interfaz de usuario sencilla. El sistema se compone de dos componentes principales: el servidor RMI y el cliente RMI.

## Componentes del Proyecto

### Servidor RMI
- **Funcionalidad**: Actúa como el servidor que gestiona el registro de votantes. Permite que los clientes se conecten y realicen operaciones relacionadas con el registro.
- **Tecnologías**: Java RMI, interfaz remota, implementación de la lógica de negocio.
- **Características**: Registro de votantes, verificación de votantes ya registrados y gestión de datos.

### Cliente RMI
- **Funcionalidad**: Proporciona una interfaz para que los usuarios interactúen con el sistema de registro de votantes. Permite a los usuarios ingresar sus datos y consultar su estado de votación.
- **Tecnologías**: Java RMI, manejo de excepciones, conexión remota al servidor.
- **Características**: Ingreso de datos del votante, consulta de estado de registro y manejo de errores.

## Cómo Ejecutar el Proyecto

1. **Compilar y ejecutar el servidor RMI**: Asegúrate de que el servidor esté corriendo antes de iniciar el cliente.
2. **Compilar y ejecutar el cliente RMI**: Inicia el cliente para interactuar con el servidor.
3. **Interacción**: Los usuarios pueden registrar sus datos y consultar su estado de votación a través de la interfaz del cliente.

## Requisitos

- JDK 8 o superior
- Configuración adecuada del entorno de red para permitir conexiones RMI

## Contribuciones

Si deseas contribuir a este proyecto, siéntete libre de hacer un fork del repositorio y enviar un pull request con tus mejoras.
