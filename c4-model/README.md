There is Tutio platform documentation, created in [C4 model](https://c4model.com/). Diagrams based on [DLS language](https://github.com/structurizr/dsl).

## Run

Structurizr Lite can be run locally in a Docker image. Based on [article](https://dev.to/simonbrown/getting-started-with-structurizr-lite-27d0), after cloning repository with `workspace.dsl` file

1. Clone Docker image:

        docker pull structurizr/lite

2. Create and run the container with repository location:

        docker run -d -p 8080:8080 -v REPO_PATH:/usr/local/structurizr --name CONTAINER_NAME structurizr/lite

Then, you can go http://localhost:8080 and explore the model locally.
