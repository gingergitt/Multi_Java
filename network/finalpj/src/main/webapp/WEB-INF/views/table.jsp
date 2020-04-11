<script>
	function display(data) {
		var result = '';
		$(data).each(function(idx, item) {
			result += '<tr>';
			result += '<td>';
			result += item.userid;
			result += '</td>';
			result += '<td>';
			result += item.userage;
			result += '</td>';
			result += '<td>';
			result += item.usergender;
			result += '</td>';
			result += '<td>';
			result += item.useremail;
			result += '</td>';
			result += '<td>';
			result += item.userphone;
			result += '</td>';
			result += '<td>';
			result += item.useragree;
			result += '</td>';
			result += '<td>';
			result += '<div class="dropdown">';
			result += '<button class="dropbtn">UserInterest</button>';
			result += '<div class="dropdown-content">';
			result += '<a href="#">living : ' + item.living + '</a>';
			result += '<a href="#">food : ' + item.food + '</a>';
			result += '<a href="#">fashion : ' + item.fashion + '</a>';
			result += '<a href="#">culture : ' + item.culture + '</a>';
			result += '<a href="#">etc: ' + item.etc + '</a>';
			result += '</div>';
			result += '</div>';
			result += '</td>';
			result += '</tr>';

		});
		$('#userid').html(result);
	};

	function getData() {
		$.ajax({
			url : 'tablegetdata',
			dataType : "json",
			success : function(data) {
				display(data);
			},
			error : function() {
				alert("fail");
			}
		})
	};

	$(document).ready(function() {
		getData();
	});
</script>

<style>
.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}
</style>

	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<div class="content-body">

				<!-- Table head options start -->
				<div class="row">
					<div class="col-xs-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">User List</h4>
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
								<div class="table-responsive">
									<table class="table">
										<thead class="thead-inverse">
											<tr>
												<th>ID</th>
												<th>AGE</th>
												<th>GENDER</th>
												<th>EMAIL</th>
												<th>PHONE</th>
												<th>AGREE</th>
												<th>INTREST</th>
											</tr>
										</thead>
										<tbody id="userid">
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Table head options end -->

			</div>
		</div>

	</div>