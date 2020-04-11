<body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">
	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-xs-12 mb-1">
					<h2 class="content-header-title"></h2>
				</div>
				<div
					class="content-header-right breadcrumbs-right breadcrumbs-top col-md-6 col-xs-12">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="index.html">Home</a></li>
							<li class="breadcrumb-item"><a href="#">Chartjs</a></li>
							<li class="breadcrumb-item active">Line Chart</li>
							<a href="logging">logging start</a>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-body">
				<!-- line chart section start -->
				<section id="chartjs-line-charts">
					<!-- Line Chart -->
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">current state of advertising contract</h4>
									<a class="heading-elements-toggle"><i
										class="icon-ellipsis font-medium-3"></i></a>
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
									<div class="card-block chartjs">
										<canvas id="line-chart" height="500"></canvas>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>

				<section id="chartjs-bar-charts">
					<!-- Bar Chart -->
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">Bar Chart</h4>
									<a class="heading-elements-toggle"><i
										class="icon-ellipsis font-medium-3"></i></a>
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
										<canvas id="bar-chart" height="400"></canvas>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>

				<section id="chartjs-pie-charts">
					<div class="row">
						<!-- Simple Pie Chart -->
						<div class="col-md-6 col-sm-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">Simple Pie Chart</h4>
									<a class="heading-elements-toggle"><i
										class="icon-ellipsis font-medium-3"></i></a>
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
										<canvas id="simple-pie-chart" height="400"></canvas>
									</div>
								</div>
							</div>
						</div>

						<!-- Simple Doughnut Chart -->
						<div class="col-md-6 col-sm-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">Simple Doughnut Chart</h4>
									<a class="heading-elements-toggle"><i
										class="icon-ellipsis font-medium-3"></i></a>
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
										<canvas id="simple-doughnut-chart" height="400"></canvas>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>

				<!-- // line chart section end -->
			</div>
		</div>
	</div>
	<!-- ////////////////////////////////////////////////////////////////////////////-->
</body>
<!-- BEGIN PAGE LEVEL JS-->
<script src="./resources/app-assets/js/scripts/charts/chartjs/line/line.js" type="text/javascript"></script>
<script src="./resources/app-assets/js/scripts/charts/chartjs/bar/bar.js" type="text/javascript"></script>
<script src="./resources/app-assets/js/scripts/charts/chartjs/pie-doughnut/pie-simple.js" type="text/javascript"></script>
<script src="./resources/app-assets/js/scripts/charts/chartjs/pie-doughnut/doughnut-simple.js" type="text/javascript"></script>
<!-- END PAGE LEVEL JS-->