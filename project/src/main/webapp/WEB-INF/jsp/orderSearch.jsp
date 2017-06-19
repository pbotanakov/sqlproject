<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form id="myForm" method="post" commandName="student">
		<fieldset>
			<legend>Order Search Form</legend>

			<div class="form-group">
				<label for="userNameInput" class="col-lg-3 control-label">User
					Name</label>
				<div class="col-lg-9">
					<form:input type="text" class="form-control" path="userName"
						id="userNameInput" placeholder="User Name" />
					<form:errors path="userName" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="type" class="col-lg-3 control-label">Type of order</label>
				<div class="col-lg-9">
					<form:input type="text" class="form-control" path="type"
						id="typeInput" placeholder="type" />
					<form:errors path="type" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="address" class="col-lg-3 control-label">Delivery Address</label>
				<div class="col-lg-9">
					<form:input type="text" class="form-control" path="address"
						id="addressInput" placeholder="Delivery Addres" />
					<form:errors path="address" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="product" class="col-lg-3 control-label">Orders Containing Product</label>
				<div class="col-lg-9">
					<form:input type="text" class="form-control" path="product"
						id="productInput" placeholder="Products" />
					<form:errors path="product" cssClass="error" />
				</div>
			</div>

			<div class="col-lg-9 col-lg-offset-3">
				<button class="btn btn-default">Cancel</button>

				<button class="btn btn-primary">Submit</button>
				<div id="themodal" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close">&times;</button>
								<h3>Signup Form Submission</h3>
							</div>
							<div class="modal-body">
								<p>Are you sure you want to do this?</p>
								<div class="progress progress-striped active">
									<div id="doitprogress" class="progress-bar"></div>
								</div>
							</div>
							<div class="modal-footer">
								<a href="#" class="btn btn-default">Close</a> <input
									type="submit" value="Yes" id="yesbutton"
									class="btn btn-primary">
							</div>
						</div>
					</div>
				</div>

			</div>

		</fieldset>
	</form:form>
		<script type="text/javascript">
		$(function() {
			var yesButton = $("#yesbutton");
			var progress = $("#doitprogress");

			yesButton.click(function() {
				yesButton.button("loading");
				var counter = 0;
				var countDown = function() {
					counter++;
					if (counter == 11) {
						yesButton.button("complete");
					} else {
						progress.width(counter * 10 + "%");
						setTimeout(countDown, 100);
					}
				};

				setTimeout(countDown, 100);
			});

		});
	</script>
</body>
</html>