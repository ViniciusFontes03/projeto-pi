$(document).ready(function(){
	
	var options =  {
		  onComplete: function(cep) {

			  $.ajax({
				  url:"/enderecos/cep",
				  data:"cep="+cep,
				  dataType:"json",
				  type:"POST",
				  success:function(data){
					  
					  $('#logradouro').val(data.logradouro);
					  $('#bairro').val(data.bairro.nome);
					  $('#cidade').val(data.bairro.cidade.nome);
					  $('#uf').val(data.bairro.cidade.uf);
				  }
			  });
		  }
	}
			  
	
	$('.cep').mask('00000-000', options);
	
	
	
	$('#cidade').typeahead({
        source: function (query, result) {
        	
        	uf = $("#uf").val();
        	
            $.ajax({
                url: "/enderecos/cidade",
				data: 'query=' + query + '&uf=' + uf,            
                dataType: "json",
                type: "POST",
                success: function (data) {
					result($.map(data, function (item) {
						return item.nome;
                    }));
                }
            });
        }
    });
	
	
	$('#bairro').typeahead({
        source: function (query, result) {
        	
        	cidade = $("#cidade").val();
        	uf = $("#uf").val();
        	
            $.ajax({
                url: "/enderecos/bairro",
				data: 'query=' + query + '&cidade=' + cidade + "&uf="+uf,            
                dataType: "json",
                type: "POST",
                success: function (data) {
					result($.map(data, function (item) {
						return item;
                    }));
                }
            });
        }
    });
});