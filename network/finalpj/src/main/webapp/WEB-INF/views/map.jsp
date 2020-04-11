<div id="map" style="width:1700px;height:1000px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e68bc7578d6d86ef183c2aff62c3ed4c"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(37.501306, 127.039639),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
	</script>

<!-- BEGIN PAGE LEVEL JS-->
<script src="./resources/app-assets/data/jqvmaps/jquery.vmap.sampledata.js" type="text/javascript"></script>
<!-- END PAGE LEVEL JS-->

