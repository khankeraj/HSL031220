$(document).ready(function(){
          $("#addRowSpare").bind('click', addRows);
 function addRows(e){
                    try{
                    	
                              var $itemsTable = $('#itemsTableSpare');
                              var $rowTemp = [
                              '<tr class="item-row">',
                            
                              '<td><a id="deleteRow"><img src="Images_4_design/AddRowDataTable/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                              
                            
                             '<td><input type="text" name="prb.material_type_spare" value="spare" readonly="readonly" class="validate[required]"  id="material_type_spare" /></td>',
                             '<td><input type="text" name="prb.spare_code" id="spare_code" /></td>', 
                             '<td><input type="text" name="prb.qtyspare" onblur="allnumeric(this);" id="qtyspare" /></td>', 
                             '<td><input type="text" name="prb.from_company_names"   class="validate[required]" id="from_company_names" /></td>',
                              '</tr>'
                              ].join('');
                              var $row = $($rowTemp);
                              $.currentRow = $row;
                             
                              var $row = $($rowTemp);
                              $.currentRow = $row;                                                                       
                              $last = $('#itemsTable').find('tbody tr:last');
                              $.first = $last.find('input:first');
                              if (true ) {                       	                                                   	          
                         	$('.item-row:last', $itemsTable).after($row);                    	                     
                              }// End if last ItemName input is empty
                              else
                       		 {
                       		 $('.item-row:last', $itemsTable).after($row);                  		                    	      
                       		 }
                              $last = $('#itemsTable').find('tbody tr:last');
                              $.first = $last.find('input:first');
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
