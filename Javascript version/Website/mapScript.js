console.log("hello darkness");
function myMap() {
  let myCenter = new google.maps.LatLng(55.822079900000006, 12.4352553)
  var mapProp = {
    center: myCenter,
    zoom: 14,
    mapTypeId: 'roadmap',
    disableDefaultUI: true,
  };
  var marker = new google.maps.Marker({
    position: myCenter,
    animation: google.maps.Animation.BOUNCE
  });

 


  var map = new google.maps.Map(document.getElementById("myMap"), mapProp);
  marker.setMap(map);
}


