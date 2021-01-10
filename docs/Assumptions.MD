#Assumptions:

The Technical Task requires REST services that:
1.	List available vehicles for hire – all vehicles that can be hired today.
2.	Calculate cost of hiring a specific vehicle for a provided date range.

But the UI requires that vehicles that are already hired can also be shown.

_Assumption 1:_ I assume that it's ok to include this is the REST interface.

In the UI requirement there is 'A mechanism where the user can select a specific vehicle with a start and end date and
then a means to call the calculation REST service, with the result displayed.'

Does this mean either:
1. that the user needs to be able to select vehicles based on start and end data ?
2. for any selected vehicle the user can calculate cost of hiring based on start and end data ?

_Assumption 2:_ I am assuming is the second option.