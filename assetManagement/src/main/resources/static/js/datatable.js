//$(document).ready( function () {
//	 var table = $('#requestTable').DataTable({
//			"sAjaxSource": "/requests/list",
//			"sAjaxDataProp": "",
//			"order": [[ 0, "asc" ]],
//			"aoColumns": [
//			      { "mData": "id"},
//		          { "mData": "requesttype" },
//				  { "mData": "requestsubtype" },
//				  { "mData": "requestdescription" },
//				  { "mData": "requestemployee_id" },
//				  { "mData": "requestfirstname" }
//			]
//	 })
//});



$(document).ready(function() {
    $('#requestTable').DataTable( {
        initComplete: function () {
            this.api().columns().every( function () {
                var column = this;
                var select = $('<select><option value=""></option></select>')
                    .appendTo( $(column.footer()).empty() )
                    .on( 'change', function () {
                        var val = $.fn.dataTable.util.escapeRegex(
                            $(this).val()
                        );
 
                        column
                            .search( val ? '^'+val+'$' : '', true, false )
                            .draw();
                    } );
 
                column.data().unique().sort().each( function ( d, j ) {
                    select.append( '<option value="'+d+'">'+d+'</option>' )
                } );
            } );
        }
    } );
} );