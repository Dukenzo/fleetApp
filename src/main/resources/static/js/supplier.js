$('document').ready(function () {
    $('.table #editButton').on('click', function (event) {
        event.preventDefault();
       // /countries/findById/?id = 1
        var href = $(this).attr('href');
        $.get(href, function (supplier, status) {
           $('#txtIdEdit').val(supplier.id );
           $('#txtNameEdit').val(supplier.name);
           $('#txtDetailsEdit').val(supplier.details);
           $('#txtWebsiteEdit').val(supplier.website);
           $('#txtAddressEdit').val(supplier.address);
           $('#ddlStateEdit').val(supplier.stateid);
           $('#ddlCountryEdit').val(supplier.countryid);
           $('#txtCityEdit').val(supplier.city);
           $('#txtPhoneEdit').val(supplier.phone);
           $('#txtMobileMobile').val(supplier.mobile);
           $('#txtEmailEdit').val(supplier.email);
        });
        $('#editModal').modal();
    });

    // $('.table #detailsButton').on('click', function (event) {
    //     event.preventDefault();
    //     var href = $(this).attr('href');
    //     $.get(href, function (supplier, status) {
    //         $('#idDetails').val(supplier.id);
    //         $('#ddlCountryDetails').val(supplier.countryid);
    //         $('#ddlStateDetails').val(supplier.stateid);
    //         $('#descriptionDetails').val(supplier.description);
    //         $('#cityDetails').val(supplier.city);
    //         $('#addressDetails').val(supplier.address);
    //         $('#detailsDetails').val(supplier.details);
    //         $('#lastModifiedByDetails').val(supplier.lastModifiedBy);
    //         //$('#lastModifiedDateDetails').val(supplier.lastModifiedDate.substr(0,19).replace("T", ""));
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