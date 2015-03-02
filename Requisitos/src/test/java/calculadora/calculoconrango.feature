Feature: Calculo con rango de valores
  Scenario: Superando el valor inferior del rango
    Given Una calculadora a la que le especifico un rango de valores de operacion
    When hacemos una operacion que supera el limite inferior
    When hacemos una operacion que supera el limite superior
    Then la calculadora nos muestra un error