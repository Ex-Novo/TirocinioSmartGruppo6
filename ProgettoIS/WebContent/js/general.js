$('input[type="submit"]').mousedown(function(){
  $(this).css('background', '#2ecc71');
});
$('input[type="submit"]').mouseup(function(){
  $(this).css('background', '#1abc9c');
});

$('#loginform').click(function(){
  $('.login').fadeToggle('slow');
  $(this).toggleClass('green');
});




$(document).mouseup(function (e)
{
    var container = $(".login");

    if (!container.is(e.target) // if the target of the click isn't the container...
        && container.has(e.target).length === 0) // ... nor a descendant of the container
    {
        container.hide();
        $('#loginform').removeClass('green');
    }
});

$('input[type="submit"]').mousedown(function(){
  $(this).css('background', '#2ecc71');
});
$('input[type="submit"]').mouseup(function(){
  $(this).css('background', '#1abc9c');
});

$('#registerform').click(function(){
  $('.register').fadeToggle('slow');
  $(this).toggleClass('green');
});

$('#registerform').click(function(){
  $('.A').fadeToggle('slow');
  $(this).toggleClass('green');
});

$(document).mouseup(function (e)
{
    var container = $(".register");

    if (!container.is(e.target) // if the target of the click isn't the container...
        && container.has(e.target).length === 0) // ... nor a descendant of the container
    {
        container.hide();
        $('#registerform').removeClass('green');
    }
});


function hideA()
{

    document.getElementById("A").style.visibility="hidden";
    document.getElementById("B").style.visibility="visible";    

}

function hideB()
{
    document.getElementById("B").style.visibility="hidden";
    document.getElementById("A").style.visibility="visible";

}

$(document).click(function(){
  $('#A').fadeIn('slow');
});