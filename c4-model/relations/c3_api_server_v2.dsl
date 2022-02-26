# components -> api_gateway
client_apps -> api_gateway_v2 "" "JSON/HTTPS"
web_rtc -> api_gateway_v2 "" "JSON/HTTPS"
security_ms_v2 -> api_gateway_v2 "JWT"

# api gateway -> microservices
api_gateway_v2 -> security_ms_v2 "Żądanie uwierzytelnienia"
api_gateway_v2 -> registration_ms_v2
api_gateway_v2 -> booking_ms_v2
api_gateway_v2 -> meetings_ms_v2
api_gateway_v2 -> reviews_ms_v2
api_gateway_v2 -> courses_management_ms_v2
api_gateway_v2 -> tutor_profile_management_v2
api_gateway_v2 -> searching_ms_v2
api_gateway_v2 -> calendar_ms_v2
api_gateway_v2 -> chat_ms_v2

# microservices -> message_broker
registration_ms_v2 -> message_broker
booking_ms_v2 -> message_broker
meetings_ms_v2 -> message_broker
reviews_ms_v2 -> message_broker
courses_management_ms_v2 -> message_broker
tutor_profile_management_v2 -> message_broker
payment_ms_v2 -> message_broker
calendar_ms_v2 -> message_broker
chat_ms_v2 -> message_broker

# microservices -> database
security_ms_v2 -> database
registration_ms_v2 -> database
booking_ms_v2 -> database
meetings_ms_v2 -> database
reviews_ms_v2 -> database
courses_management_ms_v2 -> database
tutor_profile_management_v2 -> database
searching_ms_v2 -> database
calendar_ms_v2 -> database

# microservices -> external services
calendar_ms_v2 -> google_calendar "Komunikacja z API" "JSON/HTTPS"
payment_ms_v2 -> stripe "Komunikacja z API" "JSON/HTTPS"