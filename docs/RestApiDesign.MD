#Rest interface

##Vehicles

###Get list of vehicles

**GET /vehicles**

Optional parameter:
* Name: 'filter'
* Values: ['available'] ('available' will cause only the vehicle current available for hire to be returned)

Response type: application/json

| Field | Type | Description |
| ----- | ---- | ----------- |
| vehicle-id | number | unique vehicle identifier |
| registration-number | string | vehicle registration number | 
| category | string | one of 'small car', 'estate car' or 'van'
| make | string | vehicle make |
| model | string | vehicle model |
| fuel | string | type of fuel either 'petrol' or 'diesel' |
| hire-ends | date | the date the current hire ends, will be null if not currently hired |
| hired-by | string | name of customer currently hiring vehicle, will be null if not currently hired |

Return status:
* 200 Successful
* 500 Unhandled exception

Example:
```
Available for hire:
  {
  "registration-number": "PXG600S",
  "category": "van",
  "make": "Ford",
  "model": "Escort",
  "fuel": "petrol",
  "hire-ends": null,
  "hired-by": null
  }
```

```
Currently hired:
  {
  "registration-number": "PXG600S",
  "category": "van",
  "make": "Ford",
  "model": "Escort",
  "fuel": "petrol",
  "hire-ends": "2020-02-01",
  "hired-by": "Dave's Coaches"
  }
```

###Get cost of hire

**GET /vehicles/{vehicle-id}/cost-of-hire?from_date={from-date}&to_date={to-date}**
* {vehicle-id} the identifier returned from Get list of vehicles
* {from-date} the date for start of hire period (inclusive) in ISO format (eg 2021-01-01)
* {to-date} the date for the end of hire period (inclusive) in ISO format (eg 2021-01-04)

Response type: application/json

| Field | Type | Description |
| ----- | ---- | ----------- |
| cost | number | the cost of hire in pounds sterling |

Return status:
* 200 Successful
* 400 Invalid date range
* 404 Vehicle identifier not found
* 500 Unhandled exception

Example:
```
{ 
   "cost": 100 
}
```
