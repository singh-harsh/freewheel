var request = new XMLHttpRequest()

request.open('GET', 'http://localhost:8080/freewheel/stations', true)
request.onload = function () {
  var data = JSON.parse(this.response)

  if (request.status >= 200 && request.status < 400) {
  	const stationtableBody = document.getElementById('stations')
  	const result = document.getElementById('result')
    data.forEach((station) => {
      var tr = document.createElement('tr')
      var td_id = document.createElement('td')
      var idNode = document.createTextNode(station.stationId);
      td_id.appendChild(idNode)
      var td_name = document.createElement('td')
      var nameNode = document.createTextNode(station.stationName);
      td_name.appendChild(nameNode) 
      tr.appendChild(td_id)
      tr.appendChild(td_name)
      tr.style.cursor = "pointer"
      tr.id = station.stationId
      tr.addEventListener('click', function(){
      		result.innerHTML = "";
	    	getEarliestFlightDate(station.stationId, result);
		}, false);
      stationtableBody.appendChild(tr)      
    })
  } else {
    console.log('error')
  }
}
request.send()

function getEarliestFlightDate(id, result) {
		request.open('GET', 'http://localhost:8080/freewheel/programbystationid/' + id, true)
		request.onload = function () {
	 	 var data = this.response
	 	 if (request.status >= 200 && request.status < 400) {
	 	 	var span = document.createElement('h3')
	 	 	var resultNode = document.createTextNode("Earliest flight date for station id " + id + ": "  + data);
	 	 	span.appendChild(resultNode)
	 	 	result.appendChild(span)
	 	 }
	 	  else {
	    	console.log('error')
	  	}
	}
	request.send()
}



