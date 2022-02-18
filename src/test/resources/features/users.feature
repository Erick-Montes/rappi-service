Feature: Servicio para crear un usuario

  @auto-createuser
  Scenario Outline: Validar los datos del usuario creado
    Given que el cliente accede al servicio
    When el ingresa su nombre <nombre> y posicion <posicion>
    Then el valida que su nombre <nombre> y su posicion <posicion> fueron creados correctamente
    Examples:
      | nombre | posicion |
      | Erick  | leader   |