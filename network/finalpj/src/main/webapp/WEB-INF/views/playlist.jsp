<script>
	function display(data) {
		var result = '';
		$(data)
				.each(
						function(idx, item) {
							result += '<figure class="col-lg-3 col-md-6 col-xs-12" itemprop="associatedMedia" itemscope itemtype="http://schema.org/ImageObject">';
							result += '<h5>';
							result += item.agency;
							result += ' - ';
							result += item.productname;
							result += '</h5>';
							result += item.adurl;
							result += '</figure>';

						});
		$('#playlist').html(result);
	};

	function getData() {
		$.ajax({
			url : 'playlistgetdata',
			dataType : "json",
			success : function(data) {
				display(data);
			},
			error : function(request, status, error) {
				alert("code:" + request.status + "\n" + "message:"
						+ request.responseText + "\n" + "error:" + error);
			}
		})
	};

	$(document).ready(function() {
		getData();
	});
</script>
	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-xs-12 mb-1">
					<h2 class="content-header-title">Advertising List</h2>
				</div>
				<div
					class="content-header-right breadcrumbs-right breadcrumbs-top col-md-6 col-xs-12">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="index.html">Home</a></li>
							<li class="breadcrumb-item"><a href="#">Gallery</a></li>
							<li class="breadcrumb-item active"></li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-body">
				<!-- Description -->

				<!-- Image grid -->
				<section id="image-gallery" class="card">
					<div class="card-header">
						<h4 class="card-title" style="display: inline;">Category [</h4>
						<h4 class="card-title" style="display: inline;">
							<a href="#">living</a> &nbsp;
						</h4>
						<h4 class="card-title" style="display: inline;">
							<a href="#">food</a> &nbsp;
						</h4>
						<h4 class="card-title" style="display: inline;">
							<a href="#">fashion</a> &nbsp;
						</h4>
						<h4 class="card-title" style="display: inline;">
							<a href="#">culture</a> &nbsp;
						</h4>
						<h4 class="card-title" style="display: inline;">
							<a href="#">etc</a>
						</h4>
						<h4 class="card-title" style="display: inline;">]</h4>
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
						<div class="card-block  my-gallery" itemscope
							itemtype="http://schema.org/ImageGallery">
							<div class="row" id="playlist"></div>
						</div>
						<!--/ Image grid -->

						<!-- Root element of PhotoSwipe. Must have class pswp. -->
						<div class="pswp" tabindex="-1" role="dialog" aria-hidden="true">

							<!-- Background of PhotoSwipe. 
             It's a separate element as animating opacity is faster than rgba(). -->
							<div class="pswp__bg"></div>

							<!-- Slides wrapper with overflow:hidden. -->
							<div class="pswp__scroll-wrap">

								<!-- Container that holds slides. 
                PhotoSwipe keeps only 3 of them in the DOM to save memory.
                Don't modify these 3 pswp__item elements, data is added later on. -->
								<div class="pswp__container">
									<div class="pswp__item"></div>
									<div class="pswp__item"></div>
									<div class="pswp__item"></div>
								</div>

								<!-- Default (PhotoSwipeUI_Default) interface on top of sliding area. Can be changed. -->
								<div class="pswp__ui pswp__ui--hidden">

									<div class="pswp__top-bar">

										<!--  Controls are self-explanatory. Order can be changed. -->

										<div class="pswp__counter"></div>

										<button class="pswp__button pswp__button--close"
											title="Close (Esc)"></button>

										<button class="pswp__button pswp__button--share" title="Share"></button>

										<button class="pswp__button pswp__button--fs"
											title="Toggle fullscreen"></button>

										<button class="pswp__button pswp__button--zoom"
											title="Zoom in/out"></button>

										<!-- Preloader demo http://codepen.io/dimsemenov/pen/yyBWoR -->
										<!-- element will get class pswp__preloader-active when preloader is running -->
										<div class="pswp__preloader">
											<div class="pswp__preloader__icn">
												<div class="pswp__preloader__cut">
													<div class="pswp__preloader__donut"></div>
												</div>
											</div>
										</div>
									</div>

									<div
										class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
										<div class="pswp__share-tooltip"></div>
									</div>

									<button class="pswp__button pswp__button--arrow--left"
										title="Previous (arrow left)"></button>

									<button class="pswp__button pswp__button--arrow--right"
										title="Next (arrow right)"></button>

									<div class="pswp__caption">
										<div class="pswp__caption__center"></div>
									</div>

								</div>

							</div>
						</div>
					</div>
					<!--/ PhotoSwipe -->
				</section>
				<!--/ Image grid -->
			</div>
		</div>
	</div>
<!-- BEGIN PAGE LEVEL JS-->
<script src="./resources/app-assets/js/scripts/gallery/photo-swipe/photoswipe-script.js" type="text/javascript"></script>
<!-- END PAGE LEVEL JS-->