workspace "Tutio" "Aplikacja korepetycji online" {

    !docs doc

    model {

        # actors
        !include model/actors.dsl

        # elements
        !include model/tutio_platform.dsl
        !include model/external_services.dsl

        # relations
        !include relations/c1.dsl
        !include relations/c2.dsl
        !include relations/c3_management_app.dsl
        !include relations/c3_client_apps.dsl
        !include relations/c3_api_server.dsl

        !include relations/c3_api_server_v2.dsl
    }

    views {

        theme default

        !include views.dsl

        styles {

            !include styles/shapes.dsl
            !include styles/colors.dsl
            !include styles/icons.dsl

        }
    }
}
