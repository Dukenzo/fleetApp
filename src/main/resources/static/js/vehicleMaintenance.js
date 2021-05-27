$('document').ready(function () {
    $('.table #editButton').on('click', function (event) {
        event.preventDefault();
       // /countries/findById/?id = 1
        var href = $(this).attr('href');
        $.get(href, function (vehicleMaintenance, status) {
           $('#IdEdit').val(vehicleMaintenance.id );
           $('#ddlVehicleEdit').val(vehicleMaintenance.vehicleid );
           $('#StartDateEdit').val(vehicleMaintenance.startDate);
           $('#remarksEdit').val(vehicleMaintenance.remarks);
           $('#endDateEdit').val(vehicleMaintenance.endDate);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (vehicleMaintenance, status) {
            $('#idDetails').val(vehicleMaintenance.id);
            $('#descriptionDetails').val(vehicleMaintenance.description);
            $('#detailsDetails').val(vehicleMaintenance.details);
            $('#lastModifiedByDetails').val(vehicleMaintenance.lastModifiedBy);
            //$('#lastModifiedDateDetails').val(vehicleMaintenance.lastModifiedDate.substr(0,19).replace("T", ""));
        });
        $('#detailsModal').modal();
    });
    $('.table #deleteButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);
        $('#deleteModal').modal();
    })
});