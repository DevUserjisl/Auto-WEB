Feature:Registro y login en la web PARABANK

  @RegistroParaBank
  Scenario Outline: Un usuario se registra exitosamente y accede a su cuenta
    Given que el usuario accede a la web de Parabank
    When navega al formulario de registro de nuevos usuarios
    And proporciona sus datos personales:
      | firstName   | lastName   | address   | city   | state   | zipCode   | phone   | ssn   | username   | password   |
      | <firstName> | <lastName> | <address> | <city> | <state> | <zipCode> | <phone> | <ssn> | <username> | <password> |
    And completa el proceso de registro con la información ingresada
    And que el usuario accede a la web de Parabank para loguearse
    Then debería poder iniciar sesión correctamente con las credenciales registradas
    Examples:
      | firstName | lastName | address | city  | state | zipCode | phone | ssn   | username | password |
      | faker     | faker    | faker   | faker | faker | faker   | faker | faker | faker    | faker    |
