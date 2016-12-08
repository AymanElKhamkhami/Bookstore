//////////////////////JQuery:


$(document).ready(function() {

    //Pour cacher les messages d'avertissement
    //document.getElementById("bg").style.display = 'none';
    $("#editBox").hide();
    $("#bg").hide();

    /*
     $('#editBtn').click(function() {
     $('#editBox').show();
     $('#bg').show();
     
     
     });*/
    
    $('#close').click(function() {
        $('#editBox').fadeOut(250);
        $('#bg').fadeOut(250);
    });

    $('#bg').click(function() {
        $('#editBox').fadeOut(250);
        $('#bg').fadeOut(250);
    });
/*
    $('#saveEdit').click(function() {
        $('#editBox').fadeOut(250);
        $('#bg').fadeOut(250);
    });
*/

});
	