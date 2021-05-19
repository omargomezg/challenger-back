# ☕️ Word Counter

> ℹ️ api generadora de textos

## ☝️ Dependencias

* Java 11
* Gradle (Wrapper incluido)

## 🏁 Instalación y ejecución

```bash
 ./gradlew bootRun
```

## El problema

En el repositorio actual se encontrará un microservicio que entregará un texto de forma aleatoria en el siguiente
formato

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

El objetivo es generar un api rest que sea capaz de recorrer las paginas del libro y entregar un ranking de las palabras
con mayor ocurrencia

Ejemplo respuesta basándose en el enunciado:

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

## ️⭐️ Desafio técnico

A continuación se encuentran las
[Instrucciones de desafío técnico](CONTRIBUTING.md)

