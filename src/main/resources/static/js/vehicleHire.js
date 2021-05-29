$('document').ready(function() {

    $('.table .btn-primary').on('click',function(event){
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(vehicleHire, status){
            $('#idEdit').val(vehicleHire.id);
            $('#ddlVehicleEdit').val(vehicleHire.vehicleid);

            $('#timeInEdit').val(vehicleHire.timeIn);
            $('#timeOutEdit').val(vehicleHire.timeOut);

            $('#ddlLocationEdit').val(vehicleHire.locationid);
            $('#priceEdit').val(vehicleHire.price);
            $('#ddlClientEdit').val(vehicleHire.clientid);

            var dateIn = vehicleHire.dateIn.substr(0,10);
            var dateOut = vehicleHire.dateOut.substr(0,10);
            $('#dateInEdit').val(dateIn);
            $('#dateOutEdit').val(dateOut);

            $('#remarksEdit').val(vehicleHire.remarks);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click',function(event) {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(vehicleHire, status){
            $('#idDetails').val(vehicleHire.id);
            $('#ddlClientDetails').val(vehicleHire.clientid);

            var dateIn = vehicleHire.dateIn.substr(0,10);
            var dateOut = vehicleHire.dateOut.substr(0,10);
            $('#dateInDetails').val(vehicleHire.dateIn);
            $('#dateOutDetails').val(vehicleHire.dateOut);
            $('#ddlLocationDetails').val(vehicleHire.locationid);
            $('#priceDetails').val(vehicleHire.price);
            $('#remarksDetails').val(vehicleHire.remarks);
            $('#ddlVehicleDetails').val(vehicleHire.vehicleid);
            $('#lastModifiedByDetails').val(vehicleHire.lastModifiedBy);
            $('#lastModifiedDateDetails').val(vehicleHire.lastModifiedDate.substr(0,19).replace("T", " "));
        });
        $('#detailsModal').modal();
    });

    $('.table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #confirmDeleteButton').attr('href', href);
        $('#deleteModal').modal();
    });
});