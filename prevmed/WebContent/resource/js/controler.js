(function($) {
  AddTableRow = function() {

    var newRow = $('<tr>');
    var cols = "";

    cols += '<td><span class="check"><input type="checkbox" class="checked"></span> &nbsp;&nbsp;1</td>';
    cols += '<td><a href="#">2015.1</a></td>';
    cols += '<td  class="btn_status"><button class="btn btn-success btn-xs" id="btn_check"><i class="fa fa-check" id="i_status"></i><span class="ui-button-text"> ativado</span></button></td>';
    cols += '<td>';
    cols += '<button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#editarModal" id="editar"><i class="fa fa-pencil"></i> editar</button> ';
    cols += '<button onclick="RemoveTableRow(this)" class="btn btn-danger btn-xs" type="button"><i class="fa fa-times-circle"></i> remover</button>';
    cols += '</td>';

    newRow.append(cols);
    $("#tabela-prova").append(newRow);

    return false;
  };
})(jQuery);


(function($) {

	  RemoveTableRow = function(handler) {
	    var tr = $(handler).closest('tr');

	    tr.fadeOut(300, function(){ 
	      tr.remove(); 
	    }); 

	    return false;
	  };
	})(jQuery);

(function($) {
	  AddLinhaArea = function() {

	    var newRow = $('<tr>');
	    var cols = "";

	    cols += '<td><span class="check"><input type="checkbox" class="checked"></span> &nbsp;&nbsp;1</td>';
	    cols += '<td><a href="#">Dire��o</a></td>';
	    cols += '<td  class="btn_status"><button class="btn btn-success btn-xs" id="btn_check"><i class="fa fa-check" id="i_status"></i><span class="ui-button-text"> ativado</span></button></td>';
	    cols += '<td>';
	    cols += '<button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#editarModal" id="editar"><i class="fa fa-pencil"></i> editar</button> ';
	    cols += '<button onclick="RemoveTableRow(this)" class="btn btn-danger btn-xs" type="button"><i class="fa fa-times-circle"></i> remover</button>';
	    cols += '</td>';

	    newRow.append(cols);
	    $("#tabela-area").append(newRow);

	    return false;
	  };
	})(jQuery);

(function($) {
	  AddLinhaQuestao = function() {

	    var newRow = $('<tr>');
	    var cols = "";

	    cols += '<td><span class="check"><input type="checkbox" class="checked"></span> &nbsp;&nbsp;1</td>';
	    cols += '<td><a href="#">enunciado questão</a></td>';
	    cols += '<td  class="btn_status"><button class="btn btn-success btn-xs" id="btn_check"><i class="fa fa-check" id="i_status"></i><span class="ui-button-text"> ativado</span></button></td>';
	    cols += '<td>';
	    cols += '<button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#editarModal" id="editar"><i class="fa fa-pencil"></i> editar</button> ';
	    cols += '<button onclick="RemoveTableRow(this)" class="btn btn-danger btn-xs" type="button"><i class="fa fa-times-circle"></i> remover</button>';
	    cols += '</td>';

	    newRow.append(cols);
	    $("#tabela-questao").append(newRow);

	    return false;
	  };
	})(jQuery);

