$('ul li .tabNavButton').click(function() {
  var target = $(this).data('target');
  $('.tab').hide();
  $('.tab#'+target).fadeIn();
});



