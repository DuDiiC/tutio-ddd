# Online learning platform Tutio - architecture diagrams in the C4 model

The catalog contains architecture diagrams, created in the [C4 model](https://c4model.com/, using the [Structurizr](https://structurizr.com/) tool, in a [DSL scripting language](https:/github.com/structurizr/dsl).

The project includes 5 diagrams:

- C1 - context diagram of the entire Tutio platform,
- C2 - container diagram of the entire Tutio platform,
- C3 - diagram of the platform's server application components,
- C3 - diagram of the platform's client application components,
- C3 - diagram of the platform's administration application components.

All the above-mentioned diagrams are located in the [`/exported`](exported/) directory, as vector graphics in `.pdf` format.

## Creation and launch of a container

Thanks to the shared Docker image of the Structurizr Lite tool, it is possible to run Structurizr locally, as a Docker container. Based on the [article](https://dev.to/simonbrown/getting-started-with-structurizr-lite-27d0):

1. Downloading the Docker image:

```bash
docker pull structurizr/lite
```

2. Creating and launching a container in the project directory `/c4-model`:

```bash
docker run -d -p 8080:8080 -v REPO_PATH:/usr/local/structurizr --name CONTAINER_NAME structurizr/lite
```

The tool is accessed via a web browser at http://localhost:8080.
