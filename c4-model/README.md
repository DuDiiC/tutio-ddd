# Platforma nauczania online Tutio - diagramy architektury w modelu C4

Katalog zawiera diagramy architektury, stworzone w [modelu C4](https://c4model.com/), z użyciem narzędzia [Structurizr](https://structurizr.com/), w [skryptowym języku DSL](https://github.com/structurizr/dsl).

Projekt zawiera 5 diagramów:

- C1 - diagram kontekstu całej platformy Tutio,
- C2 - diagram kontenerów całej platformy Tutio,
- C3 - diagram komponentów aplikacji serwerowej platformy,
- C3 - diagram komponentów aplikacji klienckich platformy,
- C3 - diagram komponentów aplikacji administracyjnych platformy.

Wszystkie wyżej wymienione diagramy, znajdują się w katalogu [`/exported`](/exported), jako grafiki wektorowe w formacie `.pdf`.

## Uruchomienie

Dzięki udostępnionemu obrazowi dockerowemu narzędzie Structurizr Lite, możliwe jest uruchomienie Structurizr lokalnie, w kontenerze dockerowym. Bazując na [artykule](https://dev.to/simonbrown/getting-started-with-structurizr-lite-27d0):

1. Pobranie obrazu dockerowego:

```bash
docker pull structurizr/lite
```

2. Stworzenie i uruchomienie kontenera w katalogu projektu `/c4-model`:

```bash
docker run -d -p 8080:8080 -v REPO_PATH:/usr/local/structurizr --name CONTAINER_NAME structurizr/lite
```

Dostęp do narzędzia odbywa się przez przeglądarkę internetową, pod adresem http://localhost:8080.
