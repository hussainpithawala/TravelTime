$(document).ready(function() {
  var hideWidth = '-330px'; //width that will be hidden
  var collapsibleEl = $('#generalSearchPanel'); //collapsible element
  var buttonEl =  $("#collapsibleBtn"); //button inside element
    buttonEl.html('&laquo;');
    // collapsibleEl.css({'margin-left': hideWidth}); //on page load we'll move and hide part of elements
  
  $(buttonEl).click(function()
  {
    var curwidth = $(this).parent().offset(); //get offset value of the element
    if(curwidth.left>0) //compare margin-left value
    {
      //animate margin-left value to -490px
      $(this).parent().animate({marginLeft: hideWidth}, 300 );
      $(this).html('&raquo;'); //change text of button
      if($("#mainPanel").length) {
        $(mainPanel).addClass('mdl-cell mdl-cell--10-col').removeClass('mdl-cell mdl-cell--8-col');
      }
    }else{
      //animate margin-left value 0px
      $(this).parent().animate({marginLeft: "0"}, 300 );  
      $(this).html('&laquo;'); //change text of button
      if($("#mainPanel").length){
        $(mainPanel).addClass('mdl-cell mdl-cell--8-col').removeClass('mdl-cell mdl-cell--10-col');
      }
    }
  });

  $( function() {
    $( "#datepicker" ).datepicker();
    $( "#dep-date-input" ).datepicker();
    $( "#accordion" ).accordion({
      collapsible: true
    });
  } );


});
