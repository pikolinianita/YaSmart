# Pomysł 
pomysł na mały projekt. 
## Założenia
Wykonać projekt w Springu, przypomnieć sobie podstawy Springa i przerobic na nim kurs EAI
#### Cel:
- spring w zakresie EAI
- walidacja
- jpa
- front: Thymeleaf lub prosty Angular, do rozważenia
- testy
- cleancode
#### Opcjonalnie
- Security
- Security w Angularze
#### Nie-Cel
- dopieszczanie frontu
- spędzić zbyt dużo czasu na szczegółach
## Projekt
Coś podobne do Asany/Trello, bardziej zorientowane monitorowanie czasu który pochłonęło zadanie, a nie na pilnowanie dedlajnów. dodatkowo Gamification: możliwość dodawania nagród do poszczególnych zadań:
- 3 poziomy ważnośći Campaign > Scenario > Task
- Tasks są krótkie, trwają minuty do godziny
- za wykonanie Task, Scen,Camp są nagrody
- przy zaznaczeniu Tasku podaje się czas trwania
- Task view -> do edycji
- calendar view do patrzenia
  
<img src="./yasmart.png">


```mermaid
---
title: YaSmart example
---
%%{init: {'theme':'forest'}}%%
erDiagram
 USER ||--o{ CAMPAIGN : has
CAMPAIGN ||--o{ SCENARIO : has
SCENARIO ||--o{ TASK : has
 REWARD }o--|| CURRENCY : waluta
REWARD }o--|| CAMPAIGN : gives
REWARD }o--|| SCENARIO : gives
REWARD }o--|| TASK : gives
 USER ||--o{ REWARD : w_portfelu

    USER {
    string name
    String password
    List_REWARD wallet
    List_CAMPAIGN campaigns    
    }
REWARD {
    Currency kind
    int amount
    }
CURRENCY {
    String name
    }
CAMPAIGN{
string name
List_Scenario scenarios
List_Tag tags
time startTime
time endTime
List_Reward reward
STATE state
}
SCENARIO {
string name
List_Scenario scenarios
List_Tag tags
time startTime
time endTime
List_Reward reward
STATE state
}
TASK{
string name
List_Scenario scenarios
List_Tag tags
time startTime
time endTime
List_Reward reward
STATE state
}
TAG {
string name
}
STATE {
string state "toStart, inProgress, Finished"
Color color "RGB "
}

```

## Etapy
### 0.5
- Rest API do dodawania Task/Campaign/Scenario
- Odpytywanie DB do TaskView
- przesuwanie Scenario Z PLan -> DOing -> ToDo
- 1 Dummy user

### 0.7
- Front (Task View) do 0.5
  
### 0.9
- Rest API Edycja Task/Campaign
- Users
- User Panel

### 1.0
-Front  (Task View) do 0.9

## A potem:
### Route A
- Spring Security

### Route B
- calendar view
  
