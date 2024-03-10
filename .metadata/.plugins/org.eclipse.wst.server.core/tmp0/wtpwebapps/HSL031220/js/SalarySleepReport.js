$(document).ready(function(){

	try{
		$(document).find('#salary  tr td').each(function(i, row){
	$(row).css({ border:"0"});
	});
	
		
	}catch(err){alert(err);}
});