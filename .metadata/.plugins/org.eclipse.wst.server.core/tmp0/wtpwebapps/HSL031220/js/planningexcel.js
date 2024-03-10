$(document).ready(function(){
        alert("ss");
         
          
          
          

          $("#addRow").bind('click', addRows);

          
          function addRows(e){
                    try{
                    	
                              var $itemsTable = $('#itemsTable');

                              var $rowTemp = [
                              '<tr class="item-row">',
                              '<td><a id="deleteRow"><img src="images/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                              '<td><input type="text" name="modelcode"  value=""  class="validate[required]"  id="modelcode"  style="width: 400px;"/> </td>',
                              '<td><input type="text" name="quntity" class="validate[required,custom[integer]]" value="" id="quntity"  style="width: 400px;"  /></td>',
                             
                              
                              
                              '</tr>'
                              ].join('');
                              var $row = $($rowTemp);
                              $.currentRow = $row;
//                              $.currentRow.find('#ItemName').val('value');
                              // save reference to inputs within row
                             
                            
                              var $rate 			 = $row.find('#rate');
                              
                              $last = $('#itemsTable').find('tbody tr:last');
                              $.first = $last.find('input:first');
                              if ( $.first.val() !== '' ) {
                                        
                            	
                                   
                            	  $($rate).bind("keyup", function(){
                                	  totalAmountCalculation();
                                  });

                                       
                                        // Add row after the first row in table
                                       
                                        $('.item-row:last', $itemsTable).after($row);
                                       // $($sub_product).focus();
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
