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
Coś podobne do Asany/Trello, bardziej zorientowane monitorowanie czasu który pochłonęło zadanie, a nie na pilnowanie dedlajnów. dodatkowo Gamification: możliwość dodawania nagród do poszczególnych zadań

```mermaid
---
title: YaSmart example
---
erDiagram
 USER ||--o{ REWARD : w_portfelu
 REWARD }o--|| CURRENCY : waluta
REWARD }o--|| CAMPAIGN : gives
REWARD }o--|| SCENARIO : gives
REWARD }o--|| TASK : gives
 USER ||--o{ CAMPAIGN : has
CAMPAIGN ||--o{ SCENARIO : has
SCENARIO ||--o{ TASK : has

 
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
}
```

killer
