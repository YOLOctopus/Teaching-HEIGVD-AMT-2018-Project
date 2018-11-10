<%@include file="includes/header.jsp" %>

<c:if test="${success}">
    <div class="alert alert-success" role="alert">
        Modifications saved
    </div>
</c:if>

<form action="pages/application" method="post">
    <div class="form-group">
        <label for="appname">Application name</label>
        <input class="form-control" id="appname" type="text" value="${application.getName()}" name="name">
    </div>
    <div class="form-group">
        <label for="appdesc">Description</label>
        <textarea class="form-control" id="appdesc" rows="5" name="description" id="description">${application.getDescription()}</textarea>
    </div>
    <div class="form-group">
        <label for="apikey">API Key</label>
        <input class="form-control" type="text" id="apikey" value="${application.getApiKey()}" readonly>
    </div>
    <div class="form-group">
        <label for="apisecret">API Secret</label>
        <input class="form-control" type="text" id="apisecret" value="${application.getApiSecret()}" readonly>
    </div>
    <input type="hidden" name="id" value="${application.getId()}">
    <button type="submit" class="btn btn-primary">Save changes</button>
    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#alertMessage">Delete application</button>
</form>

<div class="modal fade" id="alertMessage" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Are you sure?</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                This action cannot be undone.
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <form action="pages/applications" method="post">
                    <button type="submit" class="btn btn-danger" name="delete" value="${application.getId()}">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>


<%@include file="includes/footer.jsp" %>