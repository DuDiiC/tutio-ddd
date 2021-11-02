# api_gateway incoming
client_apps -> api_gateway "" "JSON/HTTPS"
web_rtc -> api_gateway "" "JSON/HTTPS"
authentication_ms -> api_gateway "JWT"

# api gateway outgoing
api_gateway -> authentication_ms "Żądanie uwierzytelnienia"
api_gateway -> registration_ms
api_gateway -> booking_ms
api_gateway -> courses_management_ms
api_gateway -> meetings_ms
api_gateway -> reviews_ms

# microservices inside server
meetings_ms -> reviews_ms ""

# message_broker incoming
authentication_ms -> message_broker "Publikuj"
registration_ms -> message_broker "Publikuj"
booking_ms -> message_broker "Publikuj"
meetings_ms -> message_broker "Publikuj"
reviews_ms -> message_broker "Publikuj"
