<script>

function Sendfcm(ip, idx)
{      
		var speed = $("#speed"+idx).val();

			$.ajax({
				url: "fcm",
				type: "POST",
				dataType:"json",	
				data:{"speed":speed, "ip":ip},
	         
	  			success: function(result){
	  		
	  	 		}
		});
};

	function display(data) {
		var result = '';
		$(data).each(function(idx, item) {			
			result += '<tr>';
			result += '<td class="text-truncate">';
			result += '<input type="hidden" value = "'+item.ip+'" id = "'+idx+'">';
			result += item.ip;
			result += '</td>';
			result += '<td class="text-truncate"><span class="tag tag-success">Low</span></td>';
			result += '<td class="valign-middle">';
			result += '<input type="text" class="form-control" id="speed'+idx+'">';
			result += '</td>';
			result += '<td class="text-truncate">';												  		
			result += '<button class="btn bg-info bg-darken-3 mr-1 white" onclick="Sendfcm('+"'"+ item.ip+"'"+','+idx+');">Send</button>';
			result += '</td>';
			result += '</tr>';
		});
		$('#clientip').html(result);
	};

	function getData() {
		$.ajax({
			url : 'clientgetdata',
			dataType : "json",
			success : function(data) {
				display(data);
			},
			error : function() {
				console.log("fail");
			}
		})
	};

	$(document).ready(function() {
		setInterval(getData,10000);

	});
	
</script>
        
    <div class="app-content content container-fluid">
      <div class="content-wrapper">
        <div class="content-header row">
        </div>
        <div class="content-body"><!-- Statistics -->
<div class="row">
    <div class="col-xl-3 col-lg-6 col-xs-12">
        <div class="card">
            <div class="card-body">
                <div class="media">
                    <div class="p-2 text-xs-center bg-cyan bg-darken-2 media-left media-middle">
                        <i class="icon-user1 font-large-2 white"></i>
                    </div>
                    <div class="p-2 bg-cyan white media-body">
                        <h5>Connect Client</h5>
                        <div id="clientnum"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xl-3 col-lg-6 col-xs-12">
        <div class="card">
            <div class="card-body">
                <div class="media">
                    <div class="p-2 text-xs-center bg-deep-orange bg-darken-2 media-left media-middle">
                        <i class="icon-user1 font-large-2 white"></i>
                    </div>
                    <div class="p-2 bg-deep-orange white media-body">
                        <h5>New Client</h5>
                        <h5 class="text-bold-400"></h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xl-3 col-lg-6 col-xs-12">
        <div class="card">
            <div class="card-body">
                <div class="media">
                    <div class="p-2 text-xs-center bg-teal bg-darken-2 media-left media-middle">
                        <i class="icon-cart font-large-2 white"></i>
                    </div>
                    <div class="p-2 bg-teal white media-body">
                        <h5>New Orders</h5>
                        <h5 class="text-bold-400"></h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xl-3 col-lg-6 col-xs-12">
        <div class="card">
            <div class="card-body">
                <div class="media">
                    <div class="p-2 text-xs-center bg-pink bg-darken-2 media-left media-middle">
                        <i class="icon-banknote font-large-2 white"></i>
                    </div>
                    <div class="p-2 bg-pink white media-body">
                        <h5>Total Profit</h5>
                        <h5 class="text-bold-400"></h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--/ Statistics -->

<!--/ project charts -->
<section id="google-bar-charts">

    <!-- Stacked Bar Chart -->
    <div class="row">
        <div class="col-xs-12">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">Stacked Bar Chart</h4>
                    <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
                    <div class="heading-elements">
                        <ul class="list-inline mb-0">
                            <li><a data-action="collapse"><i class="icon-minus4"></i></a></li>
                            <li><a data-action="reload"><i class="icon-reload"></i></a></li>
                            <li><a data-action="expand"><i class="icon-expand2"></i></a></li>  
                            <li><a data-action="close"><i class="icon-cross2"></i></a></li>
                        </ul>
                    </div>
                </div>
                <div class="card-body collapse in">
                    <div class="card-block">
                        <p class="card-text">A stacked bar chart is a bar chart that places related values atop one another. If there are any negative values, they are stacked in reverse order below the chart's axis baseline. Stacked bar charts are typically used when a category naturally divides into components. For instance, consider some hypothetical book sales, divided by genre and compared across time:</p>
                        <div id="stacked-bar-chart"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>
<!--/ project charts -->

<!-- projects table with monthly chart -->
<div class="row">

        <div class="col-xl-4 col-md-6 col-sm-12">
        <div class="card">
            <div class="card-body">
                <div class="card-block">
                    <h4 class="card-title">Video Embed</h4>
                    <h6 class="card-subtitle text-muted">Support card subtitle</h6>
                </div>
                <div class="embed-responsive embed-responsive-item embed-responsive-16by9">
                    <iframe class="img-thumbnail" src="https://www.youtube.com/embed/SsE5U7ta9Lw?rel=0&amp;controls=0&amp;showinfo=0" allowfullscreen=""></iframe>
                </div>
                <div class="card-block">
                    <p class="card-text">Candy cupcake sugar plum oat cake wafer marzipan jujubes lollipop macaroon. Cake dragée jujubes donut chocolate bar chocolate cake cupcake chocolate topping. Dessert jelly beans toffee muffin.</p>
                    <a href="#" class="card-link">Card link</a>
                    <a href="#" class="card-link">Another link</a>
                </div>
            </div>
        </div>
    </div>

    <div class="col-xl-8 col-lg-12">
        <div class="card">
            <div class="card-header">
                <h4 class="card-title">Ongoing Projects</h4>
                <a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
                <div class="heading-elements">
                    <ul class="list-inline mb-0">
                        <li><a data-action="reload"><i class="icon-reload"></i></a></li>
                        <li><a data-action="expand"><i class="icon-expand2"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="card-body">
                <div class="card-block">
                    <p class="m-0">Total ongoing projects 6<span class="float-xs-right"><a href="#" target="_blank">Project Summary <i class="icon-arrow-right2"></i></a></span></p>
                </div>
                <div class="table-responsive">
                    <table class="table table-hover mb-0">
                        <thead>
                            <tr>
                                <th>IP</th>
                                <th>Priority</th>
                                <th>SPEED</th>
                                <th>Send</th>
                            </tr>
                        </thead>
                        <tbody id = "clientip">


                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</div>

<!-- BEGIN PAGE LEVEL JS-->
<script src="https://www.google.com/jsapi" type="text/javascript"></script>
<script src="./resources/app-assets/js/scripts/charts/google/bar/bar-stacked.js" type="text/javascript"></script>
<!-- END PAGE LEVEL JS-->


