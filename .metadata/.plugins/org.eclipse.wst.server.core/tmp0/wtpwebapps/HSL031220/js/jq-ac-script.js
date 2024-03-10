$(document).ready(function(){
        
         
          $("tr").bind("keypress", function(event){
                    /*if(event.keyCode == 13){
                              addRows();
                    }*/

          });
          $('#Quantity').bind("keyup", function(){
                    $('#TotalAmt').val( $(this).val() * $('#PurchasePrice').val());
          });

          $('#PurchasePrice').bind("keyup", function(){
                    $('#TotalAmt').val( $(this).val() * $('#Quantity').val());
          });


          $("#addRow").bind('click', addRows);



          function addRows(e){
                    try{
                    	
                              var $itemsTable = $('#itemsTable');

                              var $rowTemp = [
                              '<tr class="item-row">',
                              '<td><a id="deleteRow"><img src="images/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                              '<td><input type="text" name="sub_product"  value=""  class="validate[required]"  id="sub_product"  style="width: 250px;"/> </td>',
                              '<td><input type="text" name="warranty" class="validate[required,custom[integer]]" value="" id="warranty"  style="width: 250px;"  /></td>',
                              
                              '</tr>'
                              ].join('');
                              var $row = $($rowTemp);
                              $.currentRow = $row;
//                              $.currentRow.find('#ItemName').val('value');
                              // save reference to inputs within row
                              var $sub_product 	        = $row.find('#sub_product');
                              var $warranty	        = $row.find('#warranty');
                         
                              $last = $('#itemsTable').find('tbody tr:last');
                              $.first = $last.find('input:first');
                              if ( $.first.val() !== '' ) {
                                        // Add row after the first row in table
                                       
                                        $('.item-row:last', $itemsTable).after($row);
                                        $($sub_product).focus();
                              } // End if last ItemName input is empty
                    }catch(err){
                              alert(err);
                    }
                    return false;
          }


//          $('#ItemName').focus(function(){
//                    window.onbeforeunload = function(){
//                              return "You haven't saved your data.  Are you sure you want to leave this page without saving first?";
//                    };
//          });

}); // End DOM

// Remove row when clicked
$("#deleteRow").live('click',function(){
          $(this).parents('.item-row').remove();
          // Hide delete Icon if we only have one row in the list.
          if ($(".item-row").length < 2) $("#deleteRow").hide();
});
