# API

- /teams - POST: Add a new football team.
- /teams - GET: Retrieve all football teams.
- /teams/{id} - GET: Retrieve a specific football team by its ID.
- /teams/{id} - PUT: Update details of a specific football team.
- /teams/{id} - DELETE: Remove a football team.
- /teams/{teamId}/players - GET: Retrieve all players belonging to a specific team.

- /players - POST: Add a new player to a team.
- /players - GET: Retrieve all players.
- /players/{id} - GET: Retrieve a specific player by their ID.
- /players/{id} - PUT: Update details of a specific player.
- /players/{id} - DELETE: Remove a player from a team.

- /matches - POST: Schedule a new football match.
- /matches - GET: Retrieve all football matches.
- /matches/{id} - GET: Retrieve details of a specific match by its ID.
- /matches/upcoming - GET: Retrieve all upcoming football matches.
- /matches/results - GET: Retrieve results of past football matches.
- /matches/{id} - PUT: Update details of a specific football match.
- /matches/{id} - DELETE: Cancel a scheduled football match.

# Structura requesturilor

# Team

## /teams - POST

- Descriere: Adaugă o nouă echipă de fotbal.
- Cod de status: 201 Created
- Body cerere:

```json
{
  "name": "Echipa Nouă",
  "founded": "1920",
  "stadium": "Stadion Nou"
}
```

## /teams - GET

- Descriere: Returnează toate echipele de fotbal.
- Cod de status: 200 OK
- Structura JSON în răspuns:

```json
[
  {
    "id": 1,
    "name": "Echipa A",
    "founded": "1901",
    "stadium": "Stadion A"
  },
  {
    "id": 2,
    "name": "Echipa B",
    "founded": "1902",
    "stadium": "Stadion B"
  }
]
```

## /team/{id} - GET

- Descriere: Returnează o echipă specifică de fotbal pe baza ID-ului.
- Cod de status: 200 OK
- Structura JSON în răspuns:

```json
{
  "id": 1,
  "name": "Echipa A",
  "founded": "1901",
  "stadium": "Stadion A"
}
```

## /team/{id} - PUT

- Descriere: Actualizează detaliile unei echipe specifice de fotbal pe baza ID-ului său.
- Cod de status HTTP: 
  - 200 OK pentru actualizare reușită, 
  - 404 Not Found dacă echipa cu ID-ul specificat nu există.
- Structura corpului cererii:

```json
{
  "name": "Nume Echipă Actualizat",
  "founded": "Anul Fondării",
  "stadium": "Nume Stadion Actualizat"
}
```

- Structura corpului răspunsului:

```json
{
  "id": "ID-ul echipei actualizate",
  "name": "Nume Echipă Actualizat",
  "founded": "Anul Fondării",
  "stadium": "Nume Stadion Actualizat"
}
```

## /team/{id} - DELETE

- Descriere: Elimină o echipă de fotbal specifică pe baza ID-ului său.
- Cod de status HTTP: 
  - 204 No Content la ștergere reușită, 
  - 404 Not Found dacă echipa cu ID-ul specificat nu există.
- Răspuns: Această cerere, de obicei, nu are un corp al răspunsului. Codul de status indică rezultatul operațiunii.

## /teams/{teamId}/players - GET

- Descriere: Returnează toți jucătorii care aparțin unei echipe specifice de fotbal.
- Cod de status HTTP: 200 OK
- Structura corpului răspunsului:

```json
[
  {
    "id": 1,
    "name": "Nume Jucător 1",
    "position": "Poziția Jucătorului",
    "number": "Numărul Jucătorului",
    "teamId": "ID-ul echipei din care face parte jucătorul"
  },
  {
    "id": 2,
    "name": "Nume Jucător 2",
    "position": "Poziția Jucătorului",
    "number": "Numărul Jucătorului",
    "teamId": "ID-ul echipei din care face parte jucătorul"
  }
]
```

# Player

## /players - POST

- Descriere: Adaugă un nou jucător unei echipe.
- Cod de status HTTP: 201 Created
- Structura corpului cererii:

```json
{
  "name": "Nume Jucător Nou",
  "position": "Poziția Jucătorului",
  "teamId": "ID-ul echipei la care va fi adăugat"
}
```

## /players - GET

- Descriere: Returnează toți jucătorii.
- Cod de status HTTP: 200 OK
- Structura corpului răspunsului:

```json
[
  {
    "id": 1,
    "name": "Nume Jucător 1",
    "position": "Poziția Jucătorului",
    "teamId": "ID-ul echipei"
  },
  {
    "id": 2,
    "name": "Nume Jucător 2",
    "position": "Poziția Jucătorului",
    "teamId": "ID-ul echipei"
  }
]
```

## /player/{id} - GET

- Descriere: Returnează un jucător specific pe baza ID-ului său.
- Cod de status HTTP: 200 OK
- Structura corpului răspunsului:

```json
{
  "id": "ID-ul jucătorului",
  "name": "Nume Jucător",
  "position": "Poziția Jucătorului",
  "teamId": "ID-ul echipei din care face parte jucătorul"
}
```

## /player/{id} - PUT

- Descriere: Actualizează detaliile unui jucător specific pe baza ID-ului său.
- Cod de status HTTP: 
  - 200 OK pentru actualizare reușită, 
  - 404 Not Found dacă jucătorul cu ID-ul specificat nu există.
- Structura corpului cererii:

```json
{
  "name": "Nume Jucător Actualizat",
  "position": "Poziția Actualizată",
  "teamId": "ID-ul echipei actualizate"
}
```

- Structura corpului răspunsului:

```json
{
  "id": "ID-ul jucătorului actualizat",
  "name": "Nume Jucător Actualizat",
  "position": "Poziția Actualizată",
  "teamId": "ID-ul echipei actualizate"
}
```

## /player/{id} - DELETE

- Descriere: Elimină un jucător specific pe baza ID-ului său din echipă.
- Cod de status HTTP: 
  - 204 No Content la ștergere reușită, 
  - 404 Not Found dacă jucătorul cu ID-ul specificat nu există.
- Răspuns: Această cerere, de obicei, nu are un corp al răspunsului. Codul de status indică rezultatul operațiunii.

# Matches

## /matches - POST

- Descriere: Programează un nou meci de fotbal.
- Cod de status HTTP: 201 Created
- Structura corpului cererii:

```json
{
  "teamA": "Nume Echipa A",
  "teamB": "Nume Echipa B",
  "date": "Data Meciului",
  "location": "Locația Meciului"
}
```

## /matches - GET

- Descriere: Returnează toate meciurile de fotbal.
- Cod de status HTTP: 200 OK
- Structura corpului răspunsului:

```json
[
  {
    "id": 1,
    "teamA": "Nume Echipa A",
    "teamB": "Nume Echipa B",
    "date": "Data Meciului",
    "location": "Locația Meciului"
  },
  {
    "id": 2,
    "teamA": "Nume Echipa A",
    "teamB": "Nume Echipa B",
    "date": "Data Meciului",
    "location": "Locația Meciului"
  }
]
```

## /match/{id} - GET

- Descriere: Returnează detaliile unui meci specific pe baza ID-ului său.
- Cod de status HTTP: 200 OK
- Structura corpului răspunsului:

```json
{
  "id": "ID-ul Meciului",
  "teamA": "Nume Echipa A",
  "teamB": "Nume Echipa B",
  "date": "Data Meciului",
  "location": "Locația Meciului",
  "score": "Scorul Meciului (opțional)"
}
```

## /matches/upcoming - GET

- Descriere: Returnează toate meciurile viitoare de fotbal.
- Cod de status HTTP: 200 OK
- Structura corpului răspunsului:

```json
[
  {
    "id": 1,
    "teamA": "Nume Echipa A",
    "teamB": "Nume Echipa B",
    "date": "Data viitoare a meciului",
    "location": "Locația Meciului"
  }
]
```

## /matches/results - GET

- Descriere: Returnează rezultatele meciurilor trecute de fotbal.
- Cod de status HTTP: 200 OK
- Structura corpului răspunsului:

```json
[
  {
    "id": 1,
    "teamA": "Nume Echipa A",
    "teamB": "Nume Echipa B",
    "date": "Data Meciului",
    "location": "Locația Meciului",
    "score": "Scorul final al meciului"
  }
]
```

## /match/{id} - PUT

- Descriere: Actualizează detaliile unui meci de fotbal specific pe baza ID-ului său.
- Cod de status HTTP: 
  - 200 OK pentru actualizare reușită, 
  - 404 Not Found dacă meciul cu ID-ul specificat nu există.
- Structura corpului cererii:

```json
{
  "teamA": "Nume Echipa A Actualizat",
  "teamB": "Nume Echipa B Actualizat",
  "date": "Data Actualizată a Meciului",
  "location": "Locația Actualizată",
  "score": "Scorul Actualizat (opțional)"
}
```

## /match/{id} - DELETE

- Descriere: Anulează un meci de fotbal programat pe baza ID-ului său.
- Cod de status HTTP: 
  - 204 No Content la anulare reușită, 
  - 404 Not Found dacă meciul cu ID-ul specificat nu există.
- Răspuns: Această cerere, de obicei, nu are un corp al răspunsului. Codul de status indică rezultatul operațiunii.