$(document).ready(function(){

	
//	$("tr").bind("keypress", function(event){
//		if(event.keyCode == 13){
//			addRows();
//		}
//
//	});
	$('#Quantity').bind("keyup", function(){
		$('#TotalAmt').val( $(this).val() * $('#PurchasePrice').val());
	});


	$("#addRow").bind('click', addRows);
	function addRows(e){
		try{

			var $itemsTable = $('#itemsTable');

			var $rowTemp = [
			                '<tr class="item-row">',
			                '<td><a id="deleteRow"><img src="images/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
			                '<td ><input type="text" name="brand"  value=""  class="validate[required]"  id="brand" /> </td>',
			                '<td><input type="text" name="product" class="validate[required]" value="" id="product"   /></td>',

			                '</tr>'
			                ].join('');
			var $row = $($rowTemp);
			$.currentRow = $row;
//			$.currentRow.find('#ItemName').val('value');
			// save reference to inputs within row
			var $brand 	        = $row.find('#brand');
			var $product	    = $row.find('#product');
			
			
			$last = $('#itemsTable').find('tbody tr:last');
			$.first = $last.find('input:first');
			if ( $.first.val() !== '' ) {
				
				
				$brand.autocomplete("GoogleSearch/Brand_Distributor_Master.jsp");
				  
				$product.autocomplete("GoogleSearch/Product_Distributor_Master.jsp");

//				$row.bind("keypress", function(event){
//					if(event.keyCode == 13){
//						addRows();
//					}
//
//				});

				// Add row after the first row in table

				$('.item-row:last', $itemsTable).after($row);
				
			} // End if last ItemName input is empty
		}catch(err){
			alert(err);
		}
		return false;
	}


//	$('#ItemName').focus(function(){
//	window.onbeforeunload = function(){
//	return "You haven't saved your data.  Are you sure you want to leave this page without saving first?";
//	};
//	});

}); // End DOM

//Remove row when clicked
$("#deleteRow").live('click',function(){
	$(this).parents('.item-row').remove();
	// Hide delete Icon if we only have one row in the list.
	if ($(".item-row").length < 2) $("#deleteRow").hide();
});
