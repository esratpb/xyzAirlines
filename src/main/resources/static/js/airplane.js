$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip();
	$(function getAllAirplanes() {
        $.ajax({
            url: 'http://localhost:8080/api/airplane',
            type: 'GET',
            contentType: 'application/json',
            dataType: "json"
        }).done(function (data) {
        $.each(data,function(index,value){

                var row = '<tr>' +
                    '<td>'+value.id+'</td>' +
                    '<td>'+value.idPlate+'</td>' +
                    '<td>'+value.typeOfAirplane+'</td>'+
                    '<td>'+value.currentAirfield+'</td>'+
                    '<td>'+value.fuel+'</td>'+
                    '<td>'+value.airport.airportName+'</td>'+
                    '<td>'+value.airport.country+'</td>'+
                '</tr>';
            	$("table").append(row);

        })
        })
        });
	//  add new button click
    $("#addNewAirplane").click(function(){
    modalOpenClose();
    $('#addButton').click(function(){
    postAirport();
//    postAirportAndAirplane();
    })

    });
});

function modalOpenClose(){
// Get the modal
var modal = document.getElementById("edit_airplane_modal");

// Get the button that opens the modal
var btn = document.getElementById("addNewAirplane");

//// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
};
