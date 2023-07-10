#language: es
@Google
Característica: Realizar una búsqueda en Google


  @BusquedaCiudad @HAPPY
  Esquema del escenario: Busco en Google una ciudad de Perú doy click al primer resultado y salgo de Google
    Dado que abro Google
    Cuando escribo "<Ciudad>"
    Y accedo al primer resultado
    Entonces valido que salí de Google
    Ejemplos:
      | Ciudad   |
      | Trujillo |
      | Lima     |
