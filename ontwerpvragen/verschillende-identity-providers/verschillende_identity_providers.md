# (Interoperability) Hoe kunnen we verschillende identity providers met verschillende interfaces integreren voor het gehele systeem?

## Componenten

| Component       | Naam                      | Verantwoordelijkheid                             |
| --------------- | ------------------------- | ------------------------------------------------ |
| LoginController | API-verzoeken afhandelaar | Omgaan met inkomende en uitgaande HTTP-verzoeken |
| LoginService    | Kern                      | De kernfunctionaliteit uitvoeren                 |
| LoginRepository | Data afhandelaar          | Persistente data ophalen en opslaan              |

## Interfaces

| Interface         | Methode                                                      | Returnwaarde     |
| ----------------- | ------------------------------------------------------------ | ---------------- |
| `LoginController` | `login(String authorizationCode)`                            | `ResponseEntity` |
| `LoginService`    | `authorizationCodeToIdentityToken(String authorizationCode)` | `IdentityToken`  |
| `LoginRepository` | `getUser(IdentityToken identityToken)`                       | `User`           |
| `LoginRepository` | `saveUser(User user)`                                        | `void`           |

## Dynamic diagram met componenten

[Dynamic diagram met componenten](./dynamic_diagram_met_componenten.puml)

## Class diagram

[Class diagram](./class_diagram.puml)
