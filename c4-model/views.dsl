# C1
systemLandscape "tutio_c1" {
    include *
}

# C2
container tutio "tutio_c2" {
    include *
}

# C3
component client_apps "tutio_c3_client_apps" {
    include *
}

# C3
component management_app "tutio_c3_management_app" {
    include *
}

# C3
component api_server "tutio_c3_api_server" {
    include *
}
