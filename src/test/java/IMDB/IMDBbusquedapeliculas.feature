Feature: IMDB búsqueda de peliculas
  Scenario: Busqueda  por título
    Given I am in IMDB page
    When I search by title
    Then It displays movies by the title

  Scenario: Búsqueda por episodio
    Given I am in IMDB page
    When I search by episode
    Then It displays movies by episode

  #Scenario: Búsqueda  por género
  #  Given I am in IMDB page
  #  When I search by genre
  #  Then It displays movies by genre

  Scenario: Busqueda por compania
    Given I am in IMDB page
    When I search by company
    Then It displays movies by company

  Scenario: Búsqueda por palabra clave
    Given I am in IMDB page
    When I search by key word
    Then It displays movies by the key word


  Scenario: Busqueda por celebs
    Given I am in IMDB page
    When I search by celebs
    Then It displays movies by celebs

