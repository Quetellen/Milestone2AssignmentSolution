/**
 * Confirmacao de exclusao
 */

function confirmp(p_id) {
	let answer = confirm("Delete this participant?")
	if (answer === true) {
		//alert(p_id)
		window.location.href = "deletep?p_id=" + p_id
	}

}