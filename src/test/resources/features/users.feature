@Api-user
Feature: Servicio para crear un usuario

  @auto-createuser
  Scenario Outline: Validar los datos del usuario creado
    Given que el cliente accede al servicio
    When el ingresa su nombre <nombre> y posicion <posicion>
    Then el valida que su nombre <nombre> y su posicion <posicion> fueron creados correctamente
    Examples:
      | nombre | posicion |
      | Erick  | qa   |

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-3
  @manual-test-evidence:[PASSED](assets/CDPM091.003.png)
  @complejidad:media
  @tiempo_ejecucion:5m
  Scenario: Prueba escenario manual
    Given que el se encuentra en el modal del login
    When el ingresa su celular 969929151 y su dni 76503293
    Then el logra ingresar a la plataforma