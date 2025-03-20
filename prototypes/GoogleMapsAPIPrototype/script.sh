source .env # Load the RapidAPI key

curl \
	-H "X-Goog-FieldMask: *" \
	-H "x-rapidapi-key: $RAPIDAPI_KEY" \
	-d '{"textQuery":"Amsterdam Airport Schiphol"}' \
    https://google-map-places-new-v2.p.rapidapi.com/v1/places:autocomplete 