<%@ include file="/WEB-INF/views/public/header.jsp"%>

<div class="main_contents">
    <div id="sub_content">
        <form action="/pay/create" method="post">
            <h2 class="col-md-6 offset-md-2 mb-5 mt-4">Payment Create Page</h2>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="paymentType" class="col-md-2 col-form-label">Payment Type:</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="paymentType" name="paymentType" >
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <button type="submit" value="create" onclick="myfunction()">Create</button>
            </div>
        </form>
    </div>
</div>
<script>
    function myfunction() {
        var result=confirm("Successfully Create!");
        return result;

    }
</script>
<%@ include file="/WEB-INF/views/public/footer.jsp"%>

