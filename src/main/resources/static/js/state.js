$('document').ready(function () {
    $('table .btn-primary').on('click', function (event) {
        event.preventDefault();
       // /countries/findById/?id = 1
        var href = $(this).attr('href');
        $.get(href, function (state, status) {
           $('#idEdit').val(state.id );
           $('#ddlCountryEdit').val(state.countryid);
           $('#capitalEdit').val(state.capital);
           $('#codeEdit').val(state.code);
           $('#nameEdit').val(state.name);
           $('#detailsEdit').val(state.details);
        });
        $('#editModal').modal();
    });

    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (state, status) {
            $('#idDetails').valid(state.id);
            $('#ddlCountryDetails').valid(state.countryid);
            $('#nameDetails').valid(state.name);
            $('#detailsDetails').valid(state.details);
            $('#lastModifiedByDetails').valid(state.lastModifiedBy);
            $('#lastModifiedDateDetails').valid(state.lastModifiedDate.substr(0,19).replace("T", ""));
        });
        $('#detailsModal').modal();
    });
    $('.table #detailsButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    })
});