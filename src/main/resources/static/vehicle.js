const app = new Vue({
    el: '#app',
    data: {
        vehicles: [],
        fromDate: "2021-01-01", //TODO set to tomorrow
        toDate: "2021-01-05" //TODO set to tomorrow + 7 days
    },
    methods: {
        fetch: function(event) {
                var url = 'http://localhost:8080/vehicles'
                if (!event.target.checked) {
                    url = url + '?filter=available'
                }
                fetch(url)
                    .then(response => response.json())
                    .then(json => {
                        this.vehicles = json
                    })
        },
        getCostOfHire: function(event) {
            fetch('http://localhost:8080/vehicles/' + event.target.id + '/cost-of-hire?from_date=' + this.fromDate + '&to_date=' + this.toDate)
                    .then(response => response.json())
                    .then(json => {
                          alert('The cost of hiring a this vehicle from ' + this.fromDate + ' to ' + this.toDate + ' will be £' + json.cost)
                    })
        }
    },
    created() {
        fetch('http://localhost:8080/vehicles?filter=available')
            .then(response => response.json())
            .then(json => {
                this.vehicles = json
            })
    }
})
