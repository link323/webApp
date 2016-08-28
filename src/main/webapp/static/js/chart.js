function drawChart(title, resultName, divName){
	google.charts.setOnLoadCallback(
			function () {
				var dataTable = google.visualization.arrayToDataTable(readData(resultName));
				var options = {
						title: title,
						curveType: 'function',
						legend: { position: 'bottom' }
				};
//				var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
				console.log($('#'+divName)[0]);
				var chart = new google.visualization.LineChart($('#'+divName)[0]);
				chart.draw(dataTable, options);
			});
}
function readData(resultName){
	var arrayData = [
	                 ['date', 'result']
	                 ];
	for(var i = 0; i< parseInt(document.getElementById("numberOfResults").value); i++){
		arrayData[arrayData.length] = [i+1, parseInt($('#'+resultName+i).val())];
	}

	return arrayData;
}
