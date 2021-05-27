$('document').ready(function () {
    $('.table #editButton').on('click', function (event) {
        event.preventDefault();
       // /countries/findById/?id = 1
        var href = $(this).attr('href');
        $.get(href, function (client, status) {
           $('#txtIdEdit').val(client.id );
           $('#txtNameEdit').val(client.name);
           $('#txtDetailsEdit').val(client.details);
           $('#txtWebsiteEdit').val(client.website);
           $('#txtAddressEdit').val(client.address);
           $('#ddlStateEdit').val(client.stateid);
           $('#ddlCountryEdit').val(client.countryid);
           $('#txtCityEdit').val(client.city);
           $('#txtPhoneEdit').val(client.phone);
           $('#txtMobileMobile').val(client.mobile);
           $('#txtEmailEdit').val(client.email);
        });
        $('#editModal').modal();
    });

    // $('.table #detailsButton').on('click', function (event) {
    //     event.preventDefault();
    //     var href = $(this).attr('href');
    //     $.get(href, function (client, status) {
    //         $('#idDetails').val(client.id);
    //         $('#ddlCountryDetails').val(client.countryid);
    //         $('#ddlStateDetails').val(client.stateid);
    //         $('#descriptionDetails').val(client.description);
    //         $('#cityDetails').val(client.city);
    //         $('#addressDetails').val(client.address);
    //         $('#detailsDetails').val(client.details);
    //         $('#lastModifiedByDetails').val(client.lastModifiedBy);
    //         //$('#lastModifiedDateDetails').val(client.lastModifiedDate.substr(0,19).replace("T", ""));
    //     });
    //     $('#detailsModal').modal();
    // });

    $('.table #deleteButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);
        $('#deleteModal').modal();
    })
});