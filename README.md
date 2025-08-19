# Patrones de Diseño - Sistema de Reservas

Este proyecto implementa un **sistema de reservas** utilizando diferentes **patrones de diseño en Java**.  
El objetivo es mostrar cómo aplicar patrones de diseño en un caso práctico: un sistema que gestiona reservas de hoteles, vuelos y autos, con opciones de pago y notificaciones.

## 🚀 Tecnologías utilizadas
- **Java 8+**
- IDE recomendado: **IntelliJ IDEA / Eclipse / NetBeans**
- Uso de **POO y patrones de diseño**

## 📂 Estructura del proyecto
```
PatronesDisenioManuelValdes/
│── src/
│   ├── Main.java                  # Clase principal
│   ├── SistemaReservas.java       # Clase central del sistema
│   ├── PruebasSistemasReservas.java # Casos de prueba
│
│── out/production/...             # Archivos compilados (.class)
│── Patrones de Diseño_Documentacion.pdf  # Documento explicativo
│── .gitignore
```

## 📖 Patrones de diseño implementados
- **Factory Method** → Creación de diferentes servicios de reserva.  
- **Builder** → Construcción de objetos `Reserva` de forma flexible.  
- **Command** → Encapsulación de solicitudes de reserva.  
- **Adapter** → Integración con reservadores externos.  
- **Decorator** → Extensión de reservas con seguros/extras.  
- **Observer** → Notificación de eventos (confirmaciones).  
- **Facade** → Interfaz simplificada para gestionar reservas.  

## ▶️ Ejecución
1. Clonar este repositorio:
   ```bash
   git clone <url-del-repo>
   ```
2. Abrir en tu IDE favorito.  
3. Compilar y ejecutar `Main.java`.  
4. Para pruebas adicionales, ejecutar `PruebasSistemasReservas.java`.

## 📌 Ejemplo de uso
- Reservar un hotel, vuelo o auto.  
- Agregar extras a la reserva (seguro, decoradores).  
- Realizar pagos con **tarjeta** o **PayPal**.  
- Recibir notificaciones de confirmación.  

## 👨‍💻 Autor
Proyecto desarrollado por **Manuel Valdés** como práctica de **Patrones de Diseño en Java**.  
