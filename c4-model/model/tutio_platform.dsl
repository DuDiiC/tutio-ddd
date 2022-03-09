tutio = softwareSystem "Platforma korepetycji online Tutio" "" "platform,tutio_white,black_stroke,intensive_blue_background,light_gray_font" {
    !include management_app.dsl
    !include client_apps.dsl
    !include api_server.dsl
    !include database.dsl
    !include message_broker.dsl
    !include web_rtc_service.dsl
}
