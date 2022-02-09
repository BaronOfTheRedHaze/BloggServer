Ett inlägg består av
- En rubrik (title)
- Ett innehåll (body)
- Id
- Du får lägga till fler attribut om du vill


Checklista: Funktionalitet för Godkänt
Planering:
- [x] Du ska i serverkomponenten ha en fil som heter README.md där du
  listar minst 10 punkter med saker du behöver göra. Beskrivningarna
  kan vara korta men ska vara tydliga. Det ska tydligt gå att utläsa
  huruvida den punkten är avklarad eller inte.
- [x] Det är uppmuntrat att du använder dig av BDD-formuleringarna
  (”Given/when/then”)
  Serverkomponenten:
- [x] Servern ska använda sig av Spring-ramverket och det är i servern som alla
  blogginlägg sparas
- [x] Servern ska svara på API-förfrågningar för att lista inlägg, redigera inlägg, ta bort
  inlägg och visa specifikt inlägg.
- Adresserna till dessa API-förfrågningar ska vara följande:
    - /api/v1/blog/list – Lista alla inlägg
    - /api/v1/blog/view/<id> - Visa ett specifikt inlägg
    - /api/v1/blog/update/<id> - Visa ett specifikt inlägg
    - /api/v1/blog/delete/<id> - Ta bort ett specifikt inlägg
    - /api/v1/blog/create – Lägg till ett nytt inlägg
    - Fler får läggas till om du känner ett behov av det
- [x] Varje förfrågan måste använda en lämplig HTTP-metod (GET, POST, PATCH et
  cetera)
- [x] Din kod ska sparas i versionhantering med Git
  Klientkomponenten:
- [ ] Klientkomponenten ska vara ett textbaserat gränssnitt (CLI)
- [ ] Användaren ska kunna lista/lägga till/redigera/ta bort blogginlägg via APIförfrågningar till serverkomponenten
- [ ] Användaren ska kunna lista alla inlägg (ID och titel visas)
- [ ] Användaren ska kunna efterfråga ett specifikt inlägg och läsa innehållet
- [ ] Ingen information ska sparas i klienten
- [ ] Om användaren försöker visa, ta bort, redigera eller ändra ett inlägg som inte
  finns ska det visas ett tydligt felmeddelande
- [ ] Din kod ska sparas i versionshantering med Git