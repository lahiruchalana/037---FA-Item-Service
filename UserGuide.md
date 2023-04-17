##Use Below Instructions To Make Requests

### When do you need to access to Set<> valued properties of the food entity, you should need to do it in that Set<> property values.

GET methods for food will not support for Set<> values

To access to Set<> values you should need to go to that property

### api/food/send

{
"name": "Pizza"
}

### api/food/id/{foodId}/add/additive

{
"listOfAdditives": "Hg45, FTY564, Ihg78, K567"
}

### api/id/{foodId}/addOrUpdate/smellTasteTexture

{
"smell": {
"smellName": "Onion and Garlic smell"
},
"taste": {
"listOfTaste": "Saltines and Umami"
},
"texture": {
"listOfTexture": "Crunchiness"
}
}