workspace "Tutio" "Aplikacja korepetycji online" {

    model {

        # actors
        !include model/actors.dsl

        # elements
        !include model/tutio_platform.dsl
        !include model/external_services.dsl

        # relations
        !include relations/relations.dsl
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
