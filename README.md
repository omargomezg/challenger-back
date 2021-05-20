# ☕️ Word Counter (Desafío Banco Internacional)

> ℹ️ Api generadora de textos -> En este repositorio se encuentra un microservicio que generará los datos de entrada para el desafío

## ☝️ Dependencias

* Java 11
* Gradle (Wrapper incluido)

## 🚀 Instalación y ejecución

```bash
 ./gradlew bootRun
```

## 🏁 Objetivo

* Generar un proyecto que exponga un api rest (springboot) que de solución al problema expuesto a continuación
* Generar un proyecto frontend (React) que consuma y muestre los datos generados por el servicio construido

## El problema

En el repositorio actual se encontrará un microservicio que entregará un texto de forma aleatoria, con una cantidad de páginas ahi indicadas.
El objetivo es generar un api rest que sea capaz de recorrer las páginas del texto y entregar un ranking de las palabras
con mayor ocurrencia:

* Formato Entrada
```
GET http://localhost:8080/generator/word-counter/text

(Páginas posteriores)
GET http://localhost:8080/generator/word-counter/text?id=2&&page=1
```

```json
{
  "id": "2",
  "title": "Cinco semanas en globo",
  "page": 5,
  "total_pages": 5,
  "text": "La línea aérea ......."
}
```

* Ejemplo de respuesta (No necesariamente debe ser igual, ud puede considerar agregar o quitar información)

```json
{
  "id": "2",
  "title": "Cinco semanas en globo",
  "ranking": [
    {
      "position": 1,
      "word": "Palabra1",
      "occurrences": 7
    },
    {
      "position": 2,
      "word": "Palabra2",
      "occurrences": 6
    }
  ]
}
```

## ☝️ Puntos a evaluar

* Solución al problema indicado
* Código limpio y ordenado
* Estructura del proyecto
* Estrategia de commits
* Documentación
* Utilización de logs de trazabilidad
* Test

## ⭐️ Entrega Desafío técnico

A continuación se encuentran las
[Instrucciones para el envío del desafío técnico](CONTRIBUTING.md)

